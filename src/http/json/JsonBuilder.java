package http.json;

import notes.Note;

public class JsonBuilder {
    public String build(Note note){
        return "{" + "\"title" + "\"" + ":" + "\"" + note.getTitle() + "\"" + ", " +
                "\"content" + "\"" + ":" + "\"" + note.getContent() + "\"" + ", " +
                "\"creationDate" + "\"" + ":" + "\"" + note.getCreationDate() + "\"" + "}";
    }
}
