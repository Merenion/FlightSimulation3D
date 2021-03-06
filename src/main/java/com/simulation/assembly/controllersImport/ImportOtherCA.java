package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.TabTypeSintez;
import com.simulation.assembly.ValidateValue;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.controllersImport.add.AddElement;
import com.simulation.assembly.dataCalculation.sintez.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ImportOtherCA extends ImportElement {


    public TextField mPrZA;
    public TextField vPrZA;
    public TextField wPrZA;
    public TextField jPrZA;

    private List<DataElement> listLoad = new ArrayList<>();

    private TabTypeSintez tabTypeSintez = TabTypeSintez.OTHER_ELEMENTS_CA;                                                   //

    public TabTypeSintez getTabTypeSintez() {
        return tabTypeSintez;
    }
    //

    @Override
    public void addElement(ActionEvent actionEvent) {
        try {
            int sizeList = listLoad.size();
            AddElement addElement = new AddElement();
            addElement.addElement(new DataOtherCA());                                                          //
            initialize();
            if (sizeList + 1 == listLoad.size()) {
                ControllerAssembly.showInfo("Элемент успешно добавлен.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ControllerAssembly.showError("Техническая ошибка.");
        }
    }

    @Override
    public void selectElement(ActionEvent actionEvent) {
        if (!ControllerAssembly.checkstartDataKAandShowErrorMess()) {
            return;
        }
        try {
            DataOtherCA data = (DataOtherCA) tableChoise.getSelectionModel().getSelectedItem();                       //
            DataCommonParameters dc = CalculationKA.getInstance().getDataCommonParameters();

            if (data == null) {
                ControllerAssembly.showError("Не выбрано не одного элемента.");
                return;
            }
            data.getType().getCalculation().predCalculation();

            if (data.isCalculationMoment()) {
                data.j = (float) data.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }

            CalculationKA.getInstance().setDataOtherCA(data);                                                      //                                                   //
            CalculationKA.getInstance().calculation(new Object());
            if (data.isCalculationMoment()) {
                data.j = data.m * ((dc.dKA * dc.dKA) / 16 + (dc.lKA * dc.lKA) / 12);
            }
            showParametersOfSelectElement(data);
            super.selectElement(actionEvent);

            ControllerAssembly.getInstance().onProgressOtherCa(true);
        } catch (Exception e) {
            ControllerAssembly.showError("Техническая ошибка.");
            return;
        }
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
        showParametersOfSelectElement(tabTypeSintez.getDataElement());
    }
}
