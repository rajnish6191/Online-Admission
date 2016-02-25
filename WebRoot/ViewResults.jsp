<%@ page language="java"
	import="java.util.*,com.admission.bean.ProgrammeTO"
	pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	ProgrammeTO courseTO;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ViewResults.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body><jsp:include page="Header.jsp"></jsp:include>
		<center>
				<table border='2' bordercolor='green'>
					<tr>
						<th width="390">
							<h3>
								Results
							</h3>
						</th>
						<th width="127">
							<h3>
								Status
							</h3>
						</th>
						<th width="141">
							<h3>
								Release Date
							</h3>
						</th>
					</tr>
					<%
						Vector<ProgrammeTO> vcourse = (Vector<ProgrammeTO>) request
								.getAttribute("results");
						Iterator it = vcourse.listIterator();
						while (it.hasNext()) {
							courseTO = (ProgrammeTO) it.next();
					%>
					<tr>
						<td class="courseResultText">
							<blink>
								<h2>
									<a href="<%=courseTO.getResultfile()%>"><font color='red'><%=courseTO.getResult()%></font>
									</a>
								</h2>
							</blink>
						</td>
						<td>
							<b><font color=''><%=courseTO.getStatus()%></font> </b>
						</td>
						<td>
							<b><font color=''><%=courseTO.getResultdate()%></font> </b>
						</td>
					</tr>
					<%
						}
					%>
				</table>
				</center>
				<br>
	</body>
</html>
