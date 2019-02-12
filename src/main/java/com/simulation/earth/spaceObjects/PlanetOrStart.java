package com.simulation.earth.spaceObjects;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public abstract class PlanetOrStart extends SpaceObject{
    private float gravityAcceleration;
    private Sphere sphere = new Sphere();

    public float getGravityAcceleration() {
        return gravityAcceleration;
    }

    public void setGravityAcceleration(float gravityAcceleration) {
        this.gravityAcceleration = gravityAcceleration;
    }

    public Sphere getSphere() {
        return sphere;
    }

    abstract protected PhongMaterial prepareMaterial();
}
