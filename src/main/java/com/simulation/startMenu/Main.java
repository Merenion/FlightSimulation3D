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
        Parent root = FXMLLoader.load(getClass().getResource("/startMenu/StartMenu.fxml"));
        stage.setTitle("Выбор подпрограммы");
        Scene scene= new Scene(root,1019,605);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}