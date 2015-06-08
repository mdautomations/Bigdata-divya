//package com.map;
//
//import static com.google.appengine.api.taskqueue.TaskOptions.Builder.withUrl;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Logger;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.appengine.api.taskqueue.Queue;
//import com.google.appengine.api.taskqueue.QueueFactory;
//import com.google.appengine.api.taskqueue.TaskOptions.Method;
//
//
//public class BackUp extends HttpServlet{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = Logger.getLogger(BackUp.class.getPackage().getName());
//	public void doGet(HttpServletRequest request,HttpServletResponse rsponse)
//	{
//		logger.info("going to run back up");
//		
//		DateFormat sdf = new SimpleDateFormat("yyyy/MMM/dd");
//		
//		String currentDate = sdf.format(new Date());
//		Queue queue = QueueFactory.getQueue("backupqueue");	
//		
//		queue.add(withUrl("/_ah/datastore_admin/backup.create").method(Method.GET).param("name", "BackupToCloud").param("kind", "").param("filesystem", "gs").param("gs_bucket_name", "/gs/full_backup/ACTI/FullJobs/" + currentDate));
//	}
//
//}
