<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

		<title>My JSP 'Example.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table cellpadding="0" cellspacing="0" width="660" border="0"
			class="examResultsTable">
			<tr>
				<th width="390">
					Results
				</th>
				<th width="127">
					Status
				</th>
				<th width="141">
					Release Date
				</th>
			</tr>
			<tr class="resultEvenRow">
				<td class="courseResultText">
					<a href="/results/kar/sslc-supplementary-2012/">Karnataka SSLC
						Supplementary Results 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					12 July 2012
				</td>
			</tr>
			<tr class="resultEvenRow">
				<td class="courseResultText">
					<a href="/results/tn/sslc-2012/">Tamil Nadu SSLC Results 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					4 June 2012
				</td>
			</tr>
			<tr class="resultOddRow">
				<td class="courseResultText">
					<a href="/results/ap/ssc-2012/">Andhra Pradesh SSC Results 2012<a />
				</td>
				<td>
					Declared
				</td>
				<td>
					24 May 2012
				</td>
			</tr>
			<tr class="resultEvenRow">
				<td class="courseResultText">
					<a href="/results/kar/puc-2012/">Karnataka PUC Results 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					23 May 2012
				</td>
			</tr>
			<tr class="resultOddRow">
				<td class="courseResultText">
					<a href="/results/tn/plustwo-2012/">Tamil Nadu Plus two
						Results 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					22 May 2012
				</td>
			</tr>

			<tr class="resultEvenRow">
				<td class="courseResultText">
					<a href="/results/kar/sslc-2012/">Karnataka SSLC Results 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					17 May 2012
				</td>
			</tr>

			<tr class="resultOddRow">
				<td class="courseResultText">
					<a href="/results/ap/inter-second-year-2012/">AP Inter Second
						Year 2012</a>
				</td>
				<td>
					Declared
				</td>
				<td>
					24 April 2012
				</td>
			</tr>


			<tr class="resultEvenRow">
				<td class="courseResultText">
					ICSE (Class X and XII) 2012
				</td>
				<td>
					Awaited
				</td>
				<td>
					-
				</td>
			</tr>

			<tr class="resultOddRow">
				<td class="courseResultText">
					CBSE (Class XII) 2012
				</td>
				<td>
					Awaited
				</td>
				<td>
					-
				</td>
			</tr>

			<tr class="resultEvenRow">
				<td class="courseResultText">
					CBSE (Class X) 2012
				</td>
				<td>
					Awaited
				</td>
				<td>
					-
				</td>
			</tr>



		</table>
		<br>
	</body>
</html>
