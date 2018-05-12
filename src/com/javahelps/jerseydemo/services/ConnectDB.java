package com.javahelps.jerseydemo.services;

import java.sql.*;
import java.util.*;

public class ConnectDB {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection openConnect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String DB_url = "jdbc:mysql://localhost/jerseydb";
			this.conn = DriverManager.getConnection(DB_url, "root", "");
			System.out.println("Kết nối MySQL thành công!");
		} catch (ClassNotFoundException e) {
			System.out.println("Kết nối Driver thất bại!");
		} catch (SQLException e) {
			System.out.println("Không kết nối được CSDL");
		}
		return conn;
	}

	public Statement getStatement() throws SQLException, Exception {

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

	public ArrayList<Customer> getAllCustomer() throws Exception {
		ArrayList<Customer> lst = new ArrayList<Customer>();
		String strSQL = "select * from customer ";
		try {
			rs = getStatement().executeQuery(strSQL);
			while (rs.next()) {
				String Id = rs.getString("Id");
				String ad2 = rs.getString("ad2");
				String zip = rs.getString("zip");
				String phone = rs.getString("phone");
				String ad1 = rs.getString("ad1");
				String fax = rs.getString("fax");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String state = rs.getString("state");
				String city = rs.getString("city");
				String rep = rs.getString("rep");
				Customer cus = new Customer(Id, ad2, zip, phone, ad1, fax, email, name, state, city, rep);
				lst.add(cus);
			}
		} catch (Exception e) {
			System.out.println("Loi truy van CSDL.");
			;
		}
		closeConnet();
		return lst;
	}

	public boolean insertNew(Customer cus) throws Exception {
		String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, cus.getId());
		pst.setString(2, cus.getAd2());
		pst.setString(3, cus.getZip());
		pst.setString(4, cus.getPhone());
		pst.setString(5, cus.getAd1());
		pst.setString(6, cus.getFax());
		pst.setString(7, cus.getEmail());
		pst.setString(8, cus.getName());
		pst.setString(9, cus.getState());
		pst.setString(10, cus.getCity());
		pst.setString(11, cus.getRep());
		return pst.executeUpdate() > 0;

	}

	public boolean deleteCustomer(String Id) throws Exception {
		String sql = "delete from customer where Id = ?";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, Id);
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

	public Customer getCustomerById(String Id) throws Exception {
		String sql = "select * from customer where Id=?";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, Id);
		rs = pst.executeQuery();
		Customer cus = null;
		if (rs.next()) {
			String ad2 = rs.getString("ad2");
			String zip = rs.getString("zip");
			String phone = rs.getString("phone");
			String ad1 = rs.getString("ad1");
			String fax = rs.getString("fax");
			String email = rs.getString("email");
			String name = rs.getString("name");
			String state = rs.getString("state");
			String city = rs.getString("city");
			String rep = rs.getString("rep");
			cus = new Customer(Id, ad2, zip, phone, ad1, fax, email, name, state, city, rep);
		}
		return cus;
	}

	public boolean UpdateCustomer(String Id, Customer cus) throws Exception {
		String sql = "update Customer set ad2=? , zip=?, phone=?, ad1=?, fax=?, email=?, name=?, state=?, city=?, rep=? where Id =?";
		PreparedStatement pst = openConnect().prepareStatement(sql);
		pst.setString(1, cus.getAd2());
		pst.setString(2, cus.getZip());
		pst.setString(3, cus.getPhone());
		pst.setString(4, cus.getAd1());
		pst.setString(5, cus.getFax());
		pst.setString(6, cus.getEmail());
		pst.setString(7, cus.getName());
		pst.setString(8, cus.getState());
		pst.setString(9, cus.getCity());
		pst.setString(10, cus.getRep());
		pst.setString(11, cus.getId());
		return pst.executeUpdate() > 0;
	}

	public static void main(String[] args) throws Exception {
		ConnectDB db = new ConnectDB();
		Iterator<Customer> it = db.getAllCustomer().iterator();
		while (it.hasNext()) {
			Object element = it.next();
			System.out.println(element);
		}
	}
}