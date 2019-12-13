package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.*;
import com.simulation.assembly.calculation.simple.*;
import com.simulation.assembly.dataCalculation.sintez.DataOtherKA;
import com.simulation.assembly.validateRestrictionSimple.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
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
        calculationBKSandAFU = new CalkulationBKSandAFU();
        calculationOtherKA = new CalculationOtherKA();
        calculationRezerv = new CalculationRezervKA();

        controllerAssembly = this;

        calculationSumBs();

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
                e.printStackTrace();
            }

        } else
            System.out.println("NO");
        showMessSimpleConsole();
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
        showConsoleSintezDebug();
    }

    /**
     * Кнопка ОЕТК - синтез
     *
     * @param actionEvent
     */
    public void actionCal_OETK(ActionEvent actionEvent) {
        try {
            if (validateOETK()) {
                ControllerAssembly.getInstance().onLabelZaimOetk(null);
                calculationOETK.getType().getDataElement().setImportData(false);
                calculationOETK.calculation(CalculationKA.getInstance().getDataOETK());
                onProgressOetk(true);
                showOetkResult();

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
                ControllerAssembly.getInstance().onLabelZaimSgk(null);
                calculationSGK.getType().getDataElement().setImportData(false);
                calculationSGK.calculation(CalculationKA.getInstance().getDataSudSGK());
                showSgkResult();
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
                ControllerAssembly.getInstance().onLabelZaimSppe(null);
                calculationSPPE.getType().getDataElement().setImportData(false);
                calculationSPPE.calculation(CalculationKA.getInstance().getDataSPPE());
                onProgressSppe(true);
                showSPEEResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SPPE);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_VRL(ActionEvent actionEvent) {
        try {
            if (validateVRL()) {
                ControllerAssembly.getInstance().onLabelZaimVrl(null);
                calculationVRL.getType().getDataElement().setImportData(false);
                calculationVRL.calculation(CalculationKA.getInstance().getDataVRL());
                onProgressVrl(true);
                showVRLResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.VRL);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_OtherCa(ActionEvent actionEvent) {
        try {
            if (validateOtherCA()) {
                ControllerAssembly.getInstance().onLabelZaimOtherCa(null);
                calculationOtherCA.getType().getDataElement().setImportData(false);
                calculationOtherCA.calculation(CalculationKA.getInstance().getDataOtherCA());
                onProgressOtherCa(true);
                showOtherCAResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENTS_CA);
        }
        showConsoleSintezDebug();
    }

    public void actionCal_CA(ActionEvent actionEvent) {
        try {
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
                ControllerAssembly.getInstance().onLabelZaimSskm(null);
                calculationSSKM.getType().getDataElement().setImportData(false);
                calculationSSKM.calculation(CalculationKA.getInstance().getDataSSKM());
                showSSKMResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SUD_SSKM);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_STKRP(ActionEvent actionEvent) {
        try {
            if (validateSTKRP()) {
                ControllerAssembly.getInstance().onLabelZaimStkrp(null);
                calculationSTKRP.getType().getDataElement().setImportData(false);
                calculationSTKRP.calculation(CalculationKA.getInstance().getDataSTKRP());
                showSTKRPResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.STKRP);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BAKES(ActionEvent actionEvent) {
        try {
            if (validateBAKES()) {
                ControllerAssembly.getInstance().onLabelZaimBaKis(null);
                calculationBAKES.getType().getDataElement().setImportData(false);
                calculationBAKES.calculation(CalculationKA.getInstance().getDataBAKES());
                showKISResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BAKIS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BETS(ActionEvent actionEvent) {
        try {
            if (validateBETS()) {
                ControllerAssembly.getInstance().onLabelZaimBets(null);
                calculationBETS.getType().getDataElement().setImportData(false);
                calculationBETS.calculation(CalculationKA.getInstance().getDataBETS());
                showBETSResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BETS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BVS(ActionEvent actionEvent) {
        try {
            if (validateBVS()) {
                ControllerAssembly.getInstance().onLabelZaimBvs(null);
                calculationBVS.getType().getDataElement().setImportData(false);
                calculationBVS.calculation(CalculationKA.getInstance().getDataBVS());
                showBVSResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BVS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_OtherBKU(ActionEvent actionEvent) {
        try {
            if (validateOtherBKU()) {
                ControllerAssembly.getInstance().onLabelZaimOtherBku(null);
                calculationOtherBKU.getType().getDataElement().setImportData(false);
                calculationOtherBKU.calculation(CalculationKA.getInstance().getDataOtherBKU());
                showOtherBKUResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENTS_BKU);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BKU(ActionEvent actionEvent) {
        try {
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
                ControllerAssembly.getInstance().onLabelZaimOtherPasivSotr(null);
                calculationPasivSOTR.getType().getDataElement().setImportData(false);
                calculationPasivSOTR.calculation(CalculationKA.getInstance().getDataPasivSOTR());
                showPasivSOTRResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.PASSIV_ELEMENT_SOTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_ActivSOTR(ActionEvent actionEvent) {
        try {
            if (validateActivSOTR()) {
                ControllerAssembly.getInstance().onLabelZaimActivSotr(null);
                calculationActivSOTR.getType().getDataElement().setImportData(false);
                calculationActivSOTR.calculation(CalculationKA.getInstance().getDataActivSOTR());
                showActivSOTRResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.ACTIV_ELEMENT_SOTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SOTR(ActionEvent actionEvent) {
        try {
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
                ControllerAssembly.getInstance().onLabelZaimAcumBet(null);
                calculationAcumBet.getType().getDataElement().setImportData(false);
                calculationAcumBet.calculation(CalculationKA.getInstance().getDataAcumBetSEP());
                showAcumBat();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.AKUM_BATTERIES);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_KAS(ActionEvent actionEvent) {
        try {
            if (validateKAS()) {
                ControllerAssembly.getInstance().onLabelZaimKas(null);
                calculationKAS.getType().getDataElement().setImportData(false);
                calculationKAS.calculation(CalculationKA.getInstance().getDataKAS());
                showKAS();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.KAS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_SunBet(ActionEvent actionEvent) {
        try {
            if (validateSunBet()) {
                ControllerAssembly.getInstance().onLabelZaimSunBet(null);
                calculationSUNbet.getType().getDataElement().setImportData(false);
                calculationSUNbet.calculation(CalculationKA.getInstance().getDataSumBetSEP());
                showSunBet();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.SUN_BATTERIES);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_speed(ActionEvent actionEvent) {
        try {
            if (validateSpeed()) {
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
                ControllerAssembly.getInstance().onLabelZaimMassT(null);
                calculationMTop.getType().getDataElement().setImportData(false);
                calculationMTop.calculation(CalculationKA.getInstance().getDataMassTopl());
                showMassTopl();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.MASS_TOPLIVA);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_KDU(ActionEvent actionEvent) {
        try {
            if (validateKDU()) {
                ControllerAssembly.getInstance().onLabelZaimKDU(null);
                calculationKDU.getType().getDataElement().setImportData(false);
                calculationKDU.calculation(CalculationKA.getInstance().getDataKDU());
                showKDU();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_konstr(ActionEvent actionEvent) {
        try {
            if (validateKonstrKA()) {
                ControllerAssembly.getInstance().onLabelZaimKonstr(null);
                calculationKonstrKA.getType().getDataElement().setImportData(false);
                calculationKonstrKA.calculation(CalculationKA.getInstance().getDataKonstrKA());
                showKonstrKA();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.KONSTR);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_BKSandAFU(ActionEvent actionEvent) {
        try {
            if (validateBKSandAFU()) {
                ControllerAssembly.getInstance().onLabelZaimBKSandAfu(null);
                calculationBKSandAFU.getType().getDataElement().setImportData(false);
                calculationBKSandAFU.calculation(CalculationKA.getInstance().getDataBKSandAFU());
                showBKSandAFU();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.BKS_AND_AFU);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_OtherKA(ActionEvent actionEvent) {
        try {
            if (validateOtherKA()) {
                calculationOtherKA.getType().getDataElement().setImportData(false);
                calculationOtherKA.calculation(CalculationKA.getInstance().getDataOtherKA());
                showOtherKA();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.OTHER_ELEMENT_KA);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_Rezerv(ActionEvent actionEvent) {
        try {
            if (validateRezerv()) {
                ControllerAssembly.getInstance().onLabelZaimRezerv(null);
                calculationRezerv.getType().getDataElement().setImportData(false);
                calculationRezerv.calculation(CalculationKA.getInstance().getDataRezervKA());
                showRezerv();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Не верно введенные данные!", TabTypeSintez.RETHERV);
        }
        showConsoleSintezDebug();
    }

    public void bt_calcul_Rezult_all(ActionEvent actionEvent) {
        try {
            CalculationKA.getInstance().calculation(new Object());
            showSinezKA();
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Неизвестная ошибка", TabTypeSintez.RESULT);
        }
        showConsoleSintezDebug();
    }

    public void actionTest(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("project", "*.sintez");//Расширение
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
        showInfo("Новый проект создан.");
    }

    public void actionOpenProject(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Project");//Заголовок диалога

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("sintez", "*.sintez"));
        File file = fileChooser.showOpenDialog(Main.getStage());
        if (file != null) {
            openFile = file;
            updateSaveBt();
            if (file.getName().contains(".sintez")) {
                SaveXmlObject<CalculationKA> saveXmlObject = new SaveXmlObject<>();
                try {
                    CalculationKA calculationKA = (CalculationKA) saveXmlObject.readObject(file, CalculationKA.class);
                    CalculationKA.setKA(calculationKA);
                    showALL();
                    startShowALL();
                    showInfo("Проект открыт");
                } catch (JAXBException e) {
                    showError("Этот файл не поддерживается\nВыберите файл с расширением .sintez");
                }
            } else {
                showError("Этот файл не поддерживается\nВыберите файл с расширением .sintez");
            }
        }

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
                    new FileChooser.ExtensionFilter("sintez", "*.sintez");//Расширение
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

    public void addOtherKaElement(ActionEvent actionEvent) {
        validateOtherKA();
        try {
            calculationOtherKA.calculation(new DataOtherKA());
        } catch (Exception e) {
            ControllerAssembly.showError("Ошибка при расчете прочих елементов КА.");
        }
        initotherKA();
        showOtherKA();
    }

    public void addOtherKaElementZaimsv(ActionEvent actionEvent) {
    }

    public void actionShowParamRezult(ActionEvent actionEvent) {
        showSinezKA();
    }
}