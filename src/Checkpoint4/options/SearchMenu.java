package Checkpoint4.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Checkpoint4.utilities.Utilities;
import Checkpoint4.sql.SQL;

public class SearchMenu {

	private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.println("SEARCH:\n"
				+ "1. Coach\n"
				+ "2. Team\n"
				+ "3. Player\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine();
		char selection = !input.isEmpty() ? input.charAt(0) : ' ';
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Incorrect option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
		}
		
		Utilities.printDivider();
		
		switch(selection) {
			case '1':
				sendSearch(cin, "Coach");
				break;
			case '2':
				sendSearch(cin, "Team");
				break;
			case '3':
				sendSearch(cin, "Player");
				break;
			default:
				break;
		}
	
		Utilities.printDivider();
	}
	
	private static void sendSearch(Scanner cin, String table) {
		System.out.print("Enter " + table + " Name (or 'x' to cancel): ");
		String name = cin.nextLine().trim();
		
		if (name.isBlank() || name.equalsIgnoreCase("x")) { return; }
		
		String sql = "SELECT * FROM "+table.toUpperCase()+" WHERE Name = ?";
		SQL.ps_SearchName(sql, name);
	}

}
