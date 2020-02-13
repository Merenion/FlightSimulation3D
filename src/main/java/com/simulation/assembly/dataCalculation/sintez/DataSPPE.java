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

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SPPE;
    }

    //входные
    public float sPI;       //Скорость передачи нформации
    public float umSPPI;    //удельная масса СППИ
    public float uwSPPI;    //удельная мощность СППИ
    public float plSPPI;    //Плотность аппаратуры СППИ

    //выходные
//    public float m;     //масса сппи
//    public float v;     //обьем сппи
//    public float w;     //мощность энергопотр. сппи
//    public float j;     //момент инерции сппи

    @Override
    public String getStartDate() {
        return "Скорость передачи нформации = " + sPI + "\n" +
                "Удельная масса СППИ = " + umSPPI + "\n" +
                "Удельная мощность СППИ = " + uwSPPI + "\n" +
                "Плотность аппаратуры СППИ = " + plSPPI;
    }
}
