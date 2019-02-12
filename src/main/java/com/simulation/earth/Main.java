package com.simulation.earth;

import com.simulation.earth.objectControl.SmartGroup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;

public class Main extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/windowSimulation.fxml"));
        stage.setTitle("Simulation Cosmos");
        Scene scene= new Scene(root, 1200, 600);
        stage.setScene(scene);
        stage.show();


//
//        group.getChildren().add(new Sphere(50));
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                group.setTranslateX(group.getTranslateX()+1);
//            }
//        };
//        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
