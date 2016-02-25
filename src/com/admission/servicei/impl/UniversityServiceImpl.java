package com.admission.servicei.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.UniversityTO;
import com.admission.daoi.UniversityDaoI;
import com.admission.daoi.impl.UniversityDaoImpl;
import com.admission.exception.ConnectionException;
import com.admission.servicei.UniversityServiceI;

@SuppressWarnings("unchecked")
public class UniversityServiceImpl implements UniversityServiceI {
	boolean flag = false;
	Vector<UniversityTO> vUniversityTOs = null;
	UniversityDaoI universityDaoI = new UniversityDaoImpl();

	public boolean addHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException {
		flag = universityDaoI.addHolidays(cmp);
		return flag;
	}

	public Vector<UniversityTO> viewHolidays() throws ConnectionException,
			SQLException {
		return universityDaoI.viewHolidays();
	}

	public Vector<UniversityTO> viewHolidays(int holidayid)
			throws ConnectionException, SQLException {
		return universityDaoI.viewHolidays(holidayid);
	}

	public boolean updateHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException {
		flag = universityDaoI.updateHolidays(cmp);
		return flag;
	}

	public boolean deleteHolidays(int holidayid) throws ConnectionException,
			SQLException {
		flag = universityDaoI.deleteHolidays(holidayid);
		return flag;
	}

	public Vector<UniversityTO> viewHolidays(String fdate)
			throws ConnectionException, SQLException {
		return universityDaoI.viewHolidays(fdate);
	}

	public boolean addNews(UniversityTO universityTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return universityDaoI.addNews(universityTO);
	}

	public Vector<UniversityTO> viewNews(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException {
		return universityDaoI.viewNews(path);
	}

	public Vector<ProgrammeTO> viewAdmissionStudents(String path,
			int programmeid) throws ConnectionException, SQLException,
			FileNotFoundException, IOException {
		return universityDaoI.viewAdmissionStudents(path, programmeid);
	}
}
