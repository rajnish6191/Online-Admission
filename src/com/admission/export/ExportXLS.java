package com.admission.export;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * servlet class for Generating reports
 * 
 */
public class ExportXLS extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("application/vnd.ms-excel");
		PrintWriter pw = res.getWriter();
		HttpSession session=req.getSession();
		String html=(String)session.getAttribute("Report");
		
		//html += "Excel Report";
		System.out.println("xls");
		pw.print(html);
		pw.close();
	}
}
