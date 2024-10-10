package model;

public class Player {
    private String name;
    private String position;
    private int age;
    private int height;
    private int jerseyNumber;
    private int minPlayed;
    private int totalGoals;
    private int totalAssists;
    private int appearances;
    private int yellowCards;
    private int redCards;
    private boolean isInjured;
    private int wins;
    private int losses;
    private int draws;

    // REQUIRES: age > 0, height > 0
    // MODIFIES: this
    // EFFECTS: constructs a player with the given name, position, age, height, and jersey number
    public Player(String name, String position, int age, int height, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.jerseyNumber = jerseyNumber;
        this.minPlayed = 0;
        this.totalGoals = 0;
        this.totalAssists = 0;
        this.appearances = 0;
        this.yellowCards = 0;
        this.redCards = 0;
        this.isInjured = false;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getJerseyNumber() {
        return this.jerseyNumber;
    }
    
    public int getMinPlayed() {
        return this.minPlayed;
    }

    public int getTotalGoals() {
        return this.totalGoals;
    }

    public int getTotalAssists() {
        return this.totalAssists;
    }

    public int getAppearances() {
        return this.appearances;
    }

    public int getYellowCards() {
        return this.yellowCards;
    }

    public int getRedCards() {
        return this.redCards;
    }

    public boolean getIsInjured() {
        return this.isInjured;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getDraws() {
        return this.draws;
    }

    // MODIFIES: this
    // EFFECTS: adds the number of minutes played
    public void addMinPlayed(int minPlayed) {
        this.minPlayed += minPlayed;
    }

    // MODIFIES: this
    // EFFECTS: increment the total number of goals scored
    public void addGoal() {
        this.totalGoals++;
    }

    // MODIFIES: this
    // EFFECTS: increment the total number of assists
    public void addAssist() {
        this.totalAssists++;
    }

    // MODIFIES: this
    // EFFECTS: increment the total number of appearances
    public void addAppearances() {
        this.appearances++;
    }

    // MODIFIES: this
    // EFFECTS: adds the total number of yellow cards
    public void addYellowCards() {
        this.yellowCards++;
    }

    // MODIFIES: this
    // EFFECTS: adds the total number of red cards
    public void addRedCards() {
        this.redCards++;
    }

    // MODIFIES: this
    // EFFECTS: sets the player as injured, only works to set the player from healthy to injured not the other way
    public void setIsInjured() {
        this.isInjured = true;
    }

    // MODIFIES: this
    // EFFECTS: increments the number of wins by 1
    public void incrementWins() {
        this.wins++;
    }

    // MODIFIES: this
    // EFFECTS: increments the number of losses by 1
    public void incrementLosses() {
        this.losses++;
    }

    // MODIFIES: this
    // EFFECTS: increments the number of draws by 1
    public void incrementDraws() {
        this.draws++;
    }

    public boolean isAvailable() {
        return !this.isInjured;
    } 
    
}
