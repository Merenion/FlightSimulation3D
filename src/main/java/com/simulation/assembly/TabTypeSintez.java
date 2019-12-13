package com.simulation.assembly;

import com.simulation.assembly.calculation.Calculation;
import com.simulation.assembly.calculation.ca.*;
import com.simulation.assembly.dataCalculation.sintez.*;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "typeElementEnum")
@XmlEnum
public enum TabTypeSintez {

    //ОГРАНИЧЕНИЯ
    RESTRICTION{
        private String name = "Ограничения";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "restr";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataCommonParameters.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSimpleSintez();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataCommonParameters();
        }

        @Override
        public Integer getNumber() {
            return 1;
        }
    },

    //ЦЕЛЕВАЯ АППАРАТУРА
    OETK{
        private String name = "ОЭТК";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "oetk";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataOETK.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationOETK();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataOETK();
        }

        @Override
        public Integer getNumber() {
            return 2;
        }
    },
    SPPE{
        private String name = "СППИ";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "sppe";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSPPE.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSPPE();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSPPE();
        }

        @Override
        public Integer getNumber() {
            return 3;
        }
    },
    VRL{
        private String name = "ВРЛ";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "vrl";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataVRL.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationVRL();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataVRL();
        }

        @Override
        public Integer getNumber() {
            return 4;
        }
    },
    OTHER_ELEMENTS_CA{
        private String name = "Прочие элементы ЦА";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "prca";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataOtherCA.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationOtherCA();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataOtherCA();
        }

        @Override
        public Integer getNumber() {
            return 5;
        }
    },
    CA{
        private String name = "ЦА";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "ca";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataCa.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationCa();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataCa();
        }

        @Override
        public Integer getNumber() {
            return 6;
        }
    },

    //БКУ
    SUD_SGK{
        private String name = "СГК";

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getTypeName() {
            return "sgk";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSudSGK.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSGK();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSudSGK();
        }

        @Override
        public Integer getNumber() {
            return 7;
        }
    },
    SUD_SSKM{

        @Override
        public String getName() {
            return "ССКМ";
        }

        @Override
        public String getTypeName() {
            return "sskm";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSSKM.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSSKM();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSSKM();
        }

        @Override
        public Integer getNumber() {
            return 8;
        }
    },
    STKRP{
        @Override
        public String getName() {
            return "STKRP";
        }

        @Override
        public String getTypeName() {
            return "stkrp";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSTKRP.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSTKRP();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSTKRP();
        }

        @Override
        public Integer getNumber() {
            return 9;
        }
    },
    BAKIS{
        @Override
        public String getName() {
            return "БА КИС";
        }

        @Override
        public String getTypeName() {
            return "bakes";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataBAKES.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationBAKES();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataBAKES();
        }

        @Override
        public Integer getNumber() {
            return 10;
        }
    },
    BETS {
        @Override
        public String getName() {
            return "БИТС";
        }

        @Override
        public String getTypeName() {
            return "bets";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataBETS.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationBETS();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataBETS();
        }

        @Override
        public Integer getNumber() {
            return 11;
        }
    },
    BVS{
        @Override
        public String getName() {
            return "БВС";
        }

        @Override
        public String getTypeName() {
            return "bvs";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataBVS.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationBVS();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataBVS();
        }

        @Override
        public Integer getNumber() {
            return 12;
        }
    },
    OTHER_ELEMENTS_BKU{
        @Override
        public String getName() {
            return "Прочие элементы БКУ";
        }

        @Override
        public String getTypeName() {
            return "prbku";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataOtherBKU.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationOtherBKU();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataOtherBKU();
        }

        @Override
        public Integer getNumber() {
            return 13;
        }
    },
    BKU{
        @Override
        public String getName() {
            return "БКУ";
        }

        @Override
        public String getTypeName() {
            return "bku";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataBKU.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationBKU();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataBKU();
        }

        @Override
        public Integer getNumber() {
            return 14;
        }
    },

    //СОТР
    PASSIV_ELEMENT_SOTR{
        @Override
        public String getName() {
            return "Пасивные элементы СОТР";
        }

        @Override
        public String getTypeName() {
            return "evti";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataPasivSOTR.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationPasivSOTR();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataPasivSOTR();
        }

        @Override
        public Integer getNumber() {
            return 15;
        }
    },
    ACTIV_ELEMENT_SOTR{
        @Override
        public String getName() {
            return "Активные элементы СОТР";
        }

        @Override
        public String getTypeName() {
            return "str";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataActivSOTR.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationActivSOTR();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataActivSOTR();
        }

        @Override
        public Integer getNumber() {
            return 16;
        }
    },
    SOTR{
        @Override
        public String getName() {
            return "СОТР";
        }

        @Override
        public String getTypeName() {
            return "sotr";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSOTR.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSOTR();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSOTR();
        }

        @Override
        public Integer getNumber() {
            return 17;
        }
    },

    //SEP
    ELECTROTEH_PARAM{
        @Override
        public String getName() {
            return "Электротехнические характеристики СЭП";
        }

        @Override
        public String getTypeName() {
            return "eetsep";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataElectHaraktSEP.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationElectHaraktSEP();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataElectHaraktSEP();
        }

        @Override
        public Integer getNumber() {
            return 18;
        }
    },
    AKUM_BATTERIES{
        @Override
        public String getName() {
            return "Аккумуляторные батареи";
        }

        @Override
        public String getTypeName() {
            return "acbtsep";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataAcumBetSEP.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationAcumBetSEP();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataAcumBetSEP();
        }

        @Override
        public Integer getNumber() {
            return 19;
        }
    },
    KAS{
        @Override
        public String getName() {
            return "КАС";
        }

        @Override
        public String getTypeName() {
            return "kas";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataKAS.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationKAS();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataKAS();
        }

        @Override
        public Integer getNumber() {
            return 20;
        }
    },
    SUN_BATTERIES{
        @Override
        public String getName() {
            return "Солнечные батареи";
        }

        @Override
        public String getTypeName() {
            return "sun";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSumBetSEP.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSumBetSEP();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSumBetSEP();
        }

        @Override
        public Integer getNumber() {
            return 21;
        }
    },

    //KDU
    SPEED{
        @Override
        public String getName() {
            return "Характеристическая скорость";
        }

        @Override
        public String getTypeName() {
            return "speed";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataSpeed.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationSpeed();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataSpeed();
        }

        @Override
        public Integer getNumber() {
            return 22;
        }
    },
    MASS_TOPLIVA{
        @Override
        public String getName() {
            return "Масса топлива";
        }

        @Override
        public String getTypeName() {
            return "mstp";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataMassTopl.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationMassTopl();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataMassTopl();
        }

        @Override
        public Integer getNumber() {
            return 23;
        }
    },
    MASOGABARITN_AND_ENERGET_PARAMETERS{
        @Override
        public String getName() {
            return "Массогабаритные и энергетические характеристики";
        }

        @Override
        public String getTypeName() {
            return "kdu";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataKDU.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationKDU();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataKDU();
        }

        @Override
        public Integer getNumber() {
            return 24;
        }
    },

    //КОНСТРУКЦИЯ
    KONSTR{
        @Override
        public String getName() {
            return "Конструкция КА";
        }

        @Override
        public String getTypeName() {
            return "konstr";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataKonstrKA.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationKonstrKA();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataKonstrKA();
        }

        @Override
        public Integer getNumber() {
            return 25;
        }
    },

    BKS_AND_AFU{
        @Override
        public String getName() {
            return "БКС и АФУ";
        }

        @Override
        public String getTypeName() {
            return "bksafu";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataBKSandAFU.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalkulationBKSandAFU();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataBKSandAFU();
        }

        @Override
        public Integer getNumber() {
            return 26;
        }
    },

    OTHER_ELEMENT_KA{
        @Override
        public String getName() {
            return "Прочие элементы КА";
        }

        @Override
        public String getTypeName() {
            return "prka";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataOtherKA.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationOtherKA();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataOtherKA();
        }

        @Override
        public Integer getNumber() {
            return 27;
        }
    },

    RETHERV{
        @Override
        public String getName() {
            return "Резерв";
        }

        @Override
        public String getTypeName() {
            return "rezerv";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataRezervKA.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationRezervKA();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataRezervKA();
        }

        @Override
        public Integer getNumber() {
            return 28;
        }
    },

    RESULT{
        @Override
        public String getName() {
            return "Результаты расчета КА";
        }

        @Override
        public String getTypeName() {
            return "rezka";
        }

        @Override
        public Class<?> getTypeClass() {
            return DataCommonParameters.class;
        }

        @Override
        public Calculation getCalculation() {
            return new CalculationKA();
        }

        @Override
        public DataElement getDataElement() {
            return CalculationKA.getInstance().getDataCommonParameters();
        }

        @Override
        public Integer getNumber() {
            return 29;
        }
    };

    private String name = "NON NAME";
    private String typeName = "non";
    private Class<?>  typeClass = DataElement.class;
    private Calculation calculation = CalculationKA.getInstance();
    private DataElement dataElement = CalculationKA.getInstance().getDataCommonParameters();
    private Integer number;


    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<?> getTypeClass() {
        return typeClass;
    }

    public Calculation getCalculation() {
        return calculation;
    }

    public DataElement getDataElement() {
        return dataElement;
    }

    public Integer getNumber() {
        return number;
    }
}
