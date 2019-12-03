package com.simulation.assembly.dataCalculation.sintez;

public class DataMassTopl {

    public String nameGoruchee;
    public float pLG;
    public String nameOkis;
    public float pLO;
    public float jT;
    public float kOG;
    public float knt;
    public float kgzt;
    public float Tak;
    public float Tas;
    public float mTKDUskm1;

    public float mTKAx;       // Масса топлива для реализации характеристической скорости КА
    public float mTKAxnzg;   // Масса топлива (для реализации характеристической скорости КА
    public float mTKDU;
    public float mO;
    public float mG;

    public float mTKAg;       // Масса гарантированного запаса топлива
    public float mTKAnz;      // Масса незабора топлива
    //+масса незабора топлива+масса гарантированного запаса топлива
    public float mTKAskm;   //Масса топлива для сброса кинетического момента за весь срок АС
    public float kakR;     //Количество астрокоррекций  (нецелое, расчетное число)
    public float kakZ;     //Количество астрокоррекций (целое, округленное число)
}
