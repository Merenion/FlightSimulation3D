package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSTKRP")
public class DataSTKRP  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.STKRP;
    }

    public float kmSTKRP;  //Доля масса СТКРП от массы КА, %
    public float uwSTKRP;  //Удельная мощность энергопотребления, Вт/кг
    public float plSTKRP;  //Средняя плотность СТКРП, кг/м3

//    public float m;
//    public float v;
//    public float w;
//    public float j;

    @Override
    public String getStartDate() {
        return "Доля масса СТКРП от массы КА, % = " + kmSTKRP + "\n" +
                "Удельная мощность энергопотребления, Вт/кг = " + uwSTKRP + "\n" +
                "Средняя плотность СТКРП, кг/м3 = " + plSTKRP;
    }
}
