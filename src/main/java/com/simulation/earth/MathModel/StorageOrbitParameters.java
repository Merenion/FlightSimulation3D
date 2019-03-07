package com.simulation.earth.MathModel;

public class StorageOrbitParameters implements OrbitParameters{

    private double i=98.3;       //угол наклона плоскости орбиты в градусах
    private double omega0=0;  //долгота восходящего узла орбиты
    private double w0=0;      //начальный аргучент перигея орбиты
    private double Hpi=2000;     //высота перигея орбиты
    private double Ha=15000;      //высота апогея орбиты

    @Override
    public double getI() {
        return i;
    }

    @Override
    public double getIinRadian() {
        return i* Math.PI / 180;
    }


    public void setI(double i) {
        this.i = i;
    }

    @Override
    public double getOmega0() {
        return omega0;
    }

    @Override
    public double getOmega0inRadian() {
        return omega0* Math.PI / 180;
    }

    public void setOmega0(double omega0) {
        this.omega0 = omega0;
    }

    @Override
    public double getW0() {
        return w0* Math.PI / 180;
    }

    @Override
    public double getW0inRadian() {
        return w0;
    }

    public void setW0(double w0) {
        this.w0 = w0;
    }

    @Override
    public double getHpi() {
        return Hpi;
    }

    public void setHpi(double hpi) {
        Hpi = hpi;
    }

    @Override
    public double getHa() {
        return Ha;
    }

    public void setHa(double ha) {
        Ha = ha;
    }
}
