package com.cogent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/MyLifeCycle")
public class MyLifeCycleServlet implements Servlet{

	ServletConfig config = null;
	// 1
	@Override
	public void init(ServletConfig sc) throws ServletException {
		// TODO Auto-generated method stub
		config = sc;
		System.out.println("in init() method");
	}

	// 2
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h2>hello from life cycle servlet</h2>");
		System.out.println("in service");

	}
	
	// 3
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("in destroy");

	}

	// 4
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "LifeCycleServlet";
	}

	// 5
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	

}
