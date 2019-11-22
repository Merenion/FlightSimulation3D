package com.simulation.assembly;

public enum TabTypeSintez {

    //ОГРАНИЧЕНИЯ
    RESTRICTION{
        private String name = "Ограничения";

        @Override
        public String getName() {
            return name;
        }
    },

    //ЦЕЛЕВАЯ АППАРАТУРА
    OETK{
        private String name = "ОЭТК";

        @Override
        public String getName() {
            return name;
        }
    },
    SPPE{
        private String name = "СППИ";

        @Override
        public String getName() {
            return name;
        }
    },
    VRL,
    OTHER_ELEMENTS_CA,
    CA,

    //БКУ
    SUD_SGK{
        private String name = "СГК";

        @Override
        public String getName() {
            return name;
        }
    },
    SUD_SSKM,
    STKRP,
    BETS,
    BVS,
    OTHER_ELEMENTS_BKU,
    BKU,

    //СОТР
    PASSIV_ELEMENT_SOTR,
    ACTIV_ELEMENT_SOTR,
    SOTR,

    //SEP
    ELECTROTEH_PARAM,
    AKUM_BATTERIES,
    KAS,
    SUN_BATTERIES,

    //KDU
    SPEED,
    MASS_TOPLIVA,
    MASOGABARITN_AND_ENERGET_PARAMETERS,

    //КОНСТРУКЦИЯ
    KONSTR,

    BKS_AND_AFU,

    OTHER_ELEMENT_KA,

    RETHERV,

    RESULT;

    private String name = "NON NAME";

    public String getName() {
        return name;
    }
}
