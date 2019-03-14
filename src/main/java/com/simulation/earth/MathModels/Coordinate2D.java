package com.simulation.earth.MathModels;

public class Coordinate2D {

    private double y;
    private double x;

    public Coordinate2D(double y, double x) {
        this.y = y;
        this.x = x;
    }

    public Coordinate2D() {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Coordinate2D{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
