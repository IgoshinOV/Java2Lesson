package com.geekbrains.chat.controllers;


import com.geekbrains.chat.Chat;
import com.geekbrains.chat.Network;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.function.Consumer;

public class AuthController {

    public static final String AUTH_COMMAND = "/auth";
    public static final String AUTH_OK_COMMAND = "/authOk";

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button authButton;

    private Chat chat;

    @FXML
    public void executeAuth() {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login == null || password == null || login.isBlank() || login.isBlank()) {
            chat.showErrorDialog("Логин и пароль должны быть указаны");
            return;
        }

        String authCommandMessage = String.format("%s %s %s", AUTH_COMMAND, login, password);

        try {
            Network.getInstance().sendMessage(authCommandMessage);
        } catch (IOException e) {
            chat.showErrorDialog("Ошибка передачи данных по сети");
            e.printStackTrace();
        }
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void initializeMessageHandler() {
        Network.getInstance().waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                if (message.startsWith(AUTH_OK_COMMAND)) {
                    Thread.currentThread().interrupt();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String[] parts = message.split(" ");
                            String userName = parts[1];
                            chat.getChatStage().setTitle(userName);
                            chat.getAuthStage().close();
                        }
                    });
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            chat.showErrorDialog("Пользователя с таким логином и паролем не существует");
                        }
                    });
                }
            }
        });
    }
}

