/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.controllers;


import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author paul
 */
@ManagedBean
@RequestScoped
@Named(value = "loginManager")
//@ViewScoped
public class LoginManager implements Serializable {
    
    private String username;
    private String password;
    private static final String SESSION_USER_VARIABLE_NAME = "user";

    /**
     * Creates a new instance of LoginManager
     */
    public LoginManager() {
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateUser(){
        FacesMessage msg = null;
        ExternalContext externalContext = externalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            System.out.println("Username " + username + " " + "Password " + password);
            request.login(username, password);
            externalContext.getSessionMap().put(SESSION_USER_VARIABLE_NAME, username);
            return "/views/bicycletable.xhtml?faces-redirect=true";
            
            //externalContext.redirect(forwardUrl);
        } catch (ServletException e) {
            /*
             * The ServletException is thrown if the configured login mechanism does not support
             * username password authentication, or if a non-null caller identity had already been
             * established (prior to the call to login), or if validation of the provided username and password fails.
             */
            String loginErrorMessage = e.getLocalizedMessage();
            
            System.out.println("Login error " + e.getMessage());
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            try {
                request.logout();
            } catch (ServletException ex) {
                
                System.out.println("Logout error " + ex.getMessage());
            }
            return null;
          //  facesContext().addMessage(null, new FacesMessage(loginErrorMessage));
        }
        
    }
    
    private ExternalContext externalContext() {
        return facesContext().getExternalContext();
    }

    private FacesContext facesContext() {
        return FacesContext.getCurrentInstance();
    }
}
