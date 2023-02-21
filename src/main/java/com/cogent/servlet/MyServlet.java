package com.cogent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Hi")
public class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
			
			out.println("<html>");
	        out.println("<head>");
	        out.println("<title> Hello Keyu! </title>");
	        out.println("</head>");

	        out.println("<body style='background-color: #ffff00;'>");
	        out.println("<h1> Hi! Keyu </h1>");
			out.println("<h2> Today is </h2>");
			out.println("<h3> February 21, 2023 </h3>");
			out.println("</body>");
			out.println("</html>");

	}
	
}
