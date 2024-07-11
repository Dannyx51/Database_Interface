package Checkpoint4.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Checkpoint4.GRS;
import Checkpoint4.utilities.Utilities;
import Checkpoint4.sql.SQL;

public class ViewMenu {
	
	private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', '4', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("VIEW ALL:\n"
				+ "1. Coaches\n"
				+ "2. Teams\n"
				+ "3. Players\n"
				+ "4. Reports\n"
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
				viewCoaches();
				break;
			case '2':
				viewTeams();
				break;
			case '3':
				viewPlayers();
				break;
			case '4':
				viewReports();
				break;
			default:
				break;
		}
		
		Utilities.printDivider();
	}
	
	/**
	 * Query all coaches contained in database.
	 */
	private static void viewCoaches() {
		String sql = "SELECT * FROM COACH";
		SQL.sqlQuery(GRS.conn, sql);
	}
	
	/**
	 * Query all teams contained in database.
	 */
	private static void viewTeams() {
		String sql = "SELECT * FROM TEAM";
		SQL.sqlQuery(GRS.conn, sql);
	}

	/**
	 * Query all players contained in database.
	 */
	private static void viewPlayers() {
		String sql = "SELECT * FROM PLAYER";
		SQL.sqlQuery(GRS.conn, sql);
	}
	
	private static void viewReports() {
		//TODO
	}
}
