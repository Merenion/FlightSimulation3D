package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateKaCaDd implements ValidateRestriction{

    private TextField editKAMassaKaCaDd;
    private TextField editDiametrKaCaDd;
    private TextField editDlinaKaCaDd;
    private TextField editCAMassaKaCaDd;

    public ValidateKaCaDd(TextField editKAMassaKaCaDd, TextField editDiametrKaCaDd, TextField editDlinaKaCaDd, TextField editCAMassaKaCaDd) {
        this.editKAMassaKaCaDd = editKAMassaKaCaDd;
        this.editDiametrKaCaDd = editDiametrKaCaDd;
        this.editDlinaKaCaDd = editDlinaKaCaDd;
        this.editCAMassaKaCaDd = editCAMassaKaCaDd;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
        if (Validate.validFloat(editKAMassaKaCaDd.getText())){
            objectData.setMassaKa(Float.valueOf(editKAMassaKaCaDd.getText()));
        } else {
            editKAMassaKaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editDiametrKaCaDd.getText())){
            objectData.setDiametr(Float.valueOf(editDiametrKaCaDd.getText()));
        } else {
            editDiametrKaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editDlinaKaCaDd.getText())){
            objectData.setDlina(Float.valueOf(editDlinaKaCaDd.getText()));
        } else {
            editDlinaKaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editCAMassaKaCaDd.getText())){
            objectData.setMassaCa(Float.valueOf(editCAMassaKaCaDd.getText()));
        } else {
            editCAMassaKaCaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
