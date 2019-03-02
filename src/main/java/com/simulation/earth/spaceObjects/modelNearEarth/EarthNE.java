package com.simulation.earth.spaceObjects.modelNearEarth;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;

import java.util.Date;

public class EarthNE extends PlanetOrStart {

    private final static float radiusEarth = 6371f;

    public EarthNE() {
        prepareSpaceModel();
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
        getSpaceModel().setRotationAxis(Rotate.Y_AXIS);
        getSpaceModel().setRotate(getSpaceModel().getRotate()-1*deltaTime/10);
    }

    @Override
    public void prepareSpaceModel() {
        setName("earth");
        getSphere().setTranslateX(0);
        getSphere().setTranslateY(0);
        getSphere().setTranslateZ(0);
        getSphere().setRadius(radiusEarth*scale);
        getSpaceModel().getChildren().add(getSphere());
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
