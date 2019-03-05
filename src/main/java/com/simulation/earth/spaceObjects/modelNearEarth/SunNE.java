package com.simulation.earth.spaceObjects.modelNearEarth;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SunNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(Date data) {

    }

    @Override
    public void prepareStartCootdints() {

    }

    private Rotate rotateFlyCircle = new Rotate(0,new Point3D(0,1,0));
    {
        getSpaceModel().getTransforms().add(rotateFlyCircle);
    }
    @Override
    public void movement(float deltaTime) {
        rotateFlyCircle.setAngle(rotateFlyCircle.getAngle()+1*deltaTime/10);
        rotateX.setAngle(rotateX.getAngle()+6*deltaTime/10);
        rotateY.setAngle(rotateY.getAngle()+3*deltaTime/10);
    }

    @Override
    protected List<Node> modelDescription() {
        Group group = new Group();
        List<Node> nodes = new ArrayList<>();
        Sphere sphere = new Sphere(radiusSun);

        group.setTranslateX(distanceOfEarth);
        sphere.setMaterial(prepareMaterial());
        PointLight pointLight = new PointLight();
        pointLight.setColor(Color.WHITE);
        pointLight.setTranslateX(sphere.getTranslateX());
        pointLight.setTranslateY(sphere.getTranslateY());
        pointLight.setTranslateZ(sphere.getTranslateZ());

        group.getChildren().addAll(sphere,pointLight);
        nodes.add(group);

        return nodes;
    }

    private PhongMaterial prepareMaterial() {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/texturs/sunTexture.jpg")));
        return phongMaterial;
    }
}
