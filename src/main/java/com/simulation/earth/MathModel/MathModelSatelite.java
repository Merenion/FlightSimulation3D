package com.simulation.earth.MathModel;

import javafx.geometry.Point3D;

public class MathModelSatelite extends DeterminateParameters implements GeodeticLocation{

    public MathModelSatelite(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    public Point3D getGeodeticCoordinats(double t) {
        return geodeticСoordinates(t,0);
    }

    @Override
    public double getAmountCoil(double t) {
        return amountCoil(t);
    }

    @Override
    public double getHight(double t) {
        return getHight(t);
    }

}
