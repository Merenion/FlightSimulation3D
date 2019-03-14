package com.simulation.earth.spaceObjects;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectWithCamera extends SpaceObject{
    private ArrayList<Camera> cameras = new ArrayList<>();

    public ArrayList<Camera> getCameras () {
        return cameras;
    }

    {
        cameras.addAll(prepareCameras());
        for (Camera camera: cameras) {
            Group group = new Group();
            group.getChildren().add(camera);
            group.getTransforms().addAll(rotateX, rotateY, rotateZ);
            getSpaceModel().getChildren().add(group);
        }
    }

    public Camera getCamera (String name) {
        for (Camera camera : cameras){
            if (camera.toString().equals(name))
                return camera;
        }
        return null;
    }

    protected abstract List<Camera> prepareCameras ();
}
