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

    public void haveOETK(ActionEvent actionEvent) {
        showWindow("/assembly/importOETK.fxml", "Заимсвованные элементы - ОЕТК");
    }

    public void haveSPPE(ActionEvent actionEvent) {
        showWindow("/assembly/importSPPE.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SPPE.getName());
    }

    public void haveVRL(ActionEvent actionEvent) {
        showWindow("/assembly/importVRL.fxml", "Заимсвованные элементы - "+ TabTypeSintez.VRL.getName());
    }

    public void haveOtherCA(ActionEvent actionEvent) {
        showWindow("/assembly/importOtherCA.fxml", "Заимсвованные элементы - "+ TabTypeSintez.OTHER_ELEMENTS_CA.getName());
    }

    public void haveSGK(ActionEvent actionEvent) {
        showWindow("/assembly/importSGK.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SUD_SGK.getName());
    }

    public void haveSSKM(ActionEvent actionEvent) {
        showWindow("/assembly/importSSKM.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SUD_SSKM.getName());

    }

    public void haveSTKRP(ActionEvent actionEvent) {
        showWindow("/assembly/importSTKRP.fxml", "Заимсвованные элементы - "+ TabTypeSintez.STKRP.getName());

    }

    public void haveBAKES(ActionEvent actionEvent) {
        showWindow("/assembly/importBAKES.fxml", "Заимсвованные элементы - "+ TabTypeSintez.BAKIS.getName());
    }

    public void haveBETS(ActionEvent actionEvent) {
        showWindow("/assembly/importBETS.fxml", "Заимсвованные элементы - "+ TabTypeSintez.BETS.getName());
    }

    public void haveBVS(ActionEvent actionEvent) {
        showWindow("/assembly/importBVS.fxml", "Заимсвованные элементы - "+ TabTypeSintez.BVS.getName());
    }

    public void haveOtherBKU(ActionEvent actionEvent) {
        showWindow("/assembly/importOtherBKU.fxml", "Заимсвованные элементы - "+ TabTypeSintez.OTHER_ELEMENTS_BKU.getName());
    }

    public void havePasivSOTR(ActionEvent actionEvent) {
        showWindow("/assembly/importPasivSOTR.fxml", "Заимсвованные элементы - "+ TabTypeSintez.PASSIV_ELEMENT_SOTR.getName());
    }

    public void haveActivSOTR(ActionEvent actionEvent) {
        showWindow("/assembly/importActivSOTR.fxml", "Заимсвованные элементы - "+ TabTypeSintez.ACTIV_ELEMENT_SOTR.getName());
    }

    public void haveElectParamSEP(ActionEvent actionEvent) {
        showWindow("/assembly/importElectHarSEP.fxml", "Заимсвованные элементы - "+ TabTypeSintez.ELECTROTEH_PARAM.getName());
    }

    public void haveAccumBet(ActionEvent actionEvent) {
        showWindow("/assembly/importAcumBet.fxml", "Заимсвованные элементы - "+ TabTypeSintez.AKUM_BATTERIES.getName());
    }

    public void haveKAS(ActionEvent actionEvent) {
        showWindow("/assembly/importKAS.fxml", "Заимсвованные элементы - "+ TabTypeSintez.KAS.getName());
    }

    public void haveSun(ActionEvent actionEvent) {
        showWindow("/assembly/importSunBet.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SUN_BATTERIES.getName());
    }

    public void haveSpeed(ActionEvent actionEvent) {
        showWindow("/assembly/importSpeed.fxml", "Заимсвованные элементы - "+ TabTypeSintez.SPEED.getName());
    }

    public void haveMassT(ActionEvent actionEvent) {
        showWindow("/assembly/importMassTopl.fxml", "Заимсвованные элементы - "+ TabTypeSintez.MASS_TOPLIVA.getName());
    }

    public void haveKDU(ActionEvent actionEvent) {
        showWindow("/assembly/importKDU.fxml", "Заимсвованные элементы - "+ TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getName());
    }

    public void haveKonstr(ActionEvent actionEvent) {
        showWindow("/assembly/importKonstr.fxml", "Заимсвованные элементы - "+ TabTypeSintez.KONSTR.getName());
    }

    public void haveBKSandAFU(ActionEvent actionEvent) {
        showWindow("/assembly/importBKSandAFU.fxml", "Заимсвованные элементы - "+ TabTypeSintez.BKS_AND_AFU.getName());
    }

    public void haveOtherKA(ActionEvent actionEvent) {
//        showWindow("/assembly/importKonstr.fxml", "Заимсвованные элементы - "+ TabTypeSintez.KONSTR.getName());
    }

    public void haveRezerv(ActionEvent actionEvent) {
        showWindow("/assembly/importRezerv.fxml", "Заимсвованные элементы - "+ TabTypeSintez.RETHERV.getName());
    }

    private void onLabelZaim (String name, Label label) {
        if (name==null){
            label.setVisible(false);
            return;
        }
        label.setVisible(true);
        label.setText("Выбран взаимсвованный элемент - "+name);
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
}
