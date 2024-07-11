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
	
	public static void menu(Scanner cin) {
		Utilities.printDivider();
		System.out.print("EDIT MENU:\n"
				+ "1. Add Artist\n"
				+ "2. Delete Artist\n"
				+ "3. Update Artist\n"
				+ "Input numerical selection (or 'x' to quit): ");
		String input = cin.nextLine();
		char selection = !input.isEmpty() ? input.charAt(0) : ' ';		
		
		while(!MENU_OPTIONS.contains(selection)) {
			System.out.print("Incorrect option specified! Try again: ");
			input = cin.nextLine();
			selection = !input.isEmpty() ? input.charAt(0) : ' ';
		}

		switch(selection) {
			case '1':
				addArtist(cin);
				break;
			case '2':

				break;
			case '3':

			default:
				break;
		}
	}
	
	private static void addArtist(Scanner cin) {
		Utilities.printDivider();

		System.out.print("Enter artist name: ");
		String artist_name = cin.nextLine().trim();

		if (artist_name.isEmpty()) {
			System.out.println("Artist name cannot be empty!");
			return;
		}

		System.out.print("Enter Birthday [YYYY-MM-DD] (or x to skip): ");
		String birthday = cin.nextLine().trim();

        if (!birthday.equals("x") && !birthday.isEmpty()) {
            try {
                var tempDateObj = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				java.sql.Date BDObj = new java.sql.Date(tempDateObj.getTime());
				SQL.ps_AddArtist(artist_name, BDObj);

            } catch (ParseException e) {
                System.out.println("Invalid birthday, adding artist without birthday.");
				SQL.ps_AddArtistNoBDay(artist_name);
            }
        } else {
			SQL.ps_AddArtistNoBDay(artist_name);
		}
    }
}
