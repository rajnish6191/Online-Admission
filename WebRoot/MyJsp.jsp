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

		<title>My JSP 'MyJsp.jsp' starting page</title>

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
		<div class="rightSeperator"></div>
		<!-- What After 12th Block -->
		<div id="whatAfter12Block">
			<div id="whatAfterTopCurve"></div>
			<div id="whatAfterContentOuter">
				<div id="wahtAfterContent">
					<div id="eduafter_frm_msg"></div>
					<div class="heading2">
						Login Here
					</div>

					<form method="post"
						action="http://lists1.oneindia.in/cgi-bin/useradd.pl"
						name="newsletter_subscribeform">
						<table cellpadding="0" cellspacing="0" width="280" border="0">
							<tr>
								<td class="textField">
									Name:
									<span class="mandatory">*</span>
								</td>
								<td class="textFieldBox">
									<input type="text" name="edu_name" id="edu_name"
										class="textBox" />
								</td>
							</tr>


							<tr>
								<td class="textField">
									Email:
									<span class="mandatory">*</span>
								</td>
								<td class="textFieldBox">
									<input type="text" name="email" id="email" class="textBox" />
								</td>
							</tr>

							<tr>
								<td class="textField">
									<input type="image" name="submit"
										src="/images/users/submitBtn.jpg"
										onclick="javascript:return validateEdu();" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<div id="whatAfterBottomCurve"></div>

		</div>
		<br>
	</body>
</html>
