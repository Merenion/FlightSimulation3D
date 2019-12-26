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
            DataSudSGK dataSudSGK = CalculationKA.getInstance().getDataSudSGK();
            DataSSKM dataSSKM = CalculationKA.getInstance().getDataSSKM();
            DataSTKRP dataSTKRP = CalculationKA.getInstance().getDataSTKRP();
            DataBAKES dataBAKES = CalculationKA.getInstance().getDataBAKES();
            DataBETS dataBETS = CalculationKA.getInstance().getDataBETS();
            DataBVS dataBVS = CalculationKA.getInstance().getDataBVS();
            DataCommonParameters dc0 = CalculationKA.getInstance().getDataCommonParameters();
            DataOtherBKU dc = CalculationKA.getInstance().getDataOtherBKU();
            if (!getType().getDataElement().isImportData()) {


                float mBKU = (dataSudSGK.m + dataSSKM.m + dataSTKRP.m + dataBAKES.m + dataBETS.m + dataBVS.m) / (1 - dc.kPrBKU / 100);
                dc.m = mBKU - (dataSudSGK.m + dataSSKM.m + dataSTKRP.m + dataBAKES.m + dataBETS.m + dataBVS.m);
                dc.v = dc.m / dc.plPrBKU;
                dc.w = dc.uwPrBKU * dc.m;
                dc.j = dc.m * ((dc0.dKA * dc0.dKA) / 16 + (dc0.lKA * dc0.lKA) / 12);
            }

            if (dc.isCalculationMoment()){
                dc.j = dc.m * ((dc0.dKA * dc0.dKA) / 16 + (dc0.lKA * dc0.lKA) / 12);
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.OTHER_ELEMENTS_BKU);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OTHER_ELEMENTS_BKU);
            throw new Exception();
        }
        return object;
    }
}
