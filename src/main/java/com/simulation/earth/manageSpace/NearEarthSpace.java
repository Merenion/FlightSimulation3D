package com.simulation.earth.manageSpace;

import com.simulation.earth.manageSatellite.ParametrsOrbit;
import com.simulation.earth.spaceObjects.*;

public class NearEarthSpace extends Space {
    NearEarthSpace() {
        prepareSpace();
    }

    @Override
    protected void prepareSpace() {
        getSpaceObjects().clear();
        getSpaceObjects().add(new Earth());
        getSpaceObjects().add(new Sun());
        getSpaceObjects().add(new Moon());
        getSpaceObjects().add(new SatelliteDefault(new ParametrsOrbit()));
    }
}
