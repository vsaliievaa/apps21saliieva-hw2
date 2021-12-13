package ua.edu.ucu.collections.immutable;


import lombok.ToString;

@ToString
public final class ImmutableLinkedList implements ImmutableList {

    private final int size;
    //    private final Object defaultVal = 0;
    private final Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        head = new Node();
        if (elements.length == 0) {
            this.tail = this.head;
        } else {
            this.head.setValue(elements[0]);
            head.setPrevious(null);
        }

        Node curNode = this.head;
        Node nextNode;

        for (int i = 1; i < elements.length; i++) {
            nextNode = new Node();
            nextNode.setValue(elements[i]);
            nextNode.setPrevious(curNode);
            curNode.setNext(nextNode);

            curNode = nextNode;
        }

        curNode.setNext(null);
        this.tail = curNode;
        this.size = elements.length;
    }

    public ImmutableLinkedList() {
        head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newElements = new Object[this.size + 1];
        Object[] oldElements = toArray();
        System.arraycopy(oldElements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(oldElements, index, newElements, index + 1,
                size - index);

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newElements = new Object[this.size + c.length];
        Object[] oldElements = toArray();
        System.arraycopy(oldElements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(oldElements, index, newElements, index + c.length,
                this.size - index);
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Node node = this.head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        Object[] newElements = new Object[size - 1];
        Object[] oldElements = toArray();
        System.arraycopy(oldElements, 0, newElements, 0, index);
        System.arraycopy(oldElements, index + 1, newElements, index,
                size - index - 1);
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Object[] newElements = toArray();
        newElements[index] = e;

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        Node node = head;
        for (int i = 0; i < this.size; i++) {
            if (node.getValue() == e) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Node node = this.head;
        Object[] elementsToArray = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            elementsToArray[i] = node.getValue();
            node = node.getNext();
        }
        return elementsToArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] newElements = new Object[size + 1];
        Node node = head;

        for (int i = 1; i < this.size + 1; i++) {
            newElements[i] = node.getValue();
            node = node.getNext();
        }

        newElements[0] = e;

        return new ImmutableLinkedList(newElements);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] newElements = new Object[size + 1];
        Object[] oldElements = toArray();

        System.arraycopy(oldElements, 0, newElements, 0, size);
        newElements[size] = e;

        return new ImmutableLinkedList(newElements);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] newElements = new Object[size - 1];
        Object[] oldElements = toArray();

        System.arraycopy(oldElements, 1, newElements, 0, size-1);

        return new ImmutableLinkedList(newElements);
//        Node node = head.getNext();
//
//        for (int i = 0; i < this.size-1; i++) {
//            newElements[i] = node.getValue();
//            node = node.getNext();
//        }
//
//        return new ImmutableLinkedList(newElements);
    }


    public ImmutableLinkedList removeLast() {
        Object[] newElements = new Object[size - 1];
        Object[] oldElements = toArray();

        System.arraycopy(oldElements, 0, newElements, 0, size - 1);

        return new ImmutableLinkedList(newElements);
    }
}
