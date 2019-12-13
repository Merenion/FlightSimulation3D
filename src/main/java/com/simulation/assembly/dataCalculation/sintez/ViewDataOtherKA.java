package com.simulation.assembly.dataCalculation.sintez;

import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.Element;

public class ViewDataOtherKA {

    private String nameElement = "non Name";

    private SimpleStringProperty omPrKA= new SimpleStringProperty(); //Относительная масса прочих элементов КА, %
    private SimpleStringProperty plPrKA=new SimpleStringProperty(); //плотность компоновки прочих элементов КА, кг/м3
    private SimpleStringProperty uwPrKA=new SimpleStringProperty();//удельная мощность электропотребления прочих элементов КА, Вт/кг

    private SimpleStringProperty mPrKA=new SimpleStringProperty();
    private SimpleStringProperty vPrKA=new SimpleStringProperty();
    private SimpleStringProperty jPrKA=new SimpleStringProperty();
    private SimpleStringProperty wPrKA=new SimpleStringProperty();

    public static ViewDataOtherKA validateDataOtherKA(DataOtherKA dataOtherKA) {
        ViewDataOtherKA viewDataOtherKA = new ViewDataOtherKA();

        viewDataOtherKA.setOmPrKA( String.valueOf(dataOtherKA.omPrKA));
        viewDataOtherKA.setPlPrKA( String.valueOf(dataOtherKA.plPrKA));
        viewDataOtherKA.setUwPrKA( String.valueOf(dataOtherKA.uwPrKA));

        viewDataOtherKA.setmPrKA( String.valueOf(dataOtherKA.mPrKA));
        viewDataOtherKA.setvPrKA( String.valueOf(dataOtherKA.vPrKA));
        viewDataOtherKA.setjPrKA( String.valueOf(dataOtherKA.jPrKA));
        viewDataOtherKA.setwPrKA( String.valueOf(dataOtherKA.wPrKA));

        viewDataOtherKA.nameElement = dataOtherKA.getNameElement();
        return viewDataOtherKA;
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public String getOmPrKA() {
        return omPrKA.get();
    }

    public SimpleStringProperty omPrKAProperty() {
        return omPrKA;
    }

    public void setOmPrKA(String omPrKA) {
        this.omPrKA.set(omPrKA);
    }

    public String getPlPrKA() {
        return plPrKA.get();
    }

    public SimpleStringProperty plPrKAProperty() {
        return plPrKA;
    }

    public void setPlPrKA(String plPrKA) {
        this.plPrKA.set(plPrKA);
    }

    public String getUwPrKA() {
        return uwPrKA.get();
    }

    public SimpleStringProperty uwPrKAProperty() {
        return uwPrKA;
    }

    public void setUwPrKA(String uwPrKA) {
        this.uwPrKA.set(uwPrKA);
    }

    public String getmPrKA() {
        return mPrKA.get();
    }

    public SimpleStringProperty mPrKAProperty() {
        return mPrKA;
    }

    public void setmPrKA(String mPrKA) {
        this.mPrKA.set(mPrKA);
    }

    public String getvPrKA() {
        return vPrKA.get();
    }

    public SimpleStringProperty vPrKAProperty() {
        return vPrKA;
    }

    public void setvPrKA(String vPrKA) {
        this.vPrKA.set(vPrKA);
    }

    public String getjPrKA() {
        return jPrKA.get();
    }

    public SimpleStringProperty jPrKAProperty() {
        return jPrKA;
    }

    public void setjPrKA(String jPrKA) {
        this.jPrKA.set(jPrKA);
    }

    public String getwPrKA() {
        return wPrKA.get();
    }

    public SimpleStringProperty wPrKAProperty() {
        return wPrKA;
    }

    public void setwPrKA(String wPrKA) {
        this.wPrKA.set(wPrKA);
    }
}
