package com.admission.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.UniversityTO;
import com.admission.delegate.UniversityDelegate;
import com.admission.util.UtilConstants;

/** 
 * ViewHolidaysAction Servlet Class for  Display Employee Holodays 
 * It gives Employee Personal applied Leaves 
 * 
 */
public class ViewHolidaysAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		Vector<UniversityTO> vcmp = null;
		try {
			vcmp = new UniversityDelegate().viewHolidays();
			if (!vcmp.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_HOLIDAY);
				request.setAttribute("companyholidays", vcmp);
				path = UtilConstants._VIEW_HOLIDAYS;
			} else {

				request.setAttribute("status", UtilConstants._NO_HOLIDAYS);
				path = UtilConstants._VIEW_HOLIDAYS;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",e.getMessage());
			path = UtilConstants._VIEW_HOLIDAYS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
