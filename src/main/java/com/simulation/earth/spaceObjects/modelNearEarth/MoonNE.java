package com.simulation.earth.spaceObjects.modelNearEarth;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;

import java.util.Date;

public class MoonNE extends PlanetOrStart {
    private final static float radiusMoon = 1737f;
    private final static float distanceOfEarthPerigey = 357_104f;
    private final static float distanceOfEarthApogei = 406_696f;

    {
        prepareSpaceModel();
    }

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {

    }

    @Override
    public void movement(float deltaTime) {
        getRotateX().setAxis(new Point3D(1,1,0));
        getRotateX().setAngle(getRotateX().getAngle()-3*deltaTime/10);
        getSphere().setRotate(getSphere().getRotate()+4*deltaTime/10);

    }

    @Override
    protected void prepareSpaceModel() {
        setName("moon");
        getSphere().setTranslateZ(distanceOfEarthPerigey);
        getSphere().setRadius(radiusMoon*scale);
        getSphere().setMaterial(prepareMaterial());
        getSpaceModel().getChildren().add(getSphere());
    }

    @Override
    protected PhongMaterial prepareMaterial() {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/moonTexture.jpg")));
        return phongMaterial;
    }
}
