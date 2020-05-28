/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Utilitarios.Artista;
import Utilitarios.Cancion;
import Utilitarios.Disco;
import java.util.List;

/**
 *
 * @author Santiago Gómez
 */
public class Compra {
    private List<Cancion> listaCanciones;
    private List<Disco> listaDiscos;
    private List<Artista> listaArtistas;
    private List<Cancion> compra;
    private double total = 0;
/**
 * 
 * @param listaCanciones
 * @param listaDiscos 
 * @param listaArtistas
 * @param compra 
 */
    public Compra(List<Cancion> listaCanciones, List<Disco> listaDiscos, List<Artista> listaArtistas, List<Cancion> compra) {
        this.listaCanciones = listaCanciones;
        this.listaDiscos = listaDiscos;
        this.listaArtistas = listaArtistas;
        this.compra = compra;
    }

    public Compra() {

    }
  
   
/**
 * Agrega la lista de albumes a una nueva lista
 * @param al 
 */
    public void compraPorAlbum(Disco al) {
       
        for (Disco d : listaDiscos) {
            if (d.getNombre().equals(al.getNombre())) {
                for (Cancion c : listaCanciones) {

                    if (c.getDisco().equals(al.getNombre())) {
                        if(!compra.contains(c)){
                             compra.add(c);
                        }
                       
                    }
                }
            }
        }
    }
/**
 * Agrega a una lista para comprar por canción
 * @param can 
 */
    public void comprarPorCancion(Cancion can) {
       
        for (Cancion c : listaCanciones) {

            if (c.getNombre().equals(can.getNombre())) {
                if(!compra.contains(can)){
                    compra.add(c);
                }
                
            }
        }
    }
    /**
     * Calcula el total de la compra que se realiza
     * @param compra 
     */

    public void finalizarCompra(List<Cancion> compra) {
        for (Cancion c : compra) {
            total += c.getPrecio();
        }
    }
/**
 * 
 * @return 
 */
    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }
/**
 * 
 * @param listaCanciones 
 */
    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
/**
 * 
 * @return 
 */
    public List<Disco> getListaAlbum() {
        return listaDiscos;
    }
/**
 * 
 * @param listaAlbum 
 */
    public void setListaAlbum(List<Disco> listaAlbum) {
        this.listaDiscos = listaAlbum;
    }
/**
 * 
 * @return 
 */
    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }
/**
 * 
 * @param listaArtistas 
 */
    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
/**
 * 
 * @return 
 */
    public List<Cancion> getCompra() {
        return compra;
    }
/**
 * 
 * @param compra 
 */
    public void setCompra(List<Cancion> compra) {
        this.compra = compra;
    }
/**
 * 
 * @return 
 */
    public double getTotal() {
        return total;
    }
/**
 * 
 * @param total 
 */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
