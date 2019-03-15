package com.simulation.earth.manageSatellite;

import com.simulation.earth.MathModels.OrbitParameters;
import com.simulation.earth.spaceObjects.SpaceObject;

public interface ManageSatellite {
    SpaceObject createSatellite (OrbitParameters parametrsOrbit);
}
