/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.util;

import com.google.gson.Gson;
import com.weco.nanotech.admin.entity.UserWeco;
import java.math.BigDecimal;

public class Request {

    private String className;
    private String bean;
    private String tipoServicio;
    private UserWeco userWeco;
    private BigDecimal from;
    private BigDecimal to;
        
    public Request() {
    }

    public Request(String className, Object bean, Object logAcceso) {
        this.className = className;
        this.bean = serializeObject(bean);
    }

    public Request(String className, Object bean, Object logAcceso, String pais) {
        this.className = className;
        this.bean = serializeObject(bean);
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public static String serializeObject(Object JSON) {
        Gson gson = new Gson();
        String response = gson.toJson(JSON);
        return response;
    }

    public UserWeco getUserWeco() {
        return userWeco;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public void setTo(BigDecimal to) {
        this.to = to;
    }
    
    
}
