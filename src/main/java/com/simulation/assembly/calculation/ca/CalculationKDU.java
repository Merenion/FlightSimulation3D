package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationKDU implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataKDU d = CalculationKA.getInstance().getDataKDU();
            DataMassTopl dataMassTopl = CalculationKA.getInstance().getDataMassTopl();
            DataSpeed dataSpeed = CalculationKA.getInstance().getDataSpeed();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mKDU=(d.s/(d.s-1))*dataMassTopl.mTKDU;
            d.mkKDU=d.mKDU-dataMassTopl.mTKDU;

            d.Vok=dataMassTopl.mO/dataMassTopl.pLO;
            d.Vg=dataMassTopl.mG/dataMassTopl.pLG;
            //Wb:=Wok+Wg;
            d.VbOk=d.Vok*(1+d.kNTB/100);
            d.VbG = d.Vg*(1+d.kNTB/100);
            d.Vb=d.VbOk+d.VbG;
            d.VKDU=d.kpVKDU_Vb*d.Vb;
            d.V_OKA_KDU=d.kpVOKA_VKDU*d.VKDU;
            d.hKDU= (float) (d.V_OKA_KDU/(Math.PI*d.dKDU/4));
            d.pKDU=d.mKDU/d.V_OKA_KDU;
            d.JxKDU=d.mKDU*(d.dKDU*d.dKDU)/8;
            d.JyKDU=d.mKDU*((d.dKDU*d.dKDU)/16+(d.hKDU*d.hKDU)/12);
            d.jKDU=d.mKDU/dc.krkKA*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            d.wKDU=d.umKDU*d.mKDU;

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
