package com.admission.servicei;

import java.sql.SQLException;
import java.util.Vector;

import com.admission.bean.ProfileTO;
import com.admission.exception.ConnectionException;
import com.admission.exception.LoginException;

public interface SecurityServiceI {
	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException;

	public boolean changePass(ProfileTO pro) throws ConnectionException,
			SQLException;
}
