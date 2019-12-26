package com.simulation.assembly;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerZaimstv extends ControllerExport {

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
    }

    public void haveIPMV(ActionEvent actionEvent) {
        if (choise_have_IPMV.isSelected()){
            pane_zaimsv_IPMV.setVisible(true);
        }else {
            pane_zaimsv_IPMV.setVisible(false);
        }
    }

    public void haveBOKZ(ActionEvent actionEvent) {
        if (choise_have_BOKZ.isSelected()){
            pane_zaimsv_BOKZ.setVisible(true);
        }else {
            pane_zaimsv_BOKZ.setVisible(false);
        }
    }

    public void haveDO(ActionEvent actionEvent) {
        if (choise_have_DO.isSelected()){
            pane_zaimsv_DO.setVisible(true);
        }else {
            pane_zaimsv_DO.setVisible(false);
        }
    }

    public void haveDUS(ActionEvent actionEvent) {
        if (choise_have_DUS.isSelected()){
            pane_zaimsv_DUS.setVisible(true);
        }else {
            pane_zaimsv_DUS.setVisible(false);
        }
    }

    public void haveBKS(ActionEvent actionEvent) {
        if (choise_have_BKS.isSelected()){
            pane_zaimsv_BKS.setVisible(true);
        }else {
            pane_zaimsv_BKS.setVisible(false);
        }
    }

    public void haveAFU(ActionEvent actionEvent) {
        if (choise_have_AFU.isSelected()){
            pane_zaimsv_AFU.setVisible(true);
        }else {
            pane_zaimsv_AFU.setVisible(false);
        }
    }

    public void haveOETK(ActionEvent actionEvent) {
//        showWindow("/assembly/importOETK.fxml", "Заимсвованные элементы - ОЕТК");
        if (choise_have_OETK.isSelected()){
            pane_zaimsv_oetk.setVisible(true);
        }else {
            pane_zaimsv_oetk.setVisible(false);
        }
    }

    public void haveSPPE(ActionEvent actionEvent) {
        if (choise_have_SPPE.isSelected()){
            pane_zaimsv_SPPE.setVisible(true);
        }else {
            pane_zaimsv_SPPE.setVisible(false);
        }
//        showWindow("/assembly/importSPPE.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SPPE.getName());
    }

    public void haveSSKM(ActionEvent actionEvent) {
        if (choise_have_SSKM.isSelected()){
            pane_zaimsv_sskm.setVisible(true);
        }else {
            pane_zaimsv_sskm.setVisible(false);
        }
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
    }

    public void haveOtherCA(ActionEvent actionEvent) {
        if (choise_have_OtherCA.isSelected()){
            pane_zaimsv_OtherCA.setVisible(true);
        }else {
            pane_zaimsv_OtherCA.setVisible(false);
        }
    }

    public void haveBVS(ActionEvent actionEvent) {
        if (choise_have_BVS.isSelected()){
            pane_zaimsv_BVS.setVisible(true);
        }else {
            pane_zaimsv_BVS.setVisible(false);
        }
    }

    public void haveSTKRP(ActionEvent actionEvent) {
        if (choise_have_STKRP.isSelected()){
            pane_zaimsv_STKRP.setVisible(true);
        }else {
            pane_zaimsv_STKRP.setVisible(false);
        }
    }

    public void haveBAKES(ActionEvent actionEvent) {
        if (choise_have_KIS.isSelected()){
            pane_zaimsv_KIS.setVisible(true);
        }else {
            pane_zaimsv_KIS.setVisible(false);
        }
    }

    public void haveKIS(ActionEvent actionEvent) {
        if (choise_have_KIS.isSelected()){
            pane_zaimsv_KIS.setVisible(true);
        }else {
            pane_zaimsv_KIS.setVisible(false);
        }
    }

    public void haveBETS(ActionEvent actionEvent) {
        if (choise_have_BETS.isSelected()){
            pane_zaimsv_BETS.setVisible(true);
        }else {
            pane_zaimsv_BETS.setVisible(false);
        }
    }

    public void haveOtherBKU(ActionEvent actionEvent) {
        if (choise_have_OtherBKU.isSelected()){
            pane_zaimsv_OtherBKU.setVisible(true);
        }else {
            pane_zaimsv_OtherBKU.setVisible(false);
        }
    }

    public void haveSGK(ActionEvent actionEvent) {
        if (choise_have_SGK.isSelected()){
            pane_zaimsv_SGK.setVisible(true);
        }else {
            pane_zaimsv_SGK.setVisible(false);
        }
    }

    public void havePasivSOTR(ActionEvent actionEvent) {
        if (choise_have_Pasivv.isSelected()){
            pane_zaimsv_Pasivv.setVisible(true);
        }else {
            pane_zaimsv_Pasivv.setVisible(false);
        }
    }

    public void havePasiv(ActionEvent actionEvent) {
        if (choise_have_Pasivv.isSelected()){
            pane_zaimsv_Pasivv.setVisible(true);
        }else {
            pane_zaimsv_Pasivv.setVisible(false);
        }
    }

    public void haveActivSOTR(ActionEvent actionEvent) {
        if (choise_have_Activ.isSelected()){
            pane_zaimsv_Activ.setVisible(true);
        }else {
            pane_zaimsv_Activ.setVisible(false);
        }
    }

    public void haveActiv(ActionEvent actionEvent) {
        if (choise_have_Activ.isSelected()){
            pane_zaimsv_Activ.setVisible(true);
        }else {
            pane_zaimsv_Activ.setVisible(false);
        }
    }


    public void haveAcum(ActionEvent actionEvent) {
        if (choise_have_Acum.isSelected()){
            pane_zaimsv_Acum.setVisible(true);
        }else {
            pane_zaimsv_Acum.setVisible(false);
        }
    }

    public void haveKAS(ActionEvent actionEvent) {
        if (choise_have_KAS.isSelected()){
            pane_zaimsv_KAS.setVisible(true);
        }else {
            pane_zaimsv_KAS.setVisible(false);
        }
    }

    public void haveSun(ActionEvent actionEvent) {
        if (choise_have_Sun.isSelected()){
            pane_zaimsv_Sun.setVisible(true);
        }else {
            pane_zaimsv_Sun.setVisible(false);
        }
    }

    public void havekdu(ActionEvent actionEvent) {
        if (choise_have_kdu.isSelected()){
            pane_zaimsv_kdu.setVisible(true);
        }else {
            pane_zaimsv_kdu.setVisible(false);
        }
    }

    public void haveKonstr(ActionEvent actionEvent) {
        if (choise_have_Konstr.isSelected()){
            pane_zaimsv_Konstr.setVisible(true);
        }else {
            pane_zaimsv_Konstr.setVisible(false);
        }
    }

    public void haveRezerv(ActionEvent actionEvent) {
        if (choise_have_Rezerv.isSelected()){
            pane_zaimsv_Rezerv.setVisible(true);
        }else {
            pane_zaimsv_Rezerv.setVisible(false);
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
