package com.admission.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.exception.ConnectionException;

public interface ProgrammeServiceI {

	public Vector<ProgrammeTO> viewResults(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException;

	public boolean addResults(ProgrammeTO course) throws ConnectionException,
			SQLException, FileNotFoundException;

	public boolean addStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException;

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath)
			throws ConnectionException, SQLException;

	public boolean addProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException;

	public Vector<ProgrammeTO> viewProgrammes(String imagepath)
			throws ConnectionException, SQLException;

	public boolean addStudyCenterProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException;

	public Vector<ProgrammeTO> viewStudyCenterProgrammes(String imagepath,
			int centerid) throws ConnectionException;

	public boolean addSelectStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException;

	public boolean addStudentCertificates(ProgrammeTO programmeTO)
			throws ConnectionException, FileNotFoundException;

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath, int Programmeid)
			throws ConnectionException, SQLException;

	public Vector<ProgrammeTO> viewStudentSelectStudyCenters(int centerid,
			int programmeid) throws ConnectionException;

	public Vector<ProgrammeTO> viewStudyCertificates(String path, int studentid)
			throws ConnectionException;

	public boolean certificateVerififcation(int docid, String docstatus)
			throws ConnectionException, FileNotFoundException;

	public boolean studyCenterAlllotement(int studentid, int programmeid,
			int centerid) throws ConnectionException, FileNotFoundException;

	public Vector<ProgrammeTO> viewStudyCenterAllotment(int programmeid)
			throws ConnectionException;

	public ProgrammeTO viewProgramme(int programmeid)
			throws ConnectionException;

	public ProgrammeTO viewStudyCenter(int centerid) throws ConnectionException;

	public ProgrammeTO viewAdmissionStudents(int studentid)
			throws ConnectionException;
}
