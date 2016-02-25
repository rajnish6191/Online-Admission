<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session.getAttribute("role") == null) {
		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
	}
%>
<html>
	<head>
		<script language="javascript">
function checkName() {
	re = /^[A-Za-z]+$/;
	if (!re.test(document.department.departmentLocation.value)) {
		alert('departmentLocation not allows to numaric values');
	}
}</script>
		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<b><h2>
					Add Study Center
				</h2> </b>
		</center>
		<form method='post'
			action="<%=request.getContextPath() + "/AddStudyCenterAction"%>"
			name="studycenter">
			<table border='0' cellspacing=2 align="center" bgcolor="27C2D0">
				<tr>
					<td align='right'>
						<b>Study Center </b><b>Name :</b>
					</td>
					<td>
						<input type='text' name='centerName'>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>Study Center </b><b>Description :</b>
					</td>
					<td>
						<textarea name='centerdesc'></textarea>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>Study Center Location :</b>
					</td>
					<td>
						<input type='text' name="location">
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>Study Center Logo :</b>
					</td>
					<td>
						<input type='file' name="logo">
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type='submit' name=submit value='Submit'>
					</td>
					<td align='left'>
						<input type='reset' name=Reset value='Clear'>
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("studycenter");
frmvalidator.addValidation("centerName", "req",
		"please Enter Study Center Name");
frmvalidator.addValidation("centerdesc", "req",
		"please Enter Study Center Description");
frmvalidator.addValidation("location", "req",
		"please Enter Study Center Location");
frmvalidator.addValidation("logo", "req", "Please Load Study Center Logo");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
