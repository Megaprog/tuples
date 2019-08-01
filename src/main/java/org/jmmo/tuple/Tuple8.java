package org.jmmo.tuple;

import org.jmmo.function.Consumer8;
import org.jmmo.function.Function8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> implements Tuple, Comparable<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> {
    private static final long serialVersionUID = 5714304777999601759L;

    private final T0 value0;
    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;
    private final T5 value5;
    private final T6 value6;
    private final T7 value7;

    protected Tuple8(T0 value0, T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6, T7 value7) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
        this.value7 = value7;
    }

    public static <V0, V1, V2, V3, V4, V5, V6, V7> Tuple8<V0, V1, V2, V3, V4, V5, V6, V7> of(
            V0 v0, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5, V6 v6, V7 v7) {
        return new Tuple8<>(v0, v1, v2, v3, v4, v5, v6, v7);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A, V6 extends A,
            V7 extends A>
    Tuple8<V0, V1, V2, V3, V4, V5, V6, V7> fromArray(A[] values) {
        return new Tuple8<>((V0) values[0], (V1) values[1], (V2) values[2], (V3) values[3], (V4) values[4],
                (V5) values[5], (V6) values[6], (V7) values[7]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A, V5 extends A, V6 extends A,
            V7 extends A>
    Tuple8<V0, V1, V2, V3, V4, V5, V6, V7> fromIterator(Iterator<A> iterator) {
        return new Tuple8<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next(), (V3) iterator.next(),
                (V4) iterator.next(), (V5) iterator.next(), (V6) iterator.next(), (V7) iterator.next());
    }

    public void unfold(Consumer8<T0, T1, T2, T3, T4, T5, T6, T7> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(),
                getValue6(), getValue7());
    }

    public <R> R unfoldResult(Function8<T0, T1, T2, T3, T4, T5, T6, T7, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(),
                getValue6(), getValue7());
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

    public T7 getValue7() {
        return value7;
    }

    @Override public int getSize() {
        return 8;
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
            case 7: return (E) getValue7();
        }

        throw new IndexOutOfBoundsException("Tuple8 contains eight elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2(), getValue3(), getValue4(), getValue5(),
                getValue6(), getValue7() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple8> comparator =
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue2(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue3(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue4(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue5(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue6(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple8, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue7(), Tuple1.nullComparator)));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> o) {
        return comparator.compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple8)) return false;
        Tuple8<?, ?, ?, ?, ?, ?, ?, ?> tuple8 = (Tuple8<?, ?, ?, ?, ?, ?, ?, ?>) o;
        return Objects.deepEquals(getValue0(), tuple8.getValue0()) &&
                Objects.deepEquals(getValue1(), tuple8.getValue1()) &&
                Objects.deepEquals(getValue2(), tuple8.getValue2()) &&
                Objects.deepEquals(getValue3(), tuple8.getValue3()) &&
                Objects.deepEquals(getValue4(), tuple8.getValue4()) &&
                Objects.deepEquals(getValue5(), tuple8.getValue5()) &&
                Objects.deepEquals(getValue6(), tuple8.getValue6()) &&
                Objects.deepEquals(getValue7(), tuple8.getValue7());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {getValue0(), getValue1(), getValue2(), getValue3(), getValue4(),
                getValue5(), getValue6(), getValue7()});
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
                ", value7=" + getValue7() +
                '}';
    }
}
