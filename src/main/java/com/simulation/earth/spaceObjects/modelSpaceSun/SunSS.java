package com.simulation.earth.spaceObjects.modelSpaceSun;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;

import java.util.Date;

public class SunSS extends PlanetOrStart {
    private final static float radiusSun = 695_508;
    private final static double distanceOfEarth = 149_600_000;

    private PointLight pointLight;

    @Override
    protected PhongMaterial prepareMaterial() {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/texturs/sunTexture.jpg")));
        return phongMaterial;
    }

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {
        getSphere().setTranslateX(0);
        getSphere().setTranslateY(0);
        getSphere().setTranslateZ(0);
    }

    @Override
    public void movement(float deltaTime) {
        getSpaceModel().setRotationAxis(Rotate.Y_AXIS);
        getSpaceModel().setRotate(getSpaceModel().getRotate()-1*deltaTime/10);
    }

    @Override
    protected void prepareSpaceModel() {
        setName("sun");
        getSphere().setRadius(radiusSun);
        getSphere().setMaterial(prepareMaterial());
        pointLight = new PointLight();
        pointLight.setColor(Color.WHITE);
        getSpaceModel().getChildren().add(getSphere());
        getSpaceModel().getChildren().add(pointLight);
    }
}
