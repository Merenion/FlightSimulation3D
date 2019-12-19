package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalkulationBKSandAFU extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BKS_AND_AFU;
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

                DataBKSandAFU d = CalculationKA.getInstance().getDataBKSandAFU();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                d.mBKS = (d.omBKS / 100) * dc.mKA;
                d.mAFU = (d.omAFU / 100) * dc.mKA;
                d.vBKS = d.mBKS / d.plBKS;
                d.vAFU = d.mAFU / d.plAFU;
                d.m = d.mBKS + d.mAFU;
                d.v = d.vBKS + d.vAFU;
                d.jBKS = d.mBKS * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                d.jAFU = d.mAFU * (dc.dKA / 2) * (dc.dKA / 2);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.BKS_AND_AFU);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.BKS_AND_AFU);
            throw new Exception();
        }
        return object;
    }
}
