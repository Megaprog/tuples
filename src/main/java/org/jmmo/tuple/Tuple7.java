package org.jmmo.tuple;

import org.jmmo.function.Consumer7;
import org.jmmo.function.Function7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple7<T0, T1, T2, T3, T4, T5, T6> implements Tuple, Comparable<Tuple7<T0, T1, T2, T3, T4, T5, T6>> {
    private static final long serialVersionUID = 4368860219843838295L;
    
    private final T0 value0;
    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;
    private final T5 value5;
    private final T6 value6;

    protected Tuple7(T0 value0, T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
    }

    public static <V0, V1, V2, V3, V4, V5, V6> Tuple7<V0, V1, V2, V3, V4, V5, V6> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4,
                                                                                     V5 v5, V6 v6) {
        return new Tuple7<>(v0, v1, v2, v3, v4, v5, v6);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A, V6 extends A>
    Tuple7<V0, V1, V2, V3, V4, V5, V6> fromArray(A[] values) {
        return new Tuple7<>((V0) values[0], (V1) values[1], (V2) values[2], (V3) values[3], (V4) values[4],
                (V5) values[5], (V6) values[6]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A, V6 extends A>
    Tuple7<V0, V1, V2, V3, V4, V5, V6> fromIterator(Iterator<A> iterator) {
        return new Tuple7<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next(), (V3) iterator.next(),
                (V4) iterator.next(), (V5) iterator.next(), (V6) iterator.next());
    }

    public void unfold(Consumer7<T0, T1, T2, T3, T4, T5, T6> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(), getValue6());
    }

    public <R> R unfoldResult(Function7<T0, T1, T2, T3, T4, T5, T6, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(), getValue6());
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

    public T6 getValue6() {
        return value6;
    }

    @Override public int getSize() {
        return 7;
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
            case 6: return (E) getValue6();
        }

        throw new IndexOutOfBoundsException("Tuple7 contains seven elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(), getValue6() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple7> comparator =
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue2(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue3(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue4(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue5(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple7, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue6(), Tuple1.nullComparator));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple7<T0, T1, T2, T3, T4, T5, T6> o) {
        return comparator.compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple7)) return false;
        Tuple7<?, ?, ?, ?, ?, ?, ?> tuple7 = (Tuple7<?, ?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(getValue0(), tuple7.getValue0()) &&
                Objects.equals(getValue1(), tuple7.getValue1()) &&
                Objects.equals(getValue2(), tuple7.getValue2()) &&
                Objects.equals(getValue3(), tuple7.getValue3()) &&
                Objects.equals(getValue4(), tuple7.getValue4()) &&
                Objects.equals(getValue5(), tuple7.getValue5()) &&
                Objects.equals(getValue6(), tuple7.getValue6());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(), getValue6());
    }

    @Override public String toString() {
        return "Tuple5{" +
                "value0=" + getValue0() +
                ", value1=" + getValue1() +
                ", value2=" + getValue2() +
                ", value3=" + getValue3() +
                ", value4=" + getValue4() +
                ", value5=" + getValue5() +
                ", value6=" + getValue6() +
                '}';
    }
}
