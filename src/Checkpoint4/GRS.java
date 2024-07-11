package Checkpoint4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Checkpoint4.options.SearchMenu;
import Checkpoint4.options.EditMenu;
import Checkpoint4.options.ViewMenu;

public class GRS {	
	
	private static String DATABASE = "database_binary.db";
	
	public static Connection conn = null;
	
    /**
     * Connects to the database if it exists, creates it if it does not, and returns the connection object.
     * 
     * @param databaseFileName the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB(String databaseFileName) {

        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The connection to the database was successful.");
            } else {
            	System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("There was a problem connecting to the database.");
        }
        return conn;
    }
	
    private static final Set<Character> MENU_OPTIONS = new HashSet<>(Arrays.asList('1', '2', '3', 'x'));
	
	private static void mainMenu(Scanner cin) {
	
		char selection;
		do {
			System.out.print("||CHECKPOINT 4||\n"
					+ "----------------"
					+ "1. VIEW MENU\n"
					+ "2. SEARCH MENU\n"
					+ "3. EDIT MENU\n"
					+ "Input numerical selection (or 'x' to quit): ");
			String input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
			
			while(!MENU_OPTIONS.contains(selection)) {
				System.out.print("Incorrect option specified! Try again: ");
				input = cin.nextLine();
				selection = !input.isEmpty() ? input.charAt(0) : ' ';
			}
		
			switch(selection) {
				case '1':
					ViewMenu.menu(cin);
					break;
				case '2':
					SearchMenu.menu(cin);
					break;
				case '3':
					EditMenu.menu(cin);
					break;
				case '4':
					EditMenu.menu(cin);
					break;
				default: 
					break;
			}

		} while(selection!='x');
	}
	
	public static void main(String[] args) {
		conn = initializeDB(DATABASE);
		
		Scanner cin = new Scanner(System.in);
		mainMenu(cin);
		
		cin.close();
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Bye");
	}

}
