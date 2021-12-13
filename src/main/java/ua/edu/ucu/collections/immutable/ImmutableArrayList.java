package ua.edu.ucu.collections.immutable;

import java.util.*;

public final class ImmutableArrayList implements ImmutableList {

    private ArrayList<Object> elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = new ArrayList<>();
        for (Object item: elements) {
            if (item != null) {
                this.elements.add(item);
            }
        }
    }

    public ImmutableArrayList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
        newList.elements.add(e);
        return newList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
        newList.elements.add(index, e);

        return newList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
        Collections.addAll(newList.elements, c);

        return newList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
        newList.elements.addAll(index, Arrays.asList(c));

        return newList;
    }

    @Override
    public Object get(int index) {
        return elements.get(index);
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
        newList.elements.remove(index);

        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
          ImmutableArrayList newList = new ImmutableArrayList(elements.toArray());
          newList.elements.set(index, e);

        return newList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (elements.get(i) == e) {
                return i;
            }
        }
        throw new NoSuchElementException("Element not found.");
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public ImmutableList clear() {
        ImmutableArrayList newList = new ImmutableArrayList();
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            array[i] = this.get(i);
        }
        return array;
    }
}
