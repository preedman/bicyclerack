/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.bicyclerack.dao;

import com.reedmanit.bicyclerack.object.BicycleRack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author paul
 */
public class BicycleRackDAO {
    
    private DataSource ds;
    Connection con;
    
    public BicycleRackDAO() throws SQLException {
        try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/bicyclerack");
			if (ds == null) {
				throw new SQLException("Can't get data source");
			}
			// get database connection
			con = ds.getConnection();
			if (con == null) {
				throw new SQLException("Can't get database connection");
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
    public List<BicycleRack> extractBicycleRacks() {
        
        List<BicycleRack> racks = new ArrayList<BicycleRack>();
        System.out.println("Extracting racks");
        try {
			// Check the logged jobseeker is valid user or not
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM brisbane_bicycle_racks.location");							
			ResultSet resultSet = ps.executeQuery();
                       
			while (resultSet.next()) {
                            BicycleRack br = new BicycleRack();
                            br.setId(resultSet.getInt(1));
                            br.setAddress(resultSet.getString(2));
                            br.setLocation(resultSet.getString(3));
                            br.setCapacity(resultSet.getInt(4));
                            br.setType(resultSet.getString(5));
                            br.setLat(resultSet.getFloat(6));
                            br.setLng(resultSet.getFloat(7));
                            racks.add(br);
                        }

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
        return racks;
    }
    
}
