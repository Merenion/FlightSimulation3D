package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBETS")
public class DataBETS  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BETS;
    }

    public float kmBITS;  //Доля масса КИС от массы КА, %
    public float uwBITS;  //Удельная мощность энергопотребления приборов БИТС, Вт/кг
    public float plBITS;  //Средняя плотность компоновки приборов БИТС, кг/м3

//    public float m;
//    public float v;
//    public float w;
//    public float j;

    @Override
    public String getStartDate() {
        return "Доля масса БИТС от массы КА, % = " + kmBITS + "\n" +
                "Удельная мощность энергопотребления приборов БИТС, Вт/кг = " + uwBITS + "\n" +
                "Средняя плотность компоновки приборов БИТС, кг/м3 = " + plBITS;
    }
}
