package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataSudSGK;

public class CalculationSGK implements Calculation {
    @Override
    public Object calculation(Object object) {

        try {
            DataSudSGK d = (DataSudSGK) object;

            d.t1=60*d.Tzr/d.Pr1;
            d.eKA= (float) (2*(d.uKA/2)/Math.pow((d.t1/2),2));
            d.wKA=d.eKA*(d.t1/2);
            d.umKA= (float) (DataCommonParameters.jKA0*d.eKA*Math.PI/180);
            //if 12=1
            d.kmKA= (float) (DataCommonParameters.jKA0*d.wKA*Math.PI/180); //jka - может быть ошибка

            d.kmRGP= (float) (d.umKA/(d.wPrez*Math.PI/180));
            d.JRGP= (float) (d.kmRGP/(2*Math.PI*d.wRGP/60));
            d.rRGP= (float) Math.exp(0.2*Math.log(15*d.JRGP/(8*Math.PI*d.plRGP)));
            d.rRGP= (float) Math.exp(0.2*Math.log(2*d.JRGP/(Math.PI*d.plRGP)));
            d.vRGP= (float) (4/3*Math.PI*d.rRGP*d.rRGP*d.rRGP);
            d.mRGP= (float) (0.75*d.plRGP*d.vRGP);
            d.mGP=d.kmGP_RGP*d.mRGP;
            d.mEB=d.kmEB_mGP/100*d.mGP;
            d.mEB_GP=d.mEB+d.mGP;
            d.mSGK=4*d.mEB_GP;
            d.vGP=d.kmGP_RGP*d.vRGP;  //Расчет объема гироприбора
            d.vEB=d.mEB/d.pEB;        //Расчет объема электронного блока гироприбора
            DataCommonParameters.vSGK=d.vRGP+d.vGP;          //Объем СГК, м3
            //Расчет мощности СГК
            d.wSGK=d.uW_SGK*d.mSGK;
            d.dGP= (float) (2*Math.exp(1/3*Math.log(3/4/Math.PI*d.vGP)));  //Расчет среднего радиуса гироприбора
            DataCommonParameters.jSGK= (float) (d.mSGK*(Math.pow(DataCommonParameters.dKA0,2)/16+Math.pow(DataCommonParameters.lKA0,2)/12));
            ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет СГК Успешен! ", TabTypeSintez.SUD_SGK);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.SUD_SGK);
        }

        return object;
    }
}
