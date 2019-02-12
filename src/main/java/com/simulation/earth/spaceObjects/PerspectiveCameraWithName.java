package com.simulation.earth.spaceObjects;

import javafx.scene.PerspectiveCamera;

public class PerspectiveCameraWithName extends PerspectiveCamera {
    private String name = "";

    public PerspectiveCameraWithName(boolean fixedEyeAtCameraZero, String name) {
        super(fixedEyeAtCameraZero);
        this.name = name;
    }

    public PerspectiveCameraWithName(String name) {
        this.name = name;
    }

    public PerspectiveCameraWithName() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (!name.equals(""))
            return name;
        else return "nameless";
    }
}
