package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataSPPE;
import com.simulation.assembly.dataCalculation.sintez.DataVRL;

public class CalculationVRL implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataVRL d = CalculationKA.getInstance().getDataVRL();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Расчет
            d.mVRL=d.umVRL*d.sPI;
            d.vVRL=d.mVRL/d.plVRL;
            d.wVRL=d.mVRL*d.uwVRL;
            //Расчет приведенного момента инерции КА с текущими габаритами и массой
            d.jVRL=1092.5f; //TODO
//            d.jVRL=d.mVRL*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.VRL);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.VRL);
            throw new Exception();
        }
        return object;
    }
}
