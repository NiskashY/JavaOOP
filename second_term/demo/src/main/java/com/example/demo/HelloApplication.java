package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Scene BackScene;
    public static void changeScene(Stage window, String fxml_file) throws IOException {
        BackScene = window.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml_file));
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
    }

    public static void goBackScene(Stage window) {
        Scene tmp = window.getScene();
        window.setScene(BackScene);
        BackScene = tmp;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600,  480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        final String kFileName = "accounts.txt";
        Model.setAccounts(Reader.ReadFromFile(kFileName));
        //Model.NotifyHard(Model.);
        launch();
        Reader.WriteIntoFile(Model.getAccounts(), kFileName);
    }
}