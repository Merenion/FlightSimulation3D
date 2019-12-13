package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import java.util.Objects;

public abstract class DataElement {

    private long id;
    private String nameElement = "non name";
    private boolean importData = false;

    public DataElement() {
        id = ((int) (Math.random() * 1000000000));
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract TabTypeSintez getType();

    public boolean isImportData() {
        return importData;
    }

    public void setImportData(boolean importData) {
        this.importData = importData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataElement that = (DataElement) o;
        return Objects.equals(nameElement, that.nameElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameElement);
    }
}
