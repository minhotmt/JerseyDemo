package com.javahelps.jerseydemo.services;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {
	
	CustomerRepository repo = new CustomerRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Customer> getAllCustomer() throws Exception {
		System.out.println("Get All Customer by id is Calling...");
		return repo.getAllCustomer();
	}
	
	@GET
	@Path("customer/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer getCustomer(@PathParam("id") String id) throws Exception {
		System.out.println("Get Customer by id is Calling...");
		return repo.getCustomerById(id);
	}
	
	@POST
	@Path("customer")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer insertNew(Customer cus) throws Exception {
		System.out.println("Get Create New Customer by id is Calling...");
		repo.insertNew(cus);
		return cus;
	}
	
	@PUT
	@Path("customer")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer updateCustomer(Customer cus) throws Exception {
		System.out.println("Update Customer by id is Calling...");
		repo.UpdateCustomer(cus.getId(), cus);
		return cus;
	}
	
	

}
