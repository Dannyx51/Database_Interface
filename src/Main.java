import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, String> teams = new HashMap<>();
    static HashMap<String, String> coaches = new HashMap<>();
    static HashMap<String, String> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String choice = "";
        while (!choice.equals("9")) {
            System.out.println("-------------------");

            System.out.println("0: add an entity.");
            System.out.println("1: delete an entity.");
            System.out.println("2: update an entity.");
            System.out.println("3: view an entity.");
            System.out.println("9: exit the program.");
            System.out.print("Enter your choice: ");

            choice = input.nextLine();

            System.out.println("-------------------");
            String aChoice;
            switch (choice) {
                case "0":
                    System.out.println("0: team");
                    System.out.println("1: coach");
                    System.out.println("2: player");
                    System.out.print("Choose an entity: ");

                    aChoice = input.nextLine();
                    if (!aChoice.equals("1") && !aChoice.equals("2") && !aChoice.equals("0")) {
                        System.out.println("Invalid input.");
                    }

                    System.out.print("Enter a name: ");
                    String name = input.nextLine();
                    switch (aChoice) {
                        case "0":
                            addTeam(name);
                            return;
                        case "1":
                            addCoach(name);
                            return;
                        case "2":
                            addPlayers(name);
                            return;
                    }
                    return;
                case "1":
                    System.out.println("0: team");
                    System.out.println("1: coach");
                    System.out.println("2: player");
                    System.out.print("Choose an entity: ");

                    aChoice = input.nextLine();
                    if (!aChoice.equals("1") && !aChoice.equals("2") && !aChoice.equals("0")) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("Enter an id: ");
                    String id = input.nextLine();

                    switch(aChoice) {
                        case "1":
                            if (!teams.containsKey(id)) {
                                System.out.println("Unable to locate team " + id + ".");
                            } else {
                                removeTeam(id);
                            }
                            return;
                        case "2":
                            if (!players.containsKey(id)) {
                                System.out.println("Unable to locate player " + id + ".");
                            } else {
                                removePlayer(id);
                            }
                            return;
                        case "0":
                            if (!coaches.containsKey(id)) {
                                System.out.println("Unable to locate coach " + id + ".");
                            } else {
                                removeCoach(id);
                            }
                            return;
                    }
                    return;
                case "2":
                    System.out.println("0: team");
                    System.out.println("1: coach");
                    System.out.println("2: player");
                    System.out.print("Choose an entity: ");

                    aChoice = input.nextLine();
                    if (!aChoice.equals("1") && !aChoice.equals("2") && !aChoice.equals("0")) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("Enter an id: ");
                    String new_id = input.nextLine();

                    System.out.print("Enter a new name: ");
                    String new_name = input.nextLine();
                    switch(aChoice) {
                        case "1":
                            if (!teams.containsKey(new_id)) {
                                System.out.println("Unable to locate team " + new_id + ".");
                            } else {
                                updateTeam(new_id, new_name);
                            }
                            return;
                        case "2":
                            if (!players.containsKey(new_id)) {
                                System.out.println("Unable to locate player " + new_id + ".");
                            } else {
                                updatePlayer(new_id, new_name);
                            }
                            return;
                        case "0":
                            if (!coaches.containsKey(new_id)) {
                                System.out.println("Unable to locate coach " + new_id + ".");
                            } else {
                                updateCoach(new_id, new_name);
                            }
                            return;
                    }
                    return;
                case "3":
                    System.out.println("Not currently implemented.");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

        input.close();
    }

    public static void addTeam(String team) {
        int _n = teams.size(), _sum = 0;
        for (String i : teams.keySet()) {_sum += Integer.parseInt(i);}

        String id = Integer.toString(Math.abs(_sum - (_n * (_n + 1)) / 2));

        teams.put(id, team);

        System.out.println("Successfully added team " + team + ".");
    }

    public static void addCoach(String coach) {
        int _n = coaches.size(), _sum = 0;
        for (String i : coaches.keySet()) {_sum += Integer.parseInt(i);}

        String id = Integer.toString(Math.abs(_sum - (_n * (_n + 1)) / 2));

        coaches.put(id, coach);

        System.out.println("Successfully added coach " + coach + ".");
    }

    public static void addPlayers(String player) {
        int _n = players.size(), _sum = 0;
        for (String i : players.keySet()) {_sum += Integer.parseInt(i);}

        String id = Integer.toString(Math.abs(_sum - (_n * (_n + 1)) / 2));

        players.put(id, player);

        System.out.println("Successfully added player " + player + ".");
    }

    public static void removePlayer(String id) {
        players.remove(id);
        System.out.println("Successfully removed player " + id + ".");
    }

    public static void removeTeam(String id) {
        if (!teams.containsKey(id)) {
            System.out.println("Unable to locate team " + id + ".");
            return;
        }
        teams.remove(id);
        System.out.println("Successfully removed team " + id + ".");
    }

    public static void removeCoach(String id) {
        if (!coaches.containsKey(id)) {
            System.out.println("Unable to locate coach " + id + ".");
            return;
        }
        coaches.remove(id);
        System.out.println("Successfully removed coach " + id + ".");
    }

    public static void updateTeam(String id, String team) {
        if (!teams.containsKey(id)) {
            System.out.println("Unable to locate team " + id + ".");
            return;
        }
        teams.put(id, team);
        System.out.println("Successfully updated team " + team + ".");
    }

    public static void updateCoach(String id, String coach) {
        if (!coaches.containsKey(id)) {
            System.out.println("Unable to locate coach " + id + ".");
            return;
        }
        coaches.put(id, coach);
        System.out.println("Successfully updated coach " + id + ".");
    }

    public static void updatePlayer(String id, String player) {
        if (!players.containsKey(id)) {
            System.out.println("Unable to locate player " + id + ".");
            return;
        }
        players.put(id, player);
        System.out.println("Successfully updated player " + id + ".");
    }
}
