package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

public class CalculationKA implements Calculation {

    private static CalculationKA singl;

    private DataCommonParameters dataCommonParameters;
    private DataOETK dataOETK;
    private DataSudSGK dataSudSGK;
    private DataSSKM dataSSKM;
    private DataSPPE dataSPPE;
    private DataVRL dataVRL;
    private DataOtherCA dataOtherCA;
    private DataCa dataCa;
    private DataSTKRP dataSTKRP;
    private DataBAKES dataBAKES;
    private DataBETS dataBETS;
    private DataBVS dataBVS;
    private DataOtherBKU dataOtherBKU;
    private DataBKU dataBKU;
    private DataActivSOTR dataActivSOTR;
    private DataPasivSOTR dataPasivSOTR;
    private DataSOTR dataSOTR;
    private DataElectHaraktSEP dataElectHaraktSEP;
    private DataAcumBetSEP dataAcumBetSEP;
    private DataKAS dataKAS;
    private DataSumBetSEP dataSumBetSEP;

    private CalculationKA() {
        init();
    }

    @Override
    public Object calculation(Object object) {
        dataCommonParameters.mKA =
                //Масса целевой аппаратуры, кг
                +dataOETK.mOETK                                      //Масса ОЭТК, кг
                        +dataSPPE.mSPPI                                      //Масса СППИ
//                        +mVRL                                       //Масса ВРЛ
//                        +mPrZA                                      //Масса прочих элементов ЦА
                        //Масса БКУ, кг
                        + dataSudSGK.mSGK                                       //Масса СГК
                        + dataSSKM.mSSKM                                      //Масса ССКМ, кг
//                        +mSTKRP                                     //Масса СТКРП, кг
//                        +mKIS                                       //Масса КИС, кг
//                        +mBITS                                      //Масса БИТС, кг
//                        +mBVS                                       //Масса КИС, кг
//                        +mPrBKU                                     //Масса прочих элементов БКУ
//                        Масса СОТР
//                        +mEVTI                                         //Масса ЭВТИ, кг
//                        +mSTR                                          //Масса СТР, кг
//                        Масса СЭП
//                        +mAB                                           //Масса всех АБ, кг
//                        +mKASsum   //Суммарная масса КАС с корпусными частями и проч. эл-тами
//                        +mPSB                                          //Масса панелей СБ
//                        Масса КДУ
//                        +mTKDU                                         //Масса топлива КДУ
//                        +mkKDU                                         //Масса конструкции КДУ
//                        +mkKA                                          //Масса конструкции КА
//                        +mBKS_AFU                                     //Масса БКС и АФУ, кг
//                        +mPrKA
//                        +mRmKA
        ;

        if (dataCommonParameters.mKA == 0) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не один из компонентов КА не расчитан");
        }

        //Расчет текущих объемов КА
        dataCommonParameters.vKA =
                +dataOETK.vkSO_OETK                             //Объем корпуса спецотсека КА
                +(dataSPPE.vSPPI                                 //Объем СППИ
//                +vVRL                                  //Объем ВРЛ
//                +vPrZA                                 //Объем прочих элементов ЦА
                        //Масса БКУ, кг
                        + dataSudSGK.vSGK                                  //Объем СГК
                        + dataSSKM.vSSKM                                 //Объем ССКМ, м3
//                +vSTKRP                                 //Объем СТКРП, м3
//                +vKIS                                   //Объем КИС, м3
//                +vBITS                                  //Объем БИТС, м3
//                +vBVS                                   //Объем КИС, м3
//                +vPrBKU)                                 //Объем прочих элементов БКУ
//                /(kpoPO/100)
        //Объем СОТР
//                +vEVTI                                  //Объем ЭВТИ, м3
//                +vSTR                                   //Объем СОТР, м3
//                /(kpoPO/100)
        //объем СЭП
//                +vAB                                    //Объем всех АБ
//                +vKASsum         //Объем КАС с учетом корпусных частей и прочих элементов
//                /(kpoPO/100)
//                +V_OKA_KDU       //Объем Отсека КА, где располагается КДУ
//                +vkKA                                   //Объем конструкции КА
//                +(vBKS_AFU
//                +vPrKA
//                +vRmKA)                              //Объем БКС и АФУ, м3
//                /(kpoPO/100)
                )
        ;

        //Расчет текущих габаритов КА
        //Расчет среднего диаметра КА
        dataCommonParameters.dKA = (float) Math.exp((1 / 3) * Math.log(4 * dataCommonParameters.vKA / (Math.PI * dataCommonParameters.udlKA)));
        //Расчет средней длины КА
        dataCommonParameters.lKA = dataCommonParameters.dKA * dataCommonParameters.udlKA;

        //Расчет максимального моментаинерции КА
        dataCommonParameters.jKA =
                //Приведенный момент инерци целевой аппаратуры, кг
                (dataOETK.jOETK     //Момент инерции ОЭТК, кг м2
                +dataSPPE.jSPPI     //Момент инерции СППИ
//                +jVRL      //Момент инерции ВРЛ
//                +jPrZA     //Момент инерции прочих элементов ЦА
                        //Приведенный момент инерции БКУ, кг м2
                        + dataSudSGK.jSGK      //Момент инерции СГК
                        + dataSSKM.jSSKM     //Момент инерции ССКМ, кг м2
//                +jSTKRP    //Момент инерции СТКРП, кг м2
//                +jKIS      //Момент инерции КИС, кг м2
//                +jBITS     //Момент инерции БИТС, кг м2
//                +jBVS      //Момент инерции КИС, кг м2
//                +jPrBKU    //Момент инерции прочих элементов БКУ
                        //Момент инерции СОТР
//                +jEVTI     //Момент инерции ЭВТИ, кг м2
//                +jSOTR     //Максимальное значение момента инерции СОТР,
                        //приведенного к габаритам КА, кг м2
                        //Момент инерции СЭП
//                +jAB_KA    //Момент инерции АБ в форме куба относительно поперечной оси КА
//                +jKASsum   //Приведенный момент инерции КАС с корпусом и прочими элеметами
//                +jPSB_KA   //Момент инерции всех панелей СБ относительно поперечной оси КА
                        //Момент инерции КДУ
//                +jKDU
                )
                        / dataCommonParameters.krkKA
//                +jkKA      //Момент инерции  конструкции КА
//                +jBKS      //Приведенный момент инерции БКС
//                +jAFU     //Приведенный момент инерции АФУ
//                +jPrKA
//                +jRmKA
        ;

        //Расчет текущего значения среднесуточной мощности электропотребления КА
        //без собственного потребления СЭП
        dataCommonParameters.wKA_wsSEP =
                //Среднесуточная мощность целевой аппаратуры, Вт
                +dataOETK.wOETK     //Среднесуточная мощность ОЭТК, Вт
                +dataSPPE.wSPPI     //Среднесуточная мощность СППИ
//                +wVRL      //Среднесуточная мощность ВРЛ
//                +wPrZA     //Среднесуточная мощность прочих элементов ЦА
                        //Масса БКУ, кг
                        + dataSudSGK.wSGK      //Среднесуточная мощность СГК
                        + dataSSKM.wSSKM    //Среднесуточная мощность ССКМ, Вт
//                +vSTKRP    //Среднесуточная мощность СТКРП, Вт
//                +wKIS      //Среднесуточная мощность КИС, Вт
//                +wBITS     //Среднесуточная мощность БИТС, Вт
//                +wBVS      //Среднесуточная мощность КИС, Вт
//                +wPrBKU    //Среднесуточная мощность прочих элементов БКУ

//                +wSTR      //Среднесуточная мощность СОТР, Вт
//                +wKDU     //Среднесуточная мощность автоматики КДУ
//                +wPrKA
//                +wRmKA;
        ;

        return null;
    }

    public void init() {
        dataCommonParameters = new DataCommonParameters();
        dataOETK = new DataOETK();
        dataSudSGK = new DataSudSGK();
        dataSSKM = new DataSSKM();
        dataSPPE = new DataSPPE();
        dataVRL = new DataVRL();
        dataOtherCA = new DataOtherCA();
        dataCa = new DataCa();
        dataSTKRP = new DataSTKRP();
        dataSTKRP = new DataSTKRP();
        dataBETS = new DataBETS();
        dataBVS = new DataBVS();
        dataOtherBKU = new DataOtherBKU();
        dataBKU = new DataBKU();
        dataActivSOTR = new DataActivSOTR();
        dataPasivSOTR = new DataPasivSOTR();
        dataSOTR = new DataSOTR();
        dataElectHaraktSEP = new DataElectHaraktSEP();
        dataAcumBetSEP= new DataAcumBetSEP();
        dataKAS = new DataKAS();
        dataSumBetSEP = new DataSumBetSEP();
    }

    public static CalculationKA getInstance() {
        if (singl == null) {
            singl = new CalculationKA();
        }
        return singl;
    }

    public DataCommonParameters getDataCommonParameters() {
        return dataCommonParameters;
    }

    public void setDataCommonParameters(DataCommonParameters dataCommonParameters) {
        this.dataCommonParameters = dataCommonParameters;
    }

    public DataOETK getDataOETK() {
        return dataOETK;
    }

    public void setDataOETK(DataOETK dataOETK) {
        this.dataOETK = dataOETK;
    }

    public DataSudSGK getDataSudSGK() {
        return dataSudSGK;
    }

    public void setDataSudSGK(DataSudSGK dataSudSGK) {
        this.dataSudSGK = dataSudSGK;
    }

    public DataSSKM getDataSSKM() {
        return dataSSKM;
    }

    public void setDataSSKM(DataSSKM dataSSKM) {
        this.dataSSKM = dataSSKM;
    }

    public DataSPPE getDataSPPE() {
        return dataSPPE;
    }

    public void setDataSPPE(DataSPPE dataSPPE) {
        this.dataSPPE = dataSPPE;
    }

    public static CalculationKA getSingl() {
        return singl;
    }

    public static void setSingl(CalculationKA singl) {
        CalculationKA.singl = singl;
    }

    public DataVRL getDataVRL() {
        return dataVRL;
    }

    public void setDataVRL(DataVRL dataVRL) {
        this.dataVRL = dataVRL;
    }

    public DataOtherCA getDataOtherCA() {
        return dataOtherCA;
    }

    public void setDataOtherCA(DataOtherCA dataOtherCA) {
        this.dataOtherCA = dataOtherCA;
    }

    public DataCa getDataCa() {
        return dataCa;
    }

    public void setDataCa(DataCa dataCa) {
        this.dataCa = dataCa;
    }

    public DataSTKRP getDataSTKRP() {
        return dataSTKRP;
    }

    public void setDataSTKRP(DataSTKRP dataSTKRP) {
        this.dataSTKRP = dataSTKRP;
    }

    public DataBAKES getDataBAKES() {
        return dataBAKES;
    }

    public void setDataBAKES(DataBAKES dataBAKES) {
        this.dataBAKES = dataBAKES;
    }

    public DataBETS getDataBETS() {
        return dataBETS;
    }

    public void setDataBETS(DataBETS dataBETS) {
        this.dataBETS = dataBETS;
    }

    public DataBVS getDataBVS() {
        return dataBVS;
    }

    public void setDataBVS(DataBVS dataBVS) {
        this.dataBVS = dataBVS;
    }

    public DataOtherBKU getDataOtherBKU() {
        return dataOtherBKU;
    }

    public void setDataOtherBKU(DataOtherBKU dataOtherBKU) {
        this.dataOtherBKU = dataOtherBKU;
    }

    public DataBKU getDataBKU() {
        return dataBKU;
    }

    public void setDataBKU(DataBKU dataBKU) {
        this.dataBKU = dataBKU;
    }

    public DataActivSOTR getDataActivSOTR() {
        return dataActivSOTR;
    }

    public void setDataActivSOTR(DataActivSOTR dataActivSOTR) {
        this.dataActivSOTR = dataActivSOTR;
    }

    public DataPasivSOTR getDataPasivSOTR() {
        return dataPasivSOTR;
    }

    public void setDataPasivSOTR(DataPasivSOTR dataPasivSOTR) {
        this.dataPasivSOTR = dataPasivSOTR;
    }

    public DataSOTR getDataSOTR() {
        return dataSOTR;
    }

    public void setDataSOTR(DataSOTR dataSOTR) {
        this.dataSOTR = dataSOTR;
    }

    public DataElectHaraktSEP getDataElectHaraktSEP() {
        return dataElectHaraktSEP;
    }

    public void setDataElectHaraktSEP(DataElectHaraktSEP dataElectHaraktSEP) {
        this.dataElectHaraktSEP = dataElectHaraktSEP;
    }

    public DataAcumBetSEP getDataAcumBetSEP() {
        return dataAcumBetSEP;
    }

    public void setDataAcumBetSEP(DataAcumBetSEP dataAcumBetSEP) {
        this.dataAcumBetSEP = dataAcumBetSEP;
    }

    public DataKAS getDataKAS() {
        return dataKAS;
    }

    public void setDataKAS(DataKAS dataKAS) {
        this.dataKAS = dataKAS;
    }

    public DataSumBetSEP getDataSumBetSEP() {
        return dataSumBetSEP;
    }

    public void setDataSumBetSEP(DataSumBetSEP dataSumBetSEP) {
        this.dataSumBetSEP = dataSumBetSEP;
    }
}
