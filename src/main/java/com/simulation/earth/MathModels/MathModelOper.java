package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;

public class MathModelOper extends DeterminateParameters {

    private final double rGSO = 42371;
    private double betta;
    private double gamma;
    private double alpha_SP;
    private double Lambda_B;
    private double L_CP_KAN = 50000; // растояние до СР

    private boolean Flag_Vid_CP_KAN;

    public MathModelOper(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    public boolean calculationOperativn(double dolgotaSR, double t) {
        double r = hightFlightFromCenter(t, 0);
        double fiGa = shirotaTockiTraseaPoleta(t, 0);
        double LambdaGd = geosethicheskayDolgotaFor2D(t, 0);

        betta = Math.acos(radiusPlanet / r);
        gamma = Math.asin(radiusPlanet / rGSO);
        alpha_SP = Math.PI / 2 + gamma - betta;

        if ((dolgotaSR * Math.PI / 180 >= 0) && (dolgotaSR * Math.PI / 180 <= Math.PI))
            Lambda_B = dolgotaSR * Math.PI / 180 - Math.PI;
        if ((dolgotaSR * Math.PI / 180 > -Math.PI) && (dolgotaSR * Math.PI / 180 < 0))
            Lambda_B = Math.PI + dolgotaSR * Math.PI / 180;

        if ((L_CP_KAN > rGSO) && (Math.abs(Math.acos(Math.sin(0) * Math.sin(fiGa)
                + Math.cos(0) * Math.cos(fiGa) * Math.cos(LambdaGd - Lambda_B)))
                < alpha_SP)) {
            Flag_Vid_CP_KAN = false;
            return false;
        } else {
            Flag_Vid_CP_KAN = true;
            return true;
        }
    }
}
