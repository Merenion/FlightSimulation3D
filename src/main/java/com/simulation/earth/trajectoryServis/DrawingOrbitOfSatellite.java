package com.simulation.earth.trajectoryServis;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;

public class DrawingOrbitOfSatellite implements DrawingPath {

    private AnimationTimer listenerChangeCoordinates;
    private Translate orientation;
    private Drawing managerDrawingOfTrajectory = new ManagerDrawing();

    public DrawingOrbitOfSatellite(Group groupTrajectory, Translate orientation, Color colorTrajectory, int maxLengthOrbit) {
        this.orientation = orientation;
        groupTrajectory.getChildren().add(managerDrawingOfTrajectory.getPath());
        initThreadDrawingTrajectory();
        managerDrawingOfTrajectory.setDistanceDrawLine(500);
        managerDrawingOfTrajectory.setMaxNumberLine(maxLengthOrbit);
        managerDrawingOfTrajectory.getLineTo3D().setColor(colorTrajectory);
    }

    private void initThreadDrawingTrajectory() {
        listenerChangeCoordinates = new AnimationTimer() {
            private double obsoleteX;
            private double obsoleteY;
            private double obsoleteZ;
            @Override
            public void handle(long now) {
                if ((obsoleteX!=orientation.getX() || obsoleteY!=orientation.getY() || obsoleteZ!=orientation.getZ())
                        && (obsoleteX!=0 || obsoleteY!=0 || obsoleteZ!=0))
                    managerDrawingOfTrajectory.addLineInPathIfNeeded((float) orientation.getX(), (float) orientation.getY(), (float) orientation.getZ());
                obsoleteX = orientation.getX();
                obsoleteY = orientation.getY();
                obsoleteZ = orientation.getZ();
            }
            @Override
            public void start() {
                managerDrawingOfTrajectory.clear();
                obsoleteX =0;
                obsoleteY =0;
                obsoleteZ =0;
                super.start();
            }
        };
    }

    @Override
    public void startDrawTrajectories() {
        listenerChangeCoordinates.start();
    }

    @Override
    public void stopDrawTrajectories() {
        listenerChangeCoordinates.stop();
    }

    @Override
    public Drawing getServisDrawTrajectories() {
        return managerDrawingOfTrajectory;
    }

    @Override
    public void removeTrajectory() {
        managerDrawingOfTrajectory.clear();
    }
}
