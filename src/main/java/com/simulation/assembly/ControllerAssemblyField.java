package com.simulation.assembly;

import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.dataCalculation.simple.DataSimpleCalculation;
import com.simulation.assembly.dataCalculation.sintez.*;
import com.simulation.assembly.validateRestrictionSimple.ValidateRestriction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerAssemblyField {


    protected ValidateRestriction validateRestriction;
    protected Calculation<DataSimpleCalculation> calculationSimp;
    protected Calculation<DataCommonParameters> calculationSimpSintez;
    protected Calculation<DataOETK> calculationOETK;
    protected Calculation<DataSudSGK> calculationSGK;
    protected Calculation<DataSPPE> calculationSPPE;
    protected Calculation<DataVRL> calculationVRL;
    protected Calculation<DataOtherCA> calculationOtherCA;
    protected Calculation<DataCa> calculationCA;
    protected Calculation<DataSSKM> calculationSSKM;
    protected Calculation<DataSTKRP> calculationSTKRP;
    protected Calculation<DataBAKES> calculationBAKES;
    protected Calculation<DataBETS> calculationBETS;
    protected Calculation<DataBVS> calculationBVS;
    protected Calculation<DataOtherBKU> calculationOtherBKU;
    protected Calculation<DataBKU> calculationBKU;
    protected Calculation<DataPasivSOTR> calculationPasivSOTR;
    protected Calculation<DataActivSOTR> calculationActivSOTR;
    protected Calculation<DataSOTR> calculationSOTR;
    protected Calculation<DataElectHaraktSEP> calculationElectrTehnSEP;
    protected Calculation<DataAcumBetSEP> calculationAcumBet;
    protected Calculation<DataKAS> calculationKAS;
    protected Calculation<DataSumBetSEP> calculationSUNbet;
    protected Calculation<DataSpeed> calculationSpeed;
    protected Calculation<DataMassTopl> calculationMTop;
    protected Calculation<DataKDU> calculationKDU;
    protected Calculation<DataKonstrKA> calculationKonstrKA;
    protected Calculation<DataBKSandAFU> calculationBKSandAFU;
    protected Calculation<DataOtherKA> calculationOtherKA;
    protected Calculation<DataRezervKA> calculationRezerv;

    protected DataSimpleCalculation dataSimpleCalculation = new DataSimpleCalculation();


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
    public TextField iN_udlKA1;

    @FXML
    public TextField iN_nonRes_udlKA;
    @FXML
    public TextField iN_nonRes_krkKA;
    @FXML
    public TextField iN_nonRes_kpoPO;

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

    /**
     * таба СППИ
     */
    @FXML
    public TextField sPISPPI;
    @FXML
    public TextField umSPPI;
    @FXML
    public TextField uwSPPI;
    @FXML
    public TextField plSPPI;

    @FXML
    public Label mSPPI;
    @FXML
    public Label vSPPI;
    @FXML
    public Label wSPPI;
    @FXML
    public Label jSPPI;

    /**
     * таба ВРЛ
     */
    @FXML
    public TextField sPI;
    @FXML
    public TextField umVRL;
    @FXML
    public TextField uwVRL;
    @FXML
    public TextField plVRL;

    @FXML
    public Label mVRL;
    @FXML
    public Label vVRL;
    @FXML
    public Label wVRL;
    @FXML
    public Label jVRL;

    /**
     * таба Прочие элементы ЦА
     */
    @FXML
    public TextField kPrZA;
    @FXML
    public TextField uwPrZA;
    @FXML
    public TextField plPrZA;

    @FXML
    public Label mPrZA;
    @FXML
    public Label vPrZA;
    @FXML
    public Label wPrZA;
    @FXML
    public Label jPrZA;

    /**
     * таба результаты ца
     */
    @FXML
    public Label mZA;
    @FXML
    public Label vZA;
    @FXML
    public Label jZA;
    @FXML
    public Label wZA;

    /**
     * таба ССКМ
     */
    @FXML
    public TextField kmSSKM;
    @FXML
    public TextField uwSSKM;
    @FXML
    public TextField kmsSSKM;
    @FXML
    public TextField plaSSKM;
    @FXML
    public TextField plsSSKM;
    @FXML
    public TextField kzsSSKM;
    @FXML
    public Label mSSKM;
    @FXML
    public Label maSSKM;
    @FXML
    public Label msSSKM;
    @FXML
    public Label vaSSKM;
    @FXML
    public Label vsSSKM;
    @FXML
    public Label wSSKM;
    @FXML
    public Label jSSKM;

    /**
     * таба СТКРП
     */
    @FXML
    public TextField kmSTKRP;
    @FXML
    public TextField uwSTKRP;
    @FXML
    public TextField plSTKRP;
    @FXML
    public Label mSTKRP;
    @FXML
    public Label vSTKRP;
    @FXML
    public Label wSTKRP;
    @FXML
    public Label jSTKRP;

    /**
     * таба КИС
     */
    @FXML
    public TextField kmKIS;
    @FXML
    public TextField uwKIS;
    @FXML
    public TextField plKIS;
    @FXML
    public Label mKIS;
    @FXML
    public Label vKIS;
    @FXML
    public Label wKIS;
    @FXML
    public Label jKIS;

    /**
     * таба БИТС
     */
    @FXML
    public TextField kmBITS;
    @FXML
    public TextField uwBITS;
    @FXML
    public TextField plBITS;
    @FXML
    public Label mBITS;
    @FXML
    public Label vBITS;
    @FXML
    public Label wBITS;
    @FXML
    public Label jBITS;

    /**
     * таба БВС
     */
    @FXML
    public TextField kmBVS;
    @FXML
    public TextField uwBVS;
    @FXML
    public TextField plBVS;
    @FXML
    public Label mBVS;
    @FXML
    public Label vBVS;
    @FXML
    public Label wBVS;
    @FXML
    public Label jBVS;

    /**
     * таба прочие БКУ
     */
    @FXML
    public TextField kPrBKU;
    @FXML
    public TextField uwPrBKU;
    @FXML
    public TextField plPrBKU;
    @FXML
    public Label mPrBKU;
    @FXML
    public Label vPrBKU;
    @FXML
    public Label wPrBKU;
    @FXML
    public Label jPrBKU;

    /**
     * таба расчет БКУ
     */
    @FXML
    public Label mZAbku;
    @FXML
    public Label vZAbku;
    @FXML
    public Label jZAbku;
    @FXML
    public Label wZAbku;

    /**
     * таба пасивные элементы СОТР
     */
    @FXML
    public TextField umEVTI;
    @FXML
    public TextField tEVTI;
    @FXML
    public TextField kpEVTI;
    @FXML
    public Label sKA;
    @FXML
    public Label sEVTI;
    @FXML
    public Label mEVTI;
    @FXML
    public Label vEVTI;
    @FXML
    public Label jEVTI;

    /**
     * таба активные элементы СОТР
     */
    @FXML
    public TextField omSTR;
    @FXML
    public TextField plSTR;
    @FXML
    public TextField uwSTR;
    @FXML
    public TextField kmtnSTR;
    @FXML
    public Label mSTR;
    @FXML
    public Label mSTRbtn;
    @FXML
    public Label mtnSTRact;
    @FXML
    public Label vSTR;
    @FXML
    public Label wSTRact;
    @FXML
    public Label jSTR;

    /**
     * таба расчет СОТР
     */
    @FXML
    public Label mSOTR;
    @FXML
    public Label mSOTRbtn;
    @FXML
    public Label mtnSTR;
    @FXML
    public Label vSOTR;
    @FXML
    public Label jSOTR;
    @FXML
    public Label wSTR;


    /**
     * таба Электротехнические характеристики СЭП
     */
    @FXML
    public TextField wNomInCep;
    @FXML
    public TextField kspSEP;
    @FXML
    public TextField TobrKA;
    @FXML
    public TextField tZRKA;
    @FXML
    public TextField kpdKAS;
    @FXML
    public TextField kpdAB;
    @FXML
    public TextField srU;
    @FXML
    public TextField kpdZU;
    @FXML
    public TextField kpdRU;
    @FXML
    public TextField kzAC;
    @FXML
    public TextField kzSR;
    @FXML
    public TextField kdowAB;
    @FXML
    public Label wsSEP;
    @FXML
    public Label wKA;
    @FXML
    public Label CosA;
    @FXML
    public Label wBF;
    @FXML
    public Label Imax;
    @FXML
    public Label wKAten;
    @FXML
    public Label wKAZR;
    @FXML
    public Label eAB;
    @FXML
    public Label cABmin;
    @FXML
    public Label cAB;
    @FXML
    public Label cAB_AS;

    /**
     * таба Аккумуляторные батареи
     */
    @FXML
    public TextField uwAB;
    @FXML
    public TextField nAB;
    @FXML
    public TextField plAB;
    @FXML
    public Label mAB;
    @FXML
    public Label mAB1;
    @FXML
    public Label vAB1;
    @FXML
    public Label vAB;
    @FXML
    public Label lAB;
    @FXML
    public Label jAB1;
    @FXML
    public Label jAB_KA;

    /**
     * таба КАС
     */
    @FXML
    public TextField uwSN;
    @FXML
    public TextField plSN;
    @FXML
    public TextField uwZU;
    @FXML
    public TextField plZU;
    @FXML
    public TextField uwRU;
    @FXML
    public TextField plRU;
    @FXML
    public TextField kKAS;
    @FXML
    public TextField ProzV_vKAS;
    @FXML
    public Label mSN;
    @FXML
    public Label vSN;
    @FXML
    public Label mZU;
    @FXML
    public Label vZU;
    @FXML
    public Label mRU;
    @FXML
    public Label vRU;
    @FXML
    public Label mKAS;
    @FXML
    public Label vKAS;
    @FXML
    public Label mKASsum;
    @FXML
    public Label vKASsum;
    @FXML
    public Label jKASsum;

    /**
     * таба Солнечная батаре
     */
    @FXML
    public TextField uwFP;
    @FXML
    public TextField kzPSB;
    @FXML
    public TextField kp;
    @FXML
    public TextField umPSB;
    @FXML
    public TextField nPSB;
    @FXML
    public Label sPSB;
    @FXML
    public Label mPSB;
    @FXML
    public Label sPSB1;
    @FXML
    public Label mPSB1;
    @FXML
    public Label lPSB1;
    @FXML
    public Label dPSB1;
    @FXML
    public Label jPSB1;
    @FXML
    public Label jPSB_KA;

    /**
     * таба Характеристическая скорость
     */
    @FXML
    public TextField Hp;
    @FXML
    public TextField iRN;
    @FXML
    public TextField Ha;
    @FXML
    public TextField iKA;
    @FXML
    public TextField dV6;
    @FXML
    public Label dV1;
    @FXML
    public Label dV2;
    @FXML
    public Label dV3;
    @FXML
    public Label dV4;
    @FXML
    public Label dV5;
    @FXML
    public Label dV;

    /**
     * таба Масса топлива
     */
    @FXML
    public TextField nameGoruchee;
    @FXML
    public TextField nameOkis;
    @FXML
    public TextField pLG;
    @FXML
    public TextField pLO;
    @FXML
    public TextField jT;
    @FXML
    public TextField kOG;
    @FXML
    public TextField knt;
    @FXML
    public TextField kgzt;
    @FXML
    public TextField Tak;
    @FXML
    public TextField Tas;
    @FXML
    public TextField mTKDUskm1;
    @FXML
    public Label mTKAx;
    @FXML
    public Label mTKAxnzg;
    @FXML
    public Label mTKDU;
    @FXML
    public Label mO;
    @FXML
    public Label mG;

    /**
     * таба Массогабаритные и энергетические характеристики
     */
    @FXML
    public TextField s;
    @FXML
    public TextField kNTB;
    @FXML
    public TextField kpVKDU_Vb;
    @FXML
    public TextField kpVOKA_VKDU;
    @FXML
    public TextField dKDU;
    @FXML
    public TextField umKDU;
    @FXML
    public Label mKDU;
    @FXML
    public Label mkKDU;
    @FXML
    public Label Vok;
    @FXML
    public Label Vg;
    @FXML
    public Label VbOk;
    @FXML
    public Label VbG;
    @FXML
    public Label Vb;
    @FXML
    public Label VKDU;
    @FXML
    public Label V_OKA_KDU;
    @FXML
    public Label hKDU;
    @FXML
    public Label pKDU;
    @FXML
    public Label JxKDU;
    @FXML
    public Label JyKDU;
    @FXML
    public Label jKDU;
    @FXML
    public Label wKDU;

    /**
     * таба Конструкция
     */
    @FXML
    public TextField omkKA;
    @FXML
    public TextField plmkKA;
    @FXML
    public TextField kpkKA;
    @FXML
    public Label mkKA;
    @FXML
    public Label vkKA;
    @FXML
    public Label jkKA;

    /**
     * таба БКС и АФУ
     */
    @FXML
    public TextField omBKS;
    @FXML
    public TextField omAFU;
    @FXML
    public TextField plBKS;
    @FXML
    public TextField plAFU;
    @FXML
    public Label mBKS;
    @FXML
    public Label vBKS;
    @FXML
    public Label mAFU;
    @FXML
    public Label vAFU;
    @FXML
    public Label mBKS_AFU;
    @FXML
    public Label vBKS_AFU;
    @FXML
    public Label jBKS;
    @FXML
    public Label jAFU;

    /**
     * таба Прочие элементы КА
     */
    @FXML
    public TextField omPrKA;
    @FXML
    public TextField plPrKA;
    @FXML
    public TextField uwPrKA;
    @FXML
    public Label mPrKA;
    @FXML
    public Label vPrKA;
    @FXML
    public Label jPrKA;
    @FXML
    public Label wPrKA;


    public TextField In_nameElement;
    public TableView tableOtherKA;
    public TableColumn<ViewDataOtherKA, String> columnOtherKAname;
    public TableColumn<ViewDataOtherKA, String> columnOtherKAm;
    public TableColumn<ViewDataOtherKA, String> columnOtherKAv;
    public TableColumn<ViewDataOtherKA, String> columnOtherKAw;
    public TableColumn<ViewDataOtherKA, String> columnOtherKAj;

    /**
     * таба Резерв
     */
    @FXML
    public TextField omRmKA;
    @FXML
    public TextField plRmKA;
    @FXML
    public TextField uwRmKA;
    @FXML
    public Label mRmKA;
    @FXML
    public Label vRmKA;
    @FXML
    public Label jRmKA;
    @FXML
    public Label wRmKA;

    @FXML
    public Label rez_simple_KA_mass;
    @FXML
    public Label rez_simple_KA_v;
    @FXML
    public Label rez_simple_KA_l;
    @FXML
    public Label rez_simple_KA_mom;
    @FXML
    public Label rez_simple_KA_d;
    @FXML
    public Label rez_simple_KA_pl;
    @FXML
    public Label rez_KA_massa;
    @FXML
    public Label rez_KA_v;
    @FXML
    public Label rez_KA_l;
    @FXML
    public Label rez_KA_mom;
    @FXML
    public Label rez_KA_d;
    @FXML
    public Label ouT_jKA0111;
    @FXML
    public Label col_iteration;

    public Label labelZaimOetk;
    public Label labelZaimSppe;
    public Label labelZaimVrl;
    public Label labelZaimOtherCA;
    public Label labelZaimSgk;
    public Label labelZaimSSKM;
    public Label labelZaimStkrp;
    public Label labelZaimBaKis;
    public Label labelZaimBets;
    public Label labelZaimBvs;
    public Label labelZaimOtherBku;
    public Label labelZaimPasivSotr;
    public Label labelZaimActivSotr;
    public Label labelZaimElHarSep;
    public Label labelZaimAcumBet;
    public Label labelZaimKas;
    public Label labelZaimSunBet;
    public Label labelZaimSpeed;
    public Label labelZaimMassT;
    public Label labelZaimKDU;
    public Label labelZaimKonstr;
    public Label labelZaimBksAndAfu;
    public Label labelZaimRezerv;

    public ImageView onStepOkRestr;
    public ImageView onStepAskRestr;
    public ImageView onStepOkOetk;
    public ImageView onStepAskOetk;
    public ImageView onStepOkSppe;
    public ImageView onStepAskSppe;
    public ImageView onStepOkVrl;
    public ImageView onStepAskVrl;
    public ImageView onStepOkOtherCa;
    public ImageView onStepAskOtherCa;
    public ImageView onStepOkCa;
    public ImageView onStepAskCa;

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
            ControllerAssembly.getInstance().onProgressRestr(false);
        } else {
            paneRestriction.setVisible(false);
            paneStartDataRestriction.setVisible(true);
            paneRestrictionCalculation.setVisible(false);
            ControllerAssembly.getInstance().onProgressRestr(true);
        }
    }


}
