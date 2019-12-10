package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSumBetSEP")
public class DataSumBetSEP  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.SUN_BATTERIES;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float uwFP; //удельная мощность ФП
    public float kzPSB;//Коэффициент заполнения площади панелей СБ фотоэлементами
    public float kp;   //Поправочный коэффициент
    public float umPSB;//удельная масса панелей СБ
    public float nPSB;//Количество паналей СБ

    public float sPSB;  //Площадь СБ, м2
    public float mPSB;
    public float sPSB1; //Площадь одной панели СБ, м2
    public float mPSB1; //Масса одной панели СБ, кг
    public float lPSB1; //Длина одной панели СБ, м
    public float dPSB1; //Ширина одной панели СБ, м
    public float jPSB1; //Момент инерции панели СБ относительно оси, расположенной
    //в пролкости панели, перпендикулярной продрльной оси панели
    //и проходящей через собственной центр масс
    public float jPSB_KA;
}
