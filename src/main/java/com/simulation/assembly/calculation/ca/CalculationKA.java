package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.sintez.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculationKA")
public class CalculationKA extends Calculation {


    @Override
    public TabTypeSintez getType() {
        return TabTypeSintez.RESULT;
    }


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
    private DataSpeed dataSpeed;
    private DataMassTopl dataMassTopl;
    private DataKDU dataKDU;
    private DataKonstrKA dataKonstrKA;
    private DataBKS dataBKS;
    private DataAFU dataAFU;
    private DataOtherKA dataOtherKA;
    private DataRezervKA dataRezervKA;
    private DataSSD dataSSD;
    private DataIPMV dataIPMV;
    private DataBOKZ dataBOKZ;
    private DataDO dataDO;
    private DataDUS dataDUS;

    public CalculationKA() {
        init();
    }

    @Override
    public Object calculation(Object object) {
        dataCommonParameters.mKA =
                //Масса целевой аппаратуры, кг
                + (dataOETK.isNeedUvyzka()?dataOETK.m:0)                                      //Масса ОЭТК, кг
                        + (dataSPPE.isNeedUvyzka()?dataSPPE.m:0)                                     //Масса СППИ
                        + (dataVRL.isNeedUvyzka()?dataVRL.m:0)                                        //Масса ВРЛ
                        + (dataOtherCA.isNeedUvyzka()?dataOtherCA.m:0)                                      //Масса прочих элементов ЦА
//                        Масса БКУ, кг
                        + (dataSudSGK.isNeedUvyzka()?dataSudSGK.m:0)                                       //Масса СГК
                        + (dataSSKM.isNeedUvyzka()?dataSSKM.m:0)                                    //Масса ССКМ, кг
                        + (dataSTKRP.isNeedUvyzka()?dataSTKRP.m:0)                                  //Масса СТКРП, кг
                        + (dataBAKES.isNeedUvyzka()?dataBAKES.m:0)                                      //Масса КИС, кг
                        + (dataBETS.isNeedUvyzka()?dataBETS.m:0)                                   //Масса БИТС, кг
                        + (dataBVS.isNeedUvyzka()?dataBVS.m:0)                                     //Масса КИС, кг
                        + (dataOtherBKU.isNeedUvyzka()?dataOtherBKU.m:0)                                   //Масса прочих элементов БКУ
//                        Масса СОТР
                        + (dataPasivSOTR.isNeedUvyzka()?dataPasivSOTR.m:0)                                         //Масса ЭВТИ, кг
                        + (dataActivSOTR.isNeedUvyzka()?dataActivSOTR.m:0)                                         //Масса СТР, кг
//                        Масса СЭП
                        + (dataAcumBetSEP.isNeedUvyzka()?dataAcumBetSEP.m:0)                                          //Масса всех АБ, кг
                        + (dataKAS.isNeedUvyzka()?dataKAS.m:0)   //Суммарная масса КАС с корпусными частями и проч. эл-тами
                        + (dataSumBetSEP.isNeedUvyzka()?dataSumBetSEP.m:0)                                       //Масса панелей СБ
//                        Масса КДУ
                        + (dataMassTopl.isNeedUvyzka()?dataMassTopl.m:0)                                        //Масса топлива КДУ
                        + (dataKDU.isNeedUvyzka()?dataKDU.m:0)                                       //Масса конструкции КДУ
                        + (dataKonstrKA.isNeedUvyzka()?dataKonstrKA.m:0)                                         //Масса конструкции КА
                        + (dataAFU.isNeedUvyzka()?dataAFU.m:0)                                     //Масса БКС и АФУ, кг
                        + (dataBKS.isNeedUvyzka()?dataBKS.m:0)
                        + (dataOtherKA.isNeedUvyzka()?dataOtherKA.m:0)
                        + (dataRezervKA.isNeedUvyzka()?dataRezervKA.m:0)
                        + (dataSSD.isNeedUvyzka()?dataSSD.m:0)
                        + (dataIPMV.isNeedUvyzka()?dataIPMV.m:0)
                        + (dataBOKZ.isNeedUvyzka()?dataBOKZ.m:0)
                        + (dataDO.isNeedUvyzka()?dataDO.m:0)
                        + (dataDUS.isNeedUvyzka()?dataDUS.m:0)
        ;

        //Расчет текущих объемов КА
        dataCommonParameters.vKA =
                +(dataOETK.isNeedUvyzka()?dataOETK.v:0)                             //Объем корпуса спецотсека КА
                        + ((dataSPPE.isNeedUvyzka()?dataSPPE.v:0)                              //Объем СППИ
                        + (dataVRL.isNeedUvyzka()?dataVRL.v:0)                                 //Объем ВРЛ
                        + (dataOtherCA.isNeedUvyzka()?dataOtherCA.v:0)                               //Объем прочих элементов ЦА
//                        Масса БКУ, кг
                        + (dataSudSGK.isNeedUvyzka()?dataSudSGK.v:0)                                 //Объем СГК
                        + (dataSSKM.isNeedUvyzka()?dataSSKM.v:0)                               //Объем ССКМ, м3
                        + (dataSTKRP.isNeedUvyzka()?dataSTKRP.v:0)                                 //Объем СТКРП, м3
                        + (dataBAKES.isNeedUvyzka()?dataBAKES.v:0)                                  //Объем КИС, м3

                        + (dataSSD.isNeedUvyzka()?dataSSD.v:0)
                        + (dataIPMV.isNeedUvyzka()?dataIPMV.v:0)
                        + (dataBOKZ.isNeedUvyzka()?dataBOKZ.v:0)
                        + (dataDO.isNeedUvyzka()?dataDO.v:0)
                        + (dataDUS.isNeedUvyzka()?dataDUS.v:0)

                        + (dataBETS.isNeedUvyzka()?dataBETS.v:0)                                 //Объем БИТС, м3
                        + (dataBVS.isNeedUvyzka()?dataBVS.v:0)                                  //Объем КИС, м3
                        + (dataOtherBKU.isNeedUvyzka()?dataOtherBKU.v:0))                                 //Объем прочих элементов БКУ
                        / (dataCommonParameters.kpoPO / 100)
//        Объем СОТР
                        + (dataPasivSOTR.isNeedUvyzka()?dataPasivSOTR.v:0)                                 //Объем ЭВТИ, м3
                        + (dataActivSOTR.isNeedUvyzka()?dataActivSOTR.v:0)                                   //Объем СОТР, м3
                        / (dataCommonParameters.kpoPO / 100)
//        объем СЭП
                        + (dataAcumBetSEP.isNeedUvyzka()?dataAcumBetSEP.v:0)                                    //Объем всех АБ
                        + (dataKAS.isNeedUvyzka()?dataKAS.v:0)        //Объем КАС с учетом корпусных частей и прочих элементов
                        / (dataCommonParameters.kpoPO / 100)
                        + (dataKDU.isNeedUvyzka()?dataKDU.v:0)       //Объем Отсека КА, где располагается КДУ
                        + (dataKonstrKA.isNeedUvyzka()?dataKonstrKA.v:0)                                  //Объем конструкции КА
                        + ((dataAFU.isNeedUvyzka()?dataAFU.v:0)
                        + (dataBKS.isNeedUvyzka()?dataBKS.v:0)
                        + (dataOtherKA.isNeedUvyzka()?dataOtherKA.v:0)
                        + (dataRezervKA.isNeedUvyzka()?dataRezervKA.v:0))                              //Объем БКС и АФУ, м3
                        / (dataCommonParameters.kpoPO / 100);

        //Расчет текущих габаритов КА
        //Расчет среднего диаметра КА
        dataCommonParameters.dKA = (float) Math.exp((1f / 3f) * Math.log(4 * dataCommonParameters.vKA / (Math.PI * dataCommonParameters.udlKA)));
        //Расчет средней длины КА
        dataCommonParameters.lKA = dataCommonParameters.dKA * dataCommonParameters.udlKA;

        //Расчет максимального моментаинерции КА
        dataCommonParameters.jKA =
                //Приведенный момент инерци целевой аппаратуры, кг
                ((dataOETK.isNeedUvyzka()?dataOETK.j:0)     //Момент инерции ОЭТК, кг м2
                        + (dataSPPE.isNeedUvyzka()?dataSPPE.j:0)     //Момент инерции СППИ
                        + (dataVRL.isNeedUvyzka()?dataVRL.j:0)      //Момент инерции ВРЛ
                        + (dataOtherCA.isNeedUvyzka()?dataOtherCA.j:0)     //Момент инерции прочих элементов ЦА
                        //Приведенный момент инерции БКУ, кг м2
                        + (dataSudSGK.isNeedUvyzka()?dataSudSGK.j:0)      //Момент инерции СГК
                        + (dataSSKM.isNeedUvyzka()?dataSSKM.j:0)     //Момент инерции ССКМ, кг м2
                        + (dataSTKRP.isNeedUvyzka()?dataSTKRP.j:0)   //Момент инерции СТКРП, кг м2
                        + (dataBAKES.isNeedUvyzka()?dataBAKES.j:0)      //Момент инерции КИС, кг м2
                        + (dataBETS.isNeedUvyzka()?dataBETS.j:0)     //Момент инерции БИТС, кг м2
                        + (dataBVS.isNeedUvyzka()?dataBVS.j:0)      //Момент инерции КИС, кг м2
                        + (dataOtherBKU.isNeedUvyzka()?dataOtherBKU.j:0)    //Момент инерции прочих элементов БКУ

                        + (dataSSD.isNeedUvyzka()?dataSSD.j:0)
                        + (dataIPMV.isNeedUvyzka()?dataIPMV.j:0)
                        + (dataBOKZ.isNeedUvyzka()?dataBOKZ.j:0)
                        + (dataDO.isNeedUvyzka()?dataDO.j:0)
                        + (dataDUS.isNeedUvyzka()?dataDUS.j:0)

                        //Момент инерции СОТР
                        + (dataPasivSOTR.isNeedUvyzka()?dataPasivSOTR.j:0)     //Момент инерции ЭВТИ, кг м2
                        + (dataActivSOTR.isNeedUvyzka()?dataActivSOTR.j:0)     //Момент инерции STR, кг м2
//                        + dataSOTR.j     //Максимальное значение момента инерции СОТР,
                        //приведенного к габаритам КА, кг м2
                        //Момент инерции СЭП
                        + (dataAcumBetSEP.isNeedUvyzka()?dataAcumBetSEP.j:0)    //Момент инерции АБ в форме куба относительно поперечной оси КА
                        + (dataKAS.isNeedUvyzka()?dataKAS.j:0)   //Приведенный момент инерции КАС с корпусом и прочими элеметами
                        + (dataSumBetSEP.isNeedUvyzka()?dataSumBetSEP.j:0)   //Момент инерции всех панелей СБ относительно поперечной оси КА
                        //Момент инерции КДУ
                        + (dataKDU.isNeedUvyzka()?dataKDU.j:0)
                )
                        / dataCommonParameters.krkKA
                        + (dataKonstrKA.isNeedUvyzka()?dataKonstrKA.j:0)      //Момент инерции  конструкции КА
                        + (dataBKS.isNeedUvyzka()?dataBKS.j:0)      //Приведенный момент инерции БКС
                        + (dataAFU.isNeedUvyzka()?dataAFU.j:0)     //Приведенный момент инерции АФУ
                        + (dataOtherKA.isNeedUvyzka()?dataOtherKA.j:0)
                        + (dataRezervKA.isNeedUvyzka()?dataRezervKA.j:0)
        ;

        //Расчет текущего значения среднесуточной мощности электропотребления КА
        //без собственного потребления СЭП
        dataCommonParameters.wKA_wsSEP =
                //Масса целевой аппаратуры, кг
                + (dataOETK.isNeedUvyzka()?dataOETK.w:0)                                      //Масса ОЭТК, кг
                        + (dataSPPE.isNeedUvyzka()?dataSPPE.w:0)                                     //Масса СППИ
                        + (dataVRL.isNeedUvyzka()?dataVRL.w:0)                                        //Масса ВРЛ
                        + (dataOtherCA.isNeedUvyzka()?dataOtherCA.w:0)                                      //Масса прочих элементов ЦА
//                        Масса БКУ, кг
                        + (dataSudSGK.isNeedUvyzka()?dataSudSGK.w:0)                                       //Масса СГК
                        + (dataSSKM.isNeedUvyzka()?dataSSKM.w:0)                                    //Масса ССКМ, кг
                        + (dataSTKRP.isNeedUvyzka()?dataSTKRP.w:0)                                  //Масса СТКРП, кг
                        + (dataBAKES.isNeedUvyzka()?dataBAKES.w:0)                                      //Масса КИС, кг
                        + (dataBETS.isNeedUvyzka()?dataBETS.w:0)                                   //Масса БИТС, кг
                        + (dataBVS.isNeedUvyzka()?dataBVS.w:0)                                     //Масса КИС, кг
                        + (dataOtherBKU.isNeedUvyzka()?dataOtherBKU.w:0)                                   //Масса прочих элементов БКУ
//                        Масса СОТР
                        + (dataPasivSOTR.isNeedUvyzka()?dataPasivSOTR.w:0)                                         //Масса ЭВТИ, кг
                        + (dataActivSOTR.isNeedUvyzka()?dataActivSOTR.w:0)                                         //Масса СТР, кг
//                        Масса СЭП
                        + (dataAcumBetSEP.isNeedUvyzka()?dataAcumBetSEP.w:0)                                          //Масса всех АБ, кг
                        + (dataKAS.isNeedUvyzka()?dataKAS.w:0)   //Суммарная масса КАС с корпусными частями и проч. эл-тами
                        + (dataSumBetSEP.isNeedUvyzka()?dataSumBetSEP.w:0)                                       //Масса панелей СБ
//                        Масса КДУ
                        + (dataMassTopl.isNeedUvyzka()?dataMassTopl.w:0)                                        //Масса топлива КДУ
                        + (dataKDU.isNeedUvyzka()?dataKDU.w:0)                                       //Масса конструкции КДУ
                        + (dataKonstrKA.isNeedUvyzka()?dataKonstrKA.w:0)                                         //Масса конструкции КА
                        + (dataAFU.isNeedUvyzka()?dataAFU.w:0)                                     //Масса БКС и АФУ, кг
                        + (dataBKS.isNeedUvyzka()?dataBKS.w:0)
                        + (dataOtherKA.isNeedUvyzka()?dataOtherKA.w:0)
                        + (dataRezervKA.isNeedUvyzka()?dataRezervKA.w:0)
                        + (dataSSD.isNeedUvyzka()?dataSSD.w:0)
                        + (dataIPMV.isNeedUvyzka()?dataIPMV.w:0)
                        + (dataBOKZ.isNeedUvyzka()?dataBOKZ.w:0)
                        + (dataDO.isNeedUvyzka()?dataDO.w:0)
                        + (dataDUS.isNeedUvyzka()?dataDUS.w:0);

        if (dataCommonParameters.isHaveRestriction) {
            if (dataCommonParameters.mKA > dataCommonParameters.mKA0) {
                ControllerAssembly.showInfo("Расчетная масса КА превысила ограничение.\nПоменяйте ограничения и пересчитайте их\nлибо подберите элементы с иными параметрами.");
            }
            if (dataCommonParameters.vKA > dataCommonParameters.vKA0) {
                ControllerAssembly.showInfo("Расчетный обьем КА превысил ограничение.\nПоменяйте ограничения и пересчитайте их\nлибо подберите элементы с иными параметрами.");
            }
            if (dataCommonParameters.jKA > dataCommonParameters.jKA0) {
                ControllerAssembly.showInfo("Расчетный момент КА превысил ограничение.\nПоменяйте ограничения и пересчитайте их\nлибо подберите элементы с иными параметрами.");
            }
            if (dataCommonParameters.dKA > dataCommonParameters.dKA0) {
                ControllerAssembly.showInfo("Расчетный диаметр КА превысил ограничение.\nПоменяйте ограничения и пересчитайте их\nлибо подберите элементы с иными параметрами.");
            }
            if (dataCommonParameters.lKA > dataCommonParameters.lKA0) {
                ControllerAssembly.showInfo("Расчетная длина КА превысила ограничение.\nПоменяйте ограничения и пересчитайте их\nлибо подберите элементы с иными параметрами.");
            }
        }
        return null;
    }

    @Override
    public Object calculationSingle(Object object) throws Exception {
        return calculation(object);
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
        dataAcumBetSEP = new DataAcumBetSEP();
        dataKAS = new DataKAS();
        dataSumBetSEP = new DataSumBetSEP();
        dataSpeed = new DataSpeed();
        dataMassTopl = new DataMassTopl();
        dataKDU = new DataKDU();
        dataKonstrKA = new DataKonstrKA();
        dataBKS = new DataBKS();
        dataAFU = new DataAFU();
        dataOtherKA = new DataOtherKA();
        dataRezervKA = new DataRezervKA();
        dataBAKES = new DataBAKES();
        dataSSD = new DataSSD();
        dataIPMV = new DataIPMV();
        dataBOKZ = new DataBOKZ();
        dataDO = new DataDO();
        dataDUS = new DataDUS();
    }

    public static CalculationKA getInstance() {
        if (singl == null) {
            singl = new CalculationKA();
        }
        return singl;
    }

    @Override
    public String toString() {
        return "ПРОТОКОЛ РАБОТЫ ПРОГРАММЫ" + "\n" +

                dataCommonParameters +
                dataOETK +
                dataSudSGK +
                dataSSKM +
                dataSPPE +
                dataVRL +
                dataOtherCA +
                dataCa +
                dataSTKRP +
                dataBAKES +
                dataBETS +
                dataBVS +
                dataOtherBKU +
                dataBKU +
                dataActivSOTR +
                dataPasivSOTR +
                dataSOTR +
                dataElectHaraktSEP +
                dataAcumBetSEP +
                dataKAS +
                dataSumBetSEP +
                dataSpeed +
                dataMassTopl +
                dataKDU +
                dataKonstrKA +
                dataBKS +
                dataAFU +
                dataOtherKA +
                dataRezervKA +
                dataSSD +
                dataIPMV +
                dataBOKZ +
                dataDO +
                dataDUS;
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

    public static void setKA(CalculationKA singl) {
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

    public DataSpeed getDataSpeed() {
        return dataSpeed;
    }

    public void setDataSpeed(DataSpeed dataSpeed) {
        this.dataSpeed = dataSpeed;
    }

    public DataMassTopl getDataMassTopl() {
        return dataMassTopl;
    }

    public void setDataMassTopl(DataMassTopl dataMassTopl) {
        this.dataMassTopl = dataMassTopl;
    }

    public DataKDU getDataKDU() {
        return dataKDU;
    }

    public void setDataKDU(DataKDU dataKDU) {
        this.dataKDU = dataKDU;
    }

    public DataKonstrKA getDataKonstrKA() {
        return dataKonstrKA;
    }

    public void setDataKonstrKA(DataKonstrKA dataKonstrKA) {
        this.dataKonstrKA = dataKonstrKA;
    }

    public DataAFU getDataAFU() {
        return dataAFU;
    }

    public void setDataAFU(DataAFU dataAFU) {
        this.dataAFU = dataAFU;
    }

    public DataOtherKA getDataOtherKA() {
        return dataOtherKA;
    }

    public void setDataOtherKA(DataOtherKA dataOtherKA) {
        this.dataOtherKA = dataOtherKA;
    }

    public DataRezervKA getDataRezervKA() {
        return dataRezervKA;
    }

    public void setDataRezervKA(DataRezervKA dataRezervKA) {
        this.dataRezervKA = dataRezervKA;
    }

    public DataSSD getDataSSD() {
        return dataSSD;
    }

    public void setDataSSD(DataSSD dataSSD) {
        this.dataSSD = dataSSD;
    }

    public DataIPMV getDataIPMV() {
        return dataIPMV;
    }

    public void setDataIPMV(DataIPMV dataIPMV) {
        this.dataIPMV = dataIPMV;
    }

    public DataBOKZ getDataBOKZ() {
        return dataBOKZ;
    }

    public void setDataBOKZ(DataBOKZ dataBOKZ) {
        this.dataBOKZ = dataBOKZ;
    }

    public DataDO getDataDO() {
        return dataDO;
    }

    public void setDataDO(DataDO dataDO) {
        this.dataDO = dataDO;
    }

    public DataDUS getDataDUS() {
        return dataDUS;
    }

    public void setDataDUS(DataDUS dataDUS) {
        this.dataDUS = dataDUS;
    }

    public DataBKS getDataBKS() {
        return dataBKS;
    }

    public void setDataBKS(DataBKS dataBKS) {
        this.dataBKS = dataBKS;
    }
}
