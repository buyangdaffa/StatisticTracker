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
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        assertEquals(11, team.getPlayers().size());
        assertTrue(team.getPlayers().contains(player1));
        assertTrue(team.getPlayers().contains(player2));
        assertTrue(team.getPlayers().contains(player3));
        assertTrue(team.getPlayers().contains(player4));
        assertTrue(team.getPlayers().contains(player5));
        assertTrue(team.getPlayers().contains(player6));
        assertTrue(team.getPlayers().contains(player7));
        assertTrue(team.getPlayers().contains(player8));
        assertTrue(team.getPlayers().contains(player9));
        assertTrue(team.getPlayers().contains(player10));
        assertTrue(team.getPlayers().contains(player11));
    }

    @Test
    void testRemovePlayer() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        assertTrue(team.removePlayer("Maarten Paes"));
        assertEquals(10, team.getPlayers().size());
        assertFalse(team.getPlayers().contains(player1));
    }

    @Test
    void testIncrementWins() {
        team.incrementWins();
        assertEquals(1, team.getTotalWins());
        assertEquals(1, player1.getWins());
        assertEquals(1, player2.getWins());
        assertEquals(1, player3.getWins());
        assertEquals(1, player4.getWins());
        assertEquals(1, player5.getWins());
        assertEquals(1, player6.getWins());
        assertEquals(1, player7.getWins());
        assertEquals(1, player8.getWins());
        assertEquals(1, player9.getWins());
        assertEquals(1, player10.getWins());
        assertEquals(1, player11.getWins());
    }

    @Test
    void testIncrementLosses() {
        team.incrementLosses();
        assertEquals(1, team.getTotalLosses());
        assertEquals(1, player1.getLosses());
        assertEquals(1, player2.getLosses());
        assertEquals(1, player3.getLosses());
        assertEquals(1, player4.getLosses());
        assertEquals(1, player5.getLosses());
        assertEquals(1, player6.getLosses());
        assertEquals(1, player7.getLosses());
        assertEquals(1, player8.getLosses());
        assertEquals(1, player9.getLosses());
        assertEquals(1, player10.getLosses());
        assertEquals(1, player11.getLosses());
    }

    @Test
    void testIncrementDraws() {
        team.incrementDraws();
        assertEquals(1, team.getTotalDraws());
        assertEquals(1, player1.getDraws());
        assertEquals(1, player2.getDraws());
        assertEquals(1, player3.getDraws());
        assertEquals(1, player4.getDraws());
        assertEquals(1, player5.getDraws());
        assertEquals(1, player6.getDraws());
        assertEquals(1, player7.getDraws());
        assertEquals(1, player8.getDraws());
        assertEquals(1, player9.getDraws());
        assertEquals(1, player10.getDraws());
        assertEquals(1, player11.getDraws());
    }

    @Test
    void testGetTotalPlayers() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        assertEquals(11, team.getTotalPlayers());
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
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        assertEquals(23, team.getAverageAge());
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
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        assertEquals(184, team.getAverageHeight());
    }

    @Test
    void testGetAverageHeightEmpty() {
        assertEquals(0, team.getAverageHeight());
    }
}
