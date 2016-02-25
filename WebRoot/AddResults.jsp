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
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<form action="./AddResultAction" method='get' name='result'>
			<center>
				<h3>
					<font color='red'>Post Results From here</font>
				</h3>
				<table>
					<tr>
						<td>
							<b>Result Name :</b>
						</td>
						<td>
							<input type="text" name="result" value="" />
						</td>
					</tr>
					<tr>
						<td>
							<b>Result File :</b>
						</td>
						<td>
							<input type="file" name="resultfile" value="" />
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
	</body>
</html>
