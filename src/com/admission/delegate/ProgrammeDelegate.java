package com.admission.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import com.admission.bean.ProgrammeTO;
import com.admission.exception.ConnectionException;
import com.admission.servicei.ProgrammeServiceI;
import com.admission.servicei.impl.ProgrammeServiceImpl;

public class ProgrammeDelegate {
	ProgrammeServiceI programmeServiceI = new ProgrammeServiceImpl();

	public boolean addStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return programmeServiceI.addStudyCenters(programmeTO);
	}

	public boolean addProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return programmeServiceI.addProgramme(programmeTO);
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath, int Programmeid)
			throws ConnectionException, SQLException {
		return programmeServiceI.viewStudyCenter(imagepath, Programmeid);
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath)
			throws ConnectionException, SQLException {
		return programmeServiceI.viewStudyCenter(imagepath);
	}

	public Vector<ProgrammeTO> viewProgrammes(String imagepath)
			throws ConnectionException, SQLException {
		return programmeServiceI.viewProgrammes(imagepath);
	}

	public boolean addResults(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return programmeServiceI.addResults(programmeTO);
	}

	public Vector<ProgrammeTO> viewResults(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException {
		return programmeServiceI.viewResults(path);
	}

	public boolean addStudyCenterProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		return programmeServiceI.addStudyCenterProgramme(programmeTO);
	}

	public boolean addSelectStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		return programmeServiceI.addSelectStudyCenters(programmeTO);
	}

	public Vector<ProgrammeTO> viewStudyCenterProgrammes(String imagepath,
			int centerid) throws ConnectionException {
		return programmeServiceI.viewStudyCenterProgrammes(imagepath, centerid);
	}

	public boolean addStudentCertificates(ProgrammeTO programmeTO)
			throws ConnectionException, FileNotFoundException {
		return programmeServiceI.addStudentCertificates(programmeTO);
	}

	public Vector<ProgrammeTO> viewStudentSelectStudyCenters(int studentid,
			int programmeid) throws ConnectionException {
		return programmeServiceI.viewStudentSelectStudyCenters(studentid,
				programmeid);
	}

	public Vector<ProgrammeTO> viewStudyCertificates(String path, int studentid)
			throws ConnectionException {
		return programmeServiceI.viewStudyCertificates(path, studentid);
	}

	public boolean certificateVerififcation(int docid, String docstatus)
			throws ConnectionException, FileNotFoundException {
		return programmeServiceI.certificateVerififcation(docid, docstatus);
	}

	public boolean studyCenterAlllotement(int studentid, int programmeid,
			int centerid) throws ConnectionException, FileNotFoundException {
		return programmeServiceI.studyCenterAlllotement(studentid, programmeid,
				centerid);
	}

	public Vector<ProgrammeTO> viewStudyCenterAllotment(int programmeid)
			throws ConnectionException {
		return programmeServiceI.viewStudyCenterAllotment(programmeid);
	}

	public ProgrammeTO viewProgramme(int programmeid)
			throws ConnectionException {
		return programmeServiceI.viewProgramme(programmeid);
	}

	public ProgrammeTO viewStudyCenter(int centerid) throws ConnectionException {
		return programmeServiceI.viewStudyCenter(centerid);
	}

	public ProgrammeTO viewAdmissionStudents(int studentid)
			throws ConnectionException {
		return programmeServiceI.viewAdmissionStudents(studentid);
	}

}
