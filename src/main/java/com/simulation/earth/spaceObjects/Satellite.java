package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.ParametrsOrbit;
import com.simulation.earth.pathServis.ManagerDrawPath;
import com.simulation.earth.pathServis.ServisDrawTrajectory;
import javafx.animation.AnimationTimer;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public abstract class Satellite extends ObjectWithCamera{
    private ParametrsOrbit parametrsOrbit;
    private ServisDrawTrajectory servisDrawPathProjection = new ManagerDrawPath();
    private AnimationTimer listenerChangeCoordinatesProjection;
    private boolean runlistenerChangeCoordinatesProjection = false;

    {
        servisDrawPathProjection.getLineToManager().setColor(Color.GREEN);
        servisDrawPathProjection.getLineToManager().setWidth(23);
        servisDrawPathProjection.setDistanceDrawLine(7);
        servisDrawPathProjection.setMaxNumberLine(200);
        servisDrawPathProjection.setLimitTerms(true);
    }

    public void initProjection (PlanetOrStart planet) {
        listenerChangeCoordinatesProjection = new AnimationTimer() {
            private float obsoleteX;
            private float obsoleteZ;
            private float obsoleteY;
            @Override
            public void handle(long now) {
                float coeff = (float) getCoefficientNecessaryDistance(new Point3D(orientation.getX(),orientation.getY(),orientation.getZ()),planet.getRadiusPlanet()+10);
                float orientationX = (float) (orientation.getX()*coeff);
                float orientationY = (float) (orientation.getY()*coeff);
                float orientationZ = (float) (orientation.getZ()*coeff);
                if ((obsoleteX!=orientationX || obsoleteY!=orientationY || obsoleteZ!=orientationZ)
                        && (obsoleteX!=0 || obsoleteY!=0 || obsoleteZ!=0)) {
                    servisDrawPathProjection.addLineInPathIfNeeded(orientationX,orientationY,orientationZ);
                    performSetRotateToPlanetInLastLineProjection(planet);
                }
                obsoleteY = orientationY;
                obsoleteX = orientationX;
                obsoleteZ = orientationZ;
            }
            @Override
            public void start() {
                obsoleteX =0;
                obsoleteZ =0;
                obsoleteY =0;
                servisDrawPathProjection.clear();
                super.start();
            }
        };
        if (runlistenerChangeCoordinatesProjection)
            listenerChangeCoordinatesProjection.start();
        servisDrawPathProjection.getPath().getTransforms().addAll(planet.rotateX,planet.rotateY,planet.rotateZ);
        planet.getSpaceModel().getChildren().add(servisDrawPathProjection.getPath());
    }

    public boolean isRunlistenerChangeCoordinatesProjection() {
        return runlistenerChangeCoordinatesProjection;
    }

    private void performSetRotateToPlanetInLastLineProjection (PlanetOrStart planet){
        Group path = servisDrawPathProjection.getPath();
        if (path.getChildren().size()!=0) {
            ObservableList<Transform> transformLastLine = path.getChildren().get(path.getChildren().size() - 1).getTransforms();
            if (transformLastLine.size()>0)
                transformLastLine.clear();
            transformLastLine.addAll(new Rotate(-planet.getRotateX().getAngle(), planet.getRotateX().getAxis()),
                     new Rotate(-planet.getRotateY().getAngle(), planet.getRotateY().getAxis()),
                    new Rotate(-planet.getRotateZ().getAngle(), planet.getRotateZ().getAxis())
            );
        }
    }

    public Group getProjectionPathAtPlanet (){
        return servisDrawPathProjection.getPath();
    }

    public void drawProjectionOfTrajectories(boolean runlistenerChangeCoordinatesProjection) {
        if (listenerChangeCoordinatesProjection!=null){
            if (runlistenerChangeCoordinatesProjection)
                listenerChangeCoordinatesProjection.start();
            else
                listenerChangeCoordinatesProjection.stop();
        }
        this.runlistenerChangeCoordinatesProjection = runlistenerChangeCoordinatesProjection;
    }

    private double getDistanceToCenter(Point3D point3D) {
        return Math.sqrt(Math.pow(point3D.getX(),2)+Math.pow(point3D.getY(),2)+Math.pow(point3D.getZ(),2));
    }

    private double getCoefficientNecessaryDistance(Point3D point3D, double necessaryDistance) {
        double distance =  getDistanceToCenter(point3D);
        return necessaryDistance/distance;
    }

    private Group getPathProjection () {
        return servisDrawPathProjection.getPath();
    }

    public Satellite(ParametrsOrbit parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }

    public Satellite(){};

    public ParametrsOrbit getParametrsOrbit() {
        return parametrsOrbit;
    }

    public void setParametrsOrbit(ParametrsOrbit parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }

}
