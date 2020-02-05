package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCommonParameters")
public class DataCommonParameters  extends DataElement{


    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.RESTRICTION;
    }

    public  boolean isHaveRestriction = true;
    public  float mKA0; //максимальная масса ка
    public  float dzPN0; //максимальный диаметр зоны ПН
    public  float lzPN0; //максимальный длина зоны ПН
    public  float knzpOBT; //Коэф. учитывающий неполноту заполнения зоны ПН под обтекателем
    public  float krkKA; //Коэффициент рациональности компоновки
    public  float kpoPO; //Плотность заполнения приборных отсеков аппаратурой %
    public  float udlKA; //Удлинение КА

    public  float dKA0; //Средний диаметр КА
    public  float lKA0; //Средняя длина КА
    public  float vKA0; //Средний обьем КА
    public  float splkKA0; //Средняя плотность компоновки
    public  float jKA0; //Максимальный приведенный момент инерции КА

    public  float mKA;
    public  float vKA;
    public  float dKA;
    public  float lKA;
    public  float jKA;
    public  float wKA_wsSEP; //Среднесуточная мощность целевой аппаратуры, Вт


    @Override
    public String toString() {
        return "\n" +
                "Характеристики КА"+"\n"+
                "масса = " + mKA + "\n" +
                "объем = " + vKA + "\n" +
                "энергопотребление = " + wKA_wsSEP + "\n" +
                "момент инерции = " + jKA + "\n" +
                "диаметр = " + dKA + "\n" +
                "длина = " + lKA + "\n" +
                "\n";
    }
}
