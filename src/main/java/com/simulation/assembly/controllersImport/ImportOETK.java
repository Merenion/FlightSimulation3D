package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ImportOETK extends ImportElement {

    public Label l;
    public Label d;
    public Label m;
    public Label w;

    private List<DataElement> listLoad = new ArrayList<>();

    private TabTypeSintez tabTypeSintez = TabTypeSintez.OETK;                                               //

    @Override
    public void addElement(ActionEvent actionEvent) {
        DataOETK data = new DataOETK();                                                                     //

        try {
//            data.ouT_mOETK = ValidateValue.conversionTextToFloat(mOETK.getText());                                  //
//            data.ouT_jOETK = ValidateValue.conversionTextToFloat(jOETK.getText());
//            data.ouT_wOETK = ValidateValue.conversionTextToFloat(wOETK.getText());
//            data.ouT_vOETK = ValidateValue.conversionTextToFloat(vkSO_OETK.getText());
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
        try {
            data.getType().getCalculation().predCalculation();
        } catch (Exception e) {
            ControllerAssembly.showError("Не удалось добавить элемент.");
            return;
        }
        CalculationKA.getInstance().setDataOETK(data);                                                      //                                                   //
        CalculationKA.getInstance().calculation(new Object());
        ControllerAssembly.getInstance().showALL();
        ControllerAssembly.getInstance().startShowALL();
        Stage stage = (Stage) btSelect.getScene().getWindow();
        stage.close();
        ControllerAssembly.getInstance().onLabelZaimOetk(data.getNameElement());
        ControllerAssembly.getInstance().onProgressOetk(true);

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

    public void showAddElement(ActionEvent actionEvent) {
        showWindowAdd("/assembly/addElement.fxml", "Заимсвованные элементы - ОЕТК");
    }
}
