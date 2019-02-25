package com.simulation.earth;

import com.simulation.earth.drawLineServis.LineToManager;
import com.simulation.earth.manageSpace.FactorySpace;
import com.simulation.earth.manageSpace.NearEarthFactory;
import com.simulation.earth.manageSpace.ParametersSpace;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.objectControl.MouseControl;
import com.simulation.earth.simulationProcessing.DefaultSimulation;
import com.simulation.earth.simulationProcessing.ISimulation;
import com.simulation.earth.spaceObjects.PerspectiveCameraWithName;
import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerWindowSimulation {


    @FXML
    public SubScene drawScene;
    @FXML
    public Accordion menu;
    @FXML
    public Slider sliderDeltaTimeFactor;
    @FXML
    public Label labelDeltaTime;
    @FXML
    public CheckBox checkOverScale;
    @FXML
    public Label labelTimeSimulation;
    @FXML
    public TableColumn<Camera,String> columnCameras;
    @FXML
    public TableView tableCameras;
    @FXML
    public Label lableTimeInMin;
    @FXML
    public Label labelTimeInHours;
    @FXML
    public Label labelTImeInDay;
    @FXML
    public CheckBox checkExtraTImeDisplay;
    @FXML
    public ImageView fontImage;
    @FXML
    public Button btTest;

    private LineToManager lineToManager = new LineToManager();
    {
        lineToManager.setColor(Color.RED);
    }

    private Group group = new Group();
    private Camera freeCamera = new PerspectiveCameraWithName(true,"free Camera");

    private FactorySpace factorySpace = new NearEarthFactory();
    private ISimulation simulation  = new DefaultSimulation();
    private MouseControl mouseControl = new MouseControl();
    private Stage stage = Main.getStage();

    private Space space;
    private ParametersSpace parametersSpace;

    @FXML
    private void initialize (){
        space = factorySpace.getSpace();
        parametersSpace = factorySpace.getParametersSpace();
        group.getChildren().add(space.getSpaceGroup());
        prepareDrawScene();
        initMouseControl();
        monitorParametrsSimulation();
        preparePoorLighting();
        prepareTableCameras();

        lineToManager.addCoordinat(0,0,0);
        lineToManager.addCoordinat(10000,0,0);
        lineToManager.addCoordinat(0,0,0);
        lineToManager.addCoordinat(0,10000,0);
        lineToManager.addCoordinat(0,0,0);
        lineToManager.addCoordinat(0,0,10000);
        group.getChildren().add(lineToManager.getTrajectory());
    }

    private void monitorParametrsSimulation () {
        AnimationTimer threadMonitorSimulation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                labelTimeSimulation.setText(simulation.getTimeSimulation()+"");
                simulation.setDeltaTime((float) (0.01*sliderDeltaTimeFactor.getValue()));
                labelDeltaTime.setText(""+simulation.getDeltaTime());
                if (checkExtraTImeDisplay.isSelected()) {
                    lableTimeInMin.setText("MIN : " + (int) simulation.getTimeSimulation()/60 );
                    labelTimeInHours.setText("HOURS : " + (int) simulation.getTimeSimulation()/3600);
                    labelTImeInDay.setText("DAY : " + (int) simulation.getTimeSimulation()/86400);
                }
            }
        };
        threadMonitorSimulation.start();
    }

    private void prepareDrawScene (){
        initSizeScene();
        System.out.println(drawScene.isDepthBuffer());
        freeCamera.setNearClip(parametersSpace.getNearClip());
        freeCamera.setFarClip(parametersSpace.getFarClip());
        drawScene.setCamera(freeCamera);
        freeCamera.setTranslateZ(-25000);
        drawScene.setRoot(group);
    }

    private void initSizeScene (){
        drawScene.setWidth(ScreenResolution.WIDTH());
        drawScene.setHeight(ScreenResolution.HIGHT());
        fontImage.setFitHeight(ScreenResolution.HIGHT());
        fontImage.setFitWidth(ScreenResolution.WIDTH());
    }

    private void preparePoorLighting () {
        AmbientLight light = new AmbientLight();
        light.setColor(Color.valueOf("101010"));
        group.getChildren().add(light);
    }

    private void prepareTableCameras () {
        ObservableList<Camera> objects = FXCollections.observableArrayList();
        objects.addAll(space.getCamerasFromSpaseObjects());
        objects.add(freeCamera);
        columnCameras.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCameras.setItems(objects);
    }

    private void initMouseControl () {
        Group freeCameraGroup = new Group();
        freeCameraGroup.getChildren().add(freeCamera);
        mouseControl.initMouseControl(freeCameraGroup,drawScene);
        mouseControl.initScrollControl(freeCamera,stage,50);
    }

    public void onStopSimulation(ActionEvent actionEvent) {
        simulation.stopSimulation();
    }

    public void onContinueSimulation(ActionEvent actionEvent) {
        simulation.enableSimulation(space);
    }

    public void onResetSimulation(ActionEvent actionEvent) {    }

    public void onOverScale(ActionEvent actionEvent) {
        if (checkOverScale.isSelected()) {
            for (SpaceObject spaceObject : space.getSpaceObjects()) {
                if (spaceObject instanceof PlanetOrStart) {
                    ((PlanetOrStart) spaceObject).getSphere().setRadius(((PlanetOrStart) spaceObject).getSphere().getRadius() * 25);
                    freeCamera.setTranslateZ(-3_000_000);
                }
            }
        }else {
            for (SpaceObject spaceObject : space.getSpaceObjects()) {
                if (spaceObject instanceof PlanetOrStart) {
                    ((PlanetOrStart) spaceObject).getSphere().setRadius(((PlanetOrStart) spaceObject).getSphere().getRadius() /25);
                    freeCamera.setTranslateZ(-20000);
                }
            }
        }
    }

    public void onSelectCamera(MouseEvent mouseEvent) {
        drawScene.setCamera((Camera) tableCameras.getSelectionModel().getSelectedItem());
    }

    public void onExtraTime(ActionEvent actionEvent) {
        if (checkExtraTImeDisplay.isSelected()){
            lableTimeInMin.setVisible(true);
            labelTimeInHours.setVisible(true);
            labelTImeInDay.setVisible(true);
        } else {
            lableTimeInMin.setVisible(false);
            labelTimeInHours.setVisible(false);
            labelTImeInDay.setVisible(false);
        }
    }

    public void onTest(ActionEvent actionEvent) {
        lineToManager.changeScaleTrajectory(5);
    }
}