package com.admission.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;

public class StudyCenterAllotedmentAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		boolean flag = false;
		try {
			flag = new ProgrammeDelegate().studyCenterAlllotement(Integer
					.parseInt(request.getParameter("studentid")), Integer
					.parseInt(request.getParameter("programmeid")), Integer
					.parseInt(request.getParameter("centerid")));
			if (flag) {
				request.setAttribute("status",
						UtilConstants._STUDY_CENTER_ALLOTMENT);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._STUDY_CENTER_NOT_ALLOTMENT);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			request.setAttribute("status",
					UtilConstants._STUDY_CENTER_NOT_ALLOTMENT);
			path = UtilConstants._STATUS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
