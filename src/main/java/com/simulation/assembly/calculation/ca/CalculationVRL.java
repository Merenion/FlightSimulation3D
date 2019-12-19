package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataVRL;

public class CalculationVRL extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.VRL;
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
            DataVRL d = CalculationKA.getInstance().getDataVRL();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            if (!getType().getDataElement().isImportData()) {

                //Расчет
                d.m = d.umVRL * d.sPI;
                d.v = d.m / d.plVRL;
                d.w = d.m * d.uwVRL;
                //Расчет приведенного момента инерции КА с текущими габаритами и массой
                d.j = 1092.5f; //TODO
//            d.jVRL=d.mVRL*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.VRL);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.VRL);
            throw new Exception();
        }
        return object;
    }
}
