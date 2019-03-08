package com.simulation.earth.simulationProcessing;

import com.simulation.earth.manageSpace.Space;
import javafx.animation.AnimationTimer;

import java.util.Date;

public class DefaultSimulation implements ISimulation {
    private double deltaTime = 0.1f;
    private double timeSimulation;
    private double startTime;
    private AnimationTimer timer;
    private boolean runningProcess = false;
    private boolean drawPath = false;

    @Override
    public double getTimeSimulation() {
        return timeSimulation;
    }

    @Override
    public double getDeltaTime() {
        return deltaTime;
    }

    @Override
    public void setDeltaTime(double delta) {
        deltaTime = delta;
    }

    @Override
    public void enableSimulation(Space space) {
        if (!runningProcess) {
            runningProcess = true;
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    timeSimulation += deltaTime;
                    space.movementObjects(timeSimulation);
                }
            };
            timer.start();
        }
    }

    @Override
    public void stopSimulation() {
        if (runningProcess && timer != null) {
            timer.stop();
            runningProcess = false;
        }
    }

    @Override
    public void resetSimulation(Space space) {
        space.prepareStartCoordinatForObjects(startTime);
        timeSimulation =startTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }
}
