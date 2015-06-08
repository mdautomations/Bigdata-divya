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
import com.google.appengine.tools.mapreduce.MapReduceState;

@SuppressWarnings("serial")
public class ConsumptionCallback extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try
		{
			String jobIdName = request.getParameter("job_id");
			System.out.println("jobIdName : " +jobIdName);
			
			JobID jobId	=	JobID.forName(jobIdName);
			DatastoreService ds	=	DatastoreServiceFactory.getDatastoreService();
			
			MapReduceState 	mrState		=	MapReduceState.getMapReduceStateFromJobID(ds, jobId);
			Counters 		counters	=	mrState.getCounters();
			CounterGroup 	counterGroup =	counters.getGroup("Consumptio");
			System.out.println("counterGroup :  "+counterGroup.getName()) ;
			Counter 		counter		=	counterGroup.findCounter("value");
			long 			wordCount	=	counter.getValue();
			System.out.println("wordCount : " +wordCount);
			
			Entity totalCountEntity	=	new Entity("TotalPowerConsumed","total_word_count");//column value.
			totalCountEntity.setProperty("count",wordCount);
			totalCountEntity.setProperty("updatedAt", new Date());
			ds.put(totalCountEntity);
		}
		catch(Exception e)
		{
			
		}
	}

}
