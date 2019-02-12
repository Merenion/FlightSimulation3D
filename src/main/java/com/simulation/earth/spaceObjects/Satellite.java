package com.simulation.earth.spaceObjects;

import com.simulation.earth.manageSatellite.ParametrsOrbit;

public abstract class Satellite extends ObjectWithCamera{
    private ParametrsOrbit parametrsOrbit;

    public Satellite(ParametrsOrbit parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }

    public Satellite(){};

    public ParametrsOrbit getParametrsOrbit() {
        return parametrsOrbit;
    }

    public void setParametrsOrbit(ParametrsOrbit parametrsOrbit) {
        this.parametrsOrbit = parametrsOrbit;
    }


}
