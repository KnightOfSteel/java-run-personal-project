package http.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.json.JsonArrayBuilder;
import notes.Notes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SearchHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = new JsonArrayBuilder().foundedNotes(new Notes().getNotesList());
        System.out.println(response);
        if (exchange.getRequestURI().getQuery().toLowerCase().contains("пароли")) {
            exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
            exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
            exchange.close();
        } else {
            response = "{" + "\"notes\"" + ": []}";
            exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
            exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
            exchange.close();
        }
    }
}
