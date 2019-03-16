package com.simulation.earth.manageSatellite;

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
    public SpaceObject createSatellite(OrbitParameters parametrsOrbit,Group group) {
        Satellite satellite = new SatelliteDefault(parametrsOrbit);
        satellites.add(satellite);
        group.getChildren().add(satellite.getSpaceModel());
        return satellite;
    }
}
