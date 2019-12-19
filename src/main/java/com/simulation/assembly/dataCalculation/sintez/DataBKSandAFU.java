package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBKSandAFU")
public class DataBKSandAFU  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BKS_AND_AFU;
    }

    public float omBKS;//Относительная масса БКС,%
    public float omAFU;//Относительная масса АФУ,%
    public float plBKS;//Плотность компоновки БКС, кг/м3
    public float plAFU;//Плотность компоновки АФУ, кг/м3

    public float mBKS;//Масса БКС, кг
    public float vBKS; //Объем БКС, м3
    public float mAFU;//Масса АФУ, кг
    public float vAFU; //Объем АФУ, м3
//    public float m;
//    public float v;
    public float jBKS;
    public float jAFU;
}
