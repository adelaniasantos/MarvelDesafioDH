package com.digitalhouse.marvelapi.model;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

//@Entity(tableName = "date")
public class Date /*implements Parcelable */{
/*    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;*/
    @Expose
    private String date;
    @Expose
    private String type;

    public Date() { }

  /*  protected Date(Parcel in) {
        date = in.readString();
        type = in.readString();
    }

    public static final Creator<Date> CREATOR = new Creator<Date>() {
        @Override
        public Date createFromParcel(Parcel in) {
            return new Date(in);
        }

        @Override
        public Date[] newArray(int size) {
            return new Date[size];
        }
    };
*/
/*    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  /*  @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(type);
    }*/
}
