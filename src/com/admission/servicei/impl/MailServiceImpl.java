package com.admission.servicei.impl;

import java.sql.SQLException;
import java.util.Vector;
import com.admission.bean.MailsTO;
import com.admission.bean.ProfileTO;
import com.admission.daoi.MailDaoI;
import com.admission.daoi.impl.MailDaoImpl;
import com.admission.exception.ConnectionException;
import com.admission.servicei.MailServiceI;

public class MailServiceImpl implements MailServiceI {
	boolean flag = false;
	Vector<ProfileTO> vpro = null;
	MailDaoI mdaoi = new MailDaoImpl();

	public Vector<MailsTO> mailContacts() throws ConnectionException, SQLException {
		return mdaoi.mailContacts();
	}

	public boolean sendMail(MailsTO mail) throws ConnectionException,
			SQLException {
		flag = mdaoi.sendMail(mail);
		return flag;
	}

	public Vector<MailsTO> viewMails(MailsTO mail) throws ConnectionException {
		return mdaoi.viewMails(mail);
	}

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException {
		flag = mdaoi.deleteMails(msgid, mailbox);
		return flag;
	}

	public Vector<MailsTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException {
		return mdaoi.viewMail(messageid, mailbox);
	}

}
