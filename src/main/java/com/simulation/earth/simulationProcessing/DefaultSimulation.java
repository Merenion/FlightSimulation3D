package com.simulation.earth.simulationProcessing;

import com.simulation.earth.manageSpace.Space;
import javafx.animation.AnimationTimer;

import java.util.Date;

public class DefaultSimulation implements ISimulation {
    private float deltaTime = 0.1f;
    private double timeSimulation;
    private AnimationTimer timer;
    private boolean runningProcess = false;
    private boolean drawPath = false;

    @Override
    public double getTimeSimulation() {
        return timeSimulation;
    }

    @Override
    public float getDeltaTime() {
        return deltaTime;
    }

    @Override
    public void setDeltaTime(float delta) {
        deltaTime = delta;
    }

    @Override
    public void enableSimulation(Space space) {
        if (!runningProcess) {
            runningProcess = true;
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    space.movementObjects(deltaTime);
                    timeSimulation += deltaTime;
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
    public void resetSimulation(Space space, Date data) {
        space.prepareStartCoordinatForObjects(data);
        timeSimulation =0;
    }
}
