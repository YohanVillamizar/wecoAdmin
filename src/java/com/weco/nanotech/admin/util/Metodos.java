package com.weco.nanotech.admin.util;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Metodos {

    public Metodos() {
    }
//-------------------------------------------------------------------------------

    public static String formatearSimple(String frase) {
        return frase.toLowerCase().trim();
    }
//-------------------------------------------------------------------------------

    public static Object Superformatear(Object objeto, String accion) throws IllegalAccessException, ParseException {

        for (Field field : objeto.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(objeto);

            if (field.get(objeto) != null && field.getType().isAssignableFrom(String.class)) {
                set(objeto, field.getName(), value.toString().toLowerCase().trim());
            }

            if ("crear".equals(accion)) {
                if ("fecharegistro".equals(field.getName()) || "fechamodificacion".equals(field.getName()) || "fechamodificaciones".equals(field.getName())) {
                    Date date = new Date();
                    set(objeto, field.getName(), date);
                }
            }
            if ("modificar".equals(accion)) {
                if ("fechamodificacion".equals(field.getName()) || "fechamodificaciones".equals(field.getName())) //insercion   
                {
                    Date date = new Date();
                    set(objeto, field.getName(), date);
                }
            }

        }
        return objeto;
    }

    public static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    //-------------------------------------------------------------------------------
    //creo que podria mejorar utilizando count con nativequery
//    public static boolean verificarLista(Object o, int tipo) {
//
//        if (tipo == 0) {
//            List<Estado> lista = (List<Estado>) o;
//            //eT=elemento Traido
//            for (Estado eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 1) {
//            List<Ciudad> lista = (List<Ciudad>) o;
//            //eT=elemento Traido
//            for (Ciudad eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 2) {
//            List<Localidad> lista = (List<Localidad>) o;
//            //eT=elemento Traido
//            for (Localidad eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 3) {
//            List<Serviciolocalidad> lista = (List<Serviciolocalidad>) o;
//            //eT=elemento Traido
//            for (Serviciolocalidad eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 4) {
//            List<Operardorhoralocalidad> lista = (List<Operardorhoralocalidad>) o;
//            //eT=elemento Traido
//            for (Operardorhoralocalidad eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 5) {
//            List<Politicasserviciotpusuario> lista = (List<Politicasserviciotpusuario>) o;
//            //eT=elemento Traido
//            for (Politicasserviciotpusuario eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 6) {
//            List<Ticket> lista = (List<Ticket>) o;
//            //eT=elemento Traido
//            for (Ticket eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 7) {
//            List<Operadorhorario> lista = (List<Operadorhorario>) o;
//            //eT=elemento Traido
//            for (Operadorhorario eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 8) {
//            List<Operhoralocalserv> lista = (List<Operhoralocalserv>) o;
//            //eT=elemento Traido
//            for (Operhoralocalserv eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 9) {
//            List<Cola> lista = (List<Cola>) o;
//            //eT=elemento Traido
//            for (Cola eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 10) {
//            List<Atencion> lista = (List<Atencion>) o;
//            //eT=elemento Traido
//            for (Atencion eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        } else if (tipo == 11) {
//            List<Grupocolas> lista = (List<Grupocolas>) o;
//            //eT=elemento Traido
//            for (Grupocolas eT : lista) {
//                if (eT.getEstatus().toString().equals("1")) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    //------------------------ verificar conexion a la DB
    public static boolean conexion() throws SQLException {

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "QPangea", "QPangea");

            try (Statement stmt = conn.createStatement()) {
                ResultSet rset
                        = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
                while (rset.next()) {

                }
                return true;
            }
        } catch (SQLException sQLException) {
            System.out.println("erro: " + sQLException.getMessage());
            return false;
        }
    }
}
