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

import com.admission.bean.MailsTO;
import com.admission.delegate.MailsDelegate;
import com.admission.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * OutboxAction Servlet Class for to view Outbox messages details. This class
 * Helps to view Outbox messages details.
 * 
 */
public class OutboxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		int empid = Integer.parseInt(request.getParameter("empid"));
		String mailbox = request.getParameter("requesttype");
		Vector<MailsTO> vmail = null;
		System.out.println(mailbox);
		System.out.println(empid);
		MailsTO mail = new MailsTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(mail, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			vmail = new MailsDelegate().viewMails(mail);
			if (!vmail.isEmpty()) {
				request.setAttribute("mails", vmail);
				request.setAttribute("mailbox", mailbox);
				request.setAttribute("status", UtilConstants._MAILS);
				path = UtilConstants._MAIL_BOX;
			} else {
				request.setAttribute("status", UtilConstants._MAIL_BOX_FAIL);
				path = UtilConstants._MAIL_BOX;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._MAIL_BOX;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}