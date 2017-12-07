/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.util;

import java.util.Date;

/**
 *
 * @author ledwin.belen
 */
public class Header extends Constants{
    private String codigo;
    private String descripcion;

    public Header() {
        this.codigo = CODIGO_RESPUESTA_EXITOSO;
        this.descripcion = DESCRIPCION_RESPUESTA_EXITOSO;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescripcion(Date DESCRIPCION_CUSTOMERS_NO_ENCONTRADOS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
