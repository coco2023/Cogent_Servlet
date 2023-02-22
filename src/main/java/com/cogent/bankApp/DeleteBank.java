package com.cogent.bankApp;

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

@WebServlet("/DeleteBank")
public class DeleteBank extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			String QUERY = "DELETE FROM employee WHERE empId = ?";
            PreparedStatement pstmt = this.conn
                   .prepareStatement(QUERY);
  
            pstmt.setInt(1, Integer.valueOf(request.getParameter("empId")));
       
            pstmt.executeUpdate();
  
            pstmt.close();
            conn.close();
           			response.sendRedirect(request.getContextPath()+"/MainBankInfo");
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	

}
