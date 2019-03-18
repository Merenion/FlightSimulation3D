package com.simulation.earth.manageSpace;

import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.spaceObjects.*;
import com.simulation.earth.spaceObjects.modelNearEarth.EarthNE;
import com.simulation.earth.spaceObjects.modelNearEarth.MoonNE;
import com.simulation.earth.spaceObjects.modelNearEarth.SunNE;

public class NearEarthSpace extends Space {
    NearEarthSpace() {
        prepareSpace();
    }

    @Override
    protected void prepareSpace() {
        getSpaceObjects().clear();
        getSpaceObjects().add(new EarthNE());
        getSpaceObjects().add(new SunNE());
        getSpaceObjects().add(new MoonNE());
//        getSpaceObjects().add(new SatelliteDefault(new StorageOrbitParameters()));
    }
}
