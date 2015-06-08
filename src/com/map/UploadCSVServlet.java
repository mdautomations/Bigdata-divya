package com.map;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;


public class UploadCSVServlet extends HttpServlet 
{
	private static final Logger log	=	Logger.getLogger(UploadCSVServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		try
		{
			BlobstoreService blobstoreService	=	BlobstoreServiceFactory.getBlobstoreService();
			Map<String,BlobKey> blobs	=	blobstoreService.getUploadedBlobs(request);
			BlobKey blobKey	=	blobs.get("data");
			if(blobKey==null)
			{
				response.sendRedirect("/");
			}
			else
			{
				response.sendRedirect("/upload-success?blob-key="+blobKey.getKeyString());
			}
		}
		catch(Exception e)
		{
			
		}
	}
	

}
