package com.simulation.assembly.controllersImport.add;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.dataCalculation.sintez.DataAcumBetSEP;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddElementAcum extends AddElement{
    public TextField nAB;

    private static MainDataAcum newDataAcum = new MainDataAcum();

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
        if (nAB.getText().equals("")) {
            ControllerAssembly.showError("Количество АБ не задано!");
            return false;
        }
        return true;
    }

    public static MainDataAcum getNewDataAcum() {
        return newDataAcum;
    }

    public void addElement(DataElement d) {
        showWindowAdd("/assembly/addElementAcum.fxml", "Добавить элемент");
        if (getNewData()!=null) {
            try {
                d.setNameElement(getNewDataAcum().nameElement);
                d.m = getNewDataAcum().m;
                d.v = getNewDataAcum().v;
                d.w = getNewDataAcum().w;
                d.j = getNewDataAcum().j;
                d.setCalculationMoment(getNewData().j_calculation);
                if (d instanceof DataAcumBetSEP){
                    ((DataAcumBetSEP) d ).nAB = getNewDataAcum().nAB;
                }
            } catch (Exception e) {
                ControllerAssembly.showError("Не верно введеные данные.");
                return;
            }
            SaveXmlObject<DataElement> saveXmlObject = new SaveXmlObject<>();
            saveXmlObject.saveDatumDomain(d);
        }
    }

    public void actionAddElement(ActionEvent actionEvent) {
        MainDataAcum data = new MainDataAcum();
        if (!checkNullLine()) {
            return;
        }

        try {
            data.m = ValidateValue.conversionTextToFloat(mElement.getText());
            data.w = ValidateValue.conversionTextToFloat(wElement.getText());
            data.nAB = ValidateValue.conversionTextToFloat(nAB.getText());
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
        newDataAcum = data;
        Stage stage = (Stage) nameElement.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void initialize() {
        newDataAcum = null;
    }

}
