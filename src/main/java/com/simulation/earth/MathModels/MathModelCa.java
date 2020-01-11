package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.CaParameters;
import com.simulation.earth.manageSatellite.OrbitParameters;

import java.util.*;
import java.util.stream.Collectors;

public class MathModelCa extends DeterminateParameters {

    CaParameters caParameters;
    boolean Flag_Per1 = false;
    boolean Flag_Per1_1 = false;
    double t_Per;
    double alfa_Obzor;
    double t_per_sum;
    double t_per_sr;
    double Summa_Rasnosti_Kvadratov_Per;
    double Dispersija_Per;
    double SrKvOtklonenie_Per;
    double maxPeriodich;
    double minPeriodich;
    double nIntPer;
    double dnIntPer;

    private int sec;
    private int min;
    private int hours;
    private int day;
    private int vitok;

    private boolean changeSec;
    private boolean changeMin;
    private boolean changeHours;
    private boolean changeDay;
    private boolean changeVitok;

    List<Double> massiv_t_Per = new ArrayList<>();
    Set<Double> F_Per = new HashSet<>();
    Double[] mhf = new Double[999];

    public MathModelCa(OrbitParameters orbitPr, CaParameters caParameters) {
        super(orbitPr);
        this.caParameters = caParameters;
    }

    public boolean testMAth(double t, double deltaTime) {
        alfa_Obzor = Math.asin((flightAltitude(t, 0) + radiusPlanet) / radiusPlanet *
                Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180) /
                Math.sqrt(1 + Math.pow(Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180), 2)))
                - Math.acos(1 / Math.sqrt(1 + Math.pow(Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180), 2)));


        if ((!Flag_Per1) && isCheckObzorON(t, deltaTime)) {
            Flag_Per1_1 = true;
            massiv_t_Per.add(t_Per);
            t_Per = 0;
            if (massiv_t_Per.size() == 999) {
                massiv_t_Per.clear();
            }
        }
        t_Per = t_Per + deltaTime / 3600;

        Flag_Per1 = isCheckObzorON(t, deltaTime);

        return Flag_Per1;
    }

    public boolean isCheckObzorON(double t, double deltaTime) {
        final double FiGa = shirotaTockiTraseaPoleta(t, 0);
        final double Koord_Fi_ObjektNabL = caParameters.shON;
        final double Koord_Ld_ObjektNabL = caParameters.dolgON;
        final double LambdaGd = geosethicheskayDolgotaFor2D(t, 0);

        alfa_Obzor = Math.asin((flightAltitude(t, 0) + radiusPlanet) / radiusPlanet *
                Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180) /
                Math.sqrt(1 + Math.pow(Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180), 2)))
                - Math.acos(1 / Math.sqrt(1 + Math.pow(Math.tan(caParameters.maksUgolKAotNadira * Math.PI / 180), 2)));

        return (Math.abs(Math.acos(Math.sin(FiGa) * Math.sin(Koord_Fi_ObjektNabL * Math.PI / 180)
                + Math.cos(FiGa) * Math.cos(Koord_Fi_ObjektNabL * Math.PI / 180)
                * Math.cos(Koord_Ld_ObjektNabL * Math.PI / 180
                - LambdaGd))) < alfa_Obzor);
    }

    public void testMath2(double t, double deltaTime) {
        eventChangeTime(t);
        testMAth(t, deltaTime);

        if (!changeMin)
            return;

        t_per_sum = 0;
        for (double el : massiv_t_Per) {
            t_per_sum = t_per_sum + el;
        }

        if ((massiv_t_Per.size() > 1) && (changeHours = true)) {
            t_per_sr = t_per_sum / massiv_t_Per.size();
        }

        if ((massiv_t_Per.size() >= 1) && (changeDay)) {
            Summa_Rasnosti_Kvadratov_Per = 0;

            for (int i = 0; i <= massiv_t_Per.size() - 1; i++) {
                Summa_Rasnosti_Kvadratov_Per =
                        Summa_Rasnosti_Kvadratov_Per + Math.pow(massiv_t_Per.get(i) - t_per_sr, 2);
            }


            if (massiv_t_Per.size() > 1) {
                Dispersija_Per = Summa_Rasnosti_Kvadratov_Per / (massiv_t_Per.size() - 1);
            }

            massiv_t_Per = massiv_t_Per.stream().sorted().collect(Collectors.toList());
            SrKvOtklonenie_Per = Math.sqrt(Dispersija_Per);
            maxPeriodich = massiv_t_Per.stream().max(Double::compare).get();
            minPeriodich = massiv_t_Per.stream().min(Double::compare).get();

            F_Per.clear();
            for (int i = 0; i <= massiv_t_Per.size() - 1; i++) {
                F_Per.add(((i + 1d) / (massiv_t_Per.size())));
                if (F_Per.size()>=2000){
                    F_Per.remove(0);
                }
            }
            F_Per = F_Per.stream().sorted().collect(Collectors.toSet());


//                FormKur2.Chart1.SeriesList[0].AddXY(massiv_t_per[i], F_Per[i], '', clRed);

            //Ïîäãîòîâêà äàííûõ äëÿ ðàñ÷åòà ïëîòíîñòè âåðîÿòíîñòè è ôóíêöèè
            //ðàñïðåäåëåíèÿ ïðè iRer>30;
            if ((massiv_t_Per.size() > 30) && (changeDay = true)) {

                nIntPer = (int) (5 * Math.log(massiv_t_Per.size()) / Math.log(10));
                dnIntPer = (massiv_t_Per.get(massiv_t_Per.size() - 1) - massiv_t_Per.get(0)) / nIntPer;

                for (int i = 0; i <= massiv_t_Per.size() + 2; i++) {
                    mhf[i] = 0d;
                }
//                for i:=0 to i_Per +2 do mhf[i]:=0;

                int i = 0;      //Íà÷àëüíîå çíà÷åíèå íîìåðà ýëåìåíòà ìàññèâà ïåðèîäè÷íîñòè
                int j = 1;                       //Íà÷àëüíîå çíà÷åíèå íîìåðà èíòåðâàëà

                while (j <= nIntPer) {
                    double mi = 0;
                    while ((massiv_t_Per.get(i) < massiv_t_Per.get(0) + dnIntPer * j) && (i < massiv_t_Per.size() - 1)) {
                        mi = mi + 1;
                        mhf[j] = mi;     //Êîëè÷åñòâî ýëåìåíòîâ ìàññèâà â èíòåðâàëå j
                        i = i + 1;         //Ïåðåõîä ê äðóãîìó ýëåìåíòó ìàññèâó
                    }
                    j = j + 1;
                }
            }
        }
    }

    private void eventChangeTime(double t) {
        final int sec = (int) t;
        final int min = (int) t / 60;
        final int hours = (int) t / 3600;
        final int day = (int) t / 86400;
        final int vitok = (int) amountCoil(t);

        changeSec = false;
        if (sec != this.sec)
            changeSec = true;

        changeMin = false;
        if (min != this.min)
            changeMin = true;

        changeHours = false;
        if (hours != this.hours)
            changeHours = true;

        changeDay = false;
        if (day != this.day)
            changeDay = true;

        changeVitok = false;
        if (vitok != this.vitok)
            changeVitok = true;

        this.sec = sec;
        this.min = min;
        this.hours = hours;
        this.day = day;
        this.vitok = vitok;
    }

    public CaParameters getCaParameters() {
        return caParameters;
    }

    public boolean isFlag_Per1() {
        return Flag_Per1;
    }

    public boolean isFlag_Per1_1() {
        return Flag_Per1_1;
    }

    public double getT_Per() {
        return t_Per;
    }

    public double getAlfa_Obzor() {
        return alfa_Obzor;
    }

    public double getT_per_sum() {
        return t_per_sum;
    }

    public double getT_per_sr() {
        return t_per_sr;
    }

    public double getSumma_Rasnosti_Kvadratov_Per() {
        return Summa_Rasnosti_Kvadratov_Per;
    }

    public double getDispersija_Per() {
        return Dispersija_Per;
    }

    public double getSrKvOtklonenie_Per() {
        return SrKvOtklonenie_Per;
    }

    public double getMaxPeriodich() {
        return maxPeriodich;
    }

    public double getMinPeriodich() {
        return minPeriodich;
    }

    public double getnIntPer() {
        return nIntPer;
    }

    public double getDnIntPer() {
        return dnIntPer;
    }

    public List<Double> getMassiv_t_Per() {
        return massiv_t_Per;
    }

    public Set<Double> getF_Per() {
        return F_Per;
    }

    public Double[] getMhf() {
        return mhf;
    }

    public boolean isChangeSec() {
        return changeSec;
    }

    public boolean isChangeMin() {
        return changeMin;
    }

    public boolean isChangeHours() {
        return changeHours;
    }

    public boolean isChangeDay() {
        return changeDay;
    }

    public boolean isChangeVitok() {
        return changeVitok;
    }
}
