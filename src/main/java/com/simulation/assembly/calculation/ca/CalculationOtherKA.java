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

            d.mPrKA = 0f;
            d.vPrKA = 0f;
            d.jPrKA = 0f;
            d.wPrKA = 0f;

            for (DataOtherKA element : d.getOthers()) {
                if (!element.isImportElement()) {
                    element.mPrKA = element.omPrKA / 100 * dc.mKA;
                    element.vPrKA = element.mPrKA / element.plPrKA;
                    element.jPrKA = element.mPrKA * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                    element.wPrKA = element.uwPrKA * element.mPrKA;
                }
                d.mPrKA = d.mPrKA + element.mPrKA;
                d.vPrKA = d.vPrKA + element.vPrKA;
                d.jPrKA = d.jPrKA + element.jPrKA;
                d.wPrKA = d.wPrKA + element.wPrKA;

                CalculationKA.getInstance().calculation(new Object());
            }

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENT_KA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENT_KA);
            throw new Exception();
        }
        return object;
    }
}
