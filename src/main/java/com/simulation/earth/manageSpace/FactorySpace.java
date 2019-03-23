package com.simulation.earth.manageSpace;

/**
 * интерфейс для работы с фабрикой. Фабрика создания Космического пространства и его параметров
 * Главный интерфейс абстрактной фабрики
 */
public interface FactorySpace {
    Space getSpace();
    ParametersSpace getParametersSpace ();
}
