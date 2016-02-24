package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.UserDao;
import model.Sector;
import model.User;

public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller [Default][doGet]");
		doStuff(request);
		doStuffSectors(request);
		//request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller [Default][doPost]");
		
		String userName = request.getParameter("userNameDefault");
		System.out.println("[Default][doPost] username is: " + userName);
		
		String[] selectedSectors = request.getParameterValues("selectSectors"); // http://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterValues%28java.lang.String%29
		System.out.println("Chosen sector amount: " + selectedSectors.length);
		for(String sector : selectedSectors){
			System.out.println("sector in selectedSectors: " + sector.toString());
		}
		//System.out.println("[Default][doPost] selectedSectors: " + selectedSectors);
		//response.sendRedirect("Default");
		
		//response.sendRedirect("Search");
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
