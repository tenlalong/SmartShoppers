package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Store extends Product {
	
	public int storeID;
	public String storeName;
	public String storeLocation;
	public String openTime;
	public String closeTime;
	
	public Store (int storeID, String storeName, String storeLocation,
			String openTime, String closeTime) {
		super();
		this.storeID = storeID;
		this.storeName = storeName;
		this.storeLocation = storeLocation;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public Store() {
		// TODO Auto-generated constructor stub
	}

	public int getStoreID() {
		return storeID;
	}
	
	// No need to create a getter method for storeID, since you cannot change a primary key
	/*
	public void setStoreID(int storeID) {
		
	}
	*/
	
	public String getStoreName() {
		return storeName;
	}
	
	public String getStoreLocation() {
		return storeLocation;
	}
	
	public String getOpenTime() {
		return openTime;
	}
	
	public String getCloseTime() {
		return closeTime;
	}

	public void setName(String storeName) {
		this.storeName = storeName;
	}
	
	public void setLocation(String location) {
		this.storeLocation = location;
	}
	
	public void setOpen(String openTime) {
		this.openTime = openTime;
	}
	
	public void setClose(String closeTime) {
		this.closeTime = closeTime;
	}
}
