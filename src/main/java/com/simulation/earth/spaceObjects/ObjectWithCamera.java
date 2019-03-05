package com.simulation.earth.spaceObjects;

import javafx.scene.Camera;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectWithCamera extends SpaceObject{
    private ArrayList<Camera> cameras = new ArrayList<>();

    public ArrayList<Camera> getCameras () {
        return cameras;
    }

    {
        cameras.addAll(prepareCameras());
        getSpaceModel().getChildren().addAll(cameras);
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
