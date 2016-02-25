<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.admission.bean.ProgrammeTO;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int sno = 0;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'StudentDocumentForm.jsp' starting page</title>

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
			<form name='certificates' action='./CertificatesVerificationaction'>
				<table>
					<tr>
						<td>
							<b>Student Name :</b>
						</td>
						<td>
							a
							<b><c:out value="${requestScope.studentName}"></c:out> </b>
						</td>
						<td>
							<b>Programme Name :</b>
						</td>
						<td>
							ad
							<b> </b>
						</td>
					</tr>
				</table>
				<table border='1'>
					<tr>
						<td>
							SNo
						</td>
						<td>
							CertificateId
						</td>
						<td>
							CertificateName
						</td>
						<td>
							Status
						</td>
						<td>
							select Option
						</td>
					</tr>

					<%
						Vector c = (Vector) request.getAttribute("studyCertificates");
						Iterator it = c.listIterator();
						Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
						while (it.hasNext()) {
							ProgrammeTO programmeTO = (ProgrammeTO) it.next();
							ProgrammeTO programmeTO2 = new ProgrammeTO();
					%>
					<tr>
						<td><%=++sno%></td>
						<td>
							<%=programmeTO.getStudocId()%>
							<%
								programmeTO2.setStudocId(programmeTO.getStudocId());
							%>
						</td>
						<td>
							<a href='<%=programmeTO.getQualificationmemofile()%>'><%=programmeTO.getQualificationname()%></a>
						</td>
						<td>
							<%=programmeTO.getDocstatus()%>
							<%
								programmeTO2.setDocstatus(programmeTO.getDocstatus());
							%>
						</td>
						<td>
							<select name='docstatus_<%=sno%>'>
								<option value='<%=programmeTO.getDocstatus()%>'>
									<%=programmeTO.getDocstatus()%>
								</option>
								<option value='Verified'>
									Verified
								</option>
								<option value='NotVerified'>
									NotVerified
								</option>
								<option value='Pending'>
									Pending
								</option>
								<option value='ReVerify'>
									ReVerify
								</option>
								<option value='ManualVerify'>
									ManualVerify
								</option>
							</select>
						</td>
					</tr>
					<%
						programmeTOs.add(programmeTO2);
						}
						session.setAttribute("programmeTOs", programmeTOs);
					%>
					<input type='hidden' name='sno' value='<%=sno%>' />
					<tr>
						<td colspan='4' align='center'>
							<input type='submit' value='submit' />
						</td>
					</tr>
				</table>
			</form>
		</center>
		<form action="./StudyCenterAllotedmentAction">
			<%
				if (!request.getAttribute("programmeTOs").equals(null)) {
			%>
			<center>
				<table border='1'>
					<tr>
						<td></td>
						<td align='center'>
							<b>StudyCenterName</b>
						</td>
						<td>
							<b>StudyCenterCode</b>
						</td>
						<td>
							<b>DateofSelected</b>
						</td>
						<td>
							<b>No of Seats</b>
						</td>
					</tr>
					<%
						Vector c1 = (Vector) request.getAttribute("programmeTOs");
							Iterator it1 = c1.listIterator();
							Vector<ProgrammeTO> programmeTOs1 = new Vector<ProgrammeTO>();
							if (it1.hasNext()) {
								ProgrammeTO programmeTO = (ProgrammeTO) it1.next();
								ProgrammeTO programmeTO2 = new ProgrammeTO();
					%>
					<tr>
						<td>
							<input type='radio' name='centerid'
								value='<%=programmeTO.getCenterid1()%>'>
						</td>
						<td><%=programmeTO.getCenterName1()%></td>
						<td><%=programmeTO.getCentercode1()%></td>
						<td><%=programmeTO.getDateofcollegeselected()%></td>
						<td><%=programmeTO.getSeats1()%></td>
					</tr>
					<tr>
						<td>
							<input type='radio' name='centerid'
								value='<%=programmeTO.getCenterid2()%>'>
						</td>
						<td><%=programmeTO.getCenterName2()%></td>
						<td><%=programmeTO.getCentercode2()%></td>
						<td><%=programmeTO.getDateofcollegeselected()%></td>
						<td><%=programmeTO.getSeats2()%></td>
					</tr>
					<tr>
						<td>
							<input type='radio' name='centerid'
								value='<%=programmeTO.getCenterid3()%>'>
						</td>
						<td><%=programmeTO.getCenterName3()%></td>
						<td><%=programmeTO.getCentercode3()%></td>
						<td><%=programmeTO.getDateofcollegeselected()%></td>
						<td><%=programmeTO.getSeats3()%></td>
					</tr>
					<tr>
						<td colspan='5' align='center'>
							<input type='submit' value='Allotment'>
						</td>
					</tr>
				</table>
				<%
					}
					}
				%>
				<input type='hidden' name='studentid'
					value='<%=request.getAttribute("studentid")%>'>
				<input type='hidden' name='programmeid'
					value='<%=request.getAttribute("programmeid")%>'>
			</center>
		</form>
		<br>
	</body>
</html>
