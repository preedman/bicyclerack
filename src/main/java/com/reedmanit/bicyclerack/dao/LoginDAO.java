package com.reedmanit.bicyclerack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDAO {

    private DataSource ds;
    Connection con;

    public LoginDAO(Connection aConnection) {
        con = aConnection;

    }
    
    public boolean validateUser(String userid, String password) {

        if ((userid.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("pulsar"))) {
            return true;
        } else {
            return false;
        }
    }

   // public boolean validateUser(String userid, String password) {
    //    try {
            // Check the logged jobseeker is valid user or not
   //         PreparedStatement ps = con
     //               .prepareStatement("select * FROM brisbane_bicycle_racks.users WHERE user='"
     //                       + userid + "'  and password='" + password + "'");
    //        ResultSet resultSet = ps.executeQuery();
      //      if (resultSet.next()) {
      //          return true;
      //      } else {
     //           return false;
     //       }

     //   } catch (SQLException e) {
     //       e.printStackTrace();

    //    } catch (Exception e) {
    //        e.printStackTrace();

      //  }
      //  return false;
   // }
}
