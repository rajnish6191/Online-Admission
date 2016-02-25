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

public class ViewStudyCentersProgrammes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		Vector<ProgrammeTO> programmeTOs = null;
		Vector<ProgrammeTO> studyCenters = null;
		try {
			programmeTOs = new ProgrammeDelegate().viewProgrammes(request
					.getRealPath("./images"));
			studyCenters = new ProgrammeDelegate().viewStudyCenter(request
					.getRealPath("./images"));
			if (!programmeTOs.isEmpty() && !studyCenters.isEmpty()) {
				request.setAttribute("status",
						UtilConstants._VIEW_ADMISSION);
				request.setAttribute("programmeTOs", programmeTOs);
				request.setAttribute("studyCenters", studyCenters);
				path = UtilConstants._ADMISSION_FORM;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
				path = UtilConstants._ADMISSION_FORM;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",
					UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
			path = UtilConstants._ADMISSION_FORM;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
