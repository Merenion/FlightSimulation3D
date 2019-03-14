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

import java.util.ArrayList;
import java.util.List;

public class SunNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(double time) {
        prepareStartCootdints();
    }

    @Override
    public void prepareStartCootdints() {
        rotateX.setAngle(0);
        rotateY.setAngle(0);
        if (rotateFlyCircleY != null)
            rotateFlyCircleY.setAngle(0);
    }

    private Rotate rotateFlyCircleY = new Rotate(0,new Point3D(0,1,0));
    private Rotate rotateFlyCircleZ = new Rotate(0,new Point3D(0,0,1));
    {
        getSpaceModel().getTransforms().add(rotateFlyCircleY);
        getSpaceModel().getTransforms().add(rotateFlyCircleZ);
    }

    private double oldTime;
    @Override
    public void movement(double time) {
        double deltaTime = time - oldTime;
        oldTime = time;
        rotateFlyCircleY.setAngle(rotateFlyCircleY.getAngle()-1* deltaTime /1000);
//        rotateFlyCircleZ.setAngle(rotateFlyCircleZ.getAngle()-1* deltaTime /2000);
        rotateX.setAngle(rotateX.getAngle()+6* deltaTime /10);
        rotateY.setAngle(rotateY.getAngle()+3* deltaTime /10);
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

    @Override
    public float getRadiusPlanet() {
        return radiusSun;
    }
}
