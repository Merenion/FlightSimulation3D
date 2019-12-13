package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataOtherCA")
public class DataOtherCA  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OTHER_ELEMENTS_CA;
    }

    //выходные параметры
    public float kPrZA;                                         //Доля по массе прочих элементов ЦА, %
    public float uwPrZA;                                        //удельная мощность электропотребления прочих элементов ЦА, Вт/кг
    public float plPrZA;                                        //Средняя плотность компоновки прочих элементов ЦА

    public float mPrZA;
    public float vPrZA;
    public float wPrZA;
    public float jPrZA;
}
