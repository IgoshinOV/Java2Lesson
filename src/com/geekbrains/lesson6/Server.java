package com.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int PORT = 8150;

    public static void main(String[] args) throws IOException {
        new Server().start(PORT);
        
    }

    private void start(int port) throws IOException {
        try(ServerSocket serverSocket  = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен");
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            runInputLoop(inputStream);
            runOutputLoop(outputStream);
        }
    }
    private void runInputLoop(DataInputStream inputStream) {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = inputStream.readUTF();
                    System.out.println("From Client: " + message);
                } catch (IOException e) {
                    System.out.println("Подключение прервано");
                    System.exit(0);
                }
            }
        }).start();
    }

    private void runOutputLoop (DataOutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.startsWith("/end")) {
                System.exit(0);
            }
            outputStream.writeUTF(message);
        }
    }
}
