package com.simulation.assembly;

import com.simulation.assembly.dataCalculation.sintez.*;

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
    };

    private String name = "NON NAME";
    private String typeName = "non";
    private Class<?>  typeClass = DataElement.class;


    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<?> getTypeClass() {
        return typeClass;
    }
}
