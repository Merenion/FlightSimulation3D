package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import com.simulation.assembly.dataCalculation.sintez.TypeKa;

public class CalculationOETK implements Calculation {
    @Override
    public Object calculation(Object object) throws Exception {

        try {
            DataOETK d = CalculationKA.getInstance().getDataOETK();
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            //Расчет
            if (d.typeKA.equals(TypeKa.BIG)) {
                ///// Расчет по моделям Куренкова

                d.fOETK = d.H * 1000 * d.rELPZS * 2 / 1000 / 1000 / d.Det;
                d.lOETK = d.fOETK / d.kUD;

                //Средняя длина, рассчитанная из условий ограничений, м

                if (dc.isHaveRestriction && d.lOETK > dc.lKA0) {
                    ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка! Длина ОЭТК больше чем длина КА! Измение ИД по ОЭТК", TabTypeSintez.OETK);
                    return d;
                }

                d.dOETK = d.fOETK / d.oO;

                if (dc.isHaveRestriction && d.dOETK > dc.dKA0) {
                    ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка! Диаметр ОЭТК больше чем диаметр КА! Измение ИД по ОЭТК ", TabTypeSintez.OETK);
                    return d;
                }

                d.vOETK = (float) (Math.PI * Math.pow(d.dOETK, 2) / 4 * d.lOETK);

                if (dc.isHaveRestriction && d.vOETK > dc.vKA0) {
                    ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка! Объем ОЭТК больше чем объем КА! Измение ИД по ОЭТК ", TabTypeSintez.OETK);
                    return d;
                }

                d.mOETK = d.plOETK * d.vOETK;

                if (dc.isHaveRestriction && d.mOETK > dc.mKA0) {
                    ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка! Масса ОЭТК больше чем масса КА! Измение ИД по ОЭТК ", TabTypeSintez.OETK);
                    return d;
                }

                d.jOETK = (float) (d.mOETK / d.krkOETK * (Math.pow(d.dOETK, 2) / 16 + Math.pow(d.lOETK, 2) / 12));
                d.wOETK = d.uwOETK * d.mOETK;

                //Расчет габаоитов корпуса спецотсека КА
                d.dkSO_OETK = d.kp2dOETK * d.dOETK;
                d.lkSO_OETK = d.kp2lOETK * d.lOETK;
                d.vkSO_OETK = (float) (Math.PI * Math.pow(d.dkSO_OETK, 2) / 4 * d.lkSO_OETK);//Объем корпуса спецотсека КА
                CalculationKA.getInstance().calculation(new Object());

                ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет ОЭТК Успешен! ", TabTypeSintez.OETK);
                return d;
            }

            if (d.typeKA.equals(TypeKa.MIDDLE)) {
                /////Расчет по моделям Горбунова (диапазон 5...20 м)
                d.fOETK = d.H * 1000 * d.rELPZS * 2 / 1000 / 1000 / d.Det;
                d.lOETK = d.fOETK / d.kUD;
                d.dOETK = d.fOETK / d.oO;
                d.vOETK = (float) (Math.PI * Math.pow(d.dOETK, 2) / 4 * d.lOETK);
                //Измененный расчет
                d.mOETK = (float) (34.826 * Math.exp(-0.3714 * Math.log(d.Det)));

                d.jOETK = (float) (d.mOETK / d.krkOETK * (Math.pow(d.dOETK, 2) / 16 + Math.pow(d.lOETK, 2) / 12));
                d.wOETK = d.uwOETK * d.mOETK;

                //Расчет габаоитов корпуса спецотсека КА
                d.dkSO_OETK = d.kp2dOETK * d.dOETK;
                d.lkSO_OETK = d.kp2lOETK * d.lOETK;
                d.vkSO_OETK = (float) (Math.PI * Math.pow(d.dkSO_OETK, 2) / 4 * d.lkSO_OETK);//Объем корпуса спецотсека КА
                CalculationKA.getInstance().calculation(new Object());

                ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет ОЭТК Успешен! ", TabTypeSintez.OETK);
                return d;
            }

            if (d.typeKA.equals(TypeKa.SAMLL) && d.Det <= 5 && d.Det > 0.6) {
                /////Расчет по моделям Горбунова (диапазон 5...20 м)
                d.fOETK = d.H * 1000 * d.rELPZS * 2 / 1000 / 1000 / d.Det;
                d.lOETK = d.fOETK / d.kUD;
                d.dOETK = d.fOETK / d.oO;
                d.vOETK = (float) (Math.PI * Math.pow(d.dOETK, 2) / 4 * d.lOETK);
                //Измененный расчет
                d.mOETK = (float) (51.812 * Math.exp(-0.6707 * Math.log(d.Det)));

                d.jOETK = (float) (d.mOETK / d.krkOETK * (Math.pow(d.dOETK, 2) / 16 + Math.pow(d.lOETK, 2) / 12));
                d.wOETK = d.uwOETK * d.mOETK;

                //Расчет габаоитов корпуса спецотсека КА
                d.dkSO_OETK = d.kp2dOETK * d.dOETK;
                d.lkSO_OETK = d.kp2lOETK * d.lOETK;
                d.vkSO_OETK = (float) (Math.PI * Math.pow(d.dkSO_OETK, 2) / 4 * d.lkSO_OETK);//Объем корпуса спецотсека КА
                CalculationKA.getInstance().calculation(new Object());


                ControllerAssembly.addMessInConsoleSintez(MessegeType.INFO, "Расчет ОЭТК Успешен! ", TabTypeSintez.OETK);
                return d;
            } else if (d.typeKA.equals(TypeKa.SAMLL)) {
                ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Детальность должна быть <=5 и >0.6 ", TabTypeSintez.OETK);
                return d;
            }
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OETK);
            return d;
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные! Ошибка при расчете", TabTypeSintez.OETK);
            throw new Exception();
        }

    }
}
