package com.simulation.earth.spaceObjects.modelNearEarth;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(Date data) {
    }

    @Override
    public void prepareStartCootdints() {

    }

    @Override
    public void movement(float deltaTime) {
        rotateY.setAngle(rotateY.getAngle()-1*deltaTime/10);
    }

    @Override
    public List<Node> modelDescription() {
        Group group = new Group();
        List<Node> nodes = new ArrayList<>();
        Sphere sphere = new Sphere(radiusEarth);
        sphere.setMaterial(prepareMaterial());
        group.getChildren().add(sphere);
        nodes.add(group);
        return nodes;
    }

    private PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/earthTexture.jpg")));
        phongMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/earthMapReflection.jpg")));
        return phongMaterial;
    }
}
