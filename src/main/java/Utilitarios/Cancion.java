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
 */
public class Cancion implements Serializable{
    private String nombre;
    private String duracion;
    private double precio;
    private String disco;
/**
 * 
 * @param nombre
 * @param duracion
 * @param precio
 * @param disco 
 */
    public Cancion(String nombre, String duracion, double precio, String disco) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.disco = disco;
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
    public String getDuracion() {
        return duracion;
    }
/**
 * 
 * @param duracion 
 */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
/**
 * 
 * @return 
 */
    public double getPrecio() {
        return precio;
    }
/**
 * 
 * @param precio 
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
/**
 * 
 * @return 
 */
    public String getDisco() {
        return disco;
    }
/**
 * 
 * @param disco 
 */
    public void setDisco(String disco) {
        this.disco = disco;
    }
    
}
