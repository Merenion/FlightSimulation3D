package com.simulation.earth.spaceObjects;

import com.simulation.earth.MathModels.*;
import com.simulation.earth.PerspectiveCameraWithName;
import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

/**
 * реализация космического обьекта- простого спутника
 */
public class SatelliteDefault extends Satellite {

    /** математическая модель полета спутника*/
    GeodeticLocation mathModel = new MathModelSatelite(getParametrsOrbit());

    /**
     * единственный конструктор - без параметров орбиты создание обьекта невозможно
     * @param parametrsOrbit параметры орбиты спутника
     */
    public SatelliteDefault(OrbitParameters parametrsOrbit) {
        super(parametrsOrbit);
    }

    /**
     * установка объекта на координаты по времени
     * @param time время от которого зависит расположение обьекта
     */
    @Override
    public void prepareStartCootdints(double time) {
        Point3D coordinats;
        if (mathModel != null) {
            coordinats = mathModel.getGeodeticCoordinats(time);
            refreshProjectionOnPlanet();
            refreshDrawingMovementPath();
        } else {
            coordinats = (new MathModelSatelite(new StorageOrbitParameters())).getGeodeticCoordinats(time);
        }
        orientation.setX(coordinats.getX());
        orientation.setY(coordinats.getY());
        orientation.setZ(coordinats.getZ());
        rotateZ.setAngle(90);
    }

    /**
     * перемещение спутника на стартовые координаты по дефолту
     */
    @Override
    public void prepareStartCootdints() {
        prepareStartCootdints(0);
    }

    /**
     * метод ля симуляции полета - перемещение спутника по времени.
     * более подробно описанно в родительском абстрактном классе
     * @param time время симуляции
     */
    @Override
    public void movement(double time) {
        Point3D coordinats = mathModel.getGeodeticCoordinats(time);
        orientation.setX(coordinats.getX());
        orientation.setY(coordinats.getY());
        orientation.setZ(coordinats.getZ());
//        if ((coordinats.getX()>1 || coordinats.getX()<1)  && (coordinats.getY()>1 || coordinats.getY()<1) && (coordinats.getZ()>1 || coordinats.getZ()<1)) {
//            System.out.println("__________");
//            System.out.println(coordinats.getY());
//            System.out.println(coordinats.getZ());
//            System.out.println(coordinats.getY() / coordinats.getZ());
//            System.out.println(coordinats.getZ() / coordinats.getX());
//            System.out.println(coordinats.getY() / coordinats.getX());
//            System.out.println("---");
//            System.out.println(Math.atan(coordinats.getZ() / coordinats.getX()) *  180/Math.PI);
//            System.out.println(Math.atan(coordinats.getY() / coordinats.getX()) *  180/Math.PI);
//            rotateX.setAngle(Math.atan(coordinats.getY()/coordinats.getZ())*180/Math.PI);

        rotationOnEarth();
    }

    /**
     * осущесвление поворота спутника (камерой в центр)
     */
    private void rotationOnEarth (){
        if (orientation.getX()>0 && orientation.getY()>0 && orientation.getZ()>0){
            rotateZ.setAngle(Math.atan(Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI +90);
            rotateY.setAngle(Math.atan(-Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()>0 && orientation.getY()>0 && orientation.getZ()<0){
            rotateZ.setAngle(Math.atan(Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI+90);
            rotateY.setAngle(Math.atan(Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()>0 && orientation.getY()<0 && orientation.getZ()>0){
            rotateZ.setAngle(Math.atan(-Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI+90);
            rotateY.setAngle(Math.atan(-Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()>0 && orientation.getY()<0 && orientation.getZ()<0){
            rotateZ.setAngle(Math.atan(-Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI+90);
            rotateY.setAngle(Math.atan(Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()<0 && orientation.getY()>0 && orientation.getZ()>0){
            rotateZ.setAngle(Math.atan(-Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI-180+90);
            rotateY.setAngle(Math.atan(Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()<0 && orientation.getY()>0 && orientation.getZ()<0){
            rotateZ.setAngle(Math.atan(-Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI-180+90);
            rotateY.setAngle(Math.atan(-Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()<0 && orientation.getY()<0 && orientation.getZ()>0){
            rotateZ.setAngle(Math.atan(Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI+180+90);
            rotateY.setAngle(Math.atan(Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
        if (orientation.getX()<0 && orientation.getY()<0 && orientation.getZ()<0){
            rotateZ.setAngle(Math.atan(Math.abs(orientation.getY()/orientation.getX()))*180/Math.PI-180+90);
            rotateY.setAngle(Math.atan(-Math.abs(orientation.getZ()/orientation.getX()))*180/Math.PI);
        }
    }

    /**
     * Создание модели обьъекта
     * @return составляющие модели
     */
    @Override
    protected List<Node> modelDescription() {
        Group satelite = new Group();
        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(0.01);
        cylinder.setRadius(0.005);
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setRadius(0.0025);
        cylinder2.setHeight(0.01);
        cylinder2.setTranslateY(0.006);
        Cylinder cylinder3 = new Cylinder();
        cylinder3.setHeight(0.057);
        cylinder3.setRadius(0.0005);
        cylinder3.setRotate(90);
        Box boxLeft = new Box();
        boxLeft.setHeight(0.0003);
        boxLeft.setDepth(0.008);
        boxLeft.setWidth(0.025);
        boxLeft.setTranslateX(-0.0185);
        Box boxRight = new Box();
        boxRight.setHeight(0.0003);
        boxRight.setDepth(0.008);
        boxRight.setWidth(0.0251);
        boxRight.setTranslateX(0.0185);

        prepareMaterialCorpus(cylinder);
        prepareMaterialSunBatars(boxLeft);
        prepareMaterialSunBatars(boxRight);

        satelite.getChildren().addAll(cylinder,cylinder2,cylinder3,boxLeft,boxRight);

        List<Node> nodes = new ArrayList<>();
        nodes.add(satelite);
        return nodes;
    }

    /**
     * подготовка камер для спутника
     * @return установленные камеры
     */
    @Override
    protected List<Camera> prepareCameras() {
        List<Camera> cameras = new ArrayList<>();
        cameras.add(initCameraForSurveySatelite());
        cameras.add(initCameraForSurveyEarth());
        return cameras;
    }

    /**
     * наложение текстур корпуса
     * @param node любая составляющая модели
     */
    private void prepareMaterialCorpus (Shape3D node) {
        PhongMaterial phongMaterialBatare = new PhongMaterial();
        phongMaterialBatare.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/corpusSateliteTexture.jpg")));
        node.setMaterial(phongMaterialBatare);
    }

    /**
     * наложение текстур солнечной батареи
     * @param node любая составляющая модели
     */
    private void prepareMaterialSunBatars (Shape3D node) {
        PhongMaterial phongMaterialCorpus = new PhongMaterial();
        phongMaterialCorpus.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/sunBatareTexture.jpg")));
        phongMaterialCorpus.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/sunBattariesMapReflection.jpg")));
        node.setMaterial(phongMaterialCorpus);
    }

    /**
     * создание камеры которая должна смотреть в сторону земли при
     * перемещении спутника по орбите
     * @return камера направленная на землю
     */
    private Camera initCameraForSurveyEarth(){
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey EarthNE");
        camera.setTranslateY(0.0011);
        camera.setNearClip(1);
        camera.setFarClip(2000_000_000);
        camera.getTransforms().add(new Rotate(-90,Rotate.X_AXIS));
        return camera;
    }

    /**
     * создание камеры котиорая смотрит на спутник со стороны
     * @return камера направленная на спутник
     */
    private Camera initCameraForSurveySatelite() {
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey Satelite");

        camera.setTranslateX(0);
        camera.setTranslateY(-0.06);
        camera.setTranslateZ(-0.08);

        Rotate rotateX = new Rotate(-40,Rotate.X_AXIS);
        Rotate rotateY = new Rotate(-20,Rotate.Z_AXIS);
        camera.getTransforms().add(rotateX);
        camera.getTransforms().add(rotateY);
        ImageView imageView = new ImageView();

        camera.setNearClip(0.01);
        camera.setFarClip(400_000_000);
        return camera;
    }
}