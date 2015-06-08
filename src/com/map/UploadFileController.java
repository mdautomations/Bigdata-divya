package com.map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class UploadFileController extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log	=	Logger.getLogger(UploadCSVServlet.class.getName());
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{

		Double			 		CTR,CPM,CPC,CR,CPA;
		BlobstoreService 		blobstoreService 		= 			BlobstoreServiceFactory.getBlobstoreService();
		Map<String, List<BlobKey>> 		blobs			= 			blobstoreService.getUploads(request);
		List<BlobKey>			blobKey 				= 			blobs.get("UploadFile");
		BlobKey 				blobKey1 				= 			blobKey.get(0);
		FileService 			fileServices 			= 			FileServiceFactory.getFileService();
		AppEngineFile 			fileURL 				= 			fileServices.getBlobFile(blobKey1);
		FileReadChannel			readChannel 			= 			null;

		try
		{
					readChannel 	= 		fileServices.openReadChannel(fileURL, true);
		}
		catch (FileNotFoundException e)
		{
					log.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
		}
		catch (LockException e)
		{
					log.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
		}
		catch (IOException e)
		{
					log.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
		}

		BufferedReader 			breader 					=				new BufferedReader(Channels.newReader(readChannel,"ISO-8859-1"));
		CsvReader 				reader						=				new CsvReader(breader);
		Entry  					entry						=				null;
		List<Entry> 			entrylist					=				new ArrayList<Entry>();
		reader.readHeaders();
		System.out.println("reader ::"+reader.getColumnCount());
		System.out.println("reader ::"+reader.getHeaderCount());
		mini();
		while (reader.readRecord())
		{
					entry						=				new Entry();
					UUID 		uniqueKey		= 				UUID.randomUUID();
					String 		clicks 			= 				reader.get("clicks");
					String 		impressions 	= 				reader.get("impressions");
					String 		conversions 	=				reader.get("conversions");
					String 		advertiser_cost = 				reader.get("advertiser");
					String  	items			=				reader.get("items");
					String  	location		=				reader.get("location");
					String  	session			=				reader.get("session");
					String  	category		=				reader.get("category");
					String 		images			=				reader.get("images");
					System.out.println("clicks :: "+clicks+"impressions :: "+impressions+"conversions ::"+conversions+"advertiser_cost :: "+advertiser_cost);
					System.out.println("items :: "+items+"location :: "+location+"session ::"+session+"category :: "+category);
					CTR 			= 					(Double.parseDouble(clicks) / Double.parseDouble(impressions)) * 100;
					CPM 			= 					(Double.parseDouble(advertiser_cost) * 1000) / Double.parseDouble(impressions);
					CPC 			= 					Double.parseDouble(advertiser_cost)/Double.parseDouble(clicks);
					CR				=					(Double.parseDouble(conversions)/Double.parseDouble(impressions))*100;
					CPA				= 					Double.parseDouble(advertiser_cost) / (Double.parseDouble(impressions)*CTR*CR);
					entry.setItems(items);
					entry.setLocation(location);
					entry.setSession(Integer.parseInt(session));
					entry.setCategory(category);
					entry.setClicks(Double.parseDouble(clicks));
					entry.setAdvertisers(Double.parseDouble(advertiser_cost));
					entry.setConversions(Double.parseDouble(conversions));
					entry.setImpresssions(Double.parseDouble(impressions));
					entry.setKey(uniqueKey.toString());
					entry.setCTR(CTR);
					entry.setCPM(CPM);
					entry.setImages(images);
					entry.setCPC(CPC);
					entry.setCR(CR);
					entry.setCPA(CPA);
					entrylist.add(entry);
		}
		reader.close();
		
		if(entrylist !=null && entrylist.size() !=0)
		{
					try 
					{
						Boolean 		status		=			persistClientPlanDetailsList(entrylist);
					} catch (Exception e) {
						e.printStackTrace();
					}
		}
	
	}
	public Boolean persistClientPlanDetailsList(List<Entry> deviceSyncInfoList) throws Exception
	{
		PersistenceManager		 pm 							= 				PMF.get().getPersistenceManager();
					Boolean							lFlag		=			false;
			try 
			{
					
					List<Entry>	syncList		=				(List<Entry>) pm.makePersistentAll(deviceSyncInfoList);
					if(syncList!=null && !syncList.isEmpty())
					{
							lFlag		=		true;
					}
			}
			catch (Exception e) 
			{
					log.log( java.util.logging.Level.INFO  , e.getMessage() ,  e);
			}
			finally
			{
				if(pm !=null)
				{
						pm.close();
				}
			}
			return lFlag;
	}
	
	public void mini()
	{
		String 							status 					= 		null;
		   PersistenceManager  pm 								= 		null;
		   Query                          queryUserDetails		=		null;
		   List<Entry> 					usersInfo				=		null;
		   try
		   {
		        pm             								   	=      PMF.get().getPersistenceManager();
		        queryUserDetails        				   	   	=  	   pm.newQuery(Entry.class);
		        usersInfo           					   	   	=      (List<Entry>) queryUserDetails.execute();
		        if( usersInfo != null && !usersInfo.isEmpty() )
		   	 {
		   		   for( Entry values:usersInfo )
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



