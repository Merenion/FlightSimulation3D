package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataAFU")
public class DataAFU extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.AFU;
    }


    public float omAFU;//Относительная масса АФУ,%
    public float plAFU;//Плотность компоновки АФУ, кг/м3


//    public float m;
//    public float v;
//    public float jAFU;

    @Override
    public String getStartDate() {
        return "Относительная масса АФУ,% = " + omAFU + "\n" +
                "Плотность компоновки АФУ, кг/м3 = " + plAFU;
    }

}
