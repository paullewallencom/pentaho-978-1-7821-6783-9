package com.pentaho.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstWebApp1 extends HttpServlet 
{
	private static final long serialVersionUID = 7132989867106106400L;

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		/**
		 * After executing the example change web.xml:
		 *   ...
		 *   <servlet-class>com.pentaho.webapp.MyFirstWebApp2</servlet-class> 
		 *   ...
		 * And start again the server.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>myFirstWebApp</title></head>");
		out.println("<body>");
		out.println("<p>This is the reply.</br>The servlet should render the report here.</p>");
		out.println("</body></html>");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}