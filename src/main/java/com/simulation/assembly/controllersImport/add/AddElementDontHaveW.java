package com.simulation.assembly.controllersImport.add;

import com.simulation.assembly.ControllerAssembly;
import com.simulation.assembly.SaveXmlObject;
import com.simulation.assembly.dataCalculation.sintez.DataElement;

public class AddElementDontHaveW extends AddElement{
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
        return true;
    }

    public void addElement(DataElement d) {
        showWindowAdd("/assembly/addElementDontHaveW.fxml", "Добавить элемент");
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
}
