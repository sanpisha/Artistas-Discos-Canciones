/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.faces.context.FacesContext;
import Utilitarios.Admin;

/**
 *
 * @author Santiago Gómez
 */
public class LogicaLogin {
    private String usuario, clave, redirecciona;
    private Admin admin;
/**
 * 
 * @param usuario
 * @param clave 
 */
    public LogicaLogin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    /**
     * Creación de la sesión del usuario admin
     */
    public void loguearse(){
        //LecturaFichero();
        FacesContext context = FacesContext.getCurrentInstance();
        Admin adm = (Admin) context.getExternalContext().getSessionMap().get("admin");
        if(adm.getUsuario().equals(usuario) && adm.getClave().equals(clave)){
            this.setRedirecciona("crudArtista.xhtml");
        }
        else{
            this.setRedirecciona("404.xhtml");
        }
    }
/**
 * 
 * @return 
 */
    public Admin getAdmin() {
        return admin;
    }
/**
 * 
 * @param admin 
 */
    public void setAdmin(Admin admin) {
        this.admin = admin;
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
/**
 * 
 * @return 
 */
    public String getRedirecciona() {
        return redirecciona;
    }
/**
 * 
 * @param redirecciona 
 */
    public void setRedirecciona(String redirecciona) {
        this.redirecciona = redirecciona;
    }
    
}
