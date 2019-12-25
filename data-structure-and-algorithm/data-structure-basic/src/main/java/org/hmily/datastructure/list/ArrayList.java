package org.hmily.datastructure.list;


public class ArrayList implements List{

    private int size = 0;

    private Object[] elementData = new Object[50];

    @Override
    public void add(Object object) {
        if (size == elementData.length){
            // 扩容
            ensureCapacity();
        }
        elementData[size] = object;
        size++;
    }

    @Override
    public void add(int index, Object object) {
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        elementData[index] = object;
        for (int i = size;i>index;i--){
            elementData[i] = elementData[i-1];
        }
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
        for (int i = index;i<size;i++){
            elementData[i]=elementData[i+1];
        }
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
        Object[] newElementData = new Object[elementData.length * 2];
        for (int i=0;i<elementData.length;i++){
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

}
