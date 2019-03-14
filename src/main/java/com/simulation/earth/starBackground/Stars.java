package com.simulation.earth.starBackground;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Stars extends Background{
    private static double distance = 180_000_000;
    private static double wallSize = distance*2;

    @Override
    ArrayList<Node> prepareBackground() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(createWall(wallSize,new Translate(0,0,distance)));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance)));
        nodes.add(createWall(wallSize,new Translate(0,0,distance),new Point3D(0,1,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance),new Point3D(0,1,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,distance),new Point3D(1,0,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance),new Point3D(1,0,0),90));
        return nodes;
    }

    private PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream(getPathTexture())));
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream(getPathTexture())));
        phongMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/earthMapNullReflection.jpg")));
        return phongMaterial;
    }

    private Node createWall (double wallSize, Translate translate, Point3D axis, int angel) {
        Box top = new Box();
        top.setRotationAxis(axis);
        top.setRotate(angel);
        top.setDepth(1000);
        top.setHeight(wallSize);
        top.setWidth(wallSize);
        top.setMaterial(prepareMaterial());
        top.getTransforms().add(translate);
        return top;
    }

    private Node createWall (double wallSize, Translate translate) {
        return createWall(wallSize, translate,new Point3D(0,0,0),0);
    }


}