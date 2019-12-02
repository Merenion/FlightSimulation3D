package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationBKU implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {
        try {

            DataBKU dataBKU = new DataBKU();
            DataSudSGK dataSudSGK = CalculationKA.getInstance().getDataSudSGK();
            DataSSKM dataSSKM = CalculationKA.getInstance().getDataSSKM();
            DataSTKRP dataSTKRP = CalculationKA.getInstance().getDataSTKRP();
            DataBAKES dataBAKES = CalculationKA.getInstance().getDataBAKES();
            DataBETS dataBETS = CalculationKA.getInstance().getDataBETS();
            DataBVS dataBVS = CalculationKA.getInstance().getDataBVS();
            DataCommonParameters dc0 = CalculationKA.getInstance().getDataCommonParameters();
            DataOtherBKU dc = CalculationKA.getInstance().getDataOtherBKU();

            dataBKU.mBKU=           //Масса БКУ, кг
                dataSudSGK.mSGK        //Масса СГК, кг
                    +dataSSKM.mSSKM      //Масса ССКМ
                    +dataSTKRP.mSTKRP     //Масса СТКРП
                    +dataBAKES.mKIS       //Масса КИС
                    +dataBETS.mBITS      //Масса БИТС
                    +dataBVS.mBVS
                    +dc.mPrBKU;    //Масса прочих элементов БКУ

            //Расчет объема ЦА
            dataBKU.vBKU=          //Объем БКУ, м3
                dataSudSGK.vSGK      //Объем СГК, м3
                    +dataSSKM.vSSKM     //Объем аппаратуры ССКМ, м3
                    +dataSTKRP.vSTKRP    //Объем аппаратуры СТКРП, м3
                    +dataBAKES.vKIS      //Объем аппаратуры КИС, м3
                    +dataBETS.vBITS     //Объем аппаратуры БИТС, м3
                    +dataBVS.vBVS     //Объем аппаратуры БВС, м3
                    +dc.vPrBKU;   //Объем прочих элементов БКУ, м3

            //Расчет мометна инерции БКУ
            dataBKU.jBKU=dataBKU.mBKU*((dc0.dKA*dc0.dKA)/16+(dc0.lKA*dc0.lKA)/12);

            dataBKU.wBKU=             //Мощность энергопотребления БКУ Вт
                dataSudSGK.wSGK        //Мощность энергопотребления СГК, Вт
                    +dataSSKM.wSSKM      //Мощность аппаратуры ССКМ, Вт
                    +dataSTKRP.wSTKRP     //Мощность аппаратуры СТКРП, Вт
                    +dataBAKES.wKIS       //Мощность аппаратуры КИС, Вт
                    +dataBETS.wBITS      //Мощность аппаратуры БИТС, Вт
                    +dataBVS.wBVS       //Мощность аппаратуры БВС, Вт
                    +dc.wPrBKU;    //Мощность прочих элементов БКУ, Вт

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
