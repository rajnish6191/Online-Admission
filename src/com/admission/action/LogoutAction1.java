package com.admission.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admission.util.UtilConstants;

/** 
 * LogoutAction1 Servlet Class for to Logout details.
 * This class Helps to session Out from his account details.
 * 
 */
public class LogoutAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.setAttribute("role", null);
		session.invalidate();
		RequestDispatcher rd = request
				.getRequestDispatcher(UtilConstants._LOGOUT);
		rd.forward(request, response);
	}

}
