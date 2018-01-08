package org.jmmo.tuple;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface Tuple<T> extends Serializable, Iterable<T>, Comparable<Tuple> {

    int getSize();

    <E extends T> E get(int i);

    default Object[] toArray() {
        final Object[] result = new Object[getSize()];
        for (int i = 0; i < getSize(); i++) {
            result[i] = get(i);
        }
        return result;
    }

    @Override default Iterator<T> iterator() {
        return new TupleIterator<>(this);
    }

    @Override default Spliterator<T> spliterator() {
        return Spliterators.spliterator(iterator(), getSize(),
                Spliterator.SIZED | Spliterator.IMMUTABLE | Spliterator.ORDERED);
    }

    default Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    class TupleIterator<T> implements Iterator<T> {
        private final Tuple<T> tuple;
        private int index;

        TupleIterator(Tuple<T> tuple) {this.tuple = tuple;}

        @Override public boolean hasNext() {
            return index < tuple.getSize();
        }

        @Override public T next() {
            return tuple.get(index++);
        }
    }
}
