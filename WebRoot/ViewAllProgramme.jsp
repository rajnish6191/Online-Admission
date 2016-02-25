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
			
			<table cellpadding="0" cellspacing="0" border="1"
				class="examResultsTable">
				<tr color='dfda'>
					<th>
						<h3>
							ProgrammeName
						</h3>
					</th>
					<th>
						<h3>
							Type
						</h3>
					</th>
					<th>
						<h3>
							Duration
						</h3>
					</th>
					<th>
						<h3>
							Description
						</h3>
					</th>
					<th>
						<h3>
							Min&Max age
						</h3>
					</th>
					<th>
						<h3>
							Eligibility
						</h3>
					</th>

				</tr>
				<%
					Vector<ProgrammeTO> vcourse = (Vector<ProgrammeTO>) request
							.getAttribute("vProgrammeTOs");
					Iterator it = vcourse.listIterator();
					while (it.hasNext()) {
						courseTO = (ProgrammeTO) it.next();
				%>
				<tr>
					<td width='250'>
						<blink>
							<h2>
								<a href="<%=courseTO.getProgrammefile()%>"><font color='red'><%=courseTO.getProgrammename()%></font>
								</a>
							</h2>
						</blink>
					</td>
					<td width='50'>
						<b><font color=''><%=courseTO.getProgrammetype()%></font> </b>
					</td>
					<td width='100'>
						<b><font color=''><%=courseTO.getProgrammeduration()%></font>
						</b>
					</td>
					<td width='600'>
						<b><font color=''><%=courseTO.getProgrammedesc()%></font> </b>
					</td>
					<td width='300'>
						<b><font color=''>Minimun age :<%=courseTO.getMinage()%><br>Maximun
								age :<%=courseTO.getMaxage()%></font> </b>
					</td>
					<td width='250'>
						<b><font color=''><%=courseTO.getEligible()%></font> </b>
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
