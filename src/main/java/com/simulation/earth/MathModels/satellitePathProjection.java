package com.simulation.earth.MathModels;

public class satellitePathProjection extends MathModelSatelite{

    public satellitePathProjection(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    @Override
    public double hightFlightFromCenter(double t, double tau) {
        return 6380;
    }
}
