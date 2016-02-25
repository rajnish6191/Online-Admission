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
		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<form action="./AddUniversityNewsAction" method='post' name='news'>
			<center>
				<h3>
					<font color='red'>Post News From here</font>
				</h3>
				<table>
					<tr>
						<td>
							<b>News Type :</b>
						</td>
						<td>
							<select name='newstype'>
							<option value=''>
									--SELECT--
								</option>
								<option value='Counselling'>
									Counselling
								</option>
								<option value='ExamTimeTables'>
									ExamTimeTables
								</option>
								<option value='AdminssionAlerts'>
									AdminssionAlerts
								</option>
								<option value='News'>
									News
								</option>
								<option value='Others'>
									Others
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<b>News Header :</b>
						</td>
						<td>
							<input type="text" name="newsHeader" value="" />
						</td>
					</tr>
					<tr>
						<td>
							<b>News Images :</b>
						</td>
						<td>
							<input type="file" name="newsImage" value="" />
						</td>
					</tr>
					<tr>
						<td>
							<b>News Information File :</b>
						</td>
						<td>
							<input type="file" name="newsInformation" value="" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							<input type="submit" name="Send" value="Send" />
						</td>
						<td>
							<input type="reset" name="Reset" value="Reset" />
						</td>
					</tr>
				</table>
			</center>
			<br>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("news");
frmvalidator.addValidation("newstype", "dontselect=0");
frmvalidator.addValidation("newsHeader", "req", "please Enter News HEADER");
frmvalidator.addValidation("newsImage", "req", "please select News File");
frmvalidator.addValidation("newsInformation", "req",
		"please select News Inforamtion");
</script>
	</body>
</html>
