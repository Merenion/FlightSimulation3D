package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataElectHaraktSEP")
public class DataElectHaraktSEP  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.ELECTROTEH_PARAM;
    }

    public float wNomInCep; //Номинальное напряжение в цепи
    public float kspSEP; //Кэффициент собственного потребления СЭП
    public float TobrKA; //Период обращения КА за один виток, мин
    public float tZRKA;  //Время целевой работы КА на одном витке, мин
    public float kpdKAS; //Коэффициент полезногодействия КАС
    public float kpdAB;  //Коэффициент полезногодействия АБ
    public float srU;    //Среднее напряжение
    public float kpdZU;  //КПД зарядного устройства,% TODO поменять местами разр - заряд
    public float kpdRU;  // КПД разрядного устройства
    public float kzAC;   //Коэффициент запаса для выхода из аварийных ситуаций
    public float kzSR;   //Коэффициент запаса для спецрешения
    public float kdowAB; //Коэффициент допустимой остаточной мощности СЭП за срок АС,%

    public float wsSEP;  //Мощность собственного электропотребления СЭП
    public float wKA;
    public float CosA;
    public float wBF;
    public float Imax;   //Максимальное значение тока, А
    public float wKAten;
    public float wKAZR;
    public float eAB;    //Необходимая энергия АБ, Вт час
    public float cABmin; //Минимально необходимая емкость АБ
    public float cAB;    //Необходимая емкости АБ с учетом запасов
    public float cAB_AS;

    public float kpdKU;  //КПД разрядного устройства,%
}
