package com.simulation.assembly;

import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyEvent;

public class ValidateLable {

    public static void actionEditValidateUnacceptableChar(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        if (!keyEvent.getText().matches("[\\d|.|,]+") && !textField.getText().equals("")
                && !textField.getText().equals(";")
                && !textField.getText().equals("/")
                && !textField.getText().equals("+")
                && !textField.getText().equals("-")
                && !textField.getText().equals("=")
                && !textField.getText().equals(">")
                && !textField.getText().equals("<")
                && !textField.getText().equals("?")
                && textField.getText().contains(keyEvent.getText()) && !keyEvent.getText().equals("")) {
            textField.setText(textField.getText().replace(keyEvent.getText(), ""));
        }
    }

    public static void actionEditPointCharValidate(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        try {
            ValidateValue.conversionTextToFloat(textField.getText());
            textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        } catch (Exception e) {
            if (!(textField.getText()).equals(""))
                textField.setEffect(new ColorAdjust(0, 0.2, 0, 0));
            else
                textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        }
    }

    public static void actionEditNotZeroValidate(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        try {
            float value = ValidateValue.conversionTextToFloat(textField.getText());
            if (value == 0){
                throw new Exception();
            }
            textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        } catch (Exception e) {
            if (!(textField.getText()).equals(""))
                textField.setEffect(new ColorAdjust(0, 0.2, 0, 0));
            else
                textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        }
    }
}
