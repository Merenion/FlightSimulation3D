package com.simulation.earth.MathModel;

import javafx.geometry.Point3D;

public class MathModelSatelite extends DeterminateParameters implements GeodeticLocation{

    double time = 0;

    public MathModelSatelite(OrbitParameters orbitPr, double startTime) {
        super(orbitPr);

    }


    public Point3D getGeodeticCoordinatsf(double t) {
    return null;
    }
    public Point3D getGeodeticCoordinats(double t) {
        return null;
    }

    @Override
    public double getAmountCoil(double t) {
        return 0;
    }

    @Override
    public double getHight(double t) {
        return 0;
    }


}
