package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBAKES")
public class DataBAKES  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BAKIS;
    }

    public float kmKIS;  //Доля масса КИС от массы КА, %
    public float uwKIS;  //Удельная мощность энергопотребления приборов КИС, Вт/кг
    public float plKIS;  //Средняя плотность компоновки приборов КИС, кг/м3

//    public float m;
//    public float v;
//    public float w;
//    public float j;

    @Override
    public String getStartDate() {
        return "Доля масса КИС от массы КА, % = " + kmKIS + "\n" +
                "Удельная мощность энергопотребления приборов КИС, Вт/кг = " + uwKIS + "\n" +
                "Средняя плотность компоновки приборов КИС, кг/м3 = " + plKIS;
    }

}
