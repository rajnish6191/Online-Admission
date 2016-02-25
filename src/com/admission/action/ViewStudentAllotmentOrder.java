package com.admission.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admission.bean.ProgrammeTO;
import com.admission.delegate.ProgrammeDelegate;
import com.admission.util.UtilConstants;

public class ViewStudentAllotmentOrder extends HttpServlet {
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
		ProgrammeTO student = null;
		ProgrammeTO programmes = null;
		ProgrammeTO studycenter = null;
		Vector<ProgrammeTO> studyCertificates = null;
		try {
			String output1 = "";
			programmes = new ProgrammeDelegate().viewProgramme(Integer
					.parseInt(request.getParameter("programmeid")));
			studycenter = new ProgrammeDelegate().viewStudyCenter(Integer
					.parseInt(request.getParameter("centerid")));
			student = new ProgrammeDelegate().viewAdmissionStudents(Integer
					.parseInt(request.getParameter("studentid")));
			studyCertificates = new ProgrammeDelegate().viewStudyCertificates(
					request.getRealPath("./images"), Integer.parseInt(request
							.getParameter("studentid")));
			if (!studycenter.equals(null) && !student.equals(null)
					&& !studyCertificates.equals(null)
					&& !programmes.equals(null)) {

				response.setContentType("application/vnd.ms-excel");
				PrintWriter out = response.getWriter();
				String output = "<HTML> <BODY><center><h2>	Allotment Order</h2>";
				output = output
						+ "<center><table width='900' border='1'><tr><td align='center' colspan='4'><h3>Student Details</h3></td></tr><tr><td>StudentName :</td>";
				output = output + "<td>" + student.getFullName()
						+ "</td><td>StudentID :</td><td>"
						+ student.getStudentid() + "</td></tr><tr><td>"
						+ student.getGuardiantype() + " Name :</td><td>"
						+ student.getNameguardian()
						+ "</td><td>Date of Birth :</td>";
				output = output + "<td>" + student.getBirthdate()
						+ "</td></tr><tr><td>Nationality :</td><td>"
						+ student.getNationality()
						+ "</td><td>Gender :</td><td>" + student.getGender()
						+ "</td></tr><tr><td>Category :</td><td>"
						+ student.getCategory() + "</td>";
				output = output + "<td>	Religion :</td><td>"
						+ student.getReligion() + "</td></tr></table></center>";
				output = output
						+ "<table width='900' border='1'><tr><td align='center' colspan='4'><h3>Student Certification Details</h3> </td></tr>";
				output = output
						+ "<tr><td align='center'>CertificateName </td><td align='center'>Status </td><td align='center'>Date </td></tr>";
				Iterator it = studyCertificates.listIterator();
				while (it.hasNext()) {
					ProgrammeTO studyCer = (ProgrammeTO) it.next();
					output1 = output1+"<tr><td>" + studyCer.getQualificationname()
							+ "</td><td>" + studyCer.getDocstatus()
							+ "</td><td>" + studyCer.getDateofpost()
							+ "</td></tr>";
				}
				output = output+output1 + "</table></center>";

				output = output
						+ "<center><table width='900' border='1'><tr><td align='center' colspan='4'><h3>College Details</h3></td></tr>";
				output = output
						+ "<tr><td align='center' colspan='2'><h4>StudyCenter Details</h4></td><td align='center' colspan='2'><h4>Programme Details</h4></td></tr>";

				output = output + "<td>StudyCenterName :</td><td>"
						+ studycenter.getCenterName()
						+ "</td><td>ProgrammeName :</td><td>"
						+ programmes.getProgrammename() + "</td></tr>";

				output = output + "<td>StudyCenterCode :</td><td>"
						+ studycenter.getCentercode()
						+ "</td><td>ProgrammeType :</td><td>"
						+ programmes.getProgrammetype() + "</td></tr>";

				output = output + "<td>StudyCenterLocation :</td><td>"
						+ studycenter.getLocation()
						+ "</td><td>ProgrammeDuration :</td><td>"
						+ programmes.getProgrammeduration() + "</td></tr>";

				output = output + "</table></center>";
				output = output + "  </BODY></HTML>";

				out.println(output);
				out.flush();
				out.close();
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_PROGRAMME_FAIL);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			request.setAttribute("status", UtilConstants._VIEW_PROGRAMME_FAIL);
			path = UtilConstants._STATUS;
		}
		// RequestDispatcher rd = request.getRequestDispatcher(path);
		// rd.forward(request, response);
	}
}
