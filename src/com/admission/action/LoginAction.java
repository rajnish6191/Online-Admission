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

import com.admission.bean.ProfileTO;
import com.admission.delegate.SecurityUserDelegate;
import com.admission.exception.ConnectionException;
import com.admission.exception.LoginException;
import com.admission.util.UtilConstants;

/**
 * LoginAction Servlet Class for to login user into his account. This class
 * Helps to login.
 * 
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		HttpSession session = request.getSession();
		ProfileTO pro = new ProfileTO();
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		pro.setUserName(request.getParameter(UtilConstants._USERNAME));
		pro.setPassword(request.getParameter(UtilConstants._PASSWORD));
		try {
			vpro = new SecurityUserDelegate().loginCheck(pro);
			Iterator it = vpro.listIterator();
			while (it.hasNext()) {
				pro = (ProfileTO) it.next();

			}
			request.setAttribute("status", "Welcome " + pro.getFirstName());
			session.setAttribute(UtilConstants._FIRSTNAME, pro.getFirstName());
			session
					.setAttribute(UtilConstants._USERID, pro
							.getEmployeeid());
			session.setAttribute(UtilConstants._ROLE, pro.getLogintype());

			if (!pro.getLogintype().equals(""))
				target = UtilConstants._ADMIN_HOME;
			else {
				request.setAttribute("status", UtilConstants._INVALID_USER);
				target = UtilConstants._LOGIN_FAILED_PAGE;
			}
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._LOGIN_FAILED_PAGE;
		} catch (LoginException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._LOGIN_FAILED_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
