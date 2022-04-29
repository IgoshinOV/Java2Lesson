package com.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        new Client().start("localhost", 8150);
    }

    public void start(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        System.out.println("Клиент запущен");
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        runInputLoop(inputStream);
        runOutputLoop(outputStream);
    }

    private void runInputLoop(DataInputStream inputStream) {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = inputStream.readUTF();
                    System.out.println("From server: " + message);
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
