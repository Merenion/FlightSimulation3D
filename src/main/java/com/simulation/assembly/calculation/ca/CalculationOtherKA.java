package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationOtherKA extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OTHER_ELEMENT_KA;
    }

    @Override
    public Object calculation(Object object) throws Exception {
        super.calculation(object);
        calculationSingle(object);
        return object;
    }

    @Override
    public Object calculationSingle(Object object) throws Exception {
        try {
            DataOtherKA d = CalculationKA.getInstance().getDataOtherKA();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.m = 0f;
            d.v = 0f;
            d.j = 0f;
            d.w = 0f;

            for (DataOtherKA element : d.getOthers()) {
//                if (!element.isImportElement()) {
//                    element.m = element.omPrKA / 100 * dc.mKA;
//                    element.v = element.m / element.plPrKA;
//                    element.j = element.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
//                    element.w = element.uwPrKA * element.m;
//                }
                if (element.isCalculationMoment()) {
                    element.j = element.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                }
                d.m = d.m + element.m;
                d.v = d.v + element.v;
                d.j = d.j + element.j;
                d.w = d.w + element.w;
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENT_KA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENT_KA);
            throw new Exception();
        }
        return object;
    }
}
