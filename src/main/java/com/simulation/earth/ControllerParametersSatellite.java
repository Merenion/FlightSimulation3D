package com.simulation.earth;

import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.ManageSatellite;
import com.simulation.earth.manageSatellite.ManagerSatelliteDefault;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.spaceObjects.Satellite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

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

    private ManageSatellite manageSatellite = ManagerSatelliteDefault.getManager();
    private static Satellite satellite;
    private static boolean editorWindow = false;
    private static Group group;

    @FXML
    private void initialize (){
        initColoursOrbitAndPath();
        if (editorWindow){
            matchingParametersOrbitInWindow();
            matchingColorTrajectories();
            matchingMaxLengthTrajectories();
        }
    }

    public static void openWindowModalityCreator(Window parentWindow,Group group) {
        openWindow(parentWindow);
        editorWindow = false;
        satellite = null;
        ControllerParametersSatellite.group= group;
    }

    public static void openWindowModalityEditor (Window parentWindow, Satellite satellite) {
        openWindow(parentWindow);
        ControllerParametersSatellite.satellite = satellite;
        editorWindow = true;
    }

    private static void openWindow (Window parentWindow) {
        try {
            Stage stage =new Stage();
            Parent root = FXMLLoader.load(ControllerParametersSatellite.class.getResource("/windowParametersSatellite.fxml"));
            stage.setTitle("Parameters satellite");
            stage.setResizable(false);           //запрет растягивание окна
            Scene scene = new Scene(root,600,273);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);            // делаем окно модальным
            stage.initOwner(parentWindow);  //указываем материнское окно
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initColoursOrbitAndPath () {
        ObservableList<ColorOrbit> colors = FXCollections.observableArrayList();
        colors.addAll(ColorOrbit.values());
        colourOrbit.setItems(colors);
        colourPathOnEarth.setItems(colors);
        colourOrbit.setValue(ColorOrbit.WHITE);
        colourPathOnEarth.setValue(ColorOrbit.GREEN);
    }

    private void matchingParametersOrbitInWindow(){
        OrbitParameters orbitParameters = satellite.getParametrsOrbit();
        angleNaclonPloskosti.setText(String.valueOf(orbitParameters.getI()));
        dolgotaVoshodychegoUzla.setText(String.valueOf(orbitParameters.getOmega0()));
        startingArgumentPerigee.setText(String.valueOf(orbitParameters.getW0()));
        hightApogey.setText(String.valueOf(orbitParameters.getHa()));
        hightPerigee.setText(String.valueOf(orbitParameters.getHpi()));
    }

    private void matchingParametersOrbitFromWindow(OrbitParameters orbitParameters){
        orbitParameters.setI(Double.parseDouble(angleNaclonPloskosti.getText()));
        orbitParameters.setOmega0(Double.parseDouble(dolgotaVoshodychegoUzla.getText()));
        orbitParameters.setW0(Double.parseDouble(startingArgumentPerigee.getText()));
        orbitParameters.setHa(Double.parseDouble(hightApogey.getText()));
        orbitParameters.setHpi(Double.parseDouble(hightPerigee.getText()));
    }

    private void matchingColorTrajectories () {
        colourOrbit.setValue(ColorOrbit.matchingColor(satellite.getColorOrbit()));
        colourPathOnEarth.setValue(ColorOrbit.matchingColor(satellite.getColorProjectionOnPlanet()));
    }

    private void matchingMaxLengthTrajectories () {
        lengthOrbit.setText(String.valueOf(satellite.getMaxLengthOrbit()));
        lengthPathonEarth.setText(String.valueOf(satellite.getMaxLengthProjectionOnPlanet()));
    }

    public void onBtCreatedSatellite(ActionEvent actionEvent) {
        final OrbitParameters orbitParameters;
        if (editorWindow){
            orbitParameters = satellite.getParametrsOrbit();
        }else {
            orbitParameters = new StorageOrbitParameters();
            matchingParametersOrbitFromWindow(orbitParameters);
            manageSatellite.createSatellite(orbitParameters,group);
        }
    }
}
