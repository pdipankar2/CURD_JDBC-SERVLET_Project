

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insurance Policy Form</title>
<%@include file="add_css.jsp"%>



</head>
<body>
	<%@include file="Navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="row-body text-center">
						<h1>Insurance Policy Form</h1>




						<c:if test="${not empty succMsg }">

							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errMsg }">

							<p class="text-center text-danger">${errMsg}</p>
							<c:remove var="errMsg" />
						</c:if>


						<form action="register" method="post">
							<div class="form-group">
								<label for="name">Full Name:</label> <input type="text"
									name="holderName" placeholder="PolicyHolder Name" required>
							</div>

							<div class="form-group">
								<label for="email">Email Address:</label> <input type="email"
									placeholder="PolicyHolder email" id="email" name="email"
									required>
							</div>

							<div class="form-group">
								<label for="phone">Phone Number:</label> <input type="tel"
									id="phone" placeholder="PolicyHolder contact" name="phone"
									required>
							</div>

							<div class="form-group">
								<label for="age">Age:</label> <input type="number" id="age"
									name="age" required>
							</div>

							<div class="form-group">
								<label for="gender">Gender:</label> <select id="gender"
									name="gender" required>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="Other">Other</option>
								</select>
							</div>

							<div class="form-group">
								<label for="policyType">Policy Type:</label> <select
									id="policyType" name="policyType" required>
									<option value="Life Insurance">Life Insurance</option>
									<option value="Health Insurance">Health Insurance</option>
									<option value="Vehicle Insurance">Vehicle Insurance</option>
									<option value="Property Insurance">Property Insurance</option>
								</select>
							</div>

							<div class="form-group">
								<label for="policyName">Policy Name:</label> <input type="text"
									name="policyName" required>
							</div>

							<div class="form-group">
								<label for="premium">Premium Amount:</label> <input
									type="number" id="premium" name="premium" required>
							</div>

							<div class="form-group">
								<button type="submit">Submit</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>

	</div>



</body>