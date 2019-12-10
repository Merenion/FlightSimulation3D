package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationKAS implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataKAS d = CalculationKA.getInstance().getDataKAS();
            DataElectHaraktSEP dataElectHaraktSEP = CalculationKA.getInstance().getDataElectHaraktSEP();
            DataAcumBetSEP dataAcumBetSEP = CalculationKA.getInstance().getDataAcumBetSEP();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Расчет массы стабилизатора напряжения
            d.mSN=dataElectHaraktSEP.wKA/d.uwSN;
            //Расчет объема стабилизатора
            d.vSN=d.mSN/d.plSN;
            d.mZU=dataElectHaraktSEP.wKAten/d.uwZU;
            d.vZU=d.mZU/d.plZU;
            d.mRU=dataElectHaraktSEP.wKAZR/d.uwRU;
            d.vRU=d.mRU/d.plRU;
            //Расчет массы и габаритов КАС
            d.mKAS=d.mSN+dataAcumBetSEP.nAB*(d.mZU+d.mRU);
            d.vKAS= d.vSN+dataAcumBetSEP.nAB*(d.vZU+d.vRU);
            //Расчет массы корпусных частей КАС
            d.mkKas=d.kKAS/100*d.mKAS;
            //Расчет массы КАС с учетом массы корпусов
            d.mKASsum=d.mKAS+d.mkKas;
            d.vKASsum=(1+d.ProzV_vKAS/100)*d.vKAS;
            d.jKASsum=d.mKASsum*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.KAS);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.KAS);
            throw new Exception();
        }
        return object;
    }
}
