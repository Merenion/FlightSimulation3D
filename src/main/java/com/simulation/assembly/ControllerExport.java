package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.*;
import javafx.event.ActionEvent;

public class ControllerExport extends ControllerManageFieldSintez {

    public void exportSSD(ActionEvent actionEvent) {
        validateSSD();
        SaveXmlObject<DataSSD> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.SSD.getName(),TabTypeSintez.SSD.getTypeName(),CalculationKA.getInstance().getDataSSD());
    }

    public void exportIPMV(ActionEvent actionEvent) {
        validateIPMV();
        SaveXmlObject<DataIPMV> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.IPMV.getName(),TabTypeSintez.IPMV.getTypeName(),CalculationKA.getInstance().getDataIPMV());
    }

    public void exportBOKZ(ActionEvent actionEvent) {
        validateBOKZ();
        SaveXmlObject<DataBOKZ> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.BOKZ.getName(),TabTypeSintez.BOKZ.getTypeName(),CalculationKA.getInstance().getDataBOKZ());
    }

    public void exportDO(ActionEvent actionEvent) {
        validateDO();
        SaveXmlObject<DataDO> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.DO.getName(),TabTypeSintez.DO.getTypeName(),CalculationKA.getInstance().getDataDO());
    }

    public void exportDUS(ActionEvent actionEvent) {
        validateDUS();
        SaveXmlObject<DataDUS> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.DUS.getName(),TabTypeSintez.DUS.getTypeName(),CalculationKA.getInstance().getDataDUS());
    }

    public void exportBks(ActionEvent actionEvent) {
        validateBKS();
        SaveXmlObject<DataBKS> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.BKS.getName(),TabTypeSintez.BKS.getTypeName(),CalculationKA.getInstance().getDataBKS());
    }

    public void exportAFU(ActionEvent actionEvent) {
        validateAFU();
        SaveXmlObject<DataAFU> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData(TabTypeSintez.AFU.getName(),TabTypeSintez.AFU.getTypeName(),CalculationKA.getInstance().getDataAFU());
    }

    public void exportRestriction(ActionEvent actionEvent) {
        validateSimpleSintez();
        SaveXmlObject<DataCommonParameters> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Ограничения","restr",CalculationKA.getInstance().getDataCommonParameters());
    }

    public void exportOETK(ActionEvent actionEvent) {
        validateOETK();
            SaveXmlObject<DataOETK> saveXmlObject = new SaveXmlObject<>();
            saveXmlObject.saveData("ОЕТК","oetk",CalculationKA.getInstance().getDataOETK());
    }

    public void exportSPPE(ActionEvent actionEvent) {
        validateSPPE();
        SaveXmlObject<DataSPPE> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("СППИ","sppe",CalculationKA.getInstance().getDataSPPE());
    }

    public void exportVRL(ActionEvent actionEvent) {
        validateVRL();
        SaveXmlObject<DataVRL> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("ВРЛ","vrl",CalculationKA.getInstance().getDataVRL());
    }

    public void exportOtherCA(ActionEvent actionEvent) {
        validateOtherCA();
        SaveXmlObject<DataOtherCA> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Прочие элементы ЦА","prca",CalculationKA.getInstance().getDataOtherCA());
    }

    public void exportSGK(ActionEvent actionEvent) {
        validateSGK();
        SaveXmlObject<DataSudSGK> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("СГК","sgk",CalculationKA.getInstance().getDataSudSGK());
    }

    public void exportSSKM(ActionEvent actionEvent) {
        validateSSKM();
        SaveXmlObject<DataSSKM> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("ССКМ","sskm",CalculationKA.getInstance().getDataSSKM());
    }

    public void exportSTKRP(ActionEvent actionEvent) {
        validateSTKRP();
        SaveXmlObject<DataSTKRP> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("СТКРП","stkrp",CalculationKA.getInstance().getDataSTKRP());
    }

    public void exportBAKES(ActionEvent actionEvent) {
        validateBAKES();
        SaveXmlObject<DataBAKES> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("БА КИС","bakes",CalculationKA.getInstance().getDataBAKES());
    }

    public void exportBETS(ActionEvent actionEvent) {
        validateBETS();
        SaveXmlObject<DataBETS> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("БИТС","bets",CalculationKA.getInstance().getDataBETS());
    }

    public void exportBVS(ActionEvent actionEvent) {
        validateBVS();
        SaveXmlObject<DataBVS> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("БВС","bvs",CalculationKA.getInstance().getDataBVS());
    }

    public void exportOtherBKU(ActionEvent actionEvent) {
        validateOtherBKU();
        SaveXmlObject<DataBKU> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Прочие элементы БКУ","prbku",CalculationKA.getInstance().getDataBKU());
    }

    public void exportPasivSOTR(ActionEvent actionEvent) {
        validatePasivSOTR();
        SaveXmlObject<DataPasivSOTR> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Пасивные элементы СОТР","evti",CalculationKA.getInstance().getDataPasivSOTR());
    }

    public void exportActivSOTR(ActionEvent actionEvent) {
        validateActivSOTR();
        SaveXmlObject<DataActivSOTR> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Активные элементы СОТР","str",CalculationKA.getInstance().getDataActivSOTR());
    }

    public void exportElectParamSEP(ActionEvent actionEvent) {
        validateElectTehHarakSEP();
        SaveXmlObject<DataElectHaraktSEP> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Электротехнические характеристики СЭП","eetsep",CalculationKA.getInstance().getDataElectHaraktSEP());
    }

    public void exportAccumBet(ActionEvent actionEvent) {
        validateAcumBat();
        SaveXmlObject<DataAcumBetSEP> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Аккумуляторные батареи","acbtsep",CalculationKA.getInstance().getDataAcumBetSEP());
    }

    public void exportKAS(ActionEvent actionEvent) {
        validateKAS();
        SaveXmlObject<DataKAS> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("КАС","kas",CalculationKA.getInstance().getDataKAS());
    }

    public void exportSun(ActionEvent actionEvent) {
        validateSunBet();
        SaveXmlObject<DataSumBetSEP> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Солнечные батареи","sun",CalculationKA.getInstance().getDataSumBetSEP());
    }

    public void exportSpeed(ActionEvent actionEvent) {
        validateSpeed();
        SaveXmlObject<DataSpeed> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Характеристическая скорость","speed",CalculationKA.getInstance().getDataSpeed());
    }

    public void exportMassT(ActionEvent actionEvent) {
        validateMassTopl();
        SaveXmlObject<DataMassTopl> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Масса топлива","mstp",CalculationKA.getInstance().getDataMassTopl());
    }

    public void exportKDU(ActionEvent actionEvent) {
        validateKDU();
        SaveXmlObject<DataKDU> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Массогабаритные и энергетические характеристики","kdu",CalculationKA.getInstance().getDataKDU());
    }

    public void exporttKonstr(ActionEvent actionEvent) {
        validateKonstrKA();
        SaveXmlObject<DataKonstrKA> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Конструкция КА","konstr",CalculationKA.getInstance().getDataKonstrKA());
    }

//    public void exportBKSandAFU(ActionEvent actionEvent) {
//        validateBKSandAFU();
//        SaveXmlObject<DataAFU> saveXmlObject = new SaveXmlObject<>();
//        saveXmlObject.saveData("БКС и АФУ","bksafu",CalculationKA.getInstance().getDataAFU());
//    }

//    public void exportOtherKa(ActionEvent actionEvent) {
//        validateOtherKA();
//        SaveXmlObject<DataOtherKA> saveXmlObject = new SaveXmlObject<>();
//        saveXmlObject.saveData("Прочие элементы КА","prka",CalculationKA.getInstance().getDataOtherKA());
//    }

    public void exportRezerv(ActionEvent actionEvent) {
        validateRezerv();
        SaveXmlObject<DataRezervKA> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveData("Резерв","rezerv",CalculationKA.getInstance().getDataRezervKA());
    }

}
