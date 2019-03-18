package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.collections.ObservableList;
import javafx.scene.Group;

public interface ManageSatellite {
    Satellite createSatellite (OrbitParameters parametrsOrbit,String name);
    ObservableList<Satellite> getAllSatelites ();
    void changeScalellites (float scale);
    void enableDrawingOrbitSatellites (Group homeGroup);
    void stopDrawingOrbitSatellites ();
    void enableDrawingProjectionSatellites (PlanetOrStart planet);
    void stopDrawingProjectionSatellites ();

}
