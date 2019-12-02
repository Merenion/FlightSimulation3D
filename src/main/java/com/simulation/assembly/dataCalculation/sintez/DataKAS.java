package com.simulation.assembly.dataCalculation.sintez;

public class DataKAS {
    public float uwSN;   //Удельная мощность стабилизатора напряжения, Вт/кг
    public float plSN;   //Плотность компоновки стабилизатора напряжения кг/м3
    public float uwZU;   //Удельная мощность зарядного устройства, Вт/кг
    public float plZU;   //Плотность компоновки зарядного устройства
    public float uwRU;   //Удельная мощность Разрядного устройства, Вт/кг
    public float plRU;   //Плотность компоновки разрядного устройства кг/м3
    public float kKAS;   //Коэффициент доли корпусных частей,%
    public float ProzV_vKAS;//процент увеличения объема КАС с учетом корпусных частей

    public float mSN;    //Масса стабилизатора напряжения, кг
    public float vSN;    //Объем стабилизатора напряжения, м3
    public float mZU;    //Масса зарядного устройства
    public float vZU;    //Объем зарядного утройства
    public float mRU;    //Масса разрядного устройства
    public float vRU;    //Объем разрядного утройства
    public float mKAS;   //Масса КАС, кг
    public float vKAS;   //Объем КАС, м3
    public float mKASsum;
    public float vKASsum;
    public float jKASsum;

    public float mkKas;  //Масса корпусных частей КАС
    //и прочих элементов
}
