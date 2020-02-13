package com.simulation.assembly;

import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOtherKA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HashSetForElementsKA")
public class HashSetForElementsKA<E> extends HashSet<E> {
    public HashSetForElementsKA() {
        super();
    }

    @Override
    public boolean add(E e) {
        if (e instanceof DataElement && !(e instanceof DataOtherKA)){
            List<Object> list = new ArrayList<Object>(this);
            for (Object o1:list){
                if (o1 instanceof DataElement && !(o1 instanceof DataOtherKA) && ((DataElement)o1).getType().equals(((DataElement)e).getType())){
                    this.remove(o1);
                }
            }
        }
        return super.add(e);
    }
}
