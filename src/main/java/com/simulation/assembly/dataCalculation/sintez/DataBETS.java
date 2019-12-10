package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBETS")
public class DataBETS  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.BETS;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kmBITS;  //Доля масса КИС от массы КА, %
    public float uwBITS;  //Удельная мощность энергопотребления приборов БИТС, Вт/кг
    public float plBITS;  //Средняя плотность компоновки приборов БИТС, кг/м3

    public float mBITS;
    public float vBITS;
    public float wBITS;
    public float jBITS;
}
