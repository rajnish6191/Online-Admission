<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = 0;
%>
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
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<form name='company' method='post' action='DeleteHolidays'>
				<table>
					<tr bgcolor='white'>
						<td></td>
						<td align='center'>
							<b>Sno</b>
						</td>

						<td align='center' width='200'>
							<b>Name of Holiday</b>
						</td>
						<td align='center' width='100'>
							<b>Date</b>
						</td>
						<td align='center' width='100'>
							<b>Day</b>
						</td>
					</tr>

					<c:forEach var="company" items="${companyholidays}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'Admin'}">
									<td>
										<input name="ch" type="checkbox" id="checkbox2"
											onClick="check1()" value="${company.hoiidayId }" />
									</td>
								</c:when>

								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${sessionScope.role eq 'Admin'}">
									<td align='center'>
										<b><a
											href="./ViewUpdateHoliday?holiday=${company.hoiidayId }">${company.hoiidayId
												}</a> </b>
									</td>

								</c:when>

								<c:otherwise>
									<td align='center'>
										<b>${company.hoiidayId }</b>
									</td>
								</c:otherwise>
							</c:choose>
							<td align='center'>
								<b> ${company.holidayName } 
							</td>
							<td align='center'>
								<b> ${company.holidaydate}</b>
							</td>
							<td align='center'>
								<b> ${company.day}</b>
							</td>
						</tr>
					</c:forEach>
					<tr>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${sessionScope.role eq 'Admin'}">
								<td>
								<td align='center' colspan='8'>
									<input type="submit" value="Delete" />
								</td>
							</c:when>
						</c:choose>
					</tr>
				</table>

			</form>
		</center>
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
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
