package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
import javafx.fxml.FXML;
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
        if (Validate.validFloat(editDiametrCaDd.getText())){
            objectData.setDiametr(Float.valueOf(editDiametrCaDd.getText()));
        } else {
            editDiametrCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editDlinaCaDd.getText())){
            objectData.setDlina(Float.valueOf(editDlinaCaDd.getText()));
        } else {
            editDlinaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editCAmassaCaDd.getText())){
            objectData.setMassaCa(Float.valueOf(editCAmassaCaDd.getText()));
        } else {
            editCAmassaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
