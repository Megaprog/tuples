package org.jmmo.function;

@FunctionalInterface
public interface Function3<T0, T1, T2, R> {

    R apply(T0 t0, T1 t1, T2 t2);
}
