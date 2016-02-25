package com.admission.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.UniversityTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.exception.ConnectionException;
import com.admission.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddAdmissionDetailsAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		int j;
		ProgrammeTO ProgrammeTO = new ProgrammeTO();
		boolean flag1 = false;
		boolean flag2 = false;
		String path = "";
		int studentid = (Integer) session.getAttribute("userid");
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(ProgrammeTO, map);
			ProgrammeTO.setStudentid(studentid);
			flag1 = new ProgrammeDelegate().addSelectStudyCenters(ProgrammeTO);

			if (!request.getParameter("image[image_1]").equals("")) {
				String ch[] = request.getParameterValues("ch");
				for (j = 1; j <= ch.length; j++) {
					ProgrammeTO.setStudentid(studentid);
					ProgrammeTO.setFilename(request.getParameter("image[image_"
							+ j + "]"));
					String certificatename = request.getParameter("filename"
							+ j);
					ProgrammeTO.setCertificatename(certificatename);
					try {
						flag2 = new ProgrammeDelegate()
								.addStudentCertificates(ProgrammeTO);
					} catch (Exception e) {
						request.setAttribute("status",
								"StudentCertificateNotAdded");
						path = UtilConstants._STATUS;
					}
				}
			} else {
				request.setAttribute("status", "StudentCertificateNotAdded");
				path = UtilConstants._STATUS;
			}
			if (flag1 && flag2) {
				request.setAttribute("status",
						"Student Admission Details Addes Successfully...");
				path = UtilConstants._STATUS;
			}
		} catch (IllegalAccessException e1) {
			request.setAttribute("status", "StudentCertificateNotAdded");
			path = UtilConstants._STATUS;
		} catch (InvocationTargetException e1) {
			request.setAttribute("status", "StudentCertificateNotAdded");
			path = UtilConstants._STATUS;
		} catch (ConnectionException e) {
			request.setAttribute("status", "StudentCertificateNotAdded");
			path = UtilConstants._STATUS;
		} catch (NullPointerException e) {
			request.setAttribute("status", "StudentCertificateNotAdded");
			path = UtilConstants._STATUS;
		} catch (SQLException e) {
			request.setAttribute("status", "StudentCertificateNotAdded");
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
