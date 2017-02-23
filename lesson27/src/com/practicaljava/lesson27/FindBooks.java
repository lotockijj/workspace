package com.practicaljava.lesson27;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindBooks
 */

@WebServlet(urlPatterns="/books", name="FindBooks" )
public class FindBooks extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// The code processing request goes here
		// The resulting Web page will be sent back via the
		// I/O stream that response variable contains
		PrintWriter out = response.getWriter();
		out.println("Hello from FindBooks");
	}
}