package com.geekbrains.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Chat extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Chat.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        ChatController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}