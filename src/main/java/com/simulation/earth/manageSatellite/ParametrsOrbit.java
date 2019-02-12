package com.simulation.earth.manageSatellite;

public class ParametrsOrbit {
    private float perigeeHeight;
    private float heightOfApogee;
    private float orbitalInclinationAngle;
    private float ascendingNodeLongitude;
    private float perigeeStartingArgument;
    private boolean useSpeed = false;
    private double speed;

    public float getPerigeeHeight() {
        return perigeeHeight;
    }

    public void setPerigeeHeight(float perigeeHeight) {
        this.perigeeHeight = perigeeHeight;
    }

    public float getHeightOfApogee() {
        return heightOfApogee;
    }

    public void setHeightOfApogee(float heightOfApogee) {
        this.heightOfApogee = heightOfApogee;
    }

    public float getOrbitalInclinationAngle() {
        return orbitalInclinationAngle;
    }

    public void setOrbitalInclinationAngle(float orbitalInclinationAngle) {
        this.orbitalInclinationAngle = orbitalInclinationAngle;
    }

    public float getAscendingNodeLongitude() {
        return ascendingNodeLongitude;
    }

    public void setAscendingNodeLongitude(float ascendingNodeLongitude) {
        this.ascendingNodeLongitude = ascendingNodeLongitude;
    }

    public float getPerigeeStartingArgument() {
        return perigeeStartingArgument;
    }

    public void setPerigeeStartingArgument(float perigeeStartingArgument) {
        this.perigeeStartingArgument = perigeeStartingArgument;
    }

    public boolean isUseSpeed() {
        return useSpeed;
    }

    public void setUseSpeed(boolean useSpeed) {
        this.useSpeed = useSpeed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
