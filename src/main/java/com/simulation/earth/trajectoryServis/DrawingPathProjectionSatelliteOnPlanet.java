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

/**
 * Класс предназначен для рисования пройденного пути подспутниковой точкой.
 * Рисует путь и при этом не нужно добавлять новые точки.
 * Сервис следит за изменением координат и автоматически рисует путь
 * при соответствующем изменении.
 */
public class DrawingPathProjectionSatelliteOnPlanet implements DrawingPath {


    /**Класс запускает поток, который следит за изменением координат (слушатель)*/
    private AnimationTimer listenerChangeCoordinatesProjection;
    /**Сервис позволяющий рисовать LineTo с дополнительными функциями*/
    private Drawing managerDrawPathProjection = new ManagerDrawing();
    /**Содержит координаты какого либо обьекта, за изменением которых идет слежение*/
    private Translate orientationSatelite;
    /**планета с которой берется радиус и углы поворота (для поворота нарисованного пути вместе с землей)*/
    private PlanetOrStart planet;

    /**
     * Конструктор для получения необходимых параметров
     * @param planet планета на которую проецируется подспутниковая точка
     * @param orientationSatelite класс хранящий координаты (в нем же они изменяются)
     * @param colorTrajectory цвет траектории
     */
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

    /**
     *
     * @param planet планета на которую проецируется подспутниковая точка
     * @param orientationSatelite класс хранящий координаты (в нем же они изменяются)
     * @param colorTrajectory цвет траектории
     * @param maxLengthTrajectory максимальная длина пути, после заполнения обрезается хвост
     */
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

    /**
     * Метод запускает слушателя за координатами, который автоматически рисует
     * при их изменении, если не выполняются определенные условия (растояние между координатами и другое)
     * то не рисует. Когда используется этот метод, сбрасывается весь нарисованый путь
     */
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

    /**
     * Метод задает каждому элементу пути (прямые из которых состоит путь)
     * поворот такой же как и у земли
     * @param planet
     */
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

    /**
     * дистанция от спутника до центра
     * @param point3D точка содержащая координаты от которых
     *                просчитывается расстояние
     * @return расстояние
     */
    private double getDistanceToCenter(Point3D point3D) {
        return Math.sqrt(Math.pow(point3D.getX(),2)+Math.pow(point3D.getY(),2)+Math.pow(point3D.getZ(),2));
    }

    /**
     * сравнивает заданое растояние и растояние от заданной точки до центра
     * и выдает коэффициент определяющий на сколько заданное растояние больше
     * расчитанной дистанции точки до центра
     * @param point3D точка от которой определяется растояние до центра (0,0,0)
     * @param necessaryDistance сравниваемое растояние
     * @return коэффициент разности
     */
    private double getCoefficientNecessaryDistance(Point3D point3D, double necessaryDistance) {
        double distance =  getDistanceToCenter(point3D);
        return necessaryDistance/distance;
    }

    /**
     * останавливает слушатель (рисование)
     */
    @Override
    public void stopDrawTrajectories() {
        listenerChangeCoordinatesProjection.stop();
    }

    /**
     * Стартует слушатель (рисование) при этом весь нарисованный путь ранее стирается
     */
    @Override
    public void startDrawTrajectories() {
        listenerChangeCoordinatesProjection.start();
    }

    @Override
    public Drawing getServisDrawTrajectories() {
        return managerDrawPathProjection;
    }

    /**
     * удаляет весь нарисованный путь
     */
    @Override
    public void removeTrajectory() {
        managerDrawPathProjection.clear();
    }
}
