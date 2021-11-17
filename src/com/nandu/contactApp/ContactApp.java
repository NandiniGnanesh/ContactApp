package com.nandu.contactApp;

import java.util.Scanner;

public class ContactApp {

	public void start() {

		int mainMenuOption = 0;

		try {

			mainMenuOption = showContactAppMainMenu();
			processMainMenuSelectedOption(mainMenuOption);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private void processMainMenuSelectedOption(int selectedOption) {

		switch (selectedOption) {

			case 1: {
				System.out.println("Option 1 selected. Logic yet to be implemented!!");
			}
			break;
	
			case 2: {
				System.out.println("Option 2 selected. Logic yet to be implemented!!");
			}
			break;
	
			case 3: {
				System.out.println("Option 3 selected. Logic yet to be implemented!!");
			}
			break;
	
			case 4: {
				System.out.println("Option 4 selected. Logic yet to be implemented!!");
			}
			break;
	
			case 5: {
				System.out.println("Option 5 selected. Logic yet to be implemented!!");
			}
			break;
	
			case 6: {
				printEmptyLines(2);
				System.out.println("Bye bye :-)");
				System.exit(0);
			}
			break;
	
			default:{
				System.out.println("Enter valid option!!");
				printEmptyLines(1);
				start();
			}	
			break;
		
		}

		printEmptyLines(1);
		start();

	}

	private int showContactAppMainMenu(){
		
		Scanner sc;
		int choice = 0;

		try {
			
			sc = new Scanner(System.in);

			System.out.println("Press 1 to Create Contacts Book");
			System.out.println("Press 2 to Load Contacts Book");
			System.out.println("Press 3 to Search contacts");
			System.out.println("Press 4 to List contacts");
			System.out.println("Press 5 for Birthday reminders");
			System.out.println("Press 6 to Exit");
			printEmptyLines(1);
			System.out.println("Enter choice : ");

			choice = sc.nextInt();

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return choice;
	}

	public static void printEmptyLines(int num) {

		for(int i = 1 ; i <= num; i++) {
			System.out.println("");
		}
		
	}

}

