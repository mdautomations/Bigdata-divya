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
public class processhmm extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log	=	Logger.getLogger(UploadCSVServlet.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		baumwelch call = new baumwelch();
		call.dice();
	}
}



