package com.simulation.assembly.validateRestrictionSimple;

import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.ValidateValue;
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
        boolean result = true;
        if (ValidateValue.validFloat(editKAmassaKaCaCc.getText())){
            objectData.setMassaKa(Float.valueOf(editKAmassaKaCaCc.getText()));
        } else {
            editKAmassaKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editPlotnKaCaCc.getText())){
            objectData.setPlotnost(Float.valueOf(editPlotnKaCaCc.getText()));
        } else {
            editPlotnKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editUdlinKaCaCc.getText())){
            objectData.setUdlinenie(Float.valueOf(editUdlinKaCaCc.getText()));
        } else {
            editUdlinKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editCAmassaKaCaCc.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaKaCaCc.getText()));
        } else {
            editCAmassaKaCaCc.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        return result;
    }
}
