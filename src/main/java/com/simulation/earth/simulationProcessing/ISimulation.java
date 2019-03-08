package com.simulation.earth.simulationProcessing;

import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.spaceObjects.SpaceObject;

import java.util.Date;

public interface ISimulation {

    double getTimeSimulation();
    double getDeltaTime();
    void setDeltaTime(double delta);
    void enableSimulation(Space space);
    void stopSimulation ();
    void resetSimulation(Space space);
    double getStartTime();
    void setStartTime(double startTime);
}
