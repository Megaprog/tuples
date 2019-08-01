package org.jmmo.tuple;

import org.jmmo.function.Consumer4;
import org.jmmo.function.Function4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple4<T0, T1, T2, T3> implements Tuple, Comparable<Tuple4<T0, T1, T2, T3>> {
    private static final long serialVersionUID = 2080892681098370535L;
    
    private final T0 value0;
    private final T1 value1;
    private final T2 value2;
    private final T3 value3;

    protected Tuple4(T0 value0, T1 value1, T2 value2, T3 value3) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static <V0, V1, V2, V3> Tuple4<V0, V1, V2, V3> of(V0 v0, V1 v1, V2 v2, V3 v3) {
        return new Tuple4<>(v0, v1, v2, v3);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A> Tuple4<V0, V1, V2, V3> fromArray(A[] values) {
        return new Tuple4<>((V0) values[0], (V1) values[1], (V2) values[2], (V3) values[3]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A> Tuple4<V0, V1, V2, V3> fromIterator(Iterator<A> iterator) {
        return new Tuple4<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next(), (V3) iterator.next());
    }

    public void unfold(Consumer4<T0, T1, T2, T3> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2(), getValue3());
    }

    public <R> R unfoldResult(Function4<T0, T1, T2, T3, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2(), getValue3());
    }

    public T0 getValue0() {
        return value0;
    }

    public T1 getValue1() {
        return value1;
    }

    public T2 getValue2() {
        return value2;
    }

    public T3 getValue3() {
        return value3;
    }

    @Override public int getSize() {
        return 4;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
            case 1: return (E) getValue1();
            case 2: return (E) getValue2();
            case 3: return (E) getValue3();
        }

        throw new IndexOutOfBoundsException("Tuple4 contains four elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2(), getValue3() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple4> comparator =
            Comparator.<Tuple4, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple4, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple4, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue2(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple4, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue3(), Tuple1.nullComparator));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple4<T0, T1, T2, T3> o) {
        return comparator.compare(this, o);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple4)) return false;
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o;
        return Objects.deepEquals(getValue0(), tuple4.getValue0()) &&
                Objects.deepEquals(getValue1(), tuple4.getValue1()) &&
                Objects.deepEquals(getValue2(), tuple4.getValue2()) &&
                Objects.deepEquals(getValue3(), tuple4.getValue3());
    }

    @Override public int hashCode() {
        return Arrays.deepHashCode(new Object[] {getValue0(), getValue1(), getValue2(), getValue3()});
    }

    @Override public String toString() {
        return "Tuple4{" +
                "value0=" + getValue0() +
                ", value1=" + getValue1() +
                ", value2=" + getValue2() +
                ", value3=" + getValue3() +
                '}';
    }
}
