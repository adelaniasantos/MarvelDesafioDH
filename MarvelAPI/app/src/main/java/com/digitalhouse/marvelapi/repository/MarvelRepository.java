package com.digitalhouse.marvelapi.repository;
import android.content.Context;
import com.digitalhouse.marvelapi.data.MarvelDAO;
import com.digitalhouse.marvelapi.data.MarvelDataBase;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.util.Util;
import java.util.List;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import static com.digitalhouse.marvelapi.data.network.RetrofitService.getApiService;
import static com.digitalhouse.marvelapi.util.Util.PRIVATE_KEY;
import static com.digitalhouse.marvelapi.util.Util.PUBLIC_KEY;
import static com.digitalhouse.marvelapi.util.Util.TS;

public class MarvelRepository {
    String hash = Util.md5(TS + PRIVATE_KEY + PUBLIC_KEY );

    public Observable<ComicsResponse> getComics(Integer offset){
        return getApiService().getComics("magazine" , "comic" , true , "focDate" , TS, hash, PUBLIC_KEY, offset);
    }

    public Flowable<List<Comics>> retornaComicsBD(Context context) {
        return MarvelDataBase.getDatabase(context).marvelDAO().recuperaComicsDoBD();
    }

    public void insereComicsBd(List<Comics> comicsList, Context context){
        MarvelDataBase.getDatabase(context).marvelDAO().insereListaComicsBD(comicsList);
    }

    public void apagaOsDadosBD(ComicsResponse comicsResponse, Context context) {
        MarvelDataBase.getDatabase(context).marvelDAO().apagaDadosBd(comicsResponse);
    }
}