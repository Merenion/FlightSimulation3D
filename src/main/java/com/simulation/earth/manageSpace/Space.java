package com.simulation.earth.manageSpace;

import com.simulation.earth.spaceObjects.SpaceObjectWithCamera;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Camera;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public abstract class Space {

    private ObservableList<SpaceObject> spaceObjects = FXCollections.observableArrayList();
    private Group spaseGroup = new Group();
    private String name = "";
    private ObservableList<Camera> cameras = FXCollections.observableArrayList();


    {
        spaceObjects.addListener((ListChangeListener<SpaceObject>) c -> {
            c.next();
            if (c.wasRemoved()){
                List<? extends SpaceObject> objecrsRemoved = c.getRemoved();
                for (SpaceObject object : objecrsRemoved)
                    spaseGroup.getChildren().remove(object.getSpaceModel());
            }
            if (c.wasAdded()) {
                List<? extends SpaceObject> objectsAdded = c.getAddedSubList();
                for (SpaceObject object : objectsAdded)
                    spaseGroup.getChildren().add(object.getSpaceModel());
            }
            refreshCameras();
        });
    }

    {
        spaceObjects.addAll(prepareSpace());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpaceObject getSpaceObject (String name) {
        for (SpaceObject object: spaceObjects){
            if (object.getName().equals(name))
                return object;
        }
        return null;
    }

    public Group getSpaceGroup () {
        return spaseGroup;
    }

    public ObservableList<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void prepareStartCoordinatForObjects (double time) {
        for (SpaceObject object : spaceObjects)
            object.prepareStartCootdints(time);
    }

    public void movementObjects(double deltaTime) {
        for (SpaceObject object : spaceObjects)
            object.movement(deltaTime);
    }

    public ObservableList<Camera> getCamerasFromSpaseObjects() {
        return cameras;
    }

    private void refreshCameras () {
        cameras.clear();
        for (SpaceObject object : spaceObjects) {
            if (object instanceof SpaceObjectWithCamera)
                cameras.addAll(((SpaceObjectWithCamera) object).getCameras());
        }
    }

    @Override
    public String toString() {
        if (!name.equals(""))
            return name;
        else return "Space nameless";
    }

    protected abstract ArrayList<SpaceObject> prepareSpace ();
}
