package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBAKES;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataPasivSOTR;

public class CalculationPasivSOTR implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataPasivSOTR d = CalculationKA.getInstance().getDataPasivSOTR();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

//            d.sKA=(float)(Math.PI*dc.dKA*dc.lKA+(Math.PI*dc.dKA*dc.dKA)/2f);
            d.sKA=44.83f; //TODO
            d.sEVTI=d.kpEVTI/100*d.sKA;
            d.mEVTI=d.umEVTI*d.sEVTI;
            d.vEVTI=d.sKA*d.tEVTI/1000;
//            d.jEVTI=d.mEVTI*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            d.jEVTI=38.2f;//TODO
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.PASSIV_ELEMENT_SOTR);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.PASSIV_ELEMENT_SOTR);
            throw new Exception();
        }
        return object;
    }
}
