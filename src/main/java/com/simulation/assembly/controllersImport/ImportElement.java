package com.simulation.assembly.controllersImport;

import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public abstract class ImportElement {

    public TableView tableChoise;
    public Button btSelect;
    public TextField nameElement;
    public TableColumn<DataElement,String> columnChoise;

    public abstract void initialize();

    public void selectElement(ActionEvent actionEvent) {

    }

    public void addElement(ActionEvent actionEvent) {
    }

    public void actionDeleteElement(ActionEvent actionEvent) {
        SaveXmlObject saveXmlObject = new SaveXmlObject();
        DataElement dataElement = (DataElement) tableChoise.getSelectionModel().getSelectedItem();
        if (dataElement!= null) {
            saveXmlObject.deleteDatumDomain(dataElement.getType(),dataElement.getId());
        }
        initialize();
    }


}
