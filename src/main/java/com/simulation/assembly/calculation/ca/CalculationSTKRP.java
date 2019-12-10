package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import com.simulation.assembly.dataCalculation.sintez.DataSTKRP;

public class CalculationSTKRP implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataSTKRP d = CalculationKA.getInstance().getDataSTKRP();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mSTKRP=d.kmSTKRP/100*dc.mKA;
            d.vSTKRP=d.mSTKRP/d.plSTKRP;
            d.wSTKRP=d.uwSTKRP*d.mSTKRP;
            d.jSTKRP=d.mSTKRP*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.STKRP);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.STKRP);
            throw new Exception();
        }
        return object;
    }
}
