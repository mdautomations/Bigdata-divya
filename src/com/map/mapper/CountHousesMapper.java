package com.map.mapper;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.mapreduce.AppEngineMapper;

public class CountHousesMapper extends AppEngineMapper<Key,Entity,Key,Entity>
{
	private static final Logger log = Logger.getLogger(CountHousesMapper.class.getName());
	
	private DatastoreService datastore;

	@Override
	public void taskSetup(Context context) {
		this.datastore = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void map(Key key, Entity value, Context context)
	{
		log.info("inside Mapper");
	//	long houseIDToMatch = Long.valueOf( context.getConfiguration().get("mapreduce.mapper.counter.substringtarget"));
		long house_id			=	(long)value.getProperty("ID");
		//Double consumption		=	(double)(value.getProperty("value"));
		//long consumptionvalue	=	consumption.longValue();
		
		//System.out.println("consumptionvalue : " +consumptionvalue);
		
		log.info("Advertisement : " +house_id);
//		if(house_id==houseIDToMatch) 
//		{
			context.getCounter("SubstringMatch", "count").increment(1);
			
//		}	
			
	}

}
