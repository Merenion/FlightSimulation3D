package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;
import com.sun.xml.txw2.annotation.XmlAttribute;
import com.sun.xml.txw2.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataOETK")
public class DataOETK extends DataElement {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OETK;
    }

    //константы
    public float wConst = 1.5f;

    //входные параметры
    public float iN_Lm; //Линейное разрешение на местности
    public float iN_H; //Высота орбиты, км
    public float iN_Delta; //Растояние от главного зеркала до фокальной плоскости
    public float iN_k0; //Нормированная пространственная частота
    public float iN_q; //Коэф. центрального экранирования
    public float iN_uwOETK; //Удельная мощность энергопотребления, Вт/кг
    public float iN_kUD; //Удельная масса единицы площади поверхности ОЭТК
    public float iN_kp2dOETK; //Коэф. превышения диаметра ОЭТК
    public float iN_kp2lOETK; //Коэф. превышения длины ОЭТК
    public float iN_yr; //длина волны

    //выходные параметры
    public float ouT_lOETK;  //Длина ОЭТК,м
    public float ouT_dOETK;  //Диаметр ОЭТК,м
//    public float m;  //Масса ОЭТК, кг
//    public float v;  //Объем ОЭТК, м3
//    public float j;  //Максимальный приведенный момент инерции ОЭТК, кг м2
//    public float w;  //Средняя мощность энергопотребления, Вт
    public float ouT_Dgl_OETK;  //Диаметр главного зеркала,м
    public float ouT_Dvt_OETK;  //Диаметр вторичного зеркала,м
    public float ouT_f_ecv_OETK;  //Эквивалентное фокусное расстояние,м
    public float ouT_f1_OETK;  //Фокальное расстояние главного зеркала ОЭТК,м
    public float ouT_f2_OETK;  //Фокальное расстояние вторичного зеркала ОЭТК,м
    public float ouT_Lpzs_OETK;  //Размер элемента ПЗС
    public float ouT_r1_OETK;  //Радиус кривизны главного зеркала
    public float ouT_d1_OETK;  //Диаметр поля зрения в фокусе главного зеркала
    public float ouT_d2_OETK;  //Диаметр поля зрения в фокальной плоскости
    public float ouT_S2_OETK1;  //Расстояние от вершины вторичного зеркала до фокуса глав зеркала
    public float ouT_d_OETK11;  //Разстояние между главным зеркалом и вторичным

    //другие
    public float km_OETK;
    public float b_OETK;
    public float m_const;
}
