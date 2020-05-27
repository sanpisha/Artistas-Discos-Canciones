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
    @PostConstruct
    public void creaAdmin(){
        Admin admin = new Admin("admin", "admin");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("admin", admin);
    }
    public String loguearse(){
        LogicaLogin logica = new LogicaLogin(username, password);
        logica.loguearse();
        return logica.getRedirecciona();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
