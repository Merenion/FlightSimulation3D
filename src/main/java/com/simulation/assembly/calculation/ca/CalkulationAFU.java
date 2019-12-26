package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataAFU;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalkulationAFU extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.AFU;
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
            DataAFU d = CalculationKA.getInstance().getDataAFU();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {



                d.m = (d.omAFU / 100) * dc.mKA;
                d.v = d.m / d.plAFU;
                d.j = d.m * (dc.dKA / 2) * (dc.dKA / 2);
            }
            if (d.isCalculationMoment()){
                d.j = d.m * (dc.dKA / 2) * (dc.dKA / 2);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.AFU);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.AFU);
            throw new Exception();
        }
        return object;
    }
}
