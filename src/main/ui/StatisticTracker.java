package ui;

import model.Player;
import model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticTracker {
    private List<Team> teams;
    private Scanner input;
    private boolean running;

    // EFFECTS: creates an instance of the StatisticTracker console UI application
    public StatisticTracker() {
        init();
        System.out.println("Hello Coach! What do you want to do?");
        run();  // Run the application
    }

    // MODIFIES: this
    // EFFECTS: initializes the StatisticTracker
    private void init() {
        this.teams = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.running = true;
    }

    // EFFECTS: runs the StatisticTracker application in a loop
    public void run() {
        while (this.running) {
            mainMenu();
        }
    }

    // EFFECTS: displays the main menu and processes user input
    private void mainMenu() {
        System.out.println("1. Create a new team");
        System.out.println("2. View and edit all teams");
        System.out.println("3. Exit");
        String input = this.input.nextLine();
        processMenuCommands(input);
    }

    // MODIFIES: this
    // EFFECTS: processes the user input for the StatisticTracker menu
    private void processMenuCommands(String input) {
        switch (input) {
            case "1":
                createTeam();
                break;
            case "2":
                viewTeams();
                break;
            case "3":
                this.running = false;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new team
    private void createTeam() {
        printSeparator();
        System.out.println("Enter the team name:");
        printSeparator();
        String teamName = this.input.nextLine();
        printSeparator();
        System.out.println("Enter the coach name:");
        printSeparator();
        String coachName = this.input.nextLine();

        Team team = new Team(teamName, coachName);
        this.teams.add(team);

        System.out.println("Team created successfully!");
    }

    // EFFECTS: print the team details
    private void printTeamDetails(Team team) {
        System.out.println("Team: " + team.getTeamName());
        System.out.println("Coach: " + team.getCoachName());
        System.out.println("Wins: " + team.getTotalWins());
        System.out.println("Losses: " + team.getTotalLosses());
        System.out.println("Draws: " + team.getTotalDraws());
        System.out.println("Average age: " + team.getAverageAge());
        System.out.println("Average height: " + team.getAverageHeight());
        System.out.println("Players (Available):");
        for (Player player : team.getAvailablePlayers()) {
            System.out.println(player.getName() + "/" + player.getPosition() + "/" + player.getJerseyNumber());
        }
        System.out.println("Players (Injured):");
        for (Player player : team.getInjuredPlayers()) {
            System.out.println(player.getName() + "/" + player.getPosition() + "/" + player.getJerseyNumber());
        }
    }

    // EFFECTS: print a separator
    private void printSeparator() {
        System.out.println("--------------------------------------------------");
    }

        // MODIFIES: this
    // EFFECTS: edits a team
    private void viewTeams() {
        if (this.teams.isEmpty()) {
            printSeparator();
            System.out.println("No teams found.");
            printSeparator();
        } else {
            int currentTeamIndex = 0;
            String input = "";
    
            while (!input.equals("q")) {
                Team team = this.teams.get(currentTeamIndex);
                printSeparator();
                printTeamDetails(team);
    
                printSeparator();
                System.out.println("Edit team " + (currentTeamIndex + 1) + " of " + this.teams.size());
                printEditTeamMenu();
                System.out.println("\nPress 'q' to quit.");
                printSeparator();
                input = this.input.nextLine();
    
                if (input.equals("q")) {
                    break;
                } else if (input.equals("8")) {
                    currentTeamIndex = (currentTeamIndex + 1) % this.teams.size();
                } else if (input.equals("9")) {
                    currentTeamIndex = (currentTeamIndex - 1 + this.teams.size()) % this.teams.size();
                } else {
                    processEditCommands(input, team);
                }
            }
        }
    }

    private void printEditTeamMenu() {
        System.out.println("1. Add player");
        System.out.println("2. Remove player");
        System.out.println("3. View and edit player");
        System.out.println("4. Compare players");
        System.out.println("5. Increment wins");
        System.out.println("6. Increment losses");
        System.out.println("7. Increment draws");
        System.out.println("8. Previous team");
        System.out.println("9. Next team");
    }

    // MODIFIES: this
    // EFFECTS: processes the user input for the edit team menu
    private void processEditCommands(String input, Team team) {
        switch (input) {
            case "1":
                addPlayer(team);
                break;
            case "2":
                removePlayer(team);
                break;
            case "3":
                viewAndEditPlayers(team);
                break;
            case "4":
                comparePlayersPrompt(team);
                break;
            case "5":
                team.incrementWins();
                System.out.println("Wins incremented successfully!");
                break;
            case "6":
                team.incrementLosses();
                System.out.println("Losses incremented successfully!");
                break;
            case "7":
                team.incrementDraws();
                System.out.println("Draws incremented successfully!");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts the user to select two players to compare from the team
    private void comparePlayersPrompt(Team team) {
        if (team.getPlayers().size() < 2) {
            System.out.println("Not enough players to compare.");
            return;
        }

        // Display all players to select
        System.out.println("Select two players to compare:");
        for (int i = 0; i < team.getPlayers().size(); i++) {
            System.out.println((i + 1) + ": " + team.getPlayers().get(i).getName());
        }

        try {
            System.out.println("Enter the number of the first player:");
            int player1Index = Integer.parseInt(this.input.nextLine()) - 1;

            System.out.println("Enter the number of the second player:");
            int player2Index = Integer.parseInt(this.input.nextLine()) - 1;

            if (player1Index >= 0 && player1Index < team.getPlayers().size() 
                    && player2Index >= 0 && player2Index < team.getPlayers().size() 
                    && player1Index != player2Index) {

                Player player1 = team.getPlayers().get(player1Index);
                Player player2 = team.getPlayers().get(player2Index);
                comparePlayers(player1, player2);

            } else {
                System.out.println("Invalid player selection. Try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // EFFECTS: compare two players
    private void comparePlayers(Player player1, Player player2) {
        System.out.println("Name: " + player1.getName() + " vs " + player2.getName());
        System.out.println("Position: " + player1.getPosition() + " vs " + player2.getPosition());
        System.out.println("Age: " + player1.getAge() + " vs " + player2.getAge());
        System.out.println("Height: " + player1.getHeight() + " vs " + player2.getHeight());
        System.out.println("Jersey Number: " + player1.getJerseyNumber() + " vs " + player2.getJerseyNumber());
        System.out.println("Minutes Played: " + player1.getMinPlayed() + " vs " + player2.getMinPlayed());
        System.out.println("Total Goals: " + player1.getTotalGoals() + " vs " + player2.getTotalGoals());
        System.out.println("Total Assists: " + player1.getTotalAssists() + " vs " + player2.getTotalAssists());
        System.out.println("Appearances: " + player1.getAppearances() + " vs " + player2.getAppearances());
        System.out.println("Yellow Cards: " + player1.getYellowCards() + " vs " + player2.getYellowCards());
        System.out.println("Red Cards: " + player1.getRedCards() + " vs " + player2.getRedCards());
        System.out.println("Injured: " + player1.getIsInjured() + " vs " + player2.getIsInjured());
        System.out.println("Wins: " + player1.getWins() + " vs " + player2.getWins());
        System.out.println("Losses: " + player1.getLosses() + " vs " + player2.getLosses());
        System.out.println("Draws: " + player1.getDraws() + " vs " + player2.getDraws());
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the team
    private void addPlayer(Team team) {
        System.out.println("Enter the player name:");
        String playerName = this.input.nextLine();
        System.out.println("Enter the player position:");
        String playerPosition = this.input.nextLine();
        System.out.println("Enter the player age:");
        int playerAge = Integer.parseInt(this.input.nextLine());
        System.out.println("Enter the player height:");
        int playerHeight = Integer.parseInt(this.input.nextLine());
        System.out.println("Enter the player jersey number:");
        int playerJerseyNumber = Integer.parseInt(this.input.nextLine());

        Player player = new Player(playerName, playerPosition, playerAge, playerHeight, playerJerseyNumber);
        team.addPlayer(player);

        System.out.println("Player added successfully!");
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team
    private void removePlayer(Team team) {
        System.out.println("Enter the player name:");
        String playerName = this.input.nextLine();

        if (team.removePlayer(playerName)) {
            System.out.println("Player removed successfully!");
        } else {
            System.out.println("Player not found.");
        }
    }

    // EFFECTS: view and edit player details
    private void viewAndEditPlayers(Team team) {
        List<Player> players = team.getPlayers();
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
    
        int currentPlayerIndex = 0;
        String input = "";
    
        while (!input.equalsIgnoreCase("q")) {
            Player player = players.get(currentPlayerIndex);
            printPlayerDetails(player);
            printSeparator();
            System.out.println("Edit player " + (currentPlayerIndex + 1) + " of " + players.size());
            printEditPlayerMenu();
            System.out.println("\nPress 'q' to quit.");
            input = this.input.nextLine().trim();
    
            if (input.equalsIgnoreCase("q")) {
                break; // Exit the loop correctly
            } else if (input.equals("8")) {
                currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
            } else if (input.equals("9")) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            } else {
                processEditPlayerCommands(input, player);
            }
        }
    }
    

    // EFFECTS: print edit player menu
    private void printEditPlayerMenu() {
        System.out.println("1. Increment minutes played");
        System.out.println("2. Increment total goals");
        System.out.println("3. Increment total assists");
        System.out.println("4. Increment appearances");
        System.out.println("5. Increment yellow cards");
        System.out.println("6. Increment red cards");
        System.out.println("7. Toggle injured status");
        System.out.println("8. Previous player");
        System.out.println("9. Next Player");
    }

    // EFFECTS: processes the user input for the edit player menu
    private void processEditPlayerCommands(String input, Player player) {
        switch (input) {
            case "1":
                System.out.println("Enter the number of minutes played:");
                int minPlayed = Integer.parseInt(this.input.nextLine());
                player.addMinPlayed(minPlayed);
                System.out.println("Minutes played incremented successfully!");
                break;
            case "2":
                player.addGoal();
                System.out.println("Total goals incremented successfully!");
                break;
            case "3":
                player.addAssist();
                System.out.println("Total assists incremented successfully!");
                break;
            case "4":
                player.addAppearances();
                System.out.println("Appearances incremented successfully!");
                break;
            case "5":
                player.addYellowCards();
                System.out.println("Yellow cards incremented successfully!");
                break;
            case "6":
                player.addRedCards();
                System.out.println("Red cards incremented successfully!");
                break;
            case "7":
                player.setIsInjured();
                System.out.println("Injured status toggled successfully!");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }
    

    // EFFECTS: print the player details
    private void printPlayerDetails(Player player) {
        System.out.println("Name: " + player.getName());
        System.out.println("Position: " + player.getPosition());
        System.out.println("Age: " + player.getAge());
        System.out.println("Height: " + player.getHeight());
        System.out.println("Jersey Number: " + player.getJerseyNumber());
        System.out.println("Minutes Played: " + player.getMinPlayed());
        System.out.println("Total Goals: " + player.getTotalGoals());
        System.out.println("Total Assists: " + player.getTotalAssists());
        System.out.println("Appearances: " + player.getAppearances());
        System.out.println("Yellow Cards: " + player.getYellowCards());
        System.out.println("Red Cards: " + player.getRedCards());
        System.out.println("Injured: " + player.getIsInjured());
        System.out.println("Wins: " + player.getWins());
        System.out.println("Losses: " + player.getLosses());
        System.out.println("Draws: " + player.getDraws());
    }
}
