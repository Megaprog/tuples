package org.jmmo.tuple;

import org.jmmo.function.Consumer5;
import org.jmmo.function.Function5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple5<T0, T1, T2, T3, T4> implements Tuple, Comparable<Tuple5<T0, T1, T2, T3, T4>> {
    private static final long serialVersionUID = 8215132094283212974L;
    
    private final T0 value0;
    private final T1 value1;
    private final T2 value2;
    private final T3 value3;
    private final T4 value4;

    protected Tuple5(T0 value0, T1 value1, T2 value2, T3 value3, T4 value4) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public static <V0, V1, V2, V3, V4> Tuple5<V0, V1, V2, V3, V4> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4) {
        return new Tuple5<>(v0, v1, v2, v3, v4);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A> Tuple5<V0, V1, V2, V3, V4> fromArray(A[] values) {
        return new Tuple5<>((V0) values[0], (V1) values[1], (V2) values[2], (V3) values[3], (V4) values[4]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A, V3 extends A, V4 extends A> Tuple5<V0, V1, V2, V3, V4> fromIterator(Iterator<A> iterator) {
        return new Tuple5<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next(), (V3) iterator.next(), (V4) iterator.next());
    }

    public void unfold(Consumer5<T0, T1, T2, T3, T4> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2(), getValue3(), getValue4());
    }

    public <R> R unfoldResult(Function5<T0, T1, T2, T3, T4, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2(), getValue3(), getValue4());
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

    @Override public int getSize() {
        return 5;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
            case 1: return (E) getValue1();
            case 2: return (E) getValue2();
            case 3: return (E) getValue3();
            case 4: return (E) getValue4();
        }

        throw new IndexOutOfBoundsException("Tuple5 contains five elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2(), getValue3(), getValue4() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple5> comparator =
            Comparator.<Tuple5, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple5, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple5, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue2(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple5, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue3(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple5, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue4(), Tuple1.nullComparator));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple5<T0, T1, T2, T3, T4> o) {
        return comparator.compare(this, o);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple5)) return false;
        Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
        return Objects.deepEquals(getValue0(), tuple5.getValue0()) &&
                Objects.deepEquals(getValue1(), tuple5.getValue1()) &&
                Objects.deepEquals(getValue2(), tuple5.getValue2()) &&
                Objects.deepEquals(getValue3(), tuple5.getValue3()) &&
                Objects.deepEquals(getValue4(), tuple5.getValue4());
    }

    @Override public int hashCode() {
        return Tuple.deepHash(getValue0(), getValue1(), getValue2(), getValue3(), getValue4());
    }

    @Override public String toString() {
        return "Tuple5{" +
                "value0=" + getValue0() +
                ", value1=" + getValue1() +
                ", value2=" + getValue2() +
                ", value3=" + getValue3() +
                ", value4=" + getValue4() +
                '}';
    }
}
