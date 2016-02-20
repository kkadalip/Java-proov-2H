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


import dao.UserDAO;

import model.User;

public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller Default doGet");
		doStuff(request);
		//request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller Default doPost");
		//response.sendRedirect("Search");
	}
	
	
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
	private List<User> getAllUsers(HttpServletRequest request){
		List<User> allUsers = new ArrayList<User>();
		dao.UserDAO userDao = new dao.UserDAO();
		try {
			allUsers = userDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}
	
	
}
