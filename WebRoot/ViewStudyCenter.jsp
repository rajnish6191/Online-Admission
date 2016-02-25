<%@ page language="java"
	import="java.util.*,com.admission.bean.ProgrammeTO"
	pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ProgrammeTO courseTO;
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

	<body><jsp:include page="Header.jsp"></jsp:include>
		<%
			Vector<ProgrammeTO> vcourse = (Vector<ProgrammeTO>) request
					.getAttribute("studycenters");
			Iterator it = vcourse.listIterator();
			while (it.hasNext()) {
				courseTO = (ProgrammeTO) it.next();
		%><center>
			<table>
				<tr>
					<td height='200' width="100">
						<img src="<%=courseTO.getLogo()%>" height='100' width='100'></img>
					</td>
					<td>
						<table>
							<tr>
								<td>
									<h3>
										<a
											href="./ViewStudyCenterProgrammes?centerid=<%=courseTO.getCenterid()%>&centerName=<%=courseTO.getCenterName()%>"><%=courseTO.getCenterName()%></a>
									</h3>
								</td>
							</tr>
							<tr>
								<td>
									<b> Location :<%=courseTO.getLocation()%> </b>
								</td>
							</tr>
							<tr>
								<td width='700'><%=courseTO.getCenterdesc()%></td>
							</tr>
						</table>
						<hr>
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
