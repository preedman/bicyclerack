/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.controllers;

import com.reedmanit.bicyclerack.dao.BicycleRackDAO;
import com.reedmanit.bicyclerack.object.BicycleRack;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author paul
 */
// http://maps.google.com/maps?q=&layer=c&cbll=-27.4593,153.032
//  https://www.google.com/maps/@-27.4593737,153.0319173,3a,75y,236.98h,84.47t/data=!3m7!1e1!3m5!1sWwpeY23n-XQREylIDLtBNQ!2e0!5s20190601T000000!7i13312!8i6656

//  <h:form>
//    <h:commandLink value="Go to this site!" action="#{bean.redirect}" />
//</h:form>
//
//public void redirect() throws IOException {
    // ...
//
//    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//    externalContext.redirect("http://stackoverflow.com");
//}
//
@ManagedBean
@Named(value = "bicycleTableController")
@RequestScoped
public class BicycleTableController implements Serializable {

    private List<BicycleRack> bicycleRacks;
    private List<BicycleRack> filtererBicycleRacks;
    private BicycleRackDAO rackDAO;

    /**
     * Creates a new instance of BicycleTableController
     */
    public BicycleTableController() {
        System.out.println("Construct");

    }

    @PostConstruct
    public void init() {
        System.out.println("INIT");
        rackDAO = new BicycleRackDAO(com.reedmanit.bicyclerack.util.Connection.getInstance().getDBConnection());
        setBicycleRacks(rackDAO.extractBicycleRacks());
    }

    /**
     * @return the bicycleRacks
     */
    public List<BicycleRack> getBicycleRacks() {
        return bicycleRacks;
    }

    /**
     * @param bicycleRacks the bicycleRacks to set
     */
    public void setBicycleRacks(List<BicycleRack> bicycleRacks) {
        this.bicycleRacks = bicycleRacks;
    }

    /**
     * @return the filtererBicycleRacks
     */
    public List<BicycleRack> getFiltererBicycleRacks() {
        return filtererBicycleRacks;
    }

    /**
     * @param filtererBicycleRacks the filtererBicycleRacks to set
     */
    public void setFiltererBicycleRacks(List<BicycleRack> filtererBicycleRacks) {
        this.filtererBicycleRacks = filtererBicycleRacks;
    }
    
    public void reDirect(Integer id) throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        
        Iterator i = bicycleRacks.iterator();
        while(i.hasNext()) {
            BicycleRack b = (BicycleRack) i.next();
            if (b.getId().equals(id)) {
                externalContext.redirect(b.getStreetView());
                break;
            }
        }
        
        
    }

}
