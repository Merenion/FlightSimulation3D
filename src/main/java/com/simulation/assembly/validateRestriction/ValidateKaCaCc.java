package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateKaCaCc implements ValidateRestriction{

    private TextField editKAmassaKaCaCc;
    private TextField editPlotnKaCaCc;
    private TextField editUdlinKaCaCc;
    private TextField editCAmassaKaCaCc;

    public ValidateKaCaCc(TextField editKAmassaKaCaCc, TextField editPlotnKaCaCc, TextField editUdlinKaCaCc, TextField editCAmassaKaCaCc) {
        this.editKAmassaKaCaCc = editKAmassaKaCaCc;
        this.editPlotnKaCaCc = editPlotnKaCaCc;
        this.editUdlinKaCaCc = editUdlinKaCaCc;
        this.editCAmassaKaCaCc = editCAmassaKaCaCc;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
        if (Validate.validFloat(editKAmassaKaCaCc.getText())){
            objectData.setMassaKa(Float.valueOf(editKAmassaKaCaCc.getText()));
        } else {
            editKAmassaKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editPlotnKaCaCc.getText())){
            objectData.setPlotnost(Float.valueOf(editPlotnKaCaCc.getText()));
        } else {
            editPlotnKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editUdlinKaCaCc.getText())){
            objectData.setUdlinenie(Float.valueOf(editUdlinKaCaCc.getText()));
        } else {
            editUdlinKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editCAmassaKaCaCc.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaKaCaCc.getText()));
        } else {
            editCAmassaKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
