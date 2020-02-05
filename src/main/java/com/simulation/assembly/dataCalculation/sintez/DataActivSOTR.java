package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataActivSOTR")
public class DataActivSOTR   extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.ACTIV_ELEMENT_SOTR;
    }

    public float omSTR; //Относительная масса СТР
    public float plSTR; //Средняя плотность компоновки приборов и агрегатов СТР, кг/м3
    public float uwSTR; //Удельная мощность приборов и агрегатов СТР, Вт/кг
    public float kmtnSTR;//Коэффицент (доля) теплоносителя в массе заправленной СТР

//    public float m;
    public float mSTRbtn;
    public float mtnSTR;
//    public float v;
//    public float w;
//    public float j;


    @Override
    public String getStartDate() {
        return "Относительная масса СТР = " + omSTR + "\n" +
                "Средняя плотность компоновки приборов и агрегатов СТР, кг/м3 = " + plSTR + "\n" +
                "Удельная мощность приборов и агрегатов СТР, Вт/кг = " + uwSTR + "\n" +
                "Коэффицент (доля) теплоносителя в массе заправленной СТР = " + kmtnSTR;
    }

    @Override
    public String getOtherDate() {
        return "Масса СТР без теплоносителя = " + mSTRbtn + "\n" +
                "Масса теплоносителя СТР = " + mtnSTR;
    }
}
