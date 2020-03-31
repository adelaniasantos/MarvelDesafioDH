package com.digitalhouse.marvelapi.viewmodel;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.repository.MarvelRepository;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.digitalhouse.marvelapi.util.Util.verificaConexaoComInternet;

public class MarvelViewModel extends AndroidViewModel {
    private MutableLiveData<List<Comics>> listaComics = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MarvelRepository repository = new MarvelRepository();

    public MarvelViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Comics>> getListaComics() {
        return this.listaComics;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    private MutableLiveData<String> mutableLiveDataErro = new MutableLiveData<>();
    public LiveData<String> liveDataErro = mutableLiveDataErro;

    public void getComics(Integer offset) {
        if (verificaConexaoComInternet(getApplication())) {
            recuperaOsDadosApi(offset);
        } else {
            carregaDadosBD();
        }
    }

    public void recuperaOsDadosApi(Integer offset) {
        disposable.add(
                repository.getComics(offset)
                        .map(this::insereDadosBd)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(comicsResponse -> listaComics.setValue(comicsResponse.getData().getResults()),
                                throwable -> {
                                    mutableLiveDataErro.setValue(throwable.getMessage());
                                    carregaDadosBD();
                                })
        );
    }

    private void carregaDadosBD() {
        disposable.add(
                repository.retornaComicsBD(getApplication())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> loading.setValue(true))
                        .doAfterTerminate(() -> loading.setValue(false))
                        .subscribe(albumList ->
                                        listaComics.setValue(albumList),
                                throwable ->
                                        mutableLiveDataErro.setValue(throwable.getMessage() + "problema banco de dados"))
        );
    }

    private ComicsResponse insereDadosBd(ComicsResponse comicsResponse) {
        repository.apagaOsDadosBD(comicsResponse, getApplication());
        repository.insereComicsBd(comicsResponse.getData().getResults(), getApplication());
        return comicsResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}