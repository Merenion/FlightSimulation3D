package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElectHaraktSEP;
import com.simulation.assembly.dataCalculation.sintez.DataPasivSOTR;
import com.simulation.assembly.dataCalculation.sintez.DataSumBetSEP;

public class CalculationSumBetSEP implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataSumBetSEP d = CalculationKA.getInstance().getDataSumBetSEP();
            DataElectHaraktSEP dataElectHaraktSEP = CalculationKA.getInstance().getDataElectHaraktSEP();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Требуемая площадь солнечной мощность батареи, м2
            d.sPSB=dataElectHaraktSEP.wBF*d.kp/(d.uwFP*d.kzPSB);
            //расчет массы панелей СБ
            d.mPSB=d.umPSB*d.sPSB;
            d.mPSB1=d.mPSB/d.nPSB;
            d.sPSB1=d.sPSB/d.nPSB;
            d.dPSB1= (float) Math.sqrt(d.sPSB1);
            d.lPSB1=d.sPSB1/d.dPSB1;
            //Расчет момента инерции панели СБ относительно оси, расположенной в пролкости
            // панели, перпендикулярной продрльной оси панели и проходящей через
            //  собственной центр масс
            d.jPSB1=d.mPSB1*(d.lPSB1*d.lPSB1)/12;
            //Расчет момента инерции всех панелей СБ относительно поперечной оси КА
            d.jPSB_KA=d.nPSB*(d.jPSB1+d.mPSB1*((dc.dKA*dc.dKA)/2));

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}