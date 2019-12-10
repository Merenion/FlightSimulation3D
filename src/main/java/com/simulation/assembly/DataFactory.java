package com.simulation.assembly;

import com.simulation.assembly.dataCalculation.sintez.DataVRL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class DataFactory {
    private final static QName QNAME = new QName(XMLConstants.NULL_NS_URI,"data");

    public JAXBElement<DataVRL> createData(DataVRL value){
        return new JAXBElement<DataVRL>(QNAME,DataVRL.class,null,value);
    }
}
