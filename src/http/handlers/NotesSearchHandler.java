package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.json.JsonArrayBuilder;
import notes.Note;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class NotesSearchHandler extends NotesHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String[] queryParam = exchange.getRequestURI().getQuery().split("=");
        List<Note> notes = notesSrc.searchBy(queryParam[1].toLowerCase());
        String response = new JsonArrayBuilder().build(notes);
        sendResponse(exchange, response);
    }
}
