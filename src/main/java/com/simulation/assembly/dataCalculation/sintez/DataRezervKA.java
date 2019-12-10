package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRezervKA")
public class DataRezervKA  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.RETHERV;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float omRmKA; //Относительная масса резерва масс КА, %
    public float plRmKA; //Плотность компоновки резерва масс КА, кг/м3
    public float uwRmKA;//Удельная мощность электропотребления резерва масс КА, Вт/кг

    public float mRmKA;
    public float vRmKA;
    public float jRmKA;
    public float wRmKA;
}
