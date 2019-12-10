package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataAcumBetSEP")
public class DataAcumBetSEP  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.AKUM_BATTERIES;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float uwAB;   //Удельная мощность АБ, А час/кг
    public float nAB;    //кол батарей
    public float plAB;   //Плотность компоновки АБ, кг/м3

    public float mAB;    //масса всех АБ
    public float mAB1;   //Масса одной АБ, кг
    public float vAB1;   //Объем одной АБ
    public float vAB;   //Объем всех АБ
    public float lAB;    //Средний линейный размер АБ (в форме куба)
    public float jAB1;   //Момент инерции АБ в форме куба относительно оси симметрии
    public float jAB_KA; //Момент инерции АБ в форме куба относительно поперечной оси КА
}
