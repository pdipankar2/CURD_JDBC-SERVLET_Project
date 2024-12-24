<%@page import="com.jtc.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.jtc.dao.CustomerDAO"%>
<%@page import="com.jtc.jdbc.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="add_css.jsp"%>

</head>
<body class="bg-light">
	<%@include file="Navbar.jsp"%>

	<div class="container p-5">

		<p class="text-center fs-1">All Policy Details</p>

		<c:if test="${not empty succMsg }">

			<p class="text-center text-success">${succMsg}</p>
			<c:remove var="succMsg" />
		</c:if>

		<c:if test="${not empty errMsg }">

			<p class="text-center text-danger">${errMsg}</p>
			<c:remove var="errMsg" />
		</c:if>


		<table class="table">
			<thead>
				<tr>
					<th scope="col">SLNO</th>

					<th scope="col">HolderName</th>

					<th scope="col">HolderEmail</th>


					<th scope="col">HolderAge</th>
					<th scope="col">HolderContact</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>


				<%
				CustomerDAO cdao = new CustomerDAO(DBConnection.getConnection());
				List<Customer> list = cdao.getAllPolicyrecord();
				int SLNO = 1;
				for (Customer c : list) {
				%>

				<tr>

					<th scope="row"><%=SLNO++%></th>
					<td><%=c.getPolicyType()%></td>

					<td><%=c.getPolicyName()%></td>
					<td><%=c.getHolderName()%></td>
					<td><%=c.getPremium()%></td>
					<td><%=c.getEmail()%></td>

					<td><%=c.getGender()%></td>
					<td><%=c.getAge()%></td>
					<td><%=c.getPhone()%></td>

					<td><a href="editCustomer.jsp?policyId=<%=c.getPolicyId()%>"
						class="btn btn-primary">Edit</a> <a
						href="delete?policyId=<%=c.getPolicyId()%>"
						class="btn btn-danger ms=1">Delete</a></td>
				</tr>
				<tr>


					<%
					}
					%>
				
			</tbody>
		</table>


	</div>

</body>
</html>