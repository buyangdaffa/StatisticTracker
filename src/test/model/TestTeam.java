package model;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTeam {
    private Team team;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void runBefore() {
        player1 = new Player("Rafael Struick", "Forward", 21, 185, 9);
        player2 = new Player("Ivar Jenner", "Midfielder", 20, 188, 18);
        player3 = new Player("Justin Hubner", "Defender", 21, 187, 23);
        
        team = new Team("Indonesia", "Tae-yong Shin");
    }

    @Test
    void testTeamConstructor() {
        assertEquals("Indonesia", team.getTeamName());
        assertEquals("Tae-yong Shin", team.getCoachName());
        assertEquals(0, team.getTotalWins());
        assertEquals(0, team.getTotalLosses());
        assertEquals(0, team.getTotalDraws());
        assertEquals(0, team.getPlayers().size());
    }

    @Test
    void testAddPlayer() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertEquals(3, team.getPlayers().size());
        assertTrue(team.getPlayers().contains(player1));
        assertTrue(team.getPlayers().contains(player2));
        assertTrue(team.getPlayers().contains(player3));
    }

    @Test
    void testRemovePlayer() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertTrue(team.removePlayer("Rafael Struick"));
        assertEquals(2, team.getPlayers().size());
        assertFalse(team.getPlayers().contains(player1));
    }

    @Test
    void testRemovePlayerNotFound() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertFalse(team.removePlayer("Alphonso Davies"));
        assertEquals(3, team.getPlayers().size());
    }

    @Test
    void testIncrementWins() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.incrementWins();
        assertEquals(1, team.getTotalWins());
        assertEquals(1, player1.getWins());
        assertEquals(1, player2.getWins());
        assertEquals(1, player3.getWins());
    }

    @Test
    void testIncrementLosses() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.incrementLosses();
        assertEquals(1, team.getTotalLosses());
        assertEquals(1, player1.getLosses());
        assertEquals(1, player2.getLosses());
        assertEquals(1, player3.getLosses());
    }

    @Test
    void testIncrementDraws() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.incrementDraws();
        assertEquals(1, team.getTotalDraws());
        assertEquals(1, player1.getDraws());
        assertEquals(1, player2.getDraws());
        assertEquals(1, player3.getDraws());
    }

    @Test
    void testGetTotalPlayers() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertEquals(3, team.getTotalPlayers());
    }

    @Test
    void testGetTotalPlayersEmpty() {
        assertEquals(0, team.getTotalPlayers());
    }

    @Test
    void testGetAverageAge() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertEquals(20, team.getAverageAge());
    }

    @Test
    void testGetAverageAgeEmpty() {
        assertEquals(0, team.getAverageAge());
    }

    @Test
    void testGetAverageHeight() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        assertEquals(186, team.getAverageHeight());
    }

    @Test
    void testGetAverageHeightEmpty() {
        assertEquals(0, team.getAverageHeight());
    }
}
