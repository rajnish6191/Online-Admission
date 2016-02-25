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
					Add Programmes
				</h2> </b>
		</center>
		<form method='post'
			action="<%=request.getContextPath() + "/AddProgrammeAction"%>"
			name="programme">
			<center>
				<table>
					<tr>
						<td align='right'>
							<b>Programme Type</b>
						</td>
						<td>
							<select name='programmetype'>
								<option value="Online">
									Online
								</option>
								<option value="Distance">
									Distance
								</option>
								<option value="Regular">
									Regular
								</option>
							</select>
							<br>
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Programme Name</b><b> :</b>
						</td>
						<td>
							<input type='text' name="programmename">
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Programme Desc :</b>
						</td>
						<td>
							<textarea name='programmedesc'></textarea>
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Duration :</b>
						</td>
						<td>
							<input type='text' name="programmeduration">
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Min Age :</b>
						</td>
						<td>
							<input type='text' name="minage">
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Max Age :</b>
						</td>
						<td>
							<input type='text' name="maxage">
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Eligibility :</b>
						</td>
						<td>
							<input type='text' name="eligible">
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Programme Information File :</b>
						</td>
						<td>
							<input type='file' name="programmefile">
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
			</center>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("programme");
frmvalidator.addValidation("programmetype", "dontselect=0");
frmvalidator.addValidation("programmename", "req",
		"please Enter Study Programme Name");
frmvalidator.addValidation("programmedesc", "req",
		"please Enter Programme Description");
frmvalidator.addValidation("programmeduration", "req",
		"please Enter Programme Duration ");
frmvalidator.addValidation("minage", "req", "please Enter Age Limit ");
frmvalidator.addValidation("maxage", "req", "please Enter Age Limit");
frmvalidator.addValidation("eligible", "req", "please Enter Qualification... ");
frmvalidator.addValidation("programmefile", "req",
		"please select Programme File");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
