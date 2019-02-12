package com.simulation.earth.manageSpace;

public class NearEarthFactory implements FactorySpace {
    @Override
    public Space getSpace() {
        return new NearEarthSpace();
    }

    @Override
    public ParametersSpace getParametersSpace() {
        return new ParametersSpaceNearEarth();
    }
}
