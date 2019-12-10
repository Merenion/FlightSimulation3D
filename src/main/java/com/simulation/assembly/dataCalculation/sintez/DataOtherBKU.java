package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataOtherBKU")
public class DataOtherBKU   extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.OTHER_ELEMENTS_BKU;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kPrBKU;    //Доля по массе прочих элементов БКУ, %
    public float uwPrBKU;   //удельная мощность электропотребления прочих элементов БКУ, Вт/кг
    public float plPrBKU;   //Средняя плотность компоновки прочих элементов БКУ

    public float mPrBKU;
    public float vPrBKU;
    public float wPrBKU;
    public float jPrBKU;

}
