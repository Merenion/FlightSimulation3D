package com.simulation.earth.spaceObjects;

import com.simulation.earth.MathModels.OrbitParameters;
import com.simulation.earth.MathModels.StorageOrbitParameters;
import com.simulation.earth.trajectoryServis.DrawingPathProjectionSatelliteOnPlanet;
import com.simulation.earth.trajectoryServis.DrawingTrajectory;
import javafx.scene.paint.Color;


public abstract class Satellite extends ObjectWithCamera{
    private OrbitParameters parametrsOrbit = new StorageOrbitParameters();
    private DrawingTrajectory drawingProjectionOnPlanet;

    public void enableDrawingProjectionOnPlanet (PlanetOrStart planet, Color colorTrjectory, int maxLengthTrajectory) {
        if (drawingProjectionOnPlanet!=null)
            drawingProjectionOnPlanet.removeTrajectory();
        drawingProjectionOnPlanet = new DrawingPathProjectionSatelliteOnPlanet(planet,orientation,colorTrjectory,maxLengthTrajectory);
        drawingProjectionOnPlanet.startDrawTrajectories();
    }

    public void enableDrawingProjectionOnPlanet (PlanetOrStart planet, Color colorTrjectory) {
        enableDrawingProjectionOnPlanet(planet, colorTrjectory,175);
    }

    public void stopDrawingProjectionOnPlanet () {
        if (drawingProjectionOnPlanet != null) {
            drawingProjectionOnPlanet.stopDrawTrajectories();
        }
    }

    public Satellite(OrbitParameters parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }

    public Satellite(){};

    public OrbitParameters getParametrsOrbit() {
        return parametrsOrbit;
    }

    public void setParametrsOrbit(OrbitParameters parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }
}
