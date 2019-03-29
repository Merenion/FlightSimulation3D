package com.simulation.earth;

import com.simulation.earth.drawServis.Line3D;
import com.simulation.earth.drawServis.LineTo3D;
import com.simulation.earth.manageSatellite.ManageSatellite;
import com.simulation.earth.manageSatellite.ManagerSatelliteEarth;
import com.simulation.earth.manageSpace.FactorySpace;
import com.simulation.earth.manageSpace.NearEarthFactory;
import com.simulation.earth.manageSpace.ParametersSpace;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.objectControl.MouseControl;
import com.simulation.earth.objectControl.SmartGroup;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import org.fxyz3d.geometry.Point3D;

/**
 * Контроллер GUI
 */
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
    @FXML
    public CheckBox checkSystCoordinat;
    @FXML
    public CheckBox checkOverLightLevel;
    public CheckBox checkEclipticPlane;
    public CheckBox checkEquatorialPlane;
    public CheckBox checkRotationAxisOfTheEarth;

    /**основная группа в которой хранится все объекты (модели, орбиты сис.коорд.) для отображения*/
    private Group group = new Group();
    /**Свободная камера*/
    private Camera freeCamera = new PerspectiveCameraWithName(true,"free Camera");

    /**фабрика пространства*/
    private FactorySpace factorySpace = new NearEarthFactory();
    /**сервис симуляции*/
    private ISimulation simulation  = new DefaultSimulation();
    /**управление мышкой*/
    private MouseControl mouseControl = new MouseControl();
    /**получаем как статический (для простаты)*/
    private Stage stage = Main.getStage();

    /**Пространство для содержания моделей космических объектов (управление ими - перемещение и прочее)*/
    private Space space = factorySpace.getSpace();
    /**параметры пространства*/
    private ParametersSpace parametersSpace  = factorySpace.getParametersSpace();

    /**сервис создиния и управления спутниками*/
    private ManageSatellite manageSatellite = ManagerSatelliteEarth.getManager();

    /**общий источник света*/
    AmbientLight light;
    /**
     * инициализация GUI
     */
    @FXML
    private void initialize (){
        group.getChildren().add(space);
        initMouseControl();

        prepareDrawScene();
        preparePoorLighting();
        prepareTableCameras();
        prepareTableSatellites();
        prepareBackground();
        prepareLineSystCoordinat();

        monitorParametrsSimulation();

//        Box box = new Box();
//        box.setDepth(20000);
//        box.setHeight(10);
//        box.setWidth(20000);
//
//
//        PhongMaterial phongMaterial = new PhongMaterial();
//        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/ecliptic plane.png")));
//        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/texturs/ecliptic plane.png")));
//        box.setMaterial(phongMaterial);
//        group.getChildren().add(box);


//        Box box = new Box();
//        box.setWidth(600);
//        box.setHeight(300);
//        box.setDepth(300);
//        box.getTransforms().add(new Translate(-9000,-9000,-9000));
////        box.getTransforms().add(new Rotate(45,Rotate.Z_AXIS));
//
//        Line3D line = new Line3D(new Point3D(0,0,0),new Point3D(-9000,-9000,-9000));
//
//        group.getChildren().add(line);
//        group.getChildren().add(box);
    }

    /**
     * инициализация отображения основной системы координат
     * Создает группу в которую помещает прямые (оси) системы координат
     * группе задается имя "sysCoordinat", для того чтобы ее можно было
     * по надобности найти и удалить
     */
    private void prepareLineSystCoordinat(){
        SmartGroup group = new SmartGroup();
        group.setName("sysCoordinat");
        LineTo3D x = new LineTo3D();
        LineTo3D y = new LineTo3D();
        LineTo3D z = new LineTo3D();
        x.setColor(Color.RED);
        x.setWidth(30);
        x.addCoordinats(0,0,0);
        x.addCoordinats(12000,0,0);
        y.setColor(Color.BLUE);
        y.setWidth(30);
        y.addCoordinats(0,0,0);
        y.addCoordinats(0,10000,0);
        z.setColor(Color.GREEN);
        z.setWidth(30);
        z.addCoordinats(0,0,0);
        z.addCoordinats(0,0,10000);
        group.getChildren().addAll(x,y,z);
        this.group.getChildren().add(group);
    }

    /**
     * Метод создает поток, который следит за изменением различных
     * парамметров заданных на GUI
     */
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

    /**
     * слушатель включения отображения дополнительных параметров времени
     */
    private void monitorOnExtraTime () {
        if (checkExtraTImeDisplay.isSelected()) {
            lableTimeInMin.setText("MIN : " + (int) simulation.getTimeSimulation()/60 );
            labelTimeInHours.setText("HOURS : " + (int) simulation.getTimeSimulation()/3600);
            labelTImeInDay.setText("DAY : " + (int) simulation.getTimeSimulation()/86400);
        }
    }


    /**для метода #monitorTrajectoryAndProjection*/
    private boolean lastSelectedCheckProjectionPathOnEarth =false;
    /**для метода #monitorTrajectoryAndProjection*/
    private boolean lastSelectedCheckSatelliteTrajectory =false;
    /**
     * Слушатель включения прорисовки орбиты и пути подспутниковой точки
     */
    private void monitorTrajectoryAndProjection() {
        SpaceObject earth = space.getSpaceObject("EarthNE");
        if (checkProjectionPathOnEarth.isSelected() && !lastSelectedCheckProjectionPathOnEarth) {
            manageSatellite.enableDrawingProjectionSatellites((PlanetOrStart) earth);
            lastSelectedCheckProjectionPathOnEarth = true;
        }
        if (!checkProjectionPathOnEarth.isSelected() && lastSelectedCheckProjectionPathOnEarth){
            manageSatellite.stopDrawingProjectionSatellites();
            manageSatellite.refreshProjectionOnPlanet();
            lastSelectedCheckProjectionPathOnEarth = false;
        }
        if (checkSatelliteTrajectory.isSelected() && !lastSelectedCheckSatelliteTrajectory) {
            manageSatellite.enableDrawingOrbitSatellites(group);
            lastSelectedCheckSatelliteTrajectory = true;
        }
        if (!checkSatelliteTrajectory.isSelected() && lastSelectedCheckSatelliteTrajectory){
            manageSatellite.stopDrawingOrbitSatellites();
            manageSatellite.refreshDrawingOrbit();
            lastSelectedCheckSatelliteTrajectory = false;
        }
    }

    /**мониторинг изменения ползунка устанавливающего deltaTIme симуляции*/
    private void monitorDeltaTime () {
        simulation.setDeltaTime((float) (0.01*sliderDeltaTimeFactor.getValue()));
        labelDeltaTime.setText(""+reduceNumber(simulation.getDeltaTime(),3));
    }

    /**
     * мониторинг ползунка масштаба спутников
     */
    private void monitorSateliteScale () {
        labelSateliteScale.setText(reduceNumber(sliderSatelliteScale.getValue(),3)+"");
        manageSatellite.changeScaleSatellites((float) sliderSatelliteScale.getValue());
    }

    /**
     * подговка фона пространства
     */
    private void prepareBackground (){
        Background background = new Stars();
        group.getChildren().add(background.getGroup());
    }

    /**
     * подготовка сцены:
     * свободной камеры,
     * ее глубины и координат
     * установка в сцену основную группу
     */
    private void prepareDrawScene (){
        initSizeScene();
        freeCamera.setNearClip(parametersSpace.getNearClip());
        freeCamera.setFarClip(parametersSpace.getFarClip());
        drawScene.setCamera(freeCamera);
        freeCamera.setTranslateZ(-25000);
        drawScene.setRoot(group);
    }

    /**
     * установка размеров окна GUI
     */
    private void initSizeScene (){
        drawScene.setWidth(ScreenResolution.WIDTH());
        drawScene.setHeight(ScreenResolution.HIGHT());
    }

    /**
     * подготовка общего источника света для пространства
     */
    private void preparePoorLighting () {
        light = new AmbientLight();
        light.setColor(Color.valueOf("101010"));
        group.getChildren().add(light);
    }

    //добавить сканирование

    /**
     * подготовка таблицы доступных камер
     */
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

    /**
     * подготовка таблици существующих спутников
     */
    private void prepareTableSatellites () {
        columnSatellites.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableSatellite.setItems(manageSatellite.getAllSatelites());

    }

    /**
     * инициализация управления свободной камерой с помощью мышки
     */
    private void initMouseControl () {
        Group freeCameraGroup = new Group();
        freeCameraGroup.getChildren().add(freeCamera);
        mouseControl.initMouseControl(freeCameraGroup,drawScene);
        mouseControl.initScrollControl(freeCamera,stage,50);
    }

    /**
     * остановить симуляциию
     * @param actionEvent нажатие по кнопке
     */
    public void onStopSimulation(ActionEvent actionEvent) {
        simulation.stopSimulation();
    }

    /**
     * включить симуляцию
     * @param actionEvent нажатие по кнопке
     */
    public void onContinueSimulation(ActionEvent actionEvent) {
        simulation.enableSimulation(space);
    }

    /**
     * сбросить симуляцию
     * @param actionEvent нажатие по кнопке
     */
    public void onResetSimulation(ActionEvent actionEvent) {
        simulation.resetSimulation(space);
    }

    /**
     * функция сильного увеличения обьектов пространства
     * @param actionEvent включение функции
     */
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

    /**
     * действие при нажатии на камеру из таблици
     * @param mouseEvent параметр нажатия
     */
    public void onSelectCamera(MouseEvent mouseEvent) {
        if (tableCameras.getSelectionModel().getSelectedItem()!= null)
        drawScene.setCamera(tableCameras.getSelectionModel().getSelectedItem());
    }

    /**
     * действие при включении дополнительного времени
     * (делает видимым label)
     * @param actionEvent
     */
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

    /**
     * тестовая кнопка на время разработики
     * @param actionEvent
     */
    public void onTest(ActionEvent actionEvent) {
    }

    /**
     * округление
     * @param number чмсло которое нужно округлить
     * @param coll необходимое число цифр после запятой
     * @return
     */
    private double reduceNumber (double number, int coll) {
        return Math.floor(number * Math.pow(10,coll))/Math.pow(10,coll);
    }

    /**
     * действие при нажатии на спутник из таблици спутников.
     * открывается окно редактирования
     * @param mouseEvent переменая нажатия
     */
    public void onSelectSatellite(MouseEvent mouseEvent) {
        if (tableSatellite.getSelectionModel().getSelectedItem()!=null)
        ControllerParametersSatellite.openWindowModalityEditor(tableSatellite.getScene().getWindow()
                , tableSatellite.getSelectionModel().getSelectedItem());
    }

    /**
     * действие при нажатии на кнопку создания спутника.
     * Открывает окно параметров создания(GUI).
     * Передавая туда оcновное окно GUI
     * для создания модального окна и объект пространства.
     * @param actionEvent
     */
    public void onAddSatellite(ActionEvent actionEvent) {
        ControllerParametersSatellite.openWindowModalityCreator(tableSatellite.getScene().getWindow(),space);
    }

    /**
     * активирует отображение системы координат при нажатии на галку
     * Удаление происходит путем удаления группы в которой находятся прямые (оси)
     * системы гоординат. Группа ищется по ее названию
     * @param actionEvent
     */
    public void onSystCoordinat(ActionEvent actionEvent) {
        if (checkSystCoordinat.isSelected()) {
            prepareLineSystCoordinat();
        }else {
            for (Node node :group.getChildren()) {
                if (node instanceof SmartGroup) {
                    if (((SmartGroup) node).getName().equals("sysCoordinat")){
                        group.getChildren().remove(node);
                        return;
                    }
                }
            }
        }
    }

    /**
     * активирует общее очвещение космических объектов при нажатии на галку
     * @param actionEvent
     */
    public void onOverLightLevel(ActionEvent actionEvent) {
        if (checkOverLightLevel.isSelected())
            light.setColor(Color.valueOf("707070"));
        else
            light.setColor(Color.valueOf("101010"));

    }

    /**плоскость эклиптики. используется в методе #onEclipticPlane(ActionEvent actionEvent)*/
    private Box planeEcliptic = createPlaneBox();
    /**
     * активирует отображение плоскости эклиптики
     * @param actionEvent
     */
    public void onEclipticPlane(ActionEvent actionEvent) {
        if (checkEclipticPlane.isSelected()){
            planeEcliptic = createPlaneBox();
            planeEcliptic.getTransforms().add(new Rotate(23.989,Rotate.X_AXIS));
            materialPlane(planeEcliptic,"/texturs/ecliptic plane.png");
            group.getChildren().add(planeEcliptic);
        }else {
            if (group.getChildren().contains(planeEcliptic))
                group.getChildren().remove(planeEcliptic);
        }
    }

    /**плоскость экватора. используется в методе #onEquatorialPlane(ActionEvent actionEvent)*/
    private Box planeEquatorial = createPlaneBox();
    /**
     * активирует отображение плоскости экватора
     * @param actionEvent
     */
    public void onEquatorialPlane(ActionEvent actionEvent) {
        if (checkEquatorialPlane.isSelected()){
            planeEquatorial = createPlaneBox();
            materialPlane(planeEquatorial,"/texturs/equatorial plane.png");
            group.getChildren().add(planeEquatorial);
        }else {
            if (group.getChildren().contains(planeEquatorial))
                group.getChildren().remove(planeEquatorial);
        }
    }

    /**Ось вращения земли. используется в методе #onRotationAxisOfTheEarth(ActionEvent actionEvent)*/
    private Line3D lineRotationAxisOfTheEarth = new Line3D(new Point3D(0,-13000,0),new Point3D(0,13000,0),40,Color.CYAN);
    /**
     * активирует отображение оси вращения земли
     * @param actionEvent
     */
    public void onRotationAxisOfTheEarth(ActionEvent actionEvent) {
        if (checkRotationAxisOfTheEarth.isSelected())
            group.getChildren().add(lineRotationAxisOfTheEarth);
        else {
            if (group.getChildren().contains(lineRotationAxisOfTheEarth))
                group.getChildren().remove(lineRotationAxisOfTheEarth);
        }
    }

    /**
     * добавляет указаную текстуру на плоскость (подсвечивается сама)
     * @param plane плоскость
     * @param pathTexture путь к текстуре
     */
    private void materialPlane (Shape3D plane, String pathTexture){
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream(pathTexture)));
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream(pathTexture)));
        plane.setMaterial(phongMaterial);
    }

    /**
     * создает плоскость из прямого параллепипеда
     * @return плоскость
     */
    private Box createPlaneBox() {
        Box box = new Box();
        box.setDepth(20000);
        box.setHeight(10);
        box.setWidth(20000);
        return box;
    }
}