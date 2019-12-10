package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataOtherKA")
public class DataOtherKA  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.OTHER_ELEMENT_KA;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float omPrKA; //Относительная масса прочих элементов КА, %
    public float plPrKA; //плотность компоновки прочих элементов КА, кг/м3
    public float uwPrKA;//удельная мощность электропотребления прочих элементов КА, Вт/кг

    public float mPrKA;
    public float vPrKA;
    public float jPrKA;
    public float wPrKA;
}
