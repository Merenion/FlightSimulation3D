package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;

/**
 * фабрика по созданияю спутников
 */
public interface FactorySatellite {
    SpaceObject createDeaultSatellite (OrbitParameters orbitParameters);
}
