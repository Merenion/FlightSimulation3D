package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataSSKM;

public class CalculationSSKM implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataSSKM d = CalculationKA.getInstance().getDataSSKM();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Расчет
            d.mSSKM=d.kmSSKM/100*dc.mKA;
            d.msSSKM=d.kmsSSKM/100*d.mSSKM;
            d.maSSKM=d.mSSKM-d.msSSKM;
            d.vaSSKM=d.maSSKM/d.plaSSKM;
            d.vsSSKM=1000*d.msSSKM/d.plsSSKM/d.kzsSSKM/100;
            d.vSSKM=d.vaSSKM+d.vsSSKM;     //Объем ССКМ, м3
            d.wSSKM=d.uwSSKM*d.maSSKM;
            d.jSSKM=d.mSSKM*((dc.dKA*dc.dKA)/16+(dc.lKA* dc.lKA)/12);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR,"Не верно введенные данные!", TabTypeSintez.RESTRICTION);
            throw new Exception();
        }
        return object;
    }
}
