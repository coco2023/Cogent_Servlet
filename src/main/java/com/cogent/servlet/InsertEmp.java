package com.cogent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		try {
			String QUERY = "INSERT INTO employee VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn
                   .prepareStatement(QUERY);
  
            pstmt.setInt(1, Integer.valueOf(request.getParameter("empId")));
            pstmt.setString(2, request.getParameter("empName"));
            pstmt.setFloat(3, Float.valueOf(request.getParameter("salary")));
            
            pstmt.executeUpdate();
  
            // Close all the connections
            pstmt.close();
            conn.close();
  
            PrintWriter out = response.getWriter();
            out.println("Successfully Inserted!");
            			response.sendRedirect(request.getContextPath()+"/dbconn");
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
