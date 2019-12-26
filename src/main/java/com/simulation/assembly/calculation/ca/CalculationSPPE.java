package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataSPPE;

public class CalculationSPPE extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SPPE;
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
            DataSPPE d = CalculationKA.getInstance().getDataSPPE();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                //Расчет
                d.m = d.umSPPI * d.sPI;
                d.v = d.m / d.plSPPI;
                d.w = d.m * d.uwSPPI;
                //Расчет приведенного момента инерции КА с текущими габаритами и массой
//                    d.j = 2375; //TODO удалить
                d.j = (float) (d.m * (Math.pow(dc.dKA, 2) / 16 + Math.pow(dc.lKA, 2) / 12));
            }
            if (d.isCalculationMoment()) {
                d.j = (float) (d.m * (Math.pow(dc.dKA, 2) / 16 + Math.pow(dc.lKA0, 2) / 12));
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.SPPE);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SPPE);
            throw new Exception();
        }
        return object;
    }
}
