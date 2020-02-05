package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSpeed")
public class DataSpeed   extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SPEED;
    }

    public float V1=7910;  //первая космическая скоость (м/с)
    public float Rs=6371;  //Радиус Земли, км
    public float Hoo=200;  //Высота круговой орбиты перед захоронением КА

    //вх
    public float Hp;       //Высота перигея
    public float iRN;
    public float Ha;  //Высота апогея
    public float iKA;
    public float dV6;      //Добавка характеристической скорости для схода с опорной орбиты

    //вых
    public float dV1;//Добавка скорости
    public float dV2;//Добавка скорости
    public float dV3;//Добавка характеристической скорости для изменения плоскости орбиты
    public float dV4;
    public float dV5;//Добавка характеристической скорости для схода с рабочей орбины
    public float dV;

    public float rkr1;     //Радиус круговой начальной орбиты
    public float Vkr1;     //Скорость КА круговая на орбите выведения РН
    public float Vp;       //Скорость в перигее
    public float a;        //Плуось орбиты перехода
    public float ra;       //радиус апогея
    public float rp;        //радиус перигея
                            //на опорную орбиту для подготовки к захоронению
                            //для захоронения КА
    public float Vkr2;     //Скорость КА круговой рабочей орбите
    public float Va;  //Скорость КА в апогее переходной эллиптической орбиты
    public float rkr2;//Радиус груговой рабочей орбиты КА
    public float roo; //Радиус опорной орбиты для захоронения КА
    public float Vaoo;//Скорость КА в апогее переходной орбиты для подготовки к захоронению
    public float aps; //Полурсь эллиптической переходной орбты для подготовки к захоронению
    public float di;  //изменение угола наклона плоскости орбиты


    @Override
    public String toString() {
        return "Характеристическая скорость = "+ dV+"\n";
    }
}
