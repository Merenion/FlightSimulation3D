package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataAcumBetSEP;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElectHaraktSEP;
import com.simulation.assembly.dataCalculation.sintez.DataPasivSOTR;

public class CalculationAcumBetSEP implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataAcumBetSEP d = CalculationKA.getInstance().getDataAcumBetSEP();
            DataElectHaraktSEP dataElectHaraktSEP = CalculationKA.getInstance().getDataElectHaraktSEP();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mAB=dataElectHaraktSEP.cAB_AS/d.uwAB;
            d.mAB1=d.mAB/d.nAB;
            d.vAB1=d.mAB1/d.plAB;
            d.vAB=d.mAB/d.plAB;
            d.lAB= (float) Math.exp((1f/3f)*Math.log(d.vAB1));
            d.jAB1=d.mAB1*(d.lAB*d.lAB)/6;
            d.jAB_KA= (float) (d.nAB*(d.jAB1+d.mAB1*(0.75*dc.dKA/2)*(0.75*dc.dKA/2)));
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.AKUM_BATTERIES);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.AKUM_BATTERIES);
            throw new Exception();
        }
        return object;
    }
}