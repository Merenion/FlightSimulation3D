package com.simulation.assembly.validateRestrictionSimple;

import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.ValidateValue;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateCaDd implements ValidateRestriction{

    private TextField editDiametrCaDd;
    private TextField editDlinaCaDd;
    private TextField editCAmassaCaDd;

    public ValidateCaDd(TextField editDiametrCaDd, TextField editDlinaCaDd, TextField editCAmassaCaDd) {
        this.editDiametrCaDd = editDiametrCaDd;
        this.editDlinaCaDd = editDlinaCaDd;
        this.editCAmassaCaDd = editCAmassaCaDd;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
        boolean result = true;
        if (ValidateValue.validFloat(editDiametrCaDd.getText())){
            objectData.setDiametr(Float.valueOf(editDiametrCaDd.getText()));
        } else {
            editDiametrCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editDlinaCaDd.getText())){
            objectData.setDlina(Float.valueOf(editDlinaCaDd.getText()));
        } else {
            editDlinaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editCAmassaCaDd.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaCaDd.getText()));
        } else {
            editCAmassaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        return result;
    }
}
