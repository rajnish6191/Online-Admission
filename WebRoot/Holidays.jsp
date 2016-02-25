
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session.getAttribute("role") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<html>
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

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<b><h4>
					Add Holidays Form
				</h4> </b>
		</center>
		<form method='post'
			action="<%=request.getContextPath() + "/SetHolidaysAction"%>"
			name="holiday">
			<table cellspacing=2 align="center" bgcolor="27C2D0">

				<tr>
					<td align='right'>
						<b>Career HolidayName :</b>
					</td>
					<td>
						<input type='text' name='holidayName'>
					</td>
					<tr>
						<td align='right'>
							<b>Date of Holiday :</b>
						</td>
						<td>
							<input type="text" name="holidaydate" value="" size="20"
								readonly="readonly" />
							<a
								href="javascript:show_calendar('document.holiday.holidaydate', document.holiday.holidaydate.value);">
								<img src="images/cal.gif" alt="a" width="18" height="18"
									border="0" /> </a>
						</td>
						<tr>
							<td align='right'>
								<b> Day of Holiday :</b>
							</td>
							<td>
								<select name="day" onChange="cleartext()">
									<option value="select" selected="true">
										<font size="3" face="Verdana">Select </font>
									</option>
									<option value="Sunday">
										<font size="3" face="Verdana">Sunday</font>
									</option>
									<option value="Monday">
										<font size="3" face="Verdana">Monday</font>
									</option>
									<option value="Tuesday">
										<font size="3" face="Verdana">Tuesday</font>
									</option>
									<option value="Wednesday">
										<font size="3" face="Verdana">Wednesday</font>
									</option>
									<option value="Thursday">
										<font size="3" face="Verdana">Thursday</font>
									</option>
									<option value="Friday">
										<font size="3" face="Verdana">Friday</font>
									</option>
									<option value="Saterday">
										<font size="3" face="Verdana">Saterday</font>
									</option>
								</select>
							</td>
						</tr>

						<tr>
							<td align='right'>
								<input type='submit' name=submit value='Add'>
							</td>
							<td align='left'>
								<input type='reset' name=Reset value='Reset'>
							</td>
						</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("holiday");
frmvalidator.addValidation("holidayName", "req", "Enter Name of the Holiday");
frmvalidator.addValidation("holidaydate", "req", "select date of the Holiday");
frmvalidator.addValidation("day", "req", "please select Day of the Holiday");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
