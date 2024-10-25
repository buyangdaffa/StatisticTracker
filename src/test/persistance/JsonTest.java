package persistance;

import model.Player;
import model.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JsonTest class to test the JsonReader and JsonWriter classes
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    protected void checkPlayer(String name, String position, int age, int height, int jerseyNumber, 
                               int minPlayed, int totalGoals, int totalAssists, int appearances, 
                               int yellowCards, int redCards, boolean isInjured, int wins, int losses, 
                               int draws, Player player) {
        assertEquals(name, player.getName());
        assertEquals(age, player.getAge());
        assertEquals(height, player.getHeight());
    }

    protected void checkTeam(String teamName, String coachName, int totalWins,
                             int totalLosses, int totalDraws, Team team) {
        assertEquals(teamName, team.getTeamName());
        assertEquals(coachName, team.getCoachName());
        assertEquals(totalWins, team.getTotalWins());
        assertEquals(totalLosses, team.getTotalLosses());
        assertEquals(totalDraws, team.getTotalDraws());
    }
}