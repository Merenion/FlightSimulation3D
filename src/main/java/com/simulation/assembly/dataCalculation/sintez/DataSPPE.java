package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSPPE")
public class DataSPPE  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.SPPE;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    //входные
    public float sPI;       //Скорость передачи нформации
    public float umSPPI;    //удельная масса СППИ
    public float uwSPPI;    //удельная мощность СППИ
    public float plSPPI;    //Плотность аппаратуры СППИ

    //выходные
    public float mSPPI;     //масса сппи
    public float vSPPI;     //обьем сппи
    public float wSPPI;     //мощность энергопотр. сппи
    public float jSPPI;     //момент инерции сппи
}
