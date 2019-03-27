package com.simulation.earth.spaceObjects;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**
 * класс описывающий планету или звезду
 */
public abstract class PlanetOrStart extends SpaceObject{
    protected final static float radiusEarth = 6371f;
    protected final static float radiusMoon = 1737f;
    protected final static float distanceOfEarthPerigey = 357_104f;
    protected final static float distanceOfEarthApogei = 406_696f;
    protected final static float radiusSun = 695_508;
    protected final static double distanceOfEarth = 149_600_000;
    protected final static double rotationalSpeedEarth = 86164.090530833;
    /**пока не где не используется*/
    private float gravityAcceleration;

    /**
     * метод для получения радуса обьекта
     * @return радиус планеты
     */
    public abstract float getRadiusPlanet ();

    public float getGravityAcceleration() {
        return gravityAcceleration;
    }

    public void setGravityAcceleration(float gravityAcceleration) {
        this.gravityAcceleration = gravityAcceleration;

    }

}
