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

    // MODIFIES: this
    // EFFECTS: adds a player to the team
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team by name (if found), returns true if removed, false if not
    public boolean removePlayer(String playerName) {
        for (Player player : this.players) {
            if (player.getName().equals(playerName)) {
                this.players.remove(player);
                return true;
            }
        }
        return false; 
    }

    // MODIFIES: this
    // EFFECTS: increments the number of wins by 1 and increments the wins for each player in the team
    public void incrementWins() {
        this.totalWins++;
        for (Player player : this.players) {
            player.incrementWins();
        }
    }

    // MODIFIES: this
    // EFFECTS: increments the number of losses by 1
    public void incrementLosses() {
        this.totalLosses++;
        for (Player player : this.players) {
            player.incrementLosses();
        }
    }

    // MODIFIES: this
    // EFFECTS: increments the number of draws by 1
    public void incrementDraws() {
        this.totalDraws++;
        for (Player player : this.players) {
            player.incrementDraws();
        }
    }

    public int getTotalPlayers() {
        return this.players.size();
    }

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
}
