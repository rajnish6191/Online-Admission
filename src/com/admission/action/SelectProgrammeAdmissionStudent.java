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
import com.admission.delegate.UniversityDelegate;
import com.admission.util.UtilConstants;

public class SelectProgrammeAdmissionStudent extends HttpServlet {

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
		Vector<ProgrammeTO> programmeTOs = null;
		String data = request.getParameter("programmeid");
		String[] split = data.split(",");
		String[] names = new String[2];
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			names[i] = split[i];
			
		}
		try {
			programmeTOs = new UniversityDelegate()
					.viewAdmissionStudents(request.getRealPath("./images"),
							Integer.parseInt(names[0]));
			System.out.println(names[0]);			System.out.println("111111"+names[1]);
			if (!programmeTOs.isEmpty()) {
				request.setAttribute("status", UtilConstants._VIEW_ADMISSION);
				request.setAttribute("programmeid", names[0]);
				request.setAttribute("programmename", names[1]);
				request.setAttribute("vprogrammeTOs", programmeTOs);
				path = UtilConstants._VIEW_ADMISSION_STUDENTS;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
				path = UtilConstants._VIEW_ADMISSION_STUDENTS;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status",
					UtilConstants._VIEW_STUDY_CENTER_PROGRAMME_FAIL);
			path = UtilConstants._VIEW_ADMISSION_STUDENTS;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
