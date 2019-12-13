package com.simulation.assembly.calculation.ca;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.MessegeType;
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
    private DataBKSandAFU dataBKSandAFU;
    private DataOtherKA dataOtherKA;
    private DataRezervKA dataRezervKA;

    public CalculationKA() {
        init();
    }

    @Override
    public Object calculation(Object object) {
        dataCommonParameters.mKA =
                //Масса целевой аппаратуры, кг
                +dataOETK.mOETK                                      //Масса ОЭТК, кг
                        + dataSPPE.mSPPI                                      //Масса СППИ
                        + dataVRL.mVRL                                       //Масса ВРЛ
                        + dataOtherCA.mPrZA                                      //Масса прочих элементов ЦА
//                        Масса БКУ, кг
                        + dataSudSGK.mSGK                                       //Масса СГК
                        + dataSSKM.mSSKM                                      //Масса ССКМ, кг
                        + dataSTKRP.mSTKRP                                     //Масса СТКРП, кг
                        + dataBAKES.mKIS                                       //Масса КИС, кг
                        + dataBETS.mBITS                                      //Масса БИТС, кг
                        + dataBVS.mBVS                                       //Масса КИС, кг
                        + dataOtherBKU.mPrBKU                                     //Масса прочих элементов БКУ
//                        Масса СОТР
                        + dataPasivSOTR.mEVTI                                         //Масса ЭВТИ, кг
                        + dataActivSOTR.mSTR                                          //Масса СТР, кг
//                        Масса СЭП
                        + dataAcumBetSEP.mAB                                           //Масса всех АБ, кг
                        + dataKAS.mKASsum   //Суммарная масса КАС с корпусными частями и проч. эл-тами
                        + dataSumBetSEP.mPSB                                          //Масса панелей СБ
//                        Масса КДУ
                        + dataMassTopl.mTKDU                                         //Масса топлива КДУ
                        + dataKDU.mkKDU                                         //Масса конструкции КДУ
                        + dataKonstrKA.mkKA                                          //Масса конструкции КА
                        + dataBKSandAFU.mBKS_AFU                                     //Масса БКС и АФУ, кг
                        + dataOtherKA.mPrKA
                        + dataRezervKA.mRmKA
        ;

        //Расчет текущих объемов КА
        dataCommonParameters.vKA =
                +dataOETK.vkSO_OETK                             //Объем корпуса спецотсека КА
                        + (dataSPPE.vSPPI                                 //Объем СППИ
                        + dataVRL.vVRL                                  //Объем ВРЛ
                        + dataOtherCA.vPrZA                                 //Объем прочих элементов ЦА
//                        Масса БКУ, кг
                        + dataSudSGK.vSGK                                  //Объем СГК
                        + dataSSKM.vSSKM                                 //Объем ССКМ, м3
                        + dataSTKRP.vSTKRP                                 //Объем СТКРП, м3
                        + dataBAKES.vKIS                                   //Объем КИС, м3
                        + dataBETS.vBITS                                  //Объем БИТС, м3
                        + dataBVS.vBVS                                   //Объем КИС, м3
                        + dataOtherBKU.vPrBKU)                                 //Объем прочих элементов БКУ
                        / (dataCommonParameters.kpoPO / 100)
//        Объем СОТР
                        + dataPasivSOTR.vEVTI                                  //Объем ЭВТИ, м3
                        + dataActivSOTR.vSTR                                   //Объем СОТР, м3
                        / (dataCommonParameters.kpoPO / 100)
//        объем СЭП
                        + dataAcumBetSEP.vAB                                    //Объем всех АБ
                        + dataKAS.vKASsum         //Объем КАС с учетом корпусных частей и прочих элементов
                        / (dataCommonParameters.kpoPO / 100)
                        + dataKDU.V_OKA_KDU       //Объем Отсека КА, где располагается КДУ
                        + dataKonstrKA.vkKA                                   //Объем конструкции КА
                        + (dataBKSandAFU.vBKS_AFU
                        + dataOtherKA.vPrKA
                        + dataRezervKA.vRmKA)                              //Объем БКС и АФУ, м3
                        / (dataCommonParameters.kpoPO / 100);

        //Расчет текущих габаритов КА
        //Расчет среднего диаметра КА
        dataCommonParameters.dKA = (float) Math.exp((1f / 3f) * Math.log(4 * dataCommonParameters.vKA / (Math.PI * dataCommonParameters.udlKA)));
        //Расчет средней длины КА
        dataCommonParameters.lKA = dataCommonParameters.dKA * dataCommonParameters.udlKA;

        //Расчет максимального моментаинерции КА
        dataCommonParameters.jKA =
                //Приведенный момент инерци целевой аппаратуры, кг
                (dataOETK.jOETK     //Момент инерции ОЭТК, кг м2
                        + dataSPPE.jSPPI     //Момент инерции СППИ
                        + dataVRL.jVRL      //Момент инерции ВРЛ
                        + dataOtherCA.jPrZA     //Момент инерции прочих элементов ЦА
                        //Приведенный момент инерции БКУ, кг м2
                        + dataSudSGK.jSGK      //Момент инерции СГК
                        + dataSSKM.jSSKM     //Момент инерции ССКМ, кг м2
                        + dataSTKRP.jSTKRP    //Момент инерции СТКРП, кг м2
                        + dataBAKES.jKIS      //Момент инерции КИС, кг м2
                        + dataBETS.jBITS     //Момент инерции БИТС, кг м2
                        + dataBVS.jBVS      //Момент инерции КИС, кг м2
                        + dataOtherBKU.jPrBKU    //Момент инерции прочих элементов БКУ
                        //Момент инерции СОТР
                        + dataPasivSOTR.jEVTI     //Момент инерции ЭВТИ, кг м2
                        + dataSOTR.jSOTR     //Максимальное значение момента инерции СОТР,
                        //приведенного к габаритам КА, кг м2
                        //Момент инерции СЭП
                        + dataAcumBetSEP.jAB_KA    //Момент инерции АБ в форме куба относительно поперечной оси КА
                        + dataKAS.jKASsum   //Приведенный момент инерции КАС с корпусом и прочими элеметами
                        + dataSumBetSEP.jPSB_KA   //Момент инерции всех панелей СБ относительно поперечной оси КА
                        //Момент инерции КДУ
                        + dataKDU.jKDU
                )
                        / dataCommonParameters.krkKA
                        + dataKonstrKA.jkKA      //Момент инерции  конструкции КА
                        + dataBKSandAFU.jBKS      //Приведенный момент инерции БКС
                        + dataBKSandAFU.jAFU     //Приведенный момент инерции АФУ
                        + dataOtherKA.jPrKA
                        + dataRezervKA.jRmKA
        ;

        //Расчет текущего значения среднесуточной мощности электропотребления КА
        //без собственного потребления СЭП
        dataCommonParameters.wKA_wsSEP =
                //Среднесуточная мощность целевой аппаратуры, Вт
                +dataOETK.wOETK     //Среднесуточная мощность ОЭТК, Вт
                        + dataSPPE.wSPPI     //Среднесуточная мощность СППИ
                        + dataVRL.wVRL      //Среднесуточная мощность ВРЛ
                        + dataOtherCA.wPrZA     //Среднесуточная мощность прочих элементов ЦА
                        //Масса БКУ, кг
                        + dataSudSGK.wSGK      //Среднесуточная мощность СГК
                        + dataSSKM.wSSKM    //Среднесуточная мощность ССКМ, Вт
                        + dataSTKRP.vSTKRP    //Среднесуточная мощность СТКРП, Вт
                        + dataBAKES.wKIS      //Среднесуточная мощность КИС, Вт
                        + dataBETS.wBITS     //Среднесуточная мощность БИТС, Вт
                        + dataBVS.wBVS      //Среднесуточная мощность КИС, Вт
                        + dataOtherBKU.wPrBKU    //Среднесуточная мощность прочих элементов БКУ

                        + dataActivSOTR.wSTR      //Среднесуточная мощность СОТР, Вт
                        + dataKDU.wKDU     //Среднесуточная мощность автоматики КДУ
                        + dataOtherKA.wPrKA
                        + dataRezervKA.wRmKA;

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
        dataBKSandAFU = new DataBKSandAFU();
        dataOtherKA = new DataOtherKA();
        dataRezervKA = new DataRezervKA();
        dataBAKES = new DataBAKES();
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

    public DataBKSandAFU getDataBKSandAFU() {
        return dataBKSandAFU;
    }

    public void setDataBKSandAFU(DataBKSandAFU dataBKSandAFU) {
        this.dataBKSandAFU = dataBKSandAFU;
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
}
