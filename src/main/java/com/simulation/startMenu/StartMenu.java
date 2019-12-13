package com.simulation.startMenu;

import com.simulation.earth.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu {
    @FXML
    public AnchorPane forma;

    @FXML
    public void initialize () {
    }

    public void onBtProgram1(ActionEvent actionEvent) throws IOException {
        System.out.println("action bt open program 1");
        com.simulation.assembly.Main main = new com.simulation.assembly.Main();
        main.start(new Stage());
        Stage stageThis = (Stage) forma.getScene().getWindow();
        stageThis.close();
    }

    public void onBtProgram3(ActionEvent actionEvent) {
    }

    public void onBtProgram2(ActionEvent actionEvent) throws IOException {
        System.out.println("action bt open program 2");
        com.simulation.earth.Main main = new com.simulation.earth.Main();
        main.start(new Stage());
        Stage stageThis = (Stage) forma.getScene().getWindow();
        stageThis.close();
    }

    public void onBtHelp(ActionEvent actionEvent) throws IOException {
        System.out.println("action bt info project");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/assembly/startMenu/AboutTheProgram.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage= new Stage();
        stage.setTitle("О программе");
        stage.setResizable(false);
        Scene scene = new Scene(root, 695, 443);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

             /**вызываем модальное окно где будет инфо о программе*/
    public void onBtAboutTheProgram(ActionEvent actionEvent) throws IOException {
        System.out.println("action bt info project");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/AboutTheProgram.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage= new Stage();
        stage.setTitle("О программе");
        stage.setResizable(false);
        Scene scene = new Scene(root, 695, 443);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }
}
