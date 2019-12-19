package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationBKU extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.BKU;
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
                DataBKU dataBKU = CalculationKA.getInstance().getDataBKU();
                DataSudSGK dataSudSGK = CalculationKA.getInstance().getDataSudSGK();
                DataSSKM dataSSKM = CalculationKA.getInstance().getDataSSKM();
                DataSTKRP dataSTKRP = CalculationKA.getInstance().getDataSTKRP();
                DataBAKES dataBAKES = CalculationKA.getInstance().getDataBAKES();
                DataBETS dataBETS = CalculationKA.getInstance().getDataBETS();
                DataBVS dataBVS = CalculationKA.getInstance().getDataBVS();
                DataCommonParameters dc0 = CalculationKA.getInstance().getDataCommonParameters();
                DataOtherBKU dc = CalculationKA.getInstance().getDataOtherBKU();

                dataBKU.m =           //Масса БКУ, кг
                        dataSudSGK.m        //Масса СГК, кг
                                + dataSSKM.m      //Масса ССКМ
                                + dataSTKRP.m     //Масса СТКРП
                                + dataBAKES.m       //Масса КИС
                                + dataBETS.m      //Масса БИТС
                                + dataBVS.m
                                + dc.m;    //Масса прочих элементов БКУ

                //Расчет объема ЦА
                dataBKU.v =          //Объем БКУ, м3
                        dataSudSGK.v      //Объем СГК, м3
                                + dataSSKM.v     //Объем аппаратуры ССКМ, м3
                                + dataSTKRP.v    //Объем аппаратуры СТКРП, м3
                                + dataBAKES.v      //Объем аппаратуры КИС, м3
                                + dataBETS.v     //Объем аппаратуры БИТС, м3
                                + dataBVS.v     //Объем аппаратуры БВС, м3
                                + dc.v;   //Объем прочих элементов БКУ, м3

                //Расчет мометна инерции БКУ
                dataBKU.j = dataBKU.m * ((dc0.dKA * dc0.dKA) / 16 + (dc0.lKA * dc0.lKA) / 12);

                dataBKU.w =             //Мощность энергопотребления БКУ Вт
                        dataSudSGK.w        //Мощность энергопотребления СГК, Вт
                                + dataSSKM.w      //Мощность аппаратуры ССКМ, Вт
                                + dataSTKRP.w     //Мощность аппаратуры СТКРП, Вт
                                + dataBAKES.w       //Мощность аппаратуры КИС, Вт
                                + dataBETS.w      //Мощность аппаратуры БИТС, Вт
                                + dataBVS.w       //Мощность аппаратуры БВС, Вт
                                + dc.w;    //Мощность прочих элементов БКУ, Вт
            }
            CalculationKA.getInstance().calculation(new Object());

            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет Успешен! ", TabTypeSintez.BKU);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.BKU);
            throw new Exception();
        }
        return object;
    }
}
