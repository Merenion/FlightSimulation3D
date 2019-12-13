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

    public float mPrKA;
    public float vPrKA;
    public float jPrKA;
    public float wPrKA;

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

    public float getmPrKA() {
        return mPrKA;
    }

    public void setmPrKA(float mPrKA) {
        this.mPrKA = mPrKA;
    }

    public float getvPrKA() {
        return vPrKA;
    }

    public void setvPrKA(float vPrKA) {
        this.vPrKA = vPrKA;
    }

    public float getjPrKA() {
        return jPrKA;
    }

    public void setjPrKA(float jPrKA) {
        this.jPrKA = jPrKA;
    }

    public float getwPrKA() {
        return wPrKA;
    }

    public void setwPrKA(float wPrKA) {
        this.wPrKA = wPrKA;
    }
}
