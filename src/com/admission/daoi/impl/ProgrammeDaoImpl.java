package com.admission.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.admission.bean.ProgrammeTO;
import com.admission.bean.ProfileTO;
import com.admission.bean.UniversityTO;
import com.admission.dao.AbstractDataAccessObject;
import com.admission.dao.SqlConstants;
import com.admission.daoi.ProgrammeDaoI;
import com.admission.daoi.SecurityDaoI;
import com.admission.exception.ConnectionException;
import com.admission.exception.LoginException;
import com.admission.util.DateWrapper;

public class ProgrammeDaoImpl implements ProgrammeDaoI {
	Connection connection;
	PreparedStatement preparedStatement, preparedStatement1,
			preparedStatement2, preparedStatement3;
	ResultSet resultSet, resultSet1;
	boolean flag = false;
	String midno = "";

	public ProgrammeDaoImpl() {
		try {
			connection = AbstractDataAccessObject.getConnection();
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method for loginCheck

	public Vector<ProgrammeTO> viewResults(String path)
			throws ConnectionException, SQLException, IOException {
		ProgrammeTO course = null;
		Vector<ProgrammeTO> vcourse = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_RESULTS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				course = new ProgrammeTO();
				course.setResultid(resultSet.getInt(1));
				course.setResult(resultSet.getString(2));
				Blob b = resultSet.getBlob(3);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + resultSet.getInt(1)
						+"."+ resultSet.getString(4);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				course.setResultfile(realpath);
				course.setResultdate(DateWrapper.parseDate(resultSet.getDate(5)
						.toString()));
				course.setStatus(resultSet.getString(6));
				vcourse.add(course);
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
		return vcourse;
	}

	public boolean addStudyCenters(ProgrammeTO programmeTO)
			throws FileNotFoundException {
		try {
			preparedStatement1 = connection
					.prepareStatement(SqlConstants._STUDENTID);
			resultSet1 = preparedStatement1.executeQuery();
			if (resultSet1.next()) {
				preparedStatement = connection
						.prepareStatement(SqlConstants._ADD_STUDY_CENTER);
				System.out.println();
				preparedStatement.setString(1, programmeTO.getLocation()
						.toString().trim().substring(0, 3)
						+ resultSet1.getString(1));
				preparedStatement.setString(2, programmeTO.getCenterName());
				preparedStatement.setString(3, programmeTO.getCenterdesc());
				File file = new File(programmeTO.getLogo());
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(4, fis, (int) file.length());
				preparedStatement.setString(5, programmeTO.getLocation());
				int c = preparedStatement.executeUpdate();
				if (c > 0) {
					flag = true;
					connection.commit();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean addResults(ProgrammeTO course) throws FileNotFoundException,
			ConnectionException {
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_RESULTS);
			preparedStatement.setString(1, course.getResult());
			preparedStatement.setBinaryStream(2, new FileInputStream(new File(
					course.getResultfile())), (int) new File(course
					.getResultfile()).length());

			String fileType = "";
			String fullpath = course.getResultfile();
			String[] extension = fullpath.split("\\.");
			int i;
			for (i = 0; i < extension.length; i++) {
				System.out.println(extension[i]);
				if (extension[i].equals("txt") || extension[i].equals("doc")
						|| extension[i].equals("ppt")
						|| extension[i].equals("avi")
						|| extension[i].equals("mp4")
						|| extension[i].equals("mpg")
						|| extension[i].equals("xls")
						|| extension[i].equals("docx")
						|| extension[i].equals("txt")
						|| extension[i].equals("pdf")
						|| extension[i].equals("Movie Clip"))
					fileType = extension[i];
			}
			preparedStatement.setString(3, fileType);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath)
			throws ConnectionException, SQLException {
		ProgrammeTO course = null;
		Vector<ProgrammeTO> vcourse = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_STUDY_CENTER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				course = new ProgrammeTO();
				int centerid = resultSet.getInt(1);
				course.setCenterid(centerid);
				course.setCentercode(resultSet.getString(2));
				course.setCenterName(resultSet.getString(3));
				course.setCenterdesc(resultSet.getString(4));
				Blob b = resultSet.getBlob(5);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = imagepath + "/" + centerid + ".jpg";
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				course.setLogo(realpath);
				course.setLocation(resultSet.getString(6));
				course.setResultdate(DateWrapper.parseDate(resultSet.getDate(7)
						.toString()));
				course.setStatus(resultSet.getString(8));
				vcourse.add(course);
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
		return vcourse;
	}

	public boolean addProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException, FileNotFoundException {
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_PROGRAMME_DETAILS);
			preparedStatement.setString(1, programmeTO.getProgrammetype());
			preparedStatement.setString(2, programmeTO.getProgrammename());
			preparedStatement.setString(3, programmeTO.getProgrammeduration());
			preparedStatement.setString(4, programmeTO.getProgrammedesc());
			preparedStatement.setString(5, programmeTO.getMinage());
			preparedStatement.setString(6, programmeTO.getMaxage());
			preparedStatement.setString(7, programmeTO.getEligible());

			String fileType = "";
			String fullpath = programmeTO.getProgrammefile();
			String[] extension = fullpath.split("\\.");
			int i;
			for (i = 0; i < extension.length; i++) {
				System.out.println(extension[i]);
				if (extension[i].equals("txt") || extension[i].equals("doc")
						|| extension[i].equals("ppt")
						|| extension[i].equals("avi")
						|| extension[i].equals("mp4")
						|| extension[i].equals("mpg")
						|| extension[i].equals("xls")
						|| extension[i].equals("docx")
						|| extension[i].equals("txt")
						|| extension[i].equals("pdf")
						|| extension[i].equals("Movie Clip"))
					fileType = extension[i];
			}
			File file = new File(programmeTO.getProgrammefile());
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setBinaryStream(8, fileInputStream, (int) file
					.length());
			preparedStatement.setString(9, fileType);
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewProgrammes(String filepath)
			throws ConnectionException, SQLException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_PROGRAMME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				programmeTO = new ProgrammeTO();
				int programmeid = resultSet.getInt(1);
				programmeTO.setProgrammeid(programmeid);
				programmeTO.setProgrammetype(resultSet.getString(2));
				programmeTO.setProgrammename(resultSet.getString(3));
				programmeTO.setProgrammeduration(resultSet.getString(4));
				programmeTO.setProgrammedesc(resultSet.getString(5));
				programmeTO.setMinage(resultSet.getString(6));
				programmeTO.setMaxage(resultSet.getString(7));
				programmeTO.setEligible(resultSet.getString(8));
				programmeTO.setProgrammetregisterdate(DateWrapper
						.parseDate(resultSet.getDate(9)));
				programmeTO.setStatus(resultSet.getString(10));

				Blob b = resultSet.getBlob(11);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = filepath + "/" + programmeid + "."
						+ resultSet.getString(12);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				programmeTO.setProgrammefile(realpath);
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

	public boolean addStudyCenterProgramme(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_STUDEY_CENTER_PROGRAMME);
			preparedStatement.setInt(1, programmeTO.getCenterid());
			preparedStatement.setInt(2, programmeTO.getProgrammeid());
			preparedStatement.setInt(3, Integer.parseInt(programmeTO
					.getStudycenterseats()));
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewStudyCenterProgrammes(String filepath,
			int centerid) throws ConnectionException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._SELECT_PROGRAMMEID);
			preparedStatement.setInt(1, centerid);
			resultSet1 = preparedStatement.executeQuery();
			while (resultSet1.next()) {
				preparedStatement1 = connection
						.prepareStatement(SqlConstants._SELECT_PROGRAMME_DATA);
				preparedStatement1.setInt(1, centerid);
				resultSet = preparedStatement1.executeQuery();
				if (resultSet.next()) {
					String realpath = "";
					programmeTO = new ProgrammeTO();
					int programmeid = resultSet.getInt(1);
					programmeTO.setProgrammeid(programmeid);
					programmeTO.setProgrammetype(resultSet.getString(2));
					programmeTO.setProgrammename(resultSet.getString(3));
					programmeTO.setProgrammeduration(resultSet.getString(4));
					programmeTO.setProgrammedesc(resultSet.getString(5));
					programmeTO.setMinage(resultSet.getString(6));
					programmeTO.setMaxage(resultSet.getString(7));
					programmeTO.setEligible(resultSet.getString(8));
					programmeTO.setProgrammetregisterdate(DateWrapper
							.parseDate(resultSet.getDate(9)));
					programmeTO.setStatus(resultSet.getString(10));

					Blob b = resultSet.getBlob(11);
					byte b1[] = b.getBytes(1, (int) b.length());
					realpath = filepath + "/" + programmeid + "."
							+ resultSet.getString(12);
					OutputStream fout = new FileOutputStream(realpath);
					fout.write(b1);
					programmeTO.setProgrammefile(realpath);
				}
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

	public boolean addSelectStudyCenters(ProgrammeTO programmeTO)
			throws ConnectionException, SQLException {
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_SELECT_STUDY_CENTER);
			preparedStatement.setInt(1, programmeTO.getStudentid());
			preparedStatement.setInt(2, programmeTO.getCenterid1());
			preparedStatement.setInt(3, programmeTO.getCenterid2());
			preparedStatement.setInt(4, programmeTO.getCenterid3());
			preparedStatement.setInt(5, programmeTO.getProgrammeid());
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean addStudentCertificates(ProgrammeTO programmeTO)
			throws ConnectionException, FileNotFoundException {
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._ADD_STUDENT_CERTIFIFCATE);
			preparedStatement.setInt(1, programmeTO.getStudentid());
			preparedStatement.setString(2, programmeTO.getCertificatename());

			File file = new File(programmeTO.getFilename());

			preparedStatement.setBinaryStream(3, new FileInputStream(file),
					(int) file.length());
			String fileType = "";
			String fullpath = programmeTO.getFilename();
			String[] extension = fullpath.split("\\.");
			int i;
			for (i = 0; i < extension.length; i++) {
				System.out.println(extension[i]);
				if (extension[i].equals("txt") || extension[i].equals("doc")
						|| extension[i].equals("jpg")
						|| extension[i].equals("jpeg")
						|| extension[i].equals("gif")
						|| extension[i].equals("docx")
						|| extension[i].equals("pdf"))
					fileType = extension[i];
			}
			preparedStatement.setString(4, fileType);
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewStudyCenter(String imagepath, int Programmeid)
			throws ConnectionException, SQLException {

		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			System.out.println("haiiiii");
			preparedStatement = connection
					.prepareStatement(SqlConstants._SELECT_STUDY_CENTERS);
			preparedStatement.setInt(1, Programmeid);
			resultSet1 = preparedStatement.executeQuery();
			while (resultSet1.next()) {
				preparedStatement1 = connection
						.prepareStatement(SqlConstants._SELECT_STUDYCENTER_DATA);
				preparedStatement1.setInt(1, resultSet1.getInt(1));
				resultSet = preparedStatement1.executeQuery();
				if (resultSet.next()) {
					String realpath = "";
					programmeTO = new ProgrammeTO();
					int programmeid = resultSet.getInt(1);
					programmeTO.setCenterid(programmeid);
					programmeTO.setCentercode(resultSet.getString(2));
					programmeTO.setCenterName(resultSet.getString(3));
					programmeTO.setCenterdesc(resultSet.getString(4));
					Blob b = resultSet.getBlob(5);
					byte b1[] = b.getBytes(1, (int) b.length());
					realpath = imagepath + "/" + programmeid + ".jpg";
					OutputStream fout = new FileOutputStream(realpath);
					fout.write(b1);
					programmeTO.setProgrammefile(realpath);
					programmeTO.setLocation(resultSet.getString(6));
					programmeTO.setProgrammetregisterdate(DateWrapper
							.parseDate(resultSet.getDate(7)));
					programmeTO.setStatus(resultSet.getString(8));
				}
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

	public Vector<ProgrammeTO> viewStudentSelectStudyCenters(int studentid,
			int programmeid) throws ConnectionException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_STUDENT_ADMISSION_STUDYCENTER);
			preparedStatement.setInt(1, studentid);
			preparedStatement.setInt(2, programmeid);
			preparedStatement.setInt(3, programmeid);
			preparedStatement.setInt(4, programmeid);
			preparedStatement.setInt(5, programmeid);
			preparedStatement.setInt(6, studentid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				programmeTO = new ProgrammeTO();
				int centerid = resultSet.getInt(1);
				programmeTO.setCenterid(centerid);
				programmeTO.setStudentid(resultSet.getInt(2));
				programmeTO.setProgrammeid(resultSet.getInt(3));
				programmeTO.setDateofcollegeselected(DateWrapper
						.parseDate(resultSet.getDate(4).toString()));
				programmeTO.setStatus(resultSet.getString(5));
				programmeTO.setCenterid1(resultSet.getInt(6));
				programmeTO.setCenterName1(resultSet.getString(7));
				programmeTO.setCentercode1(resultSet.getString(8));
				programmeTO.setCenterid2(resultSet.getInt(9));
				programmeTO.setCenterName2(resultSet.getString(10));
				programmeTO.setCentercode2(resultSet.getString(11));
				programmeTO.setCenterid3(resultSet.getInt(12));
				programmeTO.setCenterName3(resultSet.getString(13));
				programmeTO.setCentercode3(resultSet.getString(14));
				programmeTO.setFullName(resultSet.getString(15));
				programmeTO.setProgrammename(resultSet.getString(16));
				programmeTO.setSeats1(resultSet.getString(17));
				programmeTO.setSeats2(resultSet.getString(18));
				programmeTO.setSeats3(resultSet.getString(19));

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

	public Vector<ProgrammeTO> viewStudyCertificates(String path, int studentid)
			throws ConnectionException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_STUDENT_ADMISSION_DOCUMENT);
			preparedStatement.setInt(1, studentid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				programmeTO = new ProgrammeTO();
				int studocid = resultSet.getInt(1);
				programmeTO.setStudocId(studocid);
				programmeTO.setStudentidref(resultSet.getInt(2));
				programmeTO.setQualificationname(resultSet.getString(3));
				Blob b = resultSet.getBlob(4);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + studocid + "." + resultSet.getString(5);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				programmeTO.setQualificationmemofile(realpath);
				programmeTO.setDateofpost(DateWrapper.parseDate(resultSet
						.getDate(6).toString()));
				programmeTO.setDocstatus(resultSet.getString(7));

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

	public boolean certificateVerififcation(int docid, String docstatus)
			throws ConnectionException, FileNotFoundException {
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._UPDATE_CERTIFICATE_STATUS);
			preparedStatement.setString(1, docstatus);
			preparedStatement.setInt(2, docid);
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean studyCenterAlllotement(int studentid, int programmeid,
			int centerid) throws ConnectionException, FileNotFoundException {
		try {
			System.out.println("haiiiiiiiiiii");
			preparedStatement = connection
					.prepareStatement(SqlConstants._STUDYCENTER_ALLOTMENT);
			preparedStatement.setInt(1, studentid);
			preparedStatement.setInt(2, programmeid);
			preparedStatement.setInt(3, centerid);
			int c = preparedStatement.executeUpdate();
			if (c > 0) {
				flag = true;
				preparedStatement1 = connection
						.prepareStatement(SqlConstants._UPDATE_SELECT_STUDYCENTER_SEATS);
				preparedStatement1.setInt(1, programmeid);
				preparedStatement1.setInt(2, centerid);
				resultSet1 = preparedStatement1.executeQuery();
				if (resultSet1.next()) {
					int seat = 0;
					seat = resultSet1.getInt(1);
					seat = seat - 1;
					preparedStatement2 = connection
							.prepareStatement(SqlConstants._UPDATE_STUDYCENTER_SEATS);
					preparedStatement2.setInt(1, seat);
					preparedStatement2.setInt(2, programmeid);
					preparedStatement2.setInt(3, centerid);
					int d = preparedStatement2.executeUpdate();
					if (d > 0) {
						preparedStatement3 = connection
								.prepareStatement(SqlConstants._SEAT_ALLOTED);
						preparedStatement3.setInt(1, programmeid);
						preparedStatement3.setInt(2, studentid);
						int e = preparedStatement3.executeUpdate();
						if (e > 0) {
							connection.commit();
						} else {
							connection.rollback();
						}

					}
				}

			}
		} catch (SQLException e) {
			try {
				System.out.println(e);
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return flag;
	}

	public Vector<ProgrammeTO> viewStudyCenterAllotment(int programmeid)
			throws ConnectionException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		try {
			preparedStatement1 = connection
					.prepareStatement(SqlConstants._SELECT_STUDENTID);
			preparedStatement1.setInt(1, programmeid);
			resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				preparedStatement = connection
						.prepareStatement(SqlConstants._ALLOTED_STUDENTS);
				preparedStatement.setInt(1, resultSet1.getInt(1));
				preparedStatement.setInt(2, resultSet1.getInt(1));
				preparedStatement.setInt(3, resultSet1.getInt(1));
				preparedStatement.setInt(4, resultSet1.getInt(1));
				preparedStatement.setInt(5, resultSet1.getInt(1));
				preparedStatement.setInt(6, resultSet1.getInt(1));
				preparedStatement.setInt(7, resultSet1.getInt(1));
				preparedStatement.setInt(8, programmeid);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					programmeTO = new ProgrammeTO();
					programmeTO.setSelectedseatid(resultSet.getInt(1));
					programmeTO.setStudentid(resultSet.getInt(2));
					programmeTO.setFullName(resultSet.getString(3));
					programmeTO.setCenterid(resultSet.getInt(4));
					programmeTO.setCenterName(resultSet.getString(5));
					programmeTO.setCentercode(resultSet.getString(6));
					programmeTO.setProgrammeid(resultSet.getInt(7));
					programmeTO.setProgrammename(resultSet.getString(8));
					programmeTO.setDateofpost(DateWrapper.parseDate(resultSet
							.getDate(9).toString()));
					programmeTO.setStatus(resultSet.getString(10));
				}
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

	public ProgrammeTO viewProgramme(int programme) throws ConnectionException {
		ProgrammeTO programmeTO = null;
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_STUDENT_PROGRAMME);
			preparedStatement.setInt(1, programme);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				programmeTO = new ProgrammeTO();
				int programmeid = resultSet.getInt(1);
				programmeTO.setProgrammeid(programmeid);
				programmeTO.setProgrammetype(resultSet.getString(2));
				programmeTO.setProgrammename(resultSet.getString(3));
				programmeTO.setProgrammeduration(resultSet.getString(4));
				programmeTO.setProgrammedesc(resultSet.getString(5));
				programmeTO.setMinage(resultSet.getString(6));
				programmeTO.setMaxage(resultSet.getString(7));
				programmeTO.setEligible(resultSet.getString(8));
				programmeTO.setProgrammetregisterdate(DateWrapper
						.parseDate(resultSet.getDate(9)));
				programmeTO.setStatus(resultSet.getString(10));
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
		return programmeTO;
	}

	public ProgrammeTO viewStudyCenter(int centerid) throws ConnectionException {

		ProgrammeTO programmeTO = null;
		try {
			preparedStatement = connection
					.prepareStatement(SqlConstants._STUDYCENTER_DATA);
			preparedStatement.setInt(1, centerid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				programmeTO = new ProgrammeTO();
				int programmeid = resultSet.getInt(1);
				programmeTO.setCenterid(programmeid);
				programmeTO.setCentercode(resultSet.getString(2));
				programmeTO.setCenterName(resultSet.getString(3));
				programmeTO.setCenterdesc(resultSet.getString(4));
				programmeTO.setLocation(resultSet.getString(6));
				programmeTO.setProgrammetregisterdate(DateWrapper
						.parseDate(resultSet.getDate(7)));
				programmeTO.setStatus(resultSet.getString(8));
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
		return programmeTO;
	}

	public ProgrammeTO viewAdmissionStudents(int studentid)
			throws ConnectionException {
		ProgrammeTO programmeTO = null;
		Vector<ProgrammeTO> programmeTOs = new Vector<ProgrammeTO>();
		System.out.println("haiiiiiiiii");
		try {
			connection = AbstractDataAccessObject.getConnection();
			preparedStatement = connection
					.prepareStatement(SqlConstants._VIEW_STUDENT);
			preparedStatement.setInt(1, studentid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				programmeTO = new ProgrammeTO();
				int userid = resultSet.getInt(1);
				programmeTO.setStudentid(userid);
				programmeTO.setFullName(resultSet.getString(2));
				programmeTO.setGuardiantype(resultSet.getString(3));
				programmeTO.setNameguardian(resultSet.getString(4));
				programmeTO.setBirthdate(DateWrapper.parseDate(resultSet
						.getDate(5).toString()));
				programmeTO.setRegistereddate(DateWrapper.parseDate(resultSet
						.getDate(6).toString()));
				programmeTO.setNationality(resultSet.getString(8));
				programmeTO.setGender(resultSet.getString(9));
				programmeTO.setCategory(resultSet.getString(10));
				programmeTO.setMaritalstatus(resultSet.getString(11));
				programmeTO.setReligion(resultSet.getString(12));
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
		return programmeTO;
	}
}
