package com.simulation.earth.spaceObjects;

import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;

import java.util.Date;

public class Sun extends PlanetOrStart{
    private final static float radiusSun = 695_508;
    private final static double distanceOfEarth = 149_600_000;

    private PointLight pointLight;

    {
        prepareSpaceGroup();
    }

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {

    }

    @Override
    public void movement(float deltaTime) {
        getRotateX().setAxis(Rotate.Y_AXIS);
        getRotateX().setAngle(getRotateX().getAngle()+1*deltaTime/10);
        getSphere().setRotate(getSphere().getRotate()+6*deltaTime/10);
    }

    @Override
    protected void prepareSpaceGroup() {
        setName("sun");
        getSphere().setTranslateX(distanceOfEarth);
        getSphere().setRadius(radiusSun);
        getSphere().setMaterial(prepareMaterial());
        pointLight = new PointLight();
        pointLight.setColor(Color.WHITE);
        pointLight.setTranslateX(getSphere().getTranslateX());
        pointLight.setTranslateY(getSphere().getTranslateY());
        pointLight.setTranslateZ(getSphere().getTranslateZ());
        getSpaceGroup().getChildren().add(getSphere());
        getSpaceGroup().getChildren().add(pointLight);
    }

    @Override
    protected PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/texturs/sunTexture.jpg")));
        return phongMaterial;
    }
}
