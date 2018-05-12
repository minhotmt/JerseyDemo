package com.javahelps.jerseydemo.services;

public class DeTai {
	private String MaDT;
	private String Name;
	private String Status;
	public DeTai(String maDT, String name, String status) {
		super();
		MaDT = maDT;
		Name = name;
		Status = status;
	}
	public String getMaDT() {
		return MaDT;
	}
	public void setMaDT(String maDT) {
		MaDT = maDT;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "DeTai [MaDT=" + MaDT + ", Name=" + Name + ", Status=" + Status + "]";
	}
	
}
