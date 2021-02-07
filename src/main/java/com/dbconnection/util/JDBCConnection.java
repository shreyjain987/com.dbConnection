package com.dbconnection.util;

import java.sql.*;

public class JDBCConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// create our mysql database connection
			String myDriver = "oracle.jdbc.driver.OracleDriver";
			String myUrl = "jdbc:oracle:thin:@myhost:1521/myorcldbservicename";
			Class.forName(myDriver);
			// DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			Connection conn = DriverManager.getConnection(myUrl, "hr", "hr");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM users";

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Date dateCreated = rs.getDate("date_created");
				boolean isAdmin = rs.getBoolean("is_admin");
				int numPoints = rs.getInt("num_points");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

//		Properties info = new Properties();     
//	    info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
//	    info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);          
//	    info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");    
//	  
//
//	    OracleDataSource ods = new OracleDataSource();
//	    ods.setURL(DB_URL);    
//	    ods.setConnectionProperties(info);
//
//	    // With AutoCloseable, the connection is closed automatically.
//	    try (OracleConnection connection = (OracleConnection) ods.getConnection()) {
//	      // Get the JDBC driver name and version 
//	      DatabaseMetaData dbmd = connection.getMetaData();       
//	      System.out.println("Driver Name: " + dbmd.getDriverName());
//	      System.out.println("Driver Version: " + dbmd.getDriverVersion());
//	      // Print some connection properties
//	      System.out.println("Default Row Prefetch Value is: " + 
//	         connection.getDefaultRowPrefetch());
//	      System.out.println("Database Username is: " + connection.getUserName());
//	      System.out.println();
//	      // Perform a database operation 
//	      printEmployees(connection);
//	    }   
	}

}
