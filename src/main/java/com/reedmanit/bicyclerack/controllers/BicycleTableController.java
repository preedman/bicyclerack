/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.controllers;

import com.reedmanit.bicyclerack.dao.BicycleRackDAO;
import com.reedmanit.bicyclerack.object.BicycleRack;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author paul
 */
@ManagedBean
@Named(value = "bicycleTableController")
@RequestScoped
public class BicycleTableController implements Serializable {
    
    private List<BicycleRack> bicycleRacks; 
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
        try {
            rackDAO = new BicycleRackDAO();
            setBicycleRacks(rackDAO.extractBicycleRacks());
        } catch (SQLException se) {
            se.printStackTrace();
        }
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
    
    
}
