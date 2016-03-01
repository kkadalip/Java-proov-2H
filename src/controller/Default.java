package controller;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
//import java.time.Clock;
//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.plaf.synth.SynthSeparatorUI;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import dao.HibernateUtil;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;

//import dao.HibernateUtil;
import dao.SectorDao;
import dao.UserDao;
import model.Sector;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(Default.class); // info trace debug warn error

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("[doGet] START");

		HttpSession httpSession = request.getSession(true);

		List<User> displayedUsers = new ArrayList<User>();
		dao.UserDao userDao = new dao.UserDao();
		displayedUsers = userDao.getAllUsers();
		httpSession.setAttribute("displayedUsers", displayedUsers);

		List<Sector> displayedSectors = new ArrayList<Sector>();
		dao.SectorDao sectorDao = new dao.SectorDao();
		displayedSectors = sectorDao.getAllRootSectors();
		httpSession.setAttribute("displayedSectors", new ArrayList<Sector>(displayedSectors));

		String userName = (String) httpSession.getAttribute("userName");
		log.debug("[doGet] userName: {}", userName);

		Boolean checkbox_checked = (Boolean) httpSession.getAttribute("checkbox_checked");
		log.debug("[doGet] checkbox_checked: {}", checkbox_checked);

		String[] selectedSectors = (String[]) httpSession.getAttribute("selectedSectors");
		if(selectedSectors != null){
			for(String selectedSector : selectedSectors){
				log.debug("[doGet] sector: {}", selectedSector.toString());
			}
		}else{
			log.debug("[doGet] selectedSectors: null");
		}

		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("[doPost] START");
		HttpSession httpSession = request.getSession(true);

		String userName = (String) request.getParameter("userName").toString(); // userNameDefault
		httpSession.setAttribute("userName", userName);
		log.debug("[doPost] userName: {}", userName);

		Boolean checkbox_checked = request.getParameter("accept_terms") != null;
		httpSession.setAttribute("checkbox_checked", checkbox_checked);
		log.debug("[doPost] checkbox_checked: {}", checkbox_checked); 

		String[] selectedSectors = request.getParameterValues("selectSectors"); // http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterValues%28java.lang.String%29
		httpSession.setAttribute("selectedSectors", selectedSectors); // PUTTING SELECTED SECTOR ID-S TO SESSION

		Set<Sector> userSectors = new HashSet<>();
		if(selectedSectors != null){
			log.debug("[doPost] Chosen sectors amount: {}", selectedSectors.length);		
			for(String sector : selectedSectors){
				log.debug("[doPost] sector in selectedSectors: {}",sector.toString());
				SectorDao sDao = new SectorDao();
				Sector foundSector = sDao.getSectorById(Long.parseLong(sector));
				if(foundSector != null){
					log.debug("[doPost] Foundsector: {}", foundSector.toString());
					userSectors.add(foundSector);
				}else{
					log.debug("[doPost] Foundsector: null");
				}
			}
			//System.out.println("[Default][doPost] selectedSectors: " + selectedSectors);
		}else{
			log.debug("[doPost] No sectors selected for user!");
		}

		try {
			Long saved_user_id = (Long) httpSession.getAttribute("saved_user_id");
			UserDao userDAO = new UserDao();
			if(saved_user_id == null){	
				log.debug("[doPost] saved user id NULL, CREATING NEW USER");
				User newUser = new User();
				newUser.setName(userName);
				newUser.setUser_sectors(userSectors);
				newUser.setAgreedToTerms(checkbox_checked);
				LocalDateTime date = LocalDateTime.now();
				log.debug("[doPost] going to save date: {}", date);
				newUser.setDateAdded(date);
				userDAO.addUser(newUser);
				log.debug("[doPost] saved user id: {}", newUser.getId());
				httpSession.setAttribute("saved_user_id", newUser.getId());
			}else{
				log.debug("[doPost] saved user id NOT NULL: {}, UPDATING EXISTING" + saved_user_id);
				User existingUser = userDAO.getUserById(saved_user_id);
				if(existingUser != null){
					log.debug("[doPost] existinguser NOT NULL, existing user name: {}, new username: {}", existingUser.getName(), userName);
					existingUser.setName(userName); //(String) session.getAttribute("userName"));
					userDAO.updateUser(existingUser);
				}else{
					log.debug("[doPost] existinguser null!!!");
				}
			}
			// redirect here?
		}catch (Exception e) {
			log.error("Error adding or updating user", e); //should add e.printStackTrace(); automatically
		}
		response.sendRedirect(""); // Success
		log.info("[doPost] END");
	}
}













//userDAO.addUserDetails(userName); //, password, email, phone, city);

//private static final boolean ON = true;

// POST:
//String checkbox_checked = request.getParameter("accept_terms");	
//if(checkbox_checked == null){
//	System.out.println("checkbox NOT checked");
//}else{
//	System.out.println("checkbox IS checked");
//}

// GET:
//private List<User> getAllUsers(){ //(HttpServletRequest request){
//List<User> allUsers = new ArrayList<User>();
//dao.UserDao userDao = new dao.UserDao();
////try {
//	allUsers = userDao.getAllUsers();
////} catch (SQLException e) {
////	e.printStackTrace();
////}
//return allUsers;
//}	

//private List<Sector> getAllSectorsLevel0(HttpServletRequest request){
//private List<Sector> getAllSectorsLevel0(){	
//	System.out.println("[Default][getAllSectorsLevel0]");
//	List<Sector> allSectors = new ArrayList<Sector>();
//	dao.SectorDao sectorDao = new dao.SectorDao();
//	allSectors = sectorDao.findAllLevel0();
//	return allSectors;
//}

// LITERALLY GETS ALL (regardless of level/group)
/*
private List<Sector> getAllSectors(){ //(HttpServletRequest request){	
	System.out.println("[Default][getAllSectors]");
	List<Sector> allSectors = new ArrayList<Sector>();
	dao.SectorDao sectorDao = new dao.SectorDao();
	//try {
		allSectors = sectorDao.getAllSectors();
	//} catch (SQLException e) {
	//	e.printStackTrace();
	//}
	return allSectors;
}
 */

//used in doGET: doStuff(httpSession); //doStuff(request);	
//	private void doStuff(HttpSession session){ //private void doStuff(HttpServletRequest request){
//		//String behaviour = request.getParameter("do");
//		//String searchString = request.getParameter("searchString");
//		List<User> displayedUsers = new ArrayList<User>();
//		/*
//		if("delete".equals(behaviour)){
//			UserDAO userDao = new UserDAO();
//			try {
//				//System.out.println("Deleting item that has id " + request.getParameter("id"));
//				userDao.deleteByID(Integer.parseInt(request.getParameter("id")));
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if(searchString == null){
//			displayedUnits = getAllUnits(request);
//		}else{
//			displayedUnits = searchUnits(request);
//		}
//		*/
////		displayedUsers = getAllUsers(request);
//		displayedUsers = getAllUsers();
////		request.setAttribute("displayedUsers", displayedUsers);
//		session.setAttribute("displayedUsers", displayedUsers);
//	}

//doStuffSectors(httpSession); //doStuffSectors(request, session);
//// private void doStuffSectors(HttpServletRequest request, HttpSession session){
//private void doStuffSectors(HttpSession session){
//	List<Sector> displayedSectors = new ArrayList<Sector>();
//	//displayedSectors = getAllSectors(request);
////	displayedSectors = getAllSectorsLevel0(request);
//	displayedSectors = getAllSectorsLevel0();
////	request.setAttribute("displayedSectors", displayedSectors);
//	
//	// Cannot serialize session attribute displayedUsers for session EF876FDBDE448EE29D4F0051B72B35FE
//	// TODO FIX java.io.NotSerializableException: model.User
//	// java.io.NotSerializableException: model.Sector and model.User
//	//session.setAttribute("displayedSectors", displayedSectors);
//	session.setAttribute("displayedSectors", new ArrayList<Sector>(displayedSectors));
//}

//request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
// WAS HERE request.getRequestDispatcher("index.jsp").forward(request, response);

// The client won't get the request back
//request.setAttribute("SESSIONuserName", userName);
//request.setAttribute("SESSIONcheckbox_checked", checkbox_checked);
//request.setAttribute("SESSIONselectedSectors", selectedSectors);

//httpSession.setAttribute("SESSIONuserName", userName);
//httpSession.setAttribute("SESSIONcheckbox_checked", checkbox_checked);
//httpSession.setAttribute("SESSIONselectedSectors", selectedSectors);

// FIX using (String) case sometimes java.lang.ClassCastException: java.io.ObjectStreamClass cannot be cast to java.lang.String
//String userName = (String) httpSession.getAttribute("userName"); // Breaks it if not assigned -> .toString(); //session.getAttribute("userName").toString(); // http://stackoverflow.com/questions/3521026/java-io-objectstreamclass-cannot-be-cast-to-java-lang-string


//String userName = "";
//if(httpSession.getAttribute("userName") != null){
//	userName = (String) httpSession.getAttribute("userName"); //.toString();
//	System.out.println("[Default][doGet] Session has attribute userName: " + userName);
//}else{
//	System.out.println("[Default][doGet] no userName ");
//}
