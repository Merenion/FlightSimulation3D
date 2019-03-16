package com.simulation.earth;

import com.simulation.earth.spaceObjects.Satellite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    public ComboBox<ColorOrbit> colourOrbit;
    @FXML
    public ComboBox<ColorOrbit> colourPathOnEarth;
    @FXML
    public TextField lengthPathonEarth;
    @FXML
    public TextField lengthOrbit;

    @FXML
    private void initialize (){
        initColoursOrbitAndPath();
    }

    private void initColoursOrbitAndPath () {
        ObservableList<ColorOrbit> colors = FXCollections.observableArrayList();
        colors.addAll(ColorOrbit.values());
        colourOrbit.setItems(colors);
        colourPathOnEarth.setItems(colors);
        colourOrbit.setValue(ColorOrbit.WHITE);
        colourPathOnEarth.setValue(ColorOrbit.GREEN);
    }

    public void onBtCreatedSatellite(ActionEvent actionEvent) {
    }
}
