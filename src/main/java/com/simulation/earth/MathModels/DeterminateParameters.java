package com.simulation.earth.MathModels;

import com.simulation.earth.manageSatellite.OrbitParameters;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;

/**
 * Класс содержит все формулы различных параметров полета спутника.
 * Через содержащиеся методы можно найти любой параметр полета,
 * задав парамметры орбиты и время
 */
public class DeterminateParameters {

    protected OrbitParameters orbitPr;

    protected double radiusPlanet = 6371;
    protected int gravitationalParameterPlanet = 398700; //гравитационный параметр Земли
    protected double omegaPlanet = 0.0000729211;

    public DeterminateParameters(OrbitParameters orbitPr) {
        this.orbitPr = orbitPr;
    }

    /**
     * Расчет радиуса апогея
     */
    public double apogeeRadius() {
        return radiusPlanet + orbitPr.getHa();
    }

    /**
     * Расчет радиуса перегея
     */
    public double perigeeRadius() {
        return radiusPlanet + orbitPr.getHpi();
    }

    /**
     * Расчет эксцентриситета орбиты (e)
     */
    public double orbitalEccentricity() {
        double apogeeRadius = apogeeRadius();
        double perigeeRadius = perigeeRadius();
        return (apogeeRadius - perigeeRadius) / (apogeeRadius + perigeeRadius);
    }

    /**
     * Расчет большая полуось (a)
     */
    public double bigPolAxis() {
        return (perigeeRadius() + apogeeRadius()) / 2;
    }

    /**
     * Расчет локального параметра орбиты (p)
     */
    public double localOrbitParameter() {
        return bigPolAxis() * (1 - Math.pow(orbitalEccentricity(), 2));
    }

    /**
     * Расчет радиус-вектор КА от центр (r)
     */
    public double hightFlightFromCenter(double t, double tau) {
        double localOrbitParameter = localOrbitParameter();
        double orbitalEccentricitys = orbitalEccentricity();
        return localOrbitParameter / (1 + orbitalEccentricitys * Math.cos(angleOfTrueAnomaly(t,tau)));
    }

    /**
     * Расчет высота полета (H)
     */
    public double flightAltitude(double t, double tau) {
        return hightFlightFromCenter(t, tau) - radiusPlanet;
    }

    /**
     * Расчет период обращения звездный (Tzv)
     */
    public double starsPeriodRotation() {
        return 2 * Math.PI * Math.sqrt(Math.pow(bigPolAxis(), 3) / gravitationalParameterPlanet);
    }

    /**
     * Расчет векового возмущения первого порядка (dOmega)
     */
    public double vekovoeFirstOrderPerturbation() {
        return -35.052 / 60 * Math.PI / 180 * Math.pow((radiusPlanet /
                localOrbitParameter()), 2) * Math.cos(orbitPr.getIinRadian());
    }

    /**
     * Расчет векового возмущения аргумента перигея орбиты первого порядка (dw)
     */
    public double vekovoeFirstOrderPerturbationOfPerigee() {
        return -17.525 / 60 * Math.PI / 180 * Math.pow((radiusPlanet /
                localOrbitParameter()), 2) * (1 - 5 * Math.pow(Math.cos(orbitPr.getIinRadian()), 2));
    }

    /**
     * Расчет количесва витков (Ncoil)
     */
    public double amountCoil(double t) {
        return t / starsPeriodRotation();
    }

    /**
     * Текущий угол восходящего узла орбиты, рад (omega)
     */
    public double nowAngelVoshodychegoUzla(double t) {
        return orbitPr.getOmega0inRadian() + t / starsPeriodRotation() * vekovoeFirstOrderPerturbation();
    }

    /**
     * Текущее значение аргумента перигея (W)
     */
    public double nowAmountArgumentPerigee(double t) {
        return orbitPr.getW0inRadian() * Math.PI / 180 + t / starsPeriodRotation() * vekovoeFirstOrderPerturbationOfPerigee();
    }

    /**
     * Определение среднего движения (n)
     */
    public double opredelenieSrednegoDvizeniy() {
        return Math.sqrt(gravitationalParameterPlanet / Math.pow(bigPolAxis(), 3));
    }

    /**
     * Определение промежутка среднего времени с момента прохождения перигея до момента наблюдения (dt_sr)
     */
    public double promezutokSrednegoTimeOfPerigeeToMomentNabludeniy(double t, double tau) {
        return t - tau;
    }

    /**
     * Звездное время (t_zv)
     */
    public double timeStars(double t, double tau) {
        return 1.00273791 * promezutokSrednegoTimeOfPerigeeToMomentNabludeniy(t, tau);
    }

    /**
     * Определение средней аномалии (M)
     */
    public double meanAnomaly(double t, double tau) {
        return timeStars(t, tau) * opredelenieSrednegoDvizeniy();
    }

    /**
     * Период обращения звездный (Tpsv)
     */
    public double stellarRotationPeriod() {
        return 2 * Math.PI * Math.sqrt(Math.pow(bigPolAxis(), 3) / gravitationalParameterPlanet);
    }

    /**
     * Эксцентрическая аномалия (Ea)
     */
    public double eccentricAnomaly(double t, double tau) {
        double M = meanAnomaly(t, tau);
        double e = orbitalEccentricity();
        double E01 = M + e * Math.sin(M) + (e * e / 2) * Math.sin(2 * M);        //Первый член разложения уравнения Кеплера (E-e*sin(E)=M
        double E02 = e * e * e / 24 * (9 * Math.sin(3 * M) - 3 * Math.sin(M)); //Второй член разложения и т.д.
        double E03 = Math.pow(e, 4) / (24 * 8) * (64 * Math.sin(4 * M) - 32 * Math.sin(2 * M));
        double E04 = Math.pow(e, 4) / (120 * 16) * (625 * Math.sin(5 * M) + 5 * 81 * Math.sin(3 * M) + 10 * Math.sin(M));
        double E05 = Math.pow(e, 5) / (720 * 32) * (36 * 36 * 6 * Math.sin(6 * M) - 6 * 256 * 4 * Math.sin(4 * M) + 15 * 32 * Math.sin(2 * M));
        double Ea = E01 + E02 + E03 + E04 + E05;
        return Ea;
    }

    /**
     * Эксцентрическая аномалия приведенная к одному витку (Ea0)
     */
    public double eccentricAnomalyOneCoil(double t, double tau) {
        double Ea = eccentricAnomaly(t, tau);
        return Ea - 2 * Math.PI * ((int) (Ea / (2 * Math.PI)));
    }

    /**
     * Расчт угла истинной аномалии (TetaSmall)
     */
    public double angleOfTrueAnomaly(double t, double tau) {
        double e = orbitalEccentricity();
        double Ea = eccentricAnomaly(t, tau);
        double sinTetaSmall = Math.sqrt(1 - e * e) * Math.sin(Ea) / (1 - e * Math.cos(Ea));
        double cosTetaSmall = (Math.cos(Ea) - e) / (1 - e * Math.cos(Ea));
        double tetaSmall =  Math.atan(Math.sqrt(1 - cosTetaSmall * cosTetaSmall) / cosTetaSmall);
        if (sinTetaSmall > 0 && cosTetaSmall < 0) tetaSmall = tetaSmall + Math.PI;
        if (sinTetaSmall < 0 && cosTetaSmall < 0) tetaSmall = Math.PI - tetaSmall;
        if (sinTetaSmall < 0 && cosTetaSmall > 0) tetaSmall = 2 * Math.PI - tetaSmall;
        return tetaSmall;
    }

    /**Аргумент широты (u)*/
    public double argumentShiroti (double t,double tau){
        return nowAmountArgumentPerigee(t) + angleOfTrueAnomaly(t,tau);
    }

    /**Широта точки трассы полета (fiGA)*/
    public double shirotaTockiTraseaPoleta (double t,double tau) {
        double u = argumentShiroti(t, tau);
        double sinFi = Math.sin(orbitPr.getIinRadian()) * Math.sin(u);
        double cosFi = Math.sqrt(1 - sinFi * sinFi);
        double fiGA = Math.atan(sinFi / Math.sqrt(1 - sinFi * sinFi));
        return fiGA;
    }

    /**Геодезическая широта (lambdaGaSH)*/
    public double geosethicheskayShirotaFor2D(double t, double tau){
        if (t==101401){
            double u = argumentShiroti(t, tau);
        }

        if (t==10001){
            double u = argumentShiroti(t, tau);
        }
        double u = argumentShiroti(t, tau);
        double iRad = orbitPr.getIinRadian();
        double fiGA = shirotaTockiTraseaPoleta(t, tau);
        double omega = nowAngelVoshodychegoUzla(t);
        double sinlambdaGA = (Math.sin(omega) * Math.cos(u) + Math.cos(omega) * Math.cos(iRad) * Math.sin(u)) / Math.cos(fiGA);
        double coslambdaGA = (Math.cos(omega) * Math.cos(u) - Math.sin(omega) * Math.cos(iRad) * Math.sin(u)) / Math.cos(fiGA);
        double lambdaGaSh = 0;
        if (sinlambdaGA > 0 && coslambdaGA > 0)
            lambdaGaSh = Math.atan(sinlambdaGA / Math.sqrt(1 - sinlambdaGA * sinlambdaGA));
        if (sinlambdaGA > 0 && coslambdaGA < 0)
            lambdaGaSh = Math.PI + Math.atan(Math.sqrt(1 - coslambdaGA * coslambdaGA) / coslambdaGA);
        if (sinlambdaGA < 0 && coslambdaGA < 0)
            lambdaGaSh = Math.PI - Math.atan(sinlambdaGA / Math.sqrt(1 - sinlambdaGA * sinlambdaGA));
        if (sinlambdaGA < 0 && coslambdaGA > 0) {
            lambdaGaSh = -Math.atan(Math.sqrt(1 - coslambdaGA * coslambdaGA) / coslambdaGA);
            double ll = Math.sqrt(1 - coslambdaGA * coslambdaGA) / coslambdaGA;
        }
        return lambdaGaSh;
    }

    /**Геодезическая широта (lambdaGaDL)*/
    public double geosethicheskayDolgotaFor2D (double t,double tau){
        double lambdaGaDL = geosethicheskayShirotaFor2D(t, tau) - omegaPlanet * (t - (24 * 3600) *
                ((int) (t / (24 * 3600)))) - vekovoeFirstOrderPerturbation() * t / starsPeriodRotation();
        if (lambdaGaDL < -Math.PI) lambdaGaDL = lambdaGaDL + 2 * Math.PI;
        if (lambdaGaDL < -Math.PI) lambdaGaDL = lambdaGaDL + 2 * Math.PI;
        if (lambdaGaDL > Math.PI) lambdaGaDL = lambdaGaDL - 2 * Math.PI;
        if (lambdaGaDL > Math.PI) lambdaGaDL = lambdaGaDL - 2 * Math.PI;
        if (lambdaGaDL > Math.PI) lambdaGaDL = lambdaGaDL - 2 * Math.PI;
        if (lambdaGaDL > Math.PI) lambdaGaDL = lambdaGaDL - 2 * Math.PI;
        return lambdaGaDL;
    }

    /**Координаты на 2D плоскости*/
    public Point2D сoordinate2DMap (CenterPane centerPane,double t,double tau){
        double x = centerPane.getX0i() + ((int) (centerPane.getmX() * (float) geosethicheskayDolgotaFor2D(t, tau) * 180 / Math.PI));
        double y = centerPane.getY0i() - ((int) (centerPane.getmY() * (float) shirotaTockiTraseaPoleta(t, tau) * 180 / Math.PI));
        return new Point2D(x,y);
    }

    /**Геодезические координаты*/
    public Point3D geodeticСoordinates (double t, double tau) {
        double u = argumentShiroti(t, tau);
        double iRad = orbitPr.getIinRadian();
        double omega = nowAngelVoshodychegoUzla(t);
        double r = hightFlightFromCenter(t, tau);
        double Xga = r * (Math.cos(omega) * Math.cos(u) - Math.sin(omega) * Math.sin(u) * Math.cos(iRad));
        double Zga = r * (Math.sin(omega) * Math.cos(u) + Math.cos(omega) * Math.sin(u) * Math.cos(iRad));
        double Yga = -r * Math.sin(u) * Math.sin(iRad);
        return new Point3D(Xga,Yga,Zga);
    }

}
