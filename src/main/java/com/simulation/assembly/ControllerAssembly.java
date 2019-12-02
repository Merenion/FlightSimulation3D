package com.simulation.assembly;

import com.simulation.assembly.calculation.*;
import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.calculation.ca.CalculationOETK;
import com.simulation.assembly.calculation.ca.CalculationSGK;
import com.simulation.assembly.calculation.ca.CalculationSimpleSintez;
import com.simulation.assembly.calculation.simple.*;
import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataOETK;
import com.simulation.assembly.dataCalculation.sintez.DataSudSGK;
import com.simulation.assembly.dataCalculation.sintez.TypeKa;
import com.simulation.assembly.validateRestrictionSimple.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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

    /**
     * коэфициенты для прикидочного расчета
     */
    public TextField editSimpleKoefRacKom;
    public TextField editSimpleKoefNepolnZapoln;

    /**
     * результаты прикидочного расчета
     */
    @FXML
    public Label simplResCA;
    @FXML
    public Label simpleResBKU;
    @FXML
    public Label simplResSOTR;
    @FXML
    public Label simplResSEP;
    @FXML
    public Label simplResKDU;
    @FXML
    public Label simplResToplKDU;
    @FXML
    public Label simplResKonstr;
    @FXML
    public Label simplResBKSafu;
    @FXML
    public Label simplResOtherMass;
    @FXML
    public Label simplResRetherv;
    @FXML
    public Label simplResMassKA;
    @FXML
    public Label simplResDiametrKA;
    @FXML
    public Label simplResDlinaKA;
    @FXML
    public Label simplResObiem;
    @FXML
    public Label simplResPlotn;
    @FXML
    public Label simplResMoment;
    @FXML
    public Label simplResDlinaPN;
    @FXML
    public Label simplResDiametrPN;
    @FXML
    public TextArea consoleSimple;

    /**
     * синтез
     * таба Ограничения
     */
    @FXML
    public Tab tab_Restriction;
    @FXML
    public AnchorPane paneRestriction;
    @FXML
    public CheckBox isHaveRestriction;
    @FXML
    public AnchorPane paneStartDataRestriction;
    @FXML
    public AnchorPane paneRestrictionCalculation;

    @FXML
    public TextField iN_mKA0;
    @FXML
    public TextField iN_dzPN0;
    @FXML
    public TextField iN_lzPN0;
    @FXML
    public TextField iN_knzpOBT;
    @FXML
    public TextField iN_krkKA;
    @FXML
    public TextField iN_kpoPO;

    @FXML
    public TextField iN_nonRes_udlKA;
    @FXML
    public TextField iN_nonRes_krkKA;
    @FXML
    public Spinner iN_nonRes_kpoPO;

    @FXML
    public Label ouT_dKA0;
    @FXML
    public Label ouT_lKA0;
    @FXML
    public Label ouT_splkKA0;
    @FXML
    public Label ouT_jKA0;
    @FXML
    public Label ouT_vKA0;

    @FXML
    public Button bt_calcul_Restriction;


    /**
     * таба ОЕТК
     */
    @FXML
    public Tab tab_OETK;
    @FXML
    public AnchorPane pane_startData_OETK;
    @FXML
    public AnchorPane pane_finishData_OETK;

    @FXML
    public Label ouT_fOETK;
    @FXML
    public Label ouT_lOETK;
    @FXML
    public Label ouT_mOETK;
    @FXML
    public Label ouT_vOETK;
    @FXML
    public Label ouT_jOETK;
    @FXML
    public Label ouT_wOETK;
    @FXML
    public Label ouT_dkSO_OETK;
    @FXML
    public Label ouT_lkSO_OETK;
    @FXML
    public Label ouT_vkSO_OETK;
    @FXML
    public Label ouT_dOETK;

    @FXML
    public TextField iN_Det;
    @FXML
    public TextField iN_H;
    @FXML
    public TextField iN_rELPZS;
    @FXML
    public TextField iN_kUD;
    @FXML
    public TextField iN_oO;
    @FXML
    public TextField iN_plOETK;
    @FXML
    public TextField iN_uwOETK;
    @FXML
    public TextField iN_krkOETK;
    @FXML
    public TextField iN_kp2dOETK;
    @FXML
    public TextField iN_kp2lOETK;

    @FXML
    public ToggleGroup choiseTypeKA;
    @FXML
    public RadioButton iN_smmal_KA;
    @FXML
    public RadioButton iN_big_KA;
    @FXML
    public RadioButton iN_middle_KA;

    @FXML
    public Button bt_calcul_OETK;

    /**
     * таба СГК
     */
    @FXML
    public Tab tab_SGK;
    @FXML
    public AnchorPane pane_startData_SGK;
    @FXML
    public AnchorPane pane_finishData_SGK;

    @FXML
    public TextField iN_Pr1;
    @FXML
    public TextField iN_Tzr;
    @FXML
    public TextField iN_uKA;
    @FXML
    public TextField iN_wPrez;
    @FXML
    public TextField iN_wRGP;
    @FXML
    public TextField iN_plRGP;
    @FXML
    public TextField iN_kmGP_RGP;
    @FXML
    public TextField iN_kmEB_mGP;
    @FXML
    public TextField iN_uW_SGK;
    @FXML
    public TextField iN_pEB;

    @FXML
    public Label ouT_t1;
    @FXML
    public Label ouT_eKA;
    @FXML
    public Label ouT_wKA;
    @FXML
    public Label ouT_umKA;
    @FXML
    public Label ouT_kmKA;
    @FXML
    public Label ouT_kmRGP;
    @FXML
    public Label ouT_JRGP;
    @FXML
    public Label ouT_rRGP;
    @FXML
    public Label ouT_vRGP;
    @FXML
    public Label ouT_mRGP;
    @FXML
    public Label ouT_mGP;
    @FXML
    public Label ouT_mEB;
    @FXML
    public Label ouT_mEB_GP;
    @FXML
    public Label ouT_mSGK;
    @FXML
    public Label ouT_vGP;
    @FXML
    public Label ouT_vEB;
    @FXML
    public Label ouT_wSGK;
    @FXML
    public Label ouT_dGP;

    @FXML
    public Button bt_calcul_SGK;
    @FXML
    public RadioButton typeSgk;
    @FXML
    public RadioButton typeDm;
    @FXML
    public RadioButton typeBdus;
    @FXML
    public RadioButton typeLg;
    @FXML
    public Label labelNonAcces;


    private ValidateRestriction validateRestriction;
    private Calculation<DataSimpleCalculation> calculationSimp;
    private Calculation<DataCommonParameters> calculationSimpSintez;
    private Calculation<DataOETK> calculationOETK;
    private Calculation<DataSudSGK> calculationSGK;
    private CalculationKA calculationKA;

    private DataSimpleCalculation dataSimpleCalculation = new DataSimpleCalculation();

    private static List<String> messConsoleSimple = new ArrayList<>();
    private static List<String> messConsoleSintez = new ArrayList<>();

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
        calculationKA = CalculationKA.getInstance();
        calculationSumBs();
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

    /**
     * Выбор формы на вкладке ОГРАНИЧЕНИЯ - синтез (есть ограничения, нету)
     *
     * @param actionEvent
     */
    public void choiseActionHaveRestriction(ActionEvent actionEvent) {
        if (isHaveRestriction.isSelected()) {
            paneRestriction.setVisible(true);
            paneStartDataRestriction.setVisible(false);
            paneRestrictionCalculation.setVisible(true);
        } else {
            paneRestriction.setVisible(false);
            paneStartDataRestriction.setVisible(true);
            paneRestrictionCalculation.setVisible(false);
        }
    }


    //sintez

    /**
     * показать результаты прикидочного расчета
     */
    private void showSimpleSintezResult() {
        ouT_dKA0.setText(String.valueOf(calculationKA.getDataCommonParameters().dKA0));
        ouT_lKA0.setText(String.valueOf(calculationKA.getDataCommonParameters().lKA0));
        ouT_splkKA0.setText(String.valueOf(calculationKA.getDataCommonParameters().splkKA0));
        ouT_jKA0.setText(String.valueOf(calculationKA.getDataCommonParameters().jKA0));
        ouT_vKA0.setText(String.valueOf(calculationKA.getDataCommonParameters().vKA0));
    }

    /**
     * показать результаты ОЕТК
     */
    private void showOetkResult() {
        ouT_fOETK.setText(String.valueOf(calculationKA.getDataOETK().fOETK));
        ouT_lOETK.setText(String.valueOf(calculationKA.getDataOETK().lOETK));
        ouT_mOETK.setText(String.valueOf(calculationKA.getDataOETK().mOETK));
        ouT_vOETK.setText(String.valueOf(calculationKA.getDataOETK().vOETK));
        ouT_jOETK.setText(String.valueOf(calculationKA.getDataOETK().jOETK));
        ouT_wOETK.setText(String.valueOf(calculationKA.getDataOETK().wOETK));
        ouT_dkSO_OETK.setText(String.valueOf(calculationKA.getDataOETK().dkSO_OETK));
        ouT_lkSO_OETK.setText(String.valueOf(calculationKA.getDataOETK().lkSO_OETK));
        ouT_vkSO_OETK.setText(String.valueOf(calculationKA.getDataOETK().vkSO_OETK));
        ouT_dOETK.setText(String.valueOf(calculationKA.getDataOETK().dOETK));
    }

    /**
     * показать результаты ОЕТК
     */
    private void showSgkResult() {
        ouT_t1.setText(String.valueOf(calculationKA.getDataSudSGK().t1));
        ouT_eKA.setText(String.valueOf(calculationKA.getDataSudSGK().eKA));
        ouT_wKA.setText(String.valueOf(calculationKA.getDataSudSGK().wKA));
        ouT_umKA.setText(String.valueOf(calculationKA.getDataSudSGK().umKA));
        ouT_kmKA.setText(String.valueOf(calculationKA.getDataSudSGK().kmKA));
        ouT_kmRGP.setText(String.valueOf(calculationKA.getDataSudSGK().kmRGP));
        ouT_JRGP.setText(String.valueOf(calculationKA.getDataSudSGK().JRGP));

        ouT_rRGP.setText(String.valueOf(calculationKA.getDataSudSGK().rRGP));
        ouT_vRGP.setText(String.valueOf(calculationKA.getDataSudSGK().vRGP));
        ouT_mRGP.setText(String.valueOf(calculationKA.getDataSudSGK().mRGP));
        ouT_mGP.setText(String.valueOf(calculationKA.getDataSudSGK().mGP));

        ouT_mEB.setText(String.valueOf(calculationKA.getDataSudSGK().mEB));
        ouT_mEB_GP.setText(String.valueOf(calculationKA.getDataSudSGK().mEB_GP));
        ouT_mSGK.setText(String.valueOf(calculationKA.getDataSudSGK().mSGK));

        ouT_vGP.setText(String.valueOf(calculationKA.getDataSudSGK().vGP));
        ouT_vEB.setText(String.valueOf(calculationKA.getDataSudSGK().vEB));
        ouT_wSGK.setText(String.valueOf(calculationKA.getDataSudSGK().wSGK));
        ouT_dGP.setText(String.valueOf(calculationKA.getDataSudSGK().dGP));
    }

    /**
     * ввод Ограничения
     *
     * @return
     */
    private boolean validateSimpleSintez() {
        try {
            calculationKA.getDataCommonParameters().isHaveRestriction = isHaveRestriction.isSelected();
            if (isHaveRestriction.isSelected()) {
                calculationKA.getDataCommonParameters().mKA0 = ValidateValue.conversionTextToFloat(iN_mKA0.getText());
                calculationKA.getDataCommonParameters().dzPN0 = ValidateValue.conversionTextToFloat(iN_dzPN0.getText());
                calculationKA.getDataCommonParameters().lzPN0 = ValidateValue.conversionTextToFloat(iN_lzPN0.getText());
                calculationKA.getDataCommonParameters().knzpOBT = ValidateValue.conversionTextToFloat(iN_knzpOBT.getText());
                calculationKA.getDataCommonParameters().krkKA = ValidateValue.conversionTextToFloat(iN_krkKA.getText());
                calculationKA.getDataCommonParameters().kpoPO = ValidateValue.conversionTextToFloat(String.valueOf(iN_kpoPO.getText()));
            } else {
                calculationKA.getDataCommonParameters().udlKA = ValidateValue.conversionTextToFloat(iN_nonRes_udlKA.getText());
                calculationKA.getDataCommonParameters().krkKA = ValidateValue.conversionTextToFloat(iN_nonRes_krkKA.getText());
                calculationKA.getDataCommonParameters().kpoPO = ValidateValue.conversionTextToFloat(String.valueOf(iN_nonRes_kpoPO.getValue()));
            }
        } catch (Exception e) {
            addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.RESTRICTION);
            return false;
        }
        return true;
    }

    /**
     * ввод ОЭТК
     * @return
     */
    private boolean validateOETK() {
        try {
            calculationKA.getDataOETK().Det = ValidateValue.conversionTextToFloat(iN_Det.getText());
            calculationKA.getDataOETK().H = ValidateValue.conversionTextToFloat(iN_H.getText());
            calculationKA.getDataOETK().rELPZS = ValidateValue.conversionTextToFloat(iN_rELPZS.getText());
            calculationKA.getDataOETK().kUD = ValidateValue.conversionTextToFloat(iN_kUD.getText());
            calculationKA.getDataOETK().oO = ValidateValue.conversionTextToFloat(iN_oO.getText());
            calculationKA.getDataOETK().plOETK = ValidateValue.conversionTextToFloat(iN_plOETK.getText());
            calculationKA.getDataOETK().uwOETK = ValidateValue.conversionTextToFloat(iN_uwOETK.getText());
            calculationKA.getDataOETK().krkOETK = ValidateValue.conversionTextToFloat(iN_krkOETK.getText());
            calculationKA.getDataOETK().kp2dOETK = ValidateValue.conversionTextToFloat(iN_kp2dOETK.getText());
            calculationKA.getDataOETK().kp2lOETK = ValidateValue.conversionTextToFloat(iN_kp2lOETK.getText());

            if (iN_smmal_KA.isSelected()) {
                calculationKA.getDataOETK().typeKA = TypeKa.SAMLL;
            } else if (iN_middle_KA.isSelected()) {
                calculationKA.getDataOETK().typeKA = TypeKa.MIDDLE;
            } else if (iN_big_KA.isSelected()) {
                calculationKA.getDataOETK().typeKA = TypeKa.BIG;
            }

        } catch (Exception e) {
            addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.OETK);
            return false;
        }
        return true;
    }

    /**
     * ввод СГК
     * @return
     */
    private boolean validateSGK() {
        try {
            calculationKA.getDataSudSGK().Pr1 = ValidateValue.conversionTextToFloat(iN_Pr1.getText());
            calculationKA.getDataSudSGK().Tzr = ValidateValue.conversionTextToFloat(iN_Tzr.getText());
            calculationKA.getDataSudSGK().uKA = ValidateValue.conversionTextToFloat(iN_uKA.getText());
            calculationKA.getDataSudSGK().wPrez = ValidateValue.conversionTextToFloat(iN_wPrez.getText());
            calculationKA.getDataSudSGK().wRGP = ValidateValue.conversionTextToFloat(iN_wRGP.getText());
            calculationKA.getDataSudSGK().plRGP = ValidateValue.conversionTextToFloat(iN_plRGP.getText());
            calculationKA.getDataSudSGK().kmGP_RGP = ValidateValue.conversionTextToFloat(iN_kmGP_RGP.getText());
            calculationKA.getDataSudSGK().kmEB_mGP = ValidateValue.conversionTextToFloat(iN_kmEB_mGP.getText());
            calculationKA.getDataSudSGK().uW_SGK = ValidateValue.conversionTextToFloat(iN_uW_SGK.getText());
            calculationKA.getDataSudSGK().pEB = ValidateValue.conversionTextToFloat(iN_pEB.getText());
        } catch (Exception e) {
            addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SUD_SGK);
            return false;
        }
        return true;
    }


    /**
     * Кнопка расчет прикидочный - синтез
     * @param actionEvent
     */
    public void actionCal_Restriction(ActionEvent actionEvent) {
        try {
            if (validateSimpleSintez()){
                calculationSimpSintez.calculation(calculationKA.getDataCommonParameters());
                showSimpleSintezResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR,"Не верно введенные данные!", TabTypeSintez.RESTRICTION);
        }
        showConsoleSintezDebug();
    }

    /**
     * Кнопка ОЕТК - синтез
     * @param actionEvent
     */
    public void actionCal_OETK(ActionEvent actionEvent) {
        try {
            if (validateOETK()){
                calculationOETK.calculation(calculationKA.getDataOETK());
                showOetkResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR,"Не верно введенные данные!", TabTypeSintez.OETK);
        }
        showConsoleSintezDebug();
    }

    /**
     * Кнопка расчет СГК - синтез
     * @param actionEvent
     */
    public void actionCal_SGK(ActionEvent actionEvent) {
        try {
            if (validateSGK()){
                calculationSGK.calculation(calculationKA.getDataSudSGK());
                showSgkResult();
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR,"Не верно введенные данные!", TabTypeSintez.SUD_SGK);
        }
        showConsoleSintezDebug();
    }


    private void showConsoleSintezDebug() {
        for (String error : messConsoleSintez) {
            consoleSimple.setText(consoleSimple.getText() + "\n" + error);
        }
    }

    public void actionSelectTypeSGK(ActionEvent actionEvent) {
        if (!typeSgk.isSelected()||!typeBdus.isSelected()){
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
}