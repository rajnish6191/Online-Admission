
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>

		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>

	<body onload="javascript:disableBackButton()">
		<jsp:include page="Header.jsp"></jsp:include>
		<form action="<%=request.getContextPath() + "/LoginAction"%>"
			method=post name="login">
			<table bgcolor="27C2D0" border="0" align="center" bgcolor="white">
				<tr>
					<td align='center' colspan='2'>
						<b>Login Here</b>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<span class="Title">Login ID :</span>
					</td>
					<td>
						<font face="Baskerville Old Face"><input type="text"
								name="username"> </font>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<span class="Title">Password :</span>
					</td>
					<td>
						<font face="Baskerville Old Face"><input type="password"
								name="password"> </font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center" class="style11">
							<input type="submit" name="Submit" value="Sign In">
							&nbsp;
							<input name="Input2" type="reset" value="Clear">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center" class="style11">
							<a href="./StudentRegistrationForm.jsp"><b>StudentRegistration...?</b>
							</a> &nbsp;&nbsp;
						</div>
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("login");

frmvalidator.addValidation("username", "req", "Login Name is required");
frmvalidator.addValidation("password", "req", "Password is required");
</script>
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>