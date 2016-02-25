<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
	<base href="<%=basePath%>">

	<title>My JSP 'index.jsp' starting page</title>
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
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
		<table>
			<tr>
				<td>
					<b>Our Oracle Environment<b><br>
			<tr>
				<td>
					&nbsp&nbsp * Business Intelligence
					<br>
			<tr>
				<td>
					&nbsp&nbsp * Idhasoft SAP Advantage
					<br>
			<tr>
				<td>
					&nbsp&nbsp * iHMiS SAP IS-H
					<br>
			<tr>
				<td>
					&nbsp&nbsp * Mobile Solutions
					<br>
				</td>
			</tr>
						<tr>
				<td>
					<br><b>Strategic Solutions</b>
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp * FourthQuadrant Value Channel Strategy
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp * Supply Chain Solutions
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp * Content Management Solutions
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp * Portal Solutions
					<br>
				</td>
			</tr>
			<br>
			<br>
				<b>SAP Solutions</b>
			<br>
			<br>
						<tr>
				<td>
					&nbsp&nbsp* Business All-in-One
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp* BusinessObjects BI OnDemand
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp* BusinessObjects Edge
					<br>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp&nbsp* Crystal Solutions
					<br>
				</td>
			</tr>
		</table>
		<jsp:include page="Footer.jsp"></jsp:include>
</body>