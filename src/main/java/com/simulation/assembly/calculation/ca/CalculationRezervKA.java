package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationRezervKA extends Calculation {


    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.RETHERV;
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

                DataRezervKA d = CalculationKA.getInstance().getDataRezervKA();
                DataOtherKA dataOtherKA = CalculationKA.getInstance().getDataOtherKA();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                d.mRmKA = d.omRmKA / 100 * dc.mKA;
                d.vRmKA = d.mRmKA / d.plRmKA;
                d.jRmKA = dataOtherKA.mPrKA * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                d.wRmKA = d.uwRmKA * d.mRmKA;
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.RETHERV);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.RETHERV);
            throw new Exception();
        }
        return object;
    }
}
