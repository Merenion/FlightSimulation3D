package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataMassTopl")
public class DataMassTopl   extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.MASS_TOPLIVA;
    }

    public String nameGoruchee = "";
    public float pLG;
    public String nameOkis = "";
    public float pLO;
    public float jT;
    public float kOG;
    public float knt;
    public float kgzt;
    public float Tak;
    public float Tas;
    public float mTKDUskm1;

    public float mTKAx;       // Масса топлива для реализации характеристической скорости КА
    public float mTKAxnzg;   // Масса топлива (для реализации характеристической скорости КА
//    public float m;
    public float mO;
    public float mG;

    public float mTKAg;       // Масса гарантированного запаса топлива
    public float mTKAnz;      // Масса незабора топлива
    //+масса незабора топлива+масса гарантированного запаса топлива
    public float mTKAskm;   //Масса топлива для сброса кинетического момента за весь срок АС
    public float kakR;     //Количество астрокоррекций  (нецелое, расчетное число)
    public float kakZ;     //Количество астрокоррекций (целое, округленное число)



    @Override
    public String getStartDate() {
        return "Название горючего = " + nameGoruchee + "\n" +
                "Название окислителя = " + nameOkis + "\n" +
                "Плотность горючего, кг/м3 = " + pLG + "\n" +
                "Плотность окислителя, кг/м3 = " + pLO + "\n" +
                "Удельный импульс, м/c = " + jT + "\n" +
                "Отношение массы окислителя к массе горючего = " + kOG + "\n" +
                "Коэффициент незабора топлива, % = " + knt + "\n" +
                "Гарантийный запас топлива, % = " + kgzt + "\n" +
                "Периодичность астрокоррекции, час = " + Tak + "\n" +
                "Срок активного существования КА, сут = " + Tas + "\n" +
                "Расход топлива на одну операцию (по статистике), кг = " + mTKDUskm1;
    }

    @Override
    public String getOtherDate() {
        return "Масса топлива для реализации характеристической скорости КА = " + mTKAx + "\n" +
                "Масса топлива с учетом незабора и гарантийных запасов, кг = " + mTKAxnzg + "\n" +
                "Масса окислителя, кг = " + mO + "\n" +
                "Масса горючего,кг = " + mG + "\n" +
                "Количество астрокоррекций  (нецелое, расчетное число) = " + kakR + "\n" +
                "Масса топлива для сброса кинетического момента за весь срок АС= " + mTKAskm;
    }
}
