package org.hmily.cs.beautyofdataalgorithm.problems.array;

public class DynamicArray {

    public Object items[];

    private int size;

    // 构造方法
    public DynamicArray(int capacity) {
        this.items = new Object[capacity];
        this.size = 0;
    }

    //根据索引，找到数据中的元素并返回
    public Object find(int index){
        if (index < 0 && index >= items.length){
            throw new RuntimeException("超出数组下标!");
        }
        return items[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value){
        return Boolean.FALSE;
    }

    // 删除数组中的元素
    public boolean delete(int index){
        return false;
    }




}
