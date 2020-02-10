package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import java.util.Objects;

public abstract class DataElement {

    private long id;
    private String nameElement = "non name";
    private boolean importData = false;
    private boolean calculationMoment = false;
    private boolean notUse = false;

    public float m;
    public float v;
    public float w;
    public float j;

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

    public boolean isCalculationMoment() {
        return calculationMoment;
    }

    public void setCalculationMoment(boolean calculationMoment) {
        this.calculationMoment = calculationMoment;
    }

    public String getStartDate() {
        return null;
    }

    public String getOtherDate() {
        return null;
    }

    public boolean isNotUse() {
        return notUse;
    }

    public void setNotUse(boolean notUse) {
        this.notUse = notUse;
    }

    @Override
    public String toString() {

        if (notUse){
            return "\n" +
                    getType().getName() + "\n" +
                    "Не используется" + "\n" ;
        }else {
            return "\n" +
                    getType().getName() + "\n" +
                    "название элемента = \'" + nameElement + '\'' + "\n" +
                    "элемент заимствован или импортирован = " + importData + "\n" +
                    (getStartDate() != null && !importData ? "ИСХОДНЫЕ ДАННЫЕ:\n" + getStartDate() + "\n" : "") +
                    "ХАРАКТЕРИСТИКИ ЭЛЕМЕНТА:" + "\n" +
                    "масса = " + m + "\n" +
                    "объем = " + v + "\n" +
                    "энергопотребление = " + w + "\n" +
                    "момент инерции = " + j + "\n" +
                    (getOtherDate() != null ? getOtherDate() + "\n" : "") +
                    "\n";
        }
    }

    public boolean isAfterCalculation () {
        return m != 0 || v != 0 || w != 0;
    }

    public boolean isNeedUvyzka () {
        return isAfterCalculation() && !notUse;
    }
}
