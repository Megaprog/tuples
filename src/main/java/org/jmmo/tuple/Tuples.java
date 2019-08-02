package org.jmmo.tuple;

import java.util.Iterator;

public class Tuples {
    private Tuples() {}

    public static Tuple0 of() {
        return Tuple0.INSTANCE;
    }

    public static <V0> Tuple1<V0> of(V0 v0) {
        return new Tuple1<>(v0);
    }

    public static <V0, V1> Tuple2<V0, V1> of(V0 v0, V1 v1) {
        return new Tuple2<>(v0, v1);
    }

    public static <V0, V1, V2> Tuple3<V0, V1, V2> of(V0 v0, V1 v1, V2 v2) {
        return new Tuple3<>(v0, v1, v2);
    }

    public static <V0, V1, V2, V3> Tuple4<V0, V1, V2, V3> of(V0 v0, V1 v1, V2 v2, V3 v3) {
        return new Tuple4<>(v0, v1, v2, v3);
    }

    public static <V0, V1, V2, V3, V4> Tuple5<V0, V1, V2, V3, V4> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4) {
        return new Tuple5<>(v0, v1, v2, v3, v4);
    }

    public static <V0, V1, V2, V3, V4, V5> Tuple6<V0, V1, V2, V3, V4, V5> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5) {
        return new Tuple6<>(v0, v1, v2, v3, v4, v5);
    }

    public static <V0, V1, V2, V3, V4, V5, V6> Tuple7<V0, V1, V2, V3, V4, V5, V6> of(V0 v0, V1 v1, V2 v2, V3 v3, V4 v4,
                                                                                     V5 v5, V6 v6) {
        return new Tuple7<>(v0, v1, v2, v3, v4, v5, v6);
    }

    public static <V0, V1, V2, V3, V4, V5, V6, V7> Tuple8<V0, V1, V2, V3, V4, V5, V6, V7> of(
            V0 v0, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5, V6 v6, V7 v7) {
        return new Tuple8<>(v0, v1, v2, v3, v4, v5, v6, v7);
    }

    public static <V0, V1, V2, V3, V4, V5, V6, V7, V8> Tuple9<V0, V1, V2, V3, V4, V5, V6, V7, V8> of(
            V0 v0, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5, V6 v6, V7 v7, V8 v8) {
        return new Tuple9<>(v0, v1, v2, v3, v4, v5, v6, v7, v8);
    }

    public static <A> Tuple fromArray(A[] values)  {
        switch (values.length) {
            case 0:
                return of();
            case 1:
                return Tuple1.fromArray(values);
            case 2:
                return Tuple2.fromArray(values);
            case 3:
                return Tuple3.fromArray(values);
            case 4:
                return Tuple4.fromArray(values);
            case 5:
                return Tuple5.fromArray(values);
            case 6:
                return Tuple6.fromArray(values);
            case 7:
                return Tuple7.fromArray(values);
            case 8:
                return Tuple8.fromArray(values);
            case 9:
                return Tuple9.fromArray(values);
            default:
                throw new IllegalArgumentException("Too many values only 9 is allowed");
        }
    }

    public static <V> Tuple fromIterator(Iterator<V> iterator) {
        if (iterator.hasNext()) {
            V value1 = iterator.next();
            if (iterator.hasNext()) {
                V value2 = iterator.next();
                if (iterator.hasNext()) {
                    V value3 = iterator.next();
                    if (iterator.hasNext()) {
                        V value4 = iterator.next();
                        if (iterator.hasNext()) {
                            V value5 = iterator.next();
                            if (iterator.hasNext()) {
                                V value6 = iterator.next();
                                if (iterator.hasNext()) {
                                    V value7 = iterator.next();
                                    if (iterator.hasNext()) {
                                        V value8 = iterator.next();
                                        if (iterator.hasNext()) {
                                            V value9 = iterator.next();
                                            if (iterator.hasNext()) {
                                                throw new IllegalArgumentException("Too many values only 9 is allowed");
                                            } else {
                                                return of(value1, value2, value3, value4, value5, value6, value7, value8, value9);
                                            }
                                        } else {
                                            return of(value1, value2, value3, value4, value5, value6, value7, value8);
                                        }
                                    } else {
                                        return of(value1, value2, value3, value4, value5, value6, value7);
                                    }
                                } else {
                                    return of(value1, value2, value3, value4, value5, value6);
                                }
                            } else {
                                return of(value1, value2, value3, value4, value5);
                            }
                        } else {
                            return of(value1, value2, value3, value4);
                        }
                    } else {
                        return of(value1, value2, value3);
                    }
                } else {
                    return of(value1, value2);
                }
            } else {
                return of(value1);
            }
        } else {
            return of();
        }
    }
}
