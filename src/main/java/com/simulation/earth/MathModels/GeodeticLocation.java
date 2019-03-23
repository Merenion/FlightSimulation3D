package com.simulation.earth.MathModels;

import javafx.geometry.Point3D;

/**
 * интерфейс позволяющий получить различную геодезическую информацию
 */
public interface GeodeticLocation {

    /**
     * Геодезические координаты
     * @param t время в которое необходимо узнать координаты
     * @return точка содержащая координаты xyz
     */
    Point3D getGeodeticCoordinats (double t);
}
