package com.admission.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.admission.exception.ConnectionException;
import com.admission.util.LoggerManager;

/**
 * Class for getting DatabaseConnection
 */
public class AbstractDataAccessObject {
	private static Connection mCon;
	private static Properties mProps;

	/**
	 * @return the props
	 */
	public static Properties getProperties() {
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps) {
		mProps = aProps;
	}

	public static Connection getConnection() throws ConnectionException {
		try {
			Properties aProps = getProperties();
			Class.forName(aProps.getProperty("driver"));
			mCon = DriverManager.getConnection(aProps.getProperty("url"),
					aProps.getProperty("duser"), aProps.getProperty("dpass"));
			System.out.println("Connection established");
		} catch (ClassNotFoundException cnfe) {
			throw new ConnectionException("Server Busy pls try after sometime");
		} catch (SQLException se) {
			throw new ConnectionException("Server Busy pls try after sometime");
		}
		return mCon;
	}

	public int getSequenceID(String tableName, String pkid) {
		int id = 0;
		try {
			mCon = getConnection();
			Statement st = mCon.createStatement();
			ResultSet rs = st.executeQuery("select max(" + pkid + ") from "
					+ tableName);
			if (rs.next())
				id = rs.getInt(1);
			id++;
		} catch (SQLException se) {
			LoggerManager.writeLogWarning(se);
		} catch (Exception e) {
			LoggerManager.writeLogWarning(e);
		} finally {
			try {
				mCon.close();
			} catch (SQLException se) {
				LoggerManager.writeLogWarning(se);
			} catch (Exception e) {
				LoggerManager.writeLogWarning(e);
			}
		}
		return id;
	}
}
