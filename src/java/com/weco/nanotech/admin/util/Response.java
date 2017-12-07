/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.util;

import java.util.Map;

/**
 *
 * @author ledwin.belen
 */
public class Response {
    private Header respuesta;
    private Map resultado;

    public Header getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Header respuesta) {
        this.respuesta = respuesta;
    }

    public Map getResultado() {
        return resultado;
    }

    public void setResultado(Map resultado) {
        this.resultado = resultado;
    }
    
}
