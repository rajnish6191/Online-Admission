<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AboutUs.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<table cellspacing="10" cellpadding="0" border="0">
			<tbody>
				<tr>
					<td height="30" colspan="2" align="center" valign="middle"
						class="pageheader">
						<b>About University</b>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" class="bodytext">
						<div align="justify">
							Situated in the heart of the city at Kukatpally a major landmark-
							Jawaharlal Nehru Technological University, Hyderabad has an
							environment of academic excellence with &lsquo;A&rsquo; Grade
							accreditation by NAAC (National Assessment and Accreditation
							Council). Bringing the spark of knowledge to young minds and
							instilling a new confidence and vigour to face the world,it is
							providing quality education for nearly 4 decades.
							<br />
							<br />
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td valign="middle" align="left" style="height: 18px"
											class="head1">
											<strong>Districts<br /> </strong>
										</td>
									</tr>
									<tr>
									</tr>
								</tbody>
							</table>
							The territorial jurisdiction of the university covers the areas
							of Hyderabad, Ranga Reddy, Medak, Nizamabad, Adilabad,
							Karimnagar, Warangal, Khammam, Nalgonda and Mahboobnagar
							districts of Andhra Pradesh State.
						</div>
					</td>
					<td width="317" rowspan="5" align="center" valign="top"
						class="bodytext">
						<span><img border="0" src="./images/jntu.png" /> </span>
						<br />
						<br />
						<div align="justify">
							&ldquo;Reading makes a man wise&rdquo; goes a saying. In tune
							with this, the university library enhances learning through its
							collection of 20,000 books and subscribes to 95 technical
							journals. It also has abstracts of 120 journals with the National
							Centre for Science Information, IISc, Bangalore through
							INFLIBNET. In addition to this, an audio-visual library is
							installed containing colour T.V &rsquo;s and VCR&rsquo;s with
							video tapes on various subjects. Field-based learning like
							Current Affairs, Reference services, Online searching are
							provided. Upgradation plans are also in store like creating a
							computerized database in the fields of science, Engineering,
							Technology and Management. Bringing the wealth of knowledge from
							the comfort of the library to the masses is another venture by
							its participation in the local area computerized network systems
							to share information resources.
							<br />
							<br />
							Industrial knowledge forms a part and parcel of JNTU,Hyderabad.
							An Entrepreneurship Development Cell (EDC) was established by the
							Department of Science and Technology to create a
							business-oriented environment, to promote small and medium
							Enterprises(SME&rsquo;s) and NGO&rsquo;s, to organize
							lectures,T.V. and Radio talks, skill development training program
							etc.To get a hands-on experience of the industry,the JNTU Bureau
							of Industrial Consultancy Services(BICS) was formed to aid in the
							Human Resource needs, to identify R&amp;D developments, to engage
							in entrepreneurial opportunities and to Icoordinate with
							organizations like HUDA, MCH, APSRTC, APSEB, BHEL, NTPC, ONGC,
							Telecommunications Department,MES,South Central Railway, Airport
							Authority of India and many others.
						</div>
						<div align="justify">
							<br />
							Even though Research constitutes the academic framework,the
							university has an exclusive R&amp;D cell which monitors all the
							research activities and coordinates them through the
							recommendations of faculty members. Extension activities form
							part of campus life, apart from academics. The National Service
							Scheme(NSS) is introduced with an aim to help students develop a
							humanitarian temper. Commendable work done were laying of roads,
							Janmabhoomi Clean &amp;Green program, Famine and Cyclone relief
							work.
							<br />
							<br />
							Society is an integral part of our lives and our contribution
							however small matters a lot. A coordinator is posted at the NSS
							cell to undertake social service activities. A Grievance
							Redressal Cell is established with the motto of looking into the
							complaints and suggestions by staff and students. A director is
							appointed for this purpose. Backward section students are given
							utmost care and privileges.JNTU Hyderabad has a separate SC/ST
							cell to look after them. Scholarships too are provided from time
							to time.
							<br />
							<br />
							Right career directions should be provided in order to explore
							one&rsquo;s talents fully.In keeping with this,a Centre for
							Career Advancement and Resource Development (CARD) has been
							established. Some of its goals are to prepare the students for
							competitive exams like GATE, ECET, EAMCET with the assistance of
							Social and Tribal Welfare Departments Govt of Andhra Pradesh,
							Ministry of Social Justice and Empowerment,Govt of India.
							Additional facilities are the Bank, Post-office and Health-care
							centre.
							<br />
							<br />
							Grooming students for placements and helping them make a fruitful
							career is the topmost priority after learning.World famous
							companies like Wipro, Infosys, Satyam, Tata Consultancy
							Services(TCS), Birla Soft,Yahoo,Google and many others walk out
							with brilliant talent in exchange for huge pay packets and
							dynamic careers giving the university its due credit of a
							fulfilling future.
							<br />
							<br />
							Fine-tuning the skill of the faculty is a regular feature here.
							For this purpose,the Academic Staff College(ASC) was instituted
							which conducts Refresher courses for Principals, Heads, Lecturers
							and also to evaluate, plan and implement innovative teaching
							methods.
							<br />
							<br />
							As a consecutive whole, JNTU Hyderabad helps build many a bright
							and ambitious career. Hence,
							<br />
							<strong><em>Walk in with dreams and Walk out with
									reality! </em> </strong>
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" align="left" style="height: 10px">
						<br />
					</td>
				</tr>
				<tr>
					<td valign="top" align="left" class="bodytext">
						<div align="justify">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td valign="middle" align="left" style="height: 18px"
											class="head1">
											<strong>Administration<br /> </strong>
										</td>
									</tr>
									<tr>

									</tr>
								</tbody>
							</table>
							This university has been deemed an autonomous one after Act No 30
							of the approval of the Andhra Pradesh Legislature known as the
							Jawaharlal Nehru Technological Universities Act, 2008 which came
							into force on 18th August, 2008. It is a teaching cum research
							oriented university consisting of the constituent and affiliated
							colleges. The main officers and councils of the university are
							Chancellor, Vice-chancellor, Rector, Executive council and
							Academic Senate. The Governor of Andhra Pradesh shall be the
							Chancellor of the university. The first vice-chancellor of the
							university is Dr.D.N.Reddy a brilliant administrator and widely
							read scholar.
							<br />
							<br />
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td valign="middle" align="left" style="height: 18px"
											class="head1">
											<strong>Constituent Units<br /> </strong>
										</td>
									</tr>
									<tr>

									</tr>
								</tbody>
							</table>
							Picking out bright students from the rural backgrounds through
							its impartial selection system and honing them according to the
							needs and requirements of today&rsquo;s cut-throat competitive
							world, thereby preparing them for a challenge called
							&ldquo;life&rdquo; is what this university excels in.
							<br />
							<br />
							Fully autonomous now, after an act of the Andhra Pradesh
							Legislative Council Bills 1&amp;2 with effect from 18th August
							2008,the colleges that come under this university are :
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" align="left">
						<table cellspacing="0" cellpadding="0" border="0" align="center">
							<tbody>
								<tr>

									<td width="290" align="left" valign="middle" class="bodytext"
										style="height: 25px">
										JNTU College of Engineering,Hyderabad(CEH)
									</td>
								</tr>
								<tr>

									<td valign="middle" align="left" style="height: 25px"
										class="bodytext">
										JNTU College of Engineering, Karimnagar
									</td>
								</tr>
								<tr>

									<td valign="middle" align="left" style="height: 25px"
										class="bodytext">
										JNTU School of Information Technology (SIT)
									</td>
								</tr>
								<tr>

									<td valign="middle" align="left" style="height: 25px"
										class="bodytext">
										JNTU Institute of Science and Technology (IST)
									</td>
								</tr>
								<tr>

									<td valign="middle" align="left" style="height: 25px"
										class="bodytext">
										JNTU School of Management Studies (SMS)
									</td>
								</tr>
								<tr>

									<td valign="middle" align="left" style="height: 25px"
										class="bodytext">
										JNTU Academic Staff College (ASC).
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top" align="left" class="bodytext">
						<div align="justify">
							A premier institution with academic and research -oriented
							courses, the B.Tech programs (Undergraduate programs) are about
							25. Major branches among them are Aeronautical Engineering,
							Automobile, Biotechnology, Information Technology, Electronics,
							Electrical, Instrumentation &amp;Control, Metallurgy, Mechanical,
							Bio-medical, Civil and many more. A few courses are also offered
							through the correspondence cum contact mode. The Post-Graduate
							programs form about 77 in number namely M.Tech, MSIT,MBA,MCA and
							MSc. The major branches are Bio-Technology, Chemical Engineering,
							Civil Engineering, Remote-Sensing &amp;GIS, Electronics&amp;
							Communication Engineering, Water Resources, Mechanical
							Engineering, Nano-Technology, Energy Systems, Environmental
							Studies, Microbiology, Food-Technology and many more like
							Management, Computer Applications, Pharmaceutical Sciences etc.
							<br />
							<br />
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td valign="middle" align="left" style="height: 18px"
											class="head1">
											<strong>Global Colloboration<br /> </strong>
										</td>
									</tr>
									<tr>

									</tr>
								</tbody>
							</table>
							To make our students get a wide global exposure, a few
							collaborative programs with International Universities of repute
							have been designed. Some of them are 1)School of Information
							Technology (SIT) with Carnegie Mellon University, USA, 2)School
							of Management Studies with Central Michigan University,USA 3)
							JNTU College of Engineering, Hyderabad with Kansas State
							University USA 4) JNTU Hyderabad with Blekinge Institute of
							Technology,Sweden.
							<br />
							<br />
							Knowledge has no barriers -indepth exploration of it is essential
							to discover hidden areas. Keeping this principle in mind the
							university offers Research -Oriented courses like Master of
							Science(MS) in Engineering, Master of Philosophy (M.Phil) in
							Science and Humanities and Doctor of philosophy (Ph.D) in all
							streams.The admission procedure centres around merit.The
							admission to B.Tech courses are through the ranks acquired in the
							State wide common entrance examination i.e Engg Agriculture
							Medicine Common entrance examination(EAMCET exam) conducted by
							the A.P. State Council for Higher Education.
							<br />
							<br />
							Entry to the post-graduate courses like MBA and MCA are by the
							scores in the ICET examination. Admission to M.Tech programs are
							based on the GATE or an entrance test conducted by the university
							with the basic eligibility criteria being a Bachelor&rsquo;s
							degree in the appropriate field. For admission to Research
							programs, stringent rules are followed. Admission to MS course
							which is a Research degree in Engineering consists of an Entrance
							test and Interview. M.Phil is offered through an interview mode,
							for post-graduate holders. The theory exam has to be cleared
							followed by submission of thesis based on their Research work.
							The Ph.D program is flexible in nature with full-time and
							part-time external programs. Admission is for candidates
							possessing post graduation in the concerned area followed by a
							written test and interview. Passing the Pre Ph.D exam is a must
							followed by submission of research work. For external
							registration the candidate must be employed in any Research&amp;
							Development organization with permission to use the library
							facilities. Along with this a Research Supervisor must be chosen
							from his parent organization and another one from the university.
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
	</body>
</html>
