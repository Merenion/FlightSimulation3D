package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationOtherCA implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataOtherCA d = CalculationKA.getInstance().getDataOtherCA();
            DataOETK dOetk = CalculationKA.getInstance().getDataOETK();
            DataSPPE dSppi = CalculationKA.getInstance().getDataSPPE();
            DataVRL dVrl = CalculationKA.getInstance().getDataVRL();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Расчет
            float mZA=(dOetk.mOETK+dSppi.mSPPI+dVrl.mVRL)/(1-d.kPrZA/100);
            d.mPrZA=mZA-(dOetk.mOETK+dSppi.mSPPI+dVrl.mVRL);
            d.vPrZA=d.mPrZA/d.plPrZA;
            d.wPrZA=d.uwPrZA*d.mPrZA;
            //Расчет приведенного момента инерции КА с текущими габаритами и массой
            d.jPrZA=d.mPrZA*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENTS_CA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENTS_CA);
            throw new Exception();
        }
        return object;
    }
}
