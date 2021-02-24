package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayerListServlet extends HttpServlet {
	
	public void init() {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Player List</h3>");
		out.println("<table>");
		
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>Name</th>");
		out.print("<th>Country</th>");
		out.print("<th>Sports</th>");
		out.print("</tr>");
		
		new PlayerService().getAllPlayers()
		.forEach(player->{
		out.print("<tr>");
		out.print("<td>"+player.getPlayerid()+"</td>");
		out.print("<td>"+player.getPlayername()+"</td>");
		out.print("<td>"+player.getCountry()+"</td>");
		out.print("<td>"+player.getSports()+"</td>");
		out.print("</tr>");
		});
		out.println("</table>");
	}

}
