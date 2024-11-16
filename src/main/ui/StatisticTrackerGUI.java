package ui;

import model.Player;
import model.Team;

import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the graphical user interface (GUI) for the Statistic Tracker application.
 * 
 * The StatisticTrackerGUI class provides a user-friendly interface for managing teams and players.
 * It allows users to create, view, edit, and delete teams and players, as well as track various statistics.
 * The GUI is built using Swing components and includes features such as:
 * - Creating new teams and players
 * - Viewing and editing team and player information
 * - Incrementing statistics such as wins, losses, draws, and minutes played
 * - Saving and loading teams from a JSON file
 * - Comparing players based on their statistics
 * 
 * The class uses a CardLayout to switch between different panels, including the main menu, team, and player panel.
 * It also handles user interactions through action listeners and displays information using various Swing components.
 * 
 * The class relies on the JsonReader and JsonWriter classes for persisting team data to a JSON file.
 */

public class StatisticTrackerGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private List<Team> teams;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private int teamIndex = 0;
    private int playerIndex = 0;

    // MODIFIES: this
    // EFFECTS: Initializes the GUI with default values and components.
    public StatisticTrackerGUI() {
        teams = new ArrayList<>();
        initializeUI();
        jsonReader = new JsonReader("data/teams.json");
        jsonWriter = new JsonWriter("data/teams.json");
    }

    // MODIFIES: this
    // EFFECTS: Sets up the main UI components for the application.
    private void initializeUI() {
        frame = new JFrame("Statistic Tracker™");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 900);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(mainMenuPanel(), "MainMenu");
        mainPanel.add(teamPanel(), "Teams");
        // mainPanel.add(playerPanel(), "Players");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // EFFECTS: Returns the main menu panel for the application.
    private JPanel mainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon logo = new ImageIcon("image\\logo.png");
        JLabel logoPanel = new JLabel(logo);
        logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logoPanel);
    
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
    
        addButton(panel, "Create New Team", e -> showCreateTeamDialog());
        addButton(panel, "View and Edit Teams", e -> {
            updateTeamPanel();
            cardLayout.show(mainPanel, "Teams");
        });
        addButton(panel, "Load Teams from File", e -> loadTeams());
        addButton(panel, "Save Teams to File", e -> saveTeams());
        addButton(panel, "Exit", e -> System.exit(0));
    
        return panel;
    }

    // REQUIRES: panel is not null; text is not null or empty; actionListener is not null.
    // MODIFIES: panel
    // EFFECTS: Adds a button with the given text and action listener to the panel.
    private void addButton(JPanel panel, String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(actionListener);
        Dimension buttonSize = new Dimension(400, 40);
        button.setPreferredSize(buttonSize);
        button.setMaximumSize(buttonSize);
        button.setMinimumSize(buttonSize);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
    }

    // EFFECTS: Creates and returns a panel for managing teams.
    private JPanel teamPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createHeaderPanel(), BorderLayout.NORTH);
        panel.add(createScrollPane(), BorderLayout.CENTER);
        panel.add(createButtonPanel(), BorderLayout.SOUTH);
        return panel;
    }

    // EFFECTS: Creates and returns the header panel for the team panel.
    private JPanel createHeaderPanel() {
        JLabel label = new JLabel("Teams", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(label, BorderLayout.CENTER);
        return headerPanel;
    }

    // EFFECTS: Creates and returns a scrollable panel for team and player information.
    private JScrollPane createScrollPane() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    
        if (teams.isEmpty()) {
            JLabel noTeamsLabel = new JLabel("No teams available", JLabel.CENTER);
            noTeamsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            centerPanel.add(noTeamsLabel);
        } else {
            centerPanel.add(createTeamInfoPanel());
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            centerPanel.add(createPlayerPanel());
        }
    
        return new JScrollPane(centerPanel);
    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // EFFECTS: Creates and returns a panel displaying detailed information about the selected team.
    private JPanel createTeamInfoPanel() {
        Team team = teams.get(teamIndex);
        JPanel teamInfoPanel = new JPanel();
        teamInfoPanel.setLayout(new BoxLayout(teamInfoPanel, BoxLayout.Y_AXIS));
        teamInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        teamInfoPanel.add(new JLabel("Team Name: " + team.getTeamName()));
        teamInfoPanel.add(new JLabel("Coach: " + team.getCoachName()));
        teamInfoPanel.add(new JLabel("Total Wins: " + team.getTotalWins()));
        teamInfoPanel.add(new JLabel("Total Losses: " + team.getTotalLosses()));
        teamInfoPanel.add(new JLabel("Total Draws: " + team.getTotalDraws()));
        return teamInfoPanel;
    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // EFFECTS: Creates and returns a panel displaying the players of the selected team.
    private JPanel createPlayerPanel() {
        Team team = teams.get(teamIndex);
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        playerPanel.add(new JLabel("Players:"));
    
        for (Player player : team.getPlayers()) {
            String playerInfo = player.getName() + " - Age: " + player.getAge() + ", Height: " + player.getHeight();
            playerPanel.add(new JLabel(playerInfo));
        }
    
        return playerPanel;
    }

    // EFFECTS: Creates and returns a panel containing buttons for managing teams and players.
    private JPanel createButtonPanel() {
        JPanel buttonPanelSouth = new JPanel();
        buttonPanelSouth.setLayout(new BoxLayout(buttonPanelSouth, BoxLayout.Y_AXIS));
    
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
        row1.add(createButton("Increment Wins", e -> incrementWins()));
        row1.add(createButton("Increment Losses", e -> incrementLosses()));
        row1.add(createButton("Increment Draws", e -> incrementDraws()));
    
        row2.add(createButton("Add Player", e -> addPlayer()));
        row2.add(createButton("Remove Player", e -> removePlayer()));
        row2.add(createButton("Compare Players", e -> comparePlayers()));
        row2.add(createButton("View and Edit Player", e -> viewEditPlayer()));
    
        row3.add(createButton("Previous Team", e -> previousTeam()));
        row3.add(createButton("Back to Main Menu", e -> backToMainMenu()));
        row3.add(createButton("Next Team", e -> nextTeam()));
    
        buttonPanelSouth.add(row1);
        buttonPanelSouth.add(row2);
        buttonPanelSouth.add(row3);
    
        return buttonPanelSouth;
    }

    // REQUIRES: text is not null or empty; listener is not null.
    // EFFECTS: Creates and returns a JButton with the given text and action listener.
    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: The selected team in teams.
    // EFFECTS: Increments the win count of the selected team.
    private void incrementWins() {

    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: The selected team in teams.
    // EFFECTS: Increments the loss count of the selected team.
    private void incrementLosses() {

    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: The selected team in teams.
    // EFFECTS: Increments the draw count of the selected team.
    private void incrementDraws() {

    }

    // MODIFIES: The players list of the selected team.
    // EFFECTS: Opens a dialog to add a new player to the selected team.
    private void addPlayer() {

    }

    // EFFECTS: Returns an array of input fields for adding a new player.
    private Object[] createPlayerInputFields() {
        return null;
    }

    // REQUIRES: team is not null, and message contains valid input fields.
    // MODIFIES: team
    // EFFECTS: Parses input and adds a new player to the given team.
    private void handlePlayerInput(Team team, Object[] message) {

    }

    // REQUIRES: message contains valid input fields.
    // EFFECTS: Parses input fields to create a Player object. Returns null if input is invalid.
    private Player parsePlayerInput(Object[] message) {
        return null;
    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: The players list of the selected team.
    // EFFECTS: Opens a dialog to remove a player from the selected team.
    private void removePlayer() {

    }

    // REQUIRES: team is not null, playerName is not null or empty.
    // MODIFIES: team
    // EFFECTS: Removes a player by name from the given team.
    private void handlePlayerRemoval(Team team, String playerName) {

    }

    // REQUIRES: message is not null.
    // EFFECTS: Displays an error dialog with the given message.
    private void showErrorDialog(String message) {

    }

    // REQUIRES: message is not null.
    // EFFECTS: Displays an information dialog with the given message.
    private void showInfoDialog(String message) {

    }

    // REQUIRES: teams is not empty, teamIndex is a valid index in teams, and the team has at least two players.
    // EFFECTS: Opens a dialog to compare two players from the selected team.
    private void comparePlayers() {

    }

    // REQUIRES: team is not null, player1ComboBox and player2ComboBox are not null.
    // EFFECTS: Compares two selected players and displays the result.
    private void handlePlayerComparison(Team team, JComboBox<String> player1ComboBox, JComboBox<String> player2ComboBox) {

    }

    // MODIFIES: this
    // EFFECTS: Displays the player panel for the selected team.
    private void viewEditPlayer() {

    }

    // MODIFIES: this
    // EFFECTS: Moves to the previous team and updates the view.
    private void previousTeam() {

    }

    // MODIFIES: this
    // EFFECTS: Moves to the next team and updates the view.
    private void nextTeam() {

    }

    // MODIFIES: this
    // EFFECTS: Returns to the main menu panel.
    private void backToMainMenu() {

    }

    // EFFECTS: Creates and returns the player management panel.
    private JPanel playerPanel() {
        return null;
    }

    // EFFECTS: Creates and returns the center panel for the player panel.
    private JPanel createCenterPanel() {
        return null;
    }

    // REQUIRES: playerShown is not null.
    // EFFECTS: Creates and returns a panel displaying information about the given player.
    private JPanel createPlayerInfoPanel(Player playerShown) {
        return null;
    }

    // EFFECTS: Creates and returns the button panel for the player panel.
    private JPanel createButtonPanelSouth() {
        return null;
    }

    // EFFECTS: Creates and returns the first row of buttons for the player panel.
    private JPanel createRow1() {
        return null;
    }

    // EFFECTS: Creates and returns the second row of buttons for the player panel.
    private JPanel createRow2() {
        return null;
    }

    // EFFECTS: Creates and returns the third row of buttons for the player panel.
    private JPanel createRow3() {
        return null;
    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the minutes played for the selected player.
    private void incrementMinutesPlayed() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the goal count for the selected player.
    private void incrementTotalGoals() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the assist count for the selected player.
    private void incrementTotalAssists() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the appearance count for the selected player.
    private void incrementAppearances() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the yellow card count for the selected player.
    private void incrementYellowCards() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Increments the red card count for the selected player.
    private void incrementRedCards() {

    }

    // REQUIRES: teams is not empty, teamIndex and playerIndex are valid indices.
    // MODIFIES: The selected player.
    // EFFECTS: Toggles the injured status for the selected player.
    private void toggleInjuredStatus() {

    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: this
    // EFFECTS: Moves to the previous player in the team.
    private void previousPlayer() {
        
    }

    // REQUIRES: teams is not empty, and teamIndex is a valid index in teams.
    // MODIFIES: this
    // EFFECTS: Moves to the next player in the team.
    private void nextPlayer() {

    }

    // MODIFIES: this
    // EFFECTS: Opens a dialog to create a new team and adds it to the list of teams.
    private void showCreateTeamDialog() {
        JTextField teamNameField = new JTextField();
        JTextField coachNameField = new JTextField();

        Object[] message = {
            "Team Name:", teamNameField,
            "Coach Name:", coachNameField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Create New Team", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String teamName = teamNameField.getText();
            String coachName = coachNameField.getText();

            if (!teamName.isEmpty() && !coachName.isEmpty()) {
                Team team = new Team(teamName, coachName);
                teams.add(team);
                JOptionPane.showMessageDialog(frame, "Team created successfully!", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Both fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Loads teams from a JSON file.
    private void loadTeams() {
        try {
            this.teams = jsonReader.read();
            JOptionPane.showMessageDialog(frame, "Teams loaded from file successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Unable to load teams from file: " + e.getMessage());
        }
    }

    // MODIFIES: this
    // EFFECTS: Saves teams to a JSON file.
    private void saveTeams() {
        try {
            jsonWriter.open();
            jsonWriter.write(this.teams);
            jsonWriter.close();
            JOptionPane.showMessageDialog(frame, "Teams saved to file successfully!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Unable to save teams to file: " + e.getMessage());
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates the player panel with the latest information.
    private void updatePlayerPanel() {

    }

    // MODIFIES: this
    // EFFECTS: Updates the team panel with the latest information.
    private void updateTeamPanel() {
        JPanel teamPanel = teamPanel();
        mainPanel.add(teamPanel, "Teams");
        cardLayout.show(mainPanel, "Teams");
    }

    // EFFECTS: Launches the Statistic Tracker GUI application.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StatisticTrackerGUI::new);
    }
}