package com.map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadCSVSuccessServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		String blobKey	=	request.getParameter("blob-key");
		response.setContentType("text/html");
		response.getWriter().println("Successfuly uploaded the content");
		response.getWriter().println("<a href='/serve?blob-key=" + blobKey+ "'>Click to download</a>");
		response.getWriter().println("<a href='/'>Back To Home</a>");
		
		}
		catch(Exception e)
		{
			
		}
	}
}
