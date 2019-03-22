package com.simulation.earth.drawServis;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;
import org.fxyz3d.shapes.composites.PolyLine3D;

import java.util.Arrays;

/**
 * Прямая применимая в 3D пространстве
 * реализована на основе двух ортогональных прямых на плоскости с заданным поворотом
 * которые добавляются в группу.
 * Для создания прямой в 3D пространстве используется библиотека "fxyz3d"
 * Используется как обычный Node
 */
public class Line3D extends Group implements Line {

    /**Координата начала линии*/
    private Point3D startingCoordinat;
    /**Координата конца линии*/
    private Point3D endCoordinat;
    /**Вертикальная 2D линия*/
    private PolyLine3D line2DVertical;
    /**Горизонтальная 2D линия*/
    private PolyLine3D line2DGorizontal;
    /**Ширина прямой*/
    private float width = 50;
    /** цвет линии*/
    private Color color = Color.WHITE;

    /**
     * @param startingCoordinat стартовые координаты
     * @param endCoordinat конечные координаты
     */
    public Line3D(Point3D startingCoordinat, Point3D endCoordinat) {
        this.startingCoordinat = startingCoordinat;
        this.endCoordinat = endCoordinat;
        init2DLines();
    }

    /**
     * @param startingCoordinat стартовые координаты
     * @param endCoordinat конечные координаты
     * @param width ширина
     * @param color цвет
     */
    public Line3D(Point3D startingCoordinat, Point3D endCoordinat, float width, Color color) {
        this.startingCoordinat = startingCoordinat;
        this.endCoordinat = endCoordinat;
        this.width = width;
        this.color = color;
        init2DLines();
    }

    /**
     * Создание горизонтальной и вертикальной прямой
     * и добавление их в Группу
     */
    private void init2DLines(){
        line2DGorizontal = new PolyLine3D(Arrays.asList(startingCoordinat, endCoordinat),width,color,PolyLine3D.LineType.RIBBON);
        line2DVertical = new PolyLine3D(Arrays.asList(startingCoordinat, endCoordinat),width*2.3f,color, PolyLine3D.LineType.TRIANGLE);
        getChildren().addAll(line2DGorizontal,line2DVertical);
    }

    /**
     * Удаление из группы вертикальной и горизонтальной линии
     * и добвыление их заного обновленными @see #init2DLines()
     */
    private void refresh2dLines () {
        getChildren().remove(line2DGorizontal);
        getChildren().remove(line2DVertical);
        init2DLines();
    }

    @Override
    public Point3D getStartingCoordinat() {
        return startingCoordinat;
    }

    @Override
    public Point3D getEndCoordinat() {
        return endCoordinat;
    }

    @Override
    public void setStartingCoordinat(Point3D point3D) {
        startingCoordinat = point3D;
        refresh2dLines();
    }

    @Override
    public void setEndCoordinat(Point3D point3D) {
        endCoordinat = point3D;
        refresh2dLines();
    }


    @Override
    public void changeScaleWidth(float coefficient) {
        width = width*coefficient;
        refresh2dLines();
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
        refresh2dLines();
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
        refresh2dLines();
    }
}
