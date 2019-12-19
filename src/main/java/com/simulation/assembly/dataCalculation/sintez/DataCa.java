package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCa")
public class DataCa  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.CA;
    }

//    public float m; //Масса целевой аппаратуры, кг
//    public float v; //Расчет объема ЦА
//    public float j; //Расчет мометна инерции ЦА
//    public float w; //Мощность энергопотребления ЦА, Вт
}
