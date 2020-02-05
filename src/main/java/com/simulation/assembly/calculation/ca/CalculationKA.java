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
                +dataOETK.m                                      //Масса ОЭТК, кг
                        + dataSPPE.m                                      //Масса СППИ
                        + dataVRL.m                                       //Масса ВРЛ
                        + dataOtherCA.m                                      //Масса прочих элементов ЦА
//                        Масса БКУ, кг
                        + dataSudSGK.m                                       //Масса СГК
                        + dataSSKM.m                                      //Масса ССКМ, кг
                        + dataSTKRP.m                                     //Масса СТКРП, кг
                        + dataBAKES.m                                       //Масса КИС, кг
                        + dataBETS.m                                      //Масса БИТС, кг
                        + dataBVS.m                                       //Масса КИС, кг
                        + dataOtherBKU.m                                     //Масса прочих элементов БКУ
//                        Масса СОТР
                        + dataPasivSOTR.m                                         //Масса ЭВТИ, кг
                        + dataActivSOTR.m                                          //Масса СТР, кг
//                        Масса СЭП
                        + dataAcumBetSEP.m                                           //Масса всех АБ, кг
                        + dataKAS.m   //Суммарная масса КАС с корпусными частями и проч. эл-тами
                        + dataSumBetSEP.m                                          //Масса панелей СБ
//                        Масса КДУ
                        + dataMassTopl.m                                         //Масса топлива КДУ
                        + dataKDU.m                                         //Масса конструкции КДУ
                        + dataKonstrKA.m                                          //Масса конструкции КА
                        + dataAFU.m                                     //Масса БКС и АФУ, кг
                        + dataBKS.m
                        + dataOtherKA.m
                        + dataRezervKA.m
                        + dataSSD.m
                        + dataIPMV.m
                        + dataBOKZ.m
                        + dataDO.m
                        + dataDUS.m
                        + dataAFU.m
                        + dataBKS.m
        ;

        //Расчет текущих объемов КА
        dataCommonParameters.vKA =
                +dataOETK.v                             //Объем корпуса спецотсека КА
                        + (dataSPPE.v                                 //Объем СППИ
                        + dataVRL.v                                  //Объем ВРЛ
                        + dataOtherCA.v                                 //Объем прочих элементов ЦА
//                        Масса БКУ, кг
                        + dataSudSGK.v                                  //Объем СГК
                        + dataSSKM.v                                 //Объем ССКМ, м3
                        + dataSTKRP.v                                 //Объем СТКРП, м3
                        + dataBAKES.v                                   //Объем КИС, м3

                        + dataSSD.v
                        + dataIPMV.v
                        + dataBOKZ.v
                        + dataDO.v
                        + dataDUS.v

                        + dataBETS.v                                  //Объем БИТС, м3
                        + dataBVS.v                                   //Объем КИС, м3
                        + dataOtherBKU.v)                                 //Объем прочих элементов БКУ
                        / (dataCommonParameters.kpoPO / 100)
//        Объем СОТР
                        + dataPasivSOTR.v                                  //Объем ЭВТИ, м3
                        + dataActivSOTR.v                                   //Объем СОТР, м3
                        / (dataCommonParameters.kpoPO / 100)
//        объем СЭП
                        + dataAcumBetSEP.v                                    //Объем всех АБ
                        + dataKAS.v         //Объем КАС с учетом корпусных частей и прочих элементов
                        / (dataCommonParameters.kpoPO / 100)
                        + dataKDU.v       //Объем Отсека КА, где располагается КДУ
                        + dataKonstrKA.v                                   //Объем конструкции КА
                        + (dataAFU.v
                        + dataBKS.v
                        + dataOtherKA.v
                        + dataRezervKA.v)                              //Объем БКС и АФУ, м3
                        / (dataCommonParameters.kpoPO / 100);

        //Расчет текущих габаритов КА
        //Расчет среднего диаметра КА
        dataCommonParameters.dKA = (float) Math.exp((1f / 3f) * Math.log(4 * dataCommonParameters.vKA / (Math.PI * dataCommonParameters.udlKA)));
        //Расчет средней длины КА
        dataCommonParameters.lKA = dataCommonParameters.dKA * dataCommonParameters.udlKA;

        //Расчет максимального моментаинерции КА
        dataCommonParameters.jKA =
                //Приведенный момент инерци целевой аппаратуры, кг
                (dataOETK.j     //Момент инерции ОЭТК, кг м2
                        + dataSPPE.j     //Момент инерции СППИ
                        + dataVRL.j      //Момент инерции ВРЛ
                        + dataOtherCA.j     //Момент инерции прочих элементов ЦА
                        //Приведенный момент инерции БКУ, кг м2
                        + dataSudSGK.j      //Момент инерции СГК
                        + dataSSKM.j     //Момент инерции ССКМ, кг м2
                        + dataSTKRP.j    //Момент инерции СТКРП, кг м2
                        + dataBAKES.j      //Момент инерции КИС, кг м2
                        + dataBETS.j     //Момент инерции БИТС, кг м2
                        + dataBVS.j      //Момент инерции КИС, кг м2
                        + dataOtherBKU.j    //Момент инерции прочих элементов БКУ

                        + dataSSD.j
                        + dataIPMV.j
                        + dataBOKZ.j
                        + dataDO.j
                        + dataDUS.j

                        //Момент инерции СОТР
                        + dataPasivSOTR.j     //Момент инерции ЭВТИ, кг м2
//                        + dataSOTR.j     //Максимальное значение момента инерции СОТР,
                        //приведенного к габаритам КА, кг м2
                        //Момент инерции СЭП
                        + dataAcumBetSEP.j    //Момент инерции АБ в форме куба относительно поперечной оси КА
                        + dataKAS.j   //Приведенный момент инерции КАС с корпусом и прочими элеметами
                        + dataSumBetSEP.j   //Момент инерции всех панелей СБ относительно поперечной оси КА
                        //Момент инерции КДУ
                        + dataKDU.j
                )
                        / dataCommonParameters.krkKA
                        + dataKonstrKA.j      //Момент инерции  конструкции КА
                        + dataAFU.j      //Приведенный момент инерции БКС
                        + dataAFU.j     //Приведенный момент инерции АФУ
                        + dataOtherKA.j
                        + dataRezervKA.j
        ;

        //Расчет текущего значения среднесуточной мощности электропотребления КА
        //без собственного потребления СЭП
        dataCommonParameters.wKA_wsSEP =
                //Среднесуточная мощность целевой аппаратуры, Вт
                +dataOETK.w     //Среднесуточная мощность ОЭТК, Вт
                        + dataSPPE.w     //Среднесуточная мощность СППИ
                        + dataVRL.w      //Среднесуточная мощность ВРЛ
                        + dataOtherCA.w     //Среднесуточная мощность прочих элементов ЦА
                        //Масса БКУ, кг
                        + dataSudSGK.w      //Среднесуточная мощность СГК

                        + dataSSKM.w    //Среднесуточная мощность ССКМ, Вт
                        + dataSTKRP.w    //Среднесуточная мощность СТКРП, Вт
                        + dataBAKES.w      //Среднесуточная мощность КИС, Вт
                        + dataBETS.w     //Среднесуточная мощность БИТС, Вт
                        + dataBVS.w      //Среднесуточная мощность КИС, Вт
                        + dataOtherBKU.w    //Среднесуточная мощность прочих элементов БКУ

                        + dataActivSOTR.w      //Среднесуточная мощность СОТР, Вт
                        + dataKDU.w     //Среднесуточная мощность автоматики КДУ
                        + dataOtherKA.w
                        + dataRezervKA.w;

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
