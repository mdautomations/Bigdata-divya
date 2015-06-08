package com.map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entry{	

		 private static final long serialVersionUID = 1L;
		@PrimaryKey
	 	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	 	private String key;	
		@Persistent
		private double clicks;
		@Persistent
		private double impresssions;
		@Persistent
		private double advertisers;
		@Persistent
		private double CTR;
		@Persistent
		private double CPM;
		@Persistent
		private double Conversions;
		@Persistent
		private double CPC;
		@Persistent
		private double CR;
		@Persistent
		private double CPA;
		@Persistent
		private String items;
		@Persistent
		private String location;
		@Persistent
		private int session;
		@Persistent
		private String category;
		@Persistent
		private String images;
		
		
		public double getConversions() {
			return Conversions;
		}
		public void setConversions(double conversions) {
			Conversions = conversions;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public double getClicks() {
			return clicks;
		}
		public void setClicks(double clicks) {
			this.clicks = clicks;
		}
		public double getImpresssions() {
			return impresssions;
		}
		public void setImpresssions(double impresssions) {
			this.impresssions = impresssions;
		}
		public double getAdvertisers() {
			return advertisers;
		}
		public void setAdvertisers(double advertisers) {
			this.advertisers = advertisers;
		}
		public double getCTR() {
			return CTR;
		}
		public void setCTR(double cTR) {
			CTR = cTR;
		}
		public double getCPM() {
			return CPM;
		}
		public void setCPM(double cPM) {
			CPM = cPM;
		}
		public double getCPC() {
			return CPC;
		}
		public void setCPC(double cPC) {
			CPC = cPC;
		}
		public double getCR() {
			return CR;
		}
		public void setCR(double cR) {
			CR = cR;
		}
		public double getCPA() {
			return CPA;
		}
		public void setCPA(double cPA) {
			CPA = cPA;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
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
		public int getSession() {
			return session;
		}
		public void setSession(int session) {
			this.session = session;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getImages() {
			return images;
		}
		public void setImages(String images) {
			this.images = images;
		}
	}

