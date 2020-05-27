/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Santiago Gómez
 */
@ManagedBean(name="errorHandler")
@RequestScoped
public class ErrorHandler {

    /**
     * Constructos
     */
    public ErrorHandler() {
    }
    /**
     * Devuelve el tipo de error que se generó al acceder a la página
     * @return 
     */
    public String getStatusCode() {
        String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.status_code"));
        return val;
    }    
    /**
     * obtiene el mensaje que se generó en el error
     * @return 
     */
    public String getMessage() {
        String val = (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.message");
        return val;
    }    
    /**
     * Obtiene el error
     * @return 
     */
    public String getRequestURI() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.request_uri");
    }    
    /**
     * obtiene el tipo de error
     * @return 
     */
    public String getServletName() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.servlet_name");
    }    
    
    
}
