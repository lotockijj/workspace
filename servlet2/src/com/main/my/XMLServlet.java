package com.main.my;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(description = "A simple servlet", urlPatterns = { "/XMLServletpath" })
public class XMLServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.println("<h1 style=\"color:green\">Hello from PrintWriter</h1>");
	}
}
