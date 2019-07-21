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

	public LoginDAO() throws SQLException {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/brisbane_bicycle_racks");
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

	

	public boolean validateUser(String userid, String password) {
		try {
			// Check the logged jobseeker is valid user or not
			PreparedStatement ps = con
					.prepareStatement("select * FROM brisbane_bicycle_racks.users WHERE user='"
							+ userid + "'  and password='" + password + "'");
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
}
