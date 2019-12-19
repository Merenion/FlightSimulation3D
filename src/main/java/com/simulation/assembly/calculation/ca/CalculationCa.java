package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationCa extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.CA;
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

                DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
                DataOETK dataOETK = CalculationKA.getInstance().getDataOETK();
                DataSPPE dataSPPE = CalculationKA.getInstance().getDataSPPE();
                DataVRL dataVRL = CalculationKA.getInstance().getDataVRL();
                DataOtherCA dataOtherCA = CalculationKA.getInstance().getDataOtherCA();
                DataCa dataCa = CalculationKA.getInstance().getDataCa();

                dataCa.m =          //Масса целевой аппаратуры, кг
                        dataOETK.m     //Масса ОЭТК, кг
                                + dataSPPE.m    //Масса СППИ
                                + dataVRL.m     //Масса ВРЛ
                                + dataOtherCA.m;     //Масса прочих элементов ЦА

                //Расчет объема ЦА
                dataCa.v =          //Объем целвойаппаратуры, м3
                        dataOETK.v     //Объем ОЭТК, м3
                                + dataSPPE.v     //Объеи аппаратуры СППИ, м3
                                + dataVRL.v      //Объеи аппаратуры ВРЛ, м3
                                + dataOtherCA.v;      //Объем прочих элементов ЦА, м3

                //Расчет мометна инерции ЦА
                dataCa.j = dataCa.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);

                dataCa.w =         //Мощность энергопотребления ЦА, Вт
                        dataOETK.w    //Мощность энергопотребления ОЭТК, Вт
                                + dataSPPE.w   //Мощность аппаратуры СППИ, Вт
                                + dataVRL.w    //Мощность аппаратуры ВРЛ, Вт
                                + dataOtherCA.w;    //Мощность прочих элементов ЦА, Вт
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.CA);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
