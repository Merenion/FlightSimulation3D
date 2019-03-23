package com.simulation.earth.manageSpace;

import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.spaceObjects.*;
import com.simulation.earth.spaceObjects.modelNearEarth.EarthNE;
import com.simulation.earth.spaceObjects.modelNearEarth.MoonNE;
import com.simulation.earth.spaceObjects.modelNearEarth.SunNE;

import java.util.ArrayList;

/**
 * Околоземное пространство.
 * имеет все методы пространства
 */
public class NearEarthSpace extends Space {

    /**
     * Задает обьекты пространства по умолчанию, которые будут добавленны при инициализации
     * @return коллекция содержащая обьекты пространства
     */
    @Override
    protected ArrayList<SpaceObject> prepareSpace() {
        ArrayList<SpaceObject> spaceObjects = new ArrayList<>();
        spaceObjects.add(new EarthNE());
        spaceObjects.add(new SunNE());
        spaceObjects.add(new MoonNE());
        return spaceObjects;
    }
}
