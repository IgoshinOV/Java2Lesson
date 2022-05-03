package com.geekbrains.chat;

import com.geekbrains.chat.controllers.AuthController;
import com.geekbrains.chat.controllers.ChatController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Chat extends Application {
    private Stage chatStage;
    private Stage authStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.chatStage = primaryStage;
        ChatController controller = createChatDialog(primaryStage);
        connectToServer(controller);
        createAuthDialog(primaryStage);
        controller.initializeMessageHandler();
    }

    private void createAuthDialog(Stage primaryStage) throws IOException {
        FXMLLoader authLoader = new FXMLLoader();
        authLoader.setLocation(Chat.class.getResource("authDialog.fxml"));
        AnchorPane authDialogPanel = authLoader.load();
        authStage = new Stage();
        authStage.initOwner(primaryStage);
        authStage.initModality(Modality.WINDOW_MODAL);
        authStage.setScene(new Scene(authDialogPanel));
        AuthController authController = authLoader.getController();
        authController.setChat(this);
        authController.initializeMessageHandler();
        authStage.showAndWait();
    }

    private ChatController createChatDialog(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Chat.class.getResource("chat-template.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.chatStage.setTitle("Java FX Application");
        this.chatStage.setScene(scene);
        ChatController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");
        primaryStage.show();
        return controller;
    }

    private void connectToServer(ChatController chatController) {
        boolean resultConnectedToServer = Network.getInstance().connect();
        if (!resultConnectedToServer) {
            String errorMessage = "Невозможно установить сетевое соединение";
            System.err.println(errorMessage);
            showErrorDialog(errorMessage);
        }
        chatController.setApplication(this);
        chatStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Network.getInstance().close();
            }
        });
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getAuthStage() {
        return authStage;
    }

    public Stage getChatStage() {
        return chatStage;
    }
}