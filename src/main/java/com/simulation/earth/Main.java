package com.simulation.earth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private ScreenResolution display = new ScreenResolution();

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/windowParametersSatellite.fxml"));
        stage.setTitle("Simulation Cosmos");
        Scene scene= ScreenResolution.getSceneWithSize(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}