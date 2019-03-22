package com.simulation.earth.manageSpace;

/**
 * Одна из реализаций Фабрики Космического пространства
 * Данная реализация позволяет создать пространство солнечной системы
 * и его параметры
 */
public class SolarSystemFactory implements FactorySpace {

    /**
     * Создание пространства солнечной системы
     * @return пространство
     */
    @Override
    public Space getSpace() {
        return new SunSpace();
    }

    /**
     * Создает параметры солнечной системы
     * @return параметры
     */
    @Override
    public ParametersSpace getParametersSpace() {
        return new ParametersSpaceSun();
    }
}
