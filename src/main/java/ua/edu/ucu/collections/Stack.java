package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stack;

    public Stack() {
        this.stack = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.stack = stack.addFirst(e);
    }

    public Object pop() {
        Object popped = stack.getFirst();
        this.stack = stack.removeFirst();
        return popped;
    }

    public Object peek() {
        return stack.getFirst();
    }
}
