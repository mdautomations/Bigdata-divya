package com.map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class actualprob{	

		private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent
		private String CTR;
		@Persistent
		private String CPM;
		@Persistent
		private String CPA;
		
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
		public String getCPA() {
			return CPA;
		}
		public void setCPA(String cPA) {
			CPA = cPA;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	}

