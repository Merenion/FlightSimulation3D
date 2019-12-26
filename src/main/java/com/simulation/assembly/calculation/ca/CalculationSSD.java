package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataDUS;
import com.simulation.assembly.dataCalculation.sintez.DataSSD;

public class CalculationSSD extends Calculation {
    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SSD;
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
            DataSSD d = CalculationKA.getInstance().getDataSSD();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                d.m = d.km / 100 * dc.mKA;
                d.v = d.m / d.pl;
                d.w = d.uw * d.m;
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            if (d.isCalculationMoment()){
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.SSD);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SSD);
            throw new Exception();
        }
        return object;
    }
}
