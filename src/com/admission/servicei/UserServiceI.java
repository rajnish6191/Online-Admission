package com.admission.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import com.admission.bean.ProfileTO;
import com.admission.bean.StudentProfileTO;
import com.admission.exception.ConnectionException;

public interface UserServiceI {
	public StudentProfileTO insertNewUser(StudentProfileTO stuProfileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException;

	public StudentProfileTO insertStudentDetails(
			StudentProfileTO studentProfileTO) throws FileNotFoundException,
			ConnectionException, NullPointerException, SQLException;

	public Vector<StudentProfileTO> viewStundents(String requesttype,
			String path) throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException;

	public ProfileTO insertStudentParentDetails(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException;

	public boolean deleteStudents(int studentid) throws FileNotFoundException,
			ConnectionException, SQLException;

	public boolean updateStatus(int studentid) throws ConnectionException,
			SQLException;

	public Vector<StudentProfileTO> viewCounslers(String status, String path)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException;
}
