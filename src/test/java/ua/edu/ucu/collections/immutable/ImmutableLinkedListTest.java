package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableLinkedListTest extends TestCase {

    public void testAdd() {
        ImmutableList linkedList = new ImmutableLinkedList();
        ImmutableList newLinkedList = linkedList.add("node");

        assertEquals("[node]", Arrays.toString(newLinkedList.toArray()));

        ImmutableList anotherLinkedList = newLinkedList.add("node2");
        assertEquals("[node, node2]", Arrays.toString(anotherLinkedList.toArray()));
    }

    public void testAddWithIndex() {
        Object[] elements = {"1", 2, "3", 'a', 518, true};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);
        Object elementToAdd = "false";
        int idxToAdd = 4;

        ImmutableList newLinkedList = linkedList.add(idxToAdd, elementToAdd);
        assertEquals("[1, 2, 3, a, false, 518, true]", Arrays.toString(newLinkedList.toArray()));
    }

    public void testAddAll() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Object[] toAdd = {"node4", "node5"};

        ImmutableList newLinkedList = linkedList.addAll(toAdd);

        assertEquals("[node1, node2, node3, node4, node5]",
                Arrays.toString(newLinkedList.toArray()));

        assertEquals("[node1, node2, node3]",
                Arrays.toString(linkedList.toArray()));
    }

    public void testAddAllWithIndex() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);
        Object[] toAdd = {"node-2", "node-1", "node0"};

        ImmutableList newLinkedList = linkedList.addAll(0, toAdd);

        assertEquals("[node1, node2, node3]", Arrays.toString(linkedList.toArray()));

        assertEquals("[node-2, node-1, node0, node1, node2, node3]",
                Arrays.toString(newLinkedList.toArray()));
    }

    public void testGet() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Object getObject = linkedList.get(2);

        assertEquals("node3", getObject);
    }

    public void testGetIndexOutOfBounds() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        try {
            Object getObject = linkedList.get(4);
            fail("Exception not caught.");
        } catch (IndexOutOfBoundsException exc) {
            assertEquals("Index out of range.", exc.getMessage());
        }
    }

    public void testRemove() {
        Object[] elements = {true, false, false, 1, false, true};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        ImmutableList newLinkedList = linkedList.remove(3);

        assertEquals("[true, false, false, false, true]",
                Arrays.toString(newLinkedList.toArray()));
    }

    public void testSet() {
        Object[] elements = {true, false, false, "true", false, true};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        ImmutableList newLinkedList = linkedList.set(0, "false");

        assertEquals("[false, false, false, true, false, true]",
                Arrays.toString(newLinkedList.toArray()));
    }

    public void testIndexOf() {
        Object[] elements = {true, false, false, "true", false, true};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        int expIdx = 3;
        int actualIdx = linkedList.indexOf("true");

        assertEquals(expIdx, actualIdx);
    }

    public void testSize() {
        Object[] elements = {true, false, false};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        int expSize = 3;
        int actualSize = linkedList.size();

        assertEquals(expSize, actualSize);

    }

    public void testClear() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        ImmutableList newLinkedList = linkedList.clear();

        assertEquals(3, linkedList.size());
        assertEquals(0, newLinkedList.size());
        assertTrue(newLinkedList.isEmpty());
    }

    public void testIsEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        assertTrue(linkedList.isEmpty());

        ImmutableList newLinkedList = linkedList.add("text");
        assertFalse(newLinkedList.isEmpty());
    }

    public void testToArray() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);
        Object[] toArray = linkedList.toArray();
        assertEquals("[node1, node2, node3]", Arrays.toString(toArray));
    }

    public void testAddFirst() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);
        Object toAdd = "node0";

        ImmutableList newLinkedList = linkedList.addFirst(toAdd);

        assertEquals("ImmutableLinkedList(size=4, head=node0, tail=node3)", newLinkedList.toString());
    }

    public void testAddLast() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);
        Object toAdd = "node4";

        ImmutableList newLinkedList = linkedList.addLast(toAdd);

        assertEquals("ImmutableLinkedList(size=4, head=node1, tail=node4)", newLinkedList.toString());
    }

    public void testGetHead() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Node head = linkedList.getHead();
        assertEquals("node1", head.getValue());
    }

    public void testGetTail() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Node tail = linkedList.getTail();
        assertEquals("node3", tail.getValue());
    }

    public void testGetFirst() {
        Object[] elements = {1, "node2", 3};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Object first = linkedList.getFirst();

        assertEquals(1, first);
    }

    public void testGetLast() {
        Object[] elements = {1, "node2", 3};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        Object last = linkedList.getLast();

        assertEquals(3, last);
    }

    public void testRemoveFirst() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        ImmutableList newLinkedList = linkedList.removeFirst();
        assertEquals(2, newLinkedList.size());
        assertEquals("ImmutableLinkedList(size=2, head=node2, tail=node3)",
                newLinkedList.toString());
    }

    public void testRemoveLast() {
        Object[] elements = {"node1", "node2", "node3"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(elements);

        ImmutableList newLinkedList = linkedList.removeLast();
        assertEquals(2, newLinkedList.size());
        assertEquals("ImmutableLinkedList(size=2, head=node1, tail=node2)",
                newLinkedList.toString());
    }

    public void testTestToString() {
    }
}