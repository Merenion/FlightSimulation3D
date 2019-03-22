package com.simulation.earth;

import com.simulation.earth.drawServis.LineTo3D;
import com.simulation.earth.manageSatellite.ManageSatellite;
import com.simulation.earth.manageSatellite.ManagerSatelliteEarth;
import com.simulation.earth.manageSpace.FactorySpace;
import com.simulation.earth.manageSpace.NearEarthFactory;
import com.simulation.earth.manageSpace.ParametersSpace;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.objectControl.MouseControl;
import com.simulation.earth.simulationProcessing.DefaultSimulation;
import com.simulation.earth.simulationProcessing.ISimulation;
import com.simulation.earth.spaceObjects.*;
import com.simulation.earth.starBackground.Background;
import com.simulation.earth.starBackground.Stars;
import javafx.animation.AnimationTimer;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView<Camera> tableCameras;
    @FXML
    public Label lableTimeInMin;
    @FXML
    public Label labelTimeInHours;
    @FXML
    public Label labelTImeInDay;
    @FXML
    public CheckBox checkExtraTImeDisplay;
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
    @FXML
    public TableColumn<Satellite,String> columnSatellites;
    @FXML
    public TableView<Satellite> tableSatellite;

    private Group group = new Group();
    private Camera freeCamera = new PerspectiveCameraWithName(true,"free Camera");

    private FactorySpace factorySpace = new NearEarthFactory();
    private ISimulation simulation  = new DefaultSimulation();
    private MouseControl mouseControl = new MouseControl();
    private Stage stage = Main.getStage();

    private Space space = factorySpace.getSpace();
    private ParametersSpace parametersSpace  = factorySpace.getParametersSpace();

    ManageSatellite manageSatellite = ManagerSatelliteEarth.getManager();


    @FXML
    private void initialize (){
        group.getChildren().add(space.getSpaceGroup());
        initMouseControl();

        prepareDrawScene();
        preparePoorLighting();
        prepareTableCameras();
        prepareTableSatellites();
        prepareBackground();
        prepareLineSystCoordinat();

        monitorParametrsSimulation();
    }

    private void prepareLineSystCoordinat(){
        LineTo3D x = new LineTo3D();
        LineTo3D y = new LineTo3D();
        LineTo3D z = new LineTo3D();
        x.setColor(Color.RED);
        x.setWidth(30);
        x.addCoordinats(0,0,0);
        x.addCoordinats(10000,0,0);
        y.setColor(Color.BLUE);
        y.setWidth(30);
        y.addCoordinats(0,0,0);
        y.addCoordinats(0,10000,0);
        z.setColor(Color.GREEN);
        z.setWidth(30);
        z.addCoordinats(0,0,0);
        z.addCoordinats(0,0,10000);
        group.getChildren().addAll(x,y,z);
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
            manageSatellite.enableDrawingProjectionSatellites((PlanetOrStart) earth);
            lastSelectedCheckProjectionPathOnEarth = true;
        }
        if (!checkProjectionPathOnEarth.isSelected() && lastSelectedCheckProjectionPathOnEarth){
            manageSatellite.stopDrawingProjectionSatellites();
            lastSelectedCheckProjectionPathOnEarth = false;
        }
        if (checkSatelliteTrajectory.isSelected() && !lastSelectedCheckSatelliteTrajectory) {
            manageSatellite.enableDrawingOrbitSatellites(group);
            lastSelectedCheckSatelliteTrajectory = true;
        }
        if (!checkSatelliteTrajectory.isSelected() && lastSelectedCheckSatelliteTrajectory){
            manageSatellite.stopDrawingOrbitSatellites();
            lastSelectedCheckSatelliteTrajectory = false;
        }
    }

    private void monitorDeltaTime () {
        simulation.setDeltaTime((float) (0.01*sliderDeltaTimeFactor.getValue()));
        labelDeltaTime.setText(""+reduceNumber(simulation.getDeltaTime(),3));
    }

    private void monitorSateliteScale () {
        labelSateliteScale.setText(reduceNumber(sliderSatelliteScale.getValue(),3)+"");
        manageSatellite.changeScaleSatellites((float) sliderSatelliteScale.getValue());
    }

    private void prepareBackground (){
        Background background = new Stars();
        group.getChildren().add(background.getGroup());
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
        light.setColor(Color.valueOf("101010"));
        group.getChildren().add(light);
    }

    //добавить сканирование
    private void prepareTableCameras () {
        ObservableList<Camera> cameras = space.getCamerasFromSpaseObjects();
        cameras.addListener((ListChangeListener<Camera>) c -> {
            c.next();
            if (!c.getList().contains(freeCamera)){
                cameras.add(freeCamera);
            }
        });
        cameras.add(freeCamera);
        columnCameras.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tableCameras.setItems(cameras);
    }

    private void prepareTableSatellites () {
        columnSatellites.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableSatellite.setItems(manageSatellite.getAllSatelites());

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
        if (tableCameras.getSelectionModel().getSelectedItem()!= null)
        drawScene.setCamera(tableCameras.getSelectionModel().getSelectedItem());
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

    public void onSelectSatellite(MouseEvent mouseEvent) {
        if (tableSatellite.getSelectionModel().getSelectedItem()!=null)
        ControllerParametersSatellite.openWindowModalityEditor(tableSatellite.getScene().getWindow()
                , tableSatellite.getSelectionModel().getSelectedItem());
    }

    public void onAddSatellite(ActionEvent actionEvent) {
        ControllerParametersSatellite.openWindowModalityCreator(tableSatellite.getScene().getWindow(),space);
    }
}