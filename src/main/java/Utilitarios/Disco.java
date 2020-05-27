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
    
/**
 * 
 * @param artista
 * @param nombre
 * @param formato 
 */
    public Disco( String artista,String nombre, String formato) {
        
        this.nombre = nombre;
        this.artista = artista;
        this.formato=formato;
        
    }

  
/**
 * 
 * @return 
 */
    public String getFormato() {
        return formato;
    }
/**
 * 
 * @param formato 
 */
    public void setFormato(String formato) {
        this.formato = formato;
    }
/**
 * 
 * @return 
 */
    public String getImagen() {
        return imagen;
    }
/**
 * 
 * @param imagen 
 */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
/**
 * 
 * @return 
 */
    public String getNombre() {
        return nombre;
    }
/**
 * 
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * 
 * @return 
 */
    public String getArtista() {
        return artista;
    }
/**
 * 
 * @param artista 
 */
    public void setArtista(String artista) {
        this.artista = artista;
    }    
}
