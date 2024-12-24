package com.jtc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jtc.dao.CustomerDAO;
import com.jtc.jdbc.DBConnection;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int policyId=Integer.parseInt(req.getParameter("policyId"));
		
      CustomerDAO dao=new CustomerDAO(DBConnection.getConnection());
		HttpSession session = req.getSession();

      boolean f = dao.deletePolicys(policyId);
      if (f) {

			session.setAttribute("succMsg", "Record deleted  Successfully");
			resp.sendRedirect("index.jsp");
			// System.out.println("Record updated successfully in databases");
		} else {
			session.setAttribute("errMsg", "Something wrong  try aftersome time!!!!!!");
			resp.sendRedirect("index.jsp");
			// System.out.println("something wrong in server");
		}
	}
}
