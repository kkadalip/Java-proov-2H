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

public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(true);
		
		System.out.println("Controller [Default][doGet]");
//		doStuff(request);
		doStuff(httpSession);
		doStuffSectors(httpSession);
//		doStuffSectors(request, session);
		//request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		// WAS HERE request.getRequestDispatcher("index.jsp").forward(request, response);
		
		// TODO FIX using (String) case sometimes java.lang.ClassCastException: java.io.ObjectStreamClass cannot be cast to java.lang.String
		String userName = "";
		if(httpSession.getAttribute("userName") != null){
			userName = httpSession.getAttribute("userName").toString();
			System.out.println("[Default][doGet] Session has attribute userName: " + userName);
		}else{
			System.out.println("[Default][doGet] no userName ");
		}
		//String userName = (String) httpSession.getAttribute("userName").toString(); //session.getAttribute("userName").toString(); // http://stackoverflow.com/questions/3521026/java-io-objectstreamclass-cannot-be-cast-to-java-lang-string
		//System.out.println("[Default][GET] session username is: " + userName);

		Boolean checkbox_checked = (Boolean) httpSession.getAttribute("checkbox_checked");
		System.out.println("Default GET checkbox_checked" + checkbox_checked);
		String[] selectedSectors = (String[]) httpSession.getAttribute("selectedSectors");
		if(selectedSectors != null){
			for(String selectedSector : selectedSectors){
				System.out.println("DEFAULT GET sector: " + selectedSector.toString());
			}
			//System.out.println("Default GET selectedSectors: " + selectedSectors);
		}else{
			System.out.println("Default GET selectedSectors: null");
		}
		
		// The client won't get the request back
		
//		request.setAttribute("SESSIONuserName", userName);
//		request.setAttribute("SESSIONcheckbox_checked", checkbox_checked);
//		request.setAttribute("SESSIONselectedSectors", selectedSectors); // TODO
//		
//		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
		httpSession.setAttribute("SESSIONuserName", userName);
		httpSession.setAttribute("SESSIONcheckbox_checked", checkbox_checked);
		httpSession.setAttribute("SESSIONselectedSectors", selectedSectors); // TODO
		
		System.out.println("[Default][GET] END");
		
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(true);
		
		System.out.println("Controller [Default][doPost]");
		
		String userName = (String) request.getParameter("userNameDefault").toString();
		httpSession.setAttribute("userName", userName);
		System.out.println("[Default][doPost] username is: " + userName);
		
		//String checkbox_checked = request.getParameter("accept_terms");
		Boolean checkbox_checked = request.getParameter("accept_terms") != null;
		httpSession.setAttribute("checkbox_checked", checkbox_checked);
		System.out.println("[Default][doPost] checkbox_checked: " + checkbox_checked); 
		
//		if(checkbox_checked == null){
//			System.out.println("checkbox NOT checked");
//		}else{
//			System.out.println("checkbox IS checked");
//		}
		
		String[] selectedSectors = request.getParameterValues("selectSectors"); // http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterValues%28java.lang.String%29
		httpSession.setAttribute("selectedSectors", selectedSectors); // PUTTING SELECTED SECTOR ID-S TO SESSION
		
		Set<Sector> userSectors = new HashSet<>();
		if(selectedSectors != null){
			System.out.println("Chosen sector amount: " + selectedSectors.length);			
			for(String sector : selectedSectors){
				System.out.println("sector in selectedSectors: " + sector.toString());
				
				SectorDao sDao = new SectorDao();
				Sector foundSector = sDao.getSectorById(Long.parseLong(sector));
				if(foundSector != null){
					System.out.println("[Default][Post] Foundsector: " + foundSector.toString());
					userSectors.add(foundSector);
				}else{
					System.out.println("[Default][Post] Foundsector: null!!!!");
				}
			}
			//System.out.println("[Default][doPost] selectedSectors: " + selectedSectors);
			//response.sendRedirect("Default");
			
			//response.sendRedirect("Search");
		}else{
			System.out.println("No sectors selected for user!");
		}
		
        try {
        	Long saved_user_id = (Long) httpSession.getAttribute("saved_user_id");
        	UserDao userDAO = new UserDao();
        	if(saved_user_id == null){	
        		System.out.println("[Default][Post] saved user id NULL, CREATING NEW USER");
	            //userDAO.addUserDetails(userName); //, password, email, phone, city);
	            User newUser = new User();
	            newUser.setName(userName);
	            newUser.setUser_sectors(userSectors);
	            newUser.setAgreedToTerms(checkbox_checked);
	            LocalDateTime date = LocalDateTime.now();
	            System.out.println("[Default][Post] going to save date:");
	            newUser.setDateAdded(date); // http://stackoverflow.com/questions/2305973/java-util-date-vs-java-sql-date
	            userDAO.addUser(newUser); // TODO in there fix one thing
	            System.out.println("[Default][Post] erm saved user id is: " + newUser.getId());
	            httpSession.setAttribute("saved_user_id", newUser.getId());
        	}else{
        		System.out.println("[Default][Post] saved user id NOT NULL: "+ saved_user_id +" , UPDATING EXISTING");
        		User existingUser = userDAO.getUserById(saved_user_id);
        		if(existingUser != null){
        			System.out.println("[Default][Post] existinguser NOT NULL, existing user name: " + existingUser.getName());
            		//System.out.println("[Default][Post] old username: " + existingUser.getName().toString());
            		System.out.println("[Default][Post] new username: " + userName);
            		existingUser.setName(userName); //(String) session.getAttribute("userName"));
            		userDAO.updateUser(existingUser);
        		}else{
        			System.out.println("[Default][Post] existinguser null!!!");
        		}
        	}
            
            //response.sendRedirect("Success");
        	//response.sendRedirect("Default");
        	response.sendRedirect("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
	// users
//	private void doStuff(HttpServletRequest request){
	private void doStuff(HttpSession session){
		//String behaviour = request.getParameter("do");
		//String searchString = request.getParameter("searchString");
		List<User> displayedUsers = new ArrayList<User>();
		/*
		if("delete".equals(behaviour)){
			UserDAO userDao = new UserDAO();
			try {
				//System.out.println("Deleting item that has id " + request.getParameter("id"));
				userDao.deleteByID(Integer.parseInt(request.getParameter("id")));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(searchString == null){
			displayedUnits = getAllUnits(request);
		}else{
			displayedUnits = searchUnits(request);
		}
		*/
//		displayedUsers = getAllUsers(request);
		displayedUsers = getAllUsers();
//		request.setAttribute("displayedUsers", displayedUsers);
		session.setAttribute("displayedUsers", displayedUsers);
	}
	
	// private void doStuffSectors(HttpServletRequest request, HttpSession session){
	private void doStuffSectors(HttpSession session){
		List<Sector> displayedSectors = new ArrayList<Sector>();
		//displayedSectors = getAllSectors(request);
//		displayedSectors = getAllSectorsLevel0(request);
		displayedSectors = getAllSectorsLevel0();
//		request.setAttribute("displayedSectors", displayedSectors);
		
		// Cannot serialize session attribute displayedUsers for session EF876FDBDE448EE29D4F0051B72B35FE
		// TODO FIX java.io.NotSerializableException: model.User
		// java.io.NotSerializableException: model.Sector and model.User
		//session.setAttribute("displayedSectors", displayedSectors);
		session.setAttribute("displayedSectors", new ArrayList<Sector>(displayedSectors));
	}
	
	private List<User> getAllUsers(){ //(HttpServletRequest request){
		List<User> allUsers = new ArrayList<User>();
		dao.UserDao userDao = new dao.UserDao();
		//try {
			allUsers = userDao.getAllUsers();
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
		return allUsers;
	}
	
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
	
//	private List<Sector> getAllSectorsLevel0(HttpServletRequest request){
	private List<Sector> getAllSectorsLevel0(){	
		System.out.println("[Default][getAllSectorsLevel0]");
		List<Sector> allSectors = new ArrayList<Sector>();
		dao.SectorDao sectorDao = new dao.SectorDao();
		allSectors = sectorDao.findAllLevel0();
		return allSectors;
	}
	
	
}
