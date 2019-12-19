package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataKDU")
public class DataKDU  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS;
    }

    public float s;
    public float kNTB;         //Коэффициент незаполнения топливных баков, %
    public float kpVKDU_Vb;
    public float kpVOKA_VKDU;
    public float dKDU;
    public float umKDU;//удельная мощность КДУ (на единицу массы), Вт/кг

    public float mKDU;
//    public float m;
    public float Vok;
    public float Vg;
    public float VbOk;
    public float VbG;
    public float Vb;
    public float VKDU;
//    public float v;
    public float hKDU;
    public float pKDU;
    public float JxKDU;
    public float JyKDU;
//    public float j;
//    public float w;

}
