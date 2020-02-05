package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ControllerSvodka {
    public TextArea svodkaArea;

    @FXML
    private void initialize() {
        try {
            svodkaArea.setText(CalculationKA.getInstance().toString());
        } catch (Exception e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }
}
