package com.admission.dao;

/**
 * Class For SqlQueries
 */
public class SqlConstants {

	public static final String _STUDENTID = "select nvl(max(userid),1000)+1 from userdetails";

	public static final String _DELETE_STUDENT = "update userdetails set status='pending' where userid=?";
	public static final String _UPDATE_STUDENT_STATUS = "update userdetails set status='Active' where userid=?";
	public static final String _REQUESTED_STUDENTS = "select * from userdetails,REGISTRAIONFEEDETAILS,addresses where logintype='Student' and userdetails.userid=REGISTRAIONFEEDETAILS.studentidref and userdetails.status=? and userdetails.userid=addresses.userid";
	public static final String _REQUESTED_COUNSLERS = "select * from userdetails,addresses where logintype='Counselor' and userdetails.status=? and userdetails.userid=addresses.userid";

	// Results
	public static final String _ADD_RESULTS = "insert into results values((select nvl(max(resultid),100)+1 from results),?,?,?,sysdate,'Declared')";
	public static final String _VIEW_RESULTS = "SELECT  * FROM   results order by sysdate";

	// StudyCenters
	public static final String _ADD_STUDY_CENTER = "insert into studycenters values((select nvl(max(CENTERID),100)+1 from studycenters),?,?,?,?,?,sysdate,'Open')";
	public static final String _STUDYCENTER = "select nvl(max(centerid),1000)+1 from studycenters";
	public static final String _VIEW_STUDY_CENTER = "SELECT  * FROM  studycenters";
	public static final String _STUDYCENTER_DATA = "select * from STUDYCENTERS where CENTERID=?";
	
	// Programme
	public static final String _ADD_PROGRAMME_DETAILS = "insert into programmes values((select nvl(max(PROGRAMMEID),100)+1 from PROGRAMMES),?,?,?,?,?,?,?,sysdate,'Active',?,?)";
	public static final String _VIEW_PROGRAMME = "SELECT  * FROM Programmes";
	public static final String _SELECT_PROGRAMMEID = "select programmeidref from STUDYCENTERPROGRAMMES where centeridref=?";
	public static final String _SELECT_PROGRAMME_DATA = "select * from PROGRAMMES where programmeid=?";
	public static final String _VIEW_STUDENT_PROGRAMME = "SELECT  * FROM Programmes where programmeid=?";
	
	
	// StudyCenterProgrammes
	public static final String _ADD_STUDEY_CENTER_PROGRAMME = "insert into STUDYCENTERPROGRAMMES values((select nvl(max(CENTERPROID),100)+1 from STUDYCENTERPROGRAMMES),?,?,sysdate,'Active',?)";
	public static final String _VIEW_STUDEY_CENTERS = "insert into STUDYCENTERPROGRAMMES values((select nvl(max(CENTERPROID),100)+1 from STUDYCENTERPROGRAMMES),?,?,sysdate,'Active',?)";
	public static final String _VIEW_STUDENT = "select * from userdetails where userid=?";
	// News
	public static final String _ADD_NEWS = "insert into news values((select nvl(max(newsid),100)+1 from news),?,?,?,?,?,sysdate)";
	public static final String _VIEW_NEWS = "select * from news order by newstype,newsdate desc";

	public static final String _CHECK_USER = "select userid,logintype,fullname from userdetails  where loginid=? and password=? and status='Active'";
	public static final String _CHANGE_PASSWORD = "update userdetails set password=? where userid=?";
	public static final String _EMPLOYEEID = "select nvl(max(userid),1000)+1 from userdetails";
	public static final String _DELETE_EMPLOYEE = "update employee set leftdate=sysdate where employeeidref=?";
	public static final String _UPDATE_EMPLOYEE = "update employee set job=?,hiredate=?,departmentno=?,salary=? where employeeidref=?";
	public static final String _ADD_SALARY = "insert into employee_salaries values(?,?,sysdate,?,'Active')";

	// Admission
	public static final String _ADD_SELECT_STUDY_CENTER = "insert into STUDENTSTUDYCENTERSELECTION values((select nvl(max(SELECTIONCENTERID),100)+1 from STUDENTSTUDYCENTERSELECTION),?,?,?,?,?,sysdate,'selected')";
	public static final String _ADD_STUDENT_CERTIFIFCATE = "insert into STUDENTDOCUMENTS values((select nvl(max(STUDOCID),100)+1 from STUDENTDOCUMENTS),?,?,?,?,sysdate,'pending')";
	public static final String _SELECT_STUDY_CENTERS = "select centeridref from STUDYCENTERPROGRAMMES where PROGRAMMEIDREF=?";
	public static final String _SELECT_STUDYCENTER_DATA = "select * from STUDYCENTERS where CENTERID=?";
	public static final String _VIEW_ADMISSION_STUDENTS = "select * from userdetails,REGISTRAIONFEEDETAILS,STUDENTSTUDYCENTERSELECTION where logintype='Student' and userdetails.status='Active' and userdetails.userid=STUDENTSTUDYCENTERSELECTION.studnetid and STUDENTSTUDYCENTERSELECTION.STUDNETID=userdetails.userid and STUDENTSTUDYCENTERSELECTION.programmeid=? and REGISTRAIONFEEDETAILS.STUDENTIDREF=STUDENTSTUDYCENTERSELECTION.studnetid";
	public static final String _VIEW_STUDENT_ADMISSION_STUDYCENTER = "select selectioncenterid,studnetid,programmeid,dateofselected,status," +
			"(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDYCENTERNAME1)," +
			"(select centerName from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDYCENTERNAME1)," +
			"(select centercode from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDYCENTERNAME1)," +
			"(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME2)," +
			"(select centerName from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME2)," +
			"(select centercode from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME2)," +
			"(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME3)," +
			"(select centerName from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME3)," +
			"(select centercode from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME3)," +
			"(select fullname from userdetails where userdetails.userid=?)," +
			"(select programmename from programmes where programmes.programmeid=?)," +
			"(select seats from STUDYCENTERPROGRAMMES where programmeidref=? and centeridref=(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDYCENTERNAME1))," +
			"(select seats from STUDYCENTERPROGRAMMES where programmeidref=? and centeridref=(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME2))," +
			"(select seats from STUDYCENTERPROGRAMMES where programmeidref=? and centeridref=(select centerid from STUDYCENTERS where centerid=STUDENTSTUDYCENTERSELECTION.STUDEYCENTERNAME3))from STUDENTSTUDYCENTERSELECTION where studnetid=?";
	public static final String _VIEW_STUDENT_ADMISSION_DOCUMENT = "select * from STUDENTDOCUMENTS where studentidref=?";

	// holidays
	public static final String _ADD_HOLIDAY = "insert into Holiday values((select nvl(max(holidayid),100)+1 from holiday),?,?,?)";
	public static final String _VIEW_HOLIDAYS = "select * from holiday";
	public static final String _VIEW__UPDATE_HOLIDAYS = "select * from holiday where holidayid=?";
	public static final String _UPDATE_HOLIDAYS = "update holiday set holidaydesc=?,dates=to_date(?,'dd/mm/yyyy'),day=? where holidayid=?";
	public static final String _DELETE_HOLIDAY = "delete Holiday where holidayid=?";
	public static final String _VIEW_MONTH_HOLIDAYS = "select * from holiday where to_char(to_date(dates,'dd/mm/yyyy'),'mon')=to_char(to_date(?,'dd/mm/yyyy'),'mon')";

	// mails
	public static final String _MAIL_CONTACTS = "select userid,loginid from userdetails";
	public static final String _SEND_MAIL = "insert into inbox_mails  values((select nvl(max(messageid),100)+1 from inbox_mails),?,?,?,?,sysdate)";
	public static final String _SEND_MAIL1 = "insert into outbox_mails values((select nvl(max(messageid),100)+1 from outbox_mails),?,?,?,?,sysdate)";
	public static final String _VIEW_OUT_MAILS = "select * from outbox_mails where frommailid=?";
	public static final String _VIEW_OUT_MAIL = "select * from outbox_mails where messageid=?";
	public static final String _VIEW_IN_MAILS = "select * from inbox_mails  where tomailid=?";
	public static final String _VIEW_IN_MAIL = "select * from inbox_mails  where messageid=?";
	public static final String _VIEW_MAILID = "select loginid from userdetails where userid=?";
	public static final String _DELETE_MAIL = "delete outbox_mails where messageid=?";
	public static final String _DELETE_MAIL1 = "delete inbox_mails  where messageid=?";

	//Allotment
	public static final String _UPDATE_CERTIFICATE_STATUS = "update STUDENTDOCUMENTS set status=? where studocid=?";
	public static final String _STUDYCENTER_ALLOTMENT = "insert into STUDENTSTUDYCENTERSELECTED values((select nvl(max(SELECTEDID),100)+1 from STUDENTSTUDYCENTERSELECTED),?,?,?,sysdate,'Alloted')";
	public static final String _UPDATE_SELECT_STUDYCENTER_SEATS = "select seats from STUDYCENTERPROGRAMMES where PROGRAMMEIDREF=? and CENTERIDREF=?";
	public static final String _UPDATE_STUDYCENTER_SEATS = "update STUDYCENTERPROGRAMMES set seats=?  where PROGRAMMEIDREF=? and CENTERIDREF=?";
	public static final String _SEAT_ALLOTED = "update STUDENTSTUDYCENTERSELECTION set status='SeatAlloted'  where PROGRAMMEID=? and STUDNETID=?";
	public static final String _ALLOTED_STUDENTS = "select SELECTEDID," +
			"(select userid from userdetails where userid=(select STUDENTID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select fullname from userdetails where userid=(select STUDENTID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select centerid from STUDYCENTERS where centerid=(select STUDYCENTERCONFORMATIONID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select centername from STUDYCENTERS where centerid=(select STUDYCENTERCONFORMATIONID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select centercode from STUDYCENTERS where centerid=(select STUDYCENTERCONFORMATIONID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select programmeid from PROGRAMMES where programmeid=(select PROGRAMMEID from STUDENTSTUDYCENTERSELECTED where studentid=?))," +
			"(select programmename from PROGRAMMES where programmeid=(select PROGRAMMEID from STUDENTSTUDYCENTERSELECTED where studentid=?)),dateofalloted,status from STUDENTSTUDYCENTERSELECTED where PROGRAMMEID=?";

	public static final String _SELECT_STUDENTID = "select studentid from STUDENTSTUDYCENTERSELECTED where PROGRAMMEID=?";
	
	
	
}