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
 * The ViewUpdateHolidayAction class provides view yearly holidays contains
 * holidayname,holliday date
 * 
 */
public class ViewUpdateHolidayAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		Vector<UniversityTO> vcmp = null;
		int holidayid = Integer.parseInt(request.getParameter("holiday"));
		System.out.println("holidayid :" + holidayid);
		try {
			vcmp = new UniversityDelegate().viewHolidays(holidayid);
			if (!vcmp.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_UPDATE_HOLIDAY);
				request.setAttribute("holiday", vcmp);
				path = UtilConstants._UPDATE_HOLIDAY;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
