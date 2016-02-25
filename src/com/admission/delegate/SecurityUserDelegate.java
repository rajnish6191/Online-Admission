package com.admission.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import com.admission.bean.ProfileTO;
import com.admission.bean.StudentProfileTO;
import com.admission.exception.ConnectionException;
import com.admission.exception.LoginException;
import com.admission.servicei.SecurityServiceI;
import com.admission.servicei.UserServiceI;
import com.admission.servicei.impl.SecurityServiceImpl;
import com.admission.servicei.impl.UserServiceImpl;

/**
 * 
 * Class for SecurityUserDelegate
 * 
 */
@SuppressWarnings("unchecked")
public class SecurityUserDelegate {
	SecurityServiceI securityServiceI = new SecurityServiceImpl();
	Vector<ProfileTO> vpro = null;
	UserServiceI userServiceI = new UserServiceImpl();
	Vector<ProfileTO> vprofile;

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException {
		vpro = securityServiceI.loginCheck(pro);
		return vpro;
	}

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException {
		return securityServiceI.changePass(pro);
	}

	public StudentProfileTO insertNewUser(StudentProfileTO stuProfileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userServiceI.insertNewUser(stuProfileTO);
	}

	public Vector<StudentProfileTO> viewStundents(String requesttype,
			String path) throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userServiceI.viewStundents(requesttype, path);
	}

	public Vector<StudentProfileTO> viewCounslers(String status, String path)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userServiceI.viewCounslers(status, path);
	}

	public ProfileTO insertStudentParentDetails(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		return userServiceI.insertStudentParentDetails(profileTO);
	}

	public StudentProfileTO insertStudentDetails(
			StudentProfileTO studentProfileTO) throws FileNotFoundException,
			ConnectionException, NullPointerException, SQLException {
		return userServiceI.insertStudentDetails(studentProfileTO);
	}

	public boolean deleteStudents(int studentid) throws FileNotFoundException,
			ConnectionException, SQLException {
		return userServiceI.deleteStudents(studentid);
	}

	public boolean updateStatus(int studentid) throws ConnectionException,
			SQLException {
		return userServiceI.updateStatus(studentid);
	}

}
