package org.hmily.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * 队列
 * @param <E>
 */
public class Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }


    public Queue() {
        first = null;
        last  = null;
        size = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enQueue(E data) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<E>();
        newNode.item =data;
        last = newNode;
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        size ++;
    }


    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<E> firstNode = first;
        first = firstNode.next;
        size --;
        if (isEmpty()) {
            last = null;
        }
        return firstNode.item;
    }

}
