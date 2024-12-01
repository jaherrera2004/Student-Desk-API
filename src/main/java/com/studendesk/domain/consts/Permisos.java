package com.studendesk.domain.consts;


public class Permisos {

    public static String [] permisosEstudiante = {
            "holi"
    };
    public static String [] permisosProfesor = {
            "curso:crear",

    };
    public static String [] permisosAdmin = {
            "holi"
    };

    public static String [] obtenerPermisos(String rol){
        switch (rol){
            case "estudiante":
                return permisosEstudiante;
            case "profesor":
                return permisosProfesor;
            case "admin":
                return permisosAdmin;
            default:
                return null;
        }
    }
}
