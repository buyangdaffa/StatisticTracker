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
    
    // EFFECTS: creates an instance of the StatisticTracker console ui application
    public StatisticTracker() {
        init();

        System.out.println("Hello Coach! What do you want to do?");

        while (this.running) {
            appRunning();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes the StatisticTracker
    private void init() {
        this.teams = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.running = true;
    }

    // EFFECTS: runs the StatisticTracker application
    private void appRunning() {
        startMenu();
        String input = this.input.nextLine();
        processMenuCommands(input);
    }

    // MODIFIES: this
    // EFFECTS: starts the StatisticTracker menu
    private void startMenu() {
        System.out.println("1. Create a new team");
        System.out.println("2. View all teams");
        System.out.println("3. Exit");
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
            Scanner scanner = new Scanner(System.in);
            int currentTeamIndex = 0;
            String input = "";
    
            while (!input.equals("q")) {
                // Display current team
                Team team = this.teams.get(currentTeamIndex);
                printTeamDetails(team);
    
                // Prompt user for action
                System.out.println("\nPress ENTER to view next team, or 'q' to quit.");
                input = scanner.nextLine();
    
                if (input.equals("")) {
                    // Move to the next team
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
        System.out.println("Players:");
        for (Player player : team.getPlayers()) {
            System.out.println("Name: " + player.getName());
            System.out.println("Position: " + player.getPosition());
            System.out.println("Jersey number: " + player.getJerseyNumber());
        }
    }
    

    
}
