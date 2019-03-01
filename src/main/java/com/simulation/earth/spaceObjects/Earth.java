package com.simulation.earth.spaceObjects;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.Date;

public class Earth extends PlanetOrStart {

    private final static float radiusEarth = 6371f;

    public Earth() {
        prepareSpaceGroup();
    }

    @Override
    public void prepareStartCootdints(Date data) {
        getSphere().setTranslateX(0);
        getSphere().setTranslateY(0);
        getSphere().setTranslateZ(0);
    }

    @Override
    public void prepareStartCootdints() {

    }

    @Override
    public void movement(float deltaTime) {
        getSpaceGroup().setRotationAxis(Rotate.Y_AXIS);
        getSpaceGroup().setRotate(getSpaceGroup().getRotate()-1*deltaTime/10);
    }

    @Override
    public void prepareSpaceGroup() {
        setName("earth");
        getSphere().setTranslateX(0);
        getSphere().setTranslateY(0);
        getSphere().setTranslateZ(0);
        getSphere().setRadius(radiusEarth);
        getSpaceGroup().getChildren().add(getSphere());
        getSphere().setMaterial(prepareMaterial());
    }

    @Override
    protected PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/earthTexture.jpg")));
        phongMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/earthMapReflection.jpg")));
        return phongMaterial;
    }
}
