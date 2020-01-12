package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;
import javafx.geometry.Point3D;

/**
 * математическая модель, отсюда можно получить различную информацию полета спутника
 * (Реализованно не полностью)
 */
public class MathModelSatelite extends DeterminateParameters implements GeodeticLocation {

    public MathModelSatelite(OrbitParameters orbitPr) {
        super(orbitPr);
    }

    /**
     * Геодезические координаты
     *
     * @param t время в которое необходимо узнать координаты
     * @return точка содержащая координаты xyz
     */
    public Point3D getGeodeticCoordinats(double t) {
        return geodeticСoordinates(t, 0);
    }

//    //Расчет координат единичного вектора в направлени на Солнце в неподвижной геоцентрической системе координат
//    private void rashetEdVektNapravlNaSolnzVNepodvSistKoord(double t) {
//        pereschetParametersIsNeed(t);
//        //Расчет угла между направлением на точку весеннего равноденствия
//        // и направлением на Солнце
//        double ac = 2 * Math.PI / (365.2422 * 24 * 3600) * t;
//        //Расчет проекций вектора
//        double Sx = Math.cos(ac);
//        double Sy = Math.sin(ac) * Math.cos(dc);
//        double Sz = Math.sin(ac) * Math.sin(dc);
//
//        //Расчет координат центра светового пятна
//        // Расчет широты точки поверхности Земли, в которой Солнце нахдится в зените
//        shirotaZenitnTochki = Math.asin(Sz);                                                //Ранее была ошибка arctan(Sz) (Науменко);
//
//        // Расчет долготы точки поверхности Земли, в которой Солнце нахдится в зените
//        double Cos_Dolgota_Zenitn_Tochki = Sx / Math.cos(shirotaZenitnTochki);
//        double Sin_Dolgota_Zenitn_Tochki = Sy / Math.cos(shirotaZenitnTochki);
//
//        //Предохранение от неточностей расчета
//        if (Sin_Dolgota_Zenitn_Tochki > 1) Sin_Dolgota_Zenitn_Tochki = 1;
//        if (Sin_Dolgota_Zenitn_Tochki < -1) Sin_Dolgota_Zenitn_Tochki = -1;
//        if (Cos_Dolgota_Zenitn_Tochki > 1) Cos_Dolgota_Zenitn_Tochki = 1;
//        if (Cos_Dolgota_Zenitn_Tochki < -1) Cos_Dolgota_Zenitn_Tochki = -1;
//
//        //Определение квадранта, в котором находится Зенитна точка
//        //в неподвижной системе координат
//        if ((Sin_Dolgota_Zenitn_Tochki > 0) && (Cos_Dolgota_Zenitn_Tochki > 0))
//            dolgotaZenitnTochki = Math.asin(Sin_Dolgota_Zenitn_Tochki);
//        if ((Sin_Dolgota_Zenitn_Tochki > 0) && (Cos_Dolgota_Zenitn_Tochki < 0))
//            dolgotaZenitnTochki = Math.PI - Math.asin(Sin_Dolgota_Zenitn_Tochki);
//        if ((Sin_Dolgota_Zenitn_Tochki < 0) && (Cos_Dolgota_Zenitn_Tochki < 0))
//            dolgotaZenitnTochki = -Math.PI - Math.asin(Sin_Dolgota_Zenitn_Tochki);
//        if ((Sin_Dolgota_Zenitn_Tochki < 0) && (Cos_Dolgota_Zenitn_Tochki > 0))
//            dolgotaZenitnTochki = Math.asin(Sin_Dolgota_Zenitn_Tochki);
//        //Учет скорости вращения Земли
//        dolgotaZenitnTochki = dolgotaZenitnTochki - omegaZemli * (t - (24 * 3600) * (int) t / (24 * 3600)) - t / Tzv * dOmega;
//    }
//
//    public boolean isInTheSun(double t) {
//        pereschetParametersIsNeed(t);
//        rashetEdVektNapravlNaSolnzVNepodvSistKoord(t);
//        double alfa_Ten_Semli = Math.acos(Rz / (Rz + H));  //Определение центрального угла для КА, находящегося на границе тени Ранее была ошибка (Науменко) arcsin(Rs/(Rs+H));
//        double Shirota_Zentra_Teti = -shirotaZenitnTochki; //Определение широты центра теневого пятна
//        double Dolgota_Zentra_Teti = 0;
//
//        if ((dolgotaZenitnTochki >= 0) && (dolgotaZenitnTochki <= Math.PI)) //Определение долготы центра теневого пятна
//            Dolgota_Zentra_Teti = -Math.PI - dolgotaZenitnTochki;
//        if ((dolgotaZenitnTochki > -Math.PI) && (dolgotaZenitnTochki < 0))
//            Dolgota_Zentra_Teti = Math.PI + dolgotaZenitnTochki;
//
//        //Условие вхождения КА в тень Земли
//        return Math.abs(Math.acos(Math.sin(Shirota_Zentra_Teti) * Math.sin(fiGA)
//                + Math.cos(Shirota_Zentra_Teti) * Math.cos(fiGA) * Math.cos(lambdaGaDL - Dolgota_Zentra_Teti)))
//                < alfa_Ten_Semli;
//    }


}
