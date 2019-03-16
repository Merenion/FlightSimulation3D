package com.simulation.earth.spaceObjects;

import com.simulation.earth.MathModels.*;
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

public class SatelliteDefault extends Satellite {


    public SatelliteDefault(OrbitParameters parametrsOrbit) {
        super(parametrsOrbit);
    }

    GeodeticLocation mathModel = new MathModelSatelite(new StorageOrbitParameters());
    GeodeticLocation mathMode2 = new SatellitePathProjection(new StorageOrbitParameters());

    @Override
    public void prepareStartCootdints(double time) {
        Point3D coordinats = (new MathModelSatelite(new StorageOrbitParameters())).getGeodeticCoordinats(time);
        orientation.setX(coordinats.getX());
        orientation.setY(coordinats.getY());
        orientation.setZ(coordinats.getZ());
        rotateZ.setAngle(90);
    }

    @Override
    public void prepareStartCootdints() {
        prepareStartCootdints(0);
    }

    @Override
    public void movement(double time) {
        Point3D coordinats = mathModel.getGeodeticCoordinats(time);
        Point3D coordinatsOnCircle = mathMode2.getGeodeticCoordinats(time);
        orientation.setX(coordinats.getX());
        orientation.setY(coordinats.getY());
        orientation.setZ(coordinats.getZ());
//        if (isDrawPath()) {
//            managerDrawingOfTrajectory.addLineInPathIfNeeded((float) orientation.getX(), (float) orientation.getY(), (float) orientation.getZ());
//        }
//        if (isDrawPath()) {
//            servisDrawTrajectory2.addLineInPathIfNeeded((float) coordinatsOnCircle.getX(), (float) coordinatsOnCircle.getY(), (float) coordinatsOnCircle.getZ());
//        }
    }

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

    @Override
    protected List<Camera> prepareCameras() {
        List<Camera> cameras = new ArrayList<>();
        cameras.add(initCameraForSurveySatelite());
        cameras.add(initCameraForSurveyEarth());
        return cameras;
    }

    private void prepareMaterialCorpus (Shape3D node) {
        PhongMaterial phongMaterialBatare = new PhongMaterial();
        phongMaterialBatare.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/corpusSateliteTexture.jpg")));
        node.setMaterial(phongMaterialBatare);
    }

    private void prepareMaterialSunBatars (Shape3D node) {
        PhongMaterial phongMaterialCorpus = new PhongMaterial();
        phongMaterialCorpus.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/sunBatareTexture.jpg")));
        phongMaterialCorpus.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/sunBattariesMapReflection.jpg")));
        node.setMaterial(phongMaterialCorpus);
    }

    private Camera initCameraForSurveyEarth(){
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey EarthNE");
        camera.setTranslateY(0.0011);
        camera.setNearClip(1);
        camera.setFarClip(40_000_000);
        camera.getTransforms().add(new Rotate(-90,Rotate.X_AXIS));
        return camera;
    }

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
        camera.setFarClip(40_000_000);
        return camera;
    }
}