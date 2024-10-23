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

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads teams from file and returns them;
    // throws IOException if an error occurs reading data from file
    public List<Team> read() throws IOException {
        // TODO: Implement this method
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        // TODO: Implement this method
        return null;
    }
    
    // EFFECTS: parses JSONArray of teams and returns it
    private List<Team> parseTeams(JSONArray jsonArray) {
        // TODO: Implement this method
        return null;
    }

    // EFFECTS: parses team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        // TODO: Implement this method
        return null;
    }

    // MODIFIES: team
    // EFFECTS: sets team's totalWins, totalLosses, and totalDraws to the given values
    private void teamSetter(int totalWins, int totalLosses, int totalDraws, Team team) {
        // TODO: Implement this method
    }
    
    // MODIFIES: team
    // EFFECTS: parses players from JSON object and adds them to team
    private void addPlayers(Team team, JSONObject jsonObject) {
        // TODO: Implement this method
    }
    
    // MODIFIES: team
    // EFFECTS: parses player from JSON object and adds it to team
    private void addPlayer(Team team, JSONObject jsonObject) {
        // TODO: Implement this method
    }
    
    // MODIFIES: player
    // EFFECTS: sets player's minPlayed, totalGoals, totalAssists, appearances, yellowCards, redCards, and isInjured
    private void playerSetter(int minPlayed, int totalGoals, int totalAssists, int appearances, 
                              int yellowCards, int redCards, boolean isInjured, Player player) {
        // TODO: Implement this method
    }
}