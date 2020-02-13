package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.*;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class ControllerImport extends ControllerZaimstv {

    private void upd (DataElement dataElement) {
        if (dataElement.isNeedUvyzka()) {
            CalculationKA.getInstance().getAllElementKA().add(dataElement);
        }
        List<DataElement> datum = new ArrayList<>(CalculationKA.getInstance().getAllElementKA());
        for (DataElement d:datum){
            CalculationKA.getInstance().getAllElementKA().add(d.getType().getDataElement());
        }
        initTableAllElementKA();
        actionShowParamRezult(new ActionEvent());
    }

    public void importSSD(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSSD> saveXmlObject = new SaveXmlObject<>();
            DataSSD ob = saveXmlObject.readData(TabTypeSintez.SSD.getName(), TabTypeSintez.SSD.getTypeName(), TabTypeSintez.SSD.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSSD(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importIPMV(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataIPMV> saveXmlObject = new SaveXmlObject<>();
            DataIPMV ob = saveXmlObject.readData(TabTypeSintez.IPMV.getName(), TabTypeSintez.IPMV.getTypeName(), TabTypeSintez.IPMV.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataIPMV(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }

    }

    public void importBOKZ(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataBOKZ> saveXmlObject = new SaveXmlObject<>();
            DataBOKZ ob = saveXmlObject.readData(TabTypeSintez.BOKZ.getName(), TabTypeSintez.BOKZ.getTypeName(), TabTypeSintez.BOKZ.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataBOKZ(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importDO(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataDO> saveXmlObject = new SaveXmlObject<>();
            DataDO ob = saveXmlObject.readData(TabTypeSintez.DO.getName(), TabTypeSintez.DO.getTypeName(), TabTypeSintez.DO.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataDO(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importDUS(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataDUS> saveXmlObject = new SaveXmlObject<>();
            DataDUS ob = saveXmlObject.readData(TabTypeSintez.DUS.getName(), TabTypeSintez.DUS.getTypeName(), TabTypeSintez.DUS.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataDUS(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importBks(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataBKS> saveXmlObject = new SaveXmlObject<>();
            DataBKS ob = saveXmlObject.readData(TabTypeSintez.BKS.getName(), TabTypeSintez.BKS.getTypeName(), TabTypeSintez.BKS.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataBKS(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importAfu(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataAFU> saveXmlObject = new SaveXmlObject<>();
            DataAFU ob = saveXmlObject.readData(TabTypeSintez.AFU.getName(), TabTypeSintez.AFU.getTypeName(), TabTypeSintez.AFU.getTypeClass());
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataAFU(ob);
            CalculationKA.getInstance().calculation(new Object());
//            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importRestriction(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataCommonParameters> saveXmlObject = new SaveXmlObject<>();
            DataCommonParameters ob = saveXmlObject.readData("Ограничения", "restr", DataCommonParameters.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataCommonParameters(ob);
            CalculationKA.getInstance().calculation(new Object());
            ControllerAssembly.getInstance().onProgressRestr(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importOETK(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataOETK> saveXmlObject = new SaveXmlObject<>();
            DataOETK ob = saveXmlObject.readData("ОETK", "oetk", DataOETK.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataOETK(ob);
            CalculationKA.getInstance().calculation(new Object());
            ControllerAssembly.getInstance().onProgressOetk(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSPPE(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSPPE> saveXmlObject = new SaveXmlObject<>();
            DataSPPE ob = saveXmlObject.readData("СППИ", "sppe", DataSPPE.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSPPE(ob);
            CalculationKA.getInstance().calculation(new Object());
            ControllerAssembly.getInstance().onProgressSppe(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importVRL(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataVRL> saveXmlObject = new SaveXmlObject<>();
            DataVRL ob = saveXmlObject.readData("ВРЛ", "vrl", DataVRL.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataVRL(ob);
            CalculationKA.getInstance().calculation(new Object());
            ControllerAssembly.getInstance().onProgressVrl(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importOtherCA(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataOtherCA> saveXmlObject = new SaveXmlObject<>();
            DataOtherCA ob = saveXmlObject.readData("Прочие элементы ЦА", "prca", DataOtherCA.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataOtherCA(ob);
            CalculationKA.getInstance().calculation(new Object());
            ControllerAssembly.getInstance().onProgressOtherCa(true);
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSGK(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSudSGK> saveXmlObject = new SaveXmlObject<>();
            DataSudSGK ob = saveXmlObject.readData("СГК", "sgk", DataSudSGK.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSudSGK(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSSKM(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSSKM> saveXmlObject = new SaveXmlObject<>();
            DataSSKM ob = saveXmlObject.readData("ССКМ", "sskm", DataSSKM.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSSKM(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSTKRP(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSTKRP> saveXmlObject = new SaveXmlObject<>();
            DataSTKRP ob = saveXmlObject.readData("СТКРП", "stkrp", DataSTKRP.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSTKRP(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importBAKES(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataBAKES> saveXmlObject = new SaveXmlObject<>();
            DataBAKES ob = saveXmlObject.readData("БА КИС", "bakes", DataBAKES.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataBAKES(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importBETS(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataBETS> saveXmlObject = new SaveXmlObject<>();
            DataBETS ob = saveXmlObject.readData("БИТС", "bets", DataBETS.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataBETS(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importBVS(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataBVS> saveXmlObject = new SaveXmlObject<>();
            DataBVS ob = saveXmlObject.readData("БВС", "bvs", DataBVS.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataBVS(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importOtherBKU(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataOtherBKU> saveXmlObject = new SaveXmlObject<>();
            DataOtherBKU ob = saveXmlObject.readData("Прочие элементы БКУ", "prbku", DataOtherBKU.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataOtherBKU(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importPasivSOTR(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataPasivSOTR> saveXmlObject = new SaveXmlObject<>();
            DataPasivSOTR ob = saveXmlObject.readData("Пасивные элементы СОТР", "evti", DataPasivSOTR.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataPasivSOTR(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importActivSOTR(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataActivSOTR> saveXmlObject = new SaveXmlObject<>();
            DataActivSOTR ob = saveXmlObject.readData("Активные элементы СОТР", "str", DataActivSOTR.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataActivSOTR(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importElectParamSEP(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataElectHaraktSEP> saveXmlObject = new SaveXmlObject<>();
            DataElectHaraktSEP ob = saveXmlObject.readData("Электротехнические характеристики СЭП", "eetsep", DataElectHaraktSEP.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataElectHaraktSEP(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importAccumBet(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataAcumBetSEP> saveXmlObject = new SaveXmlObject<>();
            DataAcumBetSEP ob = saveXmlObject.readData("Аккумуляторные батареи", "acbtsep", DataAcumBetSEP.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataAcumBetSEP(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importKAS(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataKAS> saveXmlObject = new SaveXmlObject<>();
            DataKAS ob = saveXmlObject.readData("КАС", "kas", DataKAS.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataKAS(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSun(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSumBetSEP> saveXmlObject = new SaveXmlObject<>();
            DataSumBetSEP ob = saveXmlObject.readData("Солнечные батареи", "sun", DataSumBetSEP.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSumBetSEP(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importSpeed(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataSpeed> saveXmlObject = new SaveXmlObject<>();
            DataSpeed ob = saveXmlObject.readData("Характеристическая скорость", "speed", DataSpeed.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataSpeed(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importMassT(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataMassTopl> saveXmlObject = new SaveXmlObject<>();
            DataMassTopl ob = saveXmlObject.readData("Масса топлива", "mstp", DataMassTopl.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataMassTopl(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importKDU(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataKDU> saveXmlObject = new SaveXmlObject<>();
            DataKDU ob = saveXmlObject.readData("Массогабаритные и энергетические характеристики", "kdu", DataKDU.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataKDU(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importKonstr(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataKonstrKA> saveXmlObject = new SaveXmlObject<>();
            DataKonstrKA ob = saveXmlObject.readData("Конструкция КА", "konstr", DataKonstrKA.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataKonstrKA(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importBksAndAfu(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataAFU> saveXmlObject = new SaveXmlObject<>();
            DataAFU ob = saveXmlObject.readData("БКС и АФУ", "bksafu", DataAFU.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataAFU(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importOtherKa(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataOtherKA> saveXmlObject = new SaveXmlObject<>();
            DataOtherKA ob = saveXmlObject.readData("Прочие элементы КА", "prka", DataOtherKA.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataOtherKA(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }

    public void importRezerv(ActionEvent actionEvent) {
        try {
            SaveXmlObject<DataRezervKA> saveXmlObject = new SaveXmlObject<>();
            DataRezervKA ob = saveXmlObject.readData("Резерв", "rezerv", DataRezervKA.class);
            if (ob == null) return;
            ob.getType().getCalculation().predCalculation();
            CalculationKA.getInstance().setDataRezervKA(ob);
            CalculationKA.getInstance().calculation(new Object());
            startShowALL();
            showALL();
            ControllerAssembly.showInfo("Данные успешно импортированны. \nНеобходим ПЕРЕРАСЧЕТ!");
            upd(ob);
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при импорте.");
        }
    }
}
