package com.digitalhouse.marvelapi.repository;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.util.Util;
import io.reactivex.Observable;
import static com.digitalhouse.marvelapi.data.network.RetrofitService.getApiService;

public class MarvelRepository {
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0" ;
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f" ;
    String ts = Long. toString (System. currentTimeMillis () / 1000 );
    String hash = Util.md5(ts + PRIVATE_KEY + PUBLIC_KEY );

    public Observable<ComicsResponse> getComics(Integer offset){
        return getApiService().getComics("magazine" , "comic" , true , "focDate" , ts, hash, PUBLIC_KEY, offset);
    }
}