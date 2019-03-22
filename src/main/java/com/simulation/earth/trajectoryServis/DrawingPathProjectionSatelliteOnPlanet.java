package com.simulation.earth.trajectoryServis;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class DrawingPathProjectionSatelliteOnPlanet implements DrawingPath {

    private AnimationTimer listenerChangeCoordinatesProjection;
    private Drawing managerDrawPathProjection = new ManagerDrawing();
    private Translate orientationSatelite;
    private PlanetOrStart planet;

    public DrawingPathProjectionSatelliteOnPlanet(PlanetOrStart planet, Translate orientationSatelite, Color colorTrajectory) {
        this.planet = planet;
        this.orientationSatelite = orientationSatelite;
        initThreadDrawingProjection();
        managerDrawPathProjection.getLineTo3D().setColor(colorTrajectory);
        managerDrawPathProjection.getLineTo3D().setWidth(23);
        managerDrawPathProjection.setDistanceDrawLine(15);
        managerDrawPathProjection.setMaxNumberLine(150);
        managerDrawPathProjection.setLimitTerms(true);
    }

    public DrawingPathProjectionSatelliteOnPlanet(PlanetOrStart planet, Translate orientationSatelite, Color colorTrajectory, int maxLengthTrajectory) {
        this.planet = planet;
        this.orientationSatelite = orientationSatelite;
        initThreadDrawingProjection();
        managerDrawPathProjection.getLineTo3D().setColor(colorTrajectory);
        managerDrawPathProjection.getLineTo3D().setWidth(23);
        managerDrawPathProjection.setDistanceDrawLine(27);
        managerDrawPathProjection.setMaxNumberLine(maxLengthTrajectory);
        managerDrawPathProjection.setLimitTerms(true);
    }

    private void initThreadDrawingProjection() {
        listenerChangeCoordinatesProjection = new AnimationTimer() {
            private float obsoleteX;
            private float obsoleteZ;
            private float obsoleteY;
            @Override
            public void handle(long now) {
                float coeff = (float) getCoefficientNecessaryDistance(new Point3D(orientationSatelite.getX(),orientationSatelite.getY(),orientationSatelite.getZ()),planet.getRadiusPlanet()+10);
                float orientationX = (float) (orientationSatelite.getX()*coeff);
                float orientationY = (float) (orientationSatelite.getY()*coeff);
                float orientationZ = (float) (orientationSatelite.getZ()*coeff);
                if ((obsoleteX!=orientationX || obsoleteY!=orientationY || obsoleteZ!=orientationZ)
                        && (obsoleteX!=0 || obsoleteY!=0 || obsoleteZ!=0)) {
                    managerDrawPathProjection.addLineInPathIfNeeded(orientationX,orientationY,orientationZ);
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
                managerDrawPathProjection.clear();
                super.start();
            }
        };
        managerDrawPathProjection.getPath().getTransforms().addAll(planet.getRotateX(),planet.getRotateY(),planet.getRotateZ());
        planet.getSpaceModel().getChildren().add(managerDrawPathProjection.getPath());
    }

    private void performSetRotateToPlanetInLastLineProjection (PlanetOrStart planet){
        Group path = managerDrawPathProjection.getPath();
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

    private double getDistanceToCenter(Point3D point3D) {
        return Math.sqrt(Math.pow(point3D.getX(),2)+Math.pow(point3D.getY(),2)+Math.pow(point3D.getZ(),2));
    }

    private double getCoefficientNecessaryDistance(Point3D point3D, double necessaryDistance) {
        double distance =  getDistanceToCenter(point3D);
        return necessaryDistance/distance;
    }

    @Override
    public void stopDrawTrajectories() {
        listenerChangeCoordinatesProjection.stop();
    }

    @Override
    public void startDrawTrajectories() {
        listenerChangeCoordinatesProjection.start();
    }

    @Override
    public Drawing getServisDrawTrajectories() {
        return managerDrawPathProjection;
    }

    @Override
    public void removeTrajectory() {
        managerDrawPathProjection.clear();
    }
}
