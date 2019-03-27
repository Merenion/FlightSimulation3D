package com.simulation.earth.trajectoryServis;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;

/**
 * Класс предназначен для рисования орбиты.
 * Рисует орбиту и при этом не нужно добавлять новые точки.
 * Сервис следит за изменением координат и автоматически рисует орбиту
 * при соответствующем изменении.
 */
public class DrawingOrbitOfSatellite implements DrawingPath {

    /**Класс запускает поток, который следит за изменением координат (слушатель)*/
    private AnimationTimer listenerChangeCoordinates;
    /**Содержит координаты какого либо обьекта, за изменением которых идет слежение*/
    private Translate orientation;
    /**Сервис позволяющий рисовать LineTo с дополнительными функциями*/
    private Drawing managerDrawingOfTrajectory = new ManagerDrawing();

    /**
     * конструктор позволяет получить необходимые параметры для работы
     * @param groupTrajectory группа куда сохраняется траектория (траектория - Node)
     * @param orientation   класс хранящий координаты (в нем же они изменяются)
     * @param colorTrajectory цвет траектории
     * @param maxLengthOrbit    максимальная длина пути, после заполнения обрезается хвост
     */
    public DrawingOrbitOfSatellite(Group groupTrajectory, Translate orientation, Color colorTrajectory, int maxLengthOrbit) {
        this.orientation = orientation;
        groupTrajectory.getChildren().add(managerDrawingOfTrajectory.getPath());
        initThreadDrawingTrajectory();
        managerDrawingOfTrajectory.setDistanceDrawLine(500);
        managerDrawingOfTrajectory.setMaxNumberLine(maxLengthOrbit);
        managerDrawingOfTrajectory.getLineTo3D().setColor(colorTrajectory);
    }

    /**
     * Метод запускает слушателя за координатами, который автоматически рисует
     * при их изменении, если не выполняются определенные условия (растояние между координатами и другое)
     * то не рисует. Когда используется этот метод, сбрасывается весь нарисованый путь
     */
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

    /**
     * Стартует слушатель (рисование) при этом весь нарисованный путь ранее стирается
     */
    @Override
    public void startDrawTrajectories() {
        listenerChangeCoordinates.start();
    }

    /**
     * останавливает слушатель (рисование)
     */
    @Override
    public void stopDrawTrajectories() {
        listenerChangeCoordinates.stop();
    }

    @Override
    public Drawing getServisDrawTrajectories() {
        return managerDrawingOfTrajectory;
    }

    /**
     * удаляет весь нарисованный путь
     */
    @Override
    public void removeTrajectory() {
        managerDrawingOfTrajectory.clear();
    }
}
