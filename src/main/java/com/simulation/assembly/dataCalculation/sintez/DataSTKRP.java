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

    private final static TabTypeSintez type =TabTypeSintez.STKRP;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kmSTKRP;  //Доля масса СТКРП от массы КА, %
    public float uwSTKRP;  //Удельная мощность энергопотребления, Вт/кг
    public float plSTKRP;  //Средняя плотность СТКРП, кг/м3

    public float mSTKRP;
    public float vSTKRP;
    public float wSTKRP;
    public float jSTKRP;
}
