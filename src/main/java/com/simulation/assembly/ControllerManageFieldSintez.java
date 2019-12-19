package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataOtherKA;
import com.simulation.assembly.dataCalculation.sintez.ViewDataOtherKA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ControllerManageFieldSintez extends ControllerAssemblyField {


    /**
     * показать результаты прикидочного расчета
     */
    public void showSimpleSintezResult() {
        ouT_dKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().dKA0));
        ouT_lKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().lKA0));
        ouT_splkKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().splkKA0));
        ouT_jKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().jKA0));
        ouT_vKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().vKA0));
    }

    /**
     * показать расчета КА
     */
    public void showSinezKA() {
        rez_simple_KA_mass.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().mKA0));
        rez_simple_KA_d.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().dKA0));
        rez_simple_KA_l.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().lKA0));
        rez_simple_KA_pl.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().splkKA0));
        rez_simple_KA_mom.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().jKA0));
        rez_simple_KA_v.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().vKA0));

        rez_KA_massa.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().mKA));
        rez_KA_v.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().vKA));
        rez_KA_d.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().dKA));
        rez_KA_l.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().lKA));
        rez_KA_mom.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().jKA));
        ouT_jKA0111.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().wKA_wsSEP));
    }

    /**
     * показать результаты ОЕТК
     */
    public void showOetkResult() {
        ouT_lOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_lOETK));
        ouT_dOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_dOETK));
        ouT_mOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().m));
        ouT_vOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().v));
        ouT_jOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().j));
        ouT_wOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().w));
        ouT_Dgl_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_Dgl_OETK));
        ouT_Dvt_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_Dvt_OETK));
        ouT_f_ecv_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_f_ecv_OETK));
        ouT_f1_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_f1_OETK));
        ouT_f2_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_f2_OETK));
        ouT_Lpzs_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_Lpzs_OETK));
        ouT_r1_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_r1_OETK));
        ouT_d1_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_d1_OETK));
        ouT_d2_OETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_d2_OETK));
        ouT_S2_OETK1.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_S2_OETK1));
        ouT_d_OETK11.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().ouT_d_OETK11));
    }

    /**
     * показать результаты СППИ
     */
    public void showSPEEResult() {
        mSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().m));
        vSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().v));
        wSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().w));
        jSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().j));
    }

    /**
     * показать результаты ВРЛ
     */
    public void showVRLResult() {
        mVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().m));
        vVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().v));
        wVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().w));
        jVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().j));
    }

    /**
     * показать результаты Прочие элементы ЦА
     */
    public void showOtherCAResult() {
        mPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().m));
        vPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().v));
        wPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().w));
        jPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().j));
    }

    /**
     * показать результаты ЦА
     */
    public void showCAResult() {
        mZA.setText(String.valueOf(CalculationKA.getInstance().getDataCa().m));
        vZA.setText(String.valueOf(CalculationKA.getInstance().getDataCa().v));
        jZA.setText(String.valueOf(CalculationKA.getInstance().getDataCa().j));
        wZA.setText(String.valueOf(CalculationKA.getInstance().getDataCa().w));
    }

    /**
     * показать результаты СГК
     */
    public void showSgkResult() {
        ouT_t1.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().t1));
        ouT_eKA.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().eKA));
        ouT_wKA.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().wKA));
        ouT_umKA.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().umKA));
        ouT_kmKA.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().kmKA));
        ouT_kmRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().kmRGP));
        ouT_JRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().JRGP));

        ouT_rRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().rRGP));
        ouT_vRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().vRGP));
        ouT_mRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().mRGP));
        ouT_mGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().mGP));

        ouT_mEB.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().mEB));
        ouT_mEB_GP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().mEB_GP));
        ouT_mSGK.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().m));

        ouT_vGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().vGP));
        ouT_vEB.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().vEB));
        ouT_wSGK.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().w));
        ouT_dGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().dGP));
    }

    /**
     * показать результаты ССКМ
     */
    public void showSSKMResult() {
        mSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().m));
        maSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().maSSKM));
        msSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().msSSKM));
        vaSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().vaSSKM));
        vsSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().vsSSKM));
        wSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().w));
        jSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().j));
    }

    /**
     * показать результаты СТКРП
     */
    public void showSTKRPResult() {
        mSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().m));
        vSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().v));
        wSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().w));
        jSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().j));
    }

    /**
     * показать результаты БА КИС
     */
    public void showKISResult() {
        mKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().m));
        vKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().v));
        wKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().w));
        jKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().j));
    }

    /**
     * показать результаты БИТС
     */
    public void showBETSResult() {
        mBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().m));
        vBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().v));
        wBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().w));
        jBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().j));
    }

    /**
     * показать результаты БВС
     */
    public void showBVSResult() {
        mBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().m));
        vBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().v));
        wBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().w));
        jBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().j));
    }

    /**
     * показать результаты прочие элементы БКУ
     */
    public void showOtherBKUResult() {
        mPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().m));
        vPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().v));
        wPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().w));
        jPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().j));
    }

    /**
     * показать результаты БКУ
     */
    public void showBKUResult() {
        mZAbku.setText(String.valueOf(CalculationKA.getInstance().getDataBKU().m));
        vZAbku.setText(String.valueOf(CalculationKA.getInstance().getDataBKU().v));
        jZAbku.setText(String.valueOf(CalculationKA.getInstance().getDataBKU().j));
        wZAbku.setText(String.valueOf(CalculationKA.getInstance().getDataBKU().w));
    }

    /**
     * показать результаты пасивные элементы СОТР
     */
    public void showPasivSOTRResult() {
        sKA.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().sKA));
        sEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().sEVTI));
        mEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().m));
        vEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().v));
        jEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().j));
    }

    /**
     * показать результаты активных элементы СОТР
     */
    public void showActivSOTRResult() {
        mSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().m));
        mSTRbtn.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().mSTRbtn));
        mtnSTRact.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().mtnSTR));
        vSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().v));
        wSTRact.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().w));
        jSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().j));
    }

    /**
     * показать результаты СОТР
     */
    public void showSOTRResult() {
        mSOTR.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().mSOTR));
        mSOTRbtn.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().mSOTRbtn));
        mtnSTR.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().mtnSTR));
        vSOTR.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().vSOTR));
        jSOTR.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().j));
        wSTR.setText(String.valueOf(CalculationKA.getInstance().getDataSOTR().wSTR));
    }

    /**
     * показать электротехнические характеристики СЭП
     */
    public void showElectTehHarakSEPResult() {
        wsSEP.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wsSEP));
        wKA.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wKA));
        CosA.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().CosA));
        wBF.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wBF));
        Imax.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().Imax));
        wKAten.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wKAten));
        wKAZR.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wKAZR));
        eAB.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().eAB));
        cABmin.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().cABmin));
        cAB.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().cAB));
        cAB_AS.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().cAB_AS));
    }

    /**
     * показать Акамуляторные батареи
     */
    public void showAcumBat() {
        mAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().m));
        mAB1.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().mAB1));
        vAB1.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().vAB1));
        vAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().v));
        lAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().lAB));
        jAB1.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().jAB1));
        jAB_KA.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().j));
    }

    /**
     * показать КАС
     */
    public void showKAS() {
        mSN.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().mSN));
        vSN.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().vSN));
        mZU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().mZU));
        vZU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().vZU));
        mRU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().mRU));
        vRU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().vRU));
        mKAS.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().mKAS));
        vKAS.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().vKAS));
        mKASsum.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().m));
        vKASsum.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().v));
        jKASsum.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().j));
    }

    /**
     * показать солнечные батареии
     */
    public void showSunBet() {
        sPSB.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().sPSB));
        mPSB.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().m));
        sPSB1.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().sPSB1));
        mPSB1.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().mPSB1));
        lPSB1.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().lPSB1));
        dPSB1.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().dPSB1));
        jPSB1.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().jPSB1));
        jPSB_KA.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().j));
    }

    /**
     * показать характеристическая скорость
     */
    public void showSpeed() {
        dV1.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV1));
        dV2.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV2));
        dV3.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV3));
        dV4.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV4));
        dV5.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV5));
        dV.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV));
    }

    /**
     * показать масса топлива
     */
    public void showMassTopl() {
        mTKAx.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().mTKAx));
        mTKAxnzg.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().mTKAxnzg));
        mTKDU.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().m));
        mO.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().mO));
        mG.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().mG));

    }

    /**
     * показать Массогабаритные и энергетические характеристики КДУ
     */
    public void showKDU() {
        mKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().mKDU));
        mkKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().m));
        Vok.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().Vok));
        Vg.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().Vg));
        VbOk.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().VbOk));
        VbG.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().VbG));
        Vb.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().Vb));
        VKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().VKDU));
        V_OKA_KDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().v));
        hKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().hKDU));
        pKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().pKDU));
        JxKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().JxKDU));
        JyKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().JyKDU));
        jKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().j));
        wKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().w));

    }

    /**
     * показать Конструкция
     */
    public void showKonstrKA() {
        mkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().m));
        vkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().v));
        jkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().j));

    }

    /**
     * показать БКС и АФУ
     */
    public void showBKSandAFU() {
        mBKS.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().mBKS));
        vBKS.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().vBKS));
        mAFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().mAFU));
        vAFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().vAFU));
        mBKS_AFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().m));
        vBKS_AFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().v));
        jBKS.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().jBKS));
        jAFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().jAFU));

    }

    /**
     * показать прочие элементы КА
     */
    public void showOtherKA() {
        mPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().m));
        vPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().v));
        jPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().j));
        wPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().w));

    }

    /**
     * показать резерв
     */
    public void showRezerv() {
        mRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().m));
        vRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().v));
        jRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().j));
        wRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().w));

    }

    public void showALL() {

        showSimpleSintezResult();
        showSinezKA();
        showOetkResult();
        showSPEEResult();
        showVRLResult();
        showOtherCAResult();
        showCAResult();
        showSgkResult();
        showSSKMResult();
        showSTKRPResult();
        showKISResult();
        showBETSResult();
        showBVSResult();
        showOtherBKUResult();
        showBKUResult();
        showPasivSOTRResult();
        showActivSOTRResult();
        showSOTRResult();
        showElectTehHarakSEPResult();
        showAcumBat();
        showKAS();
        showSunBet();
        showSpeed();
        showMassTopl();
        showKDU();
        showKonstrKA();
        showBKSandAFU();
        showOtherKA();
        showRezerv();
    }


    /**
     * ввод Ограничения
     *
     * @return
     */
    public boolean validateSimpleSintez() {
        try {
            CalculationKA.getInstance().getDataCommonParameters().isHaveRestriction = isHaveRestriction.isSelected();
            if (isHaveRestriction.isSelected()) {
                CalculationKA.getInstance().getDataCommonParameters().mKA0 = ValidateValue.conversionTextToFloat(iN_mKA0.getText());
                CalculationKA.getInstance().getDataCommonParameters().dzPN0 = ValidateValue.conversionTextToFloat(iN_dzPN0.getText());
                CalculationKA.getInstance().getDataCommonParameters().lzPN0 = ValidateValue.conversionTextToFloat(iN_lzPN0.getText());
                CalculationKA.getInstance().getDataCommonParameters().knzpOBT = ValidateValue.conversionTextToFloat(iN_knzpOBT.getText());
                CalculationKA.getInstance().getDataCommonParameters().krkKA = ValidateValue.conversionTextToFloat(iN_krkKA.getText());
                CalculationKA.getInstance().getDataCommonParameters().kpoPO = ValidateValue.conversionTextToFloat(String.valueOf(iN_kpoPO.getText()));
                CalculationKA.getInstance().getDataCommonParameters().udlKA = ValidateValue.conversionTextToFloat(iN_udlKA1.getText());
            } else {
                CalculationKA.getInstance().getDataCommonParameters().udlKA = ValidateValue.conversionTextToFloat(iN_nonRes_udlKA.getText());
                CalculationKA.getInstance().getDataCommonParameters().krkKA = ValidateValue.conversionTextToFloat(iN_nonRes_krkKA.getText());
                CalculationKA.getInstance().getDataCommonParameters().kpoPO = ValidateValue.conversionTextToFloat(String.valueOf(iN_nonRes_kpoPO.getText()));
            }
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.RESTRICTION);
            return false;
        }
        return true;
    }

    /**
     * ввод ОЭТК
     *
     * @return
     */
    public boolean validateOETK() {
        try {
            CalculationKA.getInstance().getDataOETK().iN_Lm = ValidateValue.conversionTextToFloat(iN_Lm.getText());
            CalculationKA.getInstance().getDataOETK().iN_H = ValidateValue.conversionTextToFloat(iN_H.getText());
            CalculationKA.getInstance().getDataOETK().iN_Delta = ValidateValue.conversionTextToFloat(iN_Delta.getText());
            CalculationKA.getInstance().getDataOETK().iN_k0 = ValidateValue.conversionTextToFloat(iN_k0.getText());
            CalculationKA.getInstance().getDataOETK().iN_q = ValidateValue.conversionTextToFloat(iN_q.getText());
            CalculationKA.getInstance().getDataOETK().iN_uwOETK = ValidateValue.conversionTextToFloat(iN_uwOETK.getText());
            CalculationKA.getInstance().getDataOETK().iN_kUD = ValidateValue.conversionTextToFloat(iN_kUD.getText());
            CalculationKA.getInstance().getDataOETK().iN_kp2dOETK = ValidateValue.conversionTextToFloat(iN_kp2dOETK.getText());
            CalculationKA.getInstance().getDataOETK().iN_kp2lOETK = ValidateValue.conversionTextToFloat(iN_kp2lOETK.getText());
            CalculationKA.getInstance().getDataOETK().iN_yr = ValidateValue.conversionTextToFloat(iN_yr.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.OETK);
            return false;
        }
        return true;
    }

    /**
     * ввод СППИ
     *
     * @return
     */
    public boolean validateSPPE() {
        try {
            CalculationKA.getInstance().getDataSPPE().sPI = ValidateValue.conversionTextToFloat(sPISPPI.getText());
            CalculationKA.getInstance().getDataSPPE().umSPPI = ValidateValue.conversionTextToFloat(umSPPI.getText());
            CalculationKA.getInstance().getDataSPPE().uwSPPI = ValidateValue.conversionTextToFloat(uwSPPI.getText());
            CalculationKA.getInstance().getDataSPPE().plSPPI = ValidateValue.conversionTextToFloat(plSPPI.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SPPE);
            return false;
        }
        return true;
    }

    /**
     * ввод ВРЛ
     *
     * @return
     */
    public boolean validateVRL() {
        try {
            CalculationKA.getInstance().getDataVRL().sPI = ValidateValue.conversionTextToFloat(sPI.getText());
            CalculationKA.getInstance().getDataVRL().umVRL = ValidateValue.conversionTextToFloat(umVRL.getText());
            CalculationKA.getInstance().getDataVRL().uwVRL = ValidateValue.conversionTextToFloat(uwVRL.getText());
            CalculationKA.getInstance().getDataVRL().plVRL = ValidateValue.conversionTextToFloat(plVRL.getText());
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.VRL);
            return false;
        }
        return true;
    }

    /**
     * ввод Прочие элементы ЦА
     *
     * @return
     */
    public boolean validateOtherCA() {
        try {
            CalculationKA.getInstance().getDataOtherCA().kPrZA = ValidateValue.conversionTextToFloat(kPrZA.getText());
            CalculationKA.getInstance().getDataOtherCA().uwPrZA = ValidateValue.conversionTextToFloat(uwPrZA.getText());
            CalculationKA.getInstance().getDataOtherCA().plPrZA = ValidateValue.conversionTextToFloat(plPrZA.getText());
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.OTHER_ELEMENTS_CA);
            return false;
        }
        return true;
    }

    /**
     * ввод СГК
     *
     * @return
     */
    public boolean validateSGK() {
        try {
            CalculationKA.getInstance().getDataSudSGK().Pr1 = ValidateValue.conversionTextToFloat(iN_Pr1.getText());
            CalculationKA.getInstance().getDataSudSGK().Tzr = ValidateValue.conversionTextToFloat(iN_Tzr.getText());
            CalculationKA.getInstance().getDataSudSGK().uKA = ValidateValue.conversionTextToFloat(iN_uKA.getText());
            CalculationKA.getInstance().getDataSudSGK().wPrez = ValidateValue.conversionTextToFloat(iN_wPrez.getText());
            CalculationKA.getInstance().getDataSudSGK().wRGP = ValidateValue.conversionTextToFloat(iN_wRGP.getText());
            CalculationKA.getInstance().getDataSudSGK().plRGP = ValidateValue.conversionTextToFloat(iN_plRGP.getText());
            CalculationKA.getInstance().getDataSudSGK().kmGP_RGP = ValidateValue.conversionTextToFloat(iN_kmGP_RGP.getText());
            CalculationKA.getInstance().getDataSudSGK().kmEB_mGP = ValidateValue.conversionTextToFloat(iN_kmEB_mGP.getText());
            CalculationKA.getInstance().getDataSudSGK().uW_SGK = ValidateValue.conversionTextToFloat(iN_uW_SGK.getText());
            CalculationKA.getInstance().getDataSudSGK().pEB = ValidateValue.conversionTextToFloat(iN_pEB.getText());
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SUD_SGK);
            return false;
        }
        return true;
    }

    /**
     * ввод ССКМ
     *
     * @return
     */
    public boolean validateSSKM() {
        try {
            CalculationKA.getInstance().getDataSSKM().kmSSKM = ValidateValue.conversionTextToFloat(kmSSKM.getText());
            CalculationKA.getInstance().getDataSSKM().uwSSKM = ValidateValue.conversionTextToFloat(uwSSKM.getText());
            CalculationKA.getInstance().getDataSSKM().kmsSSKM = ValidateValue.conversionTextToFloat(kmsSSKM.getText());
            CalculationKA.getInstance().getDataSSKM().plaSSKM = ValidateValue.conversionTextToFloat(plaSSKM.getText());
            CalculationKA.getInstance().getDataSSKM().plsSSKM = ValidateValue.conversionTextToFloat(plsSSKM.getText());
            CalculationKA.getInstance().getDataSSKM().kzsSSKM = ValidateValue.conversionTextToFloat(kzsSSKM.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SUD_SSKM);
            return false;
        }
        return true;
    }

    /**
     * ввод СТКРП
     *
     * @return
     */
    public boolean validateSTKRP() {
        try {
            CalculationKA.getInstance().getDataSTKRP().kmSTKRP = ValidateValue.conversionTextToFloat(kmSTKRP.getText());
            CalculationKA.getInstance().getDataSTKRP().uwSTKRP = ValidateValue.conversionTextToFloat(uwSTKRP.getText());
            CalculationKA.getInstance().getDataSTKRP().plSTKRP = ValidateValue.conversionTextToFloat(plSTKRP.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.STKRP);
            return false;
        }
        return true;
    }

    /**
     * ввод БА КИС
     *
     * @return
     */
    public boolean validateBAKES() {
        try {
            CalculationKA.getInstance().getDataBAKES().kmKIS = ValidateValue.conversionTextToFloat(kmKIS.getText());
            CalculationKA.getInstance().getDataBAKES().uwKIS = ValidateValue.conversionTextToFloat(uwKIS.getText());
            CalculationKA.getInstance().getDataBAKES().plKIS = ValidateValue.conversionTextToFloat(plKIS.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.BAKIS);
            return false;
        }
        return true;
    }

    /**
     * ввод БИТС
     *
     * @return
     */
    public boolean validateBETS() {
        try {
            CalculationKA.getInstance().getDataBETS().kmBITS = ValidateValue.conversionTextToFloat(kmBITS.getText());
            CalculationKA.getInstance().getDataBETS().uwBITS = ValidateValue.conversionTextToFloat(uwBITS.getText());
            CalculationKA.getInstance().getDataBETS().plBITS = ValidateValue.conversionTextToFloat(plBITS.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.BETS);
            return false;
        }
        return true;
    }

    /**
     * ввод БВС
     *
     * @return
     */
    public boolean validateBVS() {
        try {
            CalculationKA.getInstance().getDataBVS().kmBVS = ValidateValue.conversionTextToFloat(kmBVS.getText());
            CalculationKA.getInstance().getDataBVS().uwBVS = ValidateValue.conversionTextToFloat(uwBVS.getText());
            CalculationKA.getInstance().getDataBVS().plBVS = ValidateValue.conversionTextToFloat(plBVS.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.BVS);
            return false;
        }
        return true;
    }

    /**
     * ввод прочие элементы БКУ
     *
     * @return
     */
    public boolean validateOtherBKU() {
        try {
            CalculationKA.getInstance().getDataOtherBKU().kPrBKU = ValidateValue.conversionTextToFloat(kPrBKU.getText());
            CalculationKA.getInstance().getDataOtherBKU().uwPrBKU = ValidateValue.conversionTextToFloat(uwPrBKU.getText());
            CalculationKA.getInstance().getDataOtherBKU().plPrBKU = ValidateValue.conversionTextToFloat(plPrBKU.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.OTHER_ELEMENTS_BKU);
            return false;
        }
        return true;
    }


    /**
     * ввод пасивные элементы СОТР
     *
     * @return
     */
    public boolean validatePasivSOTR() {
        try {
            CalculationKA.getInstance().getDataPasivSOTR().umEVTI = ValidateValue.conversionTextToFloat(umEVTI.getText());
            CalculationKA.getInstance().getDataPasivSOTR().tEVTI = ValidateValue.conversionTextToFloat(tEVTI.getText());
            CalculationKA.getInstance().getDataPasivSOTR().kpEVTI = ValidateValue.conversionTextToFloat(kpEVTI.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.PASSIV_ELEMENT_SOTR);
            return false;
        }
        return true;
    }

    /**
     * ввод активные элементы СОТР
     *
     * @return
     */
    public boolean validateActivSOTR() {
        try {
            CalculationKA.getInstance().getDataActivSOTR().omSTR = ValidateValue.conversionTextToFloat(omSTR.getText());
            CalculationKA.getInstance().getDataActivSOTR().plSTR = ValidateValue.conversionTextToFloat(plSTR.getText());
            CalculationKA.getInstance().getDataActivSOTR().uwSTR = ValidateValue.conversionTextToFloat(uwSTR.getText());
            CalculationKA.getInstance().getDataActivSOTR().kmtnSTR = ValidateValue.conversionTextToFloat(kmtnSTR.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.ACTIV_ELEMENT_SOTR);
            return false;
        }
        return true;
    }

    /**
     * ввод электротехнические характеристики СЭП
     *
     * @return
     */
    public boolean validateElectTehHarakSEP() {
        try {
            CalculationKA.getInstance().getDataElectHaraktSEP().wNomInCep = ValidateValue.conversionTextToFloat(wNomInCep.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kspSEP = ValidateValue.conversionTextToFloat(kspSEP.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().TobrKA = ValidateValue.conversionTextToFloat(TobrKA.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().tZRKA = ValidateValue.conversionTextToFloat(tZRKA.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kpdKAS = ValidateValue.conversionTextToFloat(kpdKAS.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kpdAB = ValidateValue.conversionTextToFloat(kpdAB.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().srU = ValidateValue.conversionTextToFloat(srU.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kpdZU = ValidateValue.conversionTextToFloat(kpdZU.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kpdRU = ValidateValue.conversionTextToFloat(kpdRU.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kzAC = ValidateValue.conversionTextToFloat(kzAC.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kzSR = ValidateValue.conversionTextToFloat(kzSR.getText());
            CalculationKA.getInstance().getDataElectHaraktSEP().kdowAB = ValidateValue.conversionTextToFloat(kdowAB.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.ELECTROTEH_PARAM);
            return false;
        }
        return true;
    }

    /**
     * ввод  Акамуляторные батареи
     *
     * @return
     */
    public boolean validateAcumBat() {
        try {
            CalculationKA.getInstance().getDataAcumBetSEP().uwAB = ValidateValue.conversionTextToFloat(uwAB.getText());
            CalculationKA.getInstance().getDataAcumBetSEP().nAB = ValidateValue.conversionTextToFloat(nAB.getText());
            CalculationKA.getInstance().getDataAcumBetSEP().plAB = ValidateValue.conversionTextToFloat(plAB.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.AKUM_BATTERIES);
            return false;
        }
        return true;
    }

    /**
     * ввод KAS
     *
     * @return
     */
    public boolean validateKAS() {
        try {
            CalculationKA.getInstance().getDataKAS().uwSN = ValidateValue.conversionTextToFloat(uwSN.getText());
            CalculationKA.getInstance().getDataKAS().plSN = ValidateValue.conversionTextToFloat(plSN.getText());
            CalculationKA.getInstance().getDataKAS().uwZU = ValidateValue.conversionTextToFloat(uwZU.getText());
            CalculationKA.getInstance().getDataKAS().plZU = ValidateValue.conversionTextToFloat(plZU.getText());
            CalculationKA.getInstance().getDataKAS().uwRU = ValidateValue.conversionTextToFloat(uwRU.getText());
            CalculationKA.getInstance().getDataKAS().plRU = ValidateValue.conversionTextToFloat(plRU.getText());
            CalculationKA.getInstance().getDataKAS().kKAS = ValidateValue.conversionTextToFloat(kKAS.getText());
            CalculationKA.getInstance().getDataKAS().ProzV_vKAS = ValidateValue.conversionTextToFloat(ProzV_vKAS.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.KAS);
            return false;
        }
        return true;
    }

    /**
     * ввод Солнечные батареи
     *
     * @return
     */
    public boolean validateSunBet() {
        try {
            CalculationKA.getInstance().getDataSumBetSEP().uwFP = ValidateValue.conversionTextToFloat(uwFP.getText());
            CalculationKA.getInstance().getDataSumBetSEP().kzPSB = ValidateValue.conversionTextToFloat(kzPSB.getText());
            CalculationKA.getInstance().getDataSumBetSEP().kp = ValidateValue.conversionTextToFloat(kp.getText());
            CalculationKA.getInstance().getDataSumBetSEP().umPSB = ValidateValue.conversionTextToFloat(umPSB.getText());
            CalculationKA.getInstance().getDataSumBetSEP().nPSB = ValidateValue.conversionTextToFloat(nPSB.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SUN_BATTERIES);
            return false;
        }
        return true;
    }

    /**
     * ввод характеристическая скорость
     *
     * @return
     */
    public boolean validateSpeed() {
        try {
            CalculationKA.getInstance().getDataSpeed().Hp = ValidateValue.conversionTextToFloat(Hp.getText());
            CalculationKA.getInstance().getDataSpeed().iRN = ValidateValue.conversionTextToFloat(iRN.getText());
            CalculationKA.getInstance().getDataSpeed().Ha = ValidateValue.conversionTextToFloat(Ha.getText());
            CalculationKA.getInstance().getDataSpeed().iKA = ValidateValue.conversionTextToFloat(iKA.getText());
            CalculationKA.getInstance().getDataSpeed().dV6 = ValidateValue.conversionTextToFloat(dV6.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.SPEED);
            return false;
        }
        return true;
    }

    /**
     * ввод масса топлива
     *
     * @return
     */
    public boolean validateMassTopl() {
        try {
            CalculationKA.getInstance().getDataMassTopl().nameGoruchee = (nameGoruchee.getText());
            CalculationKA.getInstance().getDataMassTopl().pLG = ValidateValue.conversionTextToFloat(pLG.getText());
            CalculationKA.getInstance().getDataMassTopl().nameOkis = (nameOkis.getText());
            CalculationKA.getInstance().getDataMassTopl().pLO = ValidateValue.conversionTextToFloat(pLO.getText());
            CalculationKA.getInstance().getDataMassTopl().jT = ValidateValue.conversionTextToFloat(jT.getText());
            CalculationKA.getInstance().getDataMassTopl().kOG = ValidateValue.conversionTextToFloat(kOG.getText());
            CalculationKA.getInstance().getDataMassTopl().knt = ValidateValue.conversionTextToFloat(knt.getText());
            CalculationKA.getInstance().getDataMassTopl().kgzt = ValidateValue.conversionTextToFloat(kgzt.getText());
            CalculationKA.getInstance().getDataMassTopl().Tak = ValidateValue.conversionTextToFloat(Tak.getText());
            CalculationKA.getInstance().getDataMassTopl().Tas = ValidateValue.conversionTextToFloat(Tas.getText());
            CalculationKA.getInstance().getDataMassTopl().mTKDUskm1 = ValidateValue.conversionTextToFloat(mTKDUskm1.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.MASS_TOPLIVA);
            return false;
        }
        return true;
    }

    /**
     * ввод КДУ
     *
     * @return
     */
    public boolean validateKDU() {
        try {
            CalculationKA.getInstance().getDataKDU().s = ValidateValue.conversionTextToFloat(s.getText());
            CalculationKA.getInstance().getDataKDU().kNTB = ValidateValue.conversionTextToFloat(kNTB.getText());
            CalculationKA.getInstance().getDataKDU().kpVKDU_Vb = ValidateValue.conversionTextToFloat(kpVKDU_Vb.getText());
            CalculationKA.getInstance().getDataKDU().kpVOKA_VKDU = ValidateValue.conversionTextToFloat(kpVOKA_VKDU.getText());
            CalculationKA.getInstance().getDataKDU().dKDU = ValidateValue.conversionTextToFloat(dKDU.getText());
            CalculationKA.getInstance().getDataKDU().umKDU = ValidateValue.conversionTextToFloat(umKDU.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.MASOGABARITN_AND_ENERGET_PARAMETERS);
            return false;
        }
        return true;
    }

    /**
     * ввод Конструкция
     *
     * @return
     */
    public boolean validateKonstrKA() {
        try {
            CalculationKA.getInstance().getDataKonstrKA().omkKA = ValidateValue.conversionTextToFloat(omkKA.getText());
            CalculationKA.getInstance().getDataKonstrKA().plmkKA = ValidateValue.conversionTextToFloat(plmkKA.getText());
            CalculationKA.getInstance().getDataKonstrKA().kpkKA = ValidateValue.conversionTextToFloat(kpkKA.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.KONSTR);
            return false;
        }
        return true;
    }

    /**
     * ввод БКС и АФУ
     *
     * @return
     */
    public boolean validateBKSandAFU() {
        try {
            CalculationKA.getInstance().getDataBKSandAFU().omBKS = ValidateValue.conversionTextToFloat(omBKS.getText());
            CalculationKA.getInstance().getDataBKSandAFU().omAFU = ValidateValue.conversionTextToFloat(omAFU.getText());
            CalculationKA.getInstance().getDataBKSandAFU().plBKS = ValidateValue.conversionTextToFloat(plBKS.getText());
            CalculationKA.getInstance().getDataBKSandAFU().plAFU = ValidateValue.conversionTextToFloat(plAFU.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.BKS_AND_AFU);
            return false;
        }
        return true;
    }

    /**
     * ввод БКС и АФУ
     *
     * @return
     */
    public boolean validateOtherKA() {
        try {
            DataOtherKA newEl = new DataOtherKA();
            newEl.omPrKA = ValidateValue.conversionTextToFloat(omPrKA.getText());
            newEl.plPrKA = ValidateValue.conversionTextToFloat(plPrKA.getText());
            newEl.uwPrKA = ValidateValue.conversionTextToFloat(uwPrKA.getText());
            newEl.setNameElement(In_nameElement.getText());
            CalculationKA.getInstance().getDataOtherKA().getOthers().add(newEl);
        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.OTHER_ELEMENT_KA);
            return false;
        }
        return true;
    }

    /**
     * ввод резерв
     *
     * @return
     */
    public boolean validateRezerv() {
        try {
            CalculationKA.getInstance().getDataRezervKA().omRmKA = ValidateValue.conversionTextToFloat(omRmKA.getText());
            CalculationKA.getInstance().getDataRezervKA().plRmKA = ValidateValue.conversionTextToFloat(plRmKA.getText());
            CalculationKA.getInstance().getDataRezervKA().uwRmKA = ValidateValue.conversionTextToFloat(uwRmKA.getText());

        } catch (Exception e) {
            ControllerAssembly.addMessInConsoleSintez(MessegeType.ERROR, "Ошибка введеных данных.", TabTypeSintez.RETHERV);
            return false;
        }
        return true;
    }


    /**
     * вывод в исходные Ограничения
     *
     * @return
     */
    public void startShowRestriction() {
        isHaveRestriction.setSelected(CalculationKA.getInstance().getDataCommonParameters().isHaveRestriction);

        iN_mKA0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().mKA0));
        iN_dzPN0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().dzPN0));
        iN_lzPN0.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().lzPN0));
        iN_knzpOBT.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().knzpOBT));
        iN_krkKA.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().krkKA));
        iN_kpoPO.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().kpoPO));
        iN_udlKA1.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().udlKA));

        iN_nonRes_udlKA.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().udlKA));
        iN_nonRes_krkKA.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().krkKA));
        iN_nonRes_kpoPO.setText(String.valueOf(CalculationKA.getInstance().getDataCommonParameters().kpoPO));

        if (CalculationKA.getInstance().getDataCommonParameters().isHaveRestriction) {
            isHaveRestriction.setSelected(true);
        } else {
            isHaveRestriction.setSelected(false);
        }
        choiseActionHaveRestriction(new ActionEvent());
    }

    /**
     * вывод в исходные ОЕТК
     *
     * @return
     */
    public void startShowOETK() {
        iN_Lm.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_Lm));
        iN_H.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_H));
        iN_Delta.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_Delta));
        iN_k0.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_k0));
        iN_q.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_q));
        iN_uwOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_uwOETK));
        iN_kUD.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_kUD));
        iN_kp2dOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_kp2dOETK));
        iN_kp2lOETK.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_kp2lOETK));
        iN_yr.setText(String.valueOf(CalculationKA.getInstance().getDataOETK().iN_yr));

    }

    /**
     * вывод в исходные СППИ
     *
     * @return
     */
    public void startShowSPPE() {
        sPISPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().sPI));
        umSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().umSPPI));
        uwSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().uwSPPI));
        plSPPI.setText(String.valueOf(CalculationKA.getInstance().getDataSPPE().plSPPI));
    }

    /**
     * вывод в исходные ВРЛ
     *
     * @return
     */
    public void startShowVRL() {

        sPI.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().sPI));
        umVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().umVRL));
        uwVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().uwVRL));
        plVRL.setText(String.valueOf(CalculationKA.getInstance().getDataVRL().plVRL));

    }

    /**
     * вывод в исходные Прочие элементы ЦА
     *
     * @return
     */
    public void startShowCA() {
        kPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().kPrZA));
        uwPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().uwPrZA));
        plPrZA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherCA().plPrZA));
    }

    /**
     * вывод в исходные СГК
     *
     * @return
     */
    public void startShowSGK() {
        iN_Pr1.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().Pr1));
        iN_Tzr.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().Tzr));
        iN_uKA.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().uKA));
        iN_wPrez.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().wPrez));
        iN_wRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().wRGP));
        iN_plRGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().plRGP));
        iN_kmGP_RGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().kmGP_RGP));
        iN_kmEB_mGP.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().kmEB_mGP));
        iN_uW_SGK.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().uW_SGK));
        iN_pEB.setText(String.valueOf(CalculationKA.getInstance().getDataSudSGK().pEB));

    }

    /**
     * вывод в исходные SSKM
     *
     * @return
     */
    public void startShowSSKM() {
        kmSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().kmSSKM));
        uwSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().uwSSKM));
        kmsSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().kmsSSKM));
        plaSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().plaSSKM));
        plsSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().plsSSKM));
        kzsSSKM.setText(String.valueOf(CalculationKA.getInstance().getDataSSKM().kzsSSKM));
    }

    /**
     * вывод в исходные СТКРП
     *
     * @return
     */
    public void startShowSTKRP() {
        kmSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().kmSTKRP));
        uwSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().uwSTKRP));
        plSTKRP.setText(String.valueOf(CalculationKA.getInstance().getDataSTKRP().plSTKRP));
    }

    /**
     * вывод в исходные БА КИС
     *
     * @return
     */
    public void startShowBAKES() {
        kmKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().kmKIS));
        uwKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().uwKIS));
        plKIS.setText(String.valueOf(CalculationKA.getInstance().getDataBAKES().plKIS));
    }

    /**
     * вывод в исходные БИТС
     *
     * @return
     */
    public void startShowBETS() {
        kmBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().kmBITS));
        uwBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().uwBITS));
        plBITS.setText(String.valueOf(CalculationKA.getInstance().getDataBETS().plBITS));
    }

    /**
     * вывод в исходные БВС
     *
     * @return
     */
    public void startShowBVS() {
        kmBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().kmBVS));
        uwBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().uwBVS));
        plBVS.setText(String.valueOf(CalculationKA.getInstance().getDataBVS().plBVS));
    }

    /**
     * вывод в исходные прочие элементы БКУ
     *
     * @return
     */
    public void startShowOtherBKU() {
        kPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().kPrBKU));
        uwPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().uwPrBKU));
        plPrBKU.setText(String.valueOf(CalculationKA.getInstance().getDataOtherBKU().plPrBKU));
    }

    /**
     * вывод в исходные пасивные элементы СОТР
     *
     * @return
     */
    public void startShowPasivSOTR() {
        umEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().umEVTI));
        tEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().tEVTI));
        kpEVTI.setText(String.valueOf(CalculationKA.getInstance().getDataPasivSOTR().kpEVTI));
    }

    /**
     * вывод в исходные активные элементы СОТР
     *
     * @return
     */
    public void startShowActivSOTR() {
        omSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().omSTR));
        plSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().plSTR));
        uwSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().uwSTR));
        kmtnSTR.setText(String.valueOf(CalculationKA.getInstance().getDataActivSOTR().kmtnSTR));
    }

    /**
     * вывод в электротехнические характеристики СЭП
     *
     * @return
     */
    public void startShowElectTehHarakSEP() {
        wNomInCep.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().wNomInCep));
        kspSEP.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kspSEP));
        TobrKA.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().TobrKA));
        tZRKA.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().tZRKA));
        kpdKAS.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kpdKAS));
        kpdAB.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kpdAB));
        srU.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().srU));
        kpdZU.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kpdZU));
        kpdRU.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kpdRU));
        kzAC.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kzAC));
        kzSR.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kzSR));
        kdowAB.setText(String.valueOf(CalculationKA.getInstance().getDataElectHaraktSEP().kdowAB));
    }

    /**
     * вывод в  Акамуляторные батареи
     *
     * @return
     */
    public void startShowAcumBat() {
        uwAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().uwAB));
        nAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().nAB));
        plAB.setText(String.valueOf(CalculationKA.getInstance().getDataAcumBetSEP().plAB));
    }

    /**
     * вывод в КАС
     *
     * @return
     */
    public void startShowKAS() {
        uwSN.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().uwSN));
        plSN.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().plSN));
        uwZU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().uwZU));
        plZU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().plZU));
        uwRU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().uwRU));
        plRU.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().plRU));
        kKAS.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().kKAS));
        ProzV_vKAS.setText(String.valueOf(CalculationKA.getInstance().getDataKAS().ProzV_vKAS));

    }

    /**
     * вывод в солнечные батареи
     *
     * @return
     */
    public void startShowSunBet() {
        uwFP.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().uwFP));
        kzPSB.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().kzPSB));
        kp.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().kp));
        umPSB.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().umPSB));
        nPSB.setText(String.valueOf(CalculationKA.getInstance().getDataSumBetSEP().nPSB));

    }

    /**
     * вывод в характеристическая скорость
     *
     * @return
     */
    public void startShowSpeed() {
        Hp.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().Hp));
        iRN.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().iRN));
        Ha.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().Ha));
        iKA.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().iKA));
        dV6.setText(String.valueOf(CalculationKA.getInstance().getDataSpeed().dV6));
    }

    /**
     * вывод в масса топлива
     *
     * @return
     */
    public void startMassT() {
        nameGoruchee.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().nameGoruchee));
        pLG.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().pLG));
        nameOkis.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().nameOkis));
        pLO.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().pLO));
        jT.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().jT));
        kOG.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().kOG));
        knt.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().knt));
        kgzt.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().kgzt));
        Tak.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().Tak));
        Tas.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().Tas));
        mTKDUskm1.setText(String.valueOf(CalculationKA.getInstance().getDataMassTopl().mTKDUskm1));
    }

    /**
     * вывод в КДУ
     *
     * @return
     */
    public void startShowKDU() {
        s.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().s));
        kNTB.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().kNTB));
        kpVKDU_Vb.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().kpVKDU_Vb));
        kpVOKA_VKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().kpVOKA_VKDU));
        dKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().dKDU));
        umKDU.setText(String.valueOf(CalculationKA.getInstance().getDataKDU().umKDU));

    }

    /**
     * вывод в Конструкция
     *
     * @return
     */
    public void startShowKonstrKA() {
        omkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().omkKA));
        plmkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().plmkKA));
        kpkKA.setText(String.valueOf(CalculationKA.getInstance().getDataKonstrKA().kpkKA));

    }

    /**
     * вывод в БКС и АФУ
     *
     * @return
     */
    public void startShowBKSandAFU() {
        omBKS.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().omBKS));
        omAFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().omAFU));
        plBKS.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().plBKS));
        plAFU.setText(String.valueOf(CalculationKA.getInstance().getDataBKSandAFU().plAFU));

    }

    /**
     * вывод в прочие элементы КА
     *
     * @return
     */
    public void startShowOtherKA() {
        omPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().omPrKA));
        plPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().plPrKA));
        uwPrKA.setText(String.valueOf(CalculationKA.getInstance().getDataOtherKA().uwPrKA));
        initotherKA();
    }

    /**
     * вывод в резерв
     *
     * @return
     */
    public void startShowRezerv() {
        omRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().omRmKA));
        plRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().plRmKA));
        uwRmKA.setText(String.valueOf(CalculationKA.getInstance().getDataRezervKA().uwRmKA));
    }

    public void startShowALL() {
        startShowRestriction();
        startShowOETK();
        startShowSPPE();
        startShowVRL();
        startShowCA();
        startShowSGK();
        startShowSSKM();
        startShowSTKRP();
        startShowBAKES();
        startShowBETS();
        startShowBVS();
        startShowOtherBKU();
        startShowPasivSOTR();
        startShowActivSOTR();
        startShowElectTehHarakSEP();
        startShowAcumBat();
        startShowKAS();
        startShowSunBet();
        startShowSpeed();
        startShowKDU();
        startShowKonstrKA();
        startShowBKSandAFU();
        startShowOtherKA();
        startShowRezerv();
        startMassT();
    }

    public void initotherKA() {
        try {
            columnOtherKAname.setCellValueFactory(new PropertyValueFactory<ViewDataOtherKA, String>("nameElement"));
            columnOtherKAm.setCellValueFactory(new PropertyValueFactory<ViewDataOtherKA, String>("mPrKA"));
            columnOtherKAv.setCellValueFactory(new PropertyValueFactory<ViewDataOtherKA, String>("vPrKA"));
            columnOtherKAj.setCellValueFactory(new PropertyValueFactory<ViewDataOtherKA, String>("jPrKA"));
            columnOtherKAw.setCellValueFactory(new PropertyValueFactory<ViewDataOtherKA, String>("wPrKA"));

//            calculationOtherKA.calculationSingle(new DataOtherKA());

            ObservableList<ViewDataOtherKA> list = FXCollections.observableArrayList();

            for (DataOtherKA dataOtherKA : CalculationKA.getInstance().getDataOtherKA().getOthers()) {
                list.add(ViewDataOtherKA.validateDataOtherKA(dataOtherKA));
            }
            tableOtherKA.setItems(list);
        } catch (Exception e) {
            ControllerAssembly.showError("Инициализация прочих элементов КА не удалась");
        }
    }

    private void onProgress(boolean value, ImageView ok, ImageView ask) {
        ok.setVisible(value);
        ask.setVisible(!value);
    }

    public void onProgressRestr(boolean value) {
        onProgress(value,onStepOkRestr,onStepAskRestr);
    }

    public void onProgressOetk (boolean value) {
        onProgress(value,onStepOkOetk,onStepAskOetk);
    }

    public void onProgressSppe (boolean value) {
        onProgress(value,onStepOkSppe,onStepAskSppe);
    }

    public void onProgressVrl (boolean value) {
        onProgress(value,onStepOkVrl,onStepAskVrl);
    }

    public void onProgressOtherCa (boolean value) {
        onProgress(value,onStepOkOtherCa,onStepAskOtherCa);
    }

    public void onProgressCa (boolean value) {
        onProgress(value,onStepOkCa,onStepAskCa);
    }
}


