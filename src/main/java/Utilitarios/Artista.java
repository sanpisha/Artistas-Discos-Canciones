/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Santiago Gómez
 */
public class Artista implements Serializable{
    private String nombre;
    private String apellido;
    private Date fechana;
    

    public Artista(String nombre, String apellido, Date fechana) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechana = fechana;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechana() {
        return fechana;
    }

    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }

   
}
