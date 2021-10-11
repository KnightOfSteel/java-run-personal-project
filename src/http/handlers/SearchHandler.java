package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.json.JsonArrayBuilder;
import notes.Note;
import notes.NotesSrc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SearchHandler implements HttpHandler {
    private final NotesSrc notesSrc;

    public SearchHandler(NotesSrc notesSrc) {
        this.notesSrc = notesSrc;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "[]";
        if (exchange.getRequestURI().getQuery().toLowerCase().contains("пароли")) {
            List<Note> notes = notesSrc.searchBy("пароли");
            response = new JsonArrayBuilder().build(notes);
        }
        sendResponse(exchange, response);
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
        exchange.close();
    }
}
