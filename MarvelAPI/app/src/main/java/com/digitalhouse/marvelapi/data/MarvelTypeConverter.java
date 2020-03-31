package com.digitalhouse.marvelapi.data;
import androidx.room.TypeConverter;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.model.ComicsImagem;
import com.digitalhouse.marvelapi.model.ComicsResponse;
import com.digitalhouse.marvelapi.model.Data;
import com.digitalhouse.marvelapi.model.Price;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class MarvelTypeConverter {
    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromJsonObject(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    @TypeConverter
    public List<Comics> fromListComics(String value) {
        Type listType = (Type) new TypeToken<List<Comics>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListComicsObject(List<Comics> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public ComicsImagem fromImagem(String value) {
        Type listType = (Type) new TypeToken<ComicsImagem>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromJsonImagem(ComicsImagem comicsImagem) {
        Gson gson = new Gson();
        return gson.toJson(comicsImagem);
    }

    @TypeConverter
    public List<ComicsResponse> fromListResponse(String value) {
        Type listType = (Type) new TypeToken<List<ComicsResponse>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListResponseObject(List<ComicsResponse> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Data> fromListData(String value) {
        Type listType = (Type) new TypeToken<List<Data>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListDataObject(List<Data> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Price> fromListPrice(String value) {
        Type listType = (Type) new TypeToken<List<Price>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListPriceObject(List<Price> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


   /* @TypeConverter
    public List<Date> fromListDate(String value) {
        Type listType = (Type) new TypeToken<List<Date>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListDateObject(List<Date> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }*/

  /*  @TypeConverter
    public Date fromDate(String value) {
        Type listType = (Type) new TypeToken<Date>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromJsonDate(Date object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }*/
}
