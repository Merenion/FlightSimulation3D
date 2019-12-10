package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.*;
import javafx.event.ActionEvent;

public class ControllerImport extends ControllerZaimstv {


    public void importRestriction(ActionEvent actionEvent) {
        SaveXmlObject<DataCommonParameters> saveXmlObject = new SaveXmlObject<>();
        DataCommonParameters ob = saveXmlObject.readData("Ограничения","restr",DataCommonParameters.class);
        CalculationKA.getInstance().setDataCommonParameters(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importOETK(ActionEvent actionEvent) {
        SaveXmlObject<DataOETK> saveXmlObject = new SaveXmlObject<>();
        DataOETK ob = saveXmlObject.readData("ОETK","oetk",DataOETK.class);
        CalculationKA.getInstance().setDataOETK(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSPPE(ActionEvent actionEvent) {
        SaveXmlObject<DataSPPE> saveXmlObject = new SaveXmlObject<>();
        DataSPPE ob = saveXmlObject.readData("СППИ","sppe",DataSPPE.class);
        CalculationKA.getInstance().setDataSPPE(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importVRL(ActionEvent actionEvent) {
        SaveXmlObject<DataVRL> saveXmlObject = new SaveXmlObject<>();
        DataVRL ob = saveXmlObject.readData("ВРЛ","vrl",DataVRL.class);
        CalculationKA.getInstance().setDataVRL(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importOtherCA(ActionEvent actionEvent) {
        SaveXmlObject<DataOtherCA> saveXmlObject = new SaveXmlObject<>();
        DataOtherCA ob = saveXmlObject.readData("Прочие элементы ЦА","prca",DataOtherCA.class);
        CalculationKA.getInstance().setDataOtherCA(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSGK(ActionEvent actionEvent) {
        SaveXmlObject<DataSudSGK> saveXmlObject = new SaveXmlObject<>();
        DataSudSGK ob = saveXmlObject.readData("СГК","sgk",DataSudSGK.class);
        CalculationKA.getInstance().setDataSudSGK(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSSKM(ActionEvent actionEvent) {
        SaveXmlObject<DataSSKM> saveXmlObject = new SaveXmlObject<>();
        DataSSKM ob = saveXmlObject.readData("ССКМ","sskm",DataSSKM.class);
        CalculationKA.getInstance().setDataSSKM(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSTKRP(ActionEvent actionEvent) {
        SaveXmlObject<DataSTKRP> saveXmlObject = new SaveXmlObject<>();
        DataSTKRP ob = saveXmlObject.readData("СТКРП","stkrp",DataSTKRP.class);
        CalculationKA.getInstance().setDataSTKRP(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importBAKES(ActionEvent actionEvent) {
        SaveXmlObject<DataBAKES> saveXmlObject = new SaveXmlObject<>();
        DataBAKES ob = saveXmlObject.readData("БА КИС","bakes",DataBAKES.class);
        CalculationKA.getInstance().setDataBAKES(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importBETS(ActionEvent actionEvent) {
        SaveXmlObject<DataBETS> saveXmlObject = new SaveXmlObject<>();
        DataBETS ob = saveXmlObject.readData("БИТС","bets",DataBETS.class);
        CalculationKA.getInstance().setDataBETS(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importBVS(ActionEvent actionEvent) {
        SaveXmlObject<DataBVS> saveXmlObject = new SaveXmlObject<>();
        DataBVS ob = saveXmlObject.readData("БВС","bvs",DataBVS.class);
        CalculationKA.getInstance().setDataBVS(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importOtherBKU(ActionEvent actionEvent) {
        SaveXmlObject<DataOtherBKU> saveXmlObject = new SaveXmlObject<>();
        DataOtherBKU ob = saveXmlObject.readData("Прочие элементы БКУ","prbku",DataOtherBKU.class);
        CalculationKA.getInstance().setDataOtherBKU(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importPasivSOTR(ActionEvent actionEvent) {
        SaveXmlObject<DataPasivSOTR> saveXmlObject = new SaveXmlObject<>();
        DataPasivSOTR ob = saveXmlObject.readData("Пасивные элементы СОТР","evti",DataPasivSOTR.class);
        CalculationKA.getInstance().setDataPasivSOTR(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importActivSOTR(ActionEvent actionEvent) {
        SaveXmlObject<DataActivSOTR> saveXmlObject = new SaveXmlObject<>();
        DataActivSOTR ob = saveXmlObject.readData("Активные элементы СОТР","str",DataActivSOTR.class);
        CalculationKA.getInstance().setDataActivSOTR(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importElectParamSEP(ActionEvent actionEvent) {
        SaveXmlObject<DataElectHaraktSEP> saveXmlObject = new SaveXmlObject<>();
        DataElectHaraktSEP ob = saveXmlObject.readData("Электротехнические характеристики СЭП","eetsep",DataElectHaraktSEP.class);
        CalculationKA.getInstance().setDataElectHaraktSEP(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importAccumBet(ActionEvent actionEvent) {
        SaveXmlObject<DataAcumBetSEP> saveXmlObject = new SaveXmlObject<>();
        DataAcumBetSEP ob = saveXmlObject.readData("Аккумуляторные батареи","acbtsep",DataAcumBetSEP.class);
        CalculationKA.getInstance().setDataAcumBetSEP(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importKAS(ActionEvent actionEvent) {
        SaveXmlObject<DataKAS> saveXmlObject = new SaveXmlObject<>();
        DataKAS ob = saveXmlObject.readData("КАС","kas",DataKAS.class);
        CalculationKA.getInstance().setDataKAS(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSun(ActionEvent actionEvent) {
        SaveXmlObject<DataSumBetSEP> saveXmlObject = new SaveXmlObject<>();
        DataSumBetSEP ob = saveXmlObject.readData("Солнечные батареи","sun",DataSumBetSEP.class);
        CalculationKA.getInstance().setDataSumBetSEP(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importSpeed(ActionEvent actionEvent) {
        SaveXmlObject<DataSpeed> saveXmlObject = new SaveXmlObject<>();
        DataSpeed ob = saveXmlObject.readData("Характеристическая скорость","speed",DataSpeed.class);
        CalculationKA.getInstance().setDataSpeed(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importMassT(ActionEvent actionEvent) {
        SaveXmlObject<DataMassTopl> saveXmlObject = new SaveXmlObject<>();
        DataMassTopl ob = saveXmlObject.readData("Масса топлива","mstp",DataMassTopl.class);
        CalculationKA.getInstance().setDataMassTopl(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importKDU(ActionEvent actionEvent) {
        SaveXmlObject<DataKDU> saveXmlObject = new SaveXmlObject<>();
        DataKDU ob = saveXmlObject.readData("Массогабаритные и энергетические характеристики","kdu",DataKDU.class);
        CalculationKA.getInstance().setDataKDU(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importKonstr(ActionEvent actionEvent) {
        SaveXmlObject<DataKonstrKA> saveXmlObject = new SaveXmlObject<>();
        DataKonstrKA ob = saveXmlObject.readData("Конструкция КА","konstr",DataKonstrKA.class);
        CalculationKA.getInstance().setDataKonstrKA(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importBksAndAfu(ActionEvent actionEvent) {
        SaveXmlObject<DataBKSandAFU> saveXmlObject = new SaveXmlObject<>();
        DataBKSandAFU ob = saveXmlObject.readData("БКС и АФУ","bksafu",DataBKSandAFU.class);
        CalculationKA.getInstance().setDataBKSandAFU(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importOtherKa(ActionEvent actionEvent) {
        SaveXmlObject<DataOtherKA> saveXmlObject = new SaveXmlObject<>();
        DataOtherKA ob = saveXmlObject.readData("Прочие элементы КА","prka",DataOtherKA.class);
        CalculationKA.getInstance().setDataOtherKA(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }

    public void importRezerv(ActionEvent actionEvent) {
        SaveXmlObject<DataRezervKA> saveXmlObject = new SaveXmlObject<>();
        DataRezervKA ob = saveXmlObject.readData("Резерв","rezerv",DataRezervKA.class);
        CalculationKA.getInstance().setDataRezervKA(ob);
        startShowALL();
        showALL();
        ControllerAssembly.showInfo("Данные успешно импортированны.");
    }
}
