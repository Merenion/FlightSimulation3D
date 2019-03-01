package com.simulation.earth.drawServis;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

public class LineToManager implements LineServis{
    private Group lines = new Group();
    private Color color = Color.WHITE;
    private float width = 50;
    private Point3D lastAdded;
    private FactoryLine factoryLine = new CreaterLine3Ddefault();


    public void addCoordinat (float x, float y, float z){
        Point3D newPoint = new Point3D(x,y,z);
        if (lastAdded == null) {
            lastAdded = newPoint;
        } else {
            lines.getChildren().add((Node) factoryLine.createLine(lastAdded,newPoint,width,color));
            lastAdded = newPoint;
        }
    }

    public void changeScaleTrajectory (float coefficient){
        for (Node line : lines.getChildren()){
            if (line instanceof Line)
                ((Line)line).changeScaleWidth(coefficient);
        }
    }

    public Group getPath() {
        return lines;
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
