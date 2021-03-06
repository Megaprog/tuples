package org.jmmo.tuple;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Tuple2<T0, T1> implements Tuple, Comparable<Tuple2<T0, T1>> {
    private static final long serialVersionUID = 2319789519451835186L;

    private final T0 value0;
    private final T1 value1;

    protected Tuple2(T0 value0, T1 value1) {
        this.value0 = value0;
        this.value1 = value1;
    }

    public static <V0, V1> Tuple2<V0, V1> of(V0 v0, V1 v1) {
        return new Tuple2<>(v0, v1);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A> Tuple2<V0, V1> fromArray(A[] values) {
        return new Tuple2<>((V0) values[0], (V1) values[1]);
    }

    @SuppressWarnings("unchecked")
    public static <A, V0 extends A, V1 extends A> Tuple2<V0, V1> fromIterator(Iterator<A> iterator) {
        return new Tuple2<>((V0) iterator.next(), (V1) iterator.next());
    }

    public void unfold(BiConsumer<T0, T1> valueConsumer) {
        valueConsumer.accept(getValue0(), getValue1());
    }

    public <R> R unfoldResult(BiFunction<T0, T1, R> valueFunction) {
        return valueFunction.apply(getValue0(), getValue1());
    }

    public T0 getValue0() {
        return value0;
    }

    public T1 getValue1() {
        return value1;
    }

    @Override public int getSize() {
        return 2;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
            case 1: return (E) getValue1();
        }

        throw new IndexOutOfBoundsException("Tuple2 contains two elements but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0(), getValue1() };
    }

    @SuppressWarnings("unchecked")
    private static final Comparator<Tuple2> comparator =
            Comparator.<Tuple2, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue0(), Tuple1.nullComparator)
            .thenComparing(
            Comparator.<Tuple2, Comparable<Object>>comparing(tuple -> (Comparable) tuple.getValue1(), Tuple1.nullComparator));

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple2<T0, T1> o) {
        return comparator.compare(this, o);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.deepEquals(getValue0(), tuple2.getValue0()) &&
                Objects.deepEquals(getValue1(), tuple2.getValue1());
    }

    @Override public int hashCode() {
        return Tuple.hashCode(this);
    }

    @Override public String toString() {
        return Tuple.toString(this);
    }
}
