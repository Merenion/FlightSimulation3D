package com.simulation.assembly.controllersImport;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ImportElement {

    public Label v;
    public Label j;
    public Label m;
    public Label w;

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



    public void showWindowAdd (String path,String title){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root, 413, 391);
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(tableChoise.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void showParametersOfSelectElement (DataElement data){
        if (m!=null)
            m.setText(String.valueOf(data.m));
        if (v!=null)
            v.setText(String.valueOf(data.v));
        if (w!=null)
            w.setText(String.valueOf(data.w));
        if (j!=null)
            j.setText(String.valueOf(data.j));
    }

}
