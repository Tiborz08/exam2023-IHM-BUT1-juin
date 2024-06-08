package com.example.exam2023;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsoCarburantApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConsoCarburantApplication.class.getResource("saisie-v1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        SaisieController saisieController = fxmlLoader.getController();
        stage.setTitle("Calculateur de consommation d’essence");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}