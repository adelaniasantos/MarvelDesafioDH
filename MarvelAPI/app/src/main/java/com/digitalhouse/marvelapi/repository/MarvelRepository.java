package com.digitalhouse.marvelapi.repository;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.util.Util;
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
}