/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.facade;

import com.google.gson.Gson;
import com.weco.nanotech.admin.entity.UserWeco;
import com.weco.nanotech.admin.util.Constants;
import com.weco.nanotech.admin.util.Consults;
import com.weco.nanotech.admin.util.Header;
import com.weco.nanotech.admin.util.Metodos;
import com.weco.nanotech.admin.util.Request;
import com.weco.nanotech.admin.util.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author YohanVillamizar
 */
@Stateless
public class UserWecoFacade extends AbstractFacade<UserWeco> {

    @PersistenceContext(unitName = "WecoRestPU")
    private EntityManager em;
    private Logger logger;
    private Consults query;
    private Response responseWC;
    private Gson gson = new Gson();
    private Metodos metodo;
    private Map resultado;
    private Header respuesta;
    private boolean encontrado;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserWecoFacade() {
        super(UserWeco.class);
        logger = Logger.getLogger(UserWecoFacade.class);
        query = new Consults();
        responseWC = new Response();
        metodo = new Metodos();
        boolean encontrado = false;
    }

    public Response sigIn(UserWeco userWeco) {
        logger.info("Inside ");

        resultado = new HashMap();
        respuesta = new Header();

        userWeco.setEmail(metodo.formatearSimple(userWeco.getLogin()));
        logger.info("Correo: " + userWeco.getEmail());

        List<UserWeco> listaUsuario = getUserWecoByEmail(userWeco.getEmail());

        if (!(listaUsuario == null || listaUsuario.size() == 0)) {

            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            for (Object user : listaUsuario) {
                Object[] dataUser = (Object[]) user;
                String password = (String) dataUser[13];
                String idRol = ((BigDecimal) dataUser[1]).toBigInteger().toString();
//                if (idRol.equals(userWeco.getIdRol())) {
                if (password.equals(userWeco.getPassword())) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("idUser", ((BigDecimal) dataUser[0]).toBigInteger().toString());
                    map.put("idRol", ((BigDecimal) dataUser[1]).toBigInteger().toString());
                    map.put("idLocation", ((BigDecimal) dataUser[2]).toBigInteger().toString());
                    map.put("name", (String) dataUser[3]);
                    map.put("lastname", (String) dataUser[4]);
                    map.put("birthday", ((Date) dataUser[5]).toString());
                    map.put("dni", (String) dataUser[6]);
                    map.put("address", (String) dataUser[7]);
                    map.put("email", (String) dataUser[8]);
                    map.put("licenceNumber", ((BigDecimal) dataUser[9]).toBigInteger().toString());
                    map.put("gender", (String) dataUser[10]);
                    map.put("dateStart", ((Date) dataUser[14]).toString());
                    map.put("dateRegister", ((Date) dataUser[15]).toString());
                    map.put("calification", ((BigDecimal) dataUser[16]).toBigInteger().toString());
                    map.put("photo", (String) dataUser[17]);
                    map.put("estatus", (String) dataUser[18]);

                    list.add(map);
                    encontrado = true;
                } else {
                    logger.info(new Date() + Constants.DESCRIPCION_PASSWORD_INVALIDO);
                    respuesta.setCodigo(Constants.CODIGO_PASSWORD_INVALIDO);
                    respuesta.setDescripcion(Constants.DESCRIPCION_PASSWORD_INVALIDO);
                    resultado.put(Constants.DESCRIPCION_PASSWORD_INVALIDO, "Datos no encontrados");
                }
//                } else {
//                    logger.info(new Date() + Constants.DESCRIPCION_USER_NO_ENCONTRADO);
//                    respuesta.setCodigo(Constants.CODIGO_USER_NO_ENCONTRADO);
//                    respuesta.setDescripcion(Constants.DESCRIPCION_USER_NO_ENCONTRADO);
//                    resultado.put(Constants.DESCRIPCION_USER_NO_ENCONTRADO, "Datos no encontrados");
//                }
            }
            if (encontrado) {
                resultado.put("UserWeco", gson.toJson(list));
                encontrado = false;
            }

        } else {
            logger.info(new Date() + Constants.DESCRIPCION_USER_NO_ENCONTRADO);
            respuesta.setCodigo(Constants.CODIGO_USER_NO_ENCONTRADO);
            respuesta.setDescripcion(Constants.DESCRIPCION_USER_NO_ENCONTRADO);
            resultado.put(Constants.DESCRIPCION_USER_NO_ENCONTRADO, "Datos no encontrados");
        }
        responseWC.setRespuesta(respuesta);
        responseWC.setResultado(resultado);
        return responseWC;
    }

    private List<UserWeco> getUserWecoByEmail(String email) {
        String consulta = this.query.getUserByLogin(email);
        logger.info("Consult: " + consulta);
        List<UserWeco> listaUserWeco;
        listaUserWeco = em.createNativeQuery(consulta).getResultList();
        logger.info("Usuario encontrado con exito");
        return listaUserWeco;
    }

    public Response findRangeByRol(Request requestWc) {
        logger.info("Inside ");

        resultado = new HashMap();
        respuesta = new Header();

        List<UserWeco> listaUsuario = getRangeUserWecoByRol(requestWc.getUserWeco().getIdRol().getIdRol(), requestWc.getFrom(), requestWc.getTo());

        if (!(listaUsuario == null || listaUsuario.size() == 0)) {

            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            for (Object user : listaUsuario) {
                Object[] dataUser = (Object[]) user;

                Map<String, String> map = new HashMap<String, String>();
                map.put("idUser", ((BigDecimal) dataUser[0]).toBigInteger().toString());
                map.put("idRol", ((BigDecimal) dataUser[1]).toBigInteger().toString());
                map.put("idLocation", ((BigDecimal) dataUser[2]).toBigInteger().toString());
                map.put("name", (String) dataUser[3]);
                map.put("lastname", (String) dataUser[4]);
                map.put("birthday", ((Date) dataUser[5]).toString());
                map.put("dni", (String) dataUser[6]);
                map.put("address", (String) dataUser[7]);
                map.put("email", (String) dataUser[8]);
                map.put("licenceNumber", ((BigDecimal) dataUser[9]).toBigInteger().toString());
                map.put("gender", (String) dataUser[10]);
                map.put("phoneNumber", (String) dataUser[11]);
                map.put("dateStart", ((Date) dataUser[14]).toString());
                map.put("dateRegister", ((Date) dataUser[15]).toString());
                map.put("calification", ((BigDecimal) dataUser[16]).toBigInteger().toString());
                map.put("photo", (String) dataUser[17]);
                map.put("estatus", (String) dataUser[18]);

                list.add(map);
                encontrado = true;
            }
            if (encontrado) {
                resultado.put("UserWeco", gson.toJson(list));
                encontrado = false;
            }
        } else {
            logger.info(new Date() + Constants.DESCRIPCION_USERS_NO_ENCONTRADO);
            respuesta.setCodigo(Constants.CODIGO_USERS_NO_ENCONTRADO);
            respuesta.setDescripcion(Constants.DESCRIPCION_USERS_NO_ENCONTRADO);
            resultado.put(Constants.DESCRIPCION_USERS_NO_ENCONTRADO, "Datos no encontrados");
        }
        responseWC.setRespuesta(respuesta);
        responseWC.setResultado(resultado);
        return responseWC;
    }

    private List<UserWeco> getRangeUserWecoByRol(BigDecimal idRol, BigDecimal from, BigDecimal to) {
        String consulta = this.query.getRangeUserWecoByRol(idRol, from, to);
        logger.info("Consult: " + consulta);
        List<UserWeco> listaUserWeco;
        listaUserWeco = em.createNativeQuery(consulta).getResultList();
        logger.info("Usuarios encontrados con exito");
        return listaUserWeco;
    }

}
