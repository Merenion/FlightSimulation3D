package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.trajectoryServis.Drawing;
import com.simulation.earth.trajectoryServis.ManagerDrawing;

public class SateliteWithTrajectoryProjection extends SatelliteDefault{

    protected Drawing drawing = new ManagerDrawing(0,0,0);

    {
        for (SpaceObject object: getObjectsOfReferenceMovement()){
            if (object instanceof PlanetOrStart) {
                object.getSpaceModel().getChildren().add(drawing.getPath());
                break;
            }
        }
    }

    public SateliteWithTrajectoryProjection(OrbitParameters parametrsOrbit) {
        super(parametrsOrbit);
    }



}
