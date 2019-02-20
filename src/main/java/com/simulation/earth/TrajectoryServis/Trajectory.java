package com.simulation.earth.TrajectoryServis;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;
import org.fxyz3d.shapes.composites.PolyLine3D;
import java.util.ArrayList;
import java.util.List;

public class Trajectory {
    private List<Point3D> points = new ArrayList<>();
    private Color color;
    private float width = 50;



    public void addCoordinat (float x, float y, float z){
        points.add(new Point3D(x,y,z));
    }

    public PolyLine3D getTrajectory () {
        return new PolyLine3D(points,width,Color.ALICEBLUE, PolyLine3D.LineType.RIBBON);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
