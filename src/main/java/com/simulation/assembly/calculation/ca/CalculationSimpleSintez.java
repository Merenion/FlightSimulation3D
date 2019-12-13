package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalculationSimpleSintez extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.RESTRICTION;
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
                DataCommonParameters d = CalculationKA.getInstance().getDataCommonParameters();
                d.dKA0 = (float) (d.dzPN0 * Math.exp(Math.log(d.knzpOBT) / 3));
                d.lKA0 = (float) (d.lzPN0 * Math.exp(Math.log(d.knzpOBT) / 3));
//            d.dKA0 = (float) (d.lzPN0*Math.exp(Math.log(d.knzpOBT)/3));
//            d.lKA0= (float) (d.dzPN0*Math.exp(Math.log(d.knzpOBT)/3));
                //Средний объем КА, м3
                d.vKA0 = (float) (Math.PI * d.dKA0 * d.dKA0 / 4 * d.lKA0);
                //Средняя плотность компоновки КА, кг/м3
                d.splkKA0 = d.mKA0 / d.vKA0;
                d.jKA0 = (float) (d.mKA0 / d.krkKA * (Math.pow(d.dKA0, 2) / 16 + Math.pow(d.lKA0, 2) / 12));
            }

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Прикидочный по ограничениям Успешен! ", TabTypeSintez.RESTRICTION);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.RESTRICTION);
            throw new Exception();
        }
        return object;
    }
}
