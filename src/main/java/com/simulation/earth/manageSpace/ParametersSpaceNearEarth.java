package com.simulation.earth.manageSpace;

import javafx.scene.image.Image;

/**
 * Параметры околоземного пространсва
 */
public class ParametersSpaceNearEarth extends ParametersSpace {

    /**
     * инициализация параметров камеры для околоземного пространства
     */
    @Override
    protected void prepareSpace() {
        nearClip = 1000;
        farClip = 400_000_000;
    }
}
