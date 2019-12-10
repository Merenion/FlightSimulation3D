package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBKU")
public class DataBKU  extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.BKU;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float mBKU;
    public float vBKU;
    public float jBKU;
    public float wBKU;

}
