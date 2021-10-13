package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import notes.Note;
import notes.NotesSrc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public abstract class NotesHttpHandler {

    NotesSrc notesSrc = new NotesSrc(new Note("Пароли", "А их тут нет", LocalDateTime.now()),
            new Note("Слон", "Неа", LocalDateTime.now()),
            new Note("Дерево", "Нет", LocalDateTime.now()),
            new Note("Мои пароли", "Нет", LocalDateTime.now()));

    void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
        exchange.close();
    }
}
