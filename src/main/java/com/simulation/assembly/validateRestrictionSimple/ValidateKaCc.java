package com.simulation.assembly.validateRestrictionSimple;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.ValidateValue;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateKaCc implements ValidateRestriction{

    private TextField editKAmassaKaCc;
    private TextField editPlotnKaCc;
    private TextField editUdlinKaCc;

    public ValidateKaCc(TextField editKAmassaKaCc, TextField editPlotnKaCc, TextField editUdlinKaCc) {
        this.editKAmassaKaCc = editKAmassaKaCc;
        this.editPlotnKaCc = editPlotnKaCc;
        this.editUdlinKaCc = editUdlinKaCc;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
            boolean result = false;
        try {
            if (ValidateValue.validFloat(editKAmassaKaCc.getText())) {
                objectData.setMassaKa(Float.valueOf(editKAmassaKaCc.getText()));
            } else {
                editKAmassaKaCc.setEffect(new ColorAdjust(0, 0.2, 0, 0));
                result = false;
            }
            if (ValidateValue.validFloat(editPlotnKaCc.getText())) {
                objectData.setPlotnost(Float.valueOf(editPlotnKaCc.getText()));
            } else {
                editPlotnKaCc.setEffect(new ColorAdjust(0, 0.2, 0, 0));
                result = false;
            }
            if (ValidateValue.validFloat(editUdlinKaCc.getText())) {
                objectData.setUdlinenie(Float.valueOf(editUdlinKaCc.getText()));
            } else {
                editUdlinKaCc.setEffect(new ColorAdjust(0, 0.2, 0, 0));
                result = false;
            }
        } catch (Exception e) {
            ControllerAssembly.showError("Проверьте исходные данные!");
        }

        return result;
    }
}
