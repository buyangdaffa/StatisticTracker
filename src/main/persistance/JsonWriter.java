package persistance;

import model.Team;
import org.json.JSONArray;

import java.io.*;
import java.util.List;

// Represents a writer that writes JSON representation of teams to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs a writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        // TODO: Implement this method
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of list of teams to file
    public void write(List<Team> teams) {
        // TODO: Implement this method
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        // TODO: Implement this method
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        // TODO: Implement this method
    }
}