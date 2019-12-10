package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSOTR")
public class DataSOTR   extends DataElement{

    private final static TabTypeSintez type =TabTypeSintez.SOTR;

    @Override
    public TabTypeSintez getType() {
        return type;
    }

    public float mSOTR;
    public float mSOTRbtn;
    public float mtnSTR;
    public float vSOTR;
    public float jSOTR;
    public float wSTR;
}
