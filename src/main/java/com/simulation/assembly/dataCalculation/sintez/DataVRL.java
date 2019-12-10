package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataVrl")
public class DataVRL  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.VRL;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    //входные
    public float sPI;       //Скорость передачи нформации
    public float umVRL;//удельная масса ВРЛ
    public float uwVRL;      //удельная мощность ВРЛ
    public float plVRL;    //Плотность аппаратуры ВРЛ

    //выходные
    public float mVRL;
    public float vVRL;
    public float wVRL;
    public float jVRL;
}
