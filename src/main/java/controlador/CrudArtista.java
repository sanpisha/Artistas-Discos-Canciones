/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Utilitarios.Artista;
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
@ManagedBean(name = "crudArtista")
@RequestScoped
public class CrudArtista implements Serializable {
    private String apellido, nombre;
    private Date fechana;
    private List<Artista> lista;
     private String ruta ="artistas.txt";
     
    
    /**
     * Creates a new instance of CrudArtista
     */
     /**
      * Constructor
      */
    public CrudArtista() {
        
    }
    /**
     * Post constructor
     */
    @PostConstruct
    public void init(){
        lectura();
       
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("listaArtista")== null){
            lista = new ArrayList<>();
        }else{
            lista = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
        }
        
    }
    /**
     * Lee el archivo creado para almacenar los artistas
     */
    public void lectura(){
        try{
        FileInputStream fis = new FileInputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/artista.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (List<Artista>) ois.readObject();
            fis.read();
    }catch(Exception ex){
       
            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);
      
        
    }
    }
    /**
     * Agrega el artista a la lista y actualiza el archivo creado
     */
    
    public void agregaArtista(){
        Artista art = new Artista(nombre, apellido, fechana);
       
        lista.add(art);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaArtista", this.getLista());
        nombre="";
        apellido="";
         try {
             FileOutputStream fos = new FileOutputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/artista.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(lista);
            
            oos.flush();
            oos.close();
         }catch(Exception ex){
             Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
     
    }
    /**
     * Elimina el artista de la lista de artistas
     * @param art 
     */
    public void eliminarArtista(Artista art){
        lista.remove(art);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaArtistas", this.getLista());
        
    }
/**
 * 
 * @return 
 */
    public String getRuta() {
        return ruta;
    }
/**
 * 
 * @param ruta 
 */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * 
     * @return 
     */
    public String getApellido() {
        return apellido;
    }
/**
 * 
 * @param apellido 
 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public Date getFechana() {
        return fechana;
    }
/**
 * 
 * @param fechana 
 */
    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }
/**
 * 
 * @return 
 */
    public List<Artista> getLista() {
        return lista;
    }
/**
 * 
 * @param lista 
 */
    public void setLista(List<Artista> lista) {
        this.lista = lista;
    }
    
}
