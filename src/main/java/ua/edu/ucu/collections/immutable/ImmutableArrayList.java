package ua.edu.ucu.collections.immutable;

import lombok.ToString;

import java.util.*;

@ToString
public final class ImmutableArrayList implements ImmutableList {

    private Object[] elements;
    private int size = 0;

    public ImmutableArrayList(Object[] elements) {
        this.size = elements.length;
        this.elements = elements;
    }

    public ImmutableArrayList() {
        this.size = 0;
        this.elements = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] toCopy = new Object[this.size + 1];
        System.arraycopy(elements, 0, toCopy, 0, index);
        toCopy[index] = e;
        System.arraycopy(elements, index, toCopy, index + 1, this.size - index);

        return new ImmutableArrayList(toCopy);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] toCopy = new Object[this.size + c.length];
        System.arraycopy(this.elements, 0, toCopy, 0, index);
        System.arraycopy(c, 0, toCopy, index, c.length);
        System.arraycopy(elements, index, toCopy, index + c.length, this.size - index);

        return new ImmutableArrayList(toCopy);
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] toCopy = new Object[this.size-1];

        System.arraycopy(elements, 0, toCopy, 0, index);
        System.arraycopy(elements, index+1, toCopy, index, this.size-index-1);

        return new ImmutableArrayList(toCopy);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] toCopy = new Object[this.size];
        System.arraycopy(elements, 0, toCopy, 0, this.size);
        toCopy[index] = e;

        return new ImmutableArrayList(toCopy);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        throw new NoSuchElementException("Element not found.");
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        ImmutableArrayList newList = new ImmutableArrayList();
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        System.arraycopy(this.elements, 0, array, 0, this.size());
        return array;
    }
}
