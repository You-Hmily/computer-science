package org.hmily.datastructure.list;


/**
 * 链表
 */
public class LinkedList implements List{

    /**
     * 初始节点
     */
    private Node head;

    /**
     * 大小
     */
    private int size;


    @Override
    public void add(Object object) {
        add(size,object);
        return;
    }

    @Override
    public void add(int index, Object object) {
        Node newNode=new Node();
        newNode.data=object;
        if (index == 0){
            head.next = newNode;
        }else {
            Node preNextNode = getNode(index -1);
            Node oldNext = preNextNode.next;
            preNextNode.next = newNode;
            newNode.next=oldNext;
        }
        size++;
    }

    private Node getNode(int index){
        if (index<=0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        int i = 0;
        while (true){
            if (i == index){
                break;
            }
            node = node.next;
            i++;
        }
        return node;
    }


    @Override
    public Object get(int index) {
        Node indexNode = getNode(index);
        return indexNode.data;
    }


    @Override
    public Object remove(int index) {
        Node preNode = getNode(index-1);
        Node indexNode = getNode(index);
        preNode.next = indexNode.next;
        size--;
        return indexNode.data;
    }


    @Override
    public int size() {
        return size;
    }


    /**
     * linked 节点
     */
    private static class Node{
        Object data;
        Node next;
    }

}
