package es.daw.simpson.util;

import es.daw.simpson.model.Personaje;

public class Utils {

    public static int leerEntero(String nombreCampo, String valor){
        if(valor==null || valor.isBlank()){
            return 0; //en Observacion
        }
              int numero =Integer.parseInt(valor.strip());
    }
}
