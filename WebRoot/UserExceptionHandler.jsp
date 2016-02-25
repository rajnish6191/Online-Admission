<%@ page isErrorPage="true" import="java.io.*" %>
<%
 String usertype;
 %>

<head>
	<title>Exceptional Even Occurred!</title>
	<style>
	body, p { font-family:Tahoma; font-size:10pt;
        padding-left:30; }
	pre { font-size:8pt; }
	</style>
</head>
<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<center>
			<h1>
				NO DATA FOUND
			</h1>
		


<%
out.println("<!--");
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw);
//out.print(sw);
sw.close();
pw.close();
out.println("-->");
%>

</body>