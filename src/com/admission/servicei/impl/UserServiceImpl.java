package com.admission.servicei.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import com.admission.bean.ProfileTO;
import com.admission.bean.StudentProfileTO;
import com.admission.daoi.UserDAOI;
import com.admission.daoi.impl.UserDaoImpl;
import com.admission.exception.ConnectionException;
import com.admission.servicei.UserServiceI;

@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserServiceI {
	UserDAOI userDAOI = new UserDaoImpl();
	boolean flag = false;
	Vector<ProfileTO> vprofile;

	public StudentProfileTO insertNewUser(StudentProfileTO stuProfileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userDAOI.insertNewUser(stuProfileTO);

	}

	public StudentProfileTO insertStudentDetails(
			StudentProfileTO studentProfileTO) throws FileNotFoundException,
			ConnectionException, NullPointerException, SQLException {
		return userDAOI.insertStudentDetails(studentProfileTO);
	}

	public Vector<StudentProfileTO> viewStundents(String requesttype,
			String path) throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userDAOI.viewStundents(requesttype, path);
	}

	public boolean deleteStudents(int studentid) throws FileNotFoundException,
			ConnectionException, SQLException {
		return userDAOI.deleteStudents(studentid);
	}

	public boolean updateStatus(int studentid) throws ConnectionException,
			SQLException {
		return userDAOI.updateStatus(studentid);
	}

	public Vector<StudentProfileTO> viewCounslers(String status, String path)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userDAOI.viewCounslers(status, path);
	}

	public ProfileTO insertStudentParentDetails(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
