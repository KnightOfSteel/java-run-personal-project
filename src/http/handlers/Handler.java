package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.json.JsonArrayBuilder;
import notes.NotesSrc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Handler implements HttpHandler {
    private final NotesSrc notesSrc;

    public Handler(NotesSrc notesSrc) {
        this.notesSrc = notesSrc;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = new JsonArrayBuilder().build(notesSrc.getNotesList());
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
        exchange.close();
    }
}
