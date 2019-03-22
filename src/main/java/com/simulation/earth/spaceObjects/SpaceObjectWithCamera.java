package com.simulation.earth.spaceObjects;

import com.simulation.earth.PerspectiveCameraWithName;
import javafx.scene.Camera;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public abstract class SpaceObjectWithCamera extends SpaceObject{
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

    @Override
    public void setName(String name) {
        super.setName(name);
        for (Camera camera : cameras){
            if (camera instanceof PerspectiveCameraWithName)
                ((PerspectiveCameraWithName) camera).setNameSpaceObject(getName());
        }
    }

    protected abstract List<Camera> prepareCameras ();
}
