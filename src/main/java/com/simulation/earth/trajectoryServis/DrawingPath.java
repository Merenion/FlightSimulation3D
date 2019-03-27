package com.simulation.earth.trajectoryServis;

/**
 * интерфейс рисования различных траекторий
 * (все необходимые параметры передаются через конструктор реализации)
 */
public interface DrawingPath {
    void startDrawTrajectories();
    void stopDrawTrajectories();
    Drawing getServisDrawTrajectories();
    void removeTrajectory();
}
