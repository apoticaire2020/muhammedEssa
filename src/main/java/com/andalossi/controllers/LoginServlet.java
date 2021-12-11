package com.andalossi.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andalossi.validates.CheckValidateUser;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	private CheckValidateUser checkValidateUser = new CheckValidateUser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
      // System.out.println(req.getParameter("name"));
    	
    	req.setAttribute("name", req.getParameter("name"));
    	req.setAttribute("password", req.getParameter("password"));
    	
        req.getRequestDispatcher("/WEB-INF/views/login.jsp")
        .forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	String nom =req.getParameter("name");
    	String pass =req.getParameter("password");
    	
    	
    	
    	boolean isvalid= checkValidateUser.checkValidate(nom, pass);
    	if (isvalid) {
    		req.setAttribute("name" , nom);
        	req.setAttribute("password" , pass);
    		 req.getRequestDispatcher("/WEB-INF/views/home.jsp")
    	        .forward(req, resp);
		}
    	else {
    		req.setAttribute("msgError", "name invalid or pass invalid");
    		 req.getRequestDispatcher("/WEB-INF/views/login.jsp")
    	        .forward(req, resp);
		}
    	
       
    }
    
}
