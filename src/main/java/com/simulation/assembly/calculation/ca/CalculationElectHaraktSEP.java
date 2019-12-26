package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCa;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElectHaraktSEP;

public class CalculationElectHaraktSEP extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.ELECTROTEH_PARAM;
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
            DataElectHaraktSEP d = CalculationKA.getInstance().getDataElectHaraktSEP();
            DataCa dataCa = CalculationKA.getInstance().getDataCa();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {


                //Расчет среднусуточной мощности КА, Вт
                d.wsSEP = d.kspSEP / 100 * dc.wKA_wsSEP;
                d.wKA = (dc.wKA_wsSEP + d.wsSEP);
                //Определение среднесуточного косинуса альфа
                d.CosA = (float) ((d.TobrKA / 1.8 - d.tZRKA) / d.TobrKA);
                //Расчет
                d.wBF = d.wKA / (d.kpdKAS / 100 * d.kpdAB / 100 * d.CosA);
                //Расчет максимального тока
                d.Imax = d.wBF / d.srU;
                //Расчет мощности КА при работе в тени
                d.wKAten = d.wKA - dataCa.w - d.wsSEP;
                //Расчет мощности КА при целевой работе
                d.wKAZR = d.wKA + dataCa.w + d.wsSEP;
                //Расчет потребной эрергии аккумулятьрных батарей
                d.eAB = (d.wKAten * d.TobrKA / 2 + d.wKAZR * d.tZRKA) / (d.kpdZU / 100 * d.kpdRU / 100 * 60);
                //Рсчет минимально необходимой емкости АБ
                d.cABmin = d.eAB / d.srU;
                //Рсчет необходимой емкости АБ с учетом запасо
                d.cAB = (d.kzAC + d.kzSR) / 100 * d.cABmin + d.cABmin;
                //Расчет емкости АБ с учетом изменения мощности за срок АС
                d.cAB_AS = d.cAB / (d.kdowAB / 100);
            }

            if (d.isCalculationMoment()){
                d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.ELECTROTEH_PARAM);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.ELECTROTEH_PARAM);
            throw new Exception();
        }
        return object;
    }
}
