package com.simulation.earth;

import com.simulation.earth.manageSatellite.*;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SatelliteWithParametersCA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/**
 * класс дял работы со спутником.
 * Имеет два предназначения - для изменения параметров и создания спутника.
 * окно создается вызовом статического метода этого класса.
 * Используются статические поля для простоты передачи данных в окно.
 */
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
    public ComboBox<ColorSmart> colourOrbit;
    @FXML
    public ComboBox<ColorSmart> colourPathOnEarth;
    @FXML
    public TextField lengthPathonEarth;
    @FXML
    public TextField lengthOrbit;
    @FXML
    public TextField nameSatellite;
    @FXML
    public Button btDelete;

    @FXML
    public TextField lPzs;
    @FXML
    public TextField lElemPzs;
    @FXML
    public TextField fOETK;
    @FXML
    public TextField shON;
    @FXML
    public TextField dolgON;
    @FXML
    public RadioButton Pobraz;
    @FXML
    public RadioButton Sobraz;
    @FXML
    public RadioButton Uobraz;
    @FXML
    public TextField maksUgolKAotNadira;
    @FXML
    public TextField maksHSunGoriz;
    @FXML
    public TextField timePerenac;
    @FXML
    public RadioButton schemaA;
    @FXML
    public RadioButton schemaB;
    @FXML
    public RadioButton schemaC;

    /**
     * Метод инициализации окна.
     * Скрывает кнопку удаления спутника
     * при открытии окна редактирования спутника
     */
    @FXML
    private void initialize() {
        initColoursOrbitAndPath();
        if (editorWindow) {
            matchingParametersOrbitInWindow();
            matchingParametersCaInWindow();
            matchingColorTrajectories();
            matchingMaxLengthTrajectories();
            nameSatellite.setText(satellite.getName());
        } else {
            btDelete.setVisible(false);
            btDelete.setDisable(true);
        }
    }

    private static Space space;
    /**
     * Менеджер спутников (через него создаем спутники)
     */
    private ManageSatellite manageSatellite = ManagerSatelliteEarth.getManager();
    private static Satellite satellite;
    private static boolean editorWindow = false;

    /**
     * Метод для открытия окна создания спутника
     *
     * @param parentWindow окно с которого открывается вызываемое окно (модальное)
     * @param space        пространство
     */
    public static void openWindowModalityCreator(Window parentWindow, Space space) {
        editorWindow = false;
        satellite = null;
        ControllerParametersSatellite.space = space;
        openWindow(parentWindow);
    }

    /**
     * Метод для открытия окна редактирования спутника
     *
     * @param parentWindow окно с которого открывается вызываемое окно(модальное)
     * @param satellite    спутник который требует отредактировать
     */
    public static void openWindowModalityEditor(Window parentWindow, Satellite satellite) {
        editorWindow = true;
        ControllerParametersSatellite.satellite = satellite;
        openWindow(parentWindow);
    }

    /**
     * внутренний метод открытия окна (подгрузки и т.д.)
     *
     * @param parentWindow окно с которого открывается вызываемое окно(модальное)
     */
    private static void openWindow(Window parentWindow) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(ControllerParametersSatellite.class.getResource("/earth/windowParametersSatellite.fxml"));
            stage.setTitle("Parameters satellite");
            stage.setResizable(false);           //запрет растягивание окна
            Scene scene = new Scene(root, 603, 348);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);            // делаем окно модальным
            stage.initOwner(parentWindow);  //указываем материнское окно
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * подготавливает бар меню цветов для выбора цвета орбиты
     */
    private void initColoursOrbitAndPath() {
        ObservableList<ColorSmart> colors = FXCollections.observableArrayList();
        colors.addAll(ColorSmart.values());
        colourOrbit.setItems(colors);
        colourPathOnEarth.setItems(colors);
        colourOrbit.setValue(ColorSmart.WHITE);
        colourPathOnEarth.setValue(ColorSmart.GREEN);
    }

    /**
     * Используется при изменении параметров спутника.
     * Берет установленный для спутника цвет орбиты и задает его в GUI
     */
    private void matchingParametersOrbitInWindow() {
        OrbitParameters orbitParameters = satellite.getParametrsOrbit();
        angleNaclonPloskosti.setText(String.valueOf(orbitParameters.getI()));
        dolgotaVoshodychegoUzla.setText(String.valueOf(orbitParameters.getOmega0()));
        startingArgumentPerigee.setText(String.valueOf(orbitParameters.getW0()));
        hightApogey.setText(String.valueOf(orbitParameters.getHa()));
        hightPerigee.setText(String.valueOf(orbitParameters.getHpi()));
    }

    private void matchingParametersCaInWindow() {
        CaParameters caParameters = ((SatelliteWithParametersCA) satellite).getCaParameters();
        lPzs.setText(String.valueOf(caParameters.lPzs));
        lElemPzs.setText(String.valueOf(caParameters.lElemPzs));
        fOETK.setText(String.valueOf(caParameters.fOETK));
        shON.setText(String.valueOf(caParameters.shON));
        dolgON.setText(String.valueOf(caParameters.dolgON));
        maksUgolKAotNadira.setText(String.valueOf(caParameters.maksUgolKAotNadira));
        maksHSunGoriz.setText(String.valueOf(caParameters.maksHSunGoriz));
        timePerenac.setText(String.valueOf(caParameters.timePerenac));

        if (caParameters.typeON.equals(TypeON.P_OBRAZ))
            Pobraz.setSelected(true);
        if (caParameters.typeON.equals(TypeON.U_OBRAZ))
            Uobraz.setSelected(true);
        if (caParameters.typeON.equals(TypeON.S_OBRAZ))
            Sobraz.setSelected(true);

        if (caParameters.schemaKA.equals(SchemaKA.SCHEMA_A))
            schemaA.setSelected(true);
        if (caParameters.schemaKA.equals(SchemaKA.SCHEMA_B))
            schemaB.setSelected(true);
        if (caParameters.schemaKA.equals(SchemaKA.SCHEMA_C))
            schemaC.setSelected(true);

    }

    /**
     * Задает параметры орбиты заданные в окне GUI в класс хранения
     *
     * @param orbitParameters класс хранящий параметры орбиты
     */
    private void matchingParametersOrbitFromWindow(OrbitParameters orbitParameters) {
        orbitParameters.setI(Double.parseDouble(angleNaclonPloskosti.getText()));
        orbitParameters.setOmega0(Double.parseDouble(dolgotaVoshodychegoUzla.getText()));
        orbitParameters.setW0(Double.parseDouble(startingArgumentPerigee.getText()));
        orbitParameters.setHa(Double.parseDouble(hightApogey.getText()));
        orbitParameters.setHpi(Double.parseDouble(hightPerigee.getText()));
    }

    /**
     * Задает параметры орбиты заданные в окне GUI в класс хранения
     */
    private void matchingParametersCAFromWindow(CaParameters caParameters) {
        caParameters.lPzs = (Double.parseDouble(lPzs.getText()));
        caParameters.lElemPzs = (Double.parseDouble(lElemPzs.getText()));
        caParameters.fOETK = (Double.parseDouble(fOETK.getText()));
        caParameters.shON = (Double.parseDouble(shON.getText()));
        caParameters.dolgON = (Double.parseDouble(dolgON.getText()));
        caParameters.maksUgolKAotNadira = (Double.parseDouble(maksUgolKAotNadira.getText()));
        caParameters.maksHSunGoriz = (Double.parseDouble(maksHSunGoriz.getText()));
        caParameters.timePerenac = (Double.parseDouble(timePerenac.getText()));

        if (Pobraz.isSelected())
            caParameters.typeON = TypeON.P_OBRAZ;
        if (Uobraz.isSelected())
            caParameters.typeON = TypeON.U_OBRAZ;
        if (Sobraz.isSelected())
            caParameters.typeON = TypeON.S_OBRAZ;

        if (schemaA.isSelected())
            caParameters.schemaKA = SchemaKA.SCHEMA_A;
        if (schemaB.isSelected())
            caParameters.schemaKA = SchemaKA.SCHEMA_B;
        if (schemaC.isSelected())
            caParameters.schemaKA = SchemaKA.SCHEMA_C;

    }

    /**
     * Используется при изменении параметров спутника.
     * Берет установленный для спутника цвет прорисовки подспутниковой точки и задает его в GUI
     */
    private void matchingColorTrajectories() {
        colourOrbit.setValue(ColorSmart.matchingColor(satellite.getColorOrbit()));
        colourPathOnEarth.setValue(ColorSmart.matchingColor(satellite.getColorProjectionOnPlanet()));
    }

    /**
     * Используется при изменении параметров спутника.
     * Берет установленную для спутника максимальную длину
     * прорисовки орбиты и пути подспутниковой точки
     * и устанавливает их в окне GUI
     */
    private void matchingMaxLengthTrajectories() {
        lengthOrbit.setText(String.valueOf(satellite.getMaxLengthOrbit()));
        lengthPathonEarth.setText(String.valueOf(satellite.getMaxLengthProjectionOnPlanet()));
    }

    /**
     * Создает спутник при запуске окна создания.
     * Или изменяет спутник при запуске окна изменения спутника.
     * Закрывает окно.
     *
     * @param actionEvent параметр нажатия на кнопку
     */
    public void onBtCreatedSatellite(ActionEvent actionEvent) {
        final OrbitParameters orbitParameters;
        final CaParameters caParameters;
        final Satellite satellite;
        if (editorWindow) {
            satellite = ControllerParametersSatellite.satellite;
            orbitParameters = satellite.getParametrsOrbit();
            matchingParametersOrbitFromWindow(orbitParameters);
            matchingParametersCAFromWindow(((SatelliteWithParametersCA) satellite).getCaParameters());
        } else {
            orbitParameters = new StorageOrbitParameters();
            caParameters = new CaParameters();
            matchingParametersOrbitFromWindow(orbitParameters);
            matchingParametersCAFromWindow(caParameters);
            satellite = manageSatellite.createSatelliteWithParametersCA(orbitParameters,caParameters, nameSatellite.getText());
            space.getSpaceObjects().add(satellite);
        }
        satellite.prepareStartCootdints();
        satellite.setColorProjectionOnPlanet(colourPathOnEarth.getValue().getColor());
        satellite.setColorOrbit(colourOrbit.getValue().getColor());
        satellite.setMaxLengthProjectionOnPlanet(Integer.parseInt(lengthPathonEarth.getText()));
        satellite.setMaxLengthOrbit(Integer.parseInt(lengthOrbit.getText()));
        satellite.setName(nameSatellite.getText());
        Stage stage = (Stage) nameSatellite.getScene().getWindow();
        stage.close();
    }

    /**
     * Удаляет спутник и еепрорисованные пути
     *
     * @param actionEvent параметр нажатия на кнопку
     */
    public void onBtDelete(ActionEvent actionEvent) {
        space.getSpaceObjects().remove(satellite);
        manageSatellite.deleteSatellite(satellite);
        Stage stage = (Stage) nameSatellite.getScene().getWindow();
        stage.close();
    }
}
