package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.json.JsonArrayBuilder;

import java.io.IOException;

public class NotesListHandler extends NotesHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = new JsonArrayBuilder().build(notesSrc.getNotesList());
        sendResponse(exchange, response);
    }
}
