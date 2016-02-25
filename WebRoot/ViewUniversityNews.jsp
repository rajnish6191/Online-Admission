<%@ page language="java"
	import="java.util.*,com.admission.bean.UniversityTO"
	pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	UniversityTO universityTO;
	Vector<UniversityTO> vcourse;
	Iterator it;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ViewStudyCenter.jsp' starting page</title>

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
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<table height='500' width='900' border='3' bgcolor='white'>
				<tr>
					<td>
						<h2>
							<center>
								<font color='green'>Counselling NEWS</font>
							</center>
						</h2>
						<%
							vcourse = (Vector<UniversityTO>) request
									.getAttribute("vUniversityTOs");
							it = vcourse.listIterator();
							while (it.hasNext()) {
								universityTO = (UniversityTO) it.next();
								if (universityTO.getNewstype().equals("Counselling")) {
						%><h3>
							*
							<a href="<%=universityTO.getNewsInformation()%>"><%=universityTO.getNewsHeader()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<b><%=universityTO.getNewsdate()%> </b>
						</h3>
						<%
							}
							}
						%>

					</td>
					<td>
						<h2>
							<center>
								<font color='green'>AdminssionAlerts NEWS</font>
							</center>
						</h2>
						<%
							vcourse = (Vector<UniversityTO>) request
									.getAttribute("vUniversityTOs");
							it = vcourse.listIterator();
							while (it.hasNext()) {
								universityTO = (UniversityTO) it.next();
								if (universityTO.getNewstype().equals("AdminssionAlerts")) {
						%><h3>
							*
							<a href="<%=universityTO.getNewsInformation()%>"><%=universityTO.getNewsHeader()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<b><%=universityTO.getNewsdate()%> </b>
						</h3>
						<%
							}
							}
						%>

					</td>
				</tr>
				<tr>
					<td>
						<h3>
							<center>
								<font color='green'>ExamTimeTablesNEWS</font>
							</center>
							</h2>
							<%
								vcourse = (Vector<UniversityTO>) request
										.getAttribute("vUniversityTOs");
								it = vcourse.listIterator();
								while (it.hasNext()) {
									universityTO = (UniversityTO) it.next();
									if (universityTO.getNewstype().equals("ExamTimeTables")) {
							%><h3>
								*
								<a href="<%=universityTO.getNewsInformation()%>"><%=universityTO.getNewsHeader()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b><%=universityTO.getNewsdate()%> </b>
							</h3>
							<%
								}
								}
							%>
						
					</td>
					<td>
						<h3>
							<center>
								<font color='green'> Other NEWS</font>
							</center>
							</h2>
							<%
								vcourse = (Vector<UniversityTO>) request
										.getAttribute("vUniversityTOs");
								it = vcourse.listIterator();
								while (it.hasNext()) {
									universityTO = (UniversityTO) it.next();
									if (universityTO.getNewstype().equals("Other")
											|| universityTO.getNewstype().equals("News")) {
							%><h3>
								*
								<a href="<%=universityTO.getNewsInformation()%>"><%=universityTO.getNewsHeader()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b><%=universityTO.getNewsdate()%> </b>
							</h3>
							<%
								}
								}
							%>
						
					</td>
				</tr>

			</table>
		</center>
		<br>
	</body>
</html>
