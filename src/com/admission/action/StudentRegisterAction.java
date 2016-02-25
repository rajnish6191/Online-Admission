package com.admission.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.ProfileTO;
import com.admission.bean.StudentProfileTO;
import com.admission.delegate.SecurityUserDelegate;
import com.admission.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class StudentRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String path = "";
		boolean flag = false;
		StudentProfileTO studentProfileTO = new StudentProfileTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(studentProfileTO, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			studentProfileTO = new SecurityUserDelegate()
					.insertStudentDetails(studentProfileTO);
			if (!studentProfileTO.equals("")) {
				request.setAttribute("status",
						UtilConstants._STUDENT_REGISTRATION_SUCCESS);
				request.setAttribute("loginid", studentProfileTO.getLoginid());
				request
						.setAttribute("password", studentProfileTO
								.getPassword());
				path = UtilConstants._REGISTRATION_SUCCESS;
			} else {
				request.setAttribute("status",
						UtilConstants._STUDENT_REGISTRATION_FAIL);
				path = UtilConstants._ADMIN_HOME;
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = UtilConstants._ADMIN_HOME;
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
