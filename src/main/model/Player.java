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

    // REQUIRES: age > 0, height > 0, weight > 0
    // MODIFIES: this
    // EFFECTS: constructs a player with the given name, position, age, height, weight, and jersey number
    public Player(String name, String position, int age, int height, int weight, int jerseyNumber) {
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
        return null;
    }

    public String getPosition() {
        return null;
    }

    public int getAge() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public int getJerseyNumber() {
        return 0;
    }
    
    public int getMinPlayed() {
        return 0;
    }

    public int getTotalGoals() {
        return 0;
    }

    public int getTotalAssists() {
        return 0;
    }

    public int getAppearances() {
        return 0;
    }

    public int getYellowCards() {
        return 0;
    }

    public int getRedCards() {
        return 0;
    }

    public boolean getIsInjured() {
        return false;
    }

    public int getWins() {
        return 0;
    }

    public int getLosses() {
        return 0;
    }

    public int getDraws() {
        return 0;
    }

    public void setMinPlayed(int minPlayed) {
        this.minPlayed += minPlayed;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals += totalGoals;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists += totalAssists;
    }

    public void setAppearances(int appearances) {
        this.appearances += appearances;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards += yellowCards;
    }

    public void setRedCards(int redCards) {
        this.redCards += redCards;
    }

    public void setIsInjured(boolean isInjured) {
        this.isInjured = isInjured;
    }
}
