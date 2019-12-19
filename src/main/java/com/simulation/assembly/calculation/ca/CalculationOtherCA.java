package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationOtherCA extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OTHER_ELEMENTS_CA;
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
            DataOtherCA d = CalculationKA.getInstance().getDataOtherCA();
            DataOETK dOetk = CalculationKA.getInstance().getDataOETK();
            DataSPPE dSppi = CalculationKA.getInstance().getDataSPPE();
            DataVRL dVrl = CalculationKA.getInstance().getDataVRL();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {

                //Расчет
                float mZA = (dOetk.m + dSppi.m + dVrl.m) / (1 - d.kPrZA / 100);
                d.m = mZA - (dOetk.m + dSppi.m + dVrl.m);
                d.v = d.m / d.plPrZA;
                d.w = d.uwPrZA * d.m;
                //Расчет приведенного момента инерции КА с текущими габаритами и массой
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENTS_CA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENTS_CA);
            throw new Exception();
        }
        return object;
    }
}
