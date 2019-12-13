package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationSOTR extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SOTR;
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

                DataSOTR d = CalculationKA.getInstance().getDataSOTR();
                DataPasivSOTR dataPasivSOTR = CalculationKA.getInstance().getDataPasivSOTR();
                DataActivSOTR dataActivSOTR = CalculationKA.getInstance().getDataActivSOTR();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                d.mSOTR = dataPasivSOTR.mEVTI + dataActivSOTR.mtnSTR + dataActivSOTR.mSTRbtn;
                //Масса СОТР без теплоносителя, кг
                d.mSOTRbtn = d.mSOTR - dataActivSOTR.mtnSTR;
                //Масса теплоносителя СТР, кг
                d.mtnSTR = dataActivSOTR.mtnSTR;
                //Объем ЭВТИ, приборов и агрегатов СТР, м3
                d.vSOTR = dataPasivSOTR.vEVTI + dataActivSOTR.vSTR;
                //Приведенный момент инерци СОТР, кг м2
                d.jSOTR = d.mSOTR * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                //Мощность приборов и агрегатов СТР, Вт/кг
                d.wSTR = dataActivSOTR.wSTR;
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.SOTR);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SOTR);
            throw new Exception();
        }
        return object;
    }
}
