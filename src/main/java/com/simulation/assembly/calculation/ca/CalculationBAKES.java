package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBAKES;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;

public class CalculationBAKES implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataBAKES d = CalculationKA.getInstance().getDataBAKES();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mKIS= d.kmKIS/100*dc.mKA;
            d.vKIS=d.mKIS/d.plKIS;
            d.wKIS=d.uwKIS*d.mKIS;
            d.jKIS=d.mKIS*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
