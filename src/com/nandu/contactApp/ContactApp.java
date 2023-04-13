package com.nandu.contactApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ContactApp {

	Scanner sc1;
	Scanner sc2;
	final String directory;
	File[] fileArray;
	File f;
	BufferedReader br = null;

	{
		sc1 = new Scanner(System.in);//used to input integer , double , float values etc,.
		sc2 = new Scanner(System.in);//used to input more than one character
		directory = System.getProperty("user.dir");
		System.out.println("current dir = " + directory);
		//		f = new File(directory);

	}

	public void startContactApp() {

		int menuOneOption;

		try {

			menuOneOption = menuOne();
			processMenuOneSelectedOption(menuOneOption);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public int menuOne() {

		int choice = 0;
		try {

			menu(1);

			System.out.println("Press 1 to Create Contacts Book");
			System.out.println("Press 2 to Load Contacts Book");
			System.out.println("Press 3 to Search contacts");
			System.out.println("Press 4 to List contacts");
			System.out.println("Press 5 for Birthday reminders");
			System.out.println("Press 6 to Exit");
			printEmptyLines(1);

			System.out.println("Enter choice :");

			choice = sc1.nextInt();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return choice;

	}

	public void processMenuOneSelectedOption(int option) {

		try {

			switch (option) {

			case 1: {

				createContactBook();
			}
			break;

			case 2: {

				loadContactBook();
			}
			break;

			case 3: {

				searchContactBook();
			}
			break;

			case 4: {

				listContacts();
			}
			break;

			case 5: {

				birthdayRemainders();
			}
			break;

			case 6: {

				printEmptyLines(1);
				System.out.println("Bye bye :-) ");
				System.exit(0);

			}
			break;

			default:{

				System.out.println("Enter valid option");
				printEmptyLines(1);
				startContactApp();
			}
			break;

			}

			printEmptyLines(1);
			startContactApp();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void createContactBook() {

		String contactBookName;
		String temp;
		File f1 = null;
		boolean isContactBookExists = false;
		f = new File(directory);
		try {

			System.out.println("Enter the name of a contact book");
			contactBookName = sc2.nextLine() + ".txt";
			f1 = new File(contactBookName);

			fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().contains(".txt")) {



					if(file.getName().equals(contactBookName)) {

						isContactBookExists = true;

					}
				}

			}

			if(isContactBookExists == true) {

				System.out.println("contact book already exists , enter another name or else enter back to go back to previous menu");
				temp = sc2.nextLine();

				if(temp.equals("back")) {

					startContactApp();

				}else {

					temp = temp + ".txt";

					checkIfNameExists(temp);

				}
				printEmptyLines(1);

			}
			if(isContactBookExists == false){

				f1.createNewFile();
				startToCreateContactBook();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void checkIfNameExists(String name) {

		String ContactBookname;
		boolean isContactBookExists = false;
		f = new File(directory);
		File f1;

		try {

			f1 = new File(name);

			fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().contains(".txt")) {

					if(file.getName().equals(name)) {

						isContactBookExists = true;

					}
				}
			}

			if(isContactBookExists == true) {

				System.out.println("name already exists!! enter another name or else enter back to go back to previous menu");
				ContactBookname = sc2.nextLine();

				if(ContactBookname.equals("back")){

					startContactApp();
					printEmptyLines(1);
				}else {

					checkIfNameExists(ContactBookname + ".txt");
				}

			}else {

				f1.createNewFile();
				startToCreateContactBook();
				printEmptyLines(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void startToCreateContactBook() {

		int menuTwoOption;
		try {

			menuTwoOption = menuTwo(); 
			processMenuTwoSelectedOption(menuTwoOption);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int menuTwo() {

		int choice = 0;

		try {

			menu(2);

			System.out.println("Press 1 to Add a Contact");
			System.out.println("Press 2 to Edit a Contact");
			System.out.println("Press 3 to Remove a Contact");
			System.out.println("Press 4 to List the Contact");
			System.out.println("Press 5 to Search Contact");
			System.out.println("Press 6 to Go back");
			printEmptyLines(1);

			System.out.println("Enter choice :");
			choice = sc1.nextInt();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return choice;
	}

	public void processMenuTwoSelectedOption(int option) {

		try {

			switch (option) {

			case 1: {

				System.out.println("option 1 selected , logic yet to be implemented");
			}
			break;

			case 2: {

				System.out.println("option 2 selected , logic yet to be implemented");
			}
			break;

			case 3: {

				System.out.println("option 3 selected , logic yet to be implemented");
			}
			break;

			case 4: {

				System.out.println("option 4 selected , logic yet to be implemented");
			}
			break;

			case 5: {

				System.out.println("option 5 selected , logic yet to be implemented");
			}
			break;

			case 6: {

				System.out.println("going back to previous menu");
				startContactApp();
				printEmptyLines(1);

			}
			break;

			default:{

				System.out.println("Enter valid option!");
				startToCreateContactBook();
				printEmptyLines(1);

			}
			break;
			}

			printEmptyLines(1);
			startToCreateContactBook();
			printEmptyLines(1);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void loadContactBook() {

		int contactNumber;
		String ContactBookName;
		f = new File(directory);

		boolean isValidContactNumber = false;
		int count1 = 1;
		int count2 = 1;

		try {

			if(checkIfAnyContactBookExists()) {

				fileArray = f.listFiles();

				System.out.println("Select any of the contact books listed below, else enter 0 to go back to the previous menu");
				for(File file : fileArray) {

					if(file.getName().contains(".txt")){

						System.out.println((count1++) + "." +file.getName());
					}
				}

				System.out.println("Enter a contact book number :");
				contactNumber = sc1.nextInt();//2

				if(contactNumber == 0) {

					startContactApp();
					printEmptyLines(1);

				}else {

					for(File file : fileArray) {

						if(file.getName().contains(".txt")){

							ContactBookName = count2 + "." +file.getName();
							if(count2 == contactNumber) {

								isValidContactNumber = true;
							}
							count2++;
						}
					}

					if(isValidContactNumber == true) {

						startToCreateContactBook();
						printEmptyLines(1);

					}
					if(isValidContactNumber == false) {

						checkIfValidContactBookNumberEntered();

					}	
				}

			}else {

				System.out.println("No contact book is present, please create a contact book before proceeding.");
				printEmptyLines(1);
				startContactApp();

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean checkIfAnyContactBookExists() {

		boolean isExists = true;
		int count = 0;
		f = new File(directory);


		try {

			fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().contains(".txt")){

					count++;
				}
			}

			if(count == 0) {

				isExists = false;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return isExists;
	}

	public void checkIfValidContactBookNumberEntered() {

		int contactBookNumber;
		String ContactBookName;
		boolean isValidContactNumber = false;
		f = new File(directory);

		int count = 1;
		try {

			System.out.println("Invalid contact book selected, enter valid contact book number else enter 0 to go back to previous menu.");

			System.out.println("Enter a contact book number : ");
			contactBookNumber = sc1.nextInt();//2

			if(contactBookNumber == 0) {

				startContactApp();
				printEmptyLines(1);

			}else {

				for(File file : fileArray) {

					if(file.getName().contains(".txt")){

						ContactBookName = count + "." +file.getName();

						if(count == contactBookNumber) {

							isValidContactNumber = true;
						}
						count++;
					}

				}

				if(isValidContactNumber == true) {

					startToCreateContactBook();
					printEmptyLines(1);

				}else {

					checkIfValidContactBookNumberEntered();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void searchContactBook() {

		String contactName;
		String temp;

		try {

			if(checkIfAnyContactBookExists()) {

				System.out.println("Enter contact name to search");
				contactName = sc2.nextLine();

				if(contactName.equals("")) {

					System.out.println("invalid contact name , enter a valid name or else enter back to goback to previous menu");
					temp = sc2.nextLine();

					if(temp.equals("back")) {

						startContactApp();
						printEmptyLines(1);

					}else {

						isValidNameEntered(temp);
					}
				}else {

					validContactNameEnteredforSearching(contactName);

				}
			}else {

				System.out.println("No contacts present to search, please create a contact book and add contacts before searching.");
				printEmptyLines(1);
				startContactApp();

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void isValidNameEntered(String name) {

		String contactName;

		try {

			if(name.equals("")) {

				System.out.println("invalid contact name , enter a valid name or else enter back to goback to previous menu");
				contactName = sc2.nextLine();

				if(contactName.equals("back")) {

					startContactApp();
					printEmptyLines(1);

				}else {

					isValidNameEntered(contactName);

				}

			}else {

				validContactNameEnteredforSearching(name);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void validContactNameEnteredforSearching(String contactName) {

		String line;
		boolean isSearchKeyPresent;
		String temp;
		f = new File(directory);

		try {

			System.out.println("search key : " +contactName);
			fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().contains(".txt")){

					br = new BufferedReader(new FileReader(file.getCanonicalPath()));

					temp = file.getName();
					System.out.println((temp.substring(0 , (temp.length() - 4))));

					printEmptyLines(1);
					isSearchKeyPresent = false;

					while((line = br.readLine()) != null) {

						String[] arr = line.split(":");			
						if(arr[0].contains(contactName)) {

							System.out.println(line);
							isSearchKeyPresent = true;
						}
					}

					if(isSearchKeyPresent == false) {

						System.out.println("no contacts present with given search criteria");

					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void listContacts() {
		
		f = new File(directory);
		String temp;
		String line;
		boolean isAnyContactsExists;
		
		try {
			
			if(checkIfAnyContactBookExists()) {
				
				fileArray = f.listFiles();
				
				for(File file : fileArray) {
					
					if(file.getName().contains(".txt")) {
						
						br = new BufferedReader(new FileReader(file.getCanonicalPath()));
						isAnyContactsExists = false;
						
						temp = file.getName();
						System.out.println(temp.substring(0 , (temp.length() - 4)));
						
						while((line = br.readLine()) != null){
						
							System.out.println(line);
							isAnyContactsExists = true;
							
						}
						
						if(isAnyContactsExists == false) {
							
							System.out.println("no contacts to list");
						}
						
					}
				}
				
				printEmptyLines(1);
				startContactApp();
				
			}else {
				
				System.out.println("No contacts to list, please create a contact book and add contacts before listing.");
				printEmptyLines(1);
				startContactApp();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

	public void birthdayRemainders() {
		
		Date date;
		SimpleDateFormat formatter ;
		String currentDate;
		boolean isAnyContactsExists;
		String temp;
		String line;
		String[] stringArr;
		String dob;
		
		try {
			
			if(checkIfAnyContactBookExists()) {
				
				 date = new Date();
			     formatter = new SimpleDateFormat("dd-MM-yyyy");
			     
			     currentDate = formatter.format(date);
			     System.out.print("Current date: "+currentDate);
			     printEmptyLines(1);
			     
			     fileArray = f.listFiles();
					
					for(File file : fileArray) {
						
						if(file.getName().contains(".txt")) {
							
							br = new BufferedReader(new FileReader(file.getCanonicalPath()));
							isAnyContactsExists = false;
							
							temp = file.getName();
							System.out.println(temp.substring(0 , (temp.length() - 4)));
							
							while((line = br.readLine()) != null){
							
								isAnyContactsExists = true;							
								stringArr = line.split(":");
								
								dob = stringArr[3];
								if(dob.equals(currentDate)) {
									
									System.out.println(line);
								}
								
							}
							
							if(isAnyContactsExists == false) {
								
								System.out.println("no contacts to list");
							}
							
							printEmptyLines(1);
							
						}
					}
					
					startContactApp();
					printEmptyLines(1);
			      
			}else {
				
				System.out.println("No contacts to list, please create a contact book and add contacts before getting birthday reminders.");
				printEmptyLines(1);
				startContactApp();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void printEmptyLines(int num) {

		for(int i = 0 ; i <= num; i++) {

			System.out.println("");
		}
	}

	public void menu(int num) {

		System.out.println("---------------------------------------------------------");
		System.out.println("                       Menu "+num+"                      ");
		System.out.println("---------------------------------------------------------");
	}
}
