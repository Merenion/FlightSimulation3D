package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataActivSOTR")
public class DataActivSOTR   extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.ACTIV_ELEMENT_SOTR;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float omSTR; //Относительная масса СТР
    public float plSTR; //Средняя плотность компоновки приборов и агрегатов СТР, кг/м3
    public float uwSTR; //Удельная мощность приборов и агрегатов СТР, Вт/кг
    public float kmtnSTR;//Коэффицент (доля) теплоносителя в массе заправленной СТР

    public float mSTR;
    public float mSTRbtn;
    public float mtnSTR;
    public float vSTR;
    public float wSTR;
    public float jSTR;
}
