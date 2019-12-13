package com.simulation.assembly.dataCalculation.sintez;

import com.simulation.assembly.TabTypeSintez;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataPasivSOTR")
public class DataPasivSOTR  extends DataElement{

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.PASSIV_ELEMENT_SOTR;
    }

    public float umEVTI; //Удельная масса мтов ЭВТИ, кг/м2
    public float tEVTI;  //Средняя толщина матов ЭВТИ, мм
    public float kpEVTI; //Коэффициент покрытия ЭВТИ  наружной поверхности КА, %

    public float sKA;   //Средняя площадь наружной поверхности КА, м2
    public float sEVTI; //Средняя площадь ЭВТИ, м2
    public float mEVTI;
    public float vEVTI;
    public float jEVTI;
}
