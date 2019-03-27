package com.simulation.earth.manageSpace;

import com.simulation.earth.spaceObjects.*;
import com.simulation.earth.spaceObjects.EarthNE;
import com.simulation.earth.spaceObjects.MoonNE;
import com.simulation.earth.spaceObjects.SunNE;

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
