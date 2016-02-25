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

public class ViewStudentCertificates extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		System.out.println("haiiiiiiiiii");
		Vector<ProgrammeTO> programmeTOs = null;
		Vector<ProgrammeTO> studyCertificates = null;
		try {
			programmeTOs = new ProgrammeDelegate()
					.viewStudentSelectStudyCenters(Integer.parseInt(request
							.getParameter("studentid")), Integer
							.parseInt(request.getParameter("programmeid")));
			studyCertificates = new ProgrammeDelegate().viewStudyCertificates(
					request.getRealPath("./images"), Integer.parseInt(request
							.getParameter("studentid")));
			if (!programmeTOs.isEmpty() && !studyCertificates.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_STUDENT_CERTIFICATES);
				request.setAttribute("studentid", request
						.getParameter("studentid"));
				request.setAttribute("programmeid", request
						.getParameter("programmeid"));
				request.setAttribute("studentName", request
						.getParameter("studentName"));
				request.setAttribute("programmename", request
						.getParameter("programmename"));
				request.setAttribute("programmeTOs", programmeTOs);
				request.setAttribute("studyCertificates", studyCertificates);
				path = UtilConstants._STUDENT_DOCUMENT_FORM;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
				path = UtilConstants._STUDENT_DOCUMENT_FORM;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",
					UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
			path = UtilConstants._STUDENT_DOCUMENT_FORM;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
