<%@page import="com.jtc.entity.Customer"%>
<%@page import="com.jtc.jdbc.DBConnection"%>
<%@page import="com.jtc.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="add_css.jsp" %>

</head>
<body class="bg-light">
<%@include file="Navbar.jsp" %>
<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
				<div class="card-body">
					<div class="row-body text-center">
					<h1 >Edit Policy Form</h1>
					
					
					<%
					int id=Integer.parseInt(request.getParameter("policyId"));
					
					CustomerDAO cdao=new CustomerDAO(DBConnection.getConnection());
					Customer c=cdao.getPolicyById(id);
					%>
					
					
					
					<form action="update" method="post">
					
					
					<input type="hidden" name="policyId" value="<%=c.getPolicyId()%>">
					
            <div class="mb-3">
                <label for="name">Full Name:</label>
                <input type="text" name="holderName" placeholder="PolicyHolder Name" value="<%=c.getHolderName() %>" >
            </div>

            <div class="cal mb-3">
                <label for="email">Email Address:</label>
                <input type="email" placeholder="PolicyHolder email" id="email" value="<%=c.getEmail() %>"  name="email" required>
            </div>

            <div class="cal mb-3">
                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" placeholder="PolicyHolder contact" value="<%=c.getPhone() %>" name="phone" required>
            </div>

            <div class="cal mb-3">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" value="<%=c.getAge() %>" required>
            </div>

            <div class="cal mb-3">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender"  value="<%=c.getGender() %>" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="cal mb-3">
                <label for="policyType">Policy Type:</label>
                <select id="policyType" name="policyType" value="<%=c.getPolicyType() %>" required>
                    <option value="Life Insurance">Life Insurance</option>
                    <option value="Health Insurance">Health Insurance</option>
                    <option value="Vehicle Insurance">Vehicle Insurance</option>
                    <option value="Property Insurance">Property Insurance</option>
                </select>
            </div>

            <div class=" mb-3">
                <label for="policyName">Policy Name:</label>
                <input type="text" id="policyName" name="policyName" value="<%=c.getPolicyName() %>" required>
            </div>

            <div class=" mb-3">
                <label for="premium">Premium Amount:</label>
                <input type="number" id="premium" name="premium" value="<%=c.getPremium() %>" required>
            </div>

            
                <button type="submit" class="btn btn-primary ">Submit</button>
            
       
        </form>
					
					</div>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>