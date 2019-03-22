package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;

public interface FactorySatellite {
    SpaceObject createDeaultSatellite (OrbitParameters orbitParameters);
}
