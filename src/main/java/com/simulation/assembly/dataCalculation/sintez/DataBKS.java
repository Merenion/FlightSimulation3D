package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBKS")
public class DataBKS extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BKS;
    }

    public float omBKS;//Относительная масса БКС,%
    public float plBKS;//Плотность компоновки БКС, кг/м3


//    public float m;
//    public float v;
//    public float jBKS;

    @Override
    public String getStartDate() {
        return "Относительная масса БКС,% = " + omBKS + "\n" +
                "Плотность компоновки БКС, кг/м3 = " + plBKS;
    }
}
