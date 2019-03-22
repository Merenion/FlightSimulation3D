package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.trajectoryServis.DrawingPathProjectionSatelliteOnPlanet;
import com.simulation.earth.trajectoryServis.DrawingPath;
import javafx.scene.paint.Color;


public abstract class Satellite extends SpaceObjectWithCamera {
    private OrbitParameters parametrsOrbit = new StorageOrbitParameters();
    private DrawingPath drawingProjectionOnPlanet;
    private Color colorProjectionOnPlanet = Color.WHITE;
    private int maxLengthProjectionOnPlanet = 175;


    public void enableDrawingProjectionOnPlanet (PlanetOrStart planet) {
        if (drawingProjectionOnPlanet!=null)
            drawingProjectionOnPlanet.removeTrajectory();
        drawingProjectionOnPlanet = new DrawingPathProjectionSatelliteOnPlanet(planet,orientation,colorProjectionOnPlanet,maxLengthProjectionOnPlanet);
        drawingProjectionOnPlanet.startDrawTrajectories();
    }

    public void stopDrawingProjectionOnPlanet () {
        if (drawingProjectionOnPlanet != null) {
            drawingProjectionOnPlanet.stopDrawTrajectories();
        }
    }

    public void refreshProjectionOnPlanet () {
        if (drawingProjectionOnPlanet!=null)
            drawingProjectionOnPlanet.removeTrajectory();
    }

    public Satellite(OrbitParameters parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }


    public Satellite(){};

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
