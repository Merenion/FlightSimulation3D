package com.simulation.assembly;

import com.simulation.assembly.validateRestriction.*;
import com.simulation.earth.ColorSmart;
import com.simulation.earth.manageSatellite.ManageSatellite;
import com.simulation.earth.manageSatellite.ManagerSatelliteEarth;
import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import com.simulation.earth.manageSpace.Space;
import com.simulation.earth.spaceObjects.Satellite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ControllerAssembly {

    /**
     * выбор ограничений
     */
    @FXML
    public CheckBox checkKa;
    @FXML
    public CheckBox checkCa;
    @FXML
    public CheckBox checkDd;

    /**
     * панель ограничения по массе КА , плотность и удлинение
     */
    @FXML
    public Pane kaCc;
    @FXML
    public TextField editKAmassaKaCc;
    @FXML
    public TextField editPlotnKaCc;
    @FXML
    public TextField editUdlinKaCc;

    /**
     * панель ограничения по массе ЦА , плотность и удлинение
     */
    @FXML
    public Pane caCc;
    @FXML
    public TextField editCAmassaCaCc;
    @FXML
    public TextField editPlotnCaCc;
    @FXML
    public TextField editUdlinCaCc;

    /**
     * панель ограничения по массе КА и ЦА , плотность и удлинение
     */
    @FXML
    public Pane kaCaCc;
    @FXML
    public TextField editKAmassaKaCaCc;
    @FXML
    public TextField editPlotnKaCaCc;
    @FXML
    public TextField editUdlinKaCaCc;
    @FXML
    public TextField editCAmassaKaCaCc;

    /**
     * панель ограничения по массе КА и ЦА , диаметр и длина
     */
    @FXML
    public Pane kaCaDd;
    @FXML
    public TextField editKAMassaKaCaDd;
    @FXML
    public TextField editDiametrKaCaDd;
    @FXML
    public TextField editDlinaKaCaDd;
    @FXML
    public TextField editCAMassaKaCaDd;

    /**
     * панель ограничения по массе КА , диаметр и длина
     */
    @FXML
    public Pane kaDd;
    @FXML
    public TextField editKAmassaKaDd;
    @FXML
    public TextField editDiametrKaDd;
    @FXML
    public TextField editDlinaKaDd;

    /**
     * панель ограничения по массе ЦА , диаметр и длина
     */
    @FXML
    public Pane caDd;
    @FXML
    public TextField editDiametrCaDd;
    @FXML
    public TextField editDlinaCaDd;
    @FXML
    public TextField editCAmassaCaDd;

    /**
     * Суммы масс
     */
    @FXML
    public TextField editProcCA;
    @FXML
    public TextField editProcBKU;
    @FXML
    public TextField editProcSOTR;
    @FXML
    public TextField editProcSEP;
    @FXML
    public TextField editProcKDU;
    @FXML
    public TextField editProcTOPLIVO;
    @FXML
    public TextField editProcKONSTR;
    @FXML
    public TextField editProcAFU;
    @FXML
    public TextField editProcOTHERMAS;
    @FXML
    public TextField editProcREZERV;
    @FXML
    public Label labelSummaBS;
    @FXML
    public Label labelSummaValueBS;

    private ValidateRestriction validateRestriction;
    private DataSimpleCalculation dataSimpleCalculation = new DataSimpleCalculation();

    /**
     * Метод инициализации окна.
     */
    @FXML
    private void initialize() {
        calculationSumBs();
    }

    public void actionChoiseRestriction(ActionEvent actionEvent) {
        //TODO добавить реализацию интерфейса для выбора
        hidePanelsRestrictions();
        validateRestriction = null;
        //1
        if (checkKa.isSelected() && !checkDd.isSelected() && !checkCa.isSelected()) {
            kaCc.setVisible(true);
            validateRestriction = new ValidateKaCc(editKAmassaKaCc, editPlotnKaCc, editUdlinKaCc);
        } else
            //2
            if (!checkKa.isSelected() && !checkDd.isSelected() && checkCa.isSelected()) {
                caCc.setVisible(true);
                validateRestriction = new ValidateCaCc(editCAmassaCaCc, editPlotnCaCc, editUdlinCaCc);
            } else
                //3
                if (checkKa.isSelected() && !checkDd.isSelected() && checkCa.isSelected()) {
                    kaCaCc.setVisible(true);
                    validateRestriction = new ValidateKaCaCc(editKAmassaKaCaCc, editPlotnKaCaCc, editUdlinKaCaCc, editCAmassaKaCaCc);
                } else
                    //4
                    if (checkKa.isSelected() && checkDd.isSelected() && checkCa.isSelected()) {
                        kaCaDd.setVisible(true);
                        validateRestriction = new ValidateKaCaDd(editKAMassaKaCaDd, editDiametrKaCaDd, editDlinaKaCaDd, editCAMassaKaCaDd);
                    } else
                        //5
                        if (checkKa.isSelected() && checkDd.isSelected() && !checkCa.isSelected()) {
                            kaDd.setVisible(true);
                            validateRestriction = new ValidateKaDd(editKAmassaKaDd, editDiametrKaDd, editDlinaKaDd);
                        } else
                            //6
                            if (!checkKa.isSelected() && checkDd.isSelected() && checkCa.isSelected()) {
                                caDd.setVisible(true);
                                validateRestriction = new ValidateCaDd(editDiametrCaDd, editDlinaCaDd, editCAmassaCaDd);
                            }
    }

    /**
     * скрыть все панели ограничений
     *
     * @return
     */
    private List<Pane> hidePanelsRestrictions() {
        validateRestriction = null;
        for (Pane pane : getPanelsRestriction()) {
            pane.setVisible(false);
        }
        return getPanelsRestriction();
    }

    /**
     * все панели ограничений
     *
     * @return
     */
    private List<Pane> getPanelsRestriction() {
        List<Pane> panels = new ArrayList<>();
        panels.add(kaCc);
        panels.add(caCc);
        panels.add(kaCaCc);
        panels.add(kaCaDd);
        panels.add(kaDd);
        panels.add(caDd);
        return panels;
    }

    private boolean validateEditRestriction() {
        if (validateRestriction != null && dataSimpleCalculation != null)
            return validateRestriction.validate(dataSimpleCalculation);
        return false;
    }

    public void actionBtTest(ActionEvent actionEvent) {
        if (validateEditRestriction())
            System.out.println("OK");
        else
            System.out.println("NO");
    }

    public void actionEditPointCharValidate(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        try {
            Validate.conversionTextToFloat(textField.getText());
            textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        } catch (Exception e) {
            if (!(textField.getText()).equals(""))
                textField.setEffect(new ColorAdjust(0, 0.2, 0, 0));
            else
                textField.setEffect(new ColorAdjust(0, 0, 0, 0));
        }
    }

    public void actionEditPointSumm(KeyEvent keyEvent) {
        actionEditValidateUnacceptableChar(keyEvent);
        actionEditPointCharValidate(keyEvent);
        calculationSumBs();
    }

    private void calculationSumBs() {
        try {
            Float sum = 0f;
            sum = sum + Validate.conversionTextToFloat(editProcCA.getText());
            sum = sum + Validate.conversionTextToFloat(editProcBKU.getText());
            sum = sum + Validate.conversionTextToFloat(editProcSOTR.getText());
            sum = sum + Validate.conversionTextToFloat(editProcSEP.getText());
            sum = sum + Validate.conversionTextToFloat(editProcKDU.getText());
            sum = sum + Validate.conversionTextToFloat(editProcTOPLIVO.getText());
            sum = sum + Validate.conversionTextToFloat(editProcKONSTR.getText());
            sum = sum + Validate.conversionTextToFloat(editProcAFU.getText());
            sum = sum + Validate.conversionTextToFloat(editProcOTHERMAS.getText());
            sum = sum + Validate.conversionTextToFloat(editProcREZERV.getText());
            if (sum > 99.8 && sum < 100.2) {
                labelSummaBS.setTextFill(Color.GREEN);
                labelSummaValueBS.setTextFill(Color.GREEN);
                labelSummaValueBS.setText("100");
            } else {
                labelSummaBS.setTextFill(Color.RED);
                labelSummaValueBS.setTextFill(Color.RED);
                labelSummaValueBS.setText(sum+"");
            }
        } catch (Exception e) {
            labelSummaBS.setTextFill(Color.RED);
            labelSummaValueBS.setTextFill(Color.RED);
            labelSummaValueBS.setText("Error");
        }
    }

    public void actionEditValidateUnacceptableChar(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        System.out.println(keyEvent.getText());
        if (!keyEvent.getText().matches("[\\d|.|,]+")&& !textField.getText().equals("")
                && !textField.getText().equals(";")
                && !textField.getText().equals("/")
                && !textField.getText().equals("+")
                && !textField.getText().equals("-")
                && !textField.getText().equals("=")
                && !textField.getText().equals(">")
                && !textField.getText().equals("<")
                && !textField.getText().equals("?")
                && textField.getText().contains(keyEvent.getText()) && !keyEvent.getText().equals("")){
            textField.setText(textField.getText().replace(keyEvent.getText(),""));
        }
    }

    public void actionEditMainValidate(KeyEvent keyEvent) {
        actionEditValidateUnacceptableChar(keyEvent);
        actionEditPointCharValidate(keyEvent);
    }
}
