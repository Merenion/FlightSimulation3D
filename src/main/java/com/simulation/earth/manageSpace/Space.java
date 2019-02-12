package com.simulation.earth.manageSpace;

import com.simulation.earth.spaceObjects.ObjectWithCamera;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.scene.Camera;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Date;

public abstract class Space {

    private ArrayList<SpaceObject> spaceObjects = new ArrayList<>();
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getSpaceGroup () {
        Group group = new Group();
        for (SpaceObject spaceObject : spaceObjects)
            group.getChildren().addAll(spaceObject.getSpaceGroup());
        return group;
    }

    public ArrayList<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void prepareStartCoordinatForObjects (Date date) {
        for (SpaceObject object : spaceObjects)
            object.prepareStartCootdints(date);
    }

    public void movementObjects(float deltaTime) {
        for (SpaceObject object : spaceObjects)
            object.movement(deltaTime);
    }

    public ArrayList<Camera> getCamerasFromSpaseObjects() {
        ArrayList<Camera> cameras = new ArrayList<>();
        for (SpaceObject object : spaceObjects) {
            if (object instanceof ObjectWithCamera)
                cameras.addAll(((ObjectWithCamera) object).getCameras());
        }
        return cameras;
    }

    @Override
    public String toString() {
        if (!name.equals(""))
            return name;
        else return "Space nameless";
    }

    protected abstract void prepareSpace ();
}
