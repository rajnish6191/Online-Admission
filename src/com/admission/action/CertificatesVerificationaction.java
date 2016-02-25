package com.admission.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;

public class CertificatesVerificationaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		HttpSession session = request.getSession();
		String path = "";
		int i=0;
		System.out.println("haiiiiiiii");
		try {
			Vector programmeTOs = (Vector) session.getAttribute("programmeTOs");
			Iterator it = programmeTOs.listIterator();
			int no = Integer.parseInt(request.getParameter("sno"));
			while (it.hasNext()) {
				String documentstatus = request.getParameter("docstatus_" + ++i);
				System.out.println(documentstatus);
				ProgrammeTO programmeTO = (ProgrammeTO) it.next();
				flag = new ProgrammeDelegate().certificateVerififcation(
						programmeTO.getStudocId(),documentstatus);
			}
			if (flag) {
				request.setAttribute("status",
						UtilConstants._UPDATE_STATUS_SUCCESS);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._UPDATE_STATUS_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
