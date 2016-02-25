package com.admission.daoi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.admission.bean.ProfileTO;
import com.admission.dao.AbstractDataAccessObject;
import com.admission.dao.SqlConstants;
import com.admission.daoi.SecurityDaoI;
import com.admission.exception.ConnectionException;

public class SecurityDaoImpl implements SecurityDaoI {

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * The loginCheck method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to loginCheck whether the user Autharised or
	 * not.
	 * 
	 * @param passing
	 *            Employeeid as one parameter.
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with logindetails depends upon operations.
	 * @throws SQLException
	 */
	public Vector<ProfileTO> loginCheck(ProfileTO pro)
			throws ConnectionException {
		ProfileTO profileTO = null;
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._CHECK_USER);
			String username = pro.getUserName();
			String password = pro.getPassword();
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				profileTO = new ProfileTO();
				profileTO.setEmployeeid(rs.getInt(1));
				profileTO.setLogintype(rs.getString(2));
				profileTO.setFirstName(rs.getString(3));
				vpro.add(profileTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical problum Occoured Please Try Later");
		} finally {
			closeConnection();
		}
		return vpro;
	}

	/**
	 * The changePass method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to changePassword details.
	 * 
	 * @param Passing
	 *            Profile bean as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws SQLException
	 * @throws SQLException
	 */
	public boolean changePass(ProfileTO pf) throws ConnectionException,
			SQLException {
		try {
			con = AbstractDataAccessObject.getConnection();
			String newpass = pf.getNewpassword();
			String user = pf.getFirstName();
			String firstname = pf.getFirstName();
			int userid=pf.getUserid();
			String oldpass = pf.getOldpassword();
			pstmt = con.prepareStatement(SqlConstants._CHANGE_PASSWORD);
			pstmt.setString(1, newpass);
			pstmt.setInt(2, userid);
			int c = pstmt.executeUpdate();
			if (c > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occoured Please Try Later");
		} catch (NullPointerException e) {
			throw new SQLException("Department List is empty");
		} finally {
			closeConnection();
		}
		return flag;
	}
}