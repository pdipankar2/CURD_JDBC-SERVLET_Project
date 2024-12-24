package com.jtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jtc.entity.Customer;

public class CustomerDAO {

	private Connection con;

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addCustoemr(Customer customer) {
		boolean f = false;

		try {

			String sql = "insert into policydetails(holderName,policyName,email,phone,age,gender,policyType,premium)values(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getHolderName());
			ps.setString(2, customer.getPolicyName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			ps.setInt(5, customer.getAge());
			ps.setString(6, customer.getGender());
			ps.setString(7, customer.getPolicyType());
			ps.setInt(8, customer.getPremium());

			int executeUpdate = ps.executeUpdate();

			if (executeUpdate == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<Customer> getAllPolicyrecord() {

		List<Customer> list = new ArrayList<Customer>();
		Customer cust = null;
		try {

			String sql = "select * from policydetails";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				cust = new Customer();

				cust.setPolicyId(rs.getInt(1));
				cust.setHolderName(rs.getString(2));
				cust.setPolicyName(rs.getString(3));
				cust.setEmail(rs.getString(4));
				cust.setPhone(rs.getLong(5));
				cust.setAge(rs.getInt(6));
				cust.setGender(rs.getString(7));
				cust.setPolicyType(rs.getString(8));
				cust.setPremium(rs.getInt(9));

				list.add(cust);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;
	}

	public Customer getPolicyById(Integer policyId) {

		Customer cust = null;

		try {

			String sql = "select * from policydetails where policyId=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, policyId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				cust = new Customer();

				cust.setPolicyId(rs.getInt(1));
				cust.setHolderName(rs.getString(2));
				cust.setPolicyName(rs.getString(3));
				cust.setEmail(rs.getString(4));
				cust.setPhone(rs.getLong(5));
				cust.setAge(rs.getInt(6));
				cust.setGender(rs.getString(7));
				cust.setPolicyType(rs.getString(8));
				cust.setPremium(rs.getInt(9));

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return cust;

	}

	public boolean updatePolicy(Customer customer) {
		boolean f = false;

		try {

			String sql = "update  policydetails set holderName=?,policyName=?,email=?,phone=?,age=?,gender=?,policyType=?,premium=? where policyId=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getHolderName());
			ps.setString(2, customer.getPolicyName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			ps.setInt(5, customer.getAge());
			ps.setString(6, customer.getGender());
			ps.setString(7, customer.getPolicyType()); 
			ps.setInt(8, customer.getPremium());
			ps.setInt(9, customer.getPolicyId());

			int executeUpdate = ps.executeUpdate();

			if (executeUpdate == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deletePolicys(Integer policyId) {
		
		boolean f=false;
		
		try {
			
			String sql="delete from policydetails where policyId=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, policyId);
			
			int executeUpdate = ps.executeUpdate();
			
			if (executeUpdate == 1) {
				f = true;
			}
			
		} catch (Exception e) {
           e.printStackTrace();	
           
		}
		return f;
	}

}
