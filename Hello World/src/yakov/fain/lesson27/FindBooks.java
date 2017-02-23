package yakov.fain.lesson27;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/books", name="FindBooks")
public class FindBooks extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException{
		//The code processing request goes here
		//The resulting Web page will be sent back via the
		//I/O stream that response variable contains
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
//				PrintWriter out = response.getWriter();
//				out.println("Hello from FindBooks");
				PrintWriter out = response.getWriter();
				out.println("<html><body bgcolor=blue>");
				out.println("<h2>Hello from FindBooks!!</h2>");
	}
}
