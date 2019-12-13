package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataActivSOTR;
import com.simulation.assembly.dataCalculation.sintez.DataBAKES;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalculationActivSOTR extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.ACTIV_ELEMENT_SOTR;
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
                DataActivSOTR d = CalculationKA.getInstance().getDataActivSOTR();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                d.mSTR = d.omSTR * dc.mKA;
                d.mtnSTR = d.mSTR * d.kmtnSTR / 100;
                d.mSTRbtn = d.mSTR - d.mtnSTR;
                d.vSTR = d.mSTR / d.plSTR;
                d.wSTR = d.uwSTR * d.mSTR;
                d.jSTR = d.mSTR * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.ACTIV_ELEMENT_SOTR);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.ACTIV_ELEMENT_SOTR);
            throw new Exception();
        }
        return object;
    }
}
