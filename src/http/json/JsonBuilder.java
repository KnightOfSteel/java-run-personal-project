package http.json;

import notes.Note;

public class JsonBuilder {
    public String build(Note note){
        return String.format("{" + "\"title" + "\"" + ":" + "\"" + "%s" + "\"" + ", " +
                "\"content" + "\"" + ":" + "\"" + "%s" + "\"" + ", " +
                "\"creationDate" + "\"" + ":" + "\"" + "%s" + "\"" + "}", note.getTitle(), note.getContent(), note.getCreationDate());
    }
}
