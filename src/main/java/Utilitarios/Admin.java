/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.Serializable;

/**
 *
 * @author Santiago Gómez
 * Pojo del administrador del sistema
 */

public class Admin implements Serializable {

    private String usuario, clave;
    /**
     * 
     * @param usuario
     * @param clave 
     */
    public Admin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    /**
     * 
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * 
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * 
     * @return 
     */
    public String getClave() {
        return clave;
    }
    /**
     * 
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

}
