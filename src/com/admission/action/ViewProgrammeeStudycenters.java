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

public class ViewProgrammeeStudycenters extends HttpServlet {

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
		Vector<ProgrammeTO> programmeTOs = null;
		String data = request.getParameter("programmeid");
		String[] split = data.split(",");
		String[] names = new String[2];
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			names[i] = split[i];
		}
		try {
			programmeTOs = new ProgrammeDelegate().viewProgrammes(request
					.getRealPath("./images"));
			studycenters = new ProgrammeDelegate().viewStudyCenter(request
					.getRealPath("./images"), Integer.parseInt(names[0]));
			if (!studycenters.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_ADMISSION);
				request.setAttribute("programmeid", names[0]);
				request.setAttribute("programmename", names[1]);
				request.setAttribute("programmeTOs", programmeTOs);
				request.setAttribute("studyCenters", studycenters);
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
