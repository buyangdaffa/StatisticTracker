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
        System.out.println("2. View all teams");
        System.out.println("3. Edit a team");
        System.out.println("4. Exit");
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
                editTeam();
                break;
            case "4":
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
        System.out.println("Enter the team name:");
        String teamName = this.input.nextLine();
        System.out.println("Enter the coach name:");
        String coachName = this.input.nextLine();

        Team team = new Team(teamName, coachName);
        this.teams.add(team);

        System.out.println("Team created successfully!");
    }

    // EFFECTS: prints all the teams
    private void viewTeams() {
        if (this.teams.isEmpty()) {
            System.out.println("No teams found.");
        } else {
            int currentTeamIndex = 0;
            String input = "";

            while (!input.equals("q")) {
                Team team = this.teams.get(currentTeamIndex);
                printTeamDetails(team);

                printSeparator();
                System.out.println("Viewing team " + (currentTeamIndex + 1) + " of " + this.teams.size());
                System.out.println("\nPress ENTER to view the next team, 'q' to return to the main menu.");
                printSeparator();
                input = this.input.nextLine();

                if (input.equals("")) {
                    currentTeamIndex = (currentTeamIndex + 1) % this.teams.size();
                }
            }
        }
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
    private void editTeam() {
        if (this.teams.isEmpty()) {
            System.out.println("No teams found.");
        } else {
            int currentTeamIndex = 0;
            String input = "";

            while (!input.equals("q")) {
                Team team = this.teams.get(currentTeamIndex);
                printTeamDetails(team);

                printSeparator();
                System.out.println("Edit team " + (currentTeamIndex + 1) + " of " + this.teams.size());
                printEditTeamMenu();
                printSeparator();
                input = this.input.nextLine();

                if (input.equals("6")) {
                    break;
                }

                processEditCommands(input, team);
            }
        }
    }

    private void printEditTeamMenu() {
        System.out.println("1. Add player");
        System.out.println("2. Remove player");
        System.out.println("3. Increment wins");
        System.out.println("4. Increment losses");
        System.out.println("5. Increment draws");
        System.out.println("6. Return to main menu");
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
                team.incrementWins();
                System.out.println("Wins incremented successfully!");
                break;
            case "4":
                team.incrementLosses();
                System.out.println("Losses incremented successfully!");
                break;
            case "5":
                team.incrementDraws();
                System.out.println("Draws incremented successfully!");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
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
}
