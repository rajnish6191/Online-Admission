package com.admission.servicei.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.daoi.ProgrammeDaoI;
import com.admission.daoi.impl.ProgrammeDaoImpl;
import com.admission.exception.ConnectionException;
import com.admission.servicei.ProgrammeServiceI;

public class ProgrammeServiceImpl implements ProgrammeServiceI {
	String logintype = "";
	boolean flag = false;
	Vector<ProgrammeTO> vcourse = null;
	ProgrammeDaoI programmeDaoI = new ProgrammeDaoImpl();

	public boolean addStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return programmeDaoI.addStudyCenters(programmeTO);
	}

	public Vector<ProgrammeTO> viewResults(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException {
		return programmeDaoI.viewResults(path);
	}

	public boolean addResults(ProgrammeTO course) throws ConnectionException,
			SQLException, FileNotFoundException {
		flag = programmeDaoI.addResults(course);
		if (flag == false) {
			throw new ConnectionException();
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath)
			throws ConnectionException, SQLException {
		return programmeDaoI.viewStudyCenter(imagepath);
	}

	public boolean addProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return programmeDaoI.addProgramme(programmeTO);
	}

	public Vector<ProgrammeTO> viewProgrammes(String imagepath)
			throws ConnectionException, SQLException {
		return programmeDaoI.viewProgrammes(imagepath);
	}

	public boolean addStudyCenterProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		return programmeDaoI.addStudyCenterProgramme(programmeTO);
	}

	public Vector<ProgrammeTO> viewStudyCenterProgrammes(String imagepath,
			int centerid) throws ConnectionException {
		return programmeDaoI.viewStudyCenterProgrammes(imagepath, centerid);
	}

	public boolean addSelectStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		return programmeDaoI.addSelectStudyCenters(programmeTO);
	}

	public boolean addStudentCertificates(ProgrammeTO programmeTO)
			throws ConnectionException, FileNotFoundException {
		return programmeDaoI.addStudentCertificates(programmeTO);
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath, int Programmeid)
			throws ConnectionException, SQLException {
		return programmeDaoI.viewStudyCenter(imagepath, Programmeid);
	}

	public Vector<ProgrammeTO> viewStudentSelectStudyCenters(int studentid,
			int programmeid) throws ConnectionException {
		return programmeDaoI.viewStudentSelectStudyCenters(studentid,
				programmeid);
	}

	public Vector<ProgrammeTO> viewStudyCertificates(String path, int studentid)
			throws ConnectionException {
		return programmeDaoI.viewStudyCertificates(path, studentid);
	}

	public boolean certificateVerififcation(int docid, String docstatus)
			throws ConnectionException, FileNotFoundException {
		return programmeDaoI.certificateVerififcation(docid, docstatus);
	}

	public boolean studyCenterAlllotement(int studentid, int programmeid,
			int centerid) throws ConnectionException, FileNotFoundException {
		return programmeDaoI.studyCenterAlllotement(studentid, programmeid,
				centerid);
	}

	public Vector<ProgrammeTO> viewStudyCenterAllotment(int programmeid)
			throws ConnectionException {
		return programmeDaoI.viewStudyCenterAllotment(programmeid);
	}

	public ProgrammeTO viewProgramme(int programmeid)
			throws ConnectionException {
		return programmeDaoI.viewProgramme(programmeid);
	}

	public ProgrammeTO viewStudyCenter(int centerid) throws ConnectionException {
		return programmeDaoI.viewStudyCenter(centerid);
	}

	public ProgrammeTO viewAdmissionStudents(int studentid)
			throws ConnectionException {
		return programmeDaoI.viewAdmissionStudents(studentid);
	}
}
