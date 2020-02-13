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

    @Override
    public String getStartDate() {
        return "Конструктивная характеристика (отношение заправленной КДУ с т. к массе конструкции КДУ) = " + s + "\n" +
                "Коэффициент незаполнения топливных баков, % = " + kNTB + "\n" +
                "Коэффициент, учитывающий превышение объема КДУ (включая двигатели и автоматику) над объемом баков = " + kpVKDU_Vb + "\n" +
                "Коэффициент, учитывающий превышение объема отсека КА, в котором находится КДУ, над объемом КДУ = " + kpVOKA_VKDU + "\n" +
                "Диаметр, в который вписывается КДУ,м = " + dKDU + "\n" +
                "Удельная мощность КДУ (на единицу массы), Вт/кг = " + umKDU;
    }

    @Override
    public String getOtherDate() {
        return "Расчетное значение массы КДУ, кг = " + mKDU + "\n" +
                "Объем окислителя, м3 = " + Vok + "\n" +
                "Объем горючего, м3 = " + Vg + "\n" +
                "Объем баков окислителя, м3 = " + VbOk + "\n" +
                "Объем баков горючего, м3 = " + VbG + "\n" +
                "Объем баков окислителя и горючего, м3 = " + Vb + "\n" +
                "Объем, занимаемый КДУ, м3 = " + VKDU + "\n" +
                "Расчет высоты цилиндра, в который должен вписаться КДУ = " + hKDU + "\n" +
                "Средняя плотность цилиндра, кг/м3 = " + pKDU + "\n" +
                "Момент инерции относительно оси цилиндра, кг м2 = " + JxKDU + "\n" +
                "Момент инерции относительно оси, перпенд. оси цилиндра, кг м3 = " + JyKDU;
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
                    "элемент заимствован или импортирован = " + isImportData() + "\n" +
                    (getStartDate() != null && !isImportData() ? "ИСХОДНЫЕ ДАННЫЕ:\n" + getStartDate() + "\n" : "") +
                    "ХАРАКТЕРИСТИКИ ЭЛЕМЕНТА:" + "\n" +
                    "масса = " + m + "\n" +
                    "Объем, занимаемый Отсеком КА, в котором находится КДУ, м3 = " + v + "\n" +
                    "энергопотребление = " + w + "\n" +
                    "Момент инерции КДУ, приведенный к габаритам КА(размаз.), кг м3 = " + j + "\n" +
                    (getOtherDate() != null ? getOtherDate() + "\n" : "") +
                    "\n";
        }
    }
}
