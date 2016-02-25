package com.admission.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import com.admission.bean.ProfileTO;
import com.admission.bean.StudentProfileTO;
import com.admission.dao.AbstractDataAccessObject;
import com.admission.dao.SqlConstants;
import com.admission.daoi.UserDAOI;
import com.admission.exception.ConnectionException;
import com.admission.util.DateWrapper;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * Class for DataAccessObjects menthod implementations
 * 
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDAOI {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	boolean flag = false;

	public void closeConnection() throws ConnectionException {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Some Technical prablums Occuring Please Try later.");
		}
	}

	/**
	 * The insertNewUser method of the UserDaoImpl Class. <br>
	 * 
	 * This method is called when to insertNewUser details.
	 * 
	 * @param Passing
	 *            Profile bean as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @throws FileNotFoundException
	 *             if an error occurred
	 * @return vector bean upon operations.
	 */
	public StudentProfileTO insertNewUser(StudentProfileTO stuProfileTO)
			throws ConnectionException, FileNotFoundException,
			ConnectionException {
		StudentProfileTO studentProfileTO = new StudentProfileTO();
		String loginid = "";
		FileInputStream fis;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._STUDENTID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				loginid = stuProfileTO.getFullName() + resultSet.getInt(1)
						+ "@Facuniversity.com";
			File f = new File(stuProfileTO.getPhoto());
			fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			CallableStatement cstmt = connection
					.prepareCall("{call INSERTCOUNSERSDETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(2, stuProfileTO.getFullName());
			cstmt.setString(3, DateWrapper.parseDate(stuProfileTO
					.getBirthdate()));
			cstmt.setString(5, stuProfileTO.getGender());
			cstmt.setString(4, stuProfileTO.getEmail());
			cstmt.setString(6, loginid);
			cstmt.setString(7, stuProfileTO.getFullName());
			cstmt.setString(8, "Counselor");
			cstmt.setString(9, stuProfileTO.getAddressType());
			cstmt.setString(10, stuProfileTO.getHouseNo());
			cstmt.setString(11, stuProfileTO.getStreet());
			cstmt.setString(12, stuProfileTO.getCity());
			cstmt.setString(13, stuProfileTO.getState());
			cstmt.setString(14, stuProfileTO.getCountry());
			cstmt.setString(15, stuProfileTO.getPin());
			cstmt.setString(16, stuProfileTO.getPhoneType());
			cstmt.setString(17, stuProfileTO.getPhoneNo());
			cstmt.registerOutParameter(18, Types.VARCHAR);
			cstmt.registerOutParameter(19, Types.VARCHAR);
			cstmt.execute();
			studentProfileTO.setLoginid(cstmt.getString(18));
			studentProfileTO.setPassword(cstmt.getString(19));
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Select File path not found...........");
		} finally {
			closeConnection();
		}
		return studentProfileTO;
	}

	public Vector<StudentProfileTO> viewStundents(String requesttype,
			String realpath) throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		StudentProfileTO studentProfileTO;
		Vector<StudentProfileTO> vectorStudentProfileTOs = new Vector<StudentProfileTO>();
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._REQUESTED_STUDENTS);
			preparedStatement.setString(1, requesttype);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String path = "";
				studentProfileTO = new StudentProfileTO();
				studentProfileTO.setUserid(resultSet.getInt(1));
				studentProfileTO.setFullName(resultSet.getString(2));
				studentProfileTO.setGuardiantype(resultSet.getString(3));
				studentProfileTO.setNameguardian(resultSet.getString(4));
				studentProfileTO.setBirthdate(DateWrapper.parseDate(resultSet
						.getDate(5)));
				studentProfileTO.setRegistereddate(DateWrapper
						.parseDate(resultSet.getDate(6)));

				Blob blob = resultSet.getBlob(7);
				byte b1[] = blob.getBytes(1, (int) blob.length());
				path = realpath + "/" + resultSet.getInt(1) + ".jpg";
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				studentProfileTO.setPhoto(path);

				studentProfileTO.setNationality(resultSet.getString(8));
				studentProfileTO.setGender(resultSet.getString(9));
				studentProfileTO.setCategory(resultSet.getString(10));
				studentProfileTO.setMaritalstatus(resultSet.getString(11));
				studentProfileTO.setReligion(resultSet.getString(12));
				studentProfileTO.setEmail(resultSet.getString(13));
				studentProfileTO.setLoginid(resultSet.getString(14));

				studentProfileTO.setStatus(resultSet.getString(17));
				studentProfileTO.setRegistrationid(resultSet.getInt(18));

				studentProfileTO.setBankname(resultSet.getString(20));
				studentProfileTO.setPaymentmode(resultSet.getString(21));
				studentProfileTO.setAmount(resultSet.getString(22));
				studentProfileTO.setDdno(resultSet.getString(23));
				studentProfileTO.setDdpaiddate(DateWrapper.parseDate(resultSet
						.getString(24)));

				studentProfileTO.setAddressType(resultSet.getString(27));
				studentProfileTO.setHouseNo(resultSet.getString(28));
				studentProfileTO.setStreet(resultSet.getString(29));
				studentProfileTO.setCity(resultSet.getString(30));
				studentProfileTO.setState(resultSet.getString(31));
				studentProfileTO.setCountry(resultSet.getString(32));
				studentProfileTO.setPin(resultSet.getString(33));
				studentProfileTO.setPhoneType(resultSet.getString(34));
				studentProfileTO.setPhoneNo(resultSet.getString(35));

				vectorStudentProfileTOs.add(studentProfileTO);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vectorStudentProfileTOs;
	}

	/**
	 * The viewUser method of the UserDaoImpl Class. <br>
	 * 
	 * This method is called when to viewUser details.
	 * 
	 * @param Passing
	 *            imagepath bean as a one parameter.
	 * @param Passing
	 *            user as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return ArrayList vector with profile and Emmployee details depends upon
	 *         operations.
	 * @throws ConnectionException
	 * @throws IOException
	 */
	

	/**
	 * The updateUser method of the UserDaoImpl Class. <br>
	 * 
	 * This method is called when to updateUser details.
	 * 
	 * @param Passing
	 *            Profile,Employee beans as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws ConnectionException
	 */
	

	public StudentProfileTO insertStudentDetails(
			StudentProfileTO studentProfileTO) throws ConnectionException {

		StudentProfileTO studProfileTO = new StudentProfileTO();
		FileInputStream fis;
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._STUDENTID);
			resultSet = preparedStatement.executeQuery();
			File file = null;
			if (resultSet.next())
				file = new File(studentProfileTO.getPhoto());
			fis = new FileInputStream(file);
			CallableStatement cstmt = connection
					.prepareCall("{call INSERTSTUDENTDETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setBinaryStream(1, fis, (int) file.length());
			cstmt.setString(2, studentProfileTO.getFullName());
			cstmt.setString(3, studentProfileTO.getGuardiantype());
			cstmt.setString(4, studentProfileTO.getNameguardian());
			cstmt.setString(5, DateWrapper.parseDate(studentProfileTO
					.getBirthdate()));
			cstmt.setString(6, studentProfileTO.getNationality());
			cstmt.setString(7, studentProfileTO.getGender());
			cstmt.setString(8, studentProfileTO.getCategory());
			cstmt.setString(9, studentProfileTO.getMaritalstatus());
			cstmt.setString(10, studentProfileTO.getReligion());
			cstmt.setString(11, studentProfileTO.getEmail());
			cstmt.setString(12, studentProfileTO.getFullName()
					+ resultSet.getInt(1) + "@university.com");
			cstmt.setString(13, studentProfileTO.getFullName());
			cstmt.setString(14, "Student");
			cstmt.setString(15, studentProfileTO.getAddressType());
			cstmt.setString(16, studentProfileTO.getHouseNo());
			cstmt.setString(17, studentProfileTO.getStreet());
			cstmt.setString(18, studentProfileTO.getCity());
			cstmt.setString(19, studentProfileTO.getState());
			cstmt.setString(20, studentProfileTO.getCountry());
			cstmt.setString(21, studentProfileTO.getPin());
			cstmt.setString(22, studentProfileTO.getPhoneType());
			cstmt.setString(23, studentProfileTO.getPhoneNo());
			cstmt.setString(24, studentProfileTO.getBankname());
			cstmt.setString(25, studentProfileTO.getPaymentmode());
			cstmt.setString(26, studentProfileTO.getAmount());
			cstmt.setString(27, studentProfileTO.getDdno());

			cstmt.registerOutParameter(28, Types.VARCHAR);
			cstmt.registerOutParameter(29, Types.VARCHAR);
			cstmt.execute();
			studProfileTO.setLoginid(cstmt.getString(28));
			studProfileTO.setPassword(cstmt.getString(29));

			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return studProfileTO;
	}

	public ProfileTO insertStudentParentDetails(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		ProfileTO profile = new ProfileTO();
		String loginid = "";
		FileInputStream fis;
		String firstname = profileTO.getFirstName();
		String middlename = profileTO.getMiddleName();
		String lastname = profileTO.getLastName();
		String birthdate = DateWrapper.parseDate(profileTO.getBirthdate());
		String email = profileTO.getEmail();
		String gender = profileTO.getGender();
		String photo = profileTO.getPhoto();
		String addresstype = profileTO.getAddressType();
		String houseno = profileTO.getHouseNo();
		String street = profileTO.getStreet();
		String city = profileTO.getCity();
		String district = profileTO.getDistrict();
		String state = profileTO.getState();
		String country = profileTO.getCountry();
		String pin = profileTO.getPin();
		String phoneno = profileTO.getPhoneNo();

		String logintype = "Parent";

		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._EMPLOYEEID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				loginid = firstname + resultSet.getInt(1) + "@nit.com";
			System.out.println(loginid);
			File f = new File(photo);
			fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			CallableStatement cstmt = connection
					.prepareCall("{call insertparentdetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(2, firstname);
			cstmt.setString(3, middlename);
			cstmt.setString(4, lastname);
			cstmt.setString(5, birthdate);
			cstmt.setString(6, email);
			cstmt.setString(7, loginid);
			cstmt.setString(8, gender);
			cstmt.setString(9, phoneno);
			cstmt.setString(10, logintype);
			cstmt.setString(11, addresstype);
			cstmt.setString(12, houseno);
			cstmt.setString(13, street);
			cstmt.setString(14, city);
			cstmt.setString(15, district);
			cstmt.setString(16, state);
			cstmt.setString(17, country);
			cstmt.setString(18, pin);

			cstmt.registerOutParameter(19, Types.VARCHAR);
			cstmt.registerOutParameter(20, Types.VARCHAR);
			cstmt.execute();
			profileTO.setLoginid(cstmt.getString(19));
			profileTO.setPassword(cstmt.getString(20));

			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (FileNotFoundException e) {
			throw new ConnectionException(
					"Select File path not found...........");
		} finally {
			closeConnection();
		}
		return profile;
	}

	public boolean deleteStudents(int studentid) throws ConnectionException,
			SQLException {
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._DELETE_STUDENT);
			preparedStatement.setInt(1, studentid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException se) {
			throw new ConnectionException(
					"Some Technical problem Occured please try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public boolean updateStatus(int studentid) throws ConnectionException,
			SQLException {
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._UPDATE_STUDENT_STATUS);
			preparedStatement.setInt(1, studentid);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException se) {
			throw new ConnectionException(
					"Some Technical problem Occured please try later");
		} catch (ConnectionException e) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<StudentProfileTO> viewCounslers(String status, String realpath)
			throws FileNotFoundException, ConnectionException,
			NullPointerException, SQLException {
		StudentProfileTO studentProfileTO;
		Vector<StudentProfileTO> vectorStudentProfileTOs = new Vector<StudentProfileTO>();
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._REQUESTED_COUNSLERS);
			preparedStatement.setString(1, status);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String path = "";
				studentProfileTO = new StudentProfileTO();
				studentProfileTO.setUserid(resultSet.getInt(1));
				studentProfileTO.setFullName(resultSet.getString(2));
				studentProfileTO.setBirthdate(DateWrapper.parseDate(resultSet
						.getDate(5)));
				studentProfileTO.setRegistereddate(DateWrapper
						.parseDate(resultSet.getDate(6)));
				Blob blob = resultSet.getBlob(7);
				byte b1[] = blob.getBytes(1, (int) blob.length());
				path = realpath + "/" + resultSet.getInt(1) + ".jpg";
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				studentProfileTO.setPhoto(path);
				studentProfileTO.setGender(resultSet.getString(9));
				studentProfileTO.setEmail(resultSet.getString(13));
				studentProfileTO.setLoginid(resultSet.getString(14));

				studentProfileTO.setStatus(resultSet.getString(17));
				studentProfileTO.setAddressid(resultSet.getInt(19));

				studentProfileTO.setAddressType(resultSet.getString(20));
				studentProfileTO.setHouseNo(resultSet.getString(21));
				studentProfileTO.setStreet(resultSet.getString(22));
				studentProfileTO.setCity(resultSet.getString(23));
				studentProfileTO.setState(resultSet.getString(24));
				studentProfileTO.setCountry(resultSet.getString(25));
				studentProfileTO.setPin(resultSet.getString(26));
				studentProfileTO.setPhoneType(resultSet.getString(27));
				studentProfileTO.setPhoneNo(resultSet.getString(28));

				vectorStudentProfileTOs.add(studentProfileTO);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vectorStudentProfileTOs;
	}
}
