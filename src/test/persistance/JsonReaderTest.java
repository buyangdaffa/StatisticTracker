package persistance;

import model.Player;
import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            List<Team> teams = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTeam.json");
        try {
            List<Team> teams = reader.read();
            assertEquals(0, teams.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTeam.json");
        try {
            List<Team> teams = reader.read();
            assertEquals(1, teams.size());
            Team team = teams.get(0);
            checkTeam("Team1", "Coach1", 1, 2, 3, team);
            List<Player> players = team.getPlayers();
            assertEquals(2, players.size());
            checkPlayer("Player1", "CF", 20, 180, 9, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, players.get(0));
            checkPlayer("Player2", "GK", 21, 190, 1, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, players.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeamWithStats() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTeamWithStats.json");
        try {
            List<Team> teams = reader.read();
            assertEquals(1, teams.size());
            Team team = teams.get(0);
            checkTeam("Team1", "Coach1", 1, 2, 3, team);
            List<Player> players = team.getPlayers();
            assertEquals(2, players.size());
            checkPlayer("Player1", "CF", 20, 180, 9, 90, 3, 2, 3, 1, 1, false, 1, 2, 3, players.get(0));
            checkPlayer("Player2", "GK", 21, 190, 1, 90, 1, 1, 3, 2, 1, true, 1, 2, 3, players.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
