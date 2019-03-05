package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.ParametrsOrbit;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SatelliteDefault extends Satellite {


    public SatelliteDefault(ParametrsOrbit parametrsOrbit) {
        super(parametrsOrbit);
    }

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {
        orientation.setX(mathModel.getXga(0));
        orientation.setY(mathModel.getYga(0));
        orientation.setZ(mathModel.getZga(0));
        rotateZ.setAngle(90);
    }

    private double t =0;

    @Override
    public void movement(float deltaTime) {
        t+=deltaTime;
        orientation.setX(mathModel.getXga(t));
        orientation.setY(mathModel.getYga(t));
        orientation.setZ(mathModel.getZga(t));
        if (isDrawPath()) {
            servisDrawTrajectory.addLineInPathIfNeeded((float) orientation.getX(), (float) orientation.getY(), (float) orientation.getZ());
        }
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
        LineTo lineTo = new LineTo();
    }

    private void prepareMaterialSunBatars (Shape3D node) {
        PhongMaterial phongMaterialCorpus = new PhongMaterial();
        phongMaterialCorpus.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/sunBatareTexture.jpg")));
        phongMaterialCorpus.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/sunBattariesMapReflection.jpg")));
        node.setMaterial(phongMaterialCorpus);
    }

    private Camera initCameraForSurveyEarth(){
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey EarthNE");
        camera.setTranslateX(0);
        camera.setTranslateY(0.0011);
        camera.setTranslateZ(0);
        camera.setNearClip(1);
        camera.setFarClip(400000);
        return camera;
    }

    private Camera initCameraForSurveySatelite() {
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey Satelite");

        camera.setTranslateX(0);
        camera.setTranslateY(0.06);
        camera.setTranslateZ(-0.09);

        Rotate rotateX = new Rotate(30,Rotate.X_AXIS);
        Rotate rotateY = new Rotate(-20,Rotate.Z_AXIS);
        camera.getTransforms().add(rotateX);
        camera.getTransforms().add(rotateY);

        camera.setNearClip(0.01);
        camera.setFarClip(400000);
        return camera;
    }
}