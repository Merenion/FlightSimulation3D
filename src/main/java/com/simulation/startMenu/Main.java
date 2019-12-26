package com.simulation.startMenu;

import com.simulation.earth.ScreenResolution;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(getClass().getResource("/assembly/startMenu/StartMenu.fxml"));
        stage.setTitle("Выбор программы");
        Scene scene= new Scene(root,655,338);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}