package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.ParametrsOrbit;
import com.simulation.earth.pathServis.ManagerDrawPath;
import com.simulation.earth.pathServis.ServisDrawTrajectory;
import javafx.scene.Group;
import javafx.scene.Node;

public class SateliteWithTrajectoryProjection extends SatelliteDefault{

    protected ServisDrawTrajectory servisDrawTrajectory = new ManagerDrawPath(0,0,0);

    {
        for (SpaceObject object: getObjectsOfReferenceMovement()){
            if (object instanceof PlanetOrStart) {
                object.getSpaceModel().getChildren().add(servisDrawTrajectory.getPath());
                break;
            }
        }
    }

    public SateliteWithTrajectoryProjection(ParametrsOrbit parametrsOrbit) {
        super(parametrsOrbit);
    }

    @Override
    public Group getTrajectory() {
        super.getTrajectory().getChildren().add(servisDrawTrajectory.getPath());
        return super.getTrajectory();
    }


}
