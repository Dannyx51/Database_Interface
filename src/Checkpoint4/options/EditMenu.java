package Checkpoint4.options;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Checkpoint4.utilities.Utilities;
import Checkpoint4.sql.SQL;

public class EditMenu {
	
	private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', 'x'));
	private static final String[] TABLES = {"Coach", "Team", "Player"};
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("EDIT MENU:\n"
				+ "1. Add\n"
				+ "2. Delete\n"
				+ "3. Update\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine();
		char selection = !input.isEmpty() ? input.charAt(0) : ' ';		
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Incorrect option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
		}
		
		Utilities.printDivider();
		System.out.print("TABLE SELECTION:\n"
				+ "1. Coach\n"
				+ "2. Team\n"
				+ "3. Player\n"
				+ "Input numerical selection (or 'x' to quit): ");
		input = cin.nextLine();
		char selection2 = !input.isEmpty() ? input.charAt(0) : ' ';
		
		while(!MENU_OPTIONS.contains(selection2)) {
			System.out.print("Incorrect option specified! Try again: ");
			input = cin.nextLine();
			selection2 = !input.isEmpty() ? input.charAt(0) : ' ';
		}
		
		Utilities.printDivider();
		
		if (selection2 == 'x') { return; }
		
		switch(selection) {
			case '1':
				addEntry(cin, TABLES[selection2 - '0' - 1]);
				break;
			case '2':
				deleteEntry(cin, TABLES[selection2 - '0' - 1]);
				break;
			case '3':
				updateEntry(cin, TABLES[selection2 - '0' - 1]);
			default:
				break;
		}
		Utilities.printDivider();
	}
	
	private static void addEntry(Scanner cin, String table) {
		System.out.print("Enter artist name: ");
		String artist_name = cin.nextLine().trim();

		if (artist_name.isEmpty()) {
			System.out.println("Artist name cannot be empty!");
			return;
		}

		
    }
	
	private static void deleteEntry(Scanner cin, String table) {
		
	}
	
	private static void updateEntry(Scanner cin, String table) {
		
	}
}
