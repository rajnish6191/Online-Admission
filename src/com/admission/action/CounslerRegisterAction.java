package com.admission.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
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

public class CounslerRegisterAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		StudentProfileTO stuProfileTO;
		System.out.println("haiiiiiiiiiiiiiiiiiiii");
		String path = "";
		StudentProfileTO studentProfileTO  = new StudentProfileTO();
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
			stuProfileTO = new SecurityUserDelegate().insertNewUser(studentProfileTO);
			if (!stuProfileTO.equals("")) {
				request.setAttribute("status",
						UtilConstants._COUNSLER_REGISTRATION);
				request.setAttribute("loginid", stuProfileTO.getLoginid());
				request.setAttribute("password", stuProfileTO.getPassword());
				path = UtilConstants._REGISTRATION_SUCCESS;
			} else {
				request.setAttribute("status",
						UtilConstants._STUDENT_REGISTRATION_FAIL);
				path = UtilConstants._ADMIN_HOME;
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = UtilConstants._ADMIN_HOME;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}