package com.simulation.earth.trajectoryServis;

import com.simulation.earth.drawServis.LineTo3D;
import javafx.scene.Group;
import org.fxyz3d.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class ManagerDrawing implements Drawing {
    private Point3D oldPoint;
    private Point3D newPoint;
    private double distanceDrawLine=600;
    volatile private LineTo3D lineTo3D = new LineTo3D();
    private boolean limitTerms = true;
    private int maxNumberLine = 300;
    volatile private List<Point3D> points = new ArrayList<>();

    public ManagerDrawing(float startX, float startY, float startZ) {
        oldPoint = new Point3D(startX,startY,startZ);
        newPoint = new Point3D(startX,startY,startZ);
    }

    public ManagerDrawing() {
        oldPoint = new Point3D(0,0,0);
        newPoint = new Point3D(0,0,0);
    }

    private boolean starting =false;
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

    private void removeTail (){
        if (getPath().getChildren().size()>maxNumberLine)
            getPath().getChildren().remove(0);
    }

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

    @Override
    public Group getPath(){
        return  lineTo3D;
    }

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

    @Override
    public void clear() {
        lineTo3D.clear();
        points.clear();
        starting = false;
    }
}