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

    @Override
    public String getStartDate() {
        return "Номинальное напряжение в цепи = " + wNomInCep + "\n" +
                "Кэффициент собственного потребления СЭП = " + kspSEP + "\n" +
                "Период обращения КА за один виток, мин = " + TobrKA + "\n" +
                "Время целевой работы КА на одном витке, мин = " + tZRKA + "\n" +
                "Коэффициент полезногодействия КАС = " + kpdKAS + "\n" +
                "Коэффициент полезногодействия АБ = " + kpdAB + "\n" +
                "Среднее напряжение = " + srU + "\n" +
                "КПД зарядного устройства,% = " + kpdZU + "\n" +
                "КПД разрядного устройства = " + kpdRU + "\n" +
                "Коэффициент запаса для выхода из аварийных ситуаций = " + kzAC + "\n" +
                "Коэффициент запаса для спецрешения = " + kzSR + "\n" +
                "Коэффициент допустимой остаточной мощности СЭП за срок АС,% = " + kdowAB;
    }

    @Override
    public String getOtherDate() {
        return "Мощность собственного электропотребления СЭП = " + wsSEP + "\n" +
                "Мощность электропотребления = " + wKA + "\n" +
                "Среднесуточный косинус альфа = " + CosA + "\n" +
                "Потребная мощность батареи фотоэлектрической = " + wBF + "\n" +
                "Максимальное значение тока, А = " + Imax + "\n" +
                "Мощность потребления КА в тени, Вт = " + wKAten + "\n" +
                "Мощность КА при целевой работе, Вт = " + wKAZR + "\n" +
                "Необходимая энергия АБ, Вт час = " + eAB + "\n" +
                "Минимально необходимая емкость АБ = " + cABmin + "\n" +
                "Необходимая емкости АБ с учетом запасов, А час = " + cAB + "\n" +
                "Необходимая емкости АБ с учетом срока АС А час = " + cAB_AS;
    }

    @Override
    public String toString() {

        if (isNotUse()){
            return "\n" +
                    getType().getName() + "\n" +
                    "Не используется" + "\n" ;
        }else {
            return "\n" +
                    getType().getName() + "\n" +
                    "название элемента = \'" + getNameElement() + '\'' + "\n" +
                    (getStartDate() != null ? "ИСХОДНЫЕ ДАННЫЕ:\n" + getStartDate() + "\n" : "") +
                    "ХАРАКТЕРИСТИКИ:" + "\n" +
                    (getOtherDate() != null ? getOtherDate() + "\n" : "") +
                    "\n";
        }
    }
}
