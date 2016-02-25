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

public class ViewUniversityNewsAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		Vector<UniversityTO> vUniversityTOs = null;
		try {
			vUniversityTOs = new UniversityDelegate().viewNews(request
					.getRealPath("./images"));
			if (!vUniversityTOs.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_NEWS);
				request.setAttribute("vUniversityTOs", vUniversityTOs);
				path = UtilConstants._VIEW_NEWS_PAGE;
			} else {
				request.setAttribute("status", UtilConstants._VIEW_NEWS_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", UtilConstants._VIEW_NEWS_FAIL);
			path = UtilConstants._STATUS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
