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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Utilitarios.Artista;
import Utilitarios.Cancion;
import Utilitarios.Disco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Santiago Gómez
 */
@ManagedBean(name = "crudDisco")
@RequestScoped
public class CrudDisco implements Serializable {

    public String caratula, nombre, artista, formato;
    private String formatos[] = {"DVD", "CASSETE", "MP4", "CD"};
    public List<Artista> listaArtista;
    public List<Disco> listaDisco;
    public List<String> nombresArtistas = new ArrayList<>();

    /**
     * Constructor para crear la lista de discos
     */
    public CrudDisco() {
        listaDisco = new ArrayList<>();
    }

    /**
     * Postconstruct injecta los artistas
     */
    @PostConstruct
    public void init() {
        lectura();
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().getSessionMap().get("listaArtista") == null) {
            listaArtista = new ArrayList<>();
        } else {
            listaArtista = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
        }
        if (context.getExternalContext().getSessionMap().get("listaDiscos") == null) {
            listaDisco = new ArrayList<>();
        } else {
            listaDisco = (List<Disco>) context.getExternalContext().getSessionMap().get("listaDiscos");
        }
        for (Artista a : listaArtista) {
            nombresArtistas.add(a.getNombre());
        }
    }

    /**
     * Lee y crea el archivo donde se almacenará la lista de discos
     */
    public void lectura() {
        try {
            FileInputStream fis = new FileInputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/disco.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaDisco = (List<Disco>) ois.readObject();
            fis.read();
        } catch (Exception ex) {

            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
/**
 * Agrega los discos a la lista de discos y actualiza el archivo de texto
 */
    public void agregarDisco() {
        Disco disc = new Disco(artista, nombre, formato);
        listaDisco.add(disc);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaDiscos", this.getListaDisco());
        formato = "";
        nombre = "";
        artista = "";
        try {
            FileOutputStream fos = new FileOutputStream("D:/Universidad/Linea/ProyectoDiscoTienda/Disco-Tienda/disco.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listaDisco);

            oos.flush();
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Elimina el disco de la lista de discos
 * @param disc 
 */
    public void eliminarDisco(Disco disc) {
        listaDisco.remove(disc);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaDiscos", this.getListaDisco());
    }
/**
 * Edita el disco seleccionado
 * @param event 
 */
    public void onRowEdit(RowEditEvent event) {
        Disco discoEdit = (Disco) event.getObject();

        System.out.println("Editó");
        FacesMessage message = new FacesMessage("Editó el disco de arista" + discoEdit.getArtista());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
/**
 * 
 * @return 
 */
    public String[] getFormatos() {
        return formatos;
    }
/**
 * 
 * @param formatos 
 */
    public void setFormatos(String[] formatos) {
        this.formatos = formatos;
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
    public String getCaratula() {
        return caratula;
    }
/**
 * 
 * @param caratula 
 */
    public void setCaratula(String caratula) {
        this.caratula = caratula;
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
/**
 * 
 * @return 
 */
    public List<Artista> getListaArtista() {
        return listaArtista;
    }
/**
 * 
 * @param listaArtista 
 */
    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
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
    public List<String> getNombresArtistas() {
        return nombresArtistas;
    }
/**
 * 
 * @param nombresArtistas 
 */
    public void setNombresArtistas(List<String> nombresArtistas) {
        this.nombresArtistas = nombresArtistas;
    }

}
