package com.simulation.earth.manageSpace;

public class SolarSystemFactory implements FactorySpace {
    @Override
    public Space getSpace() {
        return new SunSpace();
    }

    @Override
    public ParametersSpace getParametersSpace() {
        return new ParametersSpaceSun();
    }
}
