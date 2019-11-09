package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
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
        if (Validate.validFloat(editKAmassaKaCc.getText())){
            objectData.setMassaKa(Float.valueOf(editKAmassaKaCc.getText()));
        } else {
            editKAmassaKaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editPlotnKaCc.getText())){
            objectData.setPlotnost(Float.valueOf(editPlotnKaCc.getText()));
        } else {
            editPlotnKaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editUdlinKaCc.getText())){
            objectData.setUdlinenie(Float.valueOf(editUdlinKaCc.getText()));
        } else {
            editUdlinKaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
