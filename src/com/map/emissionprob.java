package com.map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class emissionprob{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent
		private String CTR;
		@Persistent
		private String CPM;
		@Persistent
		private String CPC;
		@Persistent
		private String CR;
		@Persistent
		private String CPA;
		@Persistent
		private String items;
		@Persistent
		private String location;
		@Persistent
		private String session;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getCTR() {
			return CTR;
		}
		public void setCTR(String cTR) {
			CTR = cTR;
		}
		public String getCPM() {
			return CPM;
		}
		public void setCPM(String cPM) {
			CPM = cPM;
		}
		public String getCPC() {
			return CPC;
		}
		public void setCPC(String cPC) {
			CPC = cPC;
		}
		public String getCR() {
			return CR;
		}
		public void setCR(String cR) {
			CR = cR;
		}
		public String getCPA() {
			return CPA;
		}
		public void setCPA(String cPA) {
			CPA = cPA;
		}
		public String getItems() {
			return items;
		}
		public void setItems(String items) {
			this.items = items;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getSession() {
			return session;
		}
		public void setSession(String session) {
			this.session = session;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
	}

