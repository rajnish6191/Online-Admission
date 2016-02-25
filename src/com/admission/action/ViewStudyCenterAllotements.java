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

public class ViewStudyCenterAllotements extends HttpServlet {
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
		String data = request.getParameter("programmeid");
		String[] split = data.split(",");
		String[] names = new String[2];
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			names[i] = split[i];

		}
		try {
			vProgrammeTOs = new ProgrammeDelegate()
					.viewStudyCenterAllotment(Integer.parseInt(names[0]));
			if (!vProgrammeTOs.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_PROGRAMME);
				request.setAttribute("programmeid", names[0]);
				request.setAttribute("programmename", names[1]);
				request.setAttribute("vprogrammeTOs", vProgrammeTOs);
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
