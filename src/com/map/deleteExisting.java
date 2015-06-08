package com.map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.LockException;
import com.csvreader.CsvReader;
import com.map.PMF;
import com.map.Entry;
public class deleteExisting extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log	=	Logger.getLogger(UploadCSVServlet.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		mini();
		mini2();
	}
	public void mini()
	{
		String 							status 					= 		null;
		   PersistenceManager  pm 								= 		null;
		   Query                          queryUserDetails		=		null;
		   List<actualprob> 					usersInfo				=		null;
		   try
		   {
		        pm             								   	=      PMF.get().getPersistenceManager();
		        queryUserDetails        				   	   	=  	   pm.newQuery(actualprob.class);
		        usersInfo           					   	   	=      (List<actualprob>) queryUserDetails.execute();
		        if( usersInfo != null && !usersInfo.isEmpty() )
		   	 	{
		   		   for( actualprob values:usersInfo )
		   			 {
		   			       if(values!=null)
		   			       {
		   			    	   pm.deletePersistentAll(values);
		   			       }
		   			 }
		   	 	}
		   }
		   catch(Exception e)
		   {
			   System.out.println("Exception while deleting");
		   }
		   finally
		   {
			   pm.close();
		   }
	}
	public void mini2()
	{
			String 							status 					= 		null;
		   PersistenceManager  pm 								= 		null;
		   Query                          queryUserDetails		=		null;
		   List<emissionprob> 					usersInfo		=		null;
		   try
		   {
		        pm             								   	=      PMF.get().getPersistenceManager();
		        queryUserDetails        				   	   	=  	   pm.newQuery(emissionprob.class);
		        usersInfo           					   	   	=      (List<emissionprob>) queryUserDetails.execute();
		        if( usersInfo != null && !usersInfo.isEmpty() )
		   	 {
		   		   for( emissionprob values:usersInfo )
		   			 {
		   			       if(values!=null)
		   			       {
		   			    	   pm.deletePersistentAll(values);
		   			       }
		   			 }
		   	 }
		   }
		   catch(Exception e)
		   {
			   System.out.println("Exception while deleting");
		   }
		   finally
		   {
			   pm.close();
		   }
	}
}



