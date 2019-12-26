package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalkulationBKS extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BKS;
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
            DataBKS d = CalculationKA.getInstance().getDataBKS();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                d.m = (d.omBKS / 100) * dc.mKA;
                d.v = d.m / d.plBKS;
                d.j = d.m * (dc.dKA / 2) * (dc.dKA / 2);
            }
            if (d.isCalculationMoment()){
                d.j = d.m * (dc.dKA / 2) * (dc.dKA / 2);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.BKS);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.BKS);
            throw new Exception();
        }
        return object;
    }
}
