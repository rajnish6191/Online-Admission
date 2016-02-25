package com.admission.delegate;

import java.sql.SQLException;
import java.util.Vector;

import com.admission.bean.MailsTO;
import com.admission.exception.ConnectionException;
import com.admission.servicei.MailServiceI;
import com.admission.servicei.impl.MailServiceImpl;

public class MailsDelegate {
	boolean flag = false;
	float salary = 0;
	MailServiceI msi = new MailServiceImpl();

	
	public Vector<MailsTO> mailContacts() throws ConnectionException,
			SQLException {
		return msi.mailContacts();
	}

	public boolean sendMail(MailsTO mail) throws ConnectionException,
			SQLException {
		flag = msi.sendMail(mail);
		return flag;
	}

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException {
		flag = msi.deleteMails(msgid, mailbox);
		return flag;
	}

	public Vector<MailsTO> viewMails(MailsTO mail) throws ConnectionException {
		return msi.viewMails(mail);
	}

	public Vector<MailsTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException {
		return msi.viewMail(messageid, mailbox);
	}

}
