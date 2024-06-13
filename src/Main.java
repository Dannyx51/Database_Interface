import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // {Coach_Id, Coach_Name}
    HashMap<String, String> coaches = new HashMap<>();

    // {Team_Id, Team_Name, Year, Conference, Coach_Id}
    HashMap<String, HashMap<String, String>> teams = new HashMap<>();

    // {Player_Id, Team_Id, Name, Age, Year, Height, Weight}
    HashMap<String, HashMap<String, String>> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] mainOptionList = {"Team", "Coach", "Coach_Season_Stats", "Team_Season_Stats", "Team_Game_Stats", "Player",
                "Player_Season_Stats", "Player_Game_Stats", "Game"};

        String[] subOptions = {"Add", "Update", "Delete"};

        String choice = "";
        while (!choice.equalsIgnoreCase("n")) {


            choice = input.nextLine();
        }

        input.close();
    }



    //region <Coach Commands>
    /**
     *
     * @param name The name of the coach to be added.
     * @return The status message of the operation.
     */
    public String addCoach(String name) {
        // calculate next id
        int _n = coaches.size(), _idSum = 0;
        for (String i : coaches.keySet()) { _idSum += Integer.parseInt(i); }

        int coachId = Math.abs(_idSum - (_n*(_n + 1) / 2));

        coaches.put(Integer.toString(coachId), name);

        return "The coach has been successfully added.";
    }

    /**
     *
     * @param coachId the id of the coach to be removed.
     * @return The status message of the operation.
     */
    public String deleteCoach(String coachId) {
        if (!coaches.containsKey(coachId)) { return "The requested coachId does not exist."; }
        coaches.remove(coachId);
        return "The coach has been successfully deleted.";
    }

    /**
     *
     * @param coachId the id of the coach to be updated.
     * @return The status message of the operation.
     */
    public String updateCoach(String coachId, String newName) {
        if (!coaches.containsKey(coachId)) { return "The requested coachId does not exist."; }
        coaches.put(coachId, newName);
        return "The coach has been successfully updated.";
    }
    //endregion

    //region <Team Commands>
    /**
     *
     * @param name
     * @param year
     * @param conference
     * @param coachId
     * @return The status message of the operation
     */
    public String addTeam(String name, String year, String conference, String coachId) {
        if (!coaches.containsKey(coachId)) { return "The referenced coachId does not exist."; }

        // calculate next teamId
        int _n = teams.size(), _idSum = 0;
        for (String i : teams.keySet()) { _idSum += Integer.parseInt(i); }
        int teamId = Math.abs(_idSum - (_n*(_n + 1) / 2));

        HashMap<String, String> submap = new HashMap<>();
        submap.put("name", name);
        submap.put("year", year);
        submap.put("conference", conference);
        submap.put("coachid", coachId);

        teams.put(Integer.toString(teamId), submap);

        return "The team has been successfully added.";
    }

    public String deleteTeam(String teamId) {
        if (!teams.containsKey(teamId)) { return "The requested teamId does not exist."; }
        teams.remove(teamId);
        return "The team has been successfully deleted.";
    }

    public String updateTeam(String teamId, String newName, String newYear, String newConference, String newCoachId) {
        if (!teams.containsKey(teamId)) { return "The referenced teamId does not exist."; }
        if (!coaches.containsKey(newCoachId)) { return "The requested coachId does not exist."; }

        HashMap<String, String> submap = teams.get(teamId);
        submap.put("name", newName);
        submap.put("newYear", newYear);
        submap.put("conference", newConference);
        submap.put("coachid", newCoachId);

        return "The team has been successfully updated.";
    }
    //endregion

    //region <Player Commands>
    public String addPlayer(String teamId, String name, String age, String year, String height, String weight) {
        if (!teams.containsKey(teamId)) { return "The referenced teamId does not exist."; }
        int _n = players.size(), _idSum = 0;
        for (String i : players.keySet()) { _idSum += Integer.parseInt(i); }
        int playerId = Math.abs(_idSum - (_n*(_n + 1) / 2));

        HashMap<String, String> submap = new HashMap<>();
        submap.put("teamid", teamId);
        submap.put("name", name);
        submap.put("age", age);
        submap.put("year", year);
        submap.put("height", height);
        submap.put("weight", weight);

        players.put(Integer.toString(playerId), submap);

        return "The player has been successfully added.";
    }

    public String deletePlayer(String playerId) {
        if (!players.containsKey(playerId)) { return "The requested player does not exist."; }
        players.remove(playerId);
        return "The player has been successfully deleted.";
    }

    public String updatePlayer(String playerId, String newTeamId, String newName, String newAge, String newHeight, String newWeight) {
        if (!players.containsKey(playerId)) { return "The referenced player does not exist."; }
        if (!teams.containsKey(newTeamId)) { return "The referenced teamId does not exist."; }

        HashMap<String, String> submap = players.get(playerId);
        submap.put("teamid", newTeamId);
        submap.put("name", newName);
        submap.put("age", newAge);
        submap.put("height", newHeight);
        submap.put("weight", newWeight);

        return "The player has been successfully updated.";
    }
    //endregion

    /// cleanup & helper functions ///
    public static void clearConsole() {

    }
}