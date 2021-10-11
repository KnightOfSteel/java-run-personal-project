package http.json;

import notes.Note;

import java.time.LocalDateTime;

public class JsonArrayBuilder {
    private final Note passNote = new Note("Пароли", "А их тут нет", LocalDateTime.now());

    public String build() {
        return "{" + "\"notes" + "\"" + ": " +
                "[ " + new JsonBuilder().build(passNote) +
                " ]" +
                "}";
    }
}
