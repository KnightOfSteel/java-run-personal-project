package http.json;

import notes.Note;
import notes.Notes;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayBuilder {

    public String buildAllNotes(List<Note> notes) {
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

    public String foundedNotes(List<Note> notes) {
        StringBuilder result = new StringBuilder("[");
        List<String> notesString = new ArrayList<>();
        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains("пароли")) {
                String noteString = new JsonBuilder().build(note);
                notesString.add(noteString);
            }
        }
        String collectedList = String.join(", ", notesString);
        result.append(collectedList);
        result.append("]");
        return result.toString();
    }
}
