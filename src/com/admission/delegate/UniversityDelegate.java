package com.admission.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.UniversityTO;
import com.admission.exception.ConnectionException;
import com.admission.servicei.UniversityServiceI;
import com.admission.servicei.impl.UniversityServiceImpl;

@SuppressWarnings("unchecked")
/**
 * Class for Company Delegate
 */
public class UniversityDelegate {
	UniversityServiceI universityServiceI = new UniversityServiceImpl();
	Vector<UniversityTO> vUniversityTOs = null;
	boolean flag = false;

	public boolean addHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException {
		flag = universityServiceI.addHolidays(cmp);
		return flag;
	}

	public Vector<UniversityTO> viewHolidays() throws ConnectionException,
			SQLException {
		return universityServiceI.viewHolidays();

	}

	public Vector<UniversityTO> viewNews(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException {
		return universityServiceI.viewNews(path);
	}

	public Vector<UniversityTO> viewHolidays(int holidayid)
			throws ConnectionException, SQLException {
		return universityServiceI.viewHolidays(holidayid);
	}

	public boolean updateHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException {
		flag = universityServiceI.updateHolidays(cmp);
		return flag;
	}

	public boolean deleteHolidays(int holidayid) throws ConnectionException,
			SQLException {
		flag = universityServiceI.deleteHolidays(holidayid);
		return flag;
	}

	public Vector<UniversityTO> viewHolidays(String fdate)
			throws ConnectionException, SQLException {
		return universityServiceI.viewHolidays(fdate);

	}

	public boolean addNews(UniversityTO universityTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		return universityServiceI.addNews(universityTO);
	}

	public Vector<ProgrammeTO> viewAdmissionStudents(String path, int programmeid)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException {
		return universityServiceI.viewAdmissionStudents(path, programmeid);
	}

}
