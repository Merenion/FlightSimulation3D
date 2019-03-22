package com.simulation.earth.manageSpace;

/**
 * Одна из реализаций Фабрики Космического пространства
 * Данная реализация позволяет создать околоземное пространство
 * и его параметры
 */
public class NearEarthFactory implements FactorySpace {

    /**
     * Создание околоземного пространства
     * @return пространство
     */
    @Override
    public Space getSpace() {
        return new NearEarthSpace();
    }

    /**
     * Создает параметры околоземного пространства
     * @return параметры
     */
    @Override
    public ParametersSpace getParametersSpace() {
        return new ParametersSpaceNearEarth();
    }
}
