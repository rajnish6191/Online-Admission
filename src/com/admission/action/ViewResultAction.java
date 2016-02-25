package com.admission.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;

public class ViewResultAction extends HttpServlet {
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
		Vector<ProgrammeTO> results = null;
		try {
			results = new ProgrammeDelegate().viewResults(request
					.getRealPath("./images"));
			if (!results.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_RESULTS);
				request.setAttribute("results", results);
				path = UtilConstants._VIEW_RESULTS_PAGE;
			} else {
				request
						.setAttribute("status",
								UtilConstants._VIEW_RESULTS_FAIL);
				path = UtilConstants._VIEW_RESULTS_PAGE;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", UtilConstants._VIEW_RESULTS_FAIL);
			path = UtilConstants._VIEW_RESULTS_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
