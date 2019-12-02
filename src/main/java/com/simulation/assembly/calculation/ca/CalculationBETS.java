package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBETS;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;

public class CalculationBETS implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataBETS d = CalculationKA.getInstance().getDataBETS();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mBITS=d.kmBITS/100*dc.mKA;
            d.vBITS=d.mBITS/d.plBITS;
            d.wBITS=d.uwBITS*d.mBITS;
            d.jBITS=d.mBITS*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
