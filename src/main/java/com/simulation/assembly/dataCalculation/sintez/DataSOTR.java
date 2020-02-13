package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSOTR")
public class DataSOTR   extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SOTR;
    }

//    public float m;
    public float mSOTRbtn;
    public float mtnSTR;
//    public float v;
//    public float j;
//    public float w;

    @Override
    public String getOtherDate() {
        return "Масса СОТР (без теплоносителя), кг = " + mSOTRbtn + "\n" +
                "Масса теплоносителя, кг = " + mtnSTR;
    }
}
