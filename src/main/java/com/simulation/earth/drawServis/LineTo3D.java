package com.simulation.earth.drawServis;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

/**
 * Класс определяющий цепочку линий в 3D пространстве
 * использует Line и FactoryLine.
 * Реализованно на основе Group с добавлением
 * прямых.
 */
public class LineTo3D extends Group implements LineTo {
    /**Цвет*/
    private Color color = Color.WHITE;
    /**Ширина линии*/
    private float width = 50;
    /**Устаревшая точка, используется для рисования. От этой и до следующей точки рисуется прямая*/
    private Point3D lastAdded;
    private FactoryLine factoryLine = new CreaterLine3Ddefault();

    /**
     * Метод для добавления новой точки до которой будет нарисована линия
     * (если она не первая). Если точка первая (задана первый раз)
     * то она автоматически становится #lastAdded
     * @param x координата X новой точки
     * @param y координата Y новой точки
     * @param z координата Z новой точки
     */
    public void addCoordinats(float x, float y, float z){
        Point3D newPoint = new Point3D(x,y,z);
        if (lastAdded == null) {
            lastAdded = newPoint;
        } else {
            getChildren().add((Line3D) factoryLine.createLine(lastAdded,newPoint,width,color));
            lastAdded = newPoint;
        }
    }

    /**
     * Изменяет масштаб ширины прямой
     * @param coefficient коэффициент на который будет
     * домноженно значение ширины линии
     */
    public void changeScaleLines(float coefficient){
        for (Node line : getChildren()){
            if (line instanceof Line)
                ((Line)line).changeScaleWidth(coefficient);
        }
    }

    /**
     * Удаляет все линии из группы.
     */
    public void clear () {
        getChildren().clear();
        lastAdded = null;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        for (Node node: getChildren())
            ((Line) node).setColor(color);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        for (Node node: getChildren())
            ((Line) node).setWidth(width);
    }
}
