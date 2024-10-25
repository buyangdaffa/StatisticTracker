package persistance;

import org.json.JSONObject;

/**
 * Represents an interface for objects that can be converted to a JSON object.
 * 
 * The Writable interface provides a method to convert an implementing class
 * to a JSON object. This is useful for saving the state of an object to a file
 * or for transmitting the object over a network in a standardized format.
 * 
 * Classes that implement this interface must provide an implementation of the
 * toJson method, which returns a JSONObject representation of the object.
 */

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
