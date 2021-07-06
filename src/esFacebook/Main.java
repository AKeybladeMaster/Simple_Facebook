package esFacebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// -----------------------------------------------------//
		Scanner sc = new Scanner(System.in);
		FbManager fb = new FbManager();

		String name = "", surname = "", user_tag = "", photo_name = "";
		Friend found = null;
		
		int menu_choice = 0;

		do {
			try {
			System.out.println("\nChoose what you want to do:");
			System.out.println("0. End the program");
			System.out.println("1. Add a friend");
			System.out.println("2. Print your list of friends");
			System.out.println("3. Find and print a friend");
			System.out.println("4. Add a photo and tag a friend");
			System.out.println("5. By choosing a friend, find in how many photos he/she was tagged");
			System.out.println("6. Find the most tagged friend in your photos");
			menu_choice = sc.nextInt();
			sc.nextLine();

			switch (menu_choice) {
			case 0:
				System.out.println("Program terminated.");
				System.exit(0);
			case 1:
				do {
					System.out.print("Type the name: ");
					name = sc.nextLine();
					System.out.print("Type the surname: ");
					surname = sc.nextLine();
					System.out.print("Type the age: ");
					int eta = sc.nextInt();
					sc.nextLine();
					user_tag = name + surname;
					fb.addPeople(new Friend(name, surname, eta, user_tag));
					System.out.println("His/Her user tag: " + user_tag);
					System.out.print("Do you want to add a new friend? (y/n)");
				} while (sc.nextLine().equalsIgnoreCase("y"));
				break;
			case 2:
				fb.printFriends();
				break;
			case 3:
				do {
					System.out.print("Type the name you're searching for: ");
					name = sc.nextLine();
					System.out.print("Type the surname you're searching for: ");
					surname = sc.nextLine();
					found = fb.find(surname, name);
					if (null != found) {
						System.out.println(fb.printAFriend(found));
					} else {
						System.out.println("Error. User not found.\n");
					}
					System.out.println("Do you want to search for another friend? (y/n)");
				} while (sc.nextLine().equalsIgnoreCase("y"));
				break;
			case 4:
				do {
					System.out.print("Type the name of the photo (no spaces allowed): ");
					photo_name = sc.next();
					sc.nextLine();
					System.out.println("The photo you added is: " + photo_name + ".jpg");
					System.out.println("Now type in your friend's info so you can tag him/her!");
					System.out.print("Type the name:");
					name = sc.nextLine();
					System.out.print("Type the surname:");
					surname = sc.nextLine();
					user_tag = name + surname;
					found = fb.find(surname, name);
					if (null != found) {
						fb.addPhoto(new Photo(photo_name, user_tag));
						System.out.println("Friend tagged!\n");
					} else {
						System.out.println("Error. User not found.\n");
					}
					System.out.println("Do you want to add another photo? (y/n) ");
				} while (sc.nextLine().equalsIgnoreCase("y"));
				break;

			case 5:
				do {
					System.out.print("Type the name: ");
					name = sc.nextLine();
					System.out.print("Type the surname: ");
					surname = sc.nextLine();
					user_tag = name + surname;
					found = fb.find(surname, name);
					if (null != found) {
						System.out.println("\nYour friend has been tagged " + fb.countUserTag(user_tag) + " times.\n");
					} else {
						System.out.println("Error. User not found.\n");
					}
					System.out.println("Do you want to search for another friend? (y/n)");
				} while (sc.nextLine().equalsIgnoreCase("y"));
				break;

			case 6:
				System.out.println(fb.findMostTaggedUser());
				break;
				
				default:
					System.out.println("Please type a correct number.");
					break;
			}
			} catch (InputMismatchException e) {
				System.out.println("I accept only correct inputs. Ending the program.");
				sc.nextLine();
			}
		} while (menu_choice != 0);

		sc.close();
	}
}