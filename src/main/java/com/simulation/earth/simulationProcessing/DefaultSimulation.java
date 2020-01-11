package com.simulation.earth.simulationProcessing;

import com.simulation.earth.manageSpace.Space;
import javafx.animation.AnimationTimer;

import java.util.Date;

/**
 * Класс реализующий симуляцию пространства по времени
 */
public class DefaultSimulation implements ISimulation {

    /**дельта на которую менется общий счетчик времени.
     * Через этот шаг перемещаются обьекты при симуляции (используя математические модели перемещения)
     * если он больше то и обьекты будут передвигаться с большим шагом*/
    private double deltaTime = 0.1f;
    /**общий счетчик времени симуляции*/
    private double timeSimulation =1;
    /**стартовое время с которого запускается поток симуляции*/
    private double startTime=1;
    /**Класс для управления потоком симуляции, работает с частотой обновления кадров*/
    private AnimationTimer timer;
    /**запущена ли симуляция*/
    private boolean runningProcess = false;

    /**
     * врубает симуляцию пространства если она еще не запущена.
     * Перемещение обьектов зависит от deltaTime
     * @param space пространство содержащее обьекты с заданными моделями перемещения
     */
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

    /**
     * останавливает симуляцию если она включена
     */
    @Override
    public void stopSimulation() {
        if (runningProcess && timer != null) {
            timer.stop();
            runningProcess = false;
        }
    }

    /**сбрасывает все счетчики и устанавливает модели в стартовое время*/
    @Override
    public void resetSimulation(Space space) {
        space.prepareStartCoordinatForObjects(startTime);
        timeSimulation =startTime;
    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

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
}
