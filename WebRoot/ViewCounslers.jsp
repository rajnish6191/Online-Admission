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
			<font color='red'>Counselors</font>
		</h1>
	</center>

	<form name='deleteuser' action='./DeleteStudentsAction'>
		<center>
			<table>
				<tr bgcolor='thikblue'>
					<td>
					</td>
					<td align='center'>
						<b>FULL NAME</b>
					</td>
					<td align='center'>
						<b>Date of Birth </b>
						<b>Registered Date </b>
					</td>
					<td align='center'>
						<b>Email Id</b>
					</td>
					<td align='center'>
						<b>University MailId</b>
					</td>
					<td align='center'>
						<b>Address Details</b>
					</td>
					<td align='center'>
						<b>Contact Details</b>
					</td>
				</tr>

				<c:set var="color" value="0" scope="request" />
				<c:forEach var="counsler" items="${vectorCounslersProfileTOs}">
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
								onClick="check1()" value="${counsler.userid}" />
						</td>
						<td>
							<b>${counsler.fullName }</b>
						</td>
						<td>
							Date of Birth :
							<b>${counsler.birthdate }</b>
							</br>
							Date of Registration :
							<b>${counsler.registereddate }</b>
						</td>
						<td>
							Gender :
							<b>${counsler.gender }</b>
							<br>
							Email :
							<b>${counsler.email }</b>
							<br>
							UniversityMail :
							<b>${counsler.loginid }</b>
						</td>
						<td>
							<img src="${counsler.photo }" />
						</td>
						<td>
							AddressType :
							<b>${counsler.addressType }</b>
							<br>
							Hno :
							<b>${counsler.houseNo }</b>, DD NO : Street :
							<b>${counsler.street }</b>
							<br>
							City :
							<b>${counsler.city }<br> </b> District :
							<b>${counsler.district } </b> State :
							<b>${counsler.state }<br> </b> Pin :
							<b>${counsler.pin }<br> </b>
						</td>
						<td>
							PhoneNo :
							<b>${counsler.phoneType }</b>
							<br>
							PhoneType :
							<b>${counsler.phoneNo }</b>
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
	<jsp:include page="./Footer.jsp"></jsp:include>
	</body>
</html>
