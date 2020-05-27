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
 * @author adriana
 */
public class LogicaLogin {
    private String usuario, clave, redirecciona;
    private Admin admin;

    public LogicaLogin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRedirecciona() {
        return redirecciona;
    }

    public void setRedirecciona(String redirecciona) {
        this.redirecciona = redirecciona;
    }
    
}
