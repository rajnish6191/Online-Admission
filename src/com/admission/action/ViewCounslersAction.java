package com.admission.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.StudentProfileTO;
import com.admission.delegate.SecurityUserDelegate;
import com.admission.util.UtilConstants;

public class ViewCounslersAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Vector<StudentProfileTO> vectorCounslersProfileTOs;
		String target = "";
		String status = request.getParameter("status");
		try {
			vectorCounslersProfileTOs = new SecurityUserDelegate()
					.viewCounslers(status, request.getRealPath("./images"));
			if (!vectorCounslersProfileTOs.isEmpty()) {
				request.setAttribute("vectorCounslersProfileTOs",
						vectorCounslersProfileTOs);
				target = UtilConstants._VIEW_COUNSLERS_DETAILS;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_COUNSLERS_DETAILS_FAIL);
				target = UtilConstants._VIEW_COUNSLERS_DETAILS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status",
					UtilConstants._VIEW_COUNSLERS_DETAILS_FAIL);
			target = UtilConstants._VIEW_COUNSLERS_DETAILS;
		}
		rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
