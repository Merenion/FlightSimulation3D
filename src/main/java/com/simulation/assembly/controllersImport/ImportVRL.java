package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataVRL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ImportVRL extends ImportElement {

    public TextField mVRL;
    public TextField vVRL;
    public TextField wVRL;
    public TextField jVRL;

    private List<DataElement> listLoad = new ArrayList<>();

    private TabTypeSintez tabTypeSintez = TabTypeSintez.VRL;                                               //

    @Override
    public void addElement(ActionEvent actionEvent) {
        DataVRL data = new DataVRL();                                                                     //

        try {
            data.m = ValidateValue.conversionTextToFloat(mVRL.getText());                                  //
            data.v = ValidateValue.conversionTextToFloat(vVRL.getText());
            data.w = ValidateValue.conversionTextToFloat(wVRL.getText());
            data.j = ValidateValue.conversionTextToFloat(jVRL.getText());
        } catch (Exception e) {
            ControllerAssembly.showError("Не верно введеные данные.");
            return;
        }

        data.setNameElement(nameElement.getText());
        if (listLoad.contains(data)) {
            ControllerAssembly.showError("Элемент с таким названием уже имеется!\nВыберите другое название либо\nудалите имеющийся элемент.");
            return;
        }
        if (data.getNameElement().equals("")) {
            ControllerAssembly.showError("Название элемента не задано.");
            return;
        }
        SaveXmlObject<DataElement> saveXmlObject = new SaveXmlObject<>();
        saveXmlObject.saveDatumDomain(data);
        initialize();
    }

    @Override
    public void selectElement(ActionEvent actionEvent) {
        DataVRL data = (DataVRL) tableChoise.getSelectionModel().getSelectedItem();                       //
        if (data==null){
            ControllerAssembly.showError("Не выбрано не одного элемента.");
            return;
        }
        try {
            data.getType().getCalculation().predCalculation();
        } catch (Exception e) {
            ControllerAssembly.showError("Не удалось добавить элемент.");
            return;
        }
        CalculationKA.getInstance().setDataVRL(data);                                                      //                                                   //
        CalculationKA.getInstance().calculation(new Object());
        ControllerAssembly.getInstance().showALL();
        ControllerAssembly.getInstance().startShowALL();
        Stage stage = (Stage) btSelect.getScene().getWindow();
        stage.close();
        ControllerAssembly.getInstance().onLabelZaimVrl(data.getNameElement());
        ControllerAssembly.getInstance().onProgressVrl(true);
    }

    @FXML
    public void initialize() {
        columnChoise.setCellValueFactory(new PropertyValueFactory<DataElement, String>("nameElement"));
        ObservableList<DataElement> list = FXCollections.observableArrayList();
        SaveXmlObject<DataElement> saveXmlObject = new SaveXmlObject<>();
        listLoad.clear();
        listLoad = saveXmlObject.readDatumDomain(tabTypeSintez);
        if (listLoad != null) {
            list.clear();
            list.addAll(listLoad);
        }
        tableChoise.setItems(list);
    }
}
