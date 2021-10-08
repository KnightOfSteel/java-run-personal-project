package http.json;

import notes.Note;

public class JsonArrayBuilder {
    private final Note note = new Note("Пароли", "А их тут нет");

    public String build() {
        return "{" +
                "[ " + new JsonBuilder().build(note) +
                " ]" +
                "}";
    }
}
