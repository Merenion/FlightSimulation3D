package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public class ImportOETK extends ImportElement {

    public TextField mOETK;
    public TextField jOETK;
    public TextField wOETK;
    public TextField vkSO_OETK;
    public TextField lOETK;
    public TextField dOETK;
    public TextField vOETK;

    private List<DataElement> listLoad = new ArrayList<>();

    private TabTypeSintez tabTypeSintez = TabTypeSintez.OETK;                                               //

    @Override
    public void addElement(ActionEvent actionEvent) {
        DataOETK data = new DataOETK();                                                                     //

        try {
            data.mOETK = ValidateValue.conversionTextToFloat(mOETK.getText());                                  //
            data.jOETK = ValidateValue.conversionTextToFloat(jOETK.getText());
            data.wOETK = ValidateValue.conversionTextToFloat(wOETK.getText());
            data.vkSO_OETK = ValidateValue.conversionTextToFloat(vkSO_OETK.getText());
            data.lOETK = ValidateValue.conversionTextToFloat(lOETK.getText());
            data.dOETK = ValidateValue.conversionTextToFloat(dOETK.getText());
            data.vOETK = ValidateValue.conversionTextToFloat(vOETK.getText());
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
        DataOETK data = (DataOETK) tableChoise.getSelectionModel().getSelectedItem();                       //
        if (data==null){
            ControllerAssembly.showError("Не выбрано не одного элемента.");
            return;
        }
        CalculationKA.getInstance().setDataOETK(data);                                                      //
        ControllerAssembly.getInstance().showALL();
        ControllerAssembly.getInstance().startShowALL();
        Stage stage = (Stage) btSelect.getScene().getWindow();
        stage.close();
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
