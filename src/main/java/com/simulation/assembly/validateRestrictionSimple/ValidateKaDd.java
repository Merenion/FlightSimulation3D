package com.simulation.assembly.validateRestrictionSimple;

import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.ValidateValue;
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
        boolean result = true;
        if (ValidateValue.validFloat(editKAmassaKaDd.getText())){
            objectData.setMassaKa(Float.valueOf(editKAmassaKaDd.getText()));
        } else {
            editKAmassaKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editDiametrKaDd.getText())){
            objectData.setDiametr(Float.valueOf(editDiametrKaDd.getText()));
        } else {
            editDiametrKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        if (ValidateValue.validFloat(editDlinaKaDd.getText())){
            objectData.setDlina(Float.valueOf(editDlinaKaDd.getText()));
        } else {
            editDlinaKaDd.setEffect(new ColorAdjust(0,0.2,0,0));
            result = false;
        }
        return result;
    }
}
