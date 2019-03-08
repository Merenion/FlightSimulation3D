package com.simulation.earth.spaceObjects.modelSpaceSun;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Date;

public class SunSS extends PlanetOrStart {
    private final static float radiusSun = 695_508;
    private final static double distanceOfEarth = 149_600_000;

    @Override
    public void prepareStartCootdints(double time) {

    }

    @Override
    public void prepareStartCootdints() {

    }

    @Override
    public void movement(double time) {

    }

    @Override
    protected ArrayList<Node> modelDescription() {
        return null;
    }
}
