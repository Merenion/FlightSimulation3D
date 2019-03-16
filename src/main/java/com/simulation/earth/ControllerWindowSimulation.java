package com.simulation.earth;

import com.simulation.earth.drawServis.LineToManager;
import com.simulation.earth.manageSpace.FactorySpace;
import com.simulation.earth.manageSpace.NearEarthFactory;
import com.simulation.earth.manageSpace.ParametersSpace;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.objectControl.MouseControl;
import com.simulation.earth.simulationProcessing.DefaultSimulation;
import com.simulation.earth.simulationProcessing.ISimulation;
import com.simulation.earth.spaceObjects.PerspectiveCameraWithName;
import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SpaceObject;
import com.simulation.earth.starBackground.Background;
import com.simulation.earth.starBackground.Stars;
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
    @FXML
    public Slider sliderSatelliteScale;
    @FXML
    public Label labelSateliteScale;
    @FXML
    public CheckBox checkSatelliteTrajectory;
    @FXML
    public CheckBox checkProjectionPathOnEarth;

    private Group group = new Group();
    private Camera freeCamera = new PerspectiveCameraWithName(true,"free Camera");

    private FactorySpace factorySpace = new NearEarthFactory();
    private ISimulation simulation  = new DefaultSimulation();
    private MouseControl mouseControl = new MouseControl();
    private Stage stage = Main.getStage();

    private Space space;
    private ParametersSpace parametersSpace;

    private Satellite satellite;


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
        initLineSystCoordinat();
        Background background = new Stars();
        group.getChildren().add(background.getGroup());

        satellite = (Satellite) space.getSpaceObject("SatelliteDefault");
    }

    private void initLineSystCoordinat (){
        LineToManager lineToManager = new LineToManager();
        lineToManager.setColor(Color.RED);
        lineToManager.setWidth(30);
        lineToManager.addCoordinat(0,0,0);
        lineToManager.addCoordinat(10000,0,0);
        lineToManager.addCoordinat(0,0,0);
        lineToManager.setColor(Color.BLUE);
        lineToManager.addCoordinat(0,10000,0);
        lineToManager.addCoordinat(0,0,0);
        lineToManager.setColor(Color.GREEN);
        lineToManager.addCoordinat(0,0,10000);
        group.getChildren().add(lineToManager.getPath());
    }

    private void monitorParametrsSimulation () {
        AnimationTimer threadMonitorSimulation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                labelTimeSimulation.setText(reduceNumber(simulation.getTimeSimulation(),3)+"");
                monitorDeltaTime();
                monitorOnExtraTime();
                monitorTrajectoryAndProjection();
                monitorSateliteScale();
            }
        };
        threadMonitorSimulation.start();
    }

    private void monitorOnExtraTime () {
        if (checkExtraTImeDisplay.isSelected()) {
            lableTimeInMin.setText("MIN : " + (int) simulation.getTimeSimulation()/60 );
            labelTimeInHours.setText("HOURS : " + (int) simulation.getTimeSimulation()/3600);
            labelTImeInDay.setText("DAY : " + (int) simulation.getTimeSimulation()/86400);
        }
    }

    private boolean lastSelectedCheckProjectionPathOnEarth =false;
    private boolean lastSelectedCheckSatelliteTrajectory =false;
    private void monitorTrajectoryAndProjection() {
        SpaceObject earth = space.getSpaceObject("EarthNE");
        if (checkProjectionPathOnEarth.isSelected() && !lastSelectedCheckProjectionPathOnEarth) {
            satellite.enableDrawingProjectionOnPlanet((PlanetOrStart) earth);
            lastSelectedCheckProjectionPathOnEarth = true;
        }
        if (!checkProjectionPathOnEarth.isSelected() && lastSelectedCheckProjectionPathOnEarth){
            satellite.stopDrawingProjectionOnPlanet();
            lastSelectedCheckProjectionPathOnEarth = false;
        }
        if (checkSatelliteTrajectory.isSelected() && !lastSelectedCheckSatelliteTrajectory) {
            satellite.enableDrawingOrbit(group);
            lastSelectedCheckSatelliteTrajectory = true;
        }
        if (!checkSatelliteTrajectory.isSelected() && lastSelectedCheckSatelliteTrajectory){
            satellite.stopDrawingOrbit();
            lastSelectedCheckSatelliteTrajectory = false;
        }
    }

    private void monitorDeltaTime () {
        simulation.setDeltaTime((float) (0.01*sliderDeltaTimeFactor.getValue()));
        labelDeltaTime.setText(""+reduceNumber(simulation.getDeltaTime(),3));
    }

    private void monitorSateliteScale () {
        labelSateliteScale.setText(reduceNumber(sliderSatelliteScale.getValue(),3)+"");
        satellite.changeScaleModel((float) sliderSatelliteScale.getValue());
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
    }

    private void preparePoorLighting () {
        AmbientLight light = new AmbientLight();
        light.setColor(Color.valueOf("090909"));
        group.getChildren().add(light);
    }

    private void prepareTableCameras () {
        ObservableList<Camera> cameras = FXCollections.observableArrayList();
        cameras.addAll(space.getCamerasFromSpaseObjects());
        cameras.add(freeCamera);
        columnCameras.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCameras.setItems(cameras);
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

    public void onResetSimulation(ActionEvent actionEvent) {
        simulation.resetSimulation(space);
    }

    public void onOverScale(ActionEvent actionEvent) {
        if (checkOverScale.isSelected()) {
            for (SpaceObject spaceObject : space.getSpaceObjects()) {
                if (spaceObject instanceof PlanetOrStart) {
                    spaceObject.changeScaleModel(25);
                    freeCamera.setTranslateZ(-3_000_000);
                }
            }
        }else {
            for (SpaceObject spaceObject : space.getSpaceObjects()) {
                if (spaceObject instanceof PlanetOrStart) {
                    spaceObject.changeScaleModel(1);
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
    }

    private double reduceNumber (double number, int coll) {
        return Math.floor(number * Math.pow(10,coll))/Math.pow(10,coll);
    }
}