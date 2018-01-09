package org.jmmo.tuple;

import org.jmmo.function.Consumer6;
import org.jmmo.function.Function6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple6<T0, T1, T2, T3, T4, T5> implements Tuple, Comparable<Tuple6<T0, T1, T2, T3, T4, T5>> {
    private static final long serialVersionUID = 7059741881567341693L;
    
    private final T0 value0;
    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;
    private final T5 value5;

    protected Tuple6(T0 value0, T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
    }

    public static <V0, V1, V2, V3, V4, V5> Tuple6<V0, V1, V2, V3, V4, V5> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5) {
        return new Tuple6<>(v0, v1, v2, v3, v4, v5);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A>
    Tuple6<V0, V1, V2, V3, V4, V5> fromArray(A[] values) {
        return new Tuple6<>((V0) values[0], (V1) values[1], (V2) values[2], (V3) values[3], (V4) values[4], (V5) values[5]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A>
    Tuple6<V0, V1, V2, V3, V4, V5> fromIterator(Iterator<A> iterator) {
        return new Tuple6<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next(), (V3) iterator.next(),
                (V4) iterator.next(), (V5) iterator.next());
    }

    public void unfold(Consumer6<T0, T1, T2, T3, T4, T5> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5());
    }

    public <R> R unfoldResult(Function6<T0, T1, T2, T3, T4, T5, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5());
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

    public T4 getValue4() {
        return value4;
    }

    public T5 getValue5() {
        return value5;
    }

    @Override public int getSize() {
        return 6;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
            case 1: return (E) getValue1();
            case 2: return (E) getValue2();
            case 3: return (E) getValue3();
            case 4: return (E) getValue4();
            case 5: return (E) getValue5();
        }

        throw new IndexOutOfBoundsException("Tuple6 contains six elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5() };
    }

    private static final Comparator<Tuple6> comparator =
            Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue0()))
            .thenComparing(Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue1()))
            .thenComparing(Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue2())))
            .thenComparing(Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue3())))
            .thenComparing(Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue4())))
            .thenComparing(Comparator.nullsFirst(
            Comparator.<Tuple6, Comparable>comparing(tuple -> (Comparable) tuple.getValue5()))));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple6<T0, T1, T2, T3, T4, T5> o) {
        return comparator.compare(this, o);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple6)) return false;
        Tuple6<?, ?, ?, ?, ?, ?> tuple6 = (Tuple6<?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(getValue0(), tuple6.getValue0()) &&
                Objects.equals(getValue1(), tuple6.getValue1()) &&
                Objects.equals(getValue2(), tuple6.getValue2()) &&
                Objects.equals(getValue3(), tuple6.getValue3()) &&
                Objects.equals(getValue4(), tuple6.getValue4()) &&
                Objects.equals(getValue5(), tuple6.getValue5());
    }

    @Override public int hashCode() {
        return Objects.hash(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5());
    }

    @Override public String toString() {
        return "Tuple5{" +
                "value0=" + getValue0() +
                ", value1=" + getValue1() +
                ", value2=" + getValue2() +
                ", value3=" + getValue3() +
                ", value4=" + getValue4() +
                ", value5=" + getValue5() +
                '}';
    }
}
