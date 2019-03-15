package com.simulation.earth.trajectoryServis;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;

public class DrawingOrbitOfSatellite implements DrawingTrajectory{

    private AnimationTimer listenerChangeCoordinates;
    private Translate orientation;
    private Drawing managerDrawingOfTrajectory = new ManagerDrawing();
    private Group groupTrajectory;

    public DrawingOrbitOfSatellite(Group groupTrajectory, Translate orientation, Color colorTrajectory, int maxLengthOrbit) {
        this.orientation = orientation;
        this.groupTrajectory = groupTrajectory;
        groupTrajectory.getChildren().add(managerDrawingOfTrajectory.getPath());
        initThreadDrawingTrajectory();
        managerDrawingOfTrajectory.setMaxNumberLine(maxLengthOrbit);
        managerDrawingOfTrajectory.getLineToManager().setColor(colorTrajectory);
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
