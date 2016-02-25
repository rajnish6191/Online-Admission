<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>stu nicholls dot com | menu - Professional dropdown #3</title>
		<meta name="Author" content="Stu Nicholls" />
		<link rel="stylesheet" type="text/css" href="menu/pro_dropdown_3.css" />
		<script src="menu/stuHover.js" type="text/javascript">
</script>
	</head>
	<body>
		<ul id="nav">
			<li class="top">
				<a href="./CollegeMagzine.jsp" id="products" class="top_link"><span>Magzine</span>
				</a>
			</li>
			<li class="top">
				<a href="#nogo2" id="Employee" class="top_link"><span
					class="down">Search</span> </a>

				<ul class="sub">

					<li>
						<span class="down"><a href="#nogo3">Student</a> </span>
						<ul>
							<li>
								<a href="./ViewBranchwiseStudentsAction">BranchWise</a>
							</li>
							<li>
								<a href="./StudentIdwiseAttendance.jsp">IDwise</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#nogo3">Staff</a>
						<ul>
							<li>
								<a href="./ViewDepartmentNameAction">Departmentwise</a>
							</li>
							<li>
								<a href="./EmployeeDatewiseSearch.jsp">yearwise</a>
							</li>
							<li>
								<a href="./EmployeeIdwiseSearch.jsp">EmployeeIDwise</a>
							</li>
						</ul>
					</li>

				</ul>


			</li>
			<li class="top">
				<a href="#nogo22" id="Departments" class="top_link"><span
					class="down">Departments</span> </a>
				<ul class="sub">

					<li>
						<a href="./viewDepartments">ViewDepartments</a>
					</li>

					<li>
						<a href="./ViewCoursesAction">ViewCourses</a>
					</li>

					<li>
						<a href="./ViewBranchesAction">viewBranches</a>
					</li>
				</ul>
			</li>

			<li class="top">
				<a href="#nogo22" id="Attendance" class="top_link"><span
					class="down">Attendance</span> </a>
				<ul class="sub">
					<li>
						<a href="#nogo3" class="fly">ViewAttendance</a>
						<ul>
							<li>
								<a href="./EmployeeTimeRecordForm.jsp">TimeRecord</a>
							</li>
							<li>
								<a href="./ViewAttendanceDepartment">Departmentwise</a>
							</li>
							<li>
								<a href="./EmployeeIdwiseAttendance.jsp">Employeewise</a>
							</li>
						</ul>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="Holidays" class="top_link"><span
					class="down">Holidays</span> </a>
				<ul class="sub">
					<li>
						<a href="./ViewHolidaysAction">ViewHolidays</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="leaves" class="top_link"><span
					class="down">Mails</span> </a>
				<ul class="sub">
					<li>
						<a href="./ComposeMail">Composemail</a>
					</li>
					<li>
						<a
							href="./OutboxAction?empid=<%=session.getAttribute("employeeid")%>&requesttype=inbox">Inbox</a>
					</li>
					<li>
						<a
							href="./OutboxAction?empid=<%=session.getAttribute("employeeid")%>&requesttype=outbox">Outbox</a>
					</li>
					<li>
						<a href="./Chat.jsp">chat</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Profile</span> </a>
				<ul class="sub">
					<li>
						<a
							href="./ViewProfileAction?employeeid=<%=session.getAttribute("employeeid")%>&requesttype=view">ViewProfile</a>
					</li>
					<li>
						<a
							href="./ViewProfileAction?employeeid=<%=session.getAttribute("employeeid")%>&requesttype=update">updateProfile</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">security</span> </a>
				<ul class="sub">
					<li>
						<a
							href="./Changepassword.jsp?userid=<%=session.getAttribute("employeeid")%>">changepassword</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="./LogoutAction" class="top_link"><span>Logout</span> </a>
			</li>
		</ul>
	</body>
</html>
