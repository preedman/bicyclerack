/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.util;

import com.reedmanit.bicyclerack.object.BicycleRack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author paul
 */
public class RackCache {

    private static ConcurrentHashMap<String, BicycleRack> dataCache;

    public RackCache() {
        dataCache = new ConcurrentHashMap<String, BicycleRack>();
    }

    public void loadCache(String cacheLocation) throws IOException {

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(cacheLocation))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);

                BicycleRack r = new BicycleRack();

                r.setId(data[0]);
                r.setAddress(data[1]);
                r.setLocation(data[2]);
                r.setCapacity(data[3]);
                r.setType(data[4]);
                r.setLat(data[5]);
                r.setLng(data[6]);
                r.setStreetView();

                dataCache.put(data[0], r);

            }

        } catch (IOException e) {
            throw e;
        }

    }

    public ConcurrentHashMap getCache() {
        return dataCache;
    }
}
