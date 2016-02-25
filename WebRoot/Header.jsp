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
		<script type="text/javascript" src="scripts/curser.js">
</script>

		<title>My JSP 'Header.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body bgcolor='27C2D0'>
		<img src="./images/jobs-banner1.jpg" align='top' height='220' width='970'>
		<c:choose>
			<c:when test="${sessionScope.role eq 'Admin'}">
				<jsp:include page="./AdminMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'Counselor'}">
				<jsp:include page="./CounselorsMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'Student'}">
				<jsp:include page="./StudentMenu.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="HomeMenu.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>


		<br />
		<br />

		<center>
			<font color="red"><b> <c:if
						test="${requestScope.status!='null'}">

						<c:out value="${requestScope.status}"></c:out>
					</c:if> </b> </font>

		</center>
	</body>
</html>
