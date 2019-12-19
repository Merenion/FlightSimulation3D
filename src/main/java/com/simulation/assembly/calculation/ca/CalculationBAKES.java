package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBAKES;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalculationBAKES extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BAKIS;
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
            if (!getType().getDataElement().isImportData()) {
                DataBAKES d = CalculationKA.getInstance().getDataBAKES();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                d.m = d.kmKIS / 100 * dc.mKA;
                d.v = d.m / d.plKIS;
                d.w = d.uwKIS * d.m;
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.BAKIS);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.BAKIS);
            throw new Exception();
        }
        return object;
    }
}
