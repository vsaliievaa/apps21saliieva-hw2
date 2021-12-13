package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queue;

    public Queue() {
        this.queue= new ImmutableLinkedList();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object dequeued = queue.getFirst();
        this.queue = queue.removeFirst();
        return dequeued;
    }

    public void enqueue(Object e) {
        this.queue = queue.addLast(e);
    }
}
