package com.simulation.earth.manageSatellite;

/**
 * Интерфейс для работы с параметрами орбиты
 */
public interface OrbitParameters {
    double getI();                      //угол наклона плоскости орбиты в градусах
    double getIinRadian();
    double getOmega0();                 //долгота восходящего узла орбиты
    double getOmega0inRadian();
    double getW0();                     //начальный аргучент перигея орбиты
    double getHpi();                    //высота перигея орбиты
    double getHa();                     //высота апогея орбиты
    double getW0inRadian();
    void setI(double i);
    void setOmega0(double omega0);
    void setW0(double w0);
    void setHpi(double hpi);
    void setHa(double ha);
}
