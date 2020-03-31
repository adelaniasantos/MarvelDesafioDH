package com.digitalhouse.marvelapi.data;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.model.ComicsResponse;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MarvelDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insereListaComicsBD(List<Comics> listaComics);

    @Query("SELECT * FROM comics")
    Flowable<List<Comics>> recuperaComicsDoBD();

    @Delete
    void apagaDadosBd(ComicsResponse comicsResponse);
}
