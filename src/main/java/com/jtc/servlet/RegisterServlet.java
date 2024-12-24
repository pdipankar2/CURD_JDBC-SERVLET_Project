package com.jtc.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jtc.dao.CustomerDAO;
import com.jtc.entity.Customer;
import com.jtc.jdbc.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String holderName = req.getParameter("holderName");
		String email = req.getParameter("email");
		String phone1 = req.getParameter("phone");
		String age1 = req.getParameter("age");
		String gender = req.getParameter("gender");
		String policyType = req.getParameter("policyType");
		String policyName = req.getParameter("policyName");
		String premium1 = req.getParameter("premium");
//convert integer data to appropiate data type

		long phone = Long.parseLong(phone1);
		Integer age = Integer.parseInt(age1);
		Integer premium = Integer.parseInt(premium1);

		Customer cust = new Customer(holderName, policyName, email, phone, age, gender, policyType, premium);
		System.out.println(cust);

		CustomerDAO cdao = new CustomerDAO(DBConnection.getConnection());

		HttpSession session = req.getSession();

		boolean f = cdao.addCustoemr(cust);

		if (f) {

			session.setAttribute("succMsg", "Record Created  Successfully");
			resp.sendRedirect("addCustomer.jsp");
			// System.out.println("Record updated successfully in databases");
		} else {
			session.setAttribute("errMsg", "Something wrong  try aftersome time!!!!!!");
			resp.sendRedirect("addCustomer.jsp");
			// System.out.println("something wrong in server");
		}
	}
}
