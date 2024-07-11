package Checkpoint4.options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Checkpoint4.DB_MANAGER;
import Checkpoint4.utilities.Utilities;
import Checkpoint4.sql.SQL;

public class ViewMenu {
	
	private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', '4', 'x'));
	private static final Set<Character> REPORT_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', 'x'));
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("VIEW ALL:\n"
				+ "1. Coaches\n"
				+ "2. Teams\n"
				+ "3. Players\n"
				+ "4. Reports\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine();
		char selection = !input.isBlank() ? input.charAt(0) : ' ';
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Invalid option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isBlank() ? input.charAt(0) : ' ';
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
				viewReports(cin);
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
		SQL.sqlQuery(DB_MANAGER.conn, sql);
	}
	
	/**
	 * Query all teams contained in database.
	 */
	private static void viewTeams() {
		String sql = "SELECT * FROM TEAM";
		SQL.sqlQuery(DB_MANAGER.conn, sql);
	}

	/**
	 * Query all players contained in database.
	 */
	private static void viewPlayers() {
		String sql = "SELECT * FROM PLAYER";
		SQL.sqlQuery(DB_MANAGER.conn, sql);
	}
	
	private static void viewReports(Scanner cin) {
		System.out.print("VIEW ALL:\n"
				+ "1. Touchdowns\n"
				+ "2. Average Player Heights\n"
				+ "3. Player Physical Stats\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine().trim();
		Character selection = !input.isBlank() ? input.charAt(0) : ' ';
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Invalid option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isBlank() ? input.charAt(0) : ' ';
		}
		
		Utilities.printDivider();
	
		String sql = "";
		switch(selection) {
			case '1':
				sql = "SELECT t.name, tss.Team_ID, tss.Touchdowns "
						+ "FROM TEAM_SEASON_STATS as tss "
						+ "JOIN TEAM as t on tss.Team_ID = t.ID "
						+ "WHERE tss.Year = 2023 "
						+ "ORDER BY tss.Touchdowns DESC";
				break;
			case '2':
				sql = "SELECT PY.Player_ID, P.Name, avg(PY.Height) "
						+ "FROM PLAYER_YEAR as PY "
						+ "JOIN PLAYER as P on P.ID = PY.Player_ID "
						+ "WHERE PY.Team_ID = 2 "
						+ "GROUP BY PY.Player_ID";
				break;
			case '3':
				sql = "SELECT P.ID, P.Name, R.Year, R.Age, R.Height, R.Weight "
						+ "FROM (SELECT PY.Player.ID, min(PY.Year) as M FROM PLAYER_YEAR as PY GROUP BY PY.Player_ID) as L "
						+ "JOIN PLAYER as P on P.ID = L.Player_ID, PLAYER_YEAR as R on R.Player_ID = L.Player_ID and R.Year = L.M";
				break;
			default:
				break;
		}
		
		if (sql.isBlank()) { return; }
		
		SQL.sqlQuery(DB_MANAGER.conn, sql);
	}
}
