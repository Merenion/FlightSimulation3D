package com.simulation.earth;

import com.simulation.earth.spaceObjects.Satellite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Camera;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class ControllerParametersSatellite {
    @FXML
    public TextField angleNaclonPloskosti;
    @FXML
    public TextField dolgotaVoshodychegoUzla;
    @FXML
    public TextField startingArgumentPerigee;
    @FXML
    public TextField hightPerigee;
    @FXML
    public TextField hightApogey;
    @FXML
    public ComboBox<Color> colourOrbit;
    @FXML
    public ComboBox<Color> colourPathOnEarth;
    @FXML
    public TextField lengthPathonEarth;
    @FXML
    public TextField lengthOrbit;

    @FXML
    private void initialize (){
        initColoursOrbitAndPath();
    }

    private void initColoursOrbitAndPath () {
        ObservableList<Color> colours = FXCollections.observableArrayList();
        colours.addAll(Color.RED,Color.GREEN,Color.BLUE,Color.WHITE,Color.SKYBLUE,Color.PINK,Color.YELLOW);
        Color color = Color.GREEN;
        colourOrbit.setItems(colours);
//        colourPathOnEarth.setCellFactory(new PropertyValueFactory<>("name"));
    }
}
