package persistance;

import model.Team;
import model.Event;
import model.EventLog;
import org.json.JSONArray;

import java.io.*;
import java.util.List;

/**
 * Represents a writer that writes JSON representation of teams to a file.
 * 
 * The JsonWriter class provides methods to open a file for writing, write a list of Team objects
 * to the file in JSON format, and close the file. The class ensures that the JSON data is correctly
 * formatted and written to the specified destination file.
 * Referenced from the JsonSerialization Demo
 * https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

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
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of list of teams to file
    public void write(List<Team> teams) {
        JSONArray jsonArray = new JSONArray();
        for (Team team : teams) {
            jsonArray.put(team.toJson());
        }
        saveToFile(jsonArray.toString(TAB));
        EventLog.getInstance().logEvent(new Event("saved team data to file"));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}