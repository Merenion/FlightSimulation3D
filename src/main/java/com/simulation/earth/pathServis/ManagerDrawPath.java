package com.simulation.earth.pathServis;

import com.simulation.earth.drawServis.Line;
import com.simulation.earth.drawServis.LineToManager;
import javafx.scene.Group;
import javafx.scene.Node;
import org.fxyz3d.geometry.Point3D;

public class ManagerDrawPath implements ServisDrawTrajectory {
    private Point3D oldPoint;
    private Point3D newPoint;
    private double distanceDrawLine=600;
    private LineToManager lineToManager = new LineToManager();
    private boolean limitTerms = true;
    private int maxNumberLine = 300;

    public ManagerDrawPath(float startX, float startY, float startZ) {
        oldPoint = new Point3D(startX,startY,startZ);
        newPoint = new Point3D(startX,startY,startZ);
        lineToManager.addCoordinat(startX,startY,startZ);
    }

    @Override
    public void addLineInPathIfNeeded (float newX, float newY, float newZ){
        newPoint.x=newX;
        newPoint.y=newY;
        newPoint.z=newZ;
        if (isLineNeeded(newX,newY,newZ)) {
            lineToManager.addCoordinat(newX, newY, newZ);
            oldPoint.x = newX;
            oldPoint.y = newY;
            oldPoint.z = newZ;
        }
        if (limitTerms)
            removeTail();
    }

    private void removeTail (){
        if (getPath().getChildren().size()>maxNumberLine)
            getPath().getChildren().remove(0);
    }

    @Override
    public Group getPath(){
        return  lineToManager.getPath();
    }

    @Override
    public boolean isLineNeeded (float newX, float newY, float newZ){
        double distance = Math.sqrt(Math.pow((oldPoint.x-newX),2)+Math.pow((oldPoint.y-newY),2)+Math.pow((oldPoint.z-newZ),2));
        return distance>distanceDrawLine;
    }

    @Override
    public Point3D getOldPoint() {
        return oldPoint;
    }

    @Override
    public void setOldPoint(Point3D oldPoint) {
        this.oldPoint = oldPoint;
    }

    @Override
    public Point3D getNewPoint() {
        return newPoint;
    }

    @Override
    public void setNewPoint(Point3D newPoint) {
        this.newPoint = newPoint;
    }

    @Override
    public double getDistanceDrawLine() {
        return distanceDrawLine;
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
    public LineToManager getLineToManager() {
        return lineToManager;
    }

    @Override
    public void clear() {
        lineToManager.getPath().getChildren().clear();
    }
}