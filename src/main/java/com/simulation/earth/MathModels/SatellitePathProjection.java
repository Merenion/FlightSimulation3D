package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;

public class SatellitePathProjection extends MathModelSatelite{

    public SatellitePathProjection(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    @Override
    public double hightFlightFromCenter(double t, double tau) {
        return 6380;
    }
}
