package com.simulation.earth.spaceObjects;

import javafx.scene.Camera;
import javafx.scene.transform.Transform;

import java.util.ArrayList;

public abstract class ObjectWithCamera extends SpaceObject{
    private ArrayList<Camera> cameras = new ArrayList<>();

    public ArrayList<Camera> getCameras () {
        return cameras;
    }

    public Camera getCamera (String name) {
        for (Camera camera : cameras){
            if (camera.toString().equals(name))
                return camera;
        }
        return null;
    }

    public Camera addCamera (Camera camera){
        getSpaceGroup().getChildren().add(camera);
        cameras.add(camera);
        return camera;
    }
}
