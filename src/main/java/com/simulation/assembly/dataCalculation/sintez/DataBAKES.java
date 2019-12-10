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

    private final static TabTypeSintez type =TabTypeSintez.BAKIS;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kmKIS;  //Доля масса КИС от массы КА, %
    public float uwKIS;  //Удельная мощность энергопотребления приборов КИС, Вт/кг
    public float plKIS;  //Средняя плотность компоновки приборов КИС, кг/м3

    public float mKIS;
    public float vKIS;
    public float wKIS;
    public float jKIS;
}
