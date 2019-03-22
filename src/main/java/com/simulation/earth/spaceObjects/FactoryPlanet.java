package com.simulation.earth.spaceObjects;

public interface FactoryPlanet {
    SpaceObject createEarth ();
    SpaceObject createMoon ();
    SpaceObject createSun ();
}
