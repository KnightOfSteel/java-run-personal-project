package http;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import http.handlers.NotesListHandler;
import http.handlers.NotesSearchHandler;

import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        startServer();
    }

    public static void startServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/notes", new NotesListHandler());
        server.createContext("/notes/search", new NotesSearchHandler());
        server.setExecutor(null);
        server.start();
    }
}
