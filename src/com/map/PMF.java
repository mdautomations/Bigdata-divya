package com.map;

import java.util.HashMap;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	
	private static PersistenceManagerFactory pmfInstance;

	static {
	    Map props = new HashMap();
	    props.put("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
	    props.put("javax.jdo.option.ConnectionURL", "appengine");
	    props.put("javax.jdo.option.NontransactionalRead", "true");
	    props.put("javax.jdo.option.NontransactionalWrite", "true");
	    props.put("javax.jdo.option.RetainValues", "true");
	    props.put("datanucleus.appengine.autoCreateDatastoreTxns", "true");
	    pmfInstance = JDOHelper.getPersistenceManagerFactory(props);
	}

	private PMF() {
	}

	public static PersistenceManagerFactory get() {
	    return pmfInstance;
	}

}