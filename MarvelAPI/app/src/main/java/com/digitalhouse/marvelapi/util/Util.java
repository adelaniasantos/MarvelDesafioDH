package com.digitalhouse.marvelapi.util;

public class Util {
    public static boolean usuarioValido (String usuario){
        return (usuario.contains("@") && usuario.contains(".com") );
    }

    public static boolean isEmptyString (String valor){
        return valor == null || valor.trim().equals("");
    }

    public static boolean senhaValida(String senha) {
        if (senha.length() < 6) {
            return false;
        }else
            return true;
    }
}
