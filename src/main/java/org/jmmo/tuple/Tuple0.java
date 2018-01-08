package org.jmmo.tuple;

import java.util.Objects;

public class Tuple0 implements Tuple<Void>, Comparable<Tuple0> {
    private static final long serialVersionUID = -5035901162805121584L;

    private static final Tuple0 INSTANCE = new Tuple0();

    protected Tuple0() {
    }

    public Tuple0 instance() {
        return INSTANCE;
    }

    @Override public int getSize() {
        return 0;
    }

    @Override public <E extends Void> E get(int i) {
        throw new IndexOutOfBoundsException("Tuple0 has no elements but " + i + " element requested");
    }

    @Override public int compareTo(Tuple0 o) {
        return 0;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple0)) return false;
        Tuple0 other = (Tuple0) o;
        return other.getSize() == 0;
    }

    @Override public int hashCode() {
        return 1;
    }

    @Override public String toString() {
        return "Tuple0{}";
    }
}
