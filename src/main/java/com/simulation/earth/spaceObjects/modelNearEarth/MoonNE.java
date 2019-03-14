package com.simulation.earth.spaceObjects.modelNearEarth;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoonNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(double time) {
        prepareStartCootdints();
    }

    @Override
    public void prepareStartCootdints() {
        rotateX.setAngle(0);
        if (rotateFlyCircle!= null)
            rotateFlyCircle.setAngle(0);
    }

    private Rotate rotateFlyCircle = new Rotate(0,new Point3D(1,1,0));
    {
        getSpaceModel().getTransforms().add(rotateFlyCircle);
    }

    private double oldTime;
    @Override
    public void movement(double time) {
        double deltaTime = time -oldTime;
        oldTime = time;
        rotateFlyCircle.setAngle(rotateFlyCircle.getAngle()-3* deltaTime /10);
        rotateX.setAngle(rotateX.getAngle()+4* deltaTime /10);
    }

    @Override
    protected List<Node> modelDescription() {
        Group group = new Group();
        List<Node> nodes = new ArrayList<>();
        Sphere sphere = new Sphere(radiusMoon);
        group.setTranslateZ(distanceOfEarthPerigey);
        sphere.setMaterial(prepareMaterial());
        nodes.add(group);
        group.getChildren().add(sphere);
        return nodes;
    }

    private PhongMaterial prepareMaterial() {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/moonTexture.jpg")));
        return phongMaterial;
    }

    @Override
    public float getRadiusPlanet() {
        return radiusMoon;
    }
}
