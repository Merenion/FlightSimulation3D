package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationKonstrKA implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataKonstrKA d = CalculationKA.getInstance().getDataKonstrKA();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mkKA=d.omkKA/100*dc.mKA;
            d.vkKA=d.mkKA/d.plmkKA/(1-d.kpkKA/100);
            d.jkKA=d.mkKA*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.KONSTR);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.KONSTR);
            throw new Exception();
        }
        return object;
    }
}
