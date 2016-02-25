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
			{ location.href='./ViewProgrammeeStudycenters?programmeid='+document.studycenterprogramme.programmeid.value;}">
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


							<tr>
								<td align='right'>
									<b>Select Center Name1 :</b>
								</td>
								<td>
									<select name="centerid1" id="select">
										<c:choose>
											<c:when test="${studyCenters ne null}">


												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>

											</c:when>
											<c:otherwise>
												<option value="">
													--SELECT--
												</option>
												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>

							<tr>
								<td align='right'>
									<b>Select Center Name2 :</b>
								</td>
								<td>
									<select name="centerid2" id="select">
										<c:choose>
											<c:when test="${studyCenters ne null}">


												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>

											</c:when>
											<c:otherwise>
												<option value="">
													--SELECT--
												</option>
												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
							<tr>
								<td align='right'>
									<b>Select Center Name3 :</b>
								</td>
								<td>
									<select name="centerid3" id="select">
										<c:choose>
											<c:when test="${studyCenters ne null}">
												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>
											</c:when>
											<c:otherwise>
												<option value="">
													--SELECT--
												</option>
												<c:if test="${not empty studyCenters}">
													<c:forEach var="programme" items="${studyCenters}">
														<option value="${programme.centerid}">
															${programme.centerName}--${programme.centercode}
														</option>
													</c:forEach>
												</c:if>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</tr>
							<tr>
								<td align='right'>
									Student Certificates :
								</td>
								<td>
									<input type="button" id="add_more" value="Add More"
										onclick="addElement_image();" />

									<input type="hidden" value="0" id="theValue" />
									<div id="myDivImage"></div>
								</td>
							</tr>
							<tr>
								<td align='right'>
									<input type="submit" value="submit" />
								</td>
								<td align='left'>
									<input type="reset" value="clear" />
								</td>
							</tr>
						</table>
					</form>
					<center>

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