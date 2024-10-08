package model;

import java.util.List;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private String coachName;
    private List<Player> players;
    private int totalWins;
    private int totalLosses;
    private int totalDraws;

    // REQUIRES: teamName and coachName should be non-null
    // MODIFIES: this
    // EFFECTS: constructs a team with the given name and coach, with an empty player list
    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.players = new ArrayList<>();
        this.totalWins = 0;
        this.totalLosses = 0;
        this.totalDraws = 0;
    }

    // EFFECTS: returns the name of the team
    public String getTeamName() {
        return null;
    }

    // EFFECTS: returns the name of the coach
    public String getCoachName() {
        return null;
    }

    // EFFECTS: returns the total number of wins
    public int getTotalWins() {
        return 0;
    }

    // EFFECTS: returns the total number of losses
    public int getTotalLosses() {
        return 0;
    }

    // EFFECTS: returns the total number of draws
    public int getTotalDraws() {
        return 0;
    }

    // EFFECTS: returns the list of players in the team
    public List<Player> getPlayers() {
        return null;
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the team
    public void addPlayer(Player player) {
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team by name (if found), returns true if removed, false if not
    public boolean removePlayer(String playerName) {
        return false;
    }

    // MODIFIES: this
    // EFFECTS: increments the number of wins by 1
    public void incrementWins() {
    }

    // MODIFIES: this
    // EFFECTS: increments the number of losses by 1
    public void incrementLosses() {
    }

    // MODIFIES: this
    // EFFECTS: increments the number of draws by 1
    public void incrementDraws() {
    }

    // EFFECTS: returns the total number of players in the team
    public int getTotalPlayers() {
        return 0;
    }
}
