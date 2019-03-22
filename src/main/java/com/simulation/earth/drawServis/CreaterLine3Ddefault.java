package com.simulation.earth.drawServis;


import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

/**
 * Реализация фабрики. Пораждает простые обьекты рисования связанные с Линиями
 */
public class CreaterLine3Ddefault implements FactoryLine{

    /**
     * Создает Линию в 3D пространстве
     * @param point1 точка начала линии
     * @param point2 точка конца линии
     * @param width ширина линии
     * @param color цвет линии
     * @return готовая линия
     */
    @Override
    public Line createLine(Point3D point1, Point3D point2, float width, Color color) {
        return new Line3D(point1,point2,width,color);
    }

    /**
     * Создает Линию которую можно продолжать другими линиями, добавляя координаты
     * @return
     */
    @Override
    public LineTo creteLineTo() {
        return new LineTo3D();
    }


}
