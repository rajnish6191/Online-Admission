<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session.getAttribute("role") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<html>
	<head>
		<html xmlns="http://www.w3.org/1999/xhtml">
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<head id="ctl00_header">
				<head>
					<script src="multifile_compressed.js">
</script>
					<script>
function addElement_image() {
	var ni = document.getElementById('myDivImage');
	var numi = document.getElementById('theValue');
	var num = (document.getElementById('theValue').value - 1) + 2;
	numi.value = num;
	var newdiv = document.createElement('div');
	var divIdName = 'my' + num + 'DivImage';
	newdiv.setAttribute('id', divIdName);
	newdiv.innerHTML = '<td><p><input type="text" name="filename'
			+ num
			+ '"><input name="image[image_'
			+ num
			+ ']" type="file" value="Add" ><input name="ch" type="checkbox" id="checkbox2"	 value="image[image_'
			+ num + ']" checked/></td>';
	ni.appendChild(newdiv);
}

function removeElement_image(divNum) {
	var d = document.getElementById('myDivImage');
	var olddiv = document.getElementById(divNum);
	d.removeChild(divNum);
}</script>
				</head>
				<body>
					<jsp:include page="Header.jsp"></jsp:include>
					<form name='studycenterprogramme'
						action="./AddAdmissionDetailsAction" method='post'>
						<table cellspacing=2 align="center" bgcolor="27C2D0">

							<tr>
								<td align='right'>
									<b>Programme Names :</b>
								</td>
								<td>
									<select name="programmeid" id="select"
										onchange="javascript:if(document.studycenterprogramme.programmeid.value=='')
			{alert('Select First Programme');} 		 else
			{ location.href='./SelectProgrammeAdmissionStudent?programmeid='+document.studycenterprogramme.programmeid.value;}">
										<c:choose>
											<c:when test="${requestScope.programmename ne null}">
												<option value="${requestScope.programmeid}">
													${requestScope.programmename}
												</option>
												<c:if test="${not empty programmeTOs}">
													<option value="">
														--select--
													</option>
													<c:forEach var="programme" items="${programmeTOs}">
														<option
															value="${programme.programmeid},${programme.programmename}">
															${programme.programmename}
														</option>
													</c:forEach>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${not empty programmeTOs}">
													<option value="">
														--select--
													</option>
													<c:forEach var="programme" items="${programmeTOs}">
														<option
															value="${programme.programmeid},${programme.programmename}">
															${programme.programmename}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
						</table>
						<center>
							<h1>
								<font color='red'>Student Admission List</font>
							</h1>
						</center>
						<center>
							<table>
								<tr bgcolor='white'>
									<td align='center'>
										<b>FULL NAME</b>
									</td>
									<td align='center'>
										<b>D.O.B & R.D </b>
									</td>
									<td align='center'>
										<b>Other Details </b>
									</td>
									<td align='center'>
										<b>Photo</b>
									</td>
									<td align='center'>
										<b>Fee Details</b>
									</td>
									<td align='center'>
										<b>Status</b>
									</td>
								</tr>
								<c:forEach var="student" items="${vprogrammeTOs}">
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
											<a
												href='./ViewStudentCertificates?studentid=${student.studentid}&studentName=${student.fullName }&programmeid=${requestScope.programmeid}&programmename=${requestScope.programmename}'><b>${student.fullName
													}</b>
											</a>


										</td>

										<td>
											BirthDate :
											<b>${student.birthdate } <br>RegisteredDate :<b>${student.registereddate
													}</b>
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
											<b>${student.amount }<br> </b> FeeStatus :
											<b>${student.feeStatus}<br> </b>
										</td>
										<td>
											${student.counslingStatus}
										</td>
									</tr>
								</c:forEach>
							</table>
						</center>
						<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("studycenterprogramme");
frmvalidator.addValidation("studycenterseats", "maxlen=3");
</script>
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<jsp:include page="Footer.jsp"></jsp:include>
				</body>
		</html>