package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSudSGK")
public class DataSudSGK  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SUD_SGK;
    }

    //выходные
    public float t1;         //Cреднее время, потребное на обсервацию одного объекта, с (Среднее время между съемками цедей, с)
    public float eKA;          //Максимальное угловое ускорение КА, град/c
    public float wKA;        //Максимальна угловая скорость КА, град/с2
    public float umKA;         //Максимальный управляющий момент КА
    public float kmKA;         //Кинетический момент КА, Н м с
    public float kmRGP;        //Кинетический момент ротора гироприбора
    public float JRGP;         //Момент инерции ротора гироприбора
    public float rRGP;         //Радиус ротора гироприбора, м

    public float vRGP;         //Объем ротора гироприбора, м3
    public float mRGP;         //Масса ротора гироприбора, кг
    public float mGP;          //Масса гироприбора, кг
    public float mEB;          //Масса электронного блока гироприбора
    public float mEB_GP;       //Масса электронного блока и гироприбора
//    public float m;       //Масса СГК
    public float vGP;          //Объем гироприбора, м3
    public float vEB;          //Объем электронного блока гироприбора, м3
//    public float w;          //Мощность потребления электр.
    public float dGP;          //Средний радиус гироприбора , м

    //входные
    public float Pr1;        //Количество объектов, подлежащих сънмке за один виток
    public float Tzr;        //Время целевой работы на одном витке, мин
    public float uKA;        //Максимальный угол поворота КА от надира, град
    public float wPrez;      //Угловая скорость прецессии рамки гироприбора
    public float wRGP;       //Угловая скорость вращения ротора гироприбора
    public float plRGP;      //Плотность ротора гироприбора
    public float kmGP_RGP;  //Коэффициент превышения массы ГП над массой ротора ГП
    public float kmEB_mGP;   //Доля массы электронного блока в % от массы ГП
    public float uW_SGK;     //Удельная мощность потребления электричества СГК
    public float pEB;        //Плотность электронного блока гироприбора

//    public float v; //Обьем СГК
//    public float j; //Момент СГК

    @Override
    public String getStartDate() {
        return "Количество объектов, подлежащих сънмке за один виток = " + Pr1 + "\n" +
                "Время целевой работы на одном витке, мин = " + Tzr + "\n" +
                "Максимальный угол поворота КА от надира, град = " + uKA + "\n" +
                "Угловая скорость прецессии рамки гироприбора = " + wPrez + "\n" +
                "Угловая скорость вращения ротора гироприбора = " + wRGP + "\n" +
                "Плотность ротора гироприбора = " + plRGP + "\n" +
                "Коэффициент превышения массы ГП над массой ротора ГП = " + kmGP_RGP + "\n" +
                "Доля массы электронного блока в % от массы ГП = " + kmEB_mGP + "\n" +
                "Удельная мощность потребления электричества СГК = " + uW_SGK + "\n" +
                "Плотность электронного блока гироприбора = " + pEB;
    }

    @Override
    public String getOtherDate() {
        return "Cреднее время, потребное на обсервацию одного объекта, с (Среднее время между съемками цедей, с) = " + t1 + "\n" +
                "Максимальное угловое ускорение КА, град/c = " + eKA + "\n" +
                "Максимальна угловая скорость КА, град/с2 = " + wKA + "\n" +
                "Максимальный управляющий момент КА = " + umKA + "\n" +
                "Кинетический момент КА, Н м с = " + kmKA + "\n" +
                "Кинетический момент ротора гироприбора = " + kmRGP + "\n" +
                "Момент инерции ротора гироприбора = " + JRGP + "\n" +
                "Радиус ротора гироприбора, м = " + rRGP + "\n" +
                "Объем ротора гироприбора, м3 = " + vRGP + "\n" +
                "Масса ротора гироприбора, кг = " + mRGP + "\n" +
                "Масса гироприбора, кг = " + mGP + "\n" +
                "Масса электронного блока гироприбора = " + mEB + "\n" +
                "Масса электронного блока и гироприбора = " + mEB_GP + "\n" +
                "Объем гироприбора, м3 = " + vGP + "\n" +
                "Объем электронного блока гироприбора, м3 = " + vEB + "\n" +
                "Средний радиус гироприбора , м = " + dGP;
    }

}
