package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;
    private Player player7;
    private Player player8;
    private Player player9;
    private Player player10;
    private Player player11;

    
    @BeforeEach
    void runBefore() {
        player1 = new Player("Maarten Paes", "Goalkeeper", 26, 192, 1);
        player2 = new Player("Calvin Verdonk'", "Defender", 27, 174, 2);
        player3 = new Player("Justin Hubner", "Defender", 21, 187, 23);
        player4 = new Player("Jay Idzes", "Defender", 24, 190, 3);
        player5 = new Player("Rizky Ridho", "Defender", 22, 183, 5);
        player6 = new Player("Sandy Walsh", "Defender", 29, 185, 6);
        player7 = new Player("Ivar Jenner", "Midfielder", 20, 188, 18);
        player8 = new Player("Nathan Tjoe-A-On", "Midfielder", 22, 182, 22);
        player9 = new Player("Ragnar Oratmangoen", "Midfielder", 26, 181, 11);
        player10 = new Player("Marselino Ferdinan", "Midfielder", 20, 178, 7);
        player11 = new Player("Rafael Struick", "Forward", 21, 185, 9);
    }

    @Test
    void testPlayerConstructor() {
        assertEquals("Maarten Paes", player1.getName());
        assertEquals("Goalkeeper", player1.getPosition());
        assertEquals(26, player1.getAge());
        assertEquals(192, player1.getHeight());
        assertEquals(1, player1.getJerseyNumber());
        assertEquals(0, player1.getMinPlayed());
        assertEquals(0, player1.getTotalGoals());
        assertEquals(0, player1.getTotalAssists());
        assertEquals(0, player1.getAppearances());
        assertEquals(0, player1.getYellowCards());
        assertEquals(0, player1.getRedCards());
        assertFalse(player1.getIsInjured());
        assertEquals(0, player1.getWins());
        assertEquals(0, player1.getLosses());
        assertEquals(0, player1.getDraws());
    }

    @Test
    void testAddMinPlayed() {
        player1.addMinPlayed(90);
        assertEquals(90, player1.getMinPlayed());
    }

    @Test
    void testScoredGoal() {
        player11.addGoal();
        assertEquals(1, player1.getTotalGoals());
    }

    @Test
    void testScoredGoalMultiple() {
        player11.addGoal();
        assertEquals(1, player11.getTotalGoals());
        player11.addGoal();
        assertEquals(2, player11.getTotalGoals());
    }

    @Test
    void testCreatedAssist() {
        player10.addAssist();
        assertEquals(1, player10.getTotalAssists());
    }

    @Test
    void testCreatedAssistMultiple() {
        player10.addAssist();
        assertEquals(1, player10.getTotalAssists());
        player10.addAssist();
        assertEquals(2, player10.getTotalAssists());
    }

    @Test
    void testAddAppearances() {
        player1.addAppearances();
        assertEquals(1, player1.getAppearances());
    }

    @Test
    void testAddYellowCards() {
        player2.addYellowCards();
        assertEquals(1, player2.getYellowCards());
    }

    @Test
    void testAddTwoYellowCards() {
        player2.addYellowCards();
        assertEquals(1, player2.getYellowCards());
        player2.addYellowCards();
        assertEquals(2, player2.getYellowCards());
    }

    @Test
    void testAddRedCards() {
        player3.addRedCards();
        assertEquals(1, player3.getRedCards());
    }

    @Test
    void testSetIsInjured() {
        player4.setIsInjured();
        assertTrue(player4.getIsInjured());
    }
}
