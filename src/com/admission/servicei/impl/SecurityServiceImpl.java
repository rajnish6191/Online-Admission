package com.admission.servicei.impl;

import java.sql.SQLException;
import java.util.Vector;

import com.admission.bean.ProfileTO;
import com.admission.daoi.SecurityDaoI;
import com.admission.daoi.impl.SecurityDaoImpl;
import com.admission.exception.ConnectionException;
import com.admission.exception.LoginException;
import com.admission.servicei.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI {

	String logintype = "";
	boolean flag = false;
	Vector<ProfileTO> vpro = null;
	SecurityDaoI sdaoi = new SecurityDaoImpl();

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException{

		vpro = sdaoi.loginCheck(pro);
       if(vpro.size()<1)
    	   throw new LoginException("Invalid username and password");
		
		return vpro;

	}

	public boolean changePass(ProfileTO pro) throws ConnectionException, SQLException {

		flag = sdaoi.changePass(pro);
		return flag;

	}
	
}
