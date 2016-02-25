package com.admission.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.UniversityTO;
import com.admission.delegate.UniversityDelegate;
import com.admission.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * SetHolidaysAction Servlet Class for to add Holidays Details This class Helps
 * to add Holidays Name,date Details.
 * 
 */
public class SetHolidaysAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		UniversityTO cmp = new UniversityTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(cmp, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			flag = new UniversityDelegate().addHolidays(cmp);
			if (flag) {
				request.setAttribute("status",
						UtilConstants._ADD_HOLIDAY_SUCCESS);
				path = UtilConstants._ADD_HOLIDAY;
			} else {
				request.setAttribute("status", UtilConstants._ADD_HOLIDAY_FAIL);
				path = UtilConstants._ADD_HOLIDAY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._ADD_HOLIDAY;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
