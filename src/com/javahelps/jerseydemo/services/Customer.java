package com.javahelps.jerseydemo.services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private String Id;
	private String ad2;
	private String zip;
	private String phone;
	private String ad1;
	private String fax;
	private String email;
	private String name;
	private String state;
	private String city;
	private String rep;
	
	

	public Customer() {
		super();
	}

	public Customer(String id, String ad2, String zip, String phone, String ad1, String fax, String email, String name,
			String state, String city, String rep) {
		super();
		Id = id;
		this.ad2 = ad2;
		this.zip = zip;
		this.phone = phone;
		this.ad1 = ad1;
		this.fax = fax;
		this.email = email;
		this.name = name;
		this.state = state;
		this.city = city;
		this.rep = rep;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAd2() {
		return ad2;
	}

	public void setAd2(String ad2) {
		this.ad2 = ad2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAd1() {
		return ad1;
	}

	public void setAd1(String ad1) {
		this.ad1 = ad1;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", ad2=" + ad2 + ", zip=" + zip + ", phone=" + phone + ", ad1=" + ad1 + ", fax="
				+ fax + ", email=" + email + ", name=" + name + ", state=" + state + ", city=" + city + ", rep=" + rep
				+ "]";
	}

}
