package http;

import com.sun.net.httpserver.HttpServer;
import http.handlers.Handler;
import http.handlers.SearchHandler;

import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        startServer();
    }

    public static void startServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/notes", new Handler());
        server.createContext("/notes/search", new SearchHandler());
        server.setExecutor(null);
        server.start();
    }
}
