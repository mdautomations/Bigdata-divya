package com.map.mapper;

import java.util.logging.Logger;

import org.apache.hadoop.io.NullWritable;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.mapreduce.AppEngineMapper;
import com.google.appengine.tools.mapreduce.BlobstoreRecordKey;
import com.google.appengine.tools.mapreduce.DatastoreMutationPool;

public class ImportFromBlobstoreMapper extends AppEngineMapper<BlobstoreRecordKey, byte[], NullWritable, NullWritable> 
{
	private static final Logger log	=	Logger.getLogger(ImportFromBlobstoreMapper.class.getName());
	
	@Override
	public void map(BlobstoreRecordKey key,byte[] segment,Context context)
	{
		try
		{
			String line 			= new String(segment);
			System.out.println("line : "+line);
			log.info("At offset: " + key.getOffset());
			log.info("Got value: " + line);
			
			String[] values 		= line.split(",");
			
			Long id 				= Long.parseLong(values[0]);
			Long dateAdded 			= Long.parseLong(values[1]);		
			Double value 			= Double.parseDouble(values[2]);
			Integer property 		= Integer.parseInt( values[3]);
			Integer plugid		 	= Integer.parseInt( values[4]);
			Integer household_id 	= Integer.parseInt(values[5]);
			Integer house_id		= Integer.parseInt(values[6]);
			
			Entity Advertisement = new Entity("Advertisement", id);
			Advertisement.setProperty("dateAdded", dateAdded);
			Advertisement.setProperty("value", value);
			Advertisement.setProperty("Adult Content", property);
			Advertisement.setProperty("Languages", plugid);
			Advertisement.setProperty("Avg visits per day", household_id);
			Advertisement.setProperty("Trust", house_id);
			log.info("Advertisement : property" +property);
		
			
				DatastoreMutationPool mutationPool = this.getAppEngineContext(context).getMutationPool();
				mutationPool.put(Advertisement);
		}
		catch(Exception e)
		{
			log.log(java.util.logging.Level.SEVERE,e.getMessage(),e);
		}
	}

}
