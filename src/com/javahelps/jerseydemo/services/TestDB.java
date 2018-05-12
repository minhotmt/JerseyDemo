package com.javahelps.jerseydemo.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/db")
public class TestDB {
	
	ConnectDB dbc;
	Connection conn;
	ResultSet relt;
	String Iuser = "Invalid User";
	
	@GET()
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Customer> DemoDB() throws Exception {
		dbc = new ConnectDB();
		ArrayList<Customer> a= new  ArrayList<>();
		a = dbc.getAllCustomer();
		return a;
	}
}
