package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataBETS;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalculationBETS extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BETS;
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
            DataBETS d = CalculationKA.getInstance().getDataBETS();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                d.m = d.kmBITS / 100 * dc.mKA;
                d.v = d.m / d.plBITS;
                d.w = d.uwBITS * d.m;
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            if (d.isCalculationMoment()){
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.BETS);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.BETS);
            throw new Exception();
        }
        return object;
    }
}
