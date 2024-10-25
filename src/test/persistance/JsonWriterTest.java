package persistance;

import model.Player;
import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Test for persistance in JsonWriter class

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            List<Team> teams = List.of(new Team("Team1", "Coach1"));
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTeam() {
        try {
            List<Team> teams = List.of();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTeam.json");
            writer.open();
            writer.write(teams);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTeam.json");
            teams = reader.read();
            assertEquals(0, teams.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTeam() {
        try {
            List<Team> teams = List.of(new Team("Team1", "Coach1"));
            teams.get(0).addPlayer(new Player("Player1", "CF", 20, 180, 9));
            teams.get(0).addPlayer(new Player("Player2", "GK", 21, 190, 1));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTeam.json");
            writer.open();
            writer.write(teams);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTeam.json");
            teams = reader.read();
            assertEquals(1, teams.size());
            Team team = teams.get(0);
            checkTeam("Team1", "Coach1", 0, 0, 0, team);
            List<Player> players = team.getPlayers();
            assertEquals(2, players.size());
            checkPlayer("Player1", "CF", 20, 180, 9, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, players.get(0));
            checkPlayer("Player2", "GK", 21, 190, 1, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, players.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
