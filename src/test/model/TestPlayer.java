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

    
    @BeforeEach
    void runBefore() {
        player1 = new Player("Rafael Struick", "Forward", 21, 185, 9);
        player2 = new Player("Ivar Jenner", "Midfielder", 20, 188, 18);
        player3 = new Player("Justin Hubner", "Defender", 21, 187, 23);
    }

    @Test
    void testPlayerConstructor() {
        assertEquals("Rafael Struick", player1.getName());
        assertEquals("Forward", player1.getPosition());
        assertEquals(21, player1.getAge());
        assertEquals(185, player1.getHeight());
        assertEquals(9, player1.getJerseyNumber());
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
    void testAddGoal() {
        player1.addGoal();
        assertEquals(1, player1.getTotalGoals());
    }

    @Test
    void testAddGoalMultiple() {
        player1.addGoal();
        assertEquals(1, player1.getTotalGoals());
        player1.addGoal();
        assertEquals(2, player1.getTotalGoals());
    }

    @Test
    void testAddAssist() {
        player1.addAssist();
        assertEquals(1, player1.getTotalAssists());
    }

    @Test
    void testAddAssistMultiple() {
        player1.addAssist();
        assertEquals(1, player1.getTotalAssists());
        player1.addAssist();
        assertEquals(2, player1.getTotalAssists());
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
        player3.setIsInjured();
        assertTrue(player3.getIsInjured());
    }

    @Test
    void testIsAvailable() {
        assertTrue(player1.isAvailable());
        player1.setIsInjured();
        assertFalse(player1.isAvailable());
    }
}
