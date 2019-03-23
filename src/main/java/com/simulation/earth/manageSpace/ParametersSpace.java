package com.simulation.earth.manageSpace;

import javafx.scene.image.Image;

/**
 * Класс отдающий различные параметры пространства
 */
public abstract class ParametersSpace {

    /*
    использует абстрактный метод подготовки параметров пространства
     */
    {
        prepareSpace();
    }

    /**наиближайшее растояние от свободной камеры на котором будут отображаться обьекты*/
    protected double nearClip;
    /**максимальное растояние от камеры на котором будут видны обьекты*/
    protected double farClip;

    public double getNearClip() {
        return nearClip;
    }

    public double getFarClip() {
        return farClip;
    }

    protected abstract void prepareSpace();
}
