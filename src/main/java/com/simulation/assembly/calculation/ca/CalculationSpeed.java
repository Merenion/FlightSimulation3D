package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationSpeed extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SPEED;
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
            DataSpeed d = CalculationKA.getInstance().getDataSpeed();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                //Определение добавки скорости, необходимой для перевода КА с низкой круговой
                //орбиты на эллиптическую орбиту
                d.ra = d.Rs + d.Ha;
                d.rp = d.Rs + d.Hp;
                d.a = (d.ra + d.rp) / 2;
                d.rkr1 = d.rp;
                d.Vkr1 = (float) (d.V1 * Math.sqrt(d.Rs / d.rkr1));
                d.Vp = (float) (d.V1 * Math.sqrt(d.Rs * (2 / d.rp - 1 / d.a)));
                d.dV1 = d.Vp - d.Vkr1;
                //Определение добавки скорости, необходимой для перевода КА с переходной
                //эллиптической орбиты на рабочую круговую орбиту

                d.rkr2 = d.ra;
                d.Vkr2 = (float) (d.V1 * Math.sqrt(d.Rs / d.rkr2));
                //ra:=rkr2;
                d.Va = (float) (d.V1 * Math.sqrt(d.Rs * (2 / d.ra - 1 / d.a)));
                d.dV2 = d.Vkr2 - d.Va;
                //Определение добавки зарактеристической скорости для изменения
                //плоскости орбиты
                d.di = d.iKA - d.iRN;
                d.dV3 = (float) (2 * d.Va * Math.sin(d.di * Math.PI / 2 / 180));
                //Определение добавки характеристической скорости для схода с рабочей
                //орбиты КА на низкую круговую орбиту (для подготовки к захоронению)
                d.roo = d.Rs + d.Hoo;
                d.aps = (d.roo + d.ra) / 2;
                d.Vaoo = (float) (d.V1 * Math.sqrt(d.Rs * (2 / d.ra - 1 / d.aps)));
                d.dV5 = d.Vkr2 - d.Vaoo;
                //Добавка характеристической скорости для схода с опорной орбиты для
                //захоронения КА
                //Расчет общей характеристической скорости
                d.dV = d.dV1 + d.dV2 + d.dV3 + d.dV5 + d.dV6;
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.SPEED);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SPEED);
            throw new Exception();
        }
        return object;
    }
}
