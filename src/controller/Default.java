package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
//import java.time.Clock;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.SectorDao;
import dao.UserDao;
import model.Sector;
import model.User;

public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Controller [Default][doGet]");
		doStuff(request);
		doStuffSectors(request);
		//request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		
		System.out.println("Controller [Default][doPost]");
		
		String userName = request.getParameter("userNameDefault");
		session.setAttribute("userName", userName);
		System.out.println("[Default][doPost] username is: " + userName);
		
		//String checkbox_checked = request.getParameter("accept_terms");
		Boolean checkbox_checked = request.getParameter("accept_terms") != null;
		session.setAttribute("checkbox_checked", checkbox_checked);
		System.out.println("[Default][doPost] checkbox_checked: " + checkbox_checked); 
		
//		if(checkbox_checked == null){
//			System.out.println("checkbox NOT checked");
//		}else{
//			System.out.println("checkbox IS checked");
//		}
		
		String[] selectedSectors = request.getParameterValues("selectSectors"); // http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterValues%28java.lang.String%29
		session.setAttribute("selectedSectors", selectedSectors); // PUTTING SELECTED SECTOR ID-S TO SESSION
		
		Set<Sector> userSectors = new HashSet<>();
		if(selectedSectors != null){
			System.out.println("Chosen sector amount: " + selectedSectors.length);			
			for(String sector : selectedSectors){
				System.out.println("sector in selectedSectors: " + sector.toString());
				
				SectorDao sDao = new SectorDao();
				Sector foundSector = sDao.getSectorById(Long.parseLong(sector));
				System.out.println("[Default][Post] Foundsector: " + foundSector.toString());
				System.out.println("");
				userSectors.add(foundSector);
			}
			//System.out.println("[Default][doPost] selectedSectors: " + selectedSectors);
			//response.sendRedirect("Default");
			
			//response.sendRedirect("Search");
		}else{
			System.out.println("No sectors selected for user!");
		}
		
        try {
            UserDao userDAO = new UserDao();
            //userDAO.addUserDetails(userName); //, password, email, phone, city);
            User newUser = new User();
            newUser.setName(userName);
            newUser.setUser_sectors(userSectors);
            newUser.setAgreedToTerms(checkbox_checked);
            LocalDateTime date = LocalDateTime.now();
            System.out.println("going to save date:");
            newUser.setDateAdded(date); // http://stackoverflow.com/questions/2305973/java-util-date-vs-java-sql-date
            userDAO.addUser(newUser);
            System.out.println("[UserControllerServlet]");
            response.sendRedirect("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	// users
	private void doStuff(HttpServletRequest request){
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
		displayedUsers = getAllUsers(request);
		request.setAttribute("displayedUsers", displayedUsers);
	}
	
	private void doStuffSectors(HttpServletRequest request){
		List<Sector> displayedSectors = new ArrayList<Sector>();
		//displayedSectors = getAllSectors(request);
		displayedSectors = getAllSectorsLevel0(request);
		request.setAttribute("displayedSectors", displayedSectors);
	}
	
	private List<User> getAllUsers(HttpServletRequest request){
		List<User> allUsers = new ArrayList<User>();
		dao.UserDao userDao = new dao.UserDao();
		//try {
			allUsers = userDao.findAll();
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
		return allUsers;
	}
	
	// LITERALLY GETS ALL (regardless of level/group)
	private List<Sector> getAllSectors(HttpServletRequest request){	
		System.out.println("[Default][getAllSectors]");
		List<Sector> allSectors = new ArrayList<Sector>();
		dao.SectorDao sectorDao = new dao.SectorDao();
		//try {
			allSectors = sectorDao.findAll();
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
		return allSectors;
	}
	
	private List<Sector> getAllSectorsLevel0(HttpServletRequest request){
		System.out.println("[Default][getAllSectorsLevel0]");
		List<Sector> allSectors = new ArrayList<Sector>();
		dao.SectorDao sectorDao = new dao.SectorDao();
		allSectors = sectorDao.findAllLevel0();
		return allSectors;
	}
	
	
}
