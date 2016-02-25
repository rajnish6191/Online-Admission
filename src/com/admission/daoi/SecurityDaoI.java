package com.admission.daoi;

import java.sql.SQLException;
import java.util.Vector;

import com.admission.bean.ProfileTO;
import com.admission.exception.ConnectionException;

public interface SecurityDaoI {
	public Vector<ProfileTO> loginCheck(ProfileTO pro)
			throws ConnectionException;

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException;
}
