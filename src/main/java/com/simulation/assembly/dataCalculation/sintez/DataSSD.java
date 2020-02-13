package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSSD")
public class DataSSD extends DataElement {

    @Override
    public TabTypeSintez getType() {
        return  TabTypeSintez.SSD;
    }

    public float km;  //Доля массы от массы КА, %
    public float uw;  //Удельная мощность энергопотребления, Вт/кг
    public float pl;  //Средняя плотность, кг/м3

    @Override
    public String getStartDate() {
        return "Доля массы от массы КА, % = " + km + "\n" +
                "Удельная мощность энергопотребления, Вт/кг = " + uw + "\n" +
                "Средняя плотность, кг/м3 = " + pl;
    }
}
