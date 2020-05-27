/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.List;

/**
 *
 * @author Santiago Gómez
 */
public class Usuario {
    
    private String nombre;
    private List<Cancion> carrito;
/**
 * 
 * @param nombre
 * @param carrito 
 */
    public Usuario(String nombre, List<Cancion> carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
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
    public List<Cancion> getCarrito() {
        return carrito;
    }
/**
 * 
 * @param carrito 
 */
    public void setCarrito(List<Cancion> carrito) {
        this.carrito = carrito;
    }
    
}
