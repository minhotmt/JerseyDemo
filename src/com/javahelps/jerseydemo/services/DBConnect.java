package com.javahelps.jerseydemo.services;

import java.sql.*;
import java.util.*;

public class DBConnect {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection openConnect() throws Exception
	{
		try {
				 Class.forName("com.mysql.jdbc.Driver");
				 String DB_url = "jdbc:mysql://localhost/detai";
				 this.conn = DriverManager.getConnection(DB_url,"root","");
				 System.out.println("Kết nối MySQL thành công!");
			 } 
		catch (ClassNotFoundException e) {System.out.println("Kết nối Driver thất bại!");}
		catch (SQLException e) {System.out.println("Không kết nối được CSDL");}
		 return conn;
	}
	
	public Statement getStatement() throws SQLException, Exception
	{
		 
		stmt = openConnect().createStatement();
		return stmt;
		 
	}

	public void closeConnet() throws SQLException {
		if (rs != null && !rs.isClosed())
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

	public ArrayList<DeTai> getAllDeTai() throws Exception {
		ArrayList<DeTai> lst = new ArrayList<DeTai>();
		String strSQL = "select * from DeTai ";
		try {
			rs = getStatement().executeQuery(strSQL);
			while (rs.next()) {
				String MaDT = rs.getString("MaDT");
				String Name = rs.getString("Name");
				String Status = rs.getString("Status");
				DeTai dt = new DeTai(MaDT, Name, Status);
				lst.add(dt);
			}
		} catch (Exception e) {
			System.out.println("Loi truy van CSDL.");
			;
		}
		closeConnet();
		return lst;
	}

	public boolean insertNew(DeTai dt) throws Exception {
		String sql = "insert into DeTai values(?,?,?)";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, dt.getMaDT());
		pst.setString(2, dt.getName());
		pst.setString(3, dt.getStatus());
		return pst.executeUpdate() > 0;

	}

	public boolean deleteDeTai(String MaDT) throws Exception {
		String sql = "delete from DeTai where MaDT = ?";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, MaDT);
		return pst.executeUpdate() > 0;
	}

	public int executeUpdate(String strSQL) throws Exception {
		int result = 0;
		try {
			result = getStatement().executeUpdate(strSQL);
		} catch (Exception e) {
			System.out.println(" Error at: " + strSQL);
		} finally {
			this.closeConnet();
		}
		return result;

	}

	public DeTai getDeTaiByMaDT(String MaDT) throws Exception {
		String sql = "select * from DeTai where MaDT=?";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, MaDT);
		rs = pst.executeQuery();
		DeTai dt = null;
		if (rs.next()) {
			String Madt = rs.getString("MaDT");
			String Name = rs.getString("Name");
			String Status = rs.getString("Status");
			dt = new DeTai(Madt, Name, Status);
		}
		return dt;
	}

	public boolean UpdateDeTai(String MaDT, DeTai newdt) throws Exception {
		String sql = "update DeTai set Name=? , Status=? where MaDT =?";
		PreparedStatement pst = openConnect().prepareStatement(sql);		
		pst.setString(1, newdt.getName());
		pst.setString(2, newdt.getStatus());
		pst.setString(3, newdt.getMaDT());
		return pst.executeUpdate() > 0;

	}

	public static void main(String[] args) throws Exception {
		DBConnect db = new DBConnect();
		Iterator<DeTai> it = db.getAllDeTai().iterator();
		while (it.hasNext()) {
			Object element = it.next();
			System.out.println(element);
		}
	}
}
