package com.simulation.assembly.controllersImport.add;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddElement {

    protected static MainData newData = new MainData();

    public TextField nameElement;
    public TextField mElement;
    public TextField wElement;
    public RadioButton choise_cilindr;
    public RadioButton choise_paralepiped;
    public RadioButton choise_value;
    public AnchorPane paneValueCilindr;
    public TextField cilindr_l;
    public TextField cilindr_d;
    public AnchorPane paneValueParaplepiped;
    public TextField paralepiped_l;
    public TextField paralepiped_s;
    public TextField paralepiped_h;
    public AnchorPane paneValueSamNoizMs;
    public TextField value_v;
    public RadioButton choise_moment_value;
    public RadioButton choise_moment_calculation;
    public AnchorPane pane_moment;
    public TextField moment;

    public void actionAddElement(ActionEvent actionEvent) {
        MainData data = new MainData();
        if (!checkNullLine()) {
            return;
        }

        try {
            data.m = ValidateValue.conversionTextToFloat(mElement.getText());
            data.w = ValidateValue.conversionTextToFloat(wElement.getText());
            if (choise_cilindr.isSelected()){
                float d = ValidateValue.conversionTextToFloat(cilindr_d.getText());
                float l = ValidateValue.conversionTextToFloat(cilindr_l.getText());
                data.v = (float) ((Math.PI * Math.pow(d, 2) / 4) * l);
            }
            if (choise_paralepiped.isSelected()){
                float s = ValidateValue.conversionTextToFloat(paralepiped_s.getText());
                float l = ValidateValue.conversionTextToFloat(paralepiped_l.getText());
                float h = ValidateValue.conversionTextToFloat(paralepiped_h.getText());
                data.v = s*l*h;
            }
            if (choise_value.isSelected()){
                data.v = ValidateValue.conversionTextToFloat(value_v.getText());
            }
            if (choise_moment_value.isSelected()){
                data.j = ValidateValue.conversionTextToFloat(moment.getText());
                data.j_calculation=false;
            }
            if (choise_moment_calculation.isSelected()){
                data.j_calculation=true;
            }
            data.nameElement = nameElement.getText();
        } catch (Exception e) {
            ControllerAssembly.showError("Не верно введеные данные.");
            return;
        }
        newData = data;
        Stage stage = (Stage) nameElement.getScene().getWindow();
        stage.close();
    }

    protected boolean checkNullLine() {
        if (nameElement.getText().equals("")) {
            ControllerAssembly.showError("Название элемента не задано!");
            return false;
        }
        if (mElement.getText().equals("")) {
            ControllerAssembly.showError("Масса не задана!");
            return false;
        }
        if (choise_cilindr.isSelected() && (cilindr_l.getText().equals("") || cilindr_d.getText().equals(""))) {
            ControllerAssembly.showError("Параметры цилиндра не заданы!");
            return false;
        }
        if (choise_paralepiped.isSelected() && (paralepiped_l.getText().equals("") || paralepiped_s.getText().equals("") || paralepiped_h.getText().equals(""))) {
            ControllerAssembly.showError("Параметры параллелепипеда не заданы!");
            return false;
        }
        if (choise_value.isSelected() && (value_v.getText().equals(""))) {
            ControllerAssembly.showError("Объем не задан!");
            return false;
        }
        if (choise_moment_value.isSelected() && moment.getText().equals("")) {
            ControllerAssembly.showError("Момент инерции не задан!");
            return false;
        }
        if (wElement.getText().equals("")) {
            ControllerAssembly.showInfo("Электропотребление не задано!\nЗначению электропотребления будет ПРИСВОЕН 0.");
        }
        return true;
    }

    @FXML
    public void initialize() {
        newData = null;
    }

    public static MainData getNewData() {
        return newData;
    }

    public static void setNewData(MainData newData) {
        AddElement.newData = newData;
    }

    public void showWindowAdd(String path, String title) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root, 416, 463);
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(ControllerAssembly.getInstance().paneRestriction.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionChoiseValue(ActionEvent actionEvent) {
        if (choise_cilindr.isSelected()){
            paneValueCilindr.setVisible(true);
            paneValueSamNoizMs.setVisible(false);
            paneValueParaplepiped.setVisible(false);
        }
        if (choise_paralepiped.isSelected()){
            paneValueCilindr.setVisible(false);
            paneValueSamNoizMs.setVisible(false);
            paneValueParaplepiped.setVisible(true);
        }
        if (choise_value.isSelected()){
            paneValueCilindr.setVisible(false);
            paneValueSamNoizMs.setVisible(true);
            paneValueParaplepiped.setVisible(false);
        }
    }

    public void actionChoiseMoment(ActionEvent actionEvent) {
        if (choise_moment_value.isSelected()){
            pane_moment.setVisible(true);
        }
        if (choise_moment_calculation.isSelected()){
            pane_moment.setVisible(false);
        }
    }

    public void addElement(DataElement d) {
        showWindowAdd("/assembly/addElement.fxml", "Добавить элемент");
        if (getNewData()!=null) {
            try {
                d.setNameElement(getNewData().nameElement);
                d.m = getNewData().m;
                d.v = getNewData().v;
                d.w = getNewData().w;
                d.j = getNewData().j;
                d.setCalculationMoment(getNewData().j_calculation);
            } catch (Exception e) {
                ControllerAssembly.showError("Не верно введеные данные.");
                return;
            }
            SaveXmlObject<DataElement> saveXmlObject = new SaveXmlObject<>();
            saveXmlObject.saveDatumDomain(d);
        }
    }

    public void addElementNotSave(DataElement d) {
        showWindowAdd("/assembly/addElement.fxml", "Добавить элемент");
        if (getNewData()!=null) {
            try {
                d.setNameElement(getNewData().nameElement);
                d.m = getNewData().m;
                d.v = getNewData().v;
                d.w = getNewData().w;
                d.j = getNewData().j;
                d.setCalculationMoment(getNewData().j_calculation);
            } catch (Exception e) {
                ControllerAssembly.showError("Не верно введеные данные.");
            }
        }
    }
}
