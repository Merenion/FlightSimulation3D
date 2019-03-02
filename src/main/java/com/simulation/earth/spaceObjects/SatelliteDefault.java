package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.ParametrsOrbit;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

import java.util.Date;

public class SatelliteDefault extends Satellite {

    {
        prepareSpaceModel();
    }


    public SatelliteDefault(ParametrsOrbit parametrsOrbit) {
        super(parametrsOrbit);
    }

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {
//        getTranslate().setZ(-9000);
//        getRotateY().setAngle(-90);
        getTranslate().setX(mathModel.getXga(0));
        getTranslate().setY(mathModel.getYga(0));
        getTranslate().setZ(mathModel.getZga(0));
    }
    double t =0;


    @Override
    public void movement(float deltaTime) {
        t+=deltaTime;
        getTranslate().setX(mathModel.getXga(t));
        getTranslate().setY(mathModel.getYga(t));
        getTranslate().setZ(mathModel.getZga(t));
        if (isDrawPath()) {
            servisDrawTrajectory.addLineInPathIfNeeded((float) getTranslate().getX(), (float) getTranslate().getY(), (float) getTranslate().getZ());
        }
    }

    @Override
    protected void prepareSpaceModel() {
        setName("satelite default");

        Group satelite = new Group();

        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(0.01*scale);
        cylinder.setRadius(0.005*scale);
//        cylinder.setHeight(500);
//        cylinder.setRadius(250);
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setRadius(0.0025*scale);
        cylinder2.setHeight(0.01*scale);
        cylinder2.setTranslateY(0.006*scale);
        Cylinder cylinder3 = new Cylinder();
        cylinder3.setHeight(0.057*scale);
        cylinder3.setRadius(0.0005*scale);
        cylinder3.setRotate(90);
        Box boxLeft = new Box();
        boxLeft.setHeight(0.0003*scale);
        boxLeft.setDepth(0.008*scale);
        boxLeft.setWidth(0.025*scale);
        boxLeft.setTranslateX(-0.0185*scale);
        Box boxRight = new Box();
        boxRight.setHeight(0.0003*scale);
        boxRight.setDepth(0.008*scale);
        boxRight.setWidth(0.0251*scale);
        boxRight.setTranslateX(0.0185*scale);

        prepareMaterialCorpus(cylinder);
        prepareMaterialSunBatars(boxLeft);
        prepareMaterialSunBatars(boxRight);

        satelite.getChildren().add(cylinder);
        satelite.getChildren().add(cylinder2);
        satelite.getChildren().add(cylinder3);
        satelite.getChildren().add(boxLeft);
        satelite.getChildren().add(boxRight);

        satelite.setRotationAxis(Rotate.Y_AXIS);
        satelite.setRotate(90);

        getSpaceModel().getChildren().add(satelite);

        initCameraForSurveyEarth(0,0.0011,0);
        initCameraForSurveySatelite();
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

    private void initCameraForSurveyEarth(double x, double y, double z){
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey EarthNE");
        camera.setTranslateX(x);
        camera.setTranslateY(y);
        camera.setTranslateZ(z);
        camera.setNearClip(1);
        camera.setFarClip(400000);
        addCamera(camera);
    }

    private void initCameraForSurveySatelite() {
        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey Satelite");

        camera.setTranslateX(0);
        camera.setTranslateY(0.06*scale);
        camera.setTranslateZ(-0.09*scale);

        Rotate rotateX = new Rotate(30,Rotate.X_AXIS);
        Rotate rotateY = new Rotate(-20,Rotate.Z_AXIS);
        camera.getTransforms().add(rotateX);
        camera.getTransforms().add(rotateY);


        camera.setNearClip(0.01);
        camera.setFarClip(400000);
        addCamera(camera);
    }
}



//
//    @Override
//    protected void prepareSpaceModel() {
//        setName("satelite default");
//
//        Group satelite = new Group();
//
//        Cylinder cylinder = new Cylinder();
//        cylinder.setHeight(0.001);
//        cylinder.setRadius(0.0005);
//        Cylinder cylinder2 = new Cylinder();
//        cylinder2.setRadius(0.00025);
//        cylinder2.setHeight(0.001);
//        cylinder2.setTranslateY(0.0006);
//        Cylinder cylinder3 = new Cylinder();
//        cylinder3.setHeight(0.0057);
//        cylinder3.setRadius(0.00005);
//        cylinder3.setRotate(90);
//        Box boxLeft = new Box();
//        boxLeft.setHeight(0.00003);
//        boxLeft.setDepth(0.0008);
//        boxLeft.setWidth(0.0025);
//        boxLeft.setTranslateX(-0.00185);
//        Box boxRight = new Box();
//        boxRight.setHeight(0.00003);
//        boxRight.setDepth(0.0008);
//        boxRight.setWidth(0.0025);
//        boxRight.setTranslateX(0.00185);
//
//        prepareMaterialCorpus(cylinder);
//        prepareMaterialSunBatars(boxLeft);
//        prepareMaterialSunBatars(boxRight);
//
//        satelite.getChildren().add(cylinder);
//        satelite.getChildren().add(cylinder2);
//        satelite.getChildren().add(cylinder3);
//        satelite.getChildren().add(boxLeft);
//        satelite.getChildren().add(boxRight);
//
//        satelite.setRotationAxis(Rotate.X_AXIS);
//        satelite.setRotate(90);
//
//        getSpaceModel().getChildren().add(satelite);
//
//        initCameraForSurveyEarth(0,0.0011,0);
//        initCameraForSurveySatelite();
//
//        getTranslate().setZ(-800);
//        getRotateY().setAngle(90);
//    }
//
//    private void prepareMaterialCorpus (Shape3D node) {
//        PhongMaterial phongMaterialBatare = new PhongMaterial();
//        phongMaterialBatare.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/corpusSateliteTexture.jpg")));
//        node.setMaterial(phongMaterialBatare);
//    }
//
//    private void prepareMaterialSunBatars (Shape3D node) {
//        PhongMaterial phongMaterialCorpus = new PhongMaterial();
//        phongMaterialCorpus.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/sunBatareTexture.jpg")));;
//        node.setMaterial(phongMaterialCorpus);
//    }
//
//    private void initCameraForSurveyEarth(double x, double y, double z){
//        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey EarthNE");
//        camera.setTranslateX(x);
//        camera.setTranslateY(y);
//        camera.setTranslateZ(z);
//        camera.setNearClip(1);
//        camera.setFarClip(400000);
//        addCamera(camera);
//    }
//
//    private void initCameraForSurveySatelite() {
//        PerspectiveCameraWithName camera = new PerspectiveCameraWithName(true,"survey Satelite");
//
//        camera.setTranslateX(0);
//        camera.setTranslateY(-0.006);
//        camera.setTranslateZ(-0.009);
//
//        Rotate rotateX = new Rotate(-30,Rotate.X_AXIS);
//        Rotate rotateY = new Rotate(20,Rotate.Z_AXIS);
//        camera.getTransforms().add(rotateX);
//        camera.getTransforms().add(rotateY);
//
//
//        camera.setNearClip(0.001);
//        camera.setFarClip(400000);
//        addCamera(camera);
//    }