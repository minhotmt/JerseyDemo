package com.javahelps.jerseydemo.services;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getcustomer")
public class HelloWorldService {
	
	CustomerRepository repo = new CustomerRepository();
	
    @GET
    @Path("auto")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomer() {
    	System.out.println("Get Customer Calling...");
    	Customer cus = new Customer("19985596","2 Le Van Luong","88000","214-645-8888","399 Hanoi","987-654-0123","minhotmt@gmail.com","Minhotmt",
    			"QA","Andrew","MI");
    	return cus;
    }
    
    @GET
    @Path("one")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomerById() throws Exception {
    	System.out.println("Get Customer Calling...");
    	Customer cus = repo.getCustomerById("19985597");
    	return cus;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomerPath(@PathParam("id") String id  ) throws Exception {
    	System.out.println("Get Customer Calling...");
    	Customer cus = repo.getCustomerById(id);
    	return cus;
    }
}