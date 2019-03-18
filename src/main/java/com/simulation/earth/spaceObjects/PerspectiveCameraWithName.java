package com.simulation.earth.spaceObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.PerspectiveCamera;

public class PerspectiveCameraWithName extends PerspectiveCamera {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private String nameSpaceObject ="";
    private SimpleStringProperty fullName = new SimpleStringProperty("");

    public PerspectiveCameraWithName(boolean fixedEyeAtCameraZero, String name) {
        super(fixedEyeAtCameraZero);
        this.name.setValue(name);
        refreshFullName();
    }

    public PerspectiveCameraWithName(String name) {
        this.name.setValue(name);
        refreshFullName();
    }

    public PerspectiveCameraWithName() {
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
        refreshFullName();
    }

    public String getNameSpaceObject() {
        return nameSpaceObject;
    }

    public void setNameSpaceObject(String nameSpaceObject) {
        this.nameSpaceObject = nameSpaceObject;
        refreshFullName();
    }

    private void refreshFullName () {
        fullName.setValue(name.getValue()+" ("+nameSpaceObject+")");
    }

    public String getFullName() {
        return fullName.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return fullName;
    }

    @Override
    public String toString() {
        if (!name.getValue().equals(""))
            return name.getValue();
        else return "nameless";
    }
}
