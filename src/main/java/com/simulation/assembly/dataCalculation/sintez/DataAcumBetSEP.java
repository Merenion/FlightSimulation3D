package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataAcumBetSEP")
public class DataAcumBetSEP extends DataElement {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.AKUM_BATTERIES;
    }

    public float uwAB;   //Удельная мощность АБ, А час/кг
    public float nAB;    //кол батарей
    public float plAB;   //Плотность компоновки АБ, кг/м3

    //    public float m;    //масса всех АБ
    public float mAB1;   //Масса одной АБ, кг
    public float vAB1;   //Объем одной АБ
    //    public float v;   //Объем всех АБ
    public float lAB;    //Средний линейный размер АБ (в форме куба)
    public float jAB1;   //Момент инерции АБ в форме куба относительно оси симметрии
//    public float j; //Момент инерции АБ в форме куба относительно поперечной оси КА

    @Override
    public String getStartDate() {
        return "Удельная мощность АБ, А час/кг = " + uwAB + "\n" +
                "количество батарей = " + nAB + "\n" +
                "Плотность компоновки АБ, кг/м3 = " + plAB;
    }

    @Override
    public String getOtherDate() {
        return "Масса одной АБ, кг = " + mAB1 + "\n" +
                "Объем одной АБ = " + vAB1 + "\n" +
                "Средний линейный размер АБ (в форме куба) = " + lAB + "\n" +
                "Момент инерции АБ в форме куба относительно оси симметрии = " + jAB1;
    }
}
