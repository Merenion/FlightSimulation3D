package com.simulation.earth.trajectoryServis;

import com.simulation.earth.drawServis.LineTo3D;
import javafx.scene.Group;
import org.fxyz3d.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис рисования (используется для рисования орбит и различных траекторий)
 * Основан на последовательном добавлении прямых (наследника Node - LineTo) в 3D пространстве
 * Так же тут сохраняются координаты созданных прямых, благодаря чему можно обрезать хвост рисования
 * (реализованно для исключения перезаполнения памяти и уменьшения требований по производительности компьютера)
 */
public class ManagerDrawing implements Drawing {

    /**Предыдущая точка (чтобы знать откуда рисовать при добавлении новой точки)*/
    private Point3D oldPoint;
    /**новая точка которая добавляется в коллекцию и до нее рисуется линия*/
    private Point3D newPoint;
    /**необходимое растояние между добавленными точками, для того чтобы добавилась (отрисовалась) линия*/
    private double distanceDrawLine=600;
    /**LineTo На нем все основанно*/
    volatile private LineTo3D lineTo3D = new LineTo3D();
    /**включить или выключить обрезание хвоста*/
    private boolean limitTerms = true;
    /**максимальное количество прямых которые может хранить группа*/
    private int maxNumberLine = 300;
    /**хранит координаты построенных линий (начало и конец)*/
    volatile private List<Point3D> points = new ArrayList<>();

    /**инициализируем координаты первой точки по дефолту, они поменяются при первом же добавлении координат*/
    {
        oldPoint = new Point3D(0,0,0);
        newPoint = new Point3D(0,0,0);
    }

    /**начато ли рисование. true если заданна хоть одна точка*/
    private boolean starting =false;

    /**
     * Добавляет координаты точки до которой рисуется линия. если точка первая,
     * то она просто добавляется и ничего не рисуется.
     * @param newX координата X
     * @param newY координата Y
     * @param newZ координата Z
     */
    @Override
    public void addLineInPathIfNeeded (float newX, float newY, float newZ){
        newPoint.x=newX;
        newPoint.y=newY;
        newPoint.z=newZ;
        if (getPath().getChildren().size()==0 && !starting){
            oldPoint.x = newX;
            oldPoint.y = newY;
            oldPoint.z = newZ;
            lineTo3D.addCoordinats(newX, newY, newZ);
            points.add(new Point3D(newX,newY,newZ));
            starting = true;
        }
        if (isNeededDraw(newX,newY,newZ)) {
            lineTo3D.addCoordinats(newX, newY, newZ);
            points.add(new Point3D(newX,newY,newZ));
            oldPoint.x = newX;
            oldPoint.y = newY;
            oldPoint.z = newZ;
        }
        if (limitTerms)
            removeTail(newX, newY, newZ);
    }

    /**
     * метод удаления хвоста.
     * другими словами удаляет самую первую линию из коллекцию когда количество линий доходит до максимума.
     */
    private void removeTail (){
        if (getPath().getChildren().size()>maxNumberLine)
            getPath().getChildren().remove(0);
    }

    /**
     * метод удаления хвоста.
     * удаляет хвост если количтво линий привышает максимум или же если
     * дистанция конца (первого элемента коллекции) от последнего элемента меньше 2*distanceDrawLine
     * при этом условия не работают если количество элементов в коллекции меньше 10
     */
    private void removeTail (float newX, float newY, float newZ) {
        if (points.size()>10) {
            Point3D firstPoint = points.get(0);
            double distance = Math.sqrt(Math.pow((firstPoint.x - newX), 2) + Math.pow((firstPoint.y - newY), 2) + Math.pow((firstPoint.z - newZ), 2));
            if (getPath().getChildren().size() > maxNumberLine || distance < distanceDrawLine*2) {
                getPath().getChildren().remove(0);
                points.remove(0);
            }
        }
    }

    /**
     * Очищает LineTo, удаляя от туда вле линии, и очищает коллекцию координат этих линий
     */
    @Override
    public void clear() {
        lineTo3D.clear();
        points.clear();
        starting = false;
    }

    @Override
    public Group getPath(){
        return  lineTo3D;
    }

    /**
     * Определяет нужно ли рисовать линию по растоянию между старой точкой и новой
     * @param newX координата X
     * @param newY координата Y
     * @param newZ координата Z
     * @return нужно ли добавлять линию
     */
    @Override
    public boolean isNeededDraw(float newX, float newY, float newZ){
        double distance = Math.sqrt(Math.pow((oldPoint.x-newX),2)+Math.pow((oldPoint.y-newY),2)+Math.pow((oldPoint.z-newZ),2));
        return distance>distanceDrawLine;
    }

    public int getMaxNumberLine() {
        return maxNumberLine;
    }

    public void setMaxNumberLine(int maxNumberLine) {
        this.maxNumberLine = maxNumberLine;
    }

    @Override
    public void setDistanceDrawLine(double distanceDrawLine) {
        this.distanceDrawLine = distanceDrawLine;
    }

    public boolean isLimitTerms() {
        return limitTerms;
    }

    public void setLimitTerms(boolean limitTerms) {
        this.limitTerms = limitTerms;
    }

    @Override
    public LineTo3D getLineTo3D() {
        return lineTo3D;
    }
}