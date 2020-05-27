/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Utilitarios.Artista;
import Utilitarios.Cancion;
import Utilitarios.Disco;
//import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Santiago Gómez
 */

@ManagedBean(name = "vistaCompra")
@ViewScoped
public class vistaCompra implements Serializable{

    private String usuario;
    private List<Cancion> listaCanciones;
    private List<Disco> listaDiscos;
    private List<Artista> listaArtistas;
    private List<String> nombreCanciones, nombreDiscos, nombreArtistas;
    private List<Cancion> compra;
    private double total;

    /**
     * Creates a new instance of vistaCompra
     */
    public vistaCompra() {
    }
/**
 * inyecta la lista de canciones el nombre de las canciones, los discos y los artistas
 */
    @PostConstruct
    public void init() {
        compra = new ArrayList<>();
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().getSessionMap().get("listaCanciones") == null) {
            listaCanciones = new ArrayList<>();
        } else {
            listaCanciones = (List<Cancion>) context.getExternalContext().getSessionMap().get("listaCanciones");
            nombreCanciones= new ArrayList<>();
            for (Cancion ca : listaCanciones) {
                nombreCanciones.add(ca.getNombre());
            }
        }
        if (context.getExternalContext().getSessionMap().get("listaDiscos") == null) {
            listaDiscos = new ArrayList<>();
        } else {
            listaDiscos = (List<Disco>) context.getExternalContext().getSessionMap().get("listaDiscos");
            nombreDiscos = new ArrayList<>();
            for (Disco di : listaDiscos) {
                nombreDiscos.add(di.getNombre());
            }
        }
        if (context.getExternalContext().getSessionMap().get("listaArtista") == null) {
            listaArtistas = new ArrayList<>();
        } else {
            listaArtistas = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
            nombreArtistas = new ArrayList<>();
            for (Artista ar : listaArtistas) {
                nombreArtistas.add(ar.getNombre());
            }
        }
        usuario = (String) context.getExternalContext().getSessionMap().get("usuario");
    }
/**
 * 
 * @param cancion 
 */
    public void agregarCarritoPorDisco(Cancion cancion) {
      
          
    }
    /**
     * 
     * @param disco 
     */
    public void compra(Disco disco){
        
    }    
   
/**
 * 
 * @param cancion 
 */
    public void agregarCarritoPorCancion(Cancion cancion) {
       
    }
/**
 * 
 */
    public void finalizarCompra() {
      
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
    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }
/**
 * 
 * @param listaDiscos 
 */
    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
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
    public List<String> getNombreCanciones() {
        return nombreCanciones;
    }
/**
 * 
 * @param nombreCanciones 
 */
    public void setNombreCanciones(List<String> nombreCanciones) {
        this.nombreCanciones = nombreCanciones;
    }
/**
 * 
 * @return 
 */
    public List<String> getNombreDiscos() {
        return nombreDiscos;
    }
/**
 * 
 * @param nombreDiscos 
 */
    public void setNombreDiscos(List<String> nombreDiscos) {
        this.nombreDiscos = nombreDiscos;
    }
/**
 * 
 * @return 
 */
    public List<String> getNombreArtistas() {
        return nombreArtistas;
    }
/**
 * 
 * @param nombreArtistas 
 */
    public void setNombreArtistas(List<String> nombreArtistas) {
        this.nombreArtistas = nombreArtistas;
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
