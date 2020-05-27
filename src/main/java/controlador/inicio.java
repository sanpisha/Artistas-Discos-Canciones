/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


/**
 *
 * @author Santiago Gómez
 */

@ManagedBean(name = "inicio")
@RequestScoped
public class inicio implements Serializable{

    private String nombre;

    /**
     * Creates a new instance of inicio
     */
    public inicio() {
    }
    

    public String iniciaSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", nombre);
        return "vistaCompra.xhtml";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
