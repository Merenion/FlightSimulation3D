package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationKDU extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS;
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
            DataKDU d = CalculationKA.getInstance().getDataKDU();
            DataMassTopl dataMassTopl = CalculationKA.getInstance().getDataMassTopl();
            DataSpeed dataSpeed = CalculationKA.getInstance().getDataSpeed();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                d.mKDU = (d.s / (d.s - 1)) * dataMassTopl.m;
                d.m = d.mKDU - dataMassTopl.m;

                d.Vok = dataMassTopl.mO / dataMassTopl.pLO;
                d.Vg = dataMassTopl.mG / dataMassTopl.pLG;
                //Wb:=Wok+Wg;
                d.VbOk = d.Vok * (1 + d.kNTB / 100);
                d.VbG = d.Vg * (1 + d.kNTB / 100);
                d.Vb = d.VbOk + d.VbG;
                d.VKDU = d.kpVKDU_Vb * d.Vb;
                d.v = d.kpVOKA_VKDU * d.VKDU;
                d.hKDU = (float) (d.v / (Math.PI * d.dKDU / 4));
                d.pKDU = d.mKDU / d.v;
                d.JxKDU = d.mKDU * (d.dKDU * d.dKDU) / 8;
                d.JyKDU = d.mKDU * ((d.dKDU * d.dKDU) / 16 + (d.hKDU * d.hKDU) / 12);
                d.j = d.mKDU / dc.krkKA * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                d.w = d.umKDU * d.mKDU;
            }
            if (d.isCalculationMoment()){
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS);
            throw new Exception();
        }
        return object;
    }
}
