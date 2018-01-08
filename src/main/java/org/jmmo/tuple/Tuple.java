package org.jmmo.tuple;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface Tuple extends Serializable, Iterable<Object> {

    int getSize();

    <E> E get(int i);

    default Object[] toArray() {
        final Object[] result = new Object[getSize()];
        for (int i = 0; i < getSize(); i++) {
            result[i] = get(i);
        }
        return result;
    }

    @Override default Iterator<Object> iterator() {
        return new TupleIterator(this);
    }

    @Override default Spliterator<Object> spliterator() {
        return Spliterators.spliterator(iterator(), getSize(),
                Spliterator.SIZED | Spliterator.IMMUTABLE | Spliterator.ORDERED);
    }

    default Stream<Object> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    class TupleIterator implements Iterator<Object> {
        private final Tuple tuple;
        private int index;

        TupleIterator(Tuple tuple) {this.tuple = tuple;}

        @Override public boolean hasNext() {
            return index < tuple.getSize();
        }

        @Override public Object next() {
            return tuple.get(index++);
        }
    }
}
