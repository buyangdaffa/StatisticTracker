package model;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

/**
 * This class represents a soccer Team.
 * 
 * Each Team object stores the team's name, coach's name, a list of players, 
 * and statistics such as total wins, draws, and losses. 
 * The team also has methods to add and remove players, increment match results, 
 * and compute the average age and height of the players.
 */
public class Team implements Writable {
    private String teamName;
    private String coachName;
    private List<Player> players;
    private int totalWins;
    private int totalLosses;
    private int totalDraws;

    /**
     * REQUIRES: teamName and coachName should be non-null
     * MODIFIES: this
     * EFFECTS: constructs a team with the given name and coach, with an empty player list,
     *          and initializes totalWins, totalLosses, and totalDraws to 0.
     */
    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.players = new ArrayList<>();
        this.totalWins = 0;
        this.totalLosses = 0;
        this.totalDraws = 0;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getCoachName() {
        return this.coachName;
    }

    public int getTotalWins() {
        return this.totalWins;
    }

    public int getTotalLosses() {
        return this.totalLosses;
    }

    public int getTotalDraws() {
        return this.totalDraws;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * MODIFIES: this
     * EFFECTS: adds a player to the team's player list.
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * MODIFIES: this
     * EFFECTS: removes a player from the team by their name if found, 
     *          returns true if the player is removed, false otherwise.
     */
    public boolean removePlayer(String playerName) {
        for (Player player : this.players) {
            if (player.getName().equals(playerName)) {
                this.players.remove(player);
                return true;
            }
        }
        return false;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of wins for the team and for each player on the team.
     */
    public void incrementWins() {
        this.totalWins++;
        for (Player player : this.players) {
            player.incrementWins();
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of losses for the team.
     */
    public void incrementLosses() {
        this.totalLosses++;
        for (Player player : this.players) {
            player.incrementLosses();
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of draws for the team.
     */
    public void incrementDraws() {
        this.totalDraws++;
        for (Player player : this.players) {
            player.incrementDraws();
        }
    }

    /**
     * EFFECTS: returns the total number of players in the team.
     */
    public int getTotalPlayers() {
        return this.players.size();
    }

    /**
     * EFFECTS: returns the average age of the players in the team, or 0 if the team has no players.
     */
    public int getAverageAge() {
        if (this.players.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (Player player : this.players) {
            totalAge += player.getAge();
        }
        return totalAge / this.players.size();
    }

    /**
     * EFFECTS: returns the average height of the players in the team, or 0 if the team has no players.
     */
    public int getAverageHeight() {
        if (this.players.isEmpty()) {
            return 0;
        }
        int totalHeight = 0;
        for (Player player : this.players) {
            totalHeight += player.getHeight();
        }
        return totalHeight / this.players.size();
    }

    /**
     * EFFECTS: returns a list of players who are available (not injured).
     */
    public List<Player> getAvailablePlayers() {
        List<Player> availablePlayers = new ArrayList<>();
        for (Player player : this.players) {
            if (player.isAvailable()) {
                availablePlayers.add(player);
            }
        }
        return availablePlayers;
    }

    /**
     * EFFECTS: returns a list of players who are injured (not available).
     */
    public List<Player> getInjuredPlayers() {
        List<Player> injuredPlayers = new ArrayList<>();
        for (Player player : this.players) {
            if (!player.isAvailable()) {
                injuredPlayers.add(player);
            }
        }
        return injuredPlayers;
    }

    @Override
    // EFFECTS: returns this team as a JSON object
    public JSONObject toJson() {
        // TODO: Implement this method
        return new JSONObject();
    }
    
    // EFFECTS: returns players in this team as a JSON array
    private JSONArray playersToJson() {
        // TODO: Implement this method
        return new JSONArray();
    }
}