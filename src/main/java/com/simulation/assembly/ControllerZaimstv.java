package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerZaimstv extends ControllerExport {

    public RadioButton choise_non_OETK;
    public RadioButton choise_non_SPPE;
    public RadioButton choise_non_VRL;
    public RadioButton choise_non_SSD;
    public RadioButton choise_non_OtherCa;
    public RadioButton choise_non_BVS;
    public RadioButton choise_non_STKRP;
    public RadioButton choise_non_KIS;
    public RadioButton choise_non_BETS;
    public RadioButton choise_non_OtherBKU;
    public RadioButton choise_non_SGK;
    public RadioButton choise_non_SSKM;
    public RadioButton choise_non_IPMV;
    public RadioButton choise_non_BOKZ;
    public RadioButton choise_non_DO;
    public RadioButton choise_non_DOU;
    public RadioButton choise_non_PasivSOTR;
    public RadioButton choise_non_ActivSOTR;
    public RadioButton choise_non_AcumBet;
    public RadioButton choise_non_KAS;
    public RadioButton choise_non_Sun;
    public RadioButton choise_non_KDU;
    public RadioButton choise_non_Konstr;
    public RadioButton choise_non_BKS;
    public RadioButton choise_non_AFU;
    public RadioButton choise_non_Rezerv;

    public Button bt_calcul_SPPE;
    public Button bt_calcul_VRL;
    public Button bt_calcul_SSD;
    public Button bt_calcul_OtherCA;
    public Button bt_calcul_BVS;
    public Button bt_calcul_STKRP;
    public Button bt_calcul_BAKES;
    public Button bt_calcul_BETS;
    public Button bt_calcul_OtherBKU;
    public Button bt_calcul_SSKM;
    public Button bt_calcul_IPMV;
    public Button bt_calcul_BOKZ;
    public Button bt_calcul_DO;
    public Button bt_calcul_DUS;
    public Button bt_calcul_PasivSOTR;
    public Button bt_calcul_ActivSOTR;
    public Button bt_calcul_AcumBet;
    public Button bt_calcul_KAS;
    public Button bt_calcul_SunBet;
    public Button bt_calcul_KDU;
    public Button bt_calcul_konstr;
    public Button bt_calcul_BKS;
    public Button bt_calcul_AFU;

    private void showWindow (String path,String title){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root, 670, 400);
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(pane_finishData_OETK.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }


    public void haveSSD(ActionEvent actionEvent) {
        if (choise_have_SSD.isSelected()){
            pane_zaimsv_ssd.setVisible(true);
        }else {
            pane_zaimsv_ssd.setVisible(false);
        }
        if (choise_non_SSD.isSelected()){
            TabTypeSintez.SSD.getDataElement().setNotUse(true);
            bt_calcul_SSD.setDisable(true);
            allElementKA.remove(TabTypeSintez.SSD.getDataElement());
        }else {
            TabTypeSintez.SSD.getDataElement().setNotUse(false);
            bt_calcul_SSD.setDisable(false);
        }
        CalculationKA.getInstance().setDataSSD(new DataSSD());
        showSSD();
        initTableAllElementKA();
    }

    public void haveIPMV(ActionEvent actionEvent) {
        if (choise_have_IPMV.isSelected()){
            pane_zaimsv_IPMV.setVisible(true);
        }else {
            pane_zaimsv_IPMV.setVisible(false);
        }
        if (choise_non_IPMV.isSelected()){
            TabTypeSintez.IPMV.getDataElement().setNotUse(true);
            bt_calcul_IPMV.setDisable(true);
            allElementKA.remove(TabTypeSintez.IPMV.getDataElement());
        }else {
            TabTypeSintez.IPMV.getDataElement().setNotUse(false);
            bt_calcul_IPMV.setDisable(false);
        }
        CalculationKA.getInstance().setDataIPMV(new DataIPMV());
        showIPMV();
        initTableAllElementKA();
    }

    public void haveBOKZ(ActionEvent actionEvent) {
        if (choise_have_BOKZ.isSelected()){
            pane_zaimsv_BOKZ.setVisible(true);
        }else {
            pane_zaimsv_BOKZ.setVisible(false);
        }
        if (choise_non_BOKZ.isSelected()){
            TabTypeSintez.BOKZ.getDataElement().setNotUse(true);
            bt_calcul_BOKZ.setDisable(true);
            allElementKA.remove(TabTypeSintez.BOKZ.getDataElement());
        }else {
            TabTypeSintez.BOKZ.getDataElement().setNotUse(false);
            bt_calcul_BOKZ.setDisable(false);
        }
        CalculationKA.getInstance().setDataBOKZ(new DataBOKZ());
        showBOKZ();
        initTableAllElementKA();
    }

    public void haveDO(ActionEvent actionEvent) {
        if (choise_have_DO.isSelected()){
            pane_zaimsv_DO.setVisible(true);
        }else {
            pane_zaimsv_DO.setVisible(false);
        }
        if (choise_non_DO.isSelected()){
            TabTypeSintez.DO.getDataElement().setNotUse(true);
            bt_calcul_DO.setDisable(true);
            allElementKA.remove(TabTypeSintez.DO.getDataElement());
        }else {
            TabTypeSintez.DO.getDataElement().setNotUse(false);
            bt_calcul_DO.setDisable(false);
        }
        CalculationKA.getInstance().setDataDO(new DataDO());
        showDO();
        initTableAllElementKA();
    }

    public void haveDUS(ActionEvent actionEvent) {
        if (choise_have_DUS.isSelected()){
            pane_zaimsv_DUS.setVisible(true);
        }else {
            pane_zaimsv_DUS.setVisible(false);
        }
        if (choise_non_DOU.isSelected()){
            TabTypeSintez.DUS.getDataElement().setNotUse(true);
            bt_calcul_DUS.setDisable(true);
            allElementKA.remove(TabTypeSintez.DUS.getDataElement());
        }else {
            TabTypeSintez.DUS.getDataElement().setNotUse(false);
            bt_calcul_DUS.setDisable(false);
        }
        CalculationKA.getInstance().setDataDUS(new DataDUS());
        showDUS();
        initTableAllElementKA();
    }

    public void haveBKS(ActionEvent actionEvent) {
        if (choise_have_BKS.isSelected()){
            pane_zaimsv_BKS.setVisible(true);
        }else {
            pane_zaimsv_BKS.setVisible(false);
        }
        if (choise_non_BKS.isSelected()){
            TabTypeSintez.BKS.getDataElement().setNotUse(true);
            bt_calcul_BKS.setDisable(true);
            allElementKA.remove(TabTypeSintez.BKS.getDataElement());
        }else {
            TabTypeSintez.BKS.getDataElement().setNotUse(false);
            bt_calcul_BKS.setDisable(false);
        }
        CalculationKA.getInstance().setDataBKS(new DataBKS());
        showBKS();
        initTableAllElementKA();
    }

    public void haveAFU(ActionEvent actionEvent) {
        if (choise_have_AFU.isSelected()){
            pane_zaimsv_AFU.setVisible(true);
        }else {
            pane_zaimsv_AFU.setVisible(false);
        }
        if (choise_non_AFU.isSelected()){
            TabTypeSintez.AFU.getDataElement().setNotUse(true);
            bt_calcul_AFU.setDisable(true);
            allElementKA.remove(TabTypeSintez.AFU.getDataElement());
        }else {
            TabTypeSintez.AFU.getDataElement().setNotUse(false);
            bt_calcul_AFU.setDisable(false);
        }
        CalculationKA.getInstance().setDataAFU(new DataAFU());
        showAFU();
        initTableAllElementKA();
    }

    public void haveOETK(ActionEvent actionEvent) {
//        showWindow("/assembly/importOETK.fxml", "Заимсвованные элементы - ОЕТК");
        if (choise_have_OETK.isSelected()){
            pane_zaimsv_oetk.setVisible(true);
        }else {
            pane_zaimsv_oetk.setVisible(false);
        }
        if (choise_non_OETK.isSelected()){
            TabTypeSintez.OETK.getDataElement().setNotUse(true);
            bt_calcul_OETK.setDisable(true);
            allElementKA.remove(TabTypeSintez.OETK.getDataElement());
        }else {
            TabTypeSintez.OETK.getDataElement().setNotUse(false);
            bt_calcul_OETK.setDisable(false);
        }
        CalculationKA.getInstance().setDataOETK(new DataOETK());
        showOetkResult();
        initTableAllElementKA();
    }

    public void haveSPPE(ActionEvent actionEvent) {
        if (choise_have_SPPE.isSelected()){
            pane_zaimsv_SPPE.setVisible(true);
        }else {
            pane_zaimsv_SPPE.setVisible(false);
        }
        if (choise_non_SPPE.isSelected()){
            TabTypeSintez.SPPE.getDataElement().setNotUse(true);
            bt_calcul_SPPE.setDisable(true);
            allElementKA.remove(TabTypeSintez.SPPE.getDataElement());
        }else {
            TabTypeSintez.SPPE.getDataElement().setNotUse(false);
            bt_calcul_SPPE.setDisable(false);
        }
        CalculationKA.getInstance().setDataSPPE(new DataSPPE());
        showSPEEResult();
        initTableAllElementKA();
//        showWindow("/assembly/importSPPE.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SPPE.getName());
    }

    public void haveSSKM(ActionEvent actionEvent) {
        if (choise_have_SSKM.isSelected()){
            pane_zaimsv_sskm.setVisible(true);
        }else {
            pane_zaimsv_sskm.setVisible(false);
        }
        if (choise_non_SSKM.isSelected()){
            TabTypeSintez.SUD_SSKM.getDataElement().setNotUse(true);
            bt_calcul_SSKM.setDisable(true);
            allElementKA.remove(TabTypeSintez.SUD_SSKM.getDataElement());
        }else {
            TabTypeSintez.SUD_SSKM.getDataElement().setNotUse(false);
            bt_calcul_SSKM.setDisable(false);
        }
        CalculationKA.getInstance().setDataSSKM(new DataSSKM());
        showSSKMResult();
        initTableAllElementKA();
//        showWindow("/assembly/importSSKM.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SUD_SSKM.getName());
    }

    public void addOtherKaElementZaimsv(ActionEvent actionEvent) {
    }

    public void haveVRL(ActionEvent actionEvent) {
        if (choise_have_VRL.isSelected()){
            pane_zaimsv_VRL.setVisible(true);
        }else {
            pane_zaimsv_VRL.setVisible(false);
        }
        if (choise_non_VRL.isSelected()){
            TabTypeSintez.VRL.getDataElement().setNotUse(true);
            bt_calcul_VRL.setDisable(true);
            allElementKA.remove(TabTypeSintez.VRL.getDataElement());
        }else {
            TabTypeSintez.VRL.getDataElement().setNotUse(false);
            bt_calcul_VRL.setDisable(false);
        }
        CalculationKA.getInstance().setDataVRL(new DataVRL());
        showVRLResult();
        initTableAllElementKA();
    }

    public void haveOtherCA(ActionEvent actionEvent) {
        if (choise_have_OtherCA.isSelected()){
            pane_zaimsv_OtherCA.setVisible(true);
        }else {
            pane_zaimsv_OtherCA.setVisible(false);
        }
        if (choise_non_OtherCa.isSelected()){
            TabTypeSintez.OTHER_ELEMENTS_CA.getDataElement().setNotUse(true);
            bt_calcul_OtherCA.setDisable(true);
            allElementKA.remove(TabTypeSintez.OTHER_ELEMENTS_CA.getDataElement());
        }else {
            TabTypeSintez.OTHER_ELEMENTS_CA.getDataElement().setNotUse(false);
            bt_calcul_OtherCA.setDisable(false);
        }
        CalculationKA.getInstance().setDataOtherCA(new DataOtherCA());
        showOtherCAResult();
        initTableAllElementKA();
    }

    public void haveBVS(ActionEvent actionEvent) {
        if (choise_have_BVS.isSelected()){
            pane_zaimsv_BVS.setVisible(true);
        }else {
            pane_zaimsv_BVS.setVisible(false);
        }
        if (choise_non_BVS.isSelected()){
            TabTypeSintez.BVS.getDataElement().setNotUse(true);
            bt_calcul_BVS.setDisable(true);
            allElementKA.remove(TabTypeSintez.BVS.getDataElement());
        }else {
            TabTypeSintez.BVS.getDataElement().setNotUse(false);
            bt_calcul_BVS.setDisable(false);
        }
        CalculationKA.getInstance().setDataBVS(new DataBVS());
        showBVSResult();
        initTableAllElementKA();
    }

    public void haveSTKRP(ActionEvent actionEvent) {
        if (choise_have_STKRP.isSelected()){
            pane_zaimsv_STKRP.setVisible(true);
        }else {
            pane_zaimsv_STKRP.setVisible(false);
        }
        if (choise_non_STKRP.isSelected()){
            TabTypeSintez.STKRP.getDataElement().setNotUse(true);
            bt_calcul_STKRP.setDisable(true);
            allElementKA.remove(TabTypeSintez.STKRP.getDataElement());
        }else {
            TabTypeSintez.STKRP.getDataElement().setNotUse(false);
            bt_calcul_STKRP.setDisable(false);
        }
        CalculationKA.getInstance().setDataSTKRP(new DataSTKRP());
        showSTKRPResult();
        initTableAllElementKA();
    }

    public void haveBAKES(ActionEvent actionEvent) {
        if (choise_have_KIS.isSelected()){
            pane_zaimsv_KIS.setVisible(true);
        }else {
            pane_zaimsv_KIS.setVisible(false);
        }
        if (choise_non_KIS.isSelected()){
            TabTypeSintez.BAKIS.getDataElement().setNotUse(true);
            bt_calcul_BAKES.setDisable(true);
            allElementKA.remove(TabTypeSintez.BAKIS.getDataElement());
        }else {
            TabTypeSintez.BAKIS.getDataElement().setNotUse(false);
            bt_calcul_BAKES.setDisable(false);
        }
        CalculationKA.getInstance().setDataBAKES(new DataBAKES());
        showKISResult();
        initTableAllElementKA();
    }

    public void haveKIS(ActionEvent actionEvent) {
        if (choise_have_KIS.isSelected()){
            pane_zaimsv_KIS.setVisible(true);
        }else {
            pane_zaimsv_KIS.setVisible(false);
        }
        if (choise_non_KIS.isSelected()){
            TabTypeSintez.BAKIS.getDataElement().setNotUse(true);
            bt_calcul_BAKES.setDisable(true);
            allElementKA.remove(TabTypeSintez.BAKIS.getDataElement());
        }else {
            TabTypeSintez.BAKIS.getDataElement().setNotUse(false);
            bt_calcul_BAKES.setDisable(false);
        }
        CalculationKA.getInstance().setDataBAKES(new DataBAKES());
        showKISResult();
        initTableAllElementKA();
    }

    public void haveBETS(ActionEvent actionEvent) {
        if (choise_have_BETS.isSelected()){
            pane_zaimsv_BETS.setVisible(true);
        }else {
            pane_zaimsv_BETS.setVisible(false);
        }
        if (choise_non_BETS.isSelected()){
            TabTypeSintez.BETS.getDataElement().setNotUse(true);
            bt_calcul_BETS.setDisable(true);
            allElementKA.remove(TabTypeSintez.BETS.getDataElement());
        }else {
            TabTypeSintez.BETS.getDataElement().setNotUse(false);
            bt_calcul_BETS.setDisable(false);
        }
        CalculationKA.getInstance().setDataBETS(new DataBETS());
        showBETSResult();
        initTableAllElementKA();
    }

    public void haveOtherBKU(ActionEvent actionEvent) {
        if (choise_have_OtherBKU.isSelected()){
            pane_zaimsv_OtherBKU.setVisible(true);
        }else {
            pane_zaimsv_OtherBKU.setVisible(false);
        }
        if (choise_non_OtherBKU.isSelected()){
            TabTypeSintez.OTHER_ELEMENTS_BKU.getDataElement().setNotUse(true);
            bt_calcul_OtherBKU.setDisable(true);
            allElementKA.remove(TabTypeSintez.OTHER_ELEMENTS_BKU.getDataElement());
        }else {
            TabTypeSintez.OTHER_ELEMENTS_BKU.getDataElement().setNotUse(false);
            bt_calcul_OtherBKU.setDisable(false);
        }
        CalculationKA.getInstance().setDataOtherBKU(new DataOtherBKU());
        showOtherBKUResult();
        initTableAllElementKA();
    }

    public void haveSGK(ActionEvent actionEvent) {
        if (choise_have_SGK.isSelected()){
            pane_zaimsv_SGK.setVisible(true);
        }else {
            pane_zaimsv_SGK.setVisible(false);
        }
        if (choise_non_SGK.isSelected()){
            TabTypeSintez.SUD_SGK.getDataElement().setNotUse(true);
            bt_calcul_SGK.setDisable(true);
            allElementKA.remove(TabTypeSintez.SUD_SGK.getDataElement());
        }else {
            TabTypeSintez.SUD_SGK.getDataElement().setNotUse(false);
            bt_calcul_SGK.setDisable(false);
        }
        CalculationKA.getInstance().setDataSudSGK(new DataSudSGK());
        showSgkResult();
        initTableAllElementKA();
    }

    public void havePasivSOTR(ActionEvent actionEvent) {
        if (choise_have_Pasivv.isSelected()){
            pane_zaimsv_Pasivv.setVisible(true);
        }else {
            pane_zaimsv_Pasivv.setVisible(false);
        }
        if (choise_non_PasivSOTR.isSelected()){
            TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement().setNotUse(true);
            bt_calcul_PasivSOTR.setDisable(true);
            allElementKA.remove(TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement());
        }else {
            TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement().setNotUse(false);
            bt_calcul_PasivSOTR.setDisable(false);
        }
        CalculationKA.getInstance().setDataPasivSOTR(new DataPasivSOTR());
        showPasivSOTRResult();
        initTableAllElementKA();
    }

    public void havePasiv(ActionEvent actionEvent) {
        if (choise_have_Pasivv.isSelected()){
            pane_zaimsv_Pasivv.setVisible(true);
        }else {
            pane_zaimsv_Pasivv.setVisible(false);
        }
        if (choise_non_PasivSOTR.isSelected()){
            TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement().setNotUse(false);
        }
    }

    public void haveActivSOTR(ActionEvent actionEvent) {
        if (choise_have_Activ.isSelected()){
            pane_zaimsv_Activ.setVisible(true);
        }else {
            pane_zaimsv_Activ.setVisible(false);
        }
        if (choise_non_ActivSOTR.isSelected()){
            TabTypeSintez.ACTIV_ELEMENT_SOTR.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.ACTIV_ELEMENT_SOTR.getDataElement().setNotUse(false);
        }
    }

    public void haveActiv(ActionEvent actionEvent) {
        if (choise_have_Activ.isSelected()){
            pane_zaimsv_Activ.setVisible(true);
        }else {
            pane_zaimsv_Activ.setVisible(false);
        }
        if (choise_non_ActivSOTR.isSelected()){
            TabTypeSintez.ACTIV_ELEMENT_SOTR.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.ACTIV_ELEMENT_SOTR.getDataElement().setNotUse(false);
        }
    }


    public void haveAcum(ActionEvent actionEvent) {
        if (choise_have_Acum.isSelected()){
            pane_zaimsv_Acum.setVisible(true);
        }else {
            pane_zaimsv_Acum.setVisible(false);
        }
        if (choise_non_AcumBet.isSelected()){
            TabTypeSintez.AKUM_BATTERIES.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.AKUM_BATTERIES.getDataElement().setNotUse(false);
        }
    }

    public void haveKAS(ActionEvent actionEvent) {
        if (choise_have_KAS.isSelected()){
            pane_zaimsv_KAS.setVisible(true);
        }else {
            pane_zaimsv_KAS.setVisible(false);
        }
        if (choise_non_KAS.isSelected()){
            TabTypeSintez.KAS.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.KAS.getDataElement().setNotUse(false);
        }
    }

    public void haveSun(ActionEvent actionEvent) {
        if (choise_have_Sun.isSelected()){
            pane_zaimsv_Sun.setVisible(true);
        }else {
            pane_zaimsv_Sun.setVisible(false);
        }
        if (choise_non_Sun.isSelected()){
            TabTypeSintez.SUN_BATTERIES.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.SUN_BATTERIES.getDataElement().setNotUse(false);
        }
    }

    public void havekdu(ActionEvent actionEvent) {
        if (choise_have_kdu.isSelected()){
            pane_zaimsv_kdu.setVisible(true);
        }else {
            pane_zaimsv_kdu.setVisible(false);
        }
        if (choise_non_KDU.isSelected()){
            TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getDataElement().setNotUse(false);
        }
    }

    public void haveKonstr(ActionEvent actionEvent) {
        if (choise_have_Konstr.isSelected()){
            pane_zaimsv_Konstr.setVisible(true);
        }else {
            pane_zaimsv_Konstr.setVisible(false);
        }
        if (choise_non_Konstr.isSelected()){
            TabTypeSintez.KONSTR.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.KONSTR.getDataElement().setNotUse(false);
        }
    }

    public void haveRezerv(ActionEvent actionEvent) {
        if (choise_have_Rezerv.isSelected()){
            pane_zaimsv_Rezerv.setVisible(true);
        }else {
            pane_zaimsv_Rezerv.setVisible(false);
        }
        if (choise_non_Rezerv.isSelected()){
            TabTypeSintez.RETHERV.getDataElement().setNotUse(true);
        }else {
            TabTypeSintez.RETHERV.getDataElement().setNotUse(false);
        }
    }

    private void onLabelZaim (String name, Label label) {
//        if (name==null){
//            label.setVisible(false);
//            return;
//        }
//        label.setVisible(true);
//        label.setText("Выбран взаимсвованный элемент - "+name);
    }

    public void onLabelZaimOetk (String name) {
        onLabelZaim(name,labelZaimOetk);
    }

    public void onLabelZaimSppe (String name) {
        onLabelZaim(name,labelZaimSppe);
    }

    public void onLabelZaimVrl(String name) {
        onLabelZaim(name,labelZaimVrl);
    }

    public void onLabelZaimOtherCa (String name) {
        onLabelZaim(name,labelZaimOtherCA);
    }

    public void onLabelZaimSgk (String name) {
        onLabelZaim(name,labelZaimSgk);
    }

    public void onLabelZaimSskm (String name) {
        onLabelZaim(name,labelZaimSSKM);
    }

    public void onLabelZaimStkrp (String name) {
        onLabelZaim(name,labelZaimStkrp);
    }

    public void onLabelZaimBaKis (String name) {
        onLabelZaim(name,labelZaimBaKis);
    }

    public void onLabelZaimBets (String name) {
        onLabelZaim(name,labelZaimBets);
    }

    public void onLabelZaimBvs (String name) {
        onLabelZaim(name,labelZaimBvs);
    }

    public void onLabelZaimOtherBku (String name) {
        onLabelZaim(name,labelZaimOtherBku);
    }

    public void onLabelZaimOtherPasivSotr (String name) {
        onLabelZaim(name,labelZaimPasivSotr);
    }

    public void onLabelZaimActivSotr(String name) {
        onLabelZaim(name,labelZaimActivSotr);
    }

    public void onLabelZaimOtherEleHarSep (String name) {
        onLabelZaim(name,labelZaimElHarSep);
    }

    public void onLabelZaimAcumBet(String name) {
        onLabelZaim(name,labelZaimAcumBet);
    }

    public void onLabelZaimKas(String name) {
        onLabelZaim(name,labelZaimKas);
    }

    public void onLabelZaimSunBet (String name) {
        onLabelZaim(name,labelZaimSunBet);
    }

    public void onLabelZaimSunSpeed (String name) {
        onLabelZaim(name,labelZaimSpeed);
    }

    public void onLabelZaimMassT (String name) {
        onLabelZaim(name,labelZaimMassT);
    }

    public void onLabelZaimKDU (String name) {
        onLabelZaim(name,labelZaimKDU);
    }

    public void onLabelZaimKonstr (String name) {
        onLabelZaim(name,labelZaimKonstr);
    }

    public void onLabelZaimBKSandAfu (String name) {
        onLabelZaim(name,labelZaimBksAndAfu);
    }

    public void onLabelZaimRezerv (String name) {
        onLabelZaim(name,labelZaimRezerv);
    }

    public void actionShowParamRezult(ActionEvent actionEvent) {
        showSinezKA();
    }
}
