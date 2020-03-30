package com.digitalhouse.marvelapi.model;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

public class ComicsImagem implements Parcelable {
    @Expose
    private String extension;
    @Expose
    private String path;

    protected ComicsImagem(Parcel in) {
        extension = in.readString();
        path = in.readString();
    }

    public static final Creator<ComicsImagem> CREATOR = new Creator<ComicsImagem>() {
        @Override
        public ComicsImagem createFromParcel(Parcel in) {
            return new ComicsImagem(in);
        }

        @Override
        public ComicsImagem[] newArray(int size) {
            return new ComicsImagem[size];
        }
    };

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(extension);
        dest.writeString(path);
    }
}
