package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;

public class CalculationOETK extends Calculation {

    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.OETK;
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
            DataOETK d = CalculationKA.getInstance().getDataOETK();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();
            if (!getType().getDataElement().isImportData()) {

                    ///// Расчет по моделям Куренкова

                if (d.iN_yr<0.5 || d.iN_yr>1.2){
                    ControllerAssembly.showError("Доступная для расчета рабочая длина волны должна быть\n больше 0.5 и меньше 1.2");
                    return object;
                }

                if (d.iN_yr<=0.6){
                    d.ouT_Lpzs_OETK = 6f;
                }else if (d.iN_yr>0.6 && d.iN_yr<=0.9){
                    d.ouT_Lpzs_OETK = 9f;
                } else if (d.iN_yr>0.9){
                    d.ouT_Lpzs_OETK = 13f;
                }

                //масса
                d.km_OETK = d.iN_kUD*d.iN_kp2dOETK;
                d.ouT_Dgl_OETK = (d.iN_yr/1000000)*(d.iN_H*1000)/(2*d.iN_k0*d.iN_Lm);
                d.m = (float) ((d.km_OETK*Math.PI*(d.iN_yr/1000000)*(d.iN_H*1000)*(d.iN_H*1000)/(2*d.iN_k0*d.iN_Lm*d.iN_Lm))*((d.iN_kp2dOETK*(d.iN_yr/1000000)/(4*d.iN_k0))+d.iN_kp2lOETK*(d.ouT_Lpzs_OETK/1000000)));

                //Обьем
                d.ouT_f_ecv_OETK = (float) (0.8086*(d.ouT_Lpzs_OETK/1000000)*d.ouT_Dgl_OETK/(d.iN_yr/1000000));
                d.ouT_lOETK =d.ouT_f_ecv_OETK*d.iN_kp2lOETK;
                d.ouT_dOETK =d.iN_kp2dOETK*d.ouT_Dgl_OETK;
                d.v = (float) (Math.PI * Math.pow(d.ouT_dOETK, 2) / 4 * d.ouT_lOETK);

                //электропотребление
                d.w = d.m *d.iN_uwOETK;

                d.ouT_Dvt_OETK = d.iN_q*d.ouT_Dgl_OETK;
                d.ouT_d_OETK11 = d.iN_q*d.ouT_f_ecv_OETK-d.iN_Delta;
                d.ouT_S2_OETK1 = d.iN_q*d.ouT_d_OETK11/(1-d.iN_q);
                d.ouT_f1_OETK = d.ouT_d_OETK11+d.ouT_S2_OETK1;
                d.ouT_r1_OETK = 2*d.ouT_f1_OETK;
                d.ouT_f2_OETK = (d.iN_q*d.ouT_f_ecv_OETK*(d.iN_Delta-d.iN_q*d.ouT_f_ecv_OETK))/(d.iN_Delta+d.ouT_f_ecv_OETK*(1-2*d.iN_q));
                d.b_OETK = Math.abs(d.ouT_f1_OETK/d.ouT_f_ecv_OETK);
                d.m_const = 1/d.b_OETK;
                d.ouT_d1_OETK= (float) (d.ouT_f1_OETK*Math.tan(2*d.wConst));
                d.ouT_d2_OETK= d.m_const *d.ouT_d1_OETK;
                //момент
                CalculationKA.getInstance().calculation(new Object());
                d.j = (float) ((d.m /(12*((dc.dKA/2)+dc.lKA)))*(3*Math.pow((dc.dKA/2),2)*((dc.dKA/2)+2*dc.lKA)+Math.pow(dc.lKA,2)*((3*dc.dKA/2)+dc.lKA)));

                if (d.isCalculationMoment()){
                    d.j = (float) ((d.m /(12*((dc.dKA/2)+dc.lKA)))*(3*Math.pow((dc.dKA/2),2)*((dc.dKA/2)+2*dc.lKA)+Math.pow(dc.lKA,2)*((3*dc.dKA/2)+dc.lKA)));
                }
                CalculationKA.getInstance().calculation(new Object());


                ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет ОЭТК Успешен! ", TabTypeSintez.OETK);
                    return d;

            } else {

                if (d.isCalculationMoment()){
                    d.j = d.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
                }
                CalculationKA.getInstance().calculation(new Object());
            }
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OETK);
            return d;
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OETK);
            throw new Exception();
        }
    }
}
