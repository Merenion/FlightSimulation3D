package com.simulation.earth.spaceObjects;

/**
 * Фабрика по созданию космических обьектов природного происхождения (земля солнце и т.д.)
 */
public interface FactoryPlanet {
    SpaceObject createEarth ();
    SpaceObject createMoon ();
    SpaceObject createSun ();
}
