/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilitarios.Artista;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Utilitarios.Cancion;
import Utilitarios.Disco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Gómez
 */
@ManagedBean(name = "crudCancion")
@RequestScoped
public class CrudCancion implements Serializable {

    private String nombre, duracion, disco;
    private double precio;
    private List<Cancion> listaCanciones;
    private List<Disco> listaDisco;
    private List<String> nombreDiscos;

    /**
     * Constructor de canción
     */
    public CrudCancion() {
        listaCanciones = new ArrayList<>();
    }
/**
 * Post constructor de canción injecta los datos de discos.
 */
    @PostConstruct
    public void init() {
        lectura();
        
         FacesContext context = FacesContext.getCurrentInstance();
         if (context.getExternalContext().getSessionMap().get("listaCanciones") == null) {
         listaCanciones = new ArrayList<>();
         }else{
         listaCanciones = (List<Cancion>) context.getExternalContext().getSessionMap().get("listaCanciones");
         }
         if(context.getExternalContext().getSessionMap().get("listaDiscos") == null){
         listaDisco = new ArrayList<>();
         }else{
         listaDisco = (List<Disco>) context.getExternalContext().getSessionMap().get("listaDiscos");
         nombreDiscos = new ArrayList<>();
         for(Disco d : listaDisco){
         nombreDiscos.add(d.getNombre());
         }
         }
    }
/**
 * Crea y lee el archivo donde se almacenarán las canciones
 */
    public void lectura() {
        try {
            FileInputStream fis = new FileInputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/cancion.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaCanciones = (List<Cancion>) ois.readObject();
            fis.read();
        } catch (Exception ex) {

            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
/**
 * agrega las canciones a la lista de canciones y actualiza el archivo de texto
 */
    public void agregarCancion() {
        Cancion can = new Cancion(nombre, duracion, precio, disco);
        listaCanciones.add(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
        nombre = "";
        duracion = "";
        precio = 0;
        disco = "";
        try {
            FileOutputStream fos = new FileOutputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/cancion.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listaCanciones);

            oos.flush();
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Elimina canciones de la lista de canciones
 * @param can 
 */
    public void eliminarCancion(Cancion can) {
        listaCanciones.remove(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
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
    public List<Disco> getListaDisco() {
        return listaDisco;
    }
/**
 * 
 * @param listaDisco 
 */
    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
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
