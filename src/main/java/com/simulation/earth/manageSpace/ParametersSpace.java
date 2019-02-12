package com.simulation.earth.manageSpace;

import javafx.scene.image.Image;

public abstract class ParametersSpace {

    {
        prepareSpace();
    }
    protected double nearClip;
    protected double farClip;
    protected Image fondImage;

    public double getNearClip() {
        return nearClip;
    }

    public double getFarClip() {
        return farClip;
    }

    public Image getFondImage() {
        return fondImage;
    }

    protected abstract void prepareSpace();
}
