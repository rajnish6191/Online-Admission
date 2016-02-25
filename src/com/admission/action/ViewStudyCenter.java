package com.admission.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;

public class ViewStudyCenter extends HttpServlet {

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
		Vector<ProgrammeTO> studycenters = null;
		try {
			studycenters = new ProgrammeDelegate().viewStudyCenter(request
					.getRealPath("./images"));
			if (!studycenters.isEmpty()) {
				request
						.setAttribute("status",
								UtilConstants._VIEW_STUDY_CENTER);
				request.setAttribute("studycenters", studycenters);
				path = UtilConstants._VIEW_STUDY_CENTERS_PAGE;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_STUDY_CENTERS_FAIL);
				path = UtilConstants._VIEW_STUDY_CENTERS_PAGE;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",
					UtilConstants._VIEW_STUDY_CENTERS_FAIL);
			path = UtilConstants._VIEW_STUDY_CENTERS_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
