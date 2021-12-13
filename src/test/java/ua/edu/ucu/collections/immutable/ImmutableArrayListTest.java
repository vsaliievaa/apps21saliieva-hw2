package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ImmutableArrayListTest extends TestCase {

    public void testImmutableArrayList() {
        Object[] elements = {'s', 0, 'm', 'e', "elements"};
        ImmutableList arrayList = new ImmutableArrayList(elements);

        assertNotNull(arrayList);
        assertEquals(5, arrayList.size());
        assertEquals("[s, 0, m, e, elements]", Arrays.toString(arrayList.toArray()));
    }

    public void testImmutableArrayListWithNoElements() {
        ImmutableList arrayList = new ImmutableArrayList();

        assertNotNull(arrayList);
        assertEquals(0, arrayList.size());
        assertEquals("[]", Arrays.toString(arrayList.toArray()));
    }

    public void testAdd() {
        ImmutableList arrayList = new ImmutableArrayList();
        ImmutableList newArrayList = arrayList.add("a");
        assertEquals(0, arrayList.size());
        assertEquals(1, newArrayList.size());
    }

    public void testAddWithIndex() {
        Object[] elements = {"test", "add", "method"};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        Object toAdd = "success";
        int toAddIdx = 3;

        ImmutableList newArrayList = arrayList.add(toAddIdx, toAdd);

        Object[] elementsToArray = arrayList.toArray();
        Object[] newElementsToArray = newArrayList.toArray();
        assertEquals("[test, add, method]", Arrays.toString(elementsToArray));
        assertEquals("[test, add, method, success]", Arrays.toString(newElementsToArray));
    }

    public void testAddAll() {
        ImmutableList arrayList = new ImmutableArrayList();
        Object[] toAdd = {"elements", "to", "add"};

        ImmutableList newArrayList = arrayList.addAll(toAdd);

        Object[] elementsToArray = arrayList.toArray();
        assertEquals("[]", Arrays.toString(elementsToArray));

        Object[] newElementsToArray = newArrayList.toArray();
        assertEquals("[elements, to, add]", Arrays.toString(newElementsToArray));
    }

    public void testAddAllWithIndex() {
        Object[] elements = {"1", 2, "3", "7", 8, "9", 10};
        Object[] toAdd = {4, "5", 6};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        ImmutableList newArrayList = arrayList.addAll(3, toAdd);

        Object[] elementsToArray = arrayList.toArray();
        Object[] newElementsToArray = newArrayList.toArray();

        assertEquals("[1, 2, 3, 7, 8, 9, 10]", Arrays.toString(elementsToArray));
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",
                Arrays.toString(newElementsToArray));
        assertEquals(7, arrayList.size());
        assertEquals(10, newArrayList.size());
    }

    public void testGet() {
        Object[] elements = {1, true, 3, false};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        assertEquals(3, arrayList.get(2));

        assertEquals(false, arrayList.get(3));
    }

    public void testRemove() {
        Object[] elements = {"hello", "world", "!"};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        ImmutableList newArrayList = arrayList.remove(1);

        Object[] elementsToArray = arrayList.toArray();
        Object[] newElementsToArray = newArrayList.toArray();

        assertEquals("[hello, world, !]", Arrays.toString(elementsToArray));
        assertEquals("[hello, !]", Arrays.toString(newElementsToArray));
        assertEquals(2, newArrayList.size());
    }

    public void testSet() {
        Object[] elements = {1, 1, 1, 1};
        ImmutableList arrayList = new ImmutableArrayList(elements);

        ImmutableList newArrayList = arrayList.set(1, "one");
        Object[] elementsToArray = arrayList.toArray();
        assertEquals("[1, 1, 1, 1]", Arrays.toString(elementsToArray));

        Object[] newElementsToArray = newArrayList.toArray();
        assertEquals("[1, one, 1, 1]", Arrays.toString(newElementsToArray));
    }

    public void testIndexOf() {
        Object[] elements = {"1", "-1", 2, -2};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        Object first = "1";
        Object second = -2;
        int firstFoundIdx = arrayList.indexOf(first);
        int secondFoundIdx = arrayList.indexOf(second);

        assertEquals(0, firstFoundIdx);
        assertEquals(3, secondFoundIdx);
    }

    public void testIndexOfWithWrongElement() {
        ImmutableList arrayList = new ImmutableArrayList();
        Object toFind = "object";

        try {
            arrayList.indexOf(toFind);
            fail("Exception not caught.");
        } catch(NoSuchElementException exc) {
            assertEquals("Element not found.", exc.getMessage());
        }
    }

    public void testSize() {
        Object[] elements = {918, 1024, "918", "1024"};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        assertEquals(4, arrayList.size());

        ImmutableList emptyArrayList = new ImmutableArrayList();
        assertEquals(0, emptyArrayList.size());
    }

    public void testClear() {
        Object[] elements = {"string", true, 254.44};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        ImmutableList newArrayList = arrayList.clear();

        assertTrue(newArrayList.isEmpty());
        assertFalse(arrayList.isEmpty());
    }

    public void testIsEmpty() {
        ImmutableList arrayList = new ImmutableArrayList();
        assertTrue(arrayList.isEmpty());
    }

    public void testToArray() {
        Object[] elements = {918, 1024, "918", "1024"};
        ImmutableList arrayList = new ImmutableArrayList(elements);
        Object[] elementsToArray = arrayList.toArray();
        assertEquals("[918, 1024, 918, 1024]", Arrays.toString(elementsToArray));

        ImmutableList emptyArrayList = new ImmutableArrayList();
        Object[] emptyElementsToArray = emptyArrayList.toArray();
        assertEquals("[]", Arrays.toString(emptyElementsToArray));

    }
}