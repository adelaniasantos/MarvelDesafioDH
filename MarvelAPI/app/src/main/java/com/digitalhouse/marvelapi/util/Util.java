package com.digitalhouse.marvelapi.util;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";
    public static final String TS = Long.toString (System. currentTimeMillis () / 1000 );
    public static final String COMICS = "Comics";

    public static boolean verificaConexaoComInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    public static String md5(String s) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(s.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public static String ConvertToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fmtReturn = new SimpleDateFormat("MMM dd, yyyy");
        Date convertedDate = new Date();
        String dataReturn = "";

        try {
            convertedDate = dateFormat.parse(dateString);
            dataReturn = fmtReturn.format(convertedDate);

        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
        return dataReturn;
    }

    public static boolean usuarioValido(String usuario) {
        return (usuario.contains("@") && usuario.contains(".com"));
    }

    public static boolean isEmptyString(String valor) {
        return valor == null || valor.trim().equals("");
    }

    public static boolean senhaValida(String senha) {
        if (senha.length() < 6) {
            return false;
        } else
            return true;
    }
}
