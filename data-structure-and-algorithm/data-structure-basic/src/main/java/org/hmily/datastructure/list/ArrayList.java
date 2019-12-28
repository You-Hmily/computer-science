package org.hmily.datastructure.list;


public class ArrayList implements List{

    private int size = 0;

    private Object[] elementData = new Object[50];


    @Override
    public void add(Object object) {
        add(size,object);
    }

    @Override
    public void add(int index, Object object) {
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == elementData.length){
            // 扩容
            ensureCapacity();
        }
        for (int i = size;i>index;i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = object;
        size++;
    }

    @Override
    public Object get(int index) {
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    @Override
    public Object remove(int index) {
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object old = elementData[index];
        for (int i = index;i<size-1;i++){
            elementData[i]=elementData[i+1];
        }
        size--;
        return old;
    }

    @Override
    public int size() {
        return size;
    }


    /**
     * 扩容方法
     */
    private void ensureCapacity(){
        Object[] newElementData = new Object[elementData.length * 2 + 1];
        for (int i = 0;i < elementData.length;i++){
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

}
