<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ViewStudents.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<jsp:include page="Header.jsp"></jsp:include>
	<center>
		<h1>
			<font color='red'> List of Students</font>
		</h1>
	</center>

	<form name='deleteuser' action='./DeleteStudentsAction'>
		<center>
			<table>
				<tr bgcolor='white'>
					<td>
					</td>
					<td align='center'>
						<b>FULL NAME</b>
					</td>
					<td align='center'>
						<b>GUARDIAN </b>
					</td>
					<td align='center'>
						<b>Date of Birth </b>
					</td>
					<td align='center'>
						<b>Registered Date </b>
					</td>
					<td align='center'>
						<b>Other Details </b>
					</td>
					<td align='center'>
						<b>Email Id</b>
					</td>
					<td align='center'>
						<b>University MailId</b>
					</td>
					<td align='center'>
						<b>Fee Details</b>
					</td>
					<td align='center'>
						<b>Address Details</b>
					</td>
					<td align='center'>
						<b>Contact Details</b>
					</td>
					<td align='center'>
						<b>Status</b>
					</td>
				</tr>

				<c:set var="color" value="0" scope="request" />
				<c:forEach var="student" items="${vectorStudentProfileTOs}">
					<tr>
						<c:choose>
							<c:when test="${requestScope.color eq '0'}">
								<tr bgcolor='white'>
									<c:set var="color" value="${color+1}" scope="request" />
							</c:when>

							<c:otherwise>
								<tr bgcolor='skyblue'>
									<c:set var="color" value="${color-1}" scope="request" />
							</c:otherwise>
						</c:choose>
						<td>
							<input name="ch" type="checkbox" id="checkbox2"
								onClick="check1()" value="${student.userid}" />
						</td>
						<td>
							<b>${student.fullName }</b>
						</td>
						<td>
							<b>${student.guardiantype } of <br>${student.nameguardian
								}</b>
						</td>
						<td>
							<b>${student.birthdate }</b>
						</td>
						<td>
							<b>${student.registereddate }</b>
						</td>
						<td>
							Nationality :
							<b>${student.nationality }</b>
							<br>
							MaritalStatus :
							<b>${student.maritalstatus }</b>
							<br>
							Category :
							<b>${student.category }</b>
							<br>
							Religion :
							<b>${student.religion }<br> </b>
						</td>
						<td>
							Gender :
							<b>${student.gender }</b> Email :
							<b>${student.email }</b>
						</td>
						<td>
							<img src="${student.photo }" />
						</td>
						<td>
							BankName :
							<b>${student.bankname }</b>
							<br>
							PayMentMode :
							<b>${student.paymentmode }</b>
							<br>
							DD NO :
							<b>${student.ddno }</b>
							<br>
							Amount :
							<b>${student.amount }<br> </b>
						</td>
						<td>
							AddressType :
							<b>${student.addressType }</b>
							<br>
							Hno :
							<b>${student.houseNo }</b>, DD NO : Street :
							<b>${student.street }</b>
							<br>
							City :
							<b>${student.city }<br> </b> District :
							<b>${student.district } </b> State :
							<b>${student.state }<br> </b> Pin :
							<b>${student.pin }<br> </b>
						</td>
						<td>
							PhoneNo :
							<b>${student.phoneType }</b>
							<br>
							PhoneType :
							<b>${student.phoneNo }</b>
						</td>
						<td>
							<a href="./UpdateStudentStatusAction?userid=${student.userid}"><b>${student.status
									}<b>
							</a>
							<b></b>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td align='center' colspan='8'>
						<input type="submit" value="Delete" />
					</td>
				</tr>
			</table>
		</center>
	</form>
	<jsp:include page="/Footer.jsp"></jsp:include>
	</body>
</html>
