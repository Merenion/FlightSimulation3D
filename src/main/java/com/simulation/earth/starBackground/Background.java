package com.simulation.earth.starBackground;

import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;

/**
 * Абстрактный класс для работы с фоном
 * Фон реализовывается путем создания обьектов вокруг пространства
 * и наложения на них текстуры
 */
public abstract class Background {

    /**путь к текстурам для фона (задан фон по умолчанию)*/
    private String pathTexture = "/texturs/starsBackground/starBackground.jpg";
    /**масштаб фона (отдаляет фон от центра)*/
    private float scale = 1;

    /**
     * Группа содержащая фон
     */
    private Group group = new Group();

    /**
     * инициализация фона
     */
    {
        group.getChildren().addAll(prepareBackground());
    }

    /**
     * метод позволяющий инициализировать обьекты для фона, автоматически
     * запихивает их в группу фона
     * @return коллекция обьекто
     */
    abstract ArrayList<Node> prepareBackground ();

    public float getScale() {
        return scale;
    }

    /**
     * задает масштаб модели фона по всем координатам
     * @param scale масштаб
     */
    public void setScale(float scale) {
        this.scale = scale;
        group.setScaleX(scale);
        group.setScaleY(scale);
        group.setScaleZ(scale);
    }

    public String getPathTexture() {
        return pathTexture;
    }

    public void setPathTexture(String pathTexture) {
        this.pathTexture = pathTexture;
    }

    public Group getGroup() {
        return group;
    }
}
