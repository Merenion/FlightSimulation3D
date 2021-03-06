package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.collections.ObservableList;
import javafx.scene.Group;

//космический аппарат

/**
 * Основной интерфей управления и создания спутника
 */
public interface ManageSatellite {
    Satellite createSatellite (OrbitParameters parametrsOrbit,String name);
    public Satellite createSatelliteWithParametersCA(OrbitParameters parametrsOrbit,CaParameters caParameters,String name);
    ObservableList<Satellite> getAllSatelites ();
    Satellite getSatelite (String name);
    void changeScaleSatellites(float scale);
    void enableDrawingOrbitSatellites (Group homeGroup);
    void stopDrawingOrbitSatellites ();
    void enableDrawingProjectionSatellites (PlanetOrStart planet);
    void stopDrawingProjectionSatellites ();
    void refreshDrawingOrbit();
    void refreshProjectionOnPlanet();
    void deleteSatellite(Satellite satellite);
    void enableDrawingZonaObzora();
    void stopDrawingZonaObzora();

}
