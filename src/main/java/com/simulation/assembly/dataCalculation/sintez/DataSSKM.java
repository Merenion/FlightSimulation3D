package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSSKM")
public class DataSSKM  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.SUD_SSKM;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float kmSSKM;  //Доля масса ССКМ от массы КА, %
    public float uwSSKM;      //Удельная мощность аппаратуры ССКМ, Вт/кг
    public float kmsSSKM; //Доля массs штанг ССКМ от массы ССКМ, %
    public float plaSSKM;      //Плотность компоновки аппаратуры ССКМ, кг/м3
    public float plsSSKM;     //Плотность конструкционного материала штанг ССКМ, кг/м3
    public float kzsSSKM;//Коэффициент заполнения штанг ССКМ конструкционным материалом, %

    public float mSSKM;  //удельная масса CCRV
    public float maSSKM;  //Масса аппаратуры ССКМ, кг
    public float msSSKM;  //Масса штанг ССКМ, кг
    public float vaSSKM;  //Объем аппаратуры ССКМ, м3
    public float vsSSKM;  //Обем штанг ССКМ, кг
    public float wSSKM;     //Мощность электропотребления, Вт
    public float jSSKM;     //момент инерции ССКМ

    public float vSSKM;     //обьем ССКМ
}
