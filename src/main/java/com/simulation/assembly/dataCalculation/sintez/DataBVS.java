package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBVS")
public class DataBVS  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BVS;
    }

    public float kmBVS;  //Доля масса БВС от массы КА, %
    public float uwBVS;  //Удельная мощность энергопотребления приборов БВС, Вт/кг
    public float plBVS;  //Средняя плотносБВС, м3


//    public float m;
//    public float v;
//    public float w;
//    public float j;

    @Override
    public String getStartDate() {
        return "Доля масса БВС от массы КА, % = " + kmBVS + "\n" +
                "Удельная мощность энергопотребления приборов БВС, Вт/кг = " + uwBVS + "\n" +
                "Средняя плотность БВС, м3 = " + plBVS;
    }

}
