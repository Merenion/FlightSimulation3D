package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;

public class CalculationSimpleSintez implements Calculation {
    @Override
    public Object calculation(Object object) {
        try {
            DataCommonParameters.dKA0 = (float) (DataCommonParameters.dzPN0*Math.exp(1/3*Math.log(DataCommonParameters.knzpOBT)));
            DataCommonParameters.lKA0= (float) (DataCommonParameters.lzPN0*Math.exp(1/3*Math.log(DataCommonParameters.knzpOBT)));
            //Средний объем КА, м3
            DataCommonParameters.vKA0= (float) (Math.PI*DataCommonParameters.dKA0*DataCommonParameters.dKA0/4*DataCommonParameters.lKA0);
            //Средняя плотность компоновки КА, кг/м3
            DataCommonParameters.splkKA0=DataCommonParameters.mKA0/DataCommonParameters.vKA0;
            DataCommonParameters.jKA0= (float) (DataCommonParameters.mKA0/DataCommonParameters.krkKA*(Math.pow(DataCommonParameters.dKA0,2)/16+Math.pow(DataCommonParameters.lKA0,2)/12));
            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Прикидочный по ограничениям Успешен! ", TabTypeSintez.RESTRICTION);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR,"Не верно введенные данные!", TabTypeSintez.RESTRICTION);
        }
        return object;
    }
}
