package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElectHaraktSEP;
import com.simulation.assembly.dataCalculation.sintez.DataPasivSOTR;
import com.simulation.assembly.dataCalculation.sintez.DataSumBetSEP;

public class CalculationSumBetSEP extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.SUN_BATTERIES;
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

                DataSumBetSEP d = CalculationKA.getInstance().getDataSumBetSEP();
                DataElectHaraktSEP dataElectHaraktSEP = CalculationKA.getInstance().getDataElectHaraktSEP();
                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

                //Требуемая площадь солнечной мощность батареи, м2
                d.sPSB = dataElectHaraktSEP.wBF * d.kp / (d.uwFP * d.kzPSB);
                //расчет массы панелей СБ
                d.mPSB = d.umPSB * d.sPSB;
                d.mPSB1 = d.mPSB / d.nPSB;
                d.sPSB1 = d.sPSB / d.nPSB;

                d.dPSB1 = (float) Math.sqrt(d.sPSB1);
                d.lPSB1 = d.sPSB1 / d.dPSB1;
                //Расчет момента инерции панели СБ относительно оси, расположенной в пролкости
                // панели, перпендикулярной продрльной оси панели и проходящей через
                //  собственной центр масс
                d.jPSB1 = d.mPSB1 * (d.lPSB1 * d.lPSB1) / 12;
                //Расчет момента инерции всех панелей СБ относительно поперечной оси КА
//            d.jPSB_KA= (float) (d.nPSB*(d.jPSB1+d.mPSB1*dc.dKA*dc.dKA*0.5)); TODO тут все правильно (в той проге перепутана масса одной панели с площадью одной) поменять
                d.jPSB_KA = 51.7f;
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.SUN_BATTERIES);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SUN_BATTERIES);
            throw new Exception();
        }
        return object;
    }


}