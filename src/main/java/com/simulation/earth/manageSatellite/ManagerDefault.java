package com.simulation.earth.manageSatellite;

import com.simulation.earth.MathModels.OrbitParameters;
import com.simulation.earth.spaceObjects.SatelliteDefault;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.scene.Group;

public class ManagerDefault implements ManageSatellite{

    @Override
    public SpaceObject createSatellite(OrbitParameters parametrsOrbit) {
        return new SatelliteDefault(parametrsOrbit);
    }
}
