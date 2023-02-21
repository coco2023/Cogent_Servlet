package com.cogent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dbconn")
public class DatabaseAccess extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/batch65";
	static final String USER = "root";
	static final String PASS = "12345";
	Connection conn = null;


	public void init(ServletConfig sc) throws ServletException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		PrintWriter out = response.getWriter();		

		out.println("<html>");
        out.println("<head>");
        out.println("<title> Database </title>");
        out.println("</head>");
        
        out.println("<body style='background-color: #ffff00;'>");
        out.println("<h1> Hi! Keyu </h1>");
		out.println("<h2> Today is </h2>");
		out.println("<h3> February 21, 2023 </h3>");
		
		try {
			
// init()
//		Class.forName(JDBC_DRIVER);
//		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
		Statement stmt = this.conn.createStatement();
		String QUERY = "SELECT * FROM employee";
		
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			int id = rs.getInt("empId");
			String name = rs.getString("empName");
			float salary = rs.getFloat("salary");
			
			out.println("id: " + id);
			out.println(", name: " + name);
			out.println(", salary: " + salary + "<br>");
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
		rs.close();
		stmt.close();
		
// destroy()
//		conn.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void destroy() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
}
