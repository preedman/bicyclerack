/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.object;

import java.io.Serializable;

/**
 *
 * @author paul
 */
public class BicycleRack implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String address;
    private String location;
    private Integer capacity;
    private String type;
    private Float lat;
    private Float lng;
    private String streetView;
    private static String url = "http://maps.google.com/maps?q=&layer=c&cbll=";

    public BicycleRack() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the lat
     */
    public Float getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public Float getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(Float lng) {
        this.lng = lng;
    }
    
    public void setStreetView() {
        streetView = url + this.lat + "," + this.lng;
    }
    
    public String getStreetView() {
        return this.streetView;
    }

}
