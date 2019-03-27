package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.OrbitParameters;

/**
 * Реализация фабрики создания космических объектов типа планета и земля
 * реализовн как singleton
 */
public class FactoryNearEarth implements FactoryPlanet, FactorySatellite {

    private static FactoryNearEarth singleton;

    private FactoryNearEarth (){}

    public static FactoryNearEarth getFactory() {
        if (singleton == null) {
            singleton = new FactoryNearEarth();
        }
        return singleton;
    }

    @Override
    public SpaceObject createEarth() {
        return new EarthNE();
    }

    @Override
    public SpaceObject createMoon() {
        return new MoonNE();
    }

    @Override
    public SpaceObject createSun() {
        return new SunNE();
    }

    @Override
    public SpaceObject createDeaultSatellite(OrbitParameters orbitParameters) {
        return new SatelliteDefault(orbitParameters);
    }
}
