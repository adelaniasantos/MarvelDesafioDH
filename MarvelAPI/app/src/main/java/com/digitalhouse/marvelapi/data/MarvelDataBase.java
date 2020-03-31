package com.digitalhouse.marvelapi.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.model.ComicsImagem;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.model.Data;
import com.digitalhouse.marvelapi.model.Price;

@Database(entities = {Comics.class, ComicsResponse.class, ComicsImagem.class, Data.class, Price.class}, version = 2, exportSchema = false)
@TypeConverters(MarvelTypeConverter.class)
public abstract class MarvelDataBase extends RoomDatabase {
    private static volatile MarvelDataBase INSTANCE;
    public abstract MarvelDAO marvelDAO();

    public static MarvelDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (MarvelDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, MarvelDataBase.class, "marvel_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
