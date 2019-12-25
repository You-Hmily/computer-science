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
        Node newNode=new Node();
        newNode.data=object;
       if (head == null){
           head = new Node();
           head.next = newNode;
           size++;
           return;
       }
       Node nextNode = head.next;
       for (int i = 1;i<=size;i++){
           if (nextNode.next ==null){
               nextNode.next = newNode;
           }
           nextNode=nextNode.next;
       }
       size ++;
       return;
    }

    @Override
    public void add(int index, Object object) {
        if (index<=0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node newNode=new Node();
        newNode.data=object;
        Node nextNode = head.next;
        Node preNextNode = null;
        int i = 1;
        while (true){
            nextNode = nextNode.next;
            if (i==index-1){
                preNextNode=nextNode;
            }
            if (i==index){
                break;
            }
            i++;
        }
        preNextNode.next=newNode;
        newNode.next=nextNode;
        size++;
    }

    @Override
    public Object get(int index) {
        if (index<=0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node nextNode = head.next;
        int i = 1;
        while (true){
            nextNode = nextNode.next;
            if (i==index){
                break;
            }
            i++;
        }
        return nextNode.data;
    }


    @Override
    public Object remove(int index) {
        if (index<=0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node nextNode = head.next;
        int i = 1;
        Node preNextNode = null;
        while (true){
            nextNode = nextNode.next;
            if (i==index-1){
                preNextNode = nextNode;
            }
            if (i==index){
                break;
            }
            i++;
        }
        preNextNode.next = nextNode.next;
        return nextNode.data;
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
