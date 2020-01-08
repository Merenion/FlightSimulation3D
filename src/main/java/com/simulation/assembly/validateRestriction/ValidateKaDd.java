package com.simulation.assembly.validateRestriction;

import com.simulation.assembly.DataSimpleCalculation;
import com.simulation.assembly.Validate;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;

public class ValidateKaDd implements ValidateRestriction{

    private TextField editKAmassaKaDd;
    private TextField editDiametrKaDd;
    private TextField editDlinaKaDd;

    public ValidateKaDd(TextField editKAmassaKaDd, TextField editDiametrKaDd, TextField editDlinaKaDd) {
        this.editKAmassaKaDd = editKAmassaKaDd;
        this.editDiametrKaDd = editDiametrKaDd;
        this.editDlinaKaDd = editDlinaKaDd;
    }

    @Override
    public boolean validate(DataSimpleCalculation objectData) {
        if (Validate.validFloat(editKAmassaKaDd.getText())){
            objectData.setMassaKa(Float.valueOf(editKAmassaKaDd.getText()));
        } else {
            editKAmassaKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editDiametrKaDd.getText())){
            objectData.setDiametr(Float.valueOf(editDiametrKaDd.getText()));
        } else {
            editDiametrKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        if (Validate.validFloat(editDlinaKaDd.getText())){
            objectData.setDlina(Float.valueOf(editDlinaKaDd.getText()));
        } else {
            editDlinaKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
        }
        return false;
    }
}
