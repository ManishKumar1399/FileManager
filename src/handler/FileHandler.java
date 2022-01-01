package handler;

import java.io.File;

import java.util.Scanner;

public class FileHandler {

	public static void main(String[] args) {

		File directory = new File("D:\\FileManager");

		// check in this folder is the main folder is there ofr not
		if (checkmain(directory)) {// if present
			// System.out.println("Already present main");
		} else {
			// System.out.println("Creating Main ");
			directory = new File("D:\\FileManager\\main");
			directory.mkdir();
		}
		// print welcome screen

		printWelcomeScreen(directory);

	}

	private static void printWelcomeScreen(File directory) {

		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Welcome to the File Handler 1.0 by Manish Kumar");
			System.out.println("In this program you are having some options to select from");
			System.out.println("Select 1 : If you want to retrieve all the files inside main folder");
			System.out.println("Select 2 : If you want to display secoundary Menu to Perform File Operations");
			System.out.println("Select 3 : If you want to End the Program");

			n = sc.nextInt();
			switch (n) {
			case 1: {

				// print files inside main directory;
				printMainDirectory(directory);

				break;
			}
			case 2: {
				displaySecoundaryMenu(sc, directory);
				n = 3;
				break;

			}
			case 3: {
				System.out.println("Program Terminated Sucessfuly");
				n = 3;
				break;

			}
			default:
				System.out.println("Enter Valid Input\n");
				break;
			}
		} while (n != 3);

		sc.close();

	}

	private static void displaySecoundaryMenu(Scanner sc, File directory) {
		int n;
		do {
			System.out.println("Select 1: If you want to add files in ain folder");
			System.out.println("Select 2: If you want to input delete a file");
			System.out.println("Select 3: If you want to get list of file names starting with your input");
			System.out.println("Select 4: If you want to return to previous menu");
			System.out.println("Select 5: If you want to End the Program");

			n = sc.nextInt();
			switch (n) {
			case 1: {
				System.out.println("Which file do you want to add with its extension");
				String name = sc.next();
				File make = new File(directory.getAbsolutePath() + "\\main" + "\\" + name);
				make.mkdir();
				break;
			}
			case 2: {
				System.out.println("Which file do you want to delete");
				String name = sc.next();
				directory = new File(directory.getAbsolutePath() + "\\main\\" + name);
				System.out.println(directory.getAbsolutePath());
				if (directory.delete()) {
					System.out.println("File deleted successfully");
				} else {
					System.out.println("Failed to delete the file");
				}

				break;
			}
			case 3: {
				System.out.println("Enter the file name which you wanted to search");
				String name = sc.next();
				directory = new File(directory.getAbsolutePath() + "\\main");
				String[] list = directory.list();
				if (list == null) {
					System.out.println("There is no such files");
				} else {
					for (String demo : list) {
						if (demo.startsWith(name)) {
							System.out.println(demo);
						}
					}
				}
				break;
			}
			case 4: {
				System.out.println("returned to previous menu");

				break;
			}
			case 5: {
				System.out.println("Program Terminated Sucessfuly");

				break;
			}
			default:
				System.out.println("Enter Valid Input");

			}

		} while (n != 5);
		sc.close();

	}

	private static void printMainDirectory(File directory) {

		directory = new File(directory.getAbsolutePath() + "\\main");
		String[] list = directory.list();
		if (list == null) {
			System.out.println("There is no such files");
		} else {
			for (String demo : list) {
				
					System.out.println(demo);
				
			}
		}
		// System.out.println(directory.getAbsolutePath());
		// System.out.println(directory.getPath());

	}

	private static boolean checkmain(File directory) {

		String[] list = directory.list();
		for (String demo : list) {
			// System.out.println(demo);
			if (demo.equals("main")) {

				return true;
			}
		}

		return false;
	}

}
