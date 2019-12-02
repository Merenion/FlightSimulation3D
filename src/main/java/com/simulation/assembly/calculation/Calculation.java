package com.simulation.assembly.calculation;

public interface Calculation<T> {
    T calculation (T object) throws Exception;
}
