package com.admission.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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
 * SendMailAction Servlet Class for to add mail details. This class Helps to add
 * mail Name,mail head,mail body Details.
 * 
 */
public class SendMailAction extends HttpServlet {
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
			flag = new MailsDelegate().sendMail(mail);
			if (flag) {
				request.setAttribute("status", UtilConstants._SEND_MAIL);
				path = UtilConstants._SEND_MAILS;
			} else {
				request.setAttribute("status", UtilConstants._SEND_MAIL_FAIL);
				path = UtilConstants._SEND_MAILS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._SEND_MAILS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
