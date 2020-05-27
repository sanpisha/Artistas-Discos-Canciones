/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Santiago Gómez
 */
public class Disco implements Serializable{
    private String imagen;
    private String nombre;
    private String artista;
    private String formato;
    

    public Disco( String artista,String nombre, String formato) {
        
        this.nombre = nombre;
        this.artista = artista;
        this.formato=formato;
        
    }

  

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }    
}
