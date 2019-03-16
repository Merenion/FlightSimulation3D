package com.simulation.earth.manageSatellite;

import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.scene.Group;

public interface ManageSatellite {
    SpaceObject createSatellite (OrbitParameters parametrsOrbit, Group group);
}
