package org.jmmo.tuple;

public class Tuple0 implements Tuple, Comparable<Tuple0> {
    private static final long serialVersionUID = 8036223661372630498L;

    protected static final Tuple0 INSTANCE = new Tuple0();

    protected Tuple0() {
    }

    public static Tuple0 of() {
        return INSTANCE;
    }

    @Override public int getSize() {
        return 0;
    }

    @Override public <E> E get(int i) {
        throw new IndexOutOfBoundsException("Tuple0 has no elements but " + i + " element requested");
    }

    @Override public int compareTo(Tuple0 o) {
        return 0;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Tuple0;
    }

    @Override public int hashCode() {
        return 1;
    }

    @Override public String toString() {
        return "Tuple0[]";
    }
}
