package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;
import javafx.geometry.Point3D;

public class MathModelSatelite extends DeterminateParameters implements GeodeticLocation{

    public MathModelSatelite(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    public Point3D getGeodeticCoordinats(double t) {
        return geodeticСoordinates(t,0);
    }


}
