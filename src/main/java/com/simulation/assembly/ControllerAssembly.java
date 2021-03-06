package com.simulation.assembly;

import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.calculation.ca.*;
import com.simulation.assembly.calculation.simple.*;
import com.simulation.assembly.controllersImport.add.AddElement;
import com.simulation.assembly.controllersImport.add.AddElementOtherKA;
import com.simulation.assembly.dataCalculation.sintez.*;
import com.simulation.assembly.validateRestrictionSimple.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ControllerAssembly extends ControllerImport {

    @FXML
    public MenuItem btSaveProject;


    private static List<String> messConsoleSimple = new ArrayList<>();
    private static List<String> messConsoleSintez = new ArrayList<>();



    private File openFile;
    private Desktop desktop = Desktop.getDesktop();

    private static ControllerAssembly controllerAssembly;

    public static ControllerAssembly getInstance() {
        return controllerAssembly;
    }

    /**
     * Метод инициализации окна.
     */
    @FXML
    private void initialize() {
        validateRestriction = new ValidateKaCc(editKAmassaKaCc, editPlotnKaCc, editUdlinKaCc);
        calculationSimp = new CalculationKaCc();
        calculationSimpSintez = new CalculationSimpleSintez();
        calculationOETK = new CalculationOETK();
        calculationSGK = new CalculationSGK();
        calculationSPPE = new CalculationSPPE();
        calculationVRL = new CalculationVRL();
        calculationOtherCA = new CalculationOtherCA();
        calculationCA = new CalculationCa();
        calculationSSKM = new CalculationSSKM();
        calculationSTKRP = new CalculationSTKRP();
        calculationBAKES = new CalculationBAKES();
        calculationBETS = new CalculationBETS();
        calculationBVS = new CalculationBVS();
        calculationOtherBKU = new CalculationOtherBKU();
        calculationBKU = new CalculationBKU();
        calculationPasivSOTR = new CalculationPasivSOTR();
        calculationActivSOTR = new CalculationActivSOTR();
        calculationSOTR = new CalculationSOTR();
        calculationElectrTehnSEP = new CalculationElectHaraktSEP();
        calculationAcumBet = new CalculationAcumBetSEP();
        calculationKAS = new CalculationKAS();
        calculationSUNbet = new CalculationSumBetSEP();
        calculationSpeed = new CalculationSpeed();
        calculationMTop = new CalculationMassTopl();
        calculationKDU = new CalculationKDU();
        calculationKonstrKA = new CalculationKonstrKA();
        calculationBKSandAFU = new CalkulationBKS();
        calculationOtherKA = new CalculationOtherKA();
        calculationRezerv = new CalculationRezervKA();
        calculationSSD = new CalculationSSD();
        calculationIPMV = new CalculationIPMV();
        calculationBOKZ = new CalculationBOKZ();
        calculationDO = new CalculationDO();
        calculationDUS = new CalculationDUS();
        calculationBKS = new CalkulationBKS();
        calculationAFU = new CalkulationAFU();
        CalculationKA.getInstance().init();

        controllerAssembly = this;

//        calculationSumBs();

//        initotherKA();
    }

    public static void addMessInConsoleSimple(MessegeType messegeType, String mes) {
        messConsoleSimple.add(messegeType + mes);
    }

    public static void addMessInConsoleSintez(MessegeType messegeType, String mes) {
        messConsoleSintez.add(messegeType + mes);
    }

    public static void addMessInConsoleSintez(MessegeType messegeType, String mes, TabTypeSintez tabType) {
        messConsoleSintez.add(messegeType + mes + "[" + tabType.getName() + "]");
    }

    public void actionChoiseRestriction(ActionEvent actionEvent) {
        //TODO добавить реализацию интерфейса для выбора
        hidePanelsRestrictions();
        validateRestriction = null;
        //1
        if (checkKa.isSelected() && !checkDd.isSelected() && !checkCa.isSelected()) {
            kaCc.setVisible(true);
            validateRestriction = new ValidateKaCc(editKAmassaKaCc, editPlotnKaCc, editUdlinKaCc);
            calculationSimp = new CalculationKaCc();
        } else
            //2
            if (!checkKa.isSelected() && !checkDd.isSelected() && checkCa.isSelected()) {
                caCc.setVisible(true);
                validateRestriction = new ValidateCaCc(editCAmassaCaCc, editPlotnCaCc, editUdlinCaCc);
                calculationSimp = new CalculationCaCc();
            } else
                //3
                if (checkKa.isSelected() && !checkDd.isSelected() && checkCa.isSelected()) {
                    kaCaCc.setVisible(true);
                    validateRestriction = new ValidateKaCaCc(editKAmassaKaCaCc, editPlotnKaCaCc, editUdlinKaCaCc, editCAmassaKaCaCc);
                    calculationSimp = new CalculationKaCaCc();
                } else
                    //4
                    if (checkKa.isSelected() && checkDd.isSelected() && checkCa.isSelected()) {
                        kaCaDd.setVisible(true);
                        validateRestriction = new ValidateKaCaDd(editKAMassaKaCaDd, editDiametrKaCaDd, editDlinaKaCaDd, editCAMassaKaCaDd);
                        calculationSimp = new CalculationKaCaDd();
                    } else
                        //5
                        if (checkKa.isSelected() && checkDd.isSelected() && !checkCa.isSelected()) {
                            kaDd.setVisible(true);
                            validateRestriction = new ValidateKaDd(editKAmassaKaDd, editDiametrKaDd, editDlinaKaDd);
                            calculationSimp = new CalculationKaDd();
                        } else
                            //6
                            if (!checkKa.isSelected() && checkDd.isSelected() && checkCa.isSelected()) {
                                caDd.setVisible(true);
                                validateRestriction = new ValidateCaDd(editDiametrCaDd, editDlinaCaDd, editCAmassaCaDd);
                                calculationSimp = new CalculationCaDd();
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

    /**
     * кнопка прикидочный расчет
     *
     * @param actionEvent
     */
    public void actionBtSimpleCalculation(ActionEvent actionEvent) {
        messConsoleSimple.clear();
        if (validateEditRestriction() && validateSimpleKoef() && validateSimpleSum()) {
            try {
                calculationSimp.calculation(dataSimpleCalculation);
                showSimpleResult();
                addMessInConsoleSimple(MessegeType.INFO, "Расчет закончен");
            } catch (Exception e) {
                addMessInConsoleSimple(MessegeType.ERROR, "Расчет не возможен, проверьте введеные данные");
                showInfo("Проверьте исходные данные");
            }

        } else
            System.out.println("NO");
    }

    public void actionEditPointSumm(KeyEvent keyEvent) {
        ValidateLable.actionEditValidateUnacceptableChar(keyEvent);
        ValidateLable.actionEditPointCharValidate(keyEvent);
        calculationSumBs();
    }

    public void actionEditMainValidate(KeyEvent keyEvent) {
        ValidateLable.actionEditValidateUnacceptableChar(keyEvent);
        ValidateLable.actionEditPointCharValidate(keyEvent);
    }

    public void actionEditMainValidateAndNotZero(KeyEvent keyEvent) {
        ValidateLable.actionEditValidateUnacceptableChar(keyEvent);
        ValidateLable.actionEditNotZeroValidate(keyEvent);
    }

    /**
     * для суммы в процентах (прикидочный расчет)
     */
    private void calculationSumBs() {
        try {
            Float sum = 0f;
            sum = sum + ValidateValue.conversionTextToFloat(editProcCA.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcBKU.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcSOTR.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcSEP.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcKDU.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcTOPLIVO.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcKONSTR.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcAFU.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcOTHERMAS.getText());
            sum = sum + ValidateValue.conversionTextToFloat(editProcREZERV.getText());
            if (sum > 99.8 && sum < 100.2) {
                labelSummaBS.setTextFill(Color.GREEN);
                labelSummaValueBS.setTextFill(Color.GREEN);
                labelSummaValueBS.setText("100");
            } else {
                labelSummaBS.setTextFill(Color.RED);
                labelSummaValueBS.setTextFill(Color.RED);
                labelSummaValueBS.setText(sum + "");
            }
        } catch (Exception e) {
            labelSummaBS.setTextFill(Color.RED);
            labelSummaValueBS.setTextFill(Color.RED);
            labelSummaValueBS.setText("Error");
        }
    }

    /**
     * забираем введенные данные (проценты) для прикидочного расчета
     *
     * @return
     */
    private boolean validateSimpleSum() {
        if (!labelSummaValueBS.getText().equals("100")) {
            addMessInConsoleSimple(MessegeType.ERROR, "Cумма процентов не равна 100 (Относительные массы бортовых систем)");
            return false;
        }
        try {
            dataSimpleCalculation.setProcCA(ValidateValue.conversionTextToFloat(editProcCA.getText()));
            dataSimpleCalculation.setProcBKU(ValidateValue.conversionTextToFloat(editProcBKU.getText()));
            dataSimpleCalculation.setProcSOTR(ValidateValue.conversionTextToFloat(editProcSOTR.getText()));
            dataSimpleCalculation.setProcSEP(ValidateValue.conversionTextToFloat(editProcSEP.getText()));
            dataSimpleCalculation.setProcKDU(ValidateValue.conversionTextToFloat(editProcKDU.getText()));
            dataSimpleCalculation.setProcTOPLIVO(ValidateValue.conversionTextToFloat(editProcTOPLIVO.getText()));
            dataSimpleCalculation.setProcKONSTR(ValidateValue.conversionTextToFloat(editProcKONSTR.getText()));
            dataSimpleCalculation.setProcAFU(ValidateValue.conversionTextToFloat(editProcAFU.getText()));
            dataSimpleCalculation.setProcREZERV(ValidateValue.conversionTextToFloat(editProcREZERV.getText()));
            dataSimpleCalculation.setProcOTHERMAS(ValidateValue.conversionTextToFloat(editProcOTHERMAS.getText()));
        } catch (Exception e) {
            addMessInConsoleSimple(MessegeType.ERROR, "Ошибка введенных данных (Относительные массы бортовых систем)");
            return false;
        }
        return true;
    }

    /**
     * забираем введенные данные (коэфициенты) для прикидочного расчета
     *
     * @return
     */
    private boolean validateSimpleKoef() {
        try {
            dataSimpleCalculation.setKoefRacKom(ValidateValue.conversionTextToFloat(editSimpleKoefRacKom.getText()));
            dataSimpleCalculation.setKoefNepolnZapoln(ValidateValue.conversionTextToFloat(editSimpleKoefNepolnZapoln.getText()));
        } catch (Exception e) {
            System.out.println(e);
            addMessInConsoleSimple(MessegeType.ERROR, "Ошибка введенных данных (Коэффициенты для прикидочного расчета)");
            return false;
        }
        return true;
    }

    /**
     * проверка для верного выпбора типа ограничений в ПРИКИДОЧНОМ РАСЧЕТЕ
     *
     * @return
     */
    private boolean validateEditRestriction() {
        if (validateRestriction != null && dataSimpleCalculation != null) {
            if (!checkCa.isSelected() && checkDd.isSelected() && !checkKa.isSelected()) {
                addMessInConsoleSimple(MessegeType.ERROR, "Нельзя задавать ограничения только по Диаметру и Длине (Ограничения)");
                return false;
            }
            if (!checkCa.isSelected() && !checkDd.isSelected() && !checkKa.isSelected()) {
                addMessInConsoleSimple(MessegeType.ERROR, "Не заданно ни одного ограничения (Ограничения)");
                return false;
            }
            boolean result = validateRestriction.validate(dataSimpleCalculation);
            if (!result) {
                addMessInConsoleSimple(MessegeType.ERROR, "Ошибка введенных данных (Ограничения)");
                return false;
            }
            return result;
        }
        addMessInConsoleSimple(MessegeType.ERROR, "Неизвестная ошибка");
        return false;
    }

    /**
     * Выдаем на форму результаты расчета для ПРИКИДОЧНОГО РАСЧЕТА
     */
    private void showSimpleResult() {
        simplResBKSafu.setText(String.valueOf(dataSimpleCalculation.res_mBKS1));
        simplResCA.setText(String.valueOf(dataSimpleCalculation.res_mZA1));
        simplResDiametrKA.setText(String.valueOf(dataSimpleCalculation.res_dKA0));
        simplResDiametrPN.setText(String.valueOf(dataSimpleCalculation.res_dzPN0));
        simplResDlinaKA.setText(String.valueOf(dataSimpleCalculation.res_lKA0));
        simplResDlinaPN.setText(String.valueOf(dataSimpleCalculation.res_lzPN0));
        simplResKDU.setText(String.valueOf(dataSimpleCalculation.res_mKDU1));
        simplResKonstr.setText(String.valueOf(dataSimpleCalculation.res_mKonstr1));
        simplResMassKA.setText(String.valueOf(dataSimpleCalculation.res_mKA0));
        simplResMoment.setText(String.valueOf(dataSimpleCalculation.res_jKA0));
        simplResObiem.setText(String.valueOf(dataSimpleCalculation.res_vKA0));
        simplResOtherMass.setText(String.valueOf(dataSimpleCalculation.res_mPr1));
        simplResPlotn.setText(String.valueOf(dataSimpleCalculation.res_plotn));
        simplResRetherv.setText(String.valueOf(dataSimpleCalculation.res_mReserv1));
        simplResSEP.setText(String.valueOf(dataSimpleCalculation.res_mSEP1));
        simplResSOTR.setText(String.valueOf(dataSimpleCalculation.res_mSOTR1));
        simplResToplKDU.setText(String.valueOf(dataSimpleCalculation.res_mTKDU1));
        simpleResBKU.setText(String.valueOf(dataSimpleCalculation.res_mBKU1));
    }

    /**
     * показываем в консоле сообщения ПРИКИДДОЧНОГО РАСЧЕТА
     */
    private void showMessSimpleConsole() {
        for (String error : messConsoleSimple) {
            consoleSimple.setText(consoleSimple.getText() + "\n" + error);
        }
    }

    //sintez


    /**
     * Кнопка расчет прикидочный - синтез
     *
     * @param actionEvent
     */
    public void actionCal_Restriction(ActionEvent actionEvent) {
        try {
            if (validateSimpleSintez()) {
                calculationSimpSintez.getType().getDataElement().setImportData(false);
                calculationSimpSintez.calculation(CalculationKA.getInstance().getDataCommonParameters());
                onProgressRestr(true);
                showSimpleSintezResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.RESTRICTION);
        }
        showStartData();
        showConsoleSintezDebug();
    }

    public static boolean checkstartDataKAandShowErrorMess () {
        if (((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).krkKA==0 && ((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).kpoPO==0 && ((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).udlKA==0){
            ControllerAssembly.showError("Коэффициент рациональности компоновки или\nплотность заполнения аппаратурой или\nудлинение КА не задано.");
            return false;
        }
        return true;
    }

    /**
     * Кнопка ОЕТК - синтез
     *
     * @param actionEvent
     */
    public void actionCal_OETK(ActionEvent actionEvent) {
        try {
            if (validateOETK()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimOetk(null);
                calculationOETK.getType().getDataElement().setImportData(false);
                calculationOETK.calculation(CalculationKA.getInstance().getDataOETK());
                onProgressOetk(true);
                showOetkResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationOETK.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OETK);
        }
        showConsoleSintezDebug();
    }

    /**
     * Кнопка расчет СГК - синтез
     *
     * @param actionEvent
     */
    public void actionCal_SGK(ActionEvent actionEvent) {
        try {
            if (validateSGK()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimSgk(null);
                calculationSGK.getType().getDataElement().setImportData(false);
                calculationSGK.calculation(CalculationKA.getInstance().getDataSudSGK());
                showSgkResult();

                CalculationKA.getInstance().getAllElementKA().add(calculationSGK.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SUD_SGK);
        }
        showConsoleSintezDebug();
    }


    private void showConsoleSintezDebug() {
        consoleSimple.clear();
        for (String error : messConsoleSintez) {
            if (consoleSimple.getText() == null || "".equals(consoleSimple.getText())) {
                consoleSimple.setText(error);
            } else {
                consoleSimple.setText(consoleSimple.getText() + "\n" + error);
            }
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consoleSimple.scrollTopProperty().set(1000000);
            }
        });
        thread.start();
    }

    public void actionSelectTypeSGK(ActionEvent actionEvent) {
        if (!typeSgk.isSelected() || !typeBdus.isSelected()) {
            pane_startData_SGK.setVisible(false);
            pane_finishData_SGK.setVisible(false);
            labelNonAcces.setVisible(true);
        } else {
            pane_startData_SGK.setVisible(true);
            pane_finishData_SGK.setVisible(true);
            labelNonAcces.setVisible(false);
        }
    }

    public void actionClearConsole(ActionEvent actionEvent) {
        messConsoleSintez.clear();
        messConsoleSimple.clear();
        consoleSimple.clear();
    }

    public void actionCal_SPPE(ActionEvent actionEvent) {
        try {
            if (validateSPPE()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimSppe(null);
                calculationSPPE.getType().getDataElement().setImportData(false);
                calculationSPPE.calculation(CalculationKA.getInstance().getDataSPPE());
                onProgressSppe(true);
                showSPEEResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationSPPE.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SPPE);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_VRL(ActionEvent actionEvent) {
        try {
            if (validateVRL()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimVrl(null);
                calculationVRL.getType().getDataElement().setImportData(false);
                calculationVRL.calculation(CalculationKA.getInstance().getDataVRL());
                onProgressVrl(true);
                showVRLResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationVRL.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.VRL);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_OtherCa(ActionEvent actionEvent) {
        try {
            if (validateOtherCA()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimOtherCa(null);
                calculationOtherCA.getType().getDataElement().setImportData(false);
                calculationOtherCA.calculation(CalculationKA.getInstance().getDataOtherCA());
                onProgressOtherCa(true);
                showOtherCAResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationOtherCA.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENTS_CA);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_CA(ActionEvent actionEvent) {
        try {
            if (!checkstartDataKAandShowErrorMess()){
                return;
            }
            calculationCA.getType().getDataElement().setImportData(false);
            calculationCA.calculation(CalculationKA.getInstance().getDataCa());
            onProgressCa(true);
            showCAResult();

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.CA);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SSKM(ActionEvent actionEvent) {
        try {
            if (validateSSKM()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimSskm(null);
                calculationSSKM.getType().getDataElement().setImportData(false);
                calculationSSKM.calculation(CalculationKA.getInstance().getDataSSKM());
                showSSKMResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationSSKM.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SUD_SSKM);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_STKRP(ActionEvent actionEvent) {
        try {
            if (validateSTKRP()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimStkrp(null);
                calculationSTKRP.getType().getDataElement().setImportData(false);
                calculationSTKRP.calculation(CalculationKA.getInstance().getDataSTKRP());
                showSTKRPResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationSTKRP.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.STKRP);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BAKES(ActionEvent actionEvent) {
        try {
            if (validateBAKES()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimBaKis(null);
                calculationBAKES.getType().getDataElement().setImportData(false);
                calculationBAKES.calculation(CalculationKA.getInstance().getDataBAKES());
                showKISResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationBAKES.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BAKIS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BETS(ActionEvent actionEvent) {
        try {
            if (validateBETS()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimBets(null);
                calculationBETS.getType().getDataElement().setImportData(false);
                calculationBETS.calculation(CalculationKA.getInstance().getDataBETS());
                showBETSResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationBETS.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BETS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BVS(ActionEvent actionEvent) {
        try {
            if (validateBVS()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimBvs(null);
                calculationBVS.getType().getDataElement().setImportData(false);
                calculationBVS.calculation(CalculationKA.getInstance().getDataBVS());
                showBVSResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationBVS.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BVS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_OtherBKU(ActionEvent actionEvent) {
        try {
            if (validateOtherBKU()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimOtherBku(null);
                calculationOtherBKU.getType().getDataElement().setImportData(false);
                calculationOtherBKU.calculation(CalculationKA.getInstance().getDataOtherBKU());
                showOtherBKUResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationOtherBKU.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENTS_BKU);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BKU(ActionEvent actionEvent) {
        try {
            if (!checkstartDataKAandShowErrorMess()){
                return;
            }
            ControllerAssembly.getInstance().onLabelZaimOtherBku(null);
            calculationBKU.getType().getDataElement().setImportData(false);
            calculationBKU.calculation(CalculationKA.getInstance().getDataBKU());
            showBKUResult();
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BKU);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_PasivSOTR(ActionEvent actionEvent) {
        try {
            if (validatePasivSOTR()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimOtherPasivSotr(null);
                calculationPasivSOTR.getType().getDataElement().setImportData(false);
                calculationPasivSOTR.calculation(CalculationKA.getInstance().getDataPasivSOTR());
                showPasivSOTRResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationPasivSOTR.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.PASSIV_ELEMENT_SOTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_ActivSOTR(ActionEvent actionEvent) {
        try {
            if (validateActivSOTR()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimActivSotr(null);
                calculationActivSOTR.getType().getDataElement().setImportData(false);
                calculationActivSOTR.calculation(CalculationKA.getInstance().getDataActivSOTR());
                showActivSOTRResult();
                CalculationKA.getInstance().getAllElementKA().add(calculationActivSOTR.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.ACTIV_ELEMENT_SOTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SOTR(ActionEvent actionEvent) {
        try {
            if (!checkstartDataKAandShowErrorMess()){
                return;
            }
            calculationSOTR.getType().getDataElement().setImportData(false);
            calculationSOTR.calculation(CalculationKA.getInstance().getDataSOTR());
            showSOTRResult();
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SOTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_electrTehnSEP(ActionEvent actionEvent) {
        try {
            if (validateElectTehHarakSEP()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimOtherEleHarSep(null);
                calculationElectrTehnSEP.getType().getDataElement().setImportData(false);
                calculationElectrTehnSEP.calculation(CalculationKA.getInstance().getDataElectHaraktSEP());
                showElectTehHarakSEPResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.ELECTROTEH_PARAM);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_AcumBet(ActionEvent actionEvent) {
        try {
            if (validateAcumBat()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimAcumBet(null);
                calculationAcumBet.getType().getDataElement().setImportData(false);
                calculationAcumBet.calculation(CalculationKA.getInstance().getDataAcumBetSEP());
                showAcumBat();
                CalculationKA.getInstance().getAllElementKA().add(calculationAcumBet.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.AKUM_BATTERIES);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_KAS(ActionEvent actionEvent) {
        try {
            if (validateKAS()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimKas(null);
                calculationKAS.getType().getDataElement().setImportData(false);
                calculationKAS.calculation(CalculationKA.getInstance().getDataKAS());
                showKAS();
                CalculationKA.getInstance().getAllElementKA().add(calculationKAS.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.KAS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SunBet(ActionEvent actionEvent) {
        try {
            if (validateSunBet()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimSunBet(null);
                calculationSUNbet.getType().getDataElement().setImportData(false);
                calculationSUNbet.calculation(CalculationKA.getInstance().getDataSumBetSEP());
                showSunBet();
                CalculationKA.getInstance().getAllElementKA().add(calculationSUNbet.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SUN_BATTERIES);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_speed(ActionEvent actionEvent) {
        try {
            if (validateSpeed()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimSunSpeed(null);
                calculationSpeed.getType().getDataElement().setImportData(false);
                calculationSpeed.calculation(CalculationKA.getInstance().getDataSpeed());
                showSpeed();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SPEED);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_mTop(ActionEvent actionEvent) {
        try {
            if (validateMassTopl()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimMassT(null);
                calculationMTop.getType().getDataElement().setImportData(false);
                calculationMTop.calculation(CalculationKA.getInstance().getDataMassTopl());
                showMassTopl();
                CalculationKA.getInstance().getAllElementKA().add(calculationMTop.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.MASS_TOPLIVA);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_KDU(ActionEvent actionEvent) {
        try {
            if (validateKDU()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimKDU(null);
                calculationKDU.getType().getDataElement().setImportData(false);
                calculationKDU.calculation(CalculationKA.getInstance().getDataKDU());
                showKDU();
                CalculationKA.getInstance().getAllElementKA().add(calculationKDU.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_konstr(ActionEvent actionEvent) {
        try {
            if (validateKonstrKA()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationKonstrKA.getType().getDataElement().setImportData(false);
                calculationKonstrKA.calculation(CalculationKA.getInstance().getDataKonstrKA());
                showKonstrKA();
                CalculationKA.getInstance().getAllElementKA().add(calculationKonstrKA.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.KONSTR);
        }
        showConsoleSintezDebug();
    }

//    public void bt_calcul_OtherKA(ActionEvent actionEvent) {
//        try {
//            if (validateOtherKA()) {
//                calculationOtherKA.getType().getDataElement().setImportData(false);
//                calculationOtherKA.calculation(CalculationKA.getInstance().getDataOtherKA());
//                showOtherKA();
//            }
//        } catch (Exception e) {
//            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENT_KA);
//        }
//        showConsoleSintezDebug();
//    }

    public void bt_calcul_Rezerv(ActionEvent actionEvent) {
        try {
            if (validateRezerv()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
                ControllerAssembly.getInstance().onLabelZaimRezerv(null);
                calculationRezerv.getType().getDataElement().setImportData(false);
                calculationRezerv.calculation(CalculationKA.getInstance().getDataRezervKA());
                showRezerv();
                CalculationKA.getInstance().getAllElementKA().add(calculationRezerv.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.RETHERV);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SSD(ActionEvent actionEvent) {
        try {
            if (validateSSD()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationSSD.getType().getDataElement().setImportData(false);
                calculationSSD.calculation(CalculationKA.getInstance().getDataSSD());
                showSSD();
                CalculationKA.getInstance().getAllElementKA().add(calculationSSD.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SSD);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_IPMV(ActionEvent actionEvent) {
        try {
            if (validateIPMV()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationIPMV.getType().getDataElement().setImportData(false);
                calculationIPMV.calculation(CalculationKA.getInstance().getDataIPMV());
                showIPMV();
                CalculationKA.getInstance().getAllElementKA().add(calculationIPMV.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.IPMV);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BOKZ(ActionEvent actionEvent) {
        try {
            if (validateBOKZ()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationBOKZ.getType().getDataElement().setImportData(false);
                calculationBOKZ.calculation(CalculationKA.getInstance().getDataBOKZ());
                showBOKZ();
                CalculationKA.getInstance().getAllElementKA().add(calculationBOKZ.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BOKZ);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_DO(ActionEvent actionEvent) {
        try {
            if (validateDO()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationDO.getType().getDataElement().setImportData(false);
                calculationDO.calculation(CalculationKA.getInstance().getDataDO());
                showDO();
                CalculationKA.getInstance().getAllElementKA().add(calculationDO.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.DO);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_DUS(ActionEvent actionEvent) {
        try {
            if (validateDUS()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationDUS.getType().getDataElement().setImportData(false);
                calculationDUS.calculation(CalculationKA.getInstance().getDataDUS());
                showDUS();
                CalculationKA.getInstance().getAllElementKA().add(calculationDUS.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.DUS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BKS(ActionEvent actionEvent) {
        try {
            if (validateBKS()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationBKS.getType().getDataElement().setImportData(false);
                calculationBKS.calculation(CalculationKA.getInstance().getDataBKS());
                showBKS();
                CalculationKA.getInstance().getAllElementKA().add(calculationBKS.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BKS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_AFU(ActionEvent actionEvent) {
        try {
            if (validateAFU()) {
                if (!checkstartDataKAandShowErrorMess()){
                    return;
                }
//                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationAFU.getType().getDataElement().setImportData(false);
                calculationAFU.calculation(CalculationKA.getInstance().getDataAFU());
                showAFU();
                CalculationKA.getInstance().getAllElementKA().add(calculationAFU.getType().getDataElement());
                initTableAllElementKA();
                actionShowParamRezult(new ActionEvent());
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.AFU);
        }
        showConsoleSintezDebug();
    }

    public void actionTest(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("project", "*.adara");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(Main.getStage());
    }


    private void updateSaveBt() {
        if (openFile == null) {
            btSaveProject.setDisable(true);
        } else {
            btSaveProject.setDisable(false);
        }
    }

    public void actionNewProject(ActionEvent actionEvent) {
        openFile = null;
        updateSaveBt();
        CalculationKA.getInstance().init();
        showALL();
        startShowALL();
        initTableAllElementKA();
        actionShowParamRezult(new ActionEvent());
        showInfo("Новый проект создан.");
    }

    public void actionOpenProject(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Project");//Заголовок диалога

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("adara", "*.adara"));
        File file = fileChooser.showOpenDialog(Main.getStage());
        if (file != null) {
            openFile = file;
            updateSaveBt();
            if (file.getName().contains(".adara")) {
                SaveXmlObject<CalculationKA> saveXmlObject = new SaveXmlObject<>();
                try {
                    CalculationKA calculationKA = (CalculationKA) saveXmlObject.readObject(file, CalculationKA.class);
                    CalculationKA.setKA(calculationKA);
                    showALL();
                    startShowALL();
                    showInfo("Проект открыт");
                } catch (JAXBException e) {
                    showError("Этот файл не поддерживается\nВыберите файл с расширением .adara");
                }
            } else {
                showError("Этот файл не поддерживается\nВыберите файл с расширением .adara");
            }
        }
        List<DataElement> datum = new ArrayList<>(CalculationKA.getInstance().getAllElementKA());
        for (DataElement d:datum){
            CalculationKA.getInstance().getAllElementKA().add(d.getType().getDataElement());
        }
        initTableAllElementKA();
        actionShowParamRezult(new ActionEvent());
    }

    public void actionSaveProject(ActionEvent actionEvent) {
        try {
            SaveXmlObject<CalculationKA> saveXmlObject = new SaveXmlObject<>();
            saveXmlObject.saveObject(openFile, CalculationKA.getInstance());
            showInfo("Проект сохранен.");
        } catch (JAXBException e) {
            showError("Не удалось сохранить проект");
        }
    }

    public void actionSaveAsProject(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
            fileChooser.setTitle("Save Document");//Заголовок диалога
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("adara", "*.adara");//Расширение
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(Main.getStage());
            if (file != null) {
                SaveXmlObject<CalculationKA> saveXmlObject = new SaveXmlObject<>();
                saveXmlObject.saveObject(file, CalculationKA.getInstance());
                showInfo("Проект сохранен.");
            }
        } catch (Exception e) {
            showError("Не удалось сохранить.");
        }
    }

    public void actionCloseProject(ActionEvent actionEvent) {
        try {
            Stage stageThis = (Stage) pane_finishData_SGK.getScene().getWindow();
            com.simulation.startMenu.Main main = new com.simulation.startMenu.Main();
            main.start(new Stage());
            stageThis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public static void showInfo(String mess) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(mess);
        alert.showAndWait();
    }


    public static void showError(String mess) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mess);
        alert.showAndWait();
    }

    public void addOtherKA(ActionEvent actionEvent) {
        if (!ControllerAssembly.checkstartDataKAandShowErrorMess()) {
            return;
        }
        AddElement addElement = new AddElementOtherKA();
        DataOtherKA newData = new DataOtherKA();
        addElement.addElementNotSave(newData);

        if (newData.m == 0f && !newData.isMassProc())
            return;

        if (newData.omPrKA == 0f && newData.isMassProc())
            return;

        CalculationKA.getInstance().getDataOtherKA().getOthers().add(newData);

        try {
            calculationOtherKA.calculation(new DataOtherKA());
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при добавлении элемента");
        }
        CalculationKA.getInstance().getAllElementKA().add(newData);
        initTableAllElementKA();
        actionShowParamRezult(new ActionEvent());

        initotherKA();
        showOtherKA();
    }

    public void removeOtherKA(ActionEvent actionEvent) {
        String nameDataElement = ((ViewDataOtherKA) tableOtherKA.getSelectionModel().getSelectedItem()).getNameElement();
        if (nameDataElement == null) {
            return;
        }
        DataElement dataElementE = null;
        SaveXmlObject<DataElement> saveXmlObject = new SaveXmlObject<>();
        for (DataElement dataElement : CalculationKA.getInstance().getDataOtherKA().getOthers()) {
            if (dataElement.getNameElement().equals(nameDataElement)) {
                dataElementE = dataElement;
            }
        }
        CalculationKA.getInstance().getDataOtherKA().getOthers().remove(dataElementE);
        try {
            calculationOtherKA.calculation(new DataOtherKA());
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при расчете прочих элементов");
        }
        if (dataElementE!=null){
            CalculationKA.getInstance().getAllElementKA().remove(dataElementE);
        }
        initTableAllElementKA();
        actionShowParamRezult(new ActionEvent());
        initotherKA();
        showOtherKA();
    }

    public boolean isShowMessM;
    public boolean isShowMessV;
    public boolean isShowMessJ;
    public boolean isShowMessD;
    public boolean isShowMessL;

    public void actionIteration(ActionEvent actionEvent) {
        isShowMessM = false;
        isShowMessV = false;
        isShowMessJ = false;
        isShowMessD = false;
        isShowMessL = false;
        try {
            if (TabTypeSintez.OETK.getDataElement().isNeedUvyzka())
                calculationOETK.calculation(new DataOETK());
            if (TabTypeSintez.SPPE.getDataElement().isNeedUvyzka())
                calculationSPPE.calculation(new DataSPPE());
            if (TabTypeSintez.VRL.getDataElement().isNeedUvyzka())
                calculationVRL.calculation(new DataVRL());
            if (TabTypeSintez.SSD.getDataElement().isNeedUvyzka())
                calculationSSD.calculation(new DataSSD());
            if (TabTypeSintez.OTHER_ELEMENTS_CA.getDataElement().isNeedUvyzka())
                calculationOtherCA.calculation(new DataOtherCA());

            calculationCA.calculation(new DataCa());

            if (TabTypeSintez.BVS.getDataElement().isNeedUvyzka())
                calculationBVS.calculation(new DataBVS());
            if (TabTypeSintez.STKRP.getDataElement().isNeedUvyzka())
                calculationSTKRP.calculation(new DataSTKRP());
            if (TabTypeSintez.BAKIS.getDataElement().isNeedUvyzka())
                calculationBAKES.calculation(new DataBAKES());
            if (TabTypeSintez.BETS.getDataElement().isNeedUvyzka())
                calculationBETS.calculation(new DataBETS());
            if (TabTypeSintez.OTHER_ELEMENTS_BKU.getDataElement().isNeedUvyzka())
                calculationOtherBKU.calculation(new DataOtherBKU());

            calculationBKU.calculation(new DataBKU());

            if (TabTypeSintez.SUD_SGK.getDataElement().isNeedUvyzka())
                calculationSGK.calculation(new DataSudSGK());
            if (TabTypeSintez.SUD_SSKM.getDataElement().isNeedUvyzka())
                calculationSSKM.calculation(new DataSSKM());
            if (TabTypeSintez.IPMV.getDataElement().isNeedUvyzka())
                calculationIPMV.calculation(new DataIPMV());
            if (TabTypeSintez.BOKZ.getDataElement().isNeedUvyzka())
                calculationBOKZ.calculation(new DataBOKZ());
            if (TabTypeSintez.DO.getDataElement().isNeedUvyzka())
                calculationDO.calculation(new DataDO());
            if (TabTypeSintez.DUS.getDataElement().isNeedUvyzka())
                calculationDUS.calculation(new DataDUS());
            if (TabTypeSintez.PASSIV_ELEMENT_SOTR.getDataElement().isNeedUvyzka())
                calculationPasivSOTR.calculation(new DataPasivSOTR());
            if (TabTypeSintez.ACTIV_ELEMENT_SOTR.getDataElement().isNeedUvyzka())
                calculationActivSOTR.calculation(new DataActivSOTR());

            calculationSOTR.calculation(new DataSOTR());

            if (TabTypeSintez.AKUM_BATTERIES.getDataElement().isNeedUvyzka())
                calculationElectrTehnSEP.calculation(new DataElectHaraktSEP());
            if (TabTypeSintez.AKUM_BATTERIES.getDataElement().isNeedUvyzka())
                calculationAcumBet.calculation(new DataAcumBetSEP());
            if (TabTypeSintez.KAS.getDataElement().isNeedUvyzka())
                calculationKAS.calculation(new DataKAS());
            if (TabTypeSintez.SUN_BATTERIES.getDataElement().isNeedUvyzka())
                calculationSUNbet.calculation(new DataSumBetSEP());
            if (TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getDataElement().isNeedUvyzka())
                calculationSpeed.calculation(new DataSpeed());
            if (TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getDataElement().isNeedUvyzka())
                calculationMTop.calculation(new DataMassTopl());
            if (TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS.getDataElement().isNeedUvyzka())
                calculationKDU.calculation(new DataKDU());
            if (TabTypeSintez.KONSTR.getDataElement().isNeedUvyzka())
                calculationKonstrKA.calculation(new DataKonstrKA());
            if (TabTypeSintez.BKS.getDataElement().isNeedUvyzka())
                calculationBKS.calculation(new DataBKS());
            if (TabTypeSintez.AFU.getDataElement().isNeedUvyzka())
                calculationAFU.calculation(new DataAFU());
            if (TabTypeSintez.OTHER_ELEMENT_KA.getDataElement().isNeedUvyzka())
                calculationOtherKA.calculation(new DataOtherKA());
            if (TabTypeSintez.RETHERV.getDataElement().isNeedUvyzka())
                calculationRezerv.calculation(new DataRezervKA());
            actionShowParamRezult(new ActionEvent());
            showALL();
            startShowALL();
            initTableAllElementKA();
        } catch (Exception e) {
            showError("Ошибка при расчете - итерации");
        }
    }

    public void actionShowHelpInfoForSpeed(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/assembly/help/helpInfoForSpeed.fxml"));
            Scene scene = new Scene(root, 600, 442);
            stage.setResizable(false);
            stage.setTitle("Справочная информация");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionShowHelpInfoForAcum(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/assembly/help/helpInfoForAKUM.fxml"));
            Scene scene = new Scene(root, 600, 400);
            stage.setResizable(false);
            stage.setTitle("Справочная информация");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionShowHelpInfoForOetk(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/assembly/help/helpInfoForOETK.fxml"));
            Scene scene = new Scene(root, 958, 455);
            stage.setResizable(false);
            stage.setTitle("Справочная информация");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionPricjidRaschet(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/assembly/prikidochnRaschet.fxml"));
            Scene scene = new Scene(root, 1159, 635);
            stage.setResizable(false);
            stage.setTitle("Прикидочный расчет");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(ControllerAssembly.getInstance().paneRestriction.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionShowSvodka(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/assembly/svodka.fxml"));
            Scene scene = new Scene(root, 922, 601);
            stage.setResizable(false);
            stage.setTitle("Сводка");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(ControllerAssembly.getInstance().paneRestriction.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            ControllerAssembly.showInfo("Возникли технические неполадки");
        }
    }

    public void actionPodtverzdenieStartData(ActionEvent actionEvent) {
        try {
            ((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).krkKA = ValidateValue.conversionTextToFloat(iN_nonRes_krkKA.getText());
            ((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).kpoPO = ValidateValue.conversionTextToFloat(iN_nonRes_kpoPO.getText());
            ((DataCommonParameters) TabTypeSintez.RESULT.getDataElement()).udlKA = ValidateValue.conversionTextToFloat(iN_nonRes_udlKA.getText());
        } catch (Exception e) {
            ControllerAssembly.showError("Проверьте введеные данные.");
        }
        showStartData();
    }

    public void aboutProgram(ActionEvent actionEvent) throws IOException {
        System.out.println("action bt info project");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/startMenu/AboutTheProgram.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage= new Stage();
        stage.setTitle("О программе");
        stage.setResizable(false);
        Scene scene = new Scene(root, 695, 443);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((paneRestriction.getScene().getWindow()));
        stage.show();
    }

//    public void addOtherKaElement(ActionEvent actionEvent) {
//        validateOtherKA();
//        try {
//            calculationOtherKA.calculation(new DataOtherKA());
//        } catch (Exception e) {
//            ControllerAssembly.showError("Ошибка при расчете прочих елементов КА.");
//        }
//        initotherKA();
//        showOtherKA();
//    }

}