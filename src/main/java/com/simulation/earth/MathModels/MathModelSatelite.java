package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;
import javafx.geometry.Point3D;

/**
 * математическая модель, отсюда можно получить различную информацию полета спутника
 * (Реализованно не полностью)
 */
public class MathModelSatelite extends DeterminateParameters implements GeodeticLocation{

    public MathModelSatelite(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    /**
     * Геодезические координаты
     * @param t время в которое необходимо узнать координаты
     * @return точка содержащая координаты xyz
     */
    public Point3D getGeodeticCoordinats(double t) {
        return geodeticСoordinates(t,0);
    }


}
