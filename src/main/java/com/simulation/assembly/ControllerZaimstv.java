package com.simulation.assembly;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    }

    public void haveSGK(ActionEvent actionEvent) {
    }

    public void haveSSKM(ActionEvent actionEvent) {
    }

    public void haveSTKRP(ActionEvent actionEvent) {
        showWindow("/assembly/importSTKRP.fxml", "Заимсвованные элементы - "+ TabTypeSintez.STKRP.getName());

    }

    public void haveBAKES(ActionEvent actionEvent) {
    }

    public void haveBETS(ActionEvent actionEvent) {
    }

    public void haveBVS(ActionEvent actionEvent) {
    }

    public void haveOtherBKU(ActionEvent actionEvent) {
    }

    public void havePasivSOTR(ActionEvent actionEvent) {
    }

    public void haveActivSOTR(ActionEvent actionEvent) {
    }

    public void haveElectParamSEP(ActionEvent actionEvent) {
    }

    public void haveAccumBet(ActionEvent actionEvent) {
    }

    public void haveKAS(ActionEvent actionEvent) {
    }

    public void haveSun(ActionEvent actionEvent) {
    }

    public void haveSpeed(ActionEvent actionEvent) {
    }

    public void haveMassT(ActionEvent actionEvent) {
    }

    public void haveKDU(ActionEvent actionEvent) {
    }

    public void haveKonstr(ActionEvent actionEvent) {
    }

    public void haveBKSandAFU(ActionEvent actionEvent) {
    }

    public void haveOtherKA(ActionEvent actionEvent) {
    }

    public void haveRezerv(ActionEvent actionEvent) {
    }
}
