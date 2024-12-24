package com.jtc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jtc.dao.CustomerDAO;
import com.jtc.entity.Customer;
import com.jtc.jdbc.DBConnection;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int policyId = Integer.parseInt(req.getParameter("policyId"));
		String holderName = req.getParameter("holderName");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));

		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String policyType = req.getParameter("policyType");
		String policyName = req.getParameter("policyName");
		int premium = Integer.parseInt(req.getParameter("premium"));

		Customer cust = new Customer(policyId, holderName, policyName, email, phone, age, gender, policyType, premium);

		CustomerDAO cdao = new CustomerDAO(DBConnection.getConnection());

		HttpSession session = req.getSession();

		boolean f = cdao.updatePolicy(cust);

		if (f) {

			session.setAttribute("succMsg", "Record Updated Successfully");
			resp.sendRedirect("index.jsp");
			// System.out.println("Record updated successfully in databases");
		} else {
			session.setAttribute("errMsg", "Something wrong  try aftersome time!!!!!!");
			resp.sendRedirect("index.jsp");
			// System.out.println("something wrong in server");
		}
	}

}
