package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBOKZ")
public class DataBOKZ extends DataElement {
    @Override
    public TabTypeSintez getType() {
        return  TabTypeSintez.BOKZ;
    }

    public float km;  //Доля масса от массы КА, %
    public float uw;  //Удельная мощность энергопотребления, Вт/кг
    public float pl;  //Средняя плотность, кг/м3
}