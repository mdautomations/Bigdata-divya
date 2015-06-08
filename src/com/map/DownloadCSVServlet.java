package com.map;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class DownloadCSVServlet extends HttpServlet
{
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException 
	{
		        BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
		        blobstoreService.serve(blobKey, res);
    }
	/*public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		String blobKey	=	request.getParameter("blob-key");
		response.setContentType("text/html");
		response.getWriter().println("Successfuly uploaded the content");
		response.getWriter().println("<a href='/serve?blob-key=" + blobKey+ "'>Click to download</a>");
		}
		catch(Exception e)
		{
			
		}
	}*/

}
