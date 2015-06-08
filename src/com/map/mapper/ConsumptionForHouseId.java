package com.map.mapper;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.hadoop.io.NullWritable;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.mapreduce.AppEngineMapper;
import com.google.appengine.tools.mapreduce.MapperContext;

public class ConsumptionForHouseId extends AppEngineMapper<Key,Entity,NullWritable,NullWritable>
{
//	HttpSession session = ;
//	session.setAttribute("values", "null");
//	long consumptionvaluefinal	= 0;
	private static final Logger log	=	Logger.getLogger(ConsumptionForHouseId.class.getName());
	
	public void map(Key key, Entity value, Context context) throws IOException, InterruptedException
	{
		log.info("inside Mapper");
		
		long houseIDToMatch = Long.valueOf( context.getConfiguration().get("mapreduce.mapper.counter.substringtarget"));
		
		long house_id			=	(long)value.getProperty("id");
		Double consumption		=	(double)(value.getProperty("value"));
		long consumptionvalue	=	consumption.longValue();
//		System.out.println("house_id : " +house_id);
//		System.out.println("consumptionvalue : " +consumptionvalue);
//		log.info("house_id : " +house_id);
		
		System.out.println("Advertisement value is this ::"+house_id);
		System.out.println("Id to match value is this ::"+houseIDToMatch);
		
		if(house_id==houseIDToMatch) 
		{
			context.getCounter("Advertisement", "count").increment(consumptionvalue);
//			long valuess = Integer.parseInt((String) session.getAttribute("values"));
//			long finalvalue = valuess + consumptionvalue;
//			session.setAttribute("values", finalvalue);
//			System.out.println("consumptionvaluefinal outside is this ::"+session.getAttribute("values"));
		}
//		String finalvalues  = (String) session.getAttribute("values");
//		System.out.println("the sting sdfkj shdk  :: "+finalvalues);
	}

}
