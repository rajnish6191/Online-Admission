package com.admission.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.UniversityTO;
import com.admission.exception.ConnectionException;

public interface UniversityServiceI {
	public boolean addHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException;

	public Vector<UniversityTO> viewHolidays() throws ConnectionException,
			SQLException;

	public Vector<UniversityTO> viewHolidays(int holidayid)
			throws ConnectionException, SQLException;

	public boolean updateHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException;

	public boolean deleteHolidays(int holidayid) throws ConnectionException,
			SQLException;

	public Vector<UniversityTO> viewHolidays(String fdate)
			throws ConnectionException, SQLException;

	public boolean addNews(UniversityTO universityTO)
			throws ConnectionException, SQLException, FileNotFoundException;

	public Vector<UniversityTO> viewNews(String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException;

	public Vector<ProgrammeTO> viewAdmissionStudents(String path,
			int programmeid) throws ConnectionException, SQLException,
			FileNotFoundException, IOException;
}
