package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBVS;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;

public class CalculationBVS implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataBVS d = CalculationKA.getInstance().getDataBVS();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mBVS=d.kmBVS/100*dc.mKA;
            d.vBVS=d.mBVS/d.plBVS;
            d.wBVS=d.uwBVS*d.mBVS;
            d.jBVS=d.mBVS*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
