package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.Satellite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;

import java.util.ArrayList;

/**
 * Абстрактный класс реализующий основные методы управления спутниками
 */
public abstract class DefaultManageSatellite implements ManageSatellite{

    /**Колекция для хранения всех созданных спутников*/
    protected ObservableList<Satellite> satellites = FXCollections.observableArrayList();

    /**
     * Возвращает все спутники
     * @return коллекция спутников
     */
    @Override
    public ObservableList<Satellite> getAllSatelites() {
        return satellites;
    }

    /**
     * изменяет масштаб модели спутника
     * @param scale необходимый масштаб
     */
    @Override
    public void changeScaleSatellites(float scale) {
        for (Satellite satellite :satellites)
            satellite.changeScaleModel(scale);
    }

    /**
     * Включение прорисовки орбиты движения всех спутников
     * @param homeGroup Группа в которую будет сохранена орбита
     */
    @Override
    public void enableDrawingOrbitSatellites(Group homeGroup) {
        for (Satellite satellite :satellites)
            satellite.enableDrawingOrbit(homeGroup);
    }

    /**
     * Остановка прорисовки орбиты движения спутников
     */
    @Override
    public void stopDrawingOrbitSatellites() {
        for (Satellite satellite :satellites)
            satellite.stopDrawingOrbit();
    }

    /**
     * Включение прорисовки пройденого пути подспутниковой точкой
     * движения всех спутников
     * @param planet планета на которой будут отрисовываться пути подспутниковых
     *               точек (в группу планеты сохраняется путь)
     */
    @Override
    public void enableDrawingProjectionSatellites(PlanetOrStart planet) {
        for (Satellite satellite :satellites)
            satellite.enableDrawingProjectionOnPlanet(planet);
    }

    /**
     * Остановка прорисовки пути подспутниковых точек
     */
    @Override
    public void stopDrawingProjectionSatellites() {
        for (Satellite satellite :satellites)
            satellite.stopDrawingProjectionOnPlanet();
    }

    /**
     * Достает спутник по его названию.
     * @param name наименование спутника
     * @return искомый спутник, если такого нету то null
     */
    @Override
    public Satellite getSatelite(String name) {
        for (Satellite satellite:satellites)
            if (satellite.getName().equals(name))
                return satellite;
        return null;
    }

    /**
     * Удаление спутника из коллекции спутников, из этого сервиса. НО НЕ ИЗ ГРУППЫ ГДЕ ОН НАХОДИТСЯ
     * @param satellite спутник который следует удалить
     */
    @Override
    public void deleteSatellite(Satellite satellite) {
        satellite.getParentGroup().getChildren().remove(satellite);
        satellite.refreshProjectionOnPlanet();
        satellites.remove(satellite);
    }
}
