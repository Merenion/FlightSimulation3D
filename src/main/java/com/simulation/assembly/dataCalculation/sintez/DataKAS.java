package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataKAS")
public class DataKAS   extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.KAS;
    }

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
//    public float m;
//    public float v;
//    public float j;

    public float mkKas;  //Масса корпусных частей КАС
    //и прочих элементов

    @Override
    public String getStartDate() {
        return "Удельная мощность стабилизатора напряжения, Вт/кг = " + uwSN + "\n" +
                "Плотность компоновки стабилизатора напряжения кг/м3 = " + plSN + "\n" +
                "Удельная мощность зарядного устройства, Вт/кг = " + uwZU + "\n" +
                "Плотность компоновки зарядного устройства = " + plZU + "\n" +
                "Удельная мощность Разрядного устройства, Вт/кг = " + uwRU + "\n" +
                "Плотность компоновки разрядного устройства кг/м3 = " + plRU + "\n" +
                "Коэффициент доли корпусных частей,% = " + kKAS + "\n" +
                "процент увеличения объема КАС с учетом корпусных частей = " + ProzV_vKAS;
    }

    @Override
    public String getOtherDate() {
        return "Масса стабилизатора напряжения, кг = " + mSN + "\n" +
                "Объем стабилизатора напряжения, м3 = " + vSN + "\n" +
                "Масса зарядного устройства = " + mZU + "\n" +
                "Объем зарядного утройства = " + vZU + "\n" +
                "Масса разрядного устройства = " + mRU + "\n" +
                "Объем разрядного утройства = " + vRU + "\n" +
                "Масса КАС, кг = " + mKAS + "\n" +
                "Объем КАС, м3 = " + vKAS;
    }
}
