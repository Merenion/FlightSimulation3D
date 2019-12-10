package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationOtherKA implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataOtherKA d = CalculationKA.getInstance().getDataOtherKA();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mPrKA=d.omPrKA/100*dc.mKA;
            d.vPrKA=d.mPrKA/d.plPrKA;
            d.jPrKA=d.mPrKA*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            d.wPrKA=d.uwPrKA*d.mPrKA;
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENT_KA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENT_KA);
            throw new Exception();
        }
        return object;
    }
}
