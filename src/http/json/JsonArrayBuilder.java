package http.json;

import notes.Note;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayBuilder {

    public String build(List<Note> notes) {
        StringBuilder result = new StringBuilder("[");
        List<String> notesString = new ArrayList<>();
        for (Note note : notes) {
            String noteString = new JsonBuilder().build(note);
            notesString.add(noteString);
        }
        String collectedArray = String.join(", ", notesString);
        result.append(collectedArray);
        result.append("]");
        return result.toString();
    }
}
