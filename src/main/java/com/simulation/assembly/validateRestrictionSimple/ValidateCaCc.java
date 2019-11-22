package com.simulation.assembly.validateRestrictionSimple;

import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.ValidateValue;
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
        boolean result = true;
        if (ValidateValue.validFloat(editCAmassaCaCc.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaCaCc.getText()));
        } else {
            editCAmassaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editPlotnCaCc.getText())){
            objectData.setPlotnost(Float.valueOf(editPlotnCaCc.getText()));
        } else {
            editPlotnCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editUdlinCaCc.getText())){
            objectData.setUdlinenie(Float.valueOf(editUdlinCaCc.getText()));
        } else {
            editUdlinCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        return result;
    }
}
