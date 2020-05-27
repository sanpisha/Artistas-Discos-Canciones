/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.LogicaLogin;
import Utilitarios.Admin;

/**
 *
 * @author Santiago Gómez
 */

@ManagedBean(name = "userLoginView")
@SessionScoped
@Dependent
public class Login implements Serializable{
    private String username;
    private String password;
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    /**
     * creación del usuario admin
     */
    @PostConstruct
    public void creaAdmin(){
        Admin admin = new Admin("admin", "admin");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("admin", admin);
    }
    /**
     * le permite el acceso al usuario administrador
     * @return 
     */
    public String loguearse(){
        LogicaLogin logica = new LogicaLogin(username, password);
        logica.loguearse();
        return logica.getRedirecciona();
    }
    /**
     * 
     * @return 
     */
    public String getUsername() {
        return username;
    }
/**
 * 
 * @param username 
 */
    public void setUsername(String username) {
        this.username = username;
    }
/**
 * 
 * @return 
 */
    public String getPassword() {
        return password;
    }
/**
 * 
 * @param password 
 */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
