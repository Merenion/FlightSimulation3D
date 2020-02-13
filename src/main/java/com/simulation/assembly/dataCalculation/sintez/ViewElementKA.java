package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;
import javafx.beans.property.SimpleStringProperty;

public class ViewElementKA {

    private SimpleStringProperty nameElement =new SimpleStringProperty();;
    private SimpleStringProperty id =new SimpleStringProperty();
    private SimpleStringProperty type =new SimpleStringProperty();

    private SimpleStringProperty m=new SimpleStringProperty();
    private SimpleStringProperty v=new SimpleStringProperty();
    private SimpleStringProperty j=new SimpleStringProperty();
    private SimpleStringProperty w=new SimpleStringProperty();
    private SimpleStringProperty zaimstv =new SimpleStringProperty();

    public static ViewElementKA validateDataElementKA(DataElement dataElement) {
        ViewElementKA viewElementKA = new ViewElementKA();

        viewElementKA.setM(String.valueOf(dataElement.m));
        viewElementKA.setV(String.valueOf(dataElement.v));
        viewElementKA.setW(String.valueOf(dataElement.w));
        viewElementKA.setJ(String.valueOf(dataElement.j));
        viewElementKA.setZaimstv(String.valueOf(dataElement.isImportData()));

        viewElementKA.setId(String.valueOf(dataElement.getId()));
        viewElementKA.setNameElement(String.valueOf(dataElement.getNameElement()));
        viewElementKA.setType(String.valueOf(dataElement.getType().getName()));
        if (dataElement instanceof DataOtherKA)
            viewElementKA.setType(String.valueOf(dataElement.getNameElement()));


        return viewElementKA;
    }

    public String getM() {
        return m.get();
    }

    public SimpleStringProperty mProperty() {
        return m;
    }

    public void setM(String m) {
        this.m.set(m);
    }

    public String getV() {
        return v.get();
    }

    public SimpleStringProperty vProperty() {
        return v;
    }

    public void setV(String v) {
        this.v.set(v);
    }

    public String getJ() {
        return j.get();
    }

    public SimpleStringProperty jProperty() {
        return j;
    }

    public void setJ(String j) {
        this.j.set(j);
    }

    public String getW() {
        return w.get();
    }

    public SimpleStringProperty wProperty() {
        return w;
    }

    public void setW(String w) {
        this.w.set(w);
    }

    public String getZaimstv() {
        return zaimstv.get();
    }

    public SimpleStringProperty zaimstvProperty() {
        return zaimstv;
    }

    public void setZaimstv(String zaimstv) {
        this.zaimstv.set(zaimstv);
    }

    public String getNameElement() {
        return nameElement.get();
    }

    public SimpleStringProperty nameElementProperty() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement.set(nameElement);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
