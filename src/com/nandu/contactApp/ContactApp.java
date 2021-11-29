package com.nandu.contactApp;

import java.io.File;
import java.util.Scanner;

public class ContactApp {

	Scanner sc1;
	Scanner sc2;
	final String directory;
	File f;

	{
		sc1 = new Scanner(System.in);//used to input integer , double , float values etc,.
		sc2 = new Scanner(System.in);//used to input more than one character
		directory = System.getProperty("user.dir");
		System.out.println("current dir = " + directory);
		f = new File(directory);
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

				System.out.println("option 3 selected , logic yet to be implemented!!");
			}
			break;

			case 4: {

				System.out.println("option 4 selected , logic yet to be implemented!!");
			}
			break;

			case 5: {

				System.out.println("option 5 selected , logic yet to be implemented!!");
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

		try {

			System.out.println("Enter the name of a contact book");
			contactBookName = sc2.nextLine() + ".txt";

			File[] fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().equals(contactBookName)) {

					System.out.println("contact book already exists , enter another name or else enter back to go back to previous menu");
					temp = sc2.nextLine();

					if(temp.equals("back")) {

						startContactApp();

					}else {

						temp = temp + ".txt";

						checkIfNameExists(temp);

					}
					printEmptyLines(1);

				}else {

					f.createNewFile();
					//display menu 2 
					startToCreateContactBook();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void checkIfNameExists(String name) {

		String ContactBookname;

		try {

			File[] fileArray = f.listFiles();

			for(File file : fileArray) {

				if(file.getName().equals(name)) {

					System.out.println("name already exists!! enter another name or else enter back to go back to previous menu");
					ContactBookname = sc2.nextLine();

					if(ContactBookname.equals("back")){

						startContactApp();
						printEmptyLines(1);
					}else {

						checkIfNameExists(ContactBookname + ".txt");
					}
				}
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
