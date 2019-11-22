package com.simulation.assembly;

public enum MessegeType {
    INFO{
        @Override
        public String toString() {
            return "[INFO] ";
        }
    },

    ERROR{
        @Override
        public String toString() {
            return "[ERROR] ";
        }
    },
    WARN{
        @Override
        public String toString() {
            return "[WARN] ";
        }
    }
}
