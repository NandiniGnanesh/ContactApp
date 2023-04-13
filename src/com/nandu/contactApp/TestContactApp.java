package com.nandu.contactApp;

public class TestContactApp {

	public static void main(String[] args) {
		
		try {
			
			ContactApp obj = new ContactApp();
			obj.startContactApp();
			
		} catch (Exception e) {
	
			e.printStackTrace();
			
		}
	}

}
