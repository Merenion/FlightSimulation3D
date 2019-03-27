package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.trajectoryServis.DrawingPathProjectionSatelliteOnPlanet;
import com.simulation.earth.trajectoryServis.DrawingPath;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * класс описывает спутники и их функции
 */
public abstract class Satellite extends SpaceObjectWithCamera {

    /**поле параметров орбиты спутника*/
    private OrbitParameters parametrsOrbit = new StorageOrbitParameters();
    /**сервис позволяющий рисовать путь подспутников точки*/
    private DrawingPath drawingProjectionOnPlanet;
    /**цвет пути подспутниковой точки*/
    private Color colorProjectionOnPlanet = Color.WHITE;
    /**длина пути подспутниковой точки*/
    private int maxLengthProjectionOnPlanet = 175;

    public Satellite(OrbitParameters parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }

    /**
     * Включает прорисовку пути подспутниковой точки.
     * Удаляет весь нарисованный путь до вызова метода
     * @param planet планета на которую проецируется подспутниковая точка
     */
    public void enableDrawingProjectionOnPlanet (PlanetOrStart planet) {
        if (drawingProjectionOnPlanet!=null)
        drawingProjectionOnPlanet.removeTrajectory();
        drawingProjectionOnPlanet = new DrawingPathProjectionSatelliteOnPlanet(planet,orientation,colorProjectionOnPlanet,maxLengthProjectionOnPlanet);
        drawingProjectionOnPlanet.startDrawTrajectories();
    }

    /**
     * Останавливает прорисовку пути подспутниковой точки
     */
    public void stopDrawingProjectionOnPlanet () {
        if (drawingProjectionOnPlanet != null) {
            drawingProjectionOnPlanet.stopDrawTrajectories();
        }
    }

    /**
     * удаляет весь нарисованный путь подспутниковой точки
     */
    public void refreshProjectionOnPlanet () {
        if (drawingProjectionOnPlanet!=null)
        drawingProjectionOnPlanet.removeTrajectory();
    }

    public OrbitParameters getParametrsOrbit() {
        return parametrsOrbit;
    }

    public Color getColorProjectionOnPlanet() {
        return colorProjectionOnPlanet;
    }

    public void setColorProjectionOnPlanet(Color colorProjectionOnPlanet) {
        this.colorProjectionOnPlanet = colorProjectionOnPlanet;
    }

    public int getMaxLengthProjectionOnPlanet() {
        return maxLengthProjectionOnPlanet;
    }

    public void setMaxLengthProjectionOnPlanet(int maxLengthProjectionOnPlanet) {
        this.maxLengthProjectionOnPlanet = maxLengthProjectionOnPlanet;
    }

    public void setParametrsOrbit(OrbitParameters parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }
}
