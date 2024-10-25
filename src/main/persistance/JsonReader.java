package persistance;

import model.Player;
import model.Team;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Represents a reader that reads JSON representation of teams from a file.
 * 
 * The JsonReader class provides methods to read a JSON file and parse its contents
 * into a list of Team objects. Each Team object can contain multiple Player objects.
 * The class handles the conversion of JSON data into Java objects, ensuring that
 * all relevant fields are correctly populated.
 * Referenced from the JsonSerialization Demo
 * https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads teams from file and returns them;
    // throws IOException if an error occurs reading data from file
    public List<Team> read() throws IOException {
        String jsonData = readFile(source);
        JSONArray jsonArray = new JSONArray(jsonData);
        return parseTeams(jsonArray);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses JSONArray of teams and returns it
    private List<Team> parseTeams(JSONArray jsonArray) {
        List<Team> teams = new ArrayList<>();

        for (Object json : jsonArray) {
            JSONObject teamJson = (JSONObject) json;
            teams.add(parseTeam(teamJson));
        }

        return teams;
    }

    // EFFECTS: parses team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        String teamName = jsonObject.getString("teamName");
        String coachName = jsonObject.getString("coachName");
        int totalWins = jsonObject.getInt("totalWins");
        int totalLosses = jsonObject.getInt("totalLosses");
        int totalDraws = jsonObject.getInt("totalDraws");

        Team team = new Team(teamName, coachName);
        addPlayers(team, jsonObject);
        teamSetter(totalWins, totalLosses, totalDraws, team);

        return team;
    }

    // MODIFIES: team
    // EFFECTS: sets team's totalWins, totalLosses, and totalDraws to the given values
    private void teamSetter(int totalWins, int totalLosses, int totalDraws, Team team) {
        while (team.getTotalWins() < totalWins) {
            team.incrementWins();
        }
        while (team.getTotalLosses() < totalLosses) {
            team.incrementLosses();
        }
        while (team.getTotalDraws() < totalDraws) {
            team.incrementDraws();
        }
    }

    // MODIFIES: team
    // EFFECTS: parses players from JSON object and adds them to team
    private void addPlayers(Team team, JSONObject jsonObject) {
        for (Object json : jsonObject.getJSONArray("players")) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(team, nextPlayer);
        }
    }

    // MODIFIES: team
    // EFFECTS: parses player from JSON object and adds it to team
    private void addPlayer(Team team, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String position = jsonObject.getString("position");
        int age = jsonObject.getInt("age");
        int height = jsonObject.getInt("height");
        int jerseyNumber = jsonObject.getInt("jerseyNumber");
        int minPlayed = jsonObject.getInt("minPlayed");
        int totalGoals = jsonObject.getInt("totalGoals");
        int totalAssists = jsonObject.getInt("totalAssists");
        int appearances = jsonObject.getInt("appearances");
        int yellowCards = jsonObject.getInt("yellowCards");
        int redCards = jsonObject.getInt("redCards");
        boolean isInjured = jsonObject.getBoolean("isInjured");
    
        Player player = new Player(name, position, age, height, jerseyNumber);
        playerSetter(minPlayed, totalGoals, totalAssists, appearances, yellowCards, 
                     redCards, isInjured, player);

        team.addPlayer(player);
    }

    // MODIFIES: player
    // EFFECTS: sets player's minPlayed, totalGoals, totalAssists, appearances, yellowCards, redCards, and isInjured
    private void playerSetter(int minPlayed, int totalGoals, int totalAssists, int appearances, 
                                         int yellowCards, int redCards, boolean isInjured, Player player) {
        player.addMinPlayed(minPlayed);
        while (player.getTotalGoals() < totalGoals) {
            player.addGoal();
        }
        while (player.getTotalAssists() < totalAssists) {
            player.addAssist();
        }
        while (player.getAppearances() < appearances) {
            player.addAppearances();
        }
        while (player.getYellowCards() < yellowCards) {
            player.addYellowCards();
        }
        while (player.getRedCards() < redCards) {
            player.addRedCards();
        }
        if (player.getIsInjured() != isInjured) {
            player.setIsInjured();
        }
    }
}