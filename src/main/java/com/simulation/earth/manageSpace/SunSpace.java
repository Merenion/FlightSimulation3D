package com.simulation.earth.manageSpace;

import com.simulation.earth.spaceObjects.SpaceObject;

import java.util.ArrayList;

/**
 * Солнечное пространство.
 * имеет все методы пространства
 */
public class SunSpace extends Space{


    /**
     * Задает обьекты пространства по умолчанию, которые будут добавленны при инициализации
     * @return коллекция содержащая обьекты пространства
     */
    @Override
    protected ArrayList<SpaceObject> prepareSpace() {
        return null;
    }
}
