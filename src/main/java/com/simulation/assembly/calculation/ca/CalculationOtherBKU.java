package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationOtherBKU extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OTHER_ELEMENTS_BKU;
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

                DataSudSGK dataSudSGK = CalculationKA.getInstance().getDataSudSGK();
                DataSSKM dataSSKM = CalculationKA.getInstance().getDataSSKM();
                DataSTKRP dataSTKRP = CalculationKA.getInstance().getDataSTKRP();
                DataBAKES dataBAKES = CalculationKA.getInstance().getDataBAKES();
                DataBETS dataBETS = CalculationKA.getInstance().getDataBETS();
                DataBVS dataBVS = CalculationKA.getInstance().getDataBVS();
                DataCommonParameters dc0 = CalculationKA.getInstance().getDataCommonParameters();
                DataOtherBKU dc = CalculationKA.getInstance().getDataOtherBKU();

                float mBKU = (dataSudSGK.mSGK + dataSSKM.mSSKM + dataSTKRP.mSTKRP + dataBAKES.mKIS + dataBETS.mBITS + dataBVS.mBVS) / (1 - dc.kPrBKU / 100);
                dc.mPrBKU = mBKU - (dataSudSGK.mSGK + dataSSKM.mSSKM + dataSTKRP.mSTKRP + dataBAKES.mKIS + dataBETS.mBITS + dataBVS.mBVS);
                dc.vPrBKU = dc.mPrBKU / dc.plPrBKU;
                dc.wPrBKU = dc.uwPrBKU * dc.mPrBKU;
                dc.jPrBKU = dc.mPrBKU * ((dc0.dKA * dc0.dKA) / 16 + (dc0.lKA * dc0.lKA) / 12);
                CalculationKA.getInstance().calculation(new Object());

                ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENTS_BKU);
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENTS_BKU);
            throw new Exception();
        }
        return object;
    }
}
