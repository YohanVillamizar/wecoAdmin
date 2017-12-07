/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.service;

import com.google.gson.Gson;
import com.weco.nanotech.admin.entity.UserWeco;
import com.weco.nanotech.admin.facade.UserWecoFacade;
import com.weco.nanotech.admin.util.Request;
import com.weco.nanotech.admin.util.Response;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

/**
 *
 * @author YohanVillamizar
 */
@Stateless
@Path("com.weco.nanotech.admin.model.userweco")
public class UserWecoFacadeREST extends AbstractFacade<UserWeco> {

    @PersistenceContext(unitName = "WecoRestPU")
    private EntityManager em;
    private Request requestWC;
    private Response responseWC;
    private Logger logger;

    private final Gson gson;

    @EJB
    private UserWecoFacade userWecoFacade;

    public UserWecoFacadeREST() {
        super(UserWeco.class);
        logger = Logger.getLogger(UserWecoFacadeREST.class);
        requestWC = new Request();
        responseWC = new Response();
        gson = new Gson();
        userWecoFacade = new UserWecoFacade();
    }

    @POST
    @Path("wecoCreate")
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(String parametros) {
        logger.info("Recibiendo parametros " + parametros);

        requestWC = gson.fromJson(parametros, Request.class);
        super.create(requestWC.getUserWeco());
    }

    @PUT
    @Path("wecoEdit/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") BigDecimal id, UserWeco entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("wecoDelete/{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("wecoFind/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserWeco find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Path("wecoList")
    @Produces({MediaType.APPLICATION_JSON})
    public List<UserWeco> findAll() {
        return super.findAll();
    }

    @POST
    @Path("wecoUserFindRange")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(String parametros) {
        logger.info("Recibiendo parametros " + parametros);

        requestWC = gson.fromJson(parametros, Request.class);
        Response response = userWecoFacade.findRangeByRol(requestWC);
        return response;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     * Método para sigIn un usuario en el sistema tanto admin, cliente, partner
     * y tecnico
     *
     * @param {"className":"UserWeco","userWeco":
     * {"login":"freddy.villamizar@gmail.com", "password":"12345"},
     * "tipoServicio":"SignUp"}
     * @return {"respuesta": {"codigo": "000","descripcion": "OK"},"resultado":
     * {"UserWeco": "[{\"birthday\":\"1988-02-03
     * 00:00:00.0\",\"nroBankAccount\":\"5463464636456\",\"idRol\":\"1\",\"address\":\"Av
     * Los
     * ilustres\",\"gender\":\"M\",\"nroDebitCard\":\"54353454325436\",\"nroCreditCard\":\"53252345345235\",\"lastname\":\"Villamizar\",\"idUser\":\"1\",\"phoneNumber\":\"04236547865\",\"estatus\":\"1\",\"name\":\"Freddy\",\"dni\":\"1456456-3\",\"email\":\"freddy.villamizar@gmail.com\"}]"}}
     */
    @POST
    @Path("sigIn")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sigIn(String parametros) {
        logger.info("Recibiendo parametros " + parametros);

        requestWC = gson.fromJson(parametros, Request.class);
        System.out.println("Weco " + requestWC.getUserWeco().getLogin());
        Response user = userWecoFacade.sigIn(requestWC.getUserWeco());
        return user;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
