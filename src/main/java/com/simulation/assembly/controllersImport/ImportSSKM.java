package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataSSKM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ImportSSKM extends ImportElement {

    public TextField mSSKM;
    public TextField vSSKM;
    public TextField wSSKM;
    public TextField jSSKM;
    public Label rez_mSSKM;
    public Label rez_vSSKM;
    public Label rez_wSSKM;
    public Label rez_jSSKM;

    private List<DataElement> listLoad = new ArrayList<>();

    private TabTypeSintez tabTypeSintez = TabTypeSintez.SUD_SSKM;                                               //

    @Override
    public void addElement(ActionEvent actionEvent) {
        DataSSKM data = new DataSSKM();                                                                     //
        DataCommonParameters dc = new DataCommonParameters();                                                                     //

        try {
            data.m = ValidateValue.conversionTextToFloat(mSSKM.getText());                                  //
            data.v = ValidateValue.conversionTextToFloat(vSSKM.getText());
            data.w = ValidateValue.conversionTextToFloat(wSSKM.getText());
            data.j = ValidateValue.conversionTextToFloat(jSSKM.getText());
//            data.jSSKM = data.mSSKM * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
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
        DataSSKM data = (DataSSKM) tableChoise.getSelectionModel().getSelectedItem();                       //
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
        CalculationKA.getInstance().setDataSSKM(data);                                                      //                                                   //
        CalculationKA.getInstance().calculation(new Object());
        showRez(data);
//        ControllerAssembly.getInstance().showALL();
//        ControllerAssembly.getInstance().startShowALL();
//        Stage stage = (Stage) btSelect.getScene().getWindow();
//        stage.close();
//        ControllerAssembly.getInstance().onLabelZaimSskm(data.getNameElement());
    }

    private void showRez (DataElement dataElement) {
        DataSSKM dataSSKM = (DataSSKM) dataElement;
        rez_jSSKM.setText(String.valueOf(dataSSKM.j));
        rez_mSSKM.setText(String.valueOf(dataSSKM.m));
        rez_vSSKM.setText(String.valueOf(dataSSKM.v));
        rez_wSSKM.setText(String.valueOf(dataSSKM.w));
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
