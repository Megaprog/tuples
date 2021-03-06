package org.jmmo.tuple;

import org.jmmo.function.Consumer3;
import org.jmmo.function.Function3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Tuple3<T0, T1, T2> implements Tuple, Comparable<Tuple3<T0, T1, T2>> {
    private static final long serialVersionUID = 2276031222124222468L;

    private final T0 value0;
    private final T1 value1;
    private final T2 value2;

    protected Tuple3(T0 value0, T1 value1, T2 value2) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
    }

    public static <V0, V1, V2> Tuple3<V0, V1, V2> of(V0 v0, V1 v1, V2 v2) {
        return new Tuple3<>(v0, v1, v2);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A> Tuple3<V0, V1, V2> fromArray(A[] values) {
        return new Tuple3<>((V0) values[0], (V1) values[1], (V2) values[2]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A, V2 extends A> Tuple3<V0, V1, V2> fromIterator(Iterator<A> iterator) {
        return new Tuple3<>((V0) iterator.next(), (V1) iterator.next(), (V2) iterator.next());
    }

    public void unfold(Consumer3<T0, T1, T2> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1(), getValue2());
    }

    public <R> R unfoldResult(Function3<T0, T1, T2, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1(), getValue2());
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

    @Override public int getSize() {
        return 3;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
            case 1: return (E) getValue1();
            case 2: return (E) getValue2();
        }

        throw new IndexOutOfBoundsException("Tuple3 contains three elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1(), getValue2() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple3> comparator =
            Comparator.<Tuple3, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple3, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator))
            .thenComparing(
            Comparator.<Tuple3, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue2(), Tuple1.nullComparator));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple3<T0, T1, T2> o) {
        return comparator.compare(this, o);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple3)) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.deepEquals(getValue0(), tuple3.getValue0()) &&
                Objects.deepEquals(getValue1(), tuple3.getValue1()) &&
                Objects.deepEquals(getValue2(), tuple3.getValue2());
    }

    @Override public int hashCode() {
        return Tuple.hashCode(this);
    }

    @Override public String toString() {
        return Tuple.toString(this);
    }
}
