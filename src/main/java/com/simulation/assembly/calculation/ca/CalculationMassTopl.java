package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationMassTopl implements Calculation {

    @Override
    public Object calculation(Object object) throws Exception {
        try {
            DataMassTopl d = CalculationKA.getInstance().getDataMassTopl();
            DataSpeed dataSpeed = CalculationKA.getInstance().getDataSpeed();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            d.mTKAx= (float) (dc.mKA-dc.mKA/Math.exp(dataSpeed.dV/d.jT));
            //Расчет массы топлива с учетом незабора и гарантийного запаса
            d.mTKAg=d.kgzt/100*d.mTKAx;
            d.mTKAnz=d.knt/100*d.mTKAx;
            d.mTKAxnzg=d.mTKAx+d.mTKAg+d.mTKAnz;
            //Расчет массы топлива для сброса кинетического момента

            d.kakR=d.Tas*24/d.Tak;    //Количество астрокоррекций  (нецелое, расчетное число)
            d.kakZ=Math.round(d.kakR);  //Количество астрокоррекций  (целое, округленное число)
            d.mTKAskm=d.mTKDUskm1*d.kakZ; //Масса топлива для сброса кинетического момента
            //за весь срок АС
            d.mTKDU=d.mTKAxnzg+d.mTKAskm;
            d.mO=d.mTKDU*d.kOG/(1+d.kOG);
            d.mG=d.mTKDU*1/(1+d.kOG);

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.CA);
            throw new Exception();
        }
        return object;
    }
}
