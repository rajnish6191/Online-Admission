package com.admission.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.MailsTO;
import com.admission.delegate.MailsDelegate;
import com.admission.util.UtilConstants;

/**
 * Servlet Class for ComposeMail
 * 
 */
public class ComposeMailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		Vector<MailsTO> vmail = null;
		try {
			vmail = new MailsDelegate().mailContacts();
			if (!vmail.isEmpty()) {
				request.setAttribute("mailcontacts", vmail);
				target = UtilConstants._COMPOSE_MAIL;
			} else {
				request.setAttribute("status", UtilConstants._NO_CONTACTS);
				target = UtilConstants._COMPOSE_MAIL;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._COMPOSE_MAIL;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
