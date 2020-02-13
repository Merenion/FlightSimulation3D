package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataOtherKA")
public class DataOtherKA  extends DataElement{

    private boolean importElement = false;

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OTHER_ELEMENT_KA;
    }

    private List<DataOtherKA> others = new ArrayList<>();

    public float omPrKA; //Относительная масса прочих элементов КА, %
    public float plPrKA; //плотность компоновки прочих элементов КА, кг/м3
    public float uwPrKA;//удельная мощность электропотребления прочих элементов КА, Вт/кг

//    public float m;
//    public float v;
//    public float j;
//    public float w;


    @Override
    public String toString() {
        if (isNotUse()){
            return "\n" +
                    getType().getName() + "\n" +
                    "Не используется" + "\n" ;
        }else {
            return "\n" +
                    getNameElement() + "\n" +
                    (getStartDate() != null && !isImportData() ? "ИСХОДНЫЕ ДАННЫЕ:\n" + getStartDate() + "\n" : "") +
                    "ХАРАКТЕРИСТИКИ ЭЛЕМЕНТА:" + "\n" +
                    "масса = " + m + "\n" +
                    "объем = " + v + "\n" +
                    "энергопотребление = " + w + "\n" +
                    "момент инерции = " + j + "\n" +
                    (getOtherDate() != null ? getOtherDate() + "\n" : "") +
                    "\n";
        }
    }

    private boolean massProc = false;

    public boolean isMassProc() {
        return massProc;
    }

    public void setMassProc(boolean massProc) {
        this.massProc = massProc;
    }


    public List<DataOtherKA> getOthers() {
        return others;
    }

    public void setOthers(List<DataOtherKA> others) {
        this.others = others;
    }

    public boolean isImportElement() {
        return importElement;
    }

    public void setImportElement(boolean importElement) {
        this.importElement = importElement;
    }


    public float getOmPrKA() {
        return omPrKA;
    }

    public void setOmPrKA(float omPrKA) {
        this.omPrKA = omPrKA;
    }

    public float getPlPrKA() {
        return plPrKA;
    }

    public void setPlPrKA(float plPrKA) {
        this.plPrKA = plPrKA;
    }

    public float getUwPrKA() {
        return uwPrKA;
    }

    public void setUwPrKA(float uwPrKA) {
        this.uwPrKA = uwPrKA;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    public float getJ() {
        return j;
    }

    public void setJ(float j) {
        this.j = j;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}
