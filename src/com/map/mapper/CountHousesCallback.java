package com.map.mapper;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.CounterGroup;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.JobID;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.tools.mapreduce.MapReduceState;

public class CountHousesCallback extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException
	{
		String jobIdName = req.getParameter("job_id");
		System.out.println("jobIdName : " +jobIdName);
		
		JobID jobId	=	JobID.forName(jobIdName);
		DatastoreService ds	=	DatastoreServiceFactory.getDatastoreService();
		try
		{
			MapReduceState 	mrState		=	MapReduceState.getMapReduceStateFromJobID(ds, jobId);
			Counters 		counters	=	mrState.getCounters();
//			CounterGroup 	counterGroup =	counters.getGroup("SubstringMatch");
			CounterGroup 	counterGroup =	counters.getGroup("SubstringMatch");
//			CounterGroup 	counterGroup1 =	counters.getGroup("EmployeeWords");
			
			System.out.println("counterGroup :  "+counterGroup.getName()) ;
			Counter 		counter		=	counterGroup.findCounter("count");
//			Counter 		counter1		=	counterGroup1.findCounter("count");
//			System.out.println("counter1 : "+counter1.getValue());
			long 			wordCount	=	counter.getValue();
			
			Entity totalCountEntity	=	new Entity("TotalConsumption","total_word_count");//column value.
			totalCountEntity.setProperty("count",wordCount);
			totalCountEntity.setProperty("updatedAt", new Date());
			ds.put(totalCountEntity);
		}
		catch(EntityNotFoundException e)
		{
			throw new IOException("no Datastore state");
		}
		catch(Exception e)
		{
			
		}
	}
}
