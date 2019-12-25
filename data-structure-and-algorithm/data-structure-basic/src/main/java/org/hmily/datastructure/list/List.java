package org.hmily.datastructure.list;


/**
 * 链表抽象接口
 */
public interface List {

    /**
     * 插入数据
     * @param object
     */
    void add(Object object);

    /**
     * 某一位位置插入
     * @param index
     * @param object
     */
    void add(int index, Object object);

    /**
     * 获取某一数据
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * 移除某一元素
     * @param index
     * @return
     */
    Object remove(int index);

    /**
     * list大小
     * @return
     */
    int size();

}
