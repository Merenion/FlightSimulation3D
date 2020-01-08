package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateCaCc implements ValidateRestriction {

    private TextField editCAmassaCaCc;
    private TextField editPlotnCaCc;
    private TextField editUdlinCaCc;

    public ValidateCaCc(TextField editCAmassaCaCc, TextField editPlotnCaCc, TextField editUdlinCaCc) {
        this.editCAmassaCaCc = editCAmassaCaCc;
        this.editPlotnCaCc = editPlotnCaCc;
        this.editUdlinCaCc = editUdlinCaCc;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
        if (Validate.validFloat(editCAmassaCaCc.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaCaCc.getText()));
        } else {
            editCAmassaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editPlotnCaCc.getText())){
            objectData.setPlotnost(Float.valueOf(editPlotnCaCc.getText()));
        } else {
            editPlotnCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editUdlinCaCc.getText())){
            objectData.setUdlinenie(Float.valueOf(editUdlinCaCc.getText()));
        } else {
            editUdlinCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
