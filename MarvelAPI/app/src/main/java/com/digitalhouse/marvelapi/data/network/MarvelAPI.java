package com.digitalhouse.marvelapi.data.network;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelAPI {
    @GET( "comics?" )
    Observable<ComicsResponse> getComics(
            @Query ( "format" ) String format,
            @Query ( "formatType" ) String formatType,
            @Query ( "noVariants" ) boolean noVariants,
            @Query ( "orderBy" ) String orderBy,
            @Query ( "ts" ) String ts,
            @Query ( "hash" ) String hash,
            @Query ( "apikey" ) String apikey,
            @Query ( "offset") Integer offset);
}
