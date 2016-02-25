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
	<head>
		<
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head id="ctl00_header">
	<head>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js">
</script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>

	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<h2>
			List of Students
			</h2>
		</center>
		<center>
			<table border='1'>
				<tr bgcolor='white' >
					<td align='center'>
						<b>StudentNo</b>
					</td>
					<td align='center' width='200'>
						<b>Name of Student</b>
					</td>
				</tr>
				<c:forEach var="student" items="${studentsnames}">
					<tr>
						<td align='center'>
							<b> ${student.studentno } 
						</td>
						<td align='center'>
							<b> ${student.studentName}</b>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
