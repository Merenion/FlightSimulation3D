package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataKonstrKA")
public class DataKonstrKA   extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.KONSTR;

    @Override
    public TabTypeSintez getType() {
        return type;
    }
    public float omkKA;   //Относительная масса конструкции КА, %
    public float plmkKA;  //Плотность материала конструкции КА, кг/м3
    public float kpkKA;   //Коэффициент пустотности конструкции КА, %

    public float mkKA;
    public float vkKA;
    public float jkKA;
}
