package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.FactorySatellite;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.FactoryNearEarth;

/**
 * Класс который определяет создание спутника по умолчанию
 * и наследует все методы управления спутниками.
 * Класс - singleton
 */
public class ManagerSatelliteEarth extends DefaultManageSatellite {

    private FactorySatellite factorySatellite = FactoryNearEarth.getFactory();

    private static ManagerSatelliteEarth singleton;

    private ManagerSatelliteEarth(){}

    public static ManagerSatelliteEarth getManager () {
        if (singleton == null) {
            singleton = new ManagerSatelliteEarth();
        }
        return singleton;
    }

    public static void destroyManager () {
        singleton =null;
    }

    /**
     * Создание спутника по умолчанию
     * используется Фабрика Спутников
     * @param parametrsOrbit параметры орбиты спутника
     * @param name имя спутника
     * @return созданный спутник
     */
    @Override
    public Satellite createSatellite(OrbitParameters parametrsOrbit,String name) {
        Satellite satellite = (Satellite) factorySatellite.createDeaultSatellite(parametrsOrbit);
        satellite.setName(name);
        satellites.add(satellite);
        return satellite;
    }

    @Override
    public Satellite createSatelliteWithParametersCA(OrbitParameters parametrsOrbit,CaParameters caParameters,String name) {
        Satellite satellite = (Satellite) factorySatellite.createSuperSatellite(parametrsOrbit,caParameters);
        satellite.setName(name);
        satellites.add(satellite);
        return satellite;
    }
}
