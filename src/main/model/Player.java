package model;

/**
 * This class represents a player in a soccer team.
 * 
 * Each Player object stores attributes such as name, position, age, height, jersey number, 
 * and records statistics including minutes played, goals, assists, appearances, 
 * yellow cards, red cards, and injury status. Additionally, it tracks the player's win, 
 * loss, and draw records, which align with their team's performance.
 */
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

    /**
     * REQUIRES: age > 0, height > 0
     * MODIFIES: this
     * EFFECTS: constructs a player with the given name, position, age, height, and jersey number,
     *          and initializes all statistical attributes (goals, assists, appearances, etc.) to 0,
     *          and sets the injury status to false.
     */
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

    /**
     * REQUIRES: minPlayed >= 0
     * MODIFIES: this
     * EFFECTS: adds the specified number of minutes to the player's total minutes played.
     */
    public void addMinPlayed(int minPlayed) {
        this.minPlayed += minPlayed;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of goals scored by the player by 1.
     */
    public void addGoal() {
        this.totalGoals++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of assists by 1.
     */
    public void addAssist() {
        this.totalAssists++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of appearances by 1.
     */
    public void addAppearances() {
        this.appearances++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of yellow cards by 1.
     */
    public void addYellowCards() {
        this.yellowCards++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the total number of red cards by 1.
     */
    public void addRedCards() {
        this.redCards++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: toggles the player's injury status between true (injured) and false (available).
     */
    public void setIsInjured() {
        this.isInjured = !this.isInjured;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the player's win count by 1.
     */
    public void incrementWins() {
        this.wins++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the player's loss count by 1.
     */
    public void incrementLosses() {
        this.losses++;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the player's draw count by 1.
     */
    public void incrementDraws() {
        this.draws++;
    }

    /**
     * EFFECTS: returns true if the player is available (not injured), false otherwise.
     */
    public boolean isAvailable() {
        return !this.isInjured;
    }
}