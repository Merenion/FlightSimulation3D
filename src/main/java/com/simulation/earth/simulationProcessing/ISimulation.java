package com.simulation.earth.simulationProcessing;

import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.spaceObjects.SpaceObject;

import java.util.Date;

public interface ISimulation {

    double getTimeSimulation();
    float getDeltaTime();
    void setDeltaTime(float delta);
    void enableSimulation(Space space);
    void stopSimulation ();
    void resetSimulation(Space space, Date data);
}
