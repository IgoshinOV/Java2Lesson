package server;

import server.chat.MyServer;

public class ServerApp {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        new MyServer().start(PORT);
    }
}
