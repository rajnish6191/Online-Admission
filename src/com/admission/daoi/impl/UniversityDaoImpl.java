package com.admission.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.UniversityTO;
import com.admission.dao.AbstractDataAccessObject;
import com.admission.dao.SqlConstants;
import com.admission.daoi.UniversityDaoI;
import com.admission.exception.ConnectionException;
import com.admission.util.DateWrapper;

/**
 * 
 * DataAccessObject Class for Company related methods
 * 
 */
@SuppressWarnings("unchecked")
public class UniversityDaoImpl implements UniversityDaoI {
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
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
			if (preparedStatement != null)
				preparedStatement.close();
			if (statement != null)
				preparedStatement.close();

			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * The addHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to add yearly holidays.
	 * 
	 * @param Passing
	 *            Bean object contains Holiday details as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws ConnectionException
	 */
	public boolean addHolidays(UniversityTO cmp) throws ConnectionException {
		boolean flag = false;
		try {
			connection = AbstractDataAccessObject.getConnection();
			String holidayName = cmp.getHolidayName();
			String holidaydate = DateWrapper.parseDate(cmp.getHolidaydate());
			String day = cmp.getDay();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_HOLIDAY);
			preparedStatement.setString(1, holidayName);
			preparedStatement.setString(2, holidaydate);
			preparedStatement.setString(3, day);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			flag = false;
			throw new ConnectionException(
					"server busy please try latter.......");

		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to view total yearly holidays.
	 * 
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with all holiday details depends upon operations.
	 * @throws SQLException
	 */
	public Vector<UniversityTO> viewHolidays() throws ConnectionException,
			SQLException {
		Vector<UniversityTO> vcmp = new Vector<UniversityTO>();
		UniversityTO cmp = null;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_HOLIDAYS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cmp = new UniversityTO();
				cmp.setHoiidayId(resultSet.getInt(1));
				cmp.setHolidayName(resultSet.getString(2));
				cmp.setHolidaydate(DateWrapper.parseDate(resultSet.getDate(3)));
				cmp.setDay(resultSet.getString(4));
				vcmp.add(cmp);
			}
		} catch (SQLException e) {
			connection.rollback();
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vcmp;
	}

	/**
	 * The viewHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to view one holiday details.
	 * 
	 * @param passing
	 *            one date for holiday details.
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with one holiday details depends upon operations.
	 * @throws SQLException
	 */
	public Vector<UniversityTO> viewHolidays(String fdate)
			throws ConnectionException {
		Vector<UniversityTO> vcmp = new Vector<UniversityTO>();
		UniversityTO cmp = null;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_MONTH_HOLIDAYS);
			preparedStatement.setString(1, fdate);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cmp = new UniversityTO();
				cmp.setHoiidayId(resultSet.getInt(1));
				cmp.setHolidayName(resultSet.getString(2));
				cmp.setHolidaydate(DateWrapper.parseDate(resultSet.getDate(3)));
				cmp.setDay(resultSet.getString(4));
				vcmp.add(cmp);
			}
		} catch (SQLException e) {
			flag = false;
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vcmp;
	}

	/**
	 * The viewHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to view one holiday details.
	 * 
	 * @param passing
	 *            one holidayid for holiday details.
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with one holiday details depends upon operations.
	 * @throws SQLException
	 */
	public Vector<UniversityTO> viewHolidays(int holiday)
			throws ConnectionException {
		Vector<UniversityTO> vcmp = new Vector<UniversityTO>();
		UniversityTO cmp = null;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW__UPDATE_HOLIDAYS);
			preparedStatement.setInt(1, holiday);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cmp = new UniversityTO();
				cmp.setHoiidayId(resultSet.getInt(1));
				cmp.setHolidayName(resultSet.getString(2));
				cmp.setHolidaydate(DateWrapper.parseDate(resultSet.getDate(3)));
				cmp.setDay(resultSet.getString(4));
				vcmp.add(cmp);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vcmp;
	}

	/**
	 * The updateHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to update holiday details.
	 * 
	 * @param Passing
	 *            Bean object contains Holiday details as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws SQLException
	 */
	public boolean updateHolidays(UniversityTO cmp) throws ConnectionException,
			SQLException {
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._UPDATE_HOLIDAYS);
			preparedStatement.setString(1, cmp.getHolidayName());
			preparedStatement.setString(2, cmp.getHolidaydate());
			preparedStatement.setString(3, cmp.getDay());
			preparedStatement.setInt(4, cmp.getHoiidayId());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			connection.rollback();
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The deleteHolidays method of the UniversityDaoImpl Class. <br>
	 * 
	 * This method is called when to delete holiday details.
	 * 
	 * @param Passing
	 *            holidayid contains Holiday details as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws ConnectionException
	 * @throws SQLException
	 */
	public boolean deleteHolidays(int holidayid) throws ConnectionException,
			SQLException {
		boolean flag = false;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._DELETE_HOLIDAY);
			preparedStatement.setInt(1, holidayid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			connection.rollback();
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean addNews(UniversityTO universityTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		boolean flag = false;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_NEWS);
			preparedStatement.setString(1, universityTO.getNewstype());
			preparedStatement.setString(2, universityTO.getNewsHeader());

			String fileType = "";
			String fullpath = universityTO.getNewsImage();
			String[] extension = fullpath.split("\\.");
			int i;
			for (i = 0; i < extension.length; i++) {
				System.out.println(extension[i]);
				if (extension[i].equals("txt") || extension[i].equals("doc")
						|| extension[i].equals("ppt")
						|| extension[i].equals("avi")
						|| extension[i].equals("mp4")
						|| extension[i].equals("mpg")
						|| extension[i].equals("jpg")
						|| extension[i].equals("jpeg")
						|| extension[i].equals("gif")
						|| extension[i].equals("xls")
						|| extension[i].equals("docx")
						|| extension[i].equals("txt")
						|| extension[i].equals("pdf")
						|| extension[i].equals("Movie Clip"))
					fileType = extension[i];
			}
			System.out.println(fileType);
			File file = new File(universityTO.getNewsImage());
			preparedStatement.setBinaryStream(3, new FileInputStream(file),
					(int) file.length());
			preparedStatement.setString(4, fileType);
			File file1 = new File(universityTO.getNewsInformation());
			preparedStatement.setBinaryStream(5, new FileInputStream(file1),
					(int) file1.length());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			flag = false;
			throw new ConnectionException(
					"server busy please try latter.......");

		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<UniversityTO> viewNews(String path)
			throws ConnectionException, SQLException, IOException {
		Vector<UniversityTO> vUniversityTOs = new Vector<UniversityTO>();
		UniversityTO universityTO = null;
		try {
			String realpath = "";
			String realpath1 = "";
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_NEWS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				universityTO = new UniversityTO();
				int newsid = resultSet.getInt(1);
				universityTO.setNewsid(newsid);
				universityTO.setNewstype(resultSet.getString(2));
				universityTO.setNewsHeader(resultSet.getString(3));
				Blob blob = resultSet.getBlob(4);
				byte blob1[] = blob.getBytes(1, (int) blob.length());
				realpath = path + "/" + newsid + "." + resultSet.getString(5);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(blob1);

				Blob blob2 = resultSet.getBlob(6);
				byte blob3[] = blob2.getBytes(1, (int) blob2.length());
				realpath1 = path + "/" + newsid + ".txt";
				OutputStream fout1 = new FileOutputStream(realpath1);
				fout1.write(blob3);
				universityTO.setNewsInformation(realpath1);
				universityTO.setNewsdate(DateWrapper.parseDate(resultSet
						.getDate(7)));
				vUniversityTOs.add(universityTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vUniversityTOs;
	}

	public Vector<ProgrammeTO> viewAdmissionStudents(String filepath,
			int programmeid) throws ConnectionException, SQLException,
			FileNotFoundException, IOException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		System.out.println("haiiiiiiiii");
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_ADMISSION_STUDENTS);
			preparedStatement.setInt(1, programmeid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				programmeTO = new ProgrammeTO();
				int userid = resultSet.getInt(1);
				programmeTO.setStudentid(userid);
				programmeTO.setFullName(resultSet.getString(2));
				programmeTO.setBirthdate(DateWrapper.parseDate(resultSet
						.getDate(5).toString()));
				programmeTO.setRegistereddate(DateWrapper.parseDate(resultSet
						.getDate(6).toString()));

				Blob b = resultSet.getBlob(7);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = filepath + "/" + programmeid + ".jpg";
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				programmeTO.setPhoto(realpath);
				programmeTO.setNationality(resultSet.getString(8));
				programmeTO.setGender(resultSet.getString(9));
				programmeTO.setCategory(resultSet.getString(10));
				programmeTO.setMaritalstatus(resultSet.getString(11));
				programmeTO.setReligion(resultSet.getString(12));
				programmeTO.setLoginid(resultSet.getString(14));
				programmeTO.setBankname(resultSet.getString(20));
				programmeTO.setPaymentmode(resultSet.getString(21));
				programmeTO.setAmount(resultSet.getString(22));
				programmeTO.setDdno(resultSet.getString(23));
				programmeTO.setDdpaiddate(DateWrapper.parseDate(resultSet
						.getDate(24).toString()));
				programmeTO.setFeeStatus(resultSet.getString(25));

				programmeTO.setCenterid1(resultSet.getInt(28));
				programmeTO.setCenterid2(resultSet.getInt(29));
				programmeTO.setCenterid3(resultSet.getInt(30));
				programmeTO.setDateofcollegeselected(DateWrapper
						.parseDate(resultSet.getDate(32)));
				programmeTO.setCounslingStatus(resultSet.getString(33));

				programmeTOs.add(programmeTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return programmeTOs;
	}
}