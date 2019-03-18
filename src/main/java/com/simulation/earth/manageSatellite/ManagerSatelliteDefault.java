package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SatelliteDefault;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;

public class ManagerSatelliteDefault implements ManageSatellite{

    private ObservableList<Satellite> satellites = FXCollections.observableArrayList();

    private static ManagerSatelliteDefault singleton;

    private ManagerSatelliteDefault (){}

    public static ManagerSatelliteDefault getManager () {
        if (singleton == null) {
            singleton = new ManagerSatelliteDefault();
        }
        return singleton;
    }

    public static void destroyManager () {
        singleton =null;
    }

    @Override
    public Satellite createSatellite(OrbitParameters parametrsOrbit,String name) {
        Satellite satellite = new SatelliteDefault(parametrsOrbit);
        satellite.setName(name);
        satellites.add(satellite);
        return satellite;
    }

    @Override
    public ObservableList<Satellite> getAllSatelites() {
        return satellites;
    }

    @Override
    public void changeScalellites(float scale) {
        for (Satellite satellite :satellites)
            satellite.changeScaleModel(scale);
    }

    @Override
    public void enableDrawingOrbitSatellites(Group homeGroup) {
        for (Satellite satellite :satellites)
            satellite.enableDrawingOrbit(homeGroup);
    }

    @Override
    public void stopDrawingOrbitSatellites() {
        for (Satellite satellite :satellites)
            satellite.stopDrawingOrbit();
    }

    @Override
    public void enableDrawingProjectionSatellites(PlanetOrStart planet) {
        for (Satellite satellite :satellites)
            satellite.enableDrawingProjectionOnPlanet(planet);
    }

    @Override
    public void stopDrawingProjectionSatellites() {
        for (Satellite satellite :satellites)
            satellite.stopDrawingProjectionOnPlanet();
    }
}
