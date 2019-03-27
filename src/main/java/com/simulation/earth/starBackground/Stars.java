package com.simulation.earth.starBackground;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

/**
 * фон реализованный на стенках представляющих прямой параллепипед на который наложена текстура
 * Пространство находится внутри ящика
 */
public class Stars extends Background{

    /**расстояние от центра по дефолту*/
    private static double distance = 180_000_000;
    private static double wallSize = distance*2;

    /**
     * создаем стенки, поворачивая их определенным образом
     * @return ящик в котором длолжно находиться пространство для корректного отображения фона
     */
    @Override
    ArrayList<Node> prepareBackground() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(createWall(wallSize,new Translate(0,0,distance)));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance)));
        nodes.add(createWall(wallSize,new Translate(0,0,distance),new Point3D(0,1,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance),new Point3D(0,1,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,distance),new Point3D(1,0,0),90));
        nodes.add(createWall(wallSize,new Translate(0,0,-distance),new Point3D(1,0,0),90));
        return nodes;
    }

    /**
     * Подкачивает текстуры
     * @return параметры отображения объекта
     */
    private PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream(getPathTexture())));
        phongMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream(getPathTexture())));
        phongMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/earthMapNullReflection.jpg")));
        return phongMaterial;
    }

    /**
     * создание стенки
     * @param wallSize размер стенки (квадрат)
     * @param translate класс расположения стенки в пространстве
     * @param axis ось
     * @param angel угол на который развернуть относительно основной системы координат
     * @return cntyrf
     */
    private Node createWall (double wallSize, Translate translate, Point3D axis, int angel) {
        Box top = new Box();
        top.setRotationAxis(axis);
        top.setRotate(angel);
        top.setDepth(1000);
        top.setHeight(wallSize);
        top.setWidth(wallSize);
        top.setMaterial(prepareMaterial());
        top.getTransforms().add(translate);
        return top;
    }

    /**
     * упрощенное создание стенки
     * @param wallSize размер стенки (квадрат)
     * @param translate (расположение стенки в пространстве)
     * @return стенка
     */
    private Node createWall (double wallSize, Translate translate) {
        return createWall(wallSize, translate,new Point3D(0,0,0),0);
    }


}
