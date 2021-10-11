package http;

import com.sun.net.httpserver.HttpServer;
import http.handlers.Handler;
import http.handlers.SearchHandler;
import notes.Note;
import notes.NotesSrc;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws Exception {
        startServer();
    }

    public static void startServer() throws Exception {
        NotesSrc notesSrc = new NotesSrc(new Note("Пароли", "А их тут нет", LocalDateTime.now()),
                new Note("Неа", "Неа", LocalDateTime.now()),
                new Note("Ну нет", "Нет", LocalDateTime.now()),
                new Note("Мои пароли", "Нет", LocalDateTime.now()));
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/notes", new Handler(notesSrc));
        server.createContext("/notes/search", new SearchHandler(notesSrc));
        server.setExecutor(null);
        server.start();
    }
}
