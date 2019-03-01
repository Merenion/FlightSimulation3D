package com.simulation.earth.drawServis;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;
import org.fxyz3d.shapes.composites.PolyLine3D;

import java.util.Arrays;

public class Line3D extends Group implements Line {

    private Point3D startingCoordinat;
    private Point3D endCoordinat;
    private PolyLine3D line2DVertical;
    private PolyLine3D line2DGorizontal;
    private float width = 50;
    private Color color = Color.WHITE;

    public Line3D(Point3D startingCoordinat, Point3D endCoordinat) {
        this.startingCoordinat = startingCoordinat;
        this.endCoordinat = endCoordinat;
        init2DLines();
    }

    public Line3D(Point3D startingCoordinat, Point3D endCoordinat, float width, Color color) {
        this.startingCoordinat = startingCoordinat;
        this.endCoordinat = endCoordinat;
        this.width = width;
        this.color = color;
        init2DLines();
    }

    private void init2DLines(){
        line2DGorizontal = new PolyLine3D(Arrays.asList(startingCoordinat, endCoordinat),width,color,PolyLine3D.LineType.RIBBON);
        line2DVertical = new PolyLine3D(Arrays.asList(startingCoordinat, endCoordinat),width*2.3f,color, PolyLine3D.LineType.TRIANGLE);
        getChildren().addAll(line2DGorizontal,line2DVertical);
    }

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
