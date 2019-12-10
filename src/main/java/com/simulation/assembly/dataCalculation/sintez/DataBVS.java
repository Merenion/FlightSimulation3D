package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBVS")
public class DataBVS  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.BVS;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kmBVS;  //Доля масса БВС от массы КА, %
    public float uwBVS;  //Удельная мощность энергопотребления приборов БВС, Вт/кг
    public float plBVS;  //Средняя плотносБВС, м3


    public float mBVS;
    public float vBVS;
    public float wBVS;
    public float jBVS;

}
