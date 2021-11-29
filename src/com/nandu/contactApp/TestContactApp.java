package com.nandu.contactApp;

public class TestContactApp {

	public static void main(String[] args) {
		
//		final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);

		try {
			
			ContactApp obj = new ContactApp();
			obj.startContactApp();

		} catch (Exception e) {
	
			e.printStackTrace();
			
		}
	}

}
