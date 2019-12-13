package com.simulation.assembly.calculation;

import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElement;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

public abstract class Calculation<T> {

    private TabTypeSintez type = TabTypeSintez.RESULT;

    public T calculation(T object) throws Exception {
        predCalculation();
        return null;
    }

    public void predCalculation () throws Exception {
//        DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
//
//        dc.mKA = 0f;
//        dc.vKA = 0f;
//        dc.dKA = 0f;
//        dc.lKA = 0f;
//        dc.jKA = 0f;
//        dc.wKA_wsSEP = 0f;
//
//        System.out.println("=============");
//        System.out.println(getType());
//        System.out.println(getType().getNumber());
//        List<TabTypeSintez> listType = Arrays.asList(TabTypeSintez.values());
//        for (int i = 0;i<getType().getNumber();i++){
//            for (TabTypeSintez iterationType:listType){
//                if (iterationType.getNumber()==i){
//                    iterationType.getCalculation().calculationSingle(new Object());
//                }
//            }
//        }
    }

    public abstract T calculationSingle(T object) throws Exception;

    public TabTypeSintez getType() {
        return type;
    }
}
