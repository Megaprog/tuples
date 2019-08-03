package org.jmmo.tuple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Tuple3Test {

    private Tuple3<Integer, Long, Double> tuple = Tuple3.of(1, 2L, 3.0);

    @Test
    void of() {
        assertEquals(1, tuple.getValue0().intValue());
        assertEquals(2L, tuple.getValue1().longValue());
        assertEquals(3.0, tuple.getValue2().doubleValue());
    }

    @Test
    void fromArray_Object() {
        Object[] objectArray = new Object[] {1, 2L, 3.0};
        Tuple3<Integer, Long, Double> tuple = Tuple3.fromArray(objectArray);
        assertEquals(1, tuple.getValue0().intValue());
        assertEquals(2L, tuple.getValue1().longValue());
        assertEquals(3.0, tuple.getValue2().doubleValue());
    }

    @Test
    void fromArray_Number() {
        Number[] numberArray = new Number[] {1, 2L, 3.0};
        Tuple3<Integer, Long, Double> tuple = Tuple3.fromArray(numberArray);
        assertEquals(1, tuple.getValue0().intValue());
        assertEquals(2L, tuple.getValue1().longValue());
        assertEquals(3.0, tuple.getValue2().doubleValue());
    }

    @Test
    void fromIterator_Object() {
        List<Object> objectList = Arrays.asList(1, 2L, 3.0);
        Tuple3<Integer, Long, Double> tuple = Tuple3.fromIterator(objectList.iterator());
        assertEquals(1, tuple.getValue0().intValue());
        assertEquals(2L, tuple.getValue1().longValue());
        assertEquals(3.0, tuple.getValue2().doubleValue());
    }

    @Test
    void fromIterator_Number() {
        List<Number> numberList = Arrays.asList(1, 2L, 3.0);
        Tuple3<Integer, Long, Double> tuple = Tuple3.fromIterator(numberList.iterator());
        assertEquals(1, tuple.getValue0().intValue());
        assertEquals(2L, tuple.getValue1().longValue());
        assertEquals(3.0, tuple.getValue2().doubleValue());
    }

    @Test
    void toObject() {
        assertArrayEquals(new Object[] {1, 2L, 3.0}, tuple.toArray());
    }

    @Test
    void unfold() {
        boolean[] flag = new boolean[]{false};
        tuple.unfold((integer, aLong, aDouble) -> {
            flag[0] = true;
            assertEquals(1, tuple.getValue0().intValue());
            assertEquals(2L, tuple.getValue1().longValue());
            assertEquals(3.0, tuple.getValue2().doubleValue());
        });
        assertTrue(flag[0]);
    }

    @Test
    void unfoldResult() {
        assertEquals("", tuple.unfoldResult((integer, aLong, aDouble) -> {
            assertEquals(1, tuple.getValue0().intValue());
            assertEquals(2L, tuple.getValue1().longValue());
            assertEquals(3.0, tuple.getValue2().doubleValue());
            return "";
        }));
    }

    @Test
    void getSize() {
        assertEquals(3, tuple.getSize());
    }

    @Test
    void get() {
        assertEquals(1, ((Integer) tuple.get(0)).intValue());
        assertEquals(2L, ((Long) tuple.get(1)).longValue());
        assertEquals(3.0, ((Double) tuple.get(2)).doubleValue());
    }

    @Test
    void get_OutOfRange() {
        assertThrows(IndexOutOfBoundsException.class, () -> tuple.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> tuple.get(3));
    }

    @Test
    void iterator() {
        Iterator<Object> iterator = tuple.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, ((Integer) iterator.next()).intValue());
        assertTrue(iterator.hasNext());
        assertEquals(2L, ((Long) iterator.next()).longValue());
        assertTrue(iterator.hasNext());
        assertEquals(3.0, ((Double) iterator.next()).doubleValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    void stream() {
        assertEquals(Arrays.asList(1, 2L, 3.0), tuple.stream().collect(Collectors.toList()));
    }

    @Test
    void forEach() {
        int[] index = new int[]{0};
        tuple.forEach(o -> {
            switch (index[0]) {
                case 0: assertEquals(1, ((Integer) o).intValue()); break;
                case 1: assertEquals(2L, ((Long) o).longValue()); break;
                case 2: assertEquals(3.0, ((Double) o).doubleValue()); break;
                default: fail("forEach() for " + tuple + " was executed more than 3 times");
            }

            index[0]++;
        });
    }

    @Test
    void compareTo_Null() {
        
    }

    @Test
    void compareTo() {
        assertTrue(Tuple3.of(1, 2L, 3.0).compareTo(tuple) == 0);
        assertTrue(Tuple3.of(1, 2L, 3.1).compareTo(tuple) > 0);
        assertTrue(Tuple3.of(1, 2L, 2.9).compareTo(tuple) < 0);
        assertTrue(Tuple3.of(1, 2L, (Double) null).compareTo(tuple) < 0);
        assertTrue(Tuple3.of(1, 2L, (Double) null).compareTo(Tuple3.of(null, null, null)) > 0);
    }

    @Test
    void equals() {
        Tuple3<Integer, Long, Double> equal = Tuple3.of(1, 2L, 3.0);
        assertEquals(tuple, equal);
        Tuple3<Integer, Long, Double> notEqual = Tuple3.of(1, 2L, 3.1);
        assertNotEquals(tuple, notEqual);
    }

    @Test
    void deepEquals() {
        assertEquals(Tuple3.of(1, 2L, new int[] {3, 4}), Tuple3.of(1, 2L, new int[] {3, 4}));
        assertNotEquals(Tuple3.of(1, 2L, new int[] {3, 5}), Tuple3.of(1, 2L, new int[] {3, 4}));
    }

    @Test
    void testHashCode() {
        Tuple3<Integer, Long, Double> other = Tuple3.of(1, 2L, 3.0);
        assertEquals(tuple.hashCode(), other.hashCode());
    }

    @Test
    void testDeepHash() {
        assertEquals(Tuple3.of(1, 2L, new int[] {3, 4}).hashCode(), Tuple3.of(1, 2L, new int[] {3, 4}).hashCode());
        assertNotEquals(Tuple3.of(1, 2L, new int[] {3, 5}).hashCode(), Tuple3.of(1, 2L, new int[] {3, 4}).hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Tuple5[1, 2, 3.0, a, true]", Tuples.of(1, 2L, 3.0, "a", true).toString());
    }
}
