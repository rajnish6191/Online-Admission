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

public class ViewStudyCenterAllotements1 extends HttpServlet {
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
		Vector<ProgrammeTO> vProgrammeTOs = null;
		try {
			vProgrammeTOs = new ProgrammeDelegate().viewProgrammes(request
					.getRealPath("./images"));
			if (!vProgrammeTOs.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_PROGRAMME);
				request.setAttribute("programmeTOs", vProgrammeTOs);
				path = UtilConstants._VIEW_STUDY_CENTER_ALLOTEMENT;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_PROGRAMME_FAIL);
				path = UtilConstants._VIEW_STUDY_CENTER_ALLOTEMENT;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",
					UtilConstants._VIEW_STUDY_CENTERS_FAIL);
			path = UtilConstants._VIEW_STUDY_CENTER_ALLOTEMENT;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}

