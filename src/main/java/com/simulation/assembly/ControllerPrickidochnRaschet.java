package com.simulation.assembly;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerPrickidochnRaschet extends ControllerAssembly {

    @Override
    public void actionCloseProject(ActionEvent actionEvent) {
        try {
            Stage stageThis = (Stage) editKAmassaKaCc.getScene().getWindow();
            com.simulation.startMenu.Main main = new com.simulation.startMenu.Main();
            main.start(new Stage());
            stageThis.close();
        } catch (IOException e) {
            e.printStackTrace();
            showInfo("Возникла техническая ошибка");
        }
    }

}
