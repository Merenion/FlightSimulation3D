package com.simulation.earth.MathModel;

import javafx.geometry.Point3D;

public interface GeodeticLocation {

    Point3D getGeodeticCoordinats (double t);
    double getAmountCoil (double t);
    double getHight (double t);
}
