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
						type="text/javascript">
</script>


					<script type="text/javascript" src="scripts/general.js">
</script>
					<script type="text/javascript" src="scripts/adi.js">
</script>
					<script type="text/javascript" src="scripts/form_validation.js">
</script>

					<script language="JavaScript" src="images/javascripts.js">
</script>
				</head>
				<body>
					<jsp:include page="Header.jsp"></jsp:include>
					<form name='studycenterprogramme'
						action="./AddStudyCenterProgrammesAction" method='post'>
						<table cellspacing=2 align="center" bgcolor="27C2D0">
							<tr>
								<td align='right'>
									<b>Study Center Name :</b>
								</td>
								<td>
									<select name="centerid" id="select">
										<c:choose>
											<c:when test="${studyCenters ne null}">


												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>

											</c:when>
											<c:otherwise>
												<option value="">
													--SELECT--
												</option>
												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
							<tr>
								<td align='right'>
									<b>Programme Names :</b>
								</td>
								<td>
									<select name="programmeid" id="select">
										<c:choose>
											<c:when test="${programmeTOs ne null}">
												<c:if test="${not empty programmeTOs}">
													<c:forEach var="programme" items="${programmeTOs}">
														<option value="${programme.programmeid}">
															${programme.programmename}
														</option>
													</c:forEach>
												</c:if>
											</c:when>
											<c:otherwise>
												<option value="">
													--SELECT--
												</option>
												<c:if test="${not empty programmeTOs}">
													<c:forEach var="programme" items="${programmeTOs}">
														<option value="${programme.programmeid}">
															${programme.programmename}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
							<tr>
								<td align='right'>
									<b>Seats :</b>
								</td>
								<td>
									<input type='text' name='studycenterseats'>
								</td>
							</tr>

							<tr>
								<td align='right'>
									<input type="submit" value="submit" />
								</td>
								<td align='left'>
									<input type="reset" value="clear" />
								</td>
							</tr>
						</table>
					</form>
					<center>

					</center>
					<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("studycenterprogramme");
frmvalidator.addValidation("studycenterseats", "maxlen=3");
</script>
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<jsp:include page="Footer.jsp"></jsp:include>
				</body>
		</html>