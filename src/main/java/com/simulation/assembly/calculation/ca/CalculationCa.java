package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationCa implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {

        try {

            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            DataOETK dataOETK = CalculationKA.getInstance().getDataOETK();
            DataSPPE dataSPPE = CalculationKA.getInstance().getDataSPPE();
            DataVRL dataVRL = CalculationKA.getInstance().getDataVRL();
            DataOtherCA dataOtherCA = CalculationKA.getInstance().getDataOtherCA();
            DataCa dataCa = CalculationKA.getInstance().getDataCa();

            dataCa.mZA =          //Масса целевой аппаратуры, кг
                    dataOETK.mOETK     //Масса ОЭТК, кг
                    +dataSPPE.mSPPI    //Масса СППИ
                    +dataVRL.mVRL     //Масса ВРЛ
                    +dataOtherCA.mPrZA;     //Масса прочих элементов ЦА

            //Расчет объема ЦА
            dataCa.vZA=          //Объем целвойаппаратуры, м3
                    dataOETK.vOETK     //Объем ОЭТК, м3
                    +dataSPPE.vSPPI     //Объеи аппаратуры СППИ, м3
                    +dataVRL.vVRL      //Объеи аппаратуры ВРЛ, м3
                    +dataOtherCA.vPrZA;      //Объем прочих элементов ЦА, м3

            //Расчет мометна инерции ЦА
            dataCa.jZA=dataCa.mZA*((dc.dKA*dc.dKA)/16+(dc.lKA*dc.lKA)/12);

            dataCa.wZA=         //Мощность энергопотребления ЦА, Вт
                    dataOETK.wOETK    //Мощность энергопотребления ОЭТК, Вт
                    +dataSPPE.wSPPI   //Мощность аппаратуры СППИ, Вт
                    +dataVRL.wVRL    //Мощность аппаратуры ВРЛ, Вт
                    +dataOtherCA.wPrZA;    //Мощность прочих элементов ЦА, Вт

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
            return object;
    }
}
