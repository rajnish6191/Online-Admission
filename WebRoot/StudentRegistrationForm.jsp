<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head id="ctl00_header">
		<head>
			<script language="JavaScript" src="scripts/gen_validatorv31.js"
				type="text/javascript">
</script>
			<script language="JavaScript" type="text/javascript"
				src="scripts/ts_picker.js">
</script>
			<script language="JavaScript1.1" src="scripts/pass.js">
</script>
			<script type="text/javascript" src="scripts/image.js">
</script>
			<script type="text/javascript" src="scripts/general.js">
</script>
			<script type="text/javascript" src="scripts/adi.js">
</script>
			<script type="text/javascript" src="scripts/form_validation.js">
</script>

			<script language="JavaScript" src="images/javascripts.js">
</script>
			<script language="JavaScript" src="images/pop-closeup.js">
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
		</head>
		<body>
			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
				<h3>
					<span class=subHead><br />Students Registration Form </span>
				</h3>
			</center>
			<form action="./StudentRegisterAction" method='get' name="register"
				onsubmit="return validate()">
				<!--<table border="1"><tr><td></td></tr></table>-->
				<input type="hidden" name="port" value="<%=request.getLocalPort()%>" />
				<input type="hidden" name="host"
					value="<%=request.getServerName()%>" />
				<br />
				<table border='0' align="center">
					<th colspan="6" bgcolor="white">
						Personal Details
					</th>

					<tr>
						<td align='right'>
							Full Name :
						</td>
						<td>
							<input type="text" name="fullName" value="" />
						</td>
						<td align='right'>
							Browse Photo :
						</td>
						<td>
							<input type="file" name="photo" class="textfield"
								onChange="preview(this)" />
						</td>

					</tr>
					<tr>
						<td align='right'>
							Guardian :
						</td>
						<td>
							<select name="guardiantype">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Father">
									<font size="3" face="Verdana">Father</font>
								</option>
								<option value="Mother">
									<font size="3" face="Verdana">Mother</font>
								</option>
								<option value="Husbend">
									<font size="3" face="Verdana">Husbend</font>
								</option>
								<option value="gurdian">
									<font size="3" face="Verdana">gurdian</font>
								</option>
							</select>
						</td>
						<td border="0" align="left" rowspan="5" colspan='2'>


							<img alt="See Photo Here" id="previewField" src="images/flag.gif"
								height="150" width="120" />

						</td>
					</tr>
					<tr>
						<td align='right'>
							Name Guardian:
						</td>
						<td>
							<input type="text" name="nameguardian" value="" size="20" />
						</td>
						<td align='right'>

						</td>
						<td>

						</td>
					</tr>

					<tr>
						<td align='right'>
							Birth Date :
						</td>
						<td width='256'>
							<input type="text" name="birthdate" value="" size="20"
								readonly="readonly" />
							<a
								href="javascript:show_calendar('document.register.birthdate', document.register.birthdate.value);">
								<img src="images/cal.gif" alt="a" width="18" height="18"
									border="0" /> </a>
						</td>
						<td align='right'>

						</td>
						<td>

						</td>
					</tr>
					<tr>
						<td align='right'>
							Nationality :
						</td>
						<td width='256'>
							<input type="text" name="nationality" value="INDIAN" size="20"
								readonly="readonly" />
						</td>
						<td align='right'>

						</td>
						<td>

						</td>
					</tr>
					<tr>
						<td align='right'>
							Gender :
						</td>
						<td>
							<select name="gender">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Male">
									<font size="3" face="Verdana">Male</font>
								</option>
								<option value="Female">
									<font size="3" face="Verdana">Female</font>
								</option>
							</select>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td align='right'>
							Email :
						</td>
						<td>
							<input type="text" name="email" value="" size="20" />
						</td>
						<td align='right'>
							Marital Status :
						</td>
						<td>
							<select name="maritalstatus">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Married">
									<font size="3" face="Verdana">Married</font>
								</option>
								<option value="UnMarried">
									<font size="3" face="Verdana">UnMarried</font>
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align='right'>
							Category :
						</td>
						<td>
							<select name="category">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="General">
									<font size="3" face="Verdana">General</font>
								</option>
								<option value="SC">
									<font size="3" face="Verdana">SC</font>
								</option>
								<option value="ST">
									<font size="3" face="Verdana">ST</font>
								</option>
								<option value="OBC">
									<font size="3" face="Verdana">OBC</font>
								</option>

							</select>
						</td>
						<td align='right'>
							Religion :
						</td>
						<td>
							<select name="religion">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Muslim">
									<font size="3" face="Verdana">Muslim</font>
								</option>
								<option value="Hindu">
									<font size="3" face="Verdana">Hindu</font>
								</option>
								<option value="Christan">
									<font size="3" face="Verdana">Christan</font>
								</option>
								<option value="Christan">
									<font size="3" face="Verdana">Skih</font>
								</option>
								<option value="Christan">
									<font size="3" face="Verdana">Jain</font>
								</option>
								<option value="Christan">
									<font size="3" face="Verdana">Buddhist</font>
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<th colspan="6" bgcolor="white">
						<center>
							Contact Details
						</center>
					</th>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align='right'>
							Address Type :
						</td>
						<td>
							<select name="addressType" onChange="cleartext()">
								<option value="select" selected="true">
									<font size="3" face="Verdana">Select </font>
								</option>
								<option value="home">
									<font size="3" face="Verdana">Home</font>
								</option>
								<option value="office">
									<font size="3" face="Verdana">Hostel</font>
								</option>
								<option value="personal">
									<font size="3" face="Verdana">Personal</font>
								</option>
							</select>
						</td>
						<td width="120" align='right'>
							City :
						</td>
						<td width="273">
							<input type="text" name="city" value="" size="20" />
						</td>

					</tr>
					<tr>
						<td align='right'>
							House No :
						</td>
						<td>
							<input type="text" name="houseNo" value="" size="20" />
						</td>

						<td width="120" align='right'>
							District :
						</td>
						<td width="273">
							<input type="text" name="district" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Street :
						</td>
						<td>
							<input type="text" name="street" value="" size="20" />
						</td>
						<td align='right'>
							State :
						</td>
						<td>
							<input type="text" name="state" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Phone Type :
						</td>
						<td>
							<select name="phoneType">
								<option value="select" selected="true">
									<font size="3" face="Verdana">Select</font>
								</option>
								<option value="home">
									<font size="3" face="Verdana">Home</font>
								</option>
								<option value="office">
									<font size="3" face="Verdana">Office</font>
								</option>
								<option value="mobile">
									<font size="3" face="Verdana">Mobile</font>
								</option>
							</select>
						</td>
						<td align='right'>
							Country :
						</td>
						<td>
							<input type="text" name="country" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Phone No :
						</td>
						<td>
							<input type="text" name="phoneNo" value="" size="20"
								onBlur="ValidateForm()" />
						</td>
						<td align='right'>
							Pin :
						</td>
						<td>
							<input type="text" name="pin" value="" size="20"
								onChange="showStatus()" />
						</td>
					</tr>
					<th colspan="6" bgcolor="white">
						<center>
							Registration Fee Details
						</center>
					</th>
					<tr>
						<td align='center' colspan='4'>
							<font color='red'><b>If We are Entering Below Details
									wrong Your account Not activated..Please Enter Proper Data.</b> </font>
						</td>
					</tr>
					<tr>
						<td align='right'>
							Pay ment Mode :
						</td>
						<td>
							<select name="paymentmode">
								<option value="select" selected="true">
									<font size="3" face="Verdana">Select</font>
								</option>
								<option value="DemadDraft">
									<font size="3" face="Verdana">DemadDraft</font>
								</option>
								<option value="CashChalana">
									<font size="3" face="Verdana">CashChalana</font>
								</option>
								<option value="Check">
									<font size="3" face="Verdana">Check</font>
								</option>
							</select>
						</td>
						<td align='right'>
							Bank Name :
						</td>
						<td>
							<input type="text" name="bankname" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							DD/Check/chalana NO :
						</td>
						<td>
							<input type="text" name="ddno" value="" size="20" />
						</td>
						<td align='right'>
							Amount :
						</td>
						<td>
							<input type="text" name="amount" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
							<font size="3" face="Verdana"> <input type="submit"
									name="register" value="Register" />&nbsp; </font>
						</td>
						<td align="left">
							<font size="3" face="Verdana"> <input type="reset"
									name="cancel" value="Cancel" /> </font>
						</td>
						<td></td>
					</tr>
				</table>

			</form>

			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("register");

frmvalidator.addValidation("fullName", "req", "Please enter your Full Name");
frmvalidator.addValidation("fullName", "maxlen=20",
		"Max length for fullName is 20");
frmvalidator.addValidation("fullName", "alpha",
		" First Name Alphabetic chars only");
frmvalidator.addValidation("guardiantype", "dontselect=0");
frmvalidator.addValidation("nameguardian", "req", "Please enter Gurdian Name");
frmvalidator.addValidation("nameguardian", "maxlen=20", "Max length is 20");
frmvalidator.addValidation("nameguardian", "alpha",
		" Last Name Alphabetic chars only");
frmvalidator.addValidation("birthdate", "req", "Please enter your birthdate");
frmvalidator.addValidation("nationality", "alpha",
		" Last Name Alphabetic chars only");
frmvalidator.addValidation("gender", "dontselect=0");
frmvalidator.addValidation("email", "maxlen=50");
frmvalidator.addValidation("email", "req");
frmvalidator.addValidation("email", "email");
frmvalidator.addValidation("category", "dontselect=0");
frmvalidator.addValidation("photo", "req", "Please Load Your Photo");
frmvalidator.addValidation("maritalstatus", "dontselect=0");
frmvalidator.addValidation("religion", "dontselect=0");
frmvalidator.addValidation("addressType", "dontselect=0");

frmvalidator.addValidation("houseNo", "req", "Please enter your House Number");

frmvalidator.addValidation("street", "req", "Please enter your Street Number");
frmvalidator.addValidation("phoneType", "dontselect=0");
frmvalidator.addValidation("phoneNo", "req");

frmvalidator.addValidation("phoneNo", "maxlen=50");
frmvalidator.addValidation("phoneNo", "numeric");
frmvalidator.addValidation("phoneNo", "Phone");

frmvalidator.addValidation("city", "req", "Please enter your city Name");
frmvalidator.addValidation("state", "req", "Please enter your State Name");
frmvalidator.addValidation("country", "req", "Please enter your Country Name");
frmvalidator.addValidation("pin", "req", "Please enter your pin Number");

frmvalidator.addValidation("paymentmode", "dontselect=0");
frmvalidator.addValidation("bankname", "req", "Please enter your BankName");
frmvalidator.addValidation("password", "req", "Please enter your Password");
frmvalidator.addValidation("ddno", "req", "Please enter DD NUMBER");
frmvalidator.addValidation("amount", "numeric");
</script>

			<br />
			<br />

			<jsp:include page="Footer.jsp"></jsp:include>



		</body>
</html>