package org.jmmo.tuple;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Tuple1<T0> implements Tuple, Comparable<Tuple1<T0>> {
    private static final long serialVersionUID = -8854900772811744378L;

    private final T0 value0;

    protected Tuple1(T0 value0) {this.value0 = value0;}

    public <V> Tuple1<V> of(V value0) {
        return new Tuple1<>(value0);
    }

    @SuppressWarnings("unchecked")
    public <A, V extends A> Tuple1<V> fromArray(A[] values) {
        return new Tuple1<>((V) values[0]);
    }

    public <V> Tuple1<V> fromIterator(Iterator<V> iterator) {
        return new Tuple1<>(iterator.next());
    }

    public void unfold(Consumer<T0> valueConsumer) {
        valueConsumer.accept(getValue0());
    }

    public <R> R unfoldResult(Function<T0, R> valueFunction) {
        return valueFunction.apply(getValue0());
    }

    public T0 getValue0() {
        return value0;
    }

    @Override public int getSize() {
        return 1;
    }

    @SuppressWarnings("unchecked")
    @Override public <E> E get(int i) {
        switch (i) {
            case 0: return (E) getValue0();
        }

        throw new IndexOutOfBoundsException("Tuple1 has one element but " + i + " element requested");
    }

    @Override public Object[] toArray() {
        return new Object[] { getValue0() };
    }

    private static final Comparator<Comparable<Object>> comparator = Comparator.nullsFirst(Comparator.naturalOrder());

    @SuppressWarnings("unchecked")
    @Override public int compareTo(Tuple1<T0> o) {
        return comparator.compare((Comparable) this.getValue0(), (Comparable) o.getValue0());
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple1)) return false;
        Tuple1<?> tuple1 = (Tuple1<?>) o;
        return Objects.equals(getValue0(), tuple1.getValue0());
    }

    @Override public int hashCode() {
        return Objects.hash(getValue0());
    }

    @Override public String toString() {
        return "Tuple1{" +
                "value0=" + getValue0() +
                '}';
    }
}
