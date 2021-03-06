package com.main.my;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" },
			initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName != "" && userName != null){
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		out.println("Hello from GET! " + userName);
		out.println("Session parameter has username as " + session.getAttribute("savedUserName"));
		out.println("Context parameter has username as " + context.getAttribute("savedUserName"));
		out.println("Init parametet has username as " + 
				getServletConfig().getInitParameter("defaultUser"));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//		PrintWriter writer = response.getWriter();
		//		writer.println("<h1 style=\"color:red\">Hello from PrintWriter</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST  method!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.println("Hello from POST! :) " + userName + ". Your full name: " + fullName);
		String prof = request.getParameter("prof");
		out.print("<br>" + "You are: " + prof);
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.print("<br>" + "You are: " + location.length + " places.");
		for(int i = 0; i < location.length; i++){
			out.println(location[i]);
		}
	}

}
