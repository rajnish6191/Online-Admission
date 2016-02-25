package com.admission.action;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddProgrammeAction extends HttpServlet {
	private static final long serialVersionUID = -2941564269120432640L;

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
		ProgrammeTO programmeTO = new ProgrammeTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(programmeTO, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			flag = new ProgrammeDelegate().addProgramme(programmeTO);
			if (flag) {
				request.setAttribute("status",
						UtilConstants._ADD_PROGRAMME_DETAILS_SUCCESS);
				path = UtilConstants._ADD_PROGRAMME_DETAILS;
			} else {
				request.setAttribute("status",
						UtilConstants._ADD_PROGRAMME_DETAILS_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status",
					UtilConstants._ADD_PROGRAMME_DETAILS_FAIL);
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}