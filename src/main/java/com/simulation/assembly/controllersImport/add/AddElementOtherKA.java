package com.simulation.assembly.controllersImport.add;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOtherKA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddElementOtherKA extends AddElement{
    public RadioButton choise_MassVvod;
    public RadioButton choise_MassProcent;
    public AnchorPane paneMassVvod;
    public AnchorPane paneMassProcent;
    public TextField mElementProcent;

    public void actionChoiseTypeMass(ActionEvent actionEvent) {
        if (choise_MassVvod.isSelected()){
            paneMassVvod.setVisible(true);
            paneMassProcent.setVisible(false);
        } else {
            paneMassVvod.setVisible(false);
            paneMassProcent.setVisible(true);
        }
    }

    protected boolean checkNullLine() {
        if (nameElement.getText().equals("")) {
            ControllerAssembly.showError("Название элемента не задано!");
            return false;
        }
        if (mElement.getText().equals("") && choise_MassVvod.isSelected()) {
            ControllerAssembly.showError("Масса не задана!");
            return false;
        }
        if (mElementProcent.getText().equals("") && choise_MassProcent.isSelected()) {
            ControllerAssembly.showError("Масса в процентах не задана!");
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

    public void actionAddElement(ActionEvent actionEvent) {
        MainData data = new MainData();
        if (!checkNullLine()) {
            return;
        }

        try {
            if (choise_MassVvod.isSelected()){
                data.m = ValidateValue.conversionTextToFloat(mElement.getText());
            }
            if (choise_MassProcent.isSelected()){
                data.mProc = ValidateValue.conversionTextToFloat(mElementProcent.getText());
                if (data.mProc == 0) throw new Exception();
            }
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
            for (DataOtherKA dataOtherKA:((DataOtherKA)TabTypeSintez.OTHER_ELEMENT_KA.getDataElement()).getOthers()) {
                if (dataOtherKA.getNameElement().equals(data.nameElement)){
                    ControllerAssembly.showError("Элемент с таким названием уже добавлен");
                    return;
                }
            }
        } catch (Exception e) {
            ControllerAssembly.showError("Не верно введеные данные.");
            return;
        }
        newData = data;
        Stage stage = (Stage) nameElement.getScene().getWindow();
        stage.close();
    }

    public void addElement(DataElement d) {
        showWindowAdd("/assembly/addElementOtherKA.fxml", "Добавить элемент");
        if (getNewData()!=null) {
            try {
                d.setNameElement(getNewData().nameElement);
                d.m = getNewData().m;
                if (d instanceof DataOtherKA && getNewData().mProc!=0){
                    ((DataOtherKA)d).omPrKA = getNewData().mProc;
                    ((DataOtherKA)d).setMassProc(true);
                }
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
        showWindowAdd("/assembly/addElementOtherKA.fxml", "Добавить элемент");
        if (getNewData()!=null) {
            try {
                d.setNameElement(getNewData().nameElement);
                d.m = getNewData().m;
                if (d instanceof DataOtherKA && getNewData().mProc != 0) {
                    ((DataOtherKA) d).omPrKA = getNewData().mProc;
                    ((DataOtherKA) d).setMassProc(true);
                }
                d.v = getNewData().v;
                d.w = getNewData().w;
                d.j = getNewData().j;
                d.setCalculationMoment(getNewData().j_calculation);
            } catch (Exception e) {
                ControllerAssembly.showError("Не верно введеные данные.");
                return;
            }
        }
    }

    public void showWindowAdd(String path, String title) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root, 416, 493);
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
}
