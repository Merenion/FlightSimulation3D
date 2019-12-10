package com.simulation.assembly.calculation.simple;

import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.calculation.Calculation;

public class CalculationCaDd implements Calculation {
    @Override
    public Object calculation(Object object) {
        if (!(object instanceof DataSimpleCalculation))
            return object;

        DataSimpleCalculation dsc = (DataSimpleCalculation) object;

        //Масса целевой аппа ату ы
        dsc.res_mZA1 = dsc.massaCa;

        //Вывод массы КА
        dsc.res_mKA0 = dsc.massaCa/(dsc.procCA/100);

        //Масса БКУ
        dsc.res_mBKU1 = dsc.procBKU / 100 * dsc.massaKa;
        //Масса СОТ
        dsc.res_mSOTR1 = dsc.procSOTR / 100 * dsc.massaKa;
        //Масса С П
        dsc.res_mSEP1 = dsc.procSEP / 100 * dsc.massaKa;
        //Масса КДУ
        dsc.res_mKDU1 = dsc.procKDU / 100 * dsc.massaKa;
        //Масса топлива КДУ
        dsc.res_mTKDU1 = dsc.procTOPLIVO / 100 * dsc.massaKa;
        //Масса конст укции
        dsc.res_mKonstr1 = dsc.procKONSTR / 100 * dsc.massaKa;
        //Масса БКС
        dsc.res_mBKS1 = dsc.procAFU / 100 * dsc.massaKa;
        //Масса п очих лементов КА
        dsc.res_mPr1 = dsc.procOTHERMAS / 100 * dsc.massaKa;
        //Резе в массы КА
        dsc.res_mReserv1 = dsc.procREZERV / 100 * dsc.massaKa;

        //Расчет габаритов обтекателя
        dsc.res_dzPN0 = dsc.diametr;
        dsc.res_lzPN0 = dsc.dlina;

        //Расчет среднего диаметра КА
        dsc.res_dKA0 = (float) (dsc.res_dzPN0*Math.exp(1f/3f*Math.log(dsc.koefNepolnZapoln)));
        //Расчет средней длины КА
        dsc.res_lKA0 = (float) (dsc.res_lzPN0*Math.exp(1f/3f*Math.log(dsc.koefNepolnZapoln)));
        //Расчет седнего объем КА, м3
        dsc.res_vKA0 = (float) (Math.PI*dsc.res_dKA0*dsc.res_dKA0/4*dsc.res_lKA0);
        //Плотность
        dsc.res_plotn = dsc.massaKa/dsc.res_vKA0;
        //Расчет приведенного момента инерции КА
        //(КА представлен в виде цилиндра с "размазанной" массой по объемв КА), кг/м3
        dsc.res_jKA0 = (float) (dsc.massaKa/dsc.koefRacKom*(Math.pow(dsc.res_dKA0,2)/16+Math.pow(dsc.res_lKA0,2)/12));
        return dsc;
    }
}
