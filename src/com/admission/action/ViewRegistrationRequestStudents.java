package com.admission.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admission.bean.StudentProfileTO;
import com.admission.delegate.SecurityUserDelegate;
import com.admission.util.UtilConstants;

public class ViewRegistrationRequestStudents extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Vector<StudentProfileTO> vectorStudentProfileTOs;
		String target = "";
		String requestedStudent = request.getParameter("studenttype");
		try {
			vectorStudentProfileTOs = new SecurityUserDelegate().viewStundents(
					requestedStudent, request.getRealPath("./images"));
			if (!vectorStudentProfileTOs.isEmpty()) {
				request.setAttribute("vectorStudentProfileTOs",
						vectorStudentProfileTOs);
				target = UtilConstants._VIEW_STUDENTS_DETAILS;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_STUDENTS_DETAILS_FAIL);
				target = UtilConstants._VIEW_STUDENTS_DETAILS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status",
					UtilConstants._VIEW_STUDENTS_DETAILS_FAIL);
			target = UtilConstants._VIEW_STUDENTS_DETAILS;
		}
		rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
