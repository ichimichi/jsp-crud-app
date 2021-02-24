package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPlayerServlet extends HttpServlet {
	
	public void init() {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String sports = request.getParameter("sports");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(new PlayerService().addPlayer(new Player(id, name, country, sports))) {
			
			out.println("<h3>Player Added</h3>");
		}else {
			out.println("<h3>Error adding Player</h3>");
		}
		
		
		
	}

}
